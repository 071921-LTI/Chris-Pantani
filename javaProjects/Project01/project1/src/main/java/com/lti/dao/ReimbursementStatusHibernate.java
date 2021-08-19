package com.lti.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.lti.models.ReimbursementStatus;
import com.lti.models.UserRole;
import com.lti.util.HibernateUtil;

public class ReimbursementStatusHibernate implements ReimbursementStatusDao{

	@Override
	public ReimbursementStatus getReimbursementStatusById(int id) {
		ReimbursementStatus rs = null;
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			rs = s.get(ReimbursementStatus.class, id);
		}
		return rs;
	}

	@Override
	public ReimbursementStatus getReimbursementStatusByStatus(String status) {
		ReimbursementStatus rs = null;
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			rs = s.get(ReimbursementStatus.class, status);
		}
		return rs;
	}

	@Override
	public List<ReimbursementStatus> getReimbursementStatus() {
		List<ReimbursementStatus> ReimbursementStatus = null;
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			ReimbursementStatus = s.createQuery("FROM ReimbursementStatus", ReimbursementStatus.class).list();
		}
		return ReimbursementStatus;
	}

	@Override
	public ReimbursementStatus addReimbursementStatus(ReimbursementStatus rs) {
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			Transaction tx = s.beginTransaction();
			s.save(rs);
			tx.commit();
		}
		return rs;
	}

	@Override
	public void updateReimbursementStatus(ReimbursementStatus rs) {
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			Transaction tx = s.beginTransaction();
			s.update(rs);
			tx.commit();
		}
		
	}

	@Override
	public void deleteReimbursementStatus(ReimbursementStatus rs) {
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			Transaction tx = s.beginTransaction();
			s.delete(rs);
			tx.commit();
		}	
	}
		
}


