package com.lti.delegates;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lti.dao.UserRoleDao;
import com.lti.dao.UserRoleHibernate;
import com.lti.delegates.Delegatable;
import com.lti.services.UserService;
import com.lti.services.UserServiceImpl;
import com.lti.exceptions.UserNotFoundException;
import com.lti.models.User;
import com.lti.models.UserRole;

public class UserDelegate implements Delegatable{
	
	UserService us = new UserServiceImpl();
	UserRoleDao urd = new UserRoleHibernate();
	private static final long serialVersionUID = 1L;

	@Override
	public void process(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		String method = rq.getMethod();

		switch (method) {
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

		String pathNext = (String) rq.getAttribute("pathNext");

		if (pathNext != null) {
			try {
				User user = us.getUserById(Integer.valueOf(pathNext));
				try (PrintWriter pw = rs.getWriter()) {
					pw.write(new ObjectMapper().writeValueAsString(user));
				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UserNotFoundException e) {
				rs.sendError(404);
			}
		} else {
			List<User> users = us.getUsers();
			try (PrintWriter pw = rs.getWriter()) {
				pw.write(new ObjectMapper().writeValueAsString(users));
			}
		}
	}

	@Override
	public void handlePut(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		System.out.println("In handlePut");
		
	}

	@Override
	public void handlePost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		System.out.println("In handlePost");
		
		
		String username = rq.getParameter("username");
		String password = rq.getParameter("password");
		String firstName = rq.getParameter("firstName");
		String lastName = rq.getParameter("lastName");
		String email = rq.getParameter("email");
		
		System.out.println(username + ":" + password+ ":" +firstName+ ":" +lastName+ ":" +email);
		
		UserRole ur = urd.getUserRoleById(3);
		
		User u = new User(username, password, firstName, lastName, email, ur);
		
		System.out.println(u);
		
		if (!us.addUser(u)) {
			rs.sendError(400, "Unable to add user.");
		} else {
			rs.setStatus(200);
		}
		
		
		
//		InputStream request = rq.getInputStream();
//
//		User user = new ObjectMapper().readValue(request, User.class);
//		
//		if (!us.addUser(user)) {
//			rs.sendError(400, "Unable to add user.");
//		} else {
//			rs.setStatus(201);
//		}

	}

	@Override
	public void handleDelete(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		System.out.println("In handleDelete");
		
	}

}
