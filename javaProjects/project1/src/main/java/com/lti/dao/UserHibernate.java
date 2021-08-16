package com.lti.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.lti.exceptions.UserNotFoundException;
import com.lti.models.User;
import com.lti.util.HibernateUtil;

public class UserHibernate implements UserDao{

	public User getUserById(int id) throws UserNotFoundException {
		User u = null;
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			u = s.get(User.class, id);
		}
		return u;
	}

	public User getUserByUsername(String username) throws UserNotFoundException {
		User u = null;
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			String hql = "from User where username = :username";
			TypedQuery<User> nq = s.createQuery(hql, User.class);
			nq.setParameter("username", username);
			u = nq.getSingleResult();
		}
		return u;
	}

	public List<User> getUsers() {
		List<User> users = null;
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			// Use the classname that been mapped, not the table name
			users = s.createQuery("FROM User", User.class).list();
		}
		return users;
	}

	public User addUser(User user) {
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			Transaction tx = s.beginTransaction();
			s.save(user);
			tx.commit();
		}
		return user;
	}

	public void updateUser(User user) {
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			Transaction tx = s.beginTransaction();
			s.update(user);
			tx.commit();
		}
		
	}

	public void deleteUser(User user) {
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			Transaction tx = s.beginTransaction();
			s.delete(user);
			tx.commit();
		}	
	}

}
