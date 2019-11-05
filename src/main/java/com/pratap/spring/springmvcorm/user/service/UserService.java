package com.pratap.spring.springmvcorm.user.service;

import java.util.List;

import com.pratap.spring.springmvcorm.user.entity.User;

public interface UserService {

	int save(User user);
	
	List<User> getUser();
	
	User getUser(Integer id);
}
