package com.g33kzone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import com.g33kzone.dao.UserDao;
import com.g33kzone.pojo.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public List<User> fetchAll() {

		List<User> userList = new ArrayList<>();
		userDao.findAll().forEach(userList::add);

		return userList;
	}

	public void adduser(User user) {
		userDao.save(user);
	}

	public List<User> findByFirstName(String firstName) {
		return userDao.findByFirstName(firstName);
	}

	public List<User> findByLastName(String lastName) {
		return userDao.findByLastName(lastName);
	}
}
