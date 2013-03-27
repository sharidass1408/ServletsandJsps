package com.nbna.service;

import javax.servlet.http.HttpServletRequest;
import com.nbna.DAO.LoginDataDAO;
import com.nbna.model.User;

public class LoginService {		
	
	LoginDataDAO ldd = null;

	private User userdata_from_database;
	
	public boolean getLoginStatus(HttpServletRequest request) {
		
		String entered_password = request.getParameter("password");
		/*
		 * Create an instance of LoginDataDAO and perform the query
		 * and get the processed results and assign it back to feild 
		 * variable of this service class. 
		 */
		ldd= new LoginDataDAO(request.getParameter("userid"));
		//ldd.performQuery();
		userdata_from_database =ldd.getProcessedResults();
		
		/*
		 * Get the password from database and compare it with the one entered by 
		 * user and only if it is equal then return true else return false. 
		 */				
		System.out.println("entered_password: "+entered_password );
		
		if(entered_password.equals(userdata_from_database.getPassword()))
				return true;		
		
		return false;
		
	}
	
	public User getUserInfo(){
		//Return userdata retrieved from database. 
		return userdata_from_database;
	}

}
