package com.nbna.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nbna.emailing.EmailCustomer;
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
		
		
		String url =request.getRequestURL().toString();
		System.out.println(url);
		if (url.endsWith("Register")){
			
			InsertDataService ids = new InsertDataService();			
			try {
				ids.execute(request);
				pw.write("Sucessfully created an account please look forward for email");
				//new EmailCustomer(request);
			} catch (SQLException e) {
				pw.write("Sorry a system error occcured while registring your account");
				pw.write("Please contact customer support at 312-623-1046");
				e.printStackTrace();
			}
						
		}else if(url.endsWith("Login")){
			
			LoginService ls = new LoginService();			
			boolean status= ls.getLoginStatus(request);
			
			/*
			 * if entered password is same as the password from the database then do the logic 
			 * in if statement
			 */
			if(status){
				System.out.println("This is login sucess");
				User user = ls.getUserInfo();				
				
				/*request.getSession().setAttribute("userid",request.getParameter("userid"));
				request.getSession().setAttribute("name",request.getParameter("name"));*/
				
				request.getSession().setAttribute("user",user);
				response.sendRedirect("viewCustomerDetails.jsp");
				
				
				
			}
			else{
				response.sendRedirect("viewLogin.jsp");
			}
			
			
		}
		
	}

}

/*
 * Second way to do it is using RequestDispather it has following advantages
 * 	1) Browser does not get involved in sending request i.e. the url does not change
 * 	2) You can still use the login infromation from current page to which ever page it
 *     is getting forwarded to
 *  3) You dont have to set values to a scope, you would just pass on the request 
 *  	and response.
 */
/*request.setAttribute("user", user);
RequestDispatcher dispatcher = request.getRequestDispatcher("viewCustomerDetails.jsp");
dispatcher.forward(request,response);*/

