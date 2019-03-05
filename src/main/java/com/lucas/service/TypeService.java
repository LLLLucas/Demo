package com.lucas.service;

import java.util.List;

import com.lucas.pojo.Type;



public interface TypeService {
	 void delete(int id);
	 void insert(Type type );
	 void update(Type type );
	 List<Type> list();
	 Type get(int id);
}
