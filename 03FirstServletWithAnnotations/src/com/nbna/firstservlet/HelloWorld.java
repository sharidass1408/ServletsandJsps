package com.nbna.firstservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/HelloWorld")

@WebServlet("/Hello")
public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		/*
		 * To Demo how we use PrintWriter which  is derived from 
		 */
		PrintWriter pw = response.getWriter();
		pw.print("Hello World");		
		
	}
	

}
