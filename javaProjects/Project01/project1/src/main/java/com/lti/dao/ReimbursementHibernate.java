package com.lti.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.lti.exceptions.ReimbursementNotFoundException;
import com.lti.exceptions.UserNotFoundException;
import com.lti.models.Reimbursement;
import com.lti.models.ReimbursementStatus;
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
			reimbursements = s.createQuery("FROM Reimbursement", Reimbursement.class).list();
		}
		return reimbursements;
	}

	@Override
	public List<Reimbursement> getReimbursementAuthor(User u) throws UserNotFoundException {
		List<Reimbursement> reimbursements = null;
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			String hql = "from Reimbursement where author = :author";
			TypedQuery<Reimbursement> nq = s.createQuery(hql, Reimbursement.class);
			nq.setParameter("author", u);
			reimbursements =nq.getResultList();
		}
		return reimbursements;
	}

	@Override
	public List<Reimbursement> getReimbursementResolver(User u) throws UserNotFoundException {
		List<Reimbursement> reimbursements = null;
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			String hql = "from Reimbursement where resolver = :resolver";
			TypedQuery<Reimbursement> nq = s.createQuery(hql, Reimbursement.class);
			nq.setParameter("resolver", u);
			reimbursements =nq.getResultList();
		}
		return reimbursements;
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

	@Override
	public List<Reimbursement> getReimbursementsByStatus(ReimbursementStatus rs, User author) {
		List<Reimbursement> reimbursements = null;
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			String hql = "from Reimbursement where status = :status and author = :author";
			TypedQuery<Reimbursement> nq = s.createQuery(hql, Reimbursement.class);
			nq.setParameter("status", rs);
			nq.setParameter("author", author);
			reimbursements =nq.getResultList();
		}
		return reimbursements;
	}

}
