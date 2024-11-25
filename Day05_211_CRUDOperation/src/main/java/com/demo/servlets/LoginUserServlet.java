package com.demo.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import com.demo.beans.User;
import com.demo.services.LoginService;
import com.demo.services.LoginServiceImpl;

@WebServlet("/LoginUserServlet")
public class LoginUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		LoginService lserv = new LoginServiceImpl();
		
		User user = lserv.authenticateUser(username, password);
		
		if(user != null && user.getRole().equals(user)) {
			HttpSession session = request.getSession();
			
			RequestDispatcher rd = request.getRequestDispatcher("showprods");
			rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("login.ntml");
			rd.include(request, response);
		}
		
	}

}
