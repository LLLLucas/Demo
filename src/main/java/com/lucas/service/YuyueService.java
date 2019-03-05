package com.lucas.service;

import java.util.List;

import com.lucas.pojo.Yuyue;

public interface YuyueService {
	void delete(int id);
	void insert(Yuyue yuyue);
	List<Yuyue> list();
	Yuyue get(int id);
	Yuyue get(int timeid,int dateid,int roomid);
	void update(Yuyue yuyue);
	List<Yuyue> list(int roomid);
	List<Yuyue> listByUserid(int userid);
	List<Yuyue> listByZhuangtai(String st);
	
}
