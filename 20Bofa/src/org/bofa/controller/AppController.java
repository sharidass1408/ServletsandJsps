package org.bofa.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import org.bofa.model;

import org.bofa.model.UrlSearchResult;
import org.bofa.service.SearchService;

/**
 * Servlet implementation class SearchController
 */

@WebServlet(urlPatterns ={ "/Search"})
public class AppController extends HttpServlet {
	private static final long serialVersionUID = 1L;    
   
    	public AppController() {
	    super();	   
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw= response.getWriter();
		
		SearchService ss = new SearchService();
		UrlSearchResult result = ss.getSearchResults(request);
			
			
			if(result== null){
				System.out.println("This is login sucess");									
				
				request.getSession().setAttribute("result",result);
				response.sendRedirect("Results.jsp");			
				
			}
			else{
				response.sendRedirect("Welcome.jsp");
			}
			
			
		}
		
	}



