package com.example.abc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.abc.dao.User;
import com.example.abc.dao.UserDao;

@Service("userService")
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public void create(User user){
		userDao.create(user);
	}

}
