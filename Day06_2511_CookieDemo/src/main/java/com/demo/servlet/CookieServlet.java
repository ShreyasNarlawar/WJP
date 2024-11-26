package com.demo.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/cookies")
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String button = request.getParameter("button");
		
		String name;
		String val;
		Cookie[] crr;
		switch(button) {
			case "add" ->{
				name = request.getParameter("name");
				val = request.getParameter("val");
				
				Cookie c = new Cookie(name, val);	
				response.addCookie(c);
				
				out.println("cookie added successfully");
				RequestDispatcher rd = request.getRequestDispatcher("cookies.html");
				rd.include(request, response);	
				}
			case "show" ->{
				crr = request.getCookies();
				
				for(Cookie c : crr) {
					out.println(c.getName() + "--->"+c.getValue()+"----->"+c.getMaxAge());
				}
				RequestDispatcher rd = request.getRequestDispatcher("cookies.html");
				rd.include(request, response);	
			}
			case "del" ->{
				 name = request.getParameter("name");
				 crr = request.getCookies();
				 
				 for(Cookie c :crr) {
					
					 if(c.getName().equals(name)) {
						 c.setMaxAge(56);
						 response.addCookie(c);
					 }
				 }
				 out.println("Cookie deleted Successfully");
				 RequestDispatcher rd = request.getRequestDispatcher("cookies.html");
				 rd.include(request, response);
			}
		
		
		}
	}

}
