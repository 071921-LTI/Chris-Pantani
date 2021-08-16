package com.lti.delegates;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lti.exceptions.UserNotFoundException;
import com.lti.models.User;
import com.lti.services.AuthService;
import com.lti.services.AuthServiceImpl;
import com.lti.util.CorsFix;

public class AuthDelegate implements Delegatable {
	
	AuthService as = new AuthServiceImpl();
	private static final long serialVersionUID = 1L;
	

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
		String pathNext = (String) rq.getAttribute("pathNext");
		switch(pathNext) {
		case "logout":
			rq.getSession().setAttribute("user", null);
			break;
		}
		
	}

	@Override
	public void handlePut(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handlePost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		System.out.println("in handlePost");
//		CorsFix.addCorsHeader(rq.getRequestURI(), rs);
		
		String username = rq.getParameter("username");
		String password = rq.getParameter("password");
		
		
		
		
			try {
				User user = as.login(username, password);
				if(user != null) {
//					HttpSession session = rq.getSession();
//					session.setAttribute("user", username);
					
					String token = user.getId() + ":" + user.getUr().getRole();
					rs.setHeader("Authorization", token);
					rs.setStatus(200);
				} else {
					rs.sendError(400);
				}
			} catch (UserNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
				
			
				
	}

	@Override
	public void handleDelete(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
