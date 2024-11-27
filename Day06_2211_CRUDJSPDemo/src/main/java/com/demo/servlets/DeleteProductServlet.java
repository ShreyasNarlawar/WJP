package com.demo.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.demo.services.*;


@WebServlet("/deleteprods")
public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int pid  = Integer.parseInt(request.getParameter("pid"));
		
		ProductService pserv = new ProductServiceImpl();
		pserv.deleteById(pid);
		
		RequestDispatcher rd = request.getRequestDispatcher("showprods");
		rd.forward(request, response);
		
		
		
	}

}
