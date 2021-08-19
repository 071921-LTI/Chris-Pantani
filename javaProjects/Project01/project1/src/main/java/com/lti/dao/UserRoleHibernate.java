package com.lti.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.lti.models.User;
import com.lti.models.UserRole;
import com.lti.util.HibernateUtil;

public class UserRoleHibernate implements UserRoleDao{

	@Override
	public UserRole getUserRoleById(int id) {
		UserRole ur = null;
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			ur = s.get(UserRole.class, id);
		}
		return ur;
	}

	@Override
	public UserRole getUserRoleByRole(String role) {
		UserRole ur = null;
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			ur = s.get(UserRole.class, role);
		}
		return ur;
	}

	
	@Override
	public List<UserRole> getUserRoles() {
		List<UserRole> userRoles = null;
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			userRoles = s.createQuery("FROM UserRole", UserRole.class).list();
		}
		return userRoles;
	}
	
	@Override
	public UserRole addUserRole(UserRole ur) {
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			Transaction tx = s.beginTransaction();
			s.save(ur);
			tx.commit();
		}
		return ur;
	}



	@Override
	public void updateUserRole(User ur) {
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			Transaction tx = s.beginTransaction();
			s.update(ur);
			tx.commit();
		}
		
	}

	@Override
	public void deleteUserRole(User ur) {
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			Transaction tx = s.beginTransaction();
			s.delete(ur);
			tx.commit();
		}	
	}
}




