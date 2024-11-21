package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.demo.beans.Person;
import com.demo.beans.User;
import com.demo.services.LoginServImpl;
import com.demo.services.LoginService;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String uname = req.getParameter("username");
		String password = req.getParameter("password");
		String gender = req.getParameter("gender");
		String  degree = req.getParameter("degree");
		String city = req.getParameter("city");
		String[]skills = req.getParameterValues("skills");
		
		LoginService ls = new LoginServImpl();
		Person p1 = new Person(fname,lname,gender,degree,skills,city);
		User u1 = new User(uname,password,"user");
																																																																																																																																																																																										
		boolean status=ls.registerDetails(u1,p1); 
	}

}
