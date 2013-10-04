package com.jmsj.db;

import java.io.File;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.SqlSessionUtils;
import org.springframework.context.ApplicationContext;

import com.jmsj.sys.annotation.Column;
import com.jmsj.sys.annotation.Entity;
import com.jmsj.sys.annotation.Id;
import com.jmsj.sys.annotation.Table;
import com.jmsj.util.XmlPaser;

public class DBInit {

	private static Connection conn;
	public static Map<String, String> maps;
	private static String DB_NAME = "";
	private static String TABLE_EXIT = "select count(*) from INFORMATION_SCHEMA.TABLES where TABLE_SCHEMA='oa' and TABLE_NAME='";
	private static String TABLE_FIELD = "SELECT column_name from information_schema.columns WHERE table_schema = '";
	private static PreparedStatement st;
	private static Statement sst;
	private static ResultSet rs;

	public static Map<String, String> classMaps = new HashMap<String, String>();
	public static Map<String, String> tableMaps = new HashMap<String, String>();
	public static Map<String, String> sqlMaps = new HashMap<String, String>();

	static {
		maps = new HashMap<String, String>();
		maps.put("int", "int");
		maps.put("class java.lang.Integer", "integer");
		maps.put("class java.lang.String", "varchar");
		maps.put("class java.util.Date", "datetime");
	}

	public static void init(ApplicationContext context) {
		String path = Thread.currentThread().getContextClassLoader()
				.getResource("").getPath();
		List<String> packs = XmlPaser.parserPackages(path + "Maps.xml");
		SqlSessionTemplate session = (SqlSessionTemplate) context
				.getBean("sqlSession");
		conn = SqlSessionUtils.getSqlSession(session.getSqlSessionFactory(),
				session.getExecutorType(),
				session.getPersistenceExceptionTranslator()).getConnection();
		DB_NAME = getDBName(conn);
		
		if (packs != null && !packs.isEmpty()) {
			for (String pack : packs) {
				File file = new File(path + pack);
				if (file.isDirectory()) {
					File[] files = file.listFiles();
					if (files != null && files.length > 0) {
						for (File f : files) {
							if (!f.isDirectory()) {
								initTable(f, pack);
							}
						}
					}
				}
			}
		}
		
		sqlMaps.clear();
		sqlMaps = null;
	}

	private static void initTable(File file, String pack) {
		pack = pack.replace("/", ".");
		pack = pack + "."
				+ file.getName().substring(0, file.getName().lastIndexOf("."));
		try {
			Class<?> c = Class.forName(pack);
			initClass(c, file);
			initMethod(c);
			String tName = classMaps.get(c.getName());
			String tableSql =  TABLE_EXIT + tName +"'";
			st = conn.prepareStatement(tableSql);
			rs = st.executeQuery();
			sst = conn.createStatement();
			int isH = 0;
			while(rs.next()){
				isH = rs.getInt(1);
			}
			
			rs.close();
			st.close();
			
			if(isH == 1){
				String fieldSql = TABLE_FIELD + DB_NAME +"' and table_name = '" + tName + "'";
				st = conn.prepareStatement(fieldSql);
				rs = st.executeQuery();
				boolean isAdd = false;
				while(rs.next()){
					String fName = rs.getString(1);
					String fn = tableMaps.get(tName+"."+fName);
					if(fn == null){
						isAdd = true;
						StringBuffer add = new StringBuffer();
						add.append("alter table ").append(tName).append(" ");
						String fieldStr = sqlMaps.get(tName+"."+fName);
						add.append(fieldStr);
						sst.addBatch(add.toString());
					}
				}
				
				if(isAdd){
					sst.executeBatch();
					sst.close();
					rs.close();
				}
			}else if(isH == 0 && c.isAnnotationPresent(Entity.class)){
				StringBuffer create = new StringBuffer();
				create.append("create table ").append(tName).append("(");
				Iterator<Entry<String, String>> values = sqlMaps.entrySet().iterator();
				boolean isAdd = false;
				while(values.hasNext()){
					String value = values.next().getKey();
					if(value.indexOf(tName) != -1){
						isAdd = true;
						String sql = values.next().getValue();
						create.append(sql).append(",");
					}
				}
				
				if(isAdd){
					String sql = create.substring(0, create.length() - 1);
					sql = sql +")";
					sst = conn.createStatement();
					sst.executeUpdate(sql);
					sst.close();
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}
	
	
	private static void initClass(Class<?> c, File file){
		if (c.isAnnotationPresent(Entity.class)) {
			// 获取实体类对应的表名
			String tableName = "";
			// 获取所有实体类的所有属性
			if (c.isAnnotationPresent(Table.class)) {
				Table table = c.getAnnotation(Table.class);
				tableName = table.value();
			} else {
				tableName = file.getName().substring(0,
						file.getName().lastIndexOf("."));
			}
			classMaps.put(c.getName(), tableName);
		}
	}
	
	private static void initMethod(Class<?> c){
		if (c.isAnnotationPresent(Entity.class)) {
			// 获取所有实体类的所有属性
			Field[] fields = c.getDeclaredFields();
			String tableName = classMaps.get(c.getName());
			boolean isSave = false;
			if(fields != null && fields.length > 0){
				for (Field f : fields) {
					if (f.isAnnotationPresent(Column.class)) {
						isSave = true;
						Column column = f.getAnnotation(Column.class);
						String name = column.name();
						int len = column.length();
						String type = maps.get(f.getType().toString());
						StringBuffer sql = new StringBuffer();
						sql.append(" ").append(name).append(" ").append(type).append("(").append(len).append(")");
						if(f.isAnnotationPresent(Id.class)){
							sql.append(" not null PRIMARY KEY");
						}
						tableMaps.put(tableName+"."+name, tableName);
						sqlMaps.put(tableName+"."+name, sql.toString());
					}
				}
			}
			
			if(!isSave){
				classMaps.remove(c.getName());
			}
		}
	}
	
	private static String getDBName(Connection conn){
		String name = null;
		try {
			name = conn.getCatalog();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return name;
	}
}
