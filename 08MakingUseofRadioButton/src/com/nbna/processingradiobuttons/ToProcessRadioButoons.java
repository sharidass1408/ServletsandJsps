package com.nbna.processingradiobuttons;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ToProcessRadioButoons
 */
@WebServlet("/ToProcessRadioButtons")
public class ToProcessRadioButoons extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter();
		
		String username = request.getParameter("username");
		String gender = request.getParameter("gender");
		
		pw.write(username +" is "+ gender );
		
		
	}

}
