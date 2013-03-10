package com.nbna.sessiondemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Note: 
 * The request is only per user per browser per request
 * The session is only per user per browser  
 */

@WebServlet("/SessionExample")
public class SessionExample extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String name =request.getParameter("username");
		PrintWriter pw = response.getWriter();
		
		
		/*
		 * Step to store session:
		 * 1. Create a session object by calling getSession() on the request object
		 * 2. Store the session object to a referece variable of type HttpSession
		 * 3. Save the value of session to the session object with some name
		 */
		
		HttpSession session = request.getSession(); 
		ServletContext context = request.getServletContext();
		if (name!= null && name!=""){
			
			session.setAttribute("savedsessionname", name);
			context.setAttribute("savedcontextname", name);
			
		}
		
		/*
		 * To Demo how to retrieve saved session. 
		 */
		
		String savedname = (String)session.getAttribute("savedsessionname");
		String savedcontextname = (String)context.getAttribute("savedcontextname");
		
		pw.print("Name from request: "+ name+"\t" );	
		pw.println("Name from session: "+ savedname +"\t");
		pw.println("Name from session: "+ savedcontextname +"\t");
		
		
	}

	

}
