package com.jmsj.db;

import java.io.File;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.SqlSessionUtils;
import org.springframework.context.ApplicationContext;

import com.jmsj.sys.annotation.Column;
import com.jmsj.sys.annotation.Entity;
import com.jmsj.sys.annotation.Id;
import com.jmsj.util.XmlPaser;

public class DBInit{
	
	private static Connection conn;
    private static Map<String, String> maps;
    private static String TABLE_EXIT = "select count(*) from INFORMATION_SCHEMA.TABLES where TABLE_SCHEMA='oa' and TABLE_NAME='";
	private static PreparedStatement st;
	private static ResultSet rs;
    static {
		maps = new HashMap<String, String>();
		maps.put("int", "int");
		maps.put("class java.lang.Integer", "integer");
		maps.put("class java.lang.String", "varchar");
		maps.put("class java.util.Date", "datetime");
	}
	
	public static void init(ApplicationContext context){
		String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		List<String> packs = XmlPaser.parserPackages(path+"Maps.xml");
		SqlSessionTemplate session = (SqlSessionTemplate) context.getBean("sqlSession");
		conn = SqlSessionUtils.getSqlSession(session.getSqlSessionFactory(),session.getExecutorType(),session.getPersistenceExceptionTranslator()).getConnection();
		if(packs != null && !packs.isEmpty()){
			for(String pack : packs){
				File file = new File(path+pack);
				if(file.isDirectory()){
					File[] files = file.listFiles();
					if(files != null && files.length > 0){
						for(File f : files){
							if(!f.isDirectory()){
								initTable(f, pack);
							}
						}
					}
				}
			}
		}
	}
	
	private static void initTable(File file, String pack){
		pack = pack.replace("/", ".");
		pack = pack+"."+file.getName().substring(0, file.getName().lastIndexOf("."));
		try {
			Class<?> c = Class.forName(pack);
			Field[] fields = c.getDeclaredFields();
			if(c.isAnnotationPresent(Entity.class)){
				Entity e = c.getAnnotation(Entity.class);
				String tableName = TABLE_EXIT + e.name()+"'";
				st = conn.prepareStatement(tableName);
				rs = st.executeQuery();
				int isH = 0;
				while(rs.next()){
					isH = rs.getInt(1);
				}
				if(isH == 1){
					
				}else{
					if(fields != null && fields.length > 0){
						String create_sql = "create table "+e.name()+" (";
						for(Field f : fields){
							Class<?> type = f.getType();
							if(f.isAnnotationPresent(Id.class)){
								Id id = f.getAnnotation(Id.class);
								String idName = id.name();
								int len = id.length();
								create_sql = create_sql + idName+" "+ maps.get(type.toString()) + "("+ len+") not null PRIMARY KEY,";
							}else if(f.isAnnotationPresent(Column.class)){
								Column col = f.getAnnotation(Column.class);
								String colName = col.name();
								int len = col.length();
								create_sql = create_sql + colName +" "+ maps.get(type.toString()) + "("+ len+"),";
							}
						}
						create_sql = create_sql.substring(0, create_sql.length()-1)+")";
						st = conn.prepareStatement(create_sql);
						st.executeUpdate();
					}
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	}
}
