package com.lti.services;

import com.lti.exceptions.AuthException;
import com.lti.models.Customer;
import com.lti.models.Employee;

public interface AuthService {
	
	public abstract Employee empLogin(String username, String password) throws AuthException;
	public abstract Customer cusLogin(String username, String password) throws AuthException;
}
