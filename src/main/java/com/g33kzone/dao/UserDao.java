package com.g33kzone.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.g33kzone.pojo.User;

public interface UserDao extends CrudRepository<User, Integer> {

	public List<User> findByFirstName(String firstName);

	public List<User> findByLastName(String lastName);
}
