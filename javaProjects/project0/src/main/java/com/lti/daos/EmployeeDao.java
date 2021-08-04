package com.lti.daos;

import java.util.List;

import com.lti.models.Employee;

public interface EmployeeDao {
	public abstract Employee getEmployeeByID(int id);
	public abstract List<Employee> getEmployees();
	public abstract int addEmployee(Employee employee);
	public abstract boolean updateEmployee(Employee employee);
	public abstract int deleteEmployee(int id);
	public abstract Employee getEmployeeByEmail(String email);
	public abstract Employee getEmployeeByUsername(String username);
}
