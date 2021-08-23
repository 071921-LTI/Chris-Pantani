package com.lti.services;

import java.util.List;

import com.lti.dao.ReimbursementDao;
import com.lti.dao.ReimbursementHibernate;
import com.lti.exceptions.ReimbursementNotFoundException;
import com.lti.exceptions.UserNotFoundException;
import com.lti.models.Reimbursement;
import com.lti.models.ReimbursementStatus;
import com.lti.models.User;

public class ReimbursementServiceImpl implements ReimbursementService {

	ReimbursementDao rd = new ReimbursementHibernate();
	
	@Override
	public boolean addReimbursement(Reimbursement reimbursement) {
		if(rd.addReimbursement(reimbursement) == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public List<Reimbursement> getReimbursements() {
		return rd.getReimbursements();
	}

	@Override
	public Reimbursement getReimbursementById(int id) throws ReimbursementNotFoundException {
		Reimbursement r = null;
		r = rd.getReimbursementById(id);
		return r;
	}

	@Override
	public boolean updateReimbursement(Reimbursement reimbursement) {
		if(reimbursement == null) {
			return false;
		} else {
			return rd.updateReimbursement(reimbursement);
		}
	}

	@Override
	public boolean deleteReimbursement(int id) {
		Reimbursement r;
		try {
			r = rd.getReimbursementById(id);
		} catch (ReimbursementNotFoundException e) {
			return false;
		}
		return true;
	}

	@Override
	public List<Reimbursement> getReimbursementAuthor(User u) throws UserNotFoundException {
		return rd.getReimbursementAuthor(u);
	}

	@Override
	public List<Reimbursement> getReimbursementResolver(User u) throws UserNotFoundException {
		return rd.getReimbursementResolver(u);
	}

	@Override
	public List<Reimbursement> getReimbursementsByStatus(ReimbursementStatus rs, User u) {
		return rd.getReimbursementsByStatus(rs, u);
	}

}
