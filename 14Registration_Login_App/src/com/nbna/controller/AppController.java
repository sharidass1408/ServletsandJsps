package com.nbna.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nbna.service.InsertDataService;

/**
 * Servlet implementation class LoginController
 */

@WebServlet(urlPatterns ={ "/Login","/Register"})
public class AppController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    	public AppController() {
	    super();	   
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw= response.getWriter();
		pw.write("Weclome to AppController: " +request.getParameter("name"));
		
		String url =request.getRequestURL().toString();
		System.out.println(url);
		if (url.endsWith("Register")){
			
			InsertDataService ids = new InsertDataService();			
			boolean result= ids.execute(request);
			
		}
		
		
	}

}
