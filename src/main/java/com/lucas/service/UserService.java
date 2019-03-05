package com.lucas.service;

import java.util.List;

import com.lucas.pojo.User;

public interface UserService {
		void delete(int id);
		 void insert(User user );
		 void update(User user );
		 List<User> list();
		 User get(int id);
		 boolean isExist(User user);
		 boolean login(User user);
		 User get(String username,String password);
		User get(String username);

}
