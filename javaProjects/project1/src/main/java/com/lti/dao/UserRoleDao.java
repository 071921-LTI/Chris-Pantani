package com.lti.dao;

import java.util.List;

import com.lti.models.User;
import com.lti.models.UserRole;

public interface UserRoleDao {
	
	UserRole getUserRoleById(int id);
	UserRole getUserRoleByRole(String role);
	List<UserRole> getUserRoles();
	UserRole addUserRole(UserRole ur);
	void updateUserRole(User ur);
	void deleteUserRole(User ur);
	
}
