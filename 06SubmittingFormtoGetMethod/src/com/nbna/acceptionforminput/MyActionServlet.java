package com.nbna.acceptionforminput;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyActionServlet
 */
@WebServlet("/MyActionServlet")
public class MyActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name =request.getParameter("username");				
		PrintWriter pw= response.getWriter();
		
		pw.println("Welcom to the world of HTML and Java: "+ name );
		
		
	}

}
