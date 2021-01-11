package com.zensar;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginController extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response) {
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		
		System.out.println("userId:"+userId);
		System.out.println("password:"+password);
		
		LoginRepository loginRepository = new LoginRepository();
		boolean result = loginRepository.checkLogin(userId, password);
		if(result) {
			System.out.println("Login Successful");
			RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
			try {
			rd.forward(request, response);
			}catch(Exception e) {
				System.out.println("Exception Occured:"+e);
			}
		}
		else {
			System.out.println("Login Failed");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			request.setAttribute("message", "Please check your login credentials and try again...");
			try {
				rd.forward(request, response);
				}catch(Exception e) {
					System.out.println("Exception Occured:"+e);
				}
			
		}
			
		
		
	}
}
