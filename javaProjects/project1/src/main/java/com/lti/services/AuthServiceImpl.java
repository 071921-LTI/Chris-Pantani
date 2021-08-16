package com.lti.services;

import java.sql.SQLException;

import com.lti.dao.UserDao;
import com.lti.dao.UserHibernate;
import com.lti.exceptions.UserNotFoundException;
import com.lti.models.User;

public class AuthServiceImpl implements AuthService{
	
	UserDao ud = new UserHibernate();

	@Override
	public User login(String username, String password) throws UserNotFoundException, SQLException {
		User u = ud.getUserByUsername(username);
		if(u.getPassword().equals(password)) {
			return u;
		} else {
			return null;
		}
	}

	@Override
	public boolean authorize(String token) throws UserNotFoundException, SQLException {
		String[] stringArr = token.split(":");
		int id = Integer.parseInt(stringArr[0]);
		String role = stringArr[1];
		User u = ud.getUserById(id);
		if(u.getUr().getRole() != role) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public User register(User u) throws SQLException {

		return null;
	}
	
}
	
