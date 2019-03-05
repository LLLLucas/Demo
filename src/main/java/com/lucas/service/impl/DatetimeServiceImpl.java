package com.lucas.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.mapper.DatetimeMapper;
import com.lucas.pojo.Datetime;
import com.lucas.pojo.DatetimeExample;
import com.lucas.service.DatetimeService;
@Service
public class DatetimeServiceImpl implements DatetimeService{
	@Autowired
	DatetimeMapper datetimeMapper;
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		datetimeMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void insert(Datetime datetime) {
		// TODO Auto-generated method stub
		datetimeMapper.insert(datetime);
	}

	@Override
	public void insert(List<Datetime> list) {
		// TODO Auto-generated method stub
		for (Datetime datetime : list) {
			datetimeMapper.insert(datetime);
		}
	}

	@Override
	public List<Datetime> list() {
		// TODO Auto-generated method stub
		DatetimeExample datetimeExample=new DatetimeExample();
		datetimeExample.setOrderByClause("id asc");
		List<Datetime> datetimeList=datetimeMapper.selectByExample(datetimeExample);
		try {
			setWeekid(datetimeList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return datetimeList;
	}

	@Override
	public Datetime get(int id) {
		// TODO Auto-generated method stub
		return datetimeMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Datetime> listByWeek(Datetime datetime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Datetime getByDate(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Datetime selectById(int id) {
		// TODO Auto-generated method stub
		return datetimeMapper.selectByPrimaryKey(id);
	}
	
	public void setWeekid(List<Datetime> datetimeList)throws Exception {
		
		for (Datetime datetime : datetimeList) {
			setWeekid(datetime);
			
		}
	}
	public Datetime setWeekid(Datetime datetime)throws Exception{
		int week=getWeek(datetime.getDatetime());
		datetime.setWeekid(week);
		return datetime;
	}
	public  int getWeek(String str) throws Exception{
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
