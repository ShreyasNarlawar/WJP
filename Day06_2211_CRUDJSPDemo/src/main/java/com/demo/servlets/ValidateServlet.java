package com.demo.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.demo.beans.User;
import com.demo.services.*;

@WebServlet("/validate")
public class ValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		LoginService lserv = new LoginServiceImpl();
		
		User user = lserv.validateUser(username, password);
		
		if(user != null && user.getRole().equals("admin")) {
			RequestDispatcher rd = request.getRequestDispatcher("showprods");
			rd.forward(request, response);
		}else {
			out.println("Invalid Credentials");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.include(request, response);
		}
		
		
	}

}
