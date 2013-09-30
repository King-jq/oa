package com.jmsj.util;

import java.lang.reflect.Field;
import java.util.Date;

public class ClassReflect {
	
	public static void setValue(Object obj, StringBuffer sql1, StringBuffer sql2, String tableName) throws Exception {
		Class<?> clzz = obj.getClass();
		Field[] fields = clzz.getDeclaredFields();
		sql1.append(" insert into ").append(tableName).append("(");
		sql2.append(") values (");
		for(Field f : fields){
			f.setAccessible(true);
			String valueType = f.getType().toString();
			String trueType = null;
			Object value = f.get(obj);
			String fName = f.getName().toLowerCase();
			sql1.append(fName).append(",");
			if(valueType.indexOf("class") != -1){
				trueType = valueType.substring(6).trim();
				trueType = trueType.substring(trueType.lastIndexOf(".") + 1);
				if("String".equals(trueType)){
					if(value == null){
						sql2.append("'',");
					}else{
						sql2.append("'").append(value.toString()).append("',");
					}
				}else if("Date".equals(trueType)){
					if(value == null){
						sql2.append("'',");
					}else{
						sql2.append("'").append(DateUtil.dateToString((Date)value)).append("',");
					}
				}else if("Integer".equals(trueType)){
					if(value == null){
						sql2.append("'',");
					}else{
						sql2.append(value.toString()).append(",");
					}
				}
			}else{
				if("int".equals(valueType)){
					sql2.append(value.toString()).append(",");
				}else if("double".equals(valueType)){
					sql2.append(value.toString()).append(",");
				}
			}
		}
		
	}
	
	public static void setValue(Object obj, Object[] objs) throws Exception {
		Class<?> clzz = obj.getClass();
		Field[] fields = clzz.getDeclaredFields();
		for(Field f : fields){
			String name = f.getName();
			if(name.indexOf("get") != -1){
				name = "set" + name.substring(3);
			}
		}
	}
	
}
