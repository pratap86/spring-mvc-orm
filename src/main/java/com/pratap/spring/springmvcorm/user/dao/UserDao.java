package com.pratap.spring.springmvcorm.user.dao;

import java.util.List;

import com.pratap.spring.springmvcorm.user.entity.User;

public interface UserDao {

	int create(User user);
	
	List<User> findusers();
	
	User finduser(Integer id);
}
