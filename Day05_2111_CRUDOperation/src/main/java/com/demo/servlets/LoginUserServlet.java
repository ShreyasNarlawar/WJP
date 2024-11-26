package com.demo.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.demo.beans.User;
import com.demo.services.LoginService;
import com.demo.services.LoginServiceImpl;

public class LoginUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		LoginService lserv = new LoginServiceImpl();
		
		User user = lserv.authenticateUser(username, password);
		
		if(user != null && user.getRole().equals("admin")) {
			
			RequestDispatcher rd = request.getRequestDispatcher("showprods");
			rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("login.ntml");
			rd.include(request, response);
		}
		
	}

}
