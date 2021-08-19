package com.lti.services;

import java.util.List;

import com.lti.exceptions.ReimbursementNotFoundException;
import com.lti.exceptions.UserNotFoundException;
import com.lti.models.Reimbursement;
import com.lti.models.ReimbursementStatus;
import com.lti.models.User;

public interface ReimbursementService {
	
	boolean addReimbursement(Reimbursement r);
	List<Reimbursement> getReimbursements();
	List<Reimbursement> getReimbursementAuthor(User u) throws UserNotFoundException;
	List<Reimbursement> getReimbursementResolver(User u) throws UserNotFoundException;
	List<Reimbursement>getReimbursementsByStatus(ReimbursementStatus rs, User u);
	Reimbursement getReimbursementById(int id) throws ReimbursementNotFoundException;
	boolean updateReimbursement(Reimbursement r);
	boolean deleteReimbursement(int id);

}
