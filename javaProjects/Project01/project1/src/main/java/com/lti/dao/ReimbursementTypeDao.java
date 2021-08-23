package com.lti.dao;

import java.util.List;

import com.lti.models.ReimbursementType;

public interface ReimbursementTypeDao {
	
	ReimbursementType getReimbursementTypeById(int id);
	ReimbursementType getReimbursementTypeByType(String type);
	List<ReimbursementType> getReimbursementTypes();
	ReimbursementType addReimbursementType(ReimbursementType rt);
	void updateReimbursementType(ReimbursementType rt);
	void deletReimbursementType(ReimbursementType rt);
}
