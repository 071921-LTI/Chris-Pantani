package com.lti.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.lti.models.ReimbursementType;
import com.lti.models.User;
import com.lti.models.UserRole;
import com.lti.util.HibernateUtil;

public class ReimbursementTypeHibernate implements ReimbursementTypeDao {

	@Override
	public ReimbursementType getReimbursementTypeById(int id) {
		ReimbursementType rt = null;
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			rt = s.get(ReimbursementType.class, id);
		}
		return rt;
	}

	@Override
	public ReimbursementType getReimbursementTypeByType(String type) {
		ReimbursementType rt = null;
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			String hql = ("from ReimbursementType where type = :type");
			TypedQuery<ReimbursementType> nq = s.createQuery(hql, ReimbursementType.class);
			nq.setParameter("type", type);
			rt = nq.getSingleResult();
		}
		return rt;
	}

	@Override
	public List<ReimbursementType> getReimbursementTypes() {
		List<ReimbursementType> ReimbursementTypes = null;
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			ReimbursementTypes = s.createQuery("FROM ReimbursementType", ReimbursementType.class).list();
		}
		return ReimbursementTypes;
	}

	@Override
	public ReimbursementType addReimbursementType(ReimbursementType rt) {
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			Transaction tx = s.beginTransaction();
			s.save(rt);
			tx.commit();
		}
		return rt;
	}

	@Override
	public void updateReimbursementType(ReimbursementType rt) {
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			Transaction tx = s.beginTransaction();
			s.update(rt);
			tx.commit();
		}
	}

	@Override
	public void deletReimbursementType(ReimbursementType rt) {
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			Transaction tx = s.beginTransaction();
			s.delete(rt);
			tx.commit();
		}
		
	}

}
