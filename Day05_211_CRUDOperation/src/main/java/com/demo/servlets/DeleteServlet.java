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

import com.demo.services.ProductServices;
import com.demo.services.ProductServiceImpl;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String role = (String) session.getAttribute("role");
		
		if(role != null && role.equals("role")) {
			
			int id = Integer.parseInt(request.getParameter("id"));
			
			ProductServices pserv = new ProductServiceImpl();
			boolean status = pserv.deleteById(id);
			
			RequestDispatcher rd = request.getRequestDispatcher("showprods");
			rd.forward(request, response);
		}else {
			out.println("<h2>Please Login in app</h2>");
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			rd.include(request, response);
		}
	}

}
