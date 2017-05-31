package com.niit.dao;

import java.util.List;

import com.niit.domain.User;


public interface UserDao {

	public boolean insertUser(User user);

	public List<User> list();

	public boolean deleteUser(String id);

	public User getUserById(String id);

}
