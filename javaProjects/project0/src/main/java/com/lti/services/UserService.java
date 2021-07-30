package com.lti.services;

import com.lti.exceptions.UserNotFoundException;
import com.lti.models.User;

public interface UserService {
	
	public abstract boolean addUser(User user);
	public abstract User getUser(String username) throws UserNotFoundException;

}
