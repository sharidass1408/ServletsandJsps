package com.nbna.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nbna.model.User;
import com.nbna.service.InsertDataService;
import com.nbna.service.LoginService;

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
			
		}else if(url.endsWith("Login")){
			
			LoginService ls = new LoginService();			
			boolean status= ls.getLoginStatus();
			
			if(true){
				
				User user = ls.getUserInfo();
				request.getSession().setAttribute("user",user);
				response.sendRedirect("viewCustomerDetails.jsp");
			}
			else{
				response.sendRedirect("viewLogin.jsp");
			}
			
			
		}
		
	}

}
