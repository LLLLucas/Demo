package com.lucas.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.mapper.RoomMapper;
import com.lucas.pojo.Room;
import com.lucas.pojo.RoomExample;
import com.lucas.service.RoomService;
@Service
public class RoomServiceImpl implements RoomService{
	@Autowired
	RoomMapper roomMapper;
	
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		roomMapper.deleteByPrimaryKey(id);
		
	}

	@Override
	public void insert(Room room) {
		// TODO Auto-generated method stub
		roomMapper.insert(room);
	}

	@Override
	public void update(Room room) {
		// TODO Auto-generated method stub
		roomMapper.updateByPrimaryKeySelective(room);
		
	}

	@Override
	public List<Room> list() {
		// TODO Auto-generated method stub
		RoomExample roomExample=new RoomExample();
		roomExample.setOrderByClause("id desc");
		return roomMapper.selectByExample(roomExample);
	}

	@Override
	public Room get(int id) {
		// TODO Auto-generated method stub
		return roomMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Room> list(int typeId) {
		// TODO Auto-generated method stub
		RoomExample roomExample=new RoomExample();
		roomExample.setOrderByClause("id desc");
		roomExample.createCriteria().andTypeidEqualTo(typeId);
		return roomMapper.selectByExample(roomExample);
	}

	@Override
	public Room selectById(int id) {
		// TODO Auto-generated method stub
		
		return roomMapper.selectByPrimaryKey(id);
	}

}
