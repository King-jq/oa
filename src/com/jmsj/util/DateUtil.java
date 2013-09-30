package com.jmsj.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	public static long DAY_TIME = 24 * 60 * 60 * 1000;
	
	public static Date stringToDate(String str) throws Exception{
		return new SimpleDateFormat().parse(str);
	}
	
	public static String stringToString(String str) throws Exception {
		Date date = stringToDate(str);
		if(date != null){
			DateFormat parm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return parm.format(date);
		}
		return null;
	}
	
	public static String dateToString(Date date){
		DateFormat parm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return parm.format(date);
	}
	
	public static Date strToDate(String date) throws Exception{
		DateFormat parm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return parm.parse(date);
	}
	
	public static int dateToDay(Date before, Date after){
		int day = (int) ((after.getTime() - before.getTime())/DAY_TIME);
		/*int last = (int) ((after.getTime() - before.getTime())%DAY_TIME);
		if(last > 0){
			day = day + 1;
		}*/
		return day;
	}
	
}
