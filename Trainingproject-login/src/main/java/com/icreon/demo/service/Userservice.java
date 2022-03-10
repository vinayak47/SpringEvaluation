package com.icreon.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icreon.demo.model.User;
import com.icreon.demo.repository.Myconnection;
import com.icreon.demo.repository.userDao;



@Service
public class Userservice {

	@Autowired
	userDao dao ;
	
	public User getUsersByEmailandPassword(String username, String password) {
		dao = new userDao(Myconnection.getConnection());
		return userDao.getUserByUsernameAndPassword(username, password);
	}
}
