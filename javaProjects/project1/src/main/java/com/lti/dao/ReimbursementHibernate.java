package com.lti.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.lti.exceptions.ReimbursementNotFoundException;
import com.lti.exceptions.UserNotFoundException;
import com.lti.models.Reimbursement;
import com.lti.models.User;
import com.lti.models.UserRole;
import com.lti.util.HibernateUtil;

public class ReimbursementHibernate implements ReimbursementDao{

	@Override
	public Reimbursement getReimbursementById(int id) throws ReimbursementNotFoundException {
		Reimbursement r = null;
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			r = s.get(Reimbursement.class, id);
		}
		return r;
	}

	@Override
	public List<Reimbursement> getReimbursements() {
		List<Reimbursement> reimbursements = null;
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			reimbursements = s.createQuery("FROM User", Reimbursement.class).list();
		}
		return reimbursements;
	}

	@Override
	public List<Reimbursement> getReimbursementAuthor(User u) throws UserNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursement> getReimbursementResolver(User u) throws UserNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reimbursement addReimbursement(Reimbursement r) {
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			Transaction tx = s.beginTransaction();
			s.save(r);
			tx.commit();
		}
		return r;
	}

	@Override
	public void updateReimbursement(Reimbursement r) {
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			Transaction tx = s.beginTransaction();
			s.update(r);
			tx.commit();
		}
		
	}

	@Override
	public void deleteReimbursement(Reimbursement r) {
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			Transaction tx = s.beginTransaction();
			s.delete(r);
			tx.commit();
		}	
	}

}
