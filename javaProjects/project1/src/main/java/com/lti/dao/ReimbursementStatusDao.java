package com.lti.dao;

import java.util.List;

import com.lti.models.ReimbursementStatus;

public interface ReimbursementStatusDao {
	
	ReimbursementStatus getReimbursementStatusById(int id);
	ReimbursementStatus getReimbursementStatusByStatus(String status);
	List<ReimbursementStatus> getReimbursementStatus();
	ReimbursementStatus addReimbursementStatus(ReimbursementStatus rs);
	void updateReimbursementStatus(ReimbursementStatus rs);
	void deleteReimbursementStatus(ReimbursementStatus rs);

}
