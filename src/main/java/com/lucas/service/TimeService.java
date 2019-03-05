package com.lucas.service;

import java.util.List;

import com.lucas.pojo.Time;

public interface TimeService {
	void delete(int id);
	List<Time> list();
	void insert(Time time);
	Time get(int id);
	Time selectById(int id);
	

}
