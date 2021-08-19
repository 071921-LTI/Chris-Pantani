package com.lti.services;

import java.util.List;

import com.lti.exceptions.UserNotFoundException;
import com.lti.models.User;

public interface UserService {
	
	boolean addUser(User user);
	List<User> getUsers();
	User getUserById(int id) throws UserNotFoundException;
	User getUSerByUsername(String username) throws UserNotFoundException;
	boolean updateUser(User user);
	boolean deleteUser(int id);
	
}
