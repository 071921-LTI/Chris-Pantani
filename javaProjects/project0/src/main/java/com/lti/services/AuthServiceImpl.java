package com.lti.services;

import com.lti.daos.UserDao;
import com.lti.daos.UserFile;
import com.lti.exceptions.AuthException;
import com.lti.models.User;
import com.lti.exceptions.UserNotFoundException;

public class AuthServiceImpl implements AuthService {
	
	private UserDao ud = new UserFile();

	@Override
	public boolean login(User user) throws AuthException {


		try {
			User activeUser = ud.getUser(user.getUsername());
			if (activeUser.getPassword().equals(user.getPassword())){
				return true;
			} else {
				return false;
			}
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

}
