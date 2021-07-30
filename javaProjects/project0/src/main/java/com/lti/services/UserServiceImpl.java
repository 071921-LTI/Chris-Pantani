package com.lti.services;

import com.lti.daos.UserDao;
import com.lti.daos.UserFile;
import com.lti.exceptions.UserNotFoundException;
import com.lti.models.User;

public class UserServiceImpl implements UserService {
	
	private UserDao ud =  new UserFile();

	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		return ud.addUser(user);
	}

	@Override
	public User getUser(String username) throws UserNotFoundException {
		// TODO Auto-generated method stub
		return ud.getUser(username);
	}

}
