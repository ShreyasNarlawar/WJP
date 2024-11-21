package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.demo.beans.User;
import com.demo.services.LoginServImpl;
import com.demo.services.LoginService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		String uname = req.getParameter("username");
		String passwd = req.getParameter("password");
		
		LoginService lser = new LoginServImpl();
		User u = lser.validateUser(uname,passwd);
		
		if(u != null && u.getRole().equals("admin")) {
			RequestDispatcher rd = req.getRequestDispatcher("showData");
			rd.forward(req, res);
		}
		else {
			out.println("---Invalid Credentials---");
			RequestDispatcher rd = req.getRequestDispatcher("login.html");
			rd.include(req, res);
		}
	}
	
}
