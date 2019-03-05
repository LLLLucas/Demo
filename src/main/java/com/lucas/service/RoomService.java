package com.lucas.service;

import java.util.List;

import com.lucas.pojo.Room;

public interface RoomService {
	void delete(int id);
	void insert(Room room);
	void update(Room room);
	List<Room> list();
	Room get(int id);
	List<Room> list(int typeId);
	Room selectById(int id);

}
