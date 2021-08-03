package com.lti.daos;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lti.daos.EmployeeDao;
import com.lti.models.Employee;
import com.lti.uitl.ConnectionUtil;

public class EmployeePostgres implements EmployeeDao {

	@Override
	public Employee getEmployeeByID(int id) {
		String sql = "select * from employees where empl_id = ?";
		Employee emp = null;
		try(Connection con = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id); //1 refers to the first ? to deal with
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int empId = rs.getInt("empl_id");
				String first_name = rs.getString("empl_first_name");
				String last_name = rs.getString("empl_last_name");
				String username = rs.getString("empl_username");
				String password = rs.getString("empl_password");
				String email = rs.getString("empl_email");
				
				emp = new Employee(empId, first_name, last_name, username, password, email);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp;
	}

	@Override
	public List<Employee> getEmployees() {
		List<Employee> employees = new ArrayList<>();
		
		try(Connection con = ConnectionUtil.getConnectionFromEnv()){
			String sql = "select * from employees";
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				int empid = rs.getInt("empl_id");
				String first_name = rs.getString("empl_first_name");
				String last_name = rs.getString("empl_last_name");
				String username = rs.getString("empl_username");
				String password = rs.getString("empl_password");
				String email = rs.getString("empl_email");
				
				Employee employee = new Employee(empid, first_name, last_name, username, password, email);
				employees.add(employee);
				}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employees;
	}

	@Override
	public int addEmployee(Employee employee) {
		int id = -1;
		String sql = "insert into employees (empl_username, empl_password, empl_first_name, empl_last_name, empl_email) values (?,?,?,?,?) returning empl_id;";
		
		try(Connection con = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, employee.getUsername());
			ps.setString(2, employee.getPassword());
			ps.setString(3, employee.getFirst_name());
			ps.setString(4, employee.getLast_name());
			ps.setString(5, employee.getEmail());
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				id = rs.getInt("empl_id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		String sql = " update employees set empl_username = ?, empl_password = ?, empl_first_name = ?, empl_last_name = ?, empl_email = ? where empl_id = ?";
		int rowsChanged = -1;
		
		try(Connection con = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, employee.getUsername());
			ps.setString(2, employee.getPassword());
			ps.setString(3, employee.getFirst_name());
			ps.setString(4, employee.getLast_name());
			ps.setString(5, employee.getEmail());
			ps.setInt(6, employee.getId());
			
			rowsChanged = ps.executeUpdate();
;		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(rowsChanged >0) {
			return true;
		}
		return false;
	}

	@Override
	public int deleteEmployee(int id) {
		String sql = "delete from employees where empl_id = ?;";
		int rowsChanged = -1;
		
		try(Connection con = ConnectionUtil.getConnectionFromEnv()) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			
			rowsChanged = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rowsChanged;	
	}

	@Override
	public Employee getEmployeeByEmail(String email) {
		String sql = "select * from employees where empl_email = ?";
		Employee emp = null;
		try(Connection con = ConnectionUtil.getConnectionFromEnv()) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int empId = rs.getInt("empl_id");
				String first_name = rs.getString("empl_first_name");
				String last_name = rs.getString("empl_last_name");
				String username = rs.getString("empl_username");
				String password = rs.getString("empl_password");
				String emp_email = rs.getString("empl_email");
				emp = new Employee(empId, first_name, last_name, username, password, emp_email);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp;
	}

	@Override
	public Employee getEmployeeByUsername(String username) {
		String sql = "select * from employees where empl_username = ?";
		Employee emp = null;
		try(Connection con = ConnectionUtil.getConnectionFromEnv()) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int empId = rs.getInt("empl_id");
				String first_name = rs.getString("empl_first_name");
				String last_name = rs.getString("empl_last_name");
				String empUsername = rs.getString("empl_username");
				String password = rs.getString("empl_password");
				String emp_email = rs.getString("empl_email");
				emp = new Employee(empId, first_name, last_name, empUsername, password, emp_email);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp;
	}

}
