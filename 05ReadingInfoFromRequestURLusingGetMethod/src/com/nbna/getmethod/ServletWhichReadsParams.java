package com.nbna.getmethod;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletWhichReadsParams")
public class ServletWhichReadsParams extends HttpServlet {
	      
    	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * To Demo how to read parameters from request URL
		 */
		String name =request.getParameter("username");
		String city = request.getParameter("city");
		
		/*
		 * To Demo how to write to to response URL
		 */
		PrintWriter pw = response.getWriter();
		pw.println("Hello: "+ name );		
		pw.println("City: "+city);
	}

}
