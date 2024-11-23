package com.demo.servlets;

import jakarta.servlet.RequestDispatcher;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.demo.beans.Person;
import com.demo.beans.User;
import com.demo.services.LoginService;
import com.demo.services.LoginServiceImpl;

@WebServlet("/RegisterUser")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String gender = request.getParameter("gender");
		String degree = request.getParameter("degree");
		String city = request.getParameter("city");
		String[] skills = request.getParameterValues("skills");
		
		LoginService lserv = new LoginServiceImpl();
		String username = request.getParameter("uname");
		String password =  request.getParameter("password");
		
		Person p1 = new Person(fname,lname,gender,degree,city,skills);
		
		User u1 = new User(username,password,"user");
		
		boolean status = lserv.registerUsers(p1,u1);
		if(status) {
			out.println("<h1>Registration done successfully </h1>");
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			rd.include(request, response);
		}else {
			out.println("<h1>Registration failed </h1>");
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			rd.include(request, response);
		}
	}

}
