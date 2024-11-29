package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.demo.beans.User;
import com.demo.service.LoginService;
import com.demo.service.LoginServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/validate")
public class ValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
   		PrintWriter out=response.getWriter();
   		String uname=request.getParameter("username");
		String pass=request.getParameter("password");
		LoginService lservice= new LoginServiceImpl();
		User user=lservice.validateUser(uname,pass);
		 if(user!=null && user.getRole().equals("user")) {
			 HttpSession sesh = request.getSession();
			 sesh.setAttribute("user",user );
			 RequestDispatcher rd= request.getRequestDispatcher("categories");
			 rd.forward(request, response);
		 }else {
			 out.println("InValid Credentials");
			 RequestDispatcher rd= request.getRequestDispatcher("Loginpage.jsp");
			 rd.include(request, response);
		 }
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
