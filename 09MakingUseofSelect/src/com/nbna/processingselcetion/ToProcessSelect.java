package com.nbna.processingselcetion;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ToProcessSelect
 */
@WebServlet("/ToProcessSelect")
public class ToProcessSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("username");
		/*
		 * To Demo how to capture multiple values, the point is that we need
		 * to use String[] instead of String to store the returned value
		 * Also we need to use getParameterValues as opposed to getParameter
		 */
		//String hobby= request.getParameter("hobby");
		String[] hobbies= request.getParameterValues("hobby");
		
		PrintWriter pw = response.getWriter();
		pw.write(name+" hobbies are:\n");
		for(String hobby:hobbies)
			pw.write(hobby+"\n");
	}

}
