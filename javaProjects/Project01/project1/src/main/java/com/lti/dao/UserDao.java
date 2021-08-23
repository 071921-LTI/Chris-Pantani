package com.lti.dao;

import java.util.List;

import com.lti.exceptions.UserNotFoundException;
import com.lti.models.User;

public interface UserDao {

	User getUserById(int id) throws UserNotFoundException;
	User getUserByUsername(String username) throws UserNotFoundException;
	List<User> getUsers();
	User addUser(User user);
	boolean updateUser(User user);
	void deleteUser(User user);
	
	
}
