package com.lti.delegates;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lti.dao.ReimbursementDao;
import com.lti.dao.ReimbursementHibernate;
import com.lti.dao.ReimbursementStatusDao;
import com.lti.dao.ReimbursementStatusHibernate;
import com.lti.dao.ReimbursementTypeDao;
import com.lti.dao.ReimbursementTypeHibernate;
import com.lti.exceptions.ReimbursementNotFoundException;
import com.lti.exceptions.UserNotFoundException;
import com.lti.models.Reimbursement;
import com.lti.models.ReimbursementStatus;
import com.lti.models.ReimbursementType;
import com.lti.models.User;
import com.lti.models.UserRole;
import com.lti.services.ReimbursementService;
import com.lti.services.ReimbursementServiceImpl;
import com.lti.services.UserService;
import com.lti.services.UserServiceImpl;

public class ReimbursementDelegate implements Delegatable {
	
	ReimbursementService res = new ReimbursementServiceImpl();
	ReimbursementTypeDao rtd = new ReimbursementTypeHibernate();
	UserService us = new UserServiceImpl();
	ReimbursementStatusDao rsd = new ReimbursementStatusHibernate();
	

	@Override
	public void process(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		String method = rq.getMethod();
				
				switch(method) {
					case "GET":
						handleGet(rq, rs);
						break;
					case "POST":
						handlePost(rq, rs);
						break;
					case "PUT":
						handlePut(rq, rs);
						break;
					case "DELETE":
						handleDelete(rq, rs);
						break;
					default:
						rs.sendError(405);
					}		
				
	}

	@Override
	public void handleGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		System.out.println("In handleGet");
		String token = rq.getHeader("Authorization");
		
		System.out.println("this is the recieved toekn"+token);
		
		String[] stringArr = token.split(":");
		int id = Integer.parseInt(stringArr[0]);
		User u = null;
		try {
			u = us.getUserById(id);
		} catch (UserNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String pathNext = (String) rq.getAttribute("pathNext");
		
		if(pathNext != null) {
				try {
					Reimbursement r = res.getReimbursementById(Integer.valueOf(pathNext));
					try(PrintWriter pw = rs.getWriter()) {
						pw.write(new ObjectMapper().writeValueAsString(r));
					}
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (ReimbursementNotFoundException e) {
					rs.sendError(400);
				} 
			} else {
					List<Reimbursement> reimbursements = null;
					if(u.getUr().getRole().equals("Manager")) {
						reimbursements = res.getReimbursements();
					} else {
						try {
							reimbursements = res.getReimbursementAuthor(u);
						} catch (UserNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					rs.setStatus(200);
					try (PrintWriter pw = rs.getWriter()) {
						pw.write(new ObjectMapper().writeValueAsString(reimbursements));
					
				}
				

			}
		
	}

	@Override
	public void handlePut(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handlePost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		System.out.println("In handlePost reim");
		String token = rq.getHeader("Authorization");
		
		String[] stringArr = token.split(":");
		int id = Integer.parseInt(stringArr[0]);
		String role = stringArr[1];
		
		User u = null;
		try {
			u = us.getUserById(id);
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		String amount = rq.getParameter("amount");
		String description = rq.getParameter("description");
		String type = rq.getParameter("type");
		
		int amountInt = Integer.parseInt(amount);
				
					
		System.out.println(amountInt + ":" + description+ ":" +type);
		
		ReimbursementType rt = rtd.getReimbursementTypeByType(type);
		ReimbursementStatus rbs = rsd.getReimbursementStatusById(1);
		
		Reimbursement r = new Reimbursement(amountInt, new Timestamp(System.currentTimeMillis()), null, description,u,null,rbs,rt);
		System.out.println(u);
				
		if (!res.addReimbursement(r)) {
			rs.sendError(400, "Unable to add user.");
		} else {
			rs.setStatus(200);
		}
			
	}

	@Override
	public void handleDelete(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
