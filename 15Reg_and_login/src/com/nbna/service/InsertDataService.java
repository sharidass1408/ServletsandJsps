package com.nbna.service;


import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import com.nbna.DAO.InsertDataDAO;
import com.nbna.model.User;

public class InsertDataService {
	
	public boolean execute (HttpServletRequest request) throws SQLException{
		
		if(request.getParameter("password").equals(request.getParameter("repassword"))){
			
			User user = new User();
			
			user.setName(request.getParameter("name"));
			user.setUserid(request.getParameter("userid"));
			user.setPassword(request.getParameter("password"));
			user.setEmail(request.getParameter("email"));
			
			user.setStreet(request.getParameter("street"));
			user.setCity(request.getParameter("city"));
			user.setState(request.getParameter("state"));
			user.setZip(request.getParameter("zip"));			
			
			InsertDataDAO idd = new InsertDataDAO(user);
			idd.performQuery();
			
			return true;
			}
		
		return false;
		
	}

}
