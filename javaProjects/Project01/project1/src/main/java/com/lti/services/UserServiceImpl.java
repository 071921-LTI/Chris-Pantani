package com.lti.services;

import java.util.List;

import com.lti.dao.UserDao;
import com.lti.dao.UserHibernate;
import com.lti.exceptions.UserNotFoundException;
import com.lti.models.User;

public class UserServiceImpl implements UserService{
	
	UserDao ud = new UserHibernate();

	@Override
	public boolean addUser(User user) {
		if(ud.addUser(user) == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public List<User> getUsers() {
		return ud.getUsers();
	}

	@Override
	public User getUserById(int id) throws UserNotFoundException {
		User user = null;
		user = ud.getUserById(id);
		return user;
	}

	@Override
	public User getUSerByUsername(String username) throws UserNotFoundException {
		User user = null;
		user = ud.getUserByUsername(username);
		return user;
	}

	@Override
	public boolean updateUser(User user) {
		if(user == null) {
			return false;
		} else {
			return ud.updateUser(user);
		}
	}

	@Override
	public boolean deleteUser(int id) {
		User u;
		try {
			u = ud.getUserById(id);
		} catch (UserNotFoundException e) {
			return false;
		}
		return true;
	}
	
}
