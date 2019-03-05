package com.lucas.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 * 获取日期的第几周
 * @author Administrator
 *
 */


public class DatetimeWeek {
	public static  int getWeek(String str) throws Exception{
		 SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		 Date date =sdf.parse(str);
		 Calendar calendar = Calendar.getInstance();
		 calendar.setTime(date);
		 //第几周
	     int week = calendar.get(Calendar.WEEK_OF_YEAR);
	     //第几天，从周日开始
	     //int day = calendar.get(Calendar.DAY_OF_WEEK);
	     return week;
	 }

}
