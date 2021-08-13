package com.lti.dao;

import java.util.List;

import com.lti.exceptions.ReimbursementNotFoundException;
import com.lti.exceptions.UserNotFoundException;
import com.lti.models.Reimbursement;
import com.lti.models.User;

public interface ReimbursementDao {

	Reimbursement getReimbursementById(int id) throws ReimbursementNotFoundException;
	List<Reimbursement> getReimbursements();
	List<Reimbursement> getReimbursementAuthor(User u) throws UserNotFoundException;
	List<Reimbursement> getReimbursementResolver(User u) throws UserNotFoundException;
	Reimbursement addReimbursement(Reimbursement r);
	void updateReimbursement(Reimbursement r);
	void deleteReimbursement(Reimbursement r);
}
