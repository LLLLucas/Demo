package com.lucas.datetime;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.lucas.pojo.Datetime;
/*
 * 创建日期的
 */

public class DateCreate {
		public  List<Datetime> dateCre(){
			Calendar c = Calendar.getInstance();//获得一个日历的实例
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = null;
			Date date2=new Date();
			System.out.println(sdf.format(date2));
			try{
			date = sdf.parse("2018-12-23");//初始日期
			}catch(Exception e){
		
			}
			List<Datetime> datetimeList=new ArrayList<Datetime>();
			for(int i=0;i<180;i++) {
				c.setTime(date);//设置日历时间
				c.add(Calendar.DAY_OF_MONTH,1);
				System.out.println(sdf.format(c.getTime()));
				date=c.getTime();
				Datetime datetime=new Datetime();
				datetime.setDatetime(sdf.format(c.getTime()));
				datetimeList.add(datetime);
			}
			
		
			return datetimeList;
		}
}
