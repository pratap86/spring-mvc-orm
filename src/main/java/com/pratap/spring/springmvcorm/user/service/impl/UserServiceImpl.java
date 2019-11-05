package com.pratap.spring.springmvcorm.user.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pratap.spring.springmvcorm.user.dao.UserDao;
import com.pratap.spring.springmvcorm.user.entity.User;
import com.pratap.spring.springmvcorm.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	@Transactional
	public int save(User user) {
		// Business Logic
		return userDao.create(user);
	}

	@Override
	public List<User> getUser() {
		List<User> users = userDao.findusers();
		Collections.sort(users);
		return users;
	}

	@Override
	public User getUser(Integer id) {
		return userDao.finduser(id);
	}

}
