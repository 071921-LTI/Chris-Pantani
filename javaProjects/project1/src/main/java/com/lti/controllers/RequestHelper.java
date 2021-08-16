package com.lti.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lti.delegates.AuthDelegate;
import com.lti.delegates.UserDelegate;

public class RequestHelper {
	
	private UserDelegate ud = new UserDelegate();
	private AuthDelegate ad = new AuthDelegate();
	
	public void process(HttpServletRequest rq, HttpServletResponse rs) throws IOException, ServletException {
		
		String path = rq.getPathInfo();
		
		if(path != null) {
			path = path.substring(1);
			
			if(path.indexOf("/") != -1) {
				String[] paths = path.split("/");
				path = paths[0];
				rq.setAttribute("pathNext", paths[1]);
			}
			
			switch(path) {
			case "users":
				ud.process(rq, rs);
				break;
			case "auth":
				ad.process(rq, rs);
				
				break;
			case "reimbursements":
				
				break;
			default:
				rs.sendError(400, "Path not supported:" + path);
			}
		}else { 
			rs.sendError(400, "No path found.");
		}
	}
	

}
