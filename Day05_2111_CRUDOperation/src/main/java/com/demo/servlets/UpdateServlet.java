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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.demo.beans.Product;
import com.demo.services.ProductServices;
import com.demo.services.ProductServiceImpl;


public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		String role = (String)session.getAttribute("role");
		
		if(role != null && role.equals("role")) {
			int id = Integer.parseInt(request.getParameter("pid"));
			String name = request.getParameter("name");
			int qty = Integer.parseInt(request.getParameter("qty"));
			double price = Double.parseDouble(request.getParameter("price"));
			String dt = request.getParameter("date");
			LocalDate date = LocalDate.parse(dt,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			int cid = Integer.parseInt(request.getParameter("CID"));
			
			ProductServices pserv = new ProductServiceImpl();

			Product p = new Product(id,name,qty,price,date,cid);
			
			boolean status = pserv.updateProduct(p);
			if(status) {
				RequestDispatcher rd = request.getRequestDispatcher("showprods");
				rd.forward(request, response);
			}
		}else {
			out.println("<h2>Please login in the app</h2>");
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			rd.include(request, response);
		}
	}

}
