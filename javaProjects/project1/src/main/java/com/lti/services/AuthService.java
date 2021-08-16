package com.lti.services;

import java.sql.SQLException;

import com.lti.exceptions.UserNotFoundException;
import com.lti.models.User;

public interface AuthService {
	
	User login(String username, String password) throws UserNotFoundException, SQLException;
	boolean authorize(String token) throws UserNotFoundException, SQLException;
	User register(User u) throws SQLException;
}
