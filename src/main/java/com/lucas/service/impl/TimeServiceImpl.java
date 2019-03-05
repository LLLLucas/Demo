package com.lucas.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.mapper.TimeMapper;
import com.lucas.pojo.Time;
import com.lucas.pojo.TimeExample;
import com.lucas.service.TimeService;
@Service
public class TimeServiceImpl implements TimeService{
	@Autowired
	TimeMapper timeMapper;
	
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		timeMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<Time> list() {
		// TODO Auto-generated method stub
		TimeExample timeExample=new TimeExample();
		timeExample.setOrderByClause("id asc");
		
		
		return timeMapper.selectByExample(timeExample);
	}

	@Override
	public void insert(Time time) {
		// TODO Auto-generated method stub
		timeMapper.insert(time);
		
	}

	@Override
	public Time get(int id) {
		// TODO Auto-generated method stub
		return timeMapper.selectByPrimaryKey(id);
				
	}

	@Override
	public Time selectById(int id) {
		// TODO Auto-generated method stub
		return timeMapper.selectByPrimaryKey(id);
	}

}
