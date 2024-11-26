package com.demo.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.demo.beans.Product;
import com.demo.services.*;

@WebServlet("/editprods")
public class EditProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 int pid = Integer.parseInt(request.getParameter("pid"));	
		 
		 ProductService pserv = new ProductServiceImpl();
		 
		 Product p = pserv.getById(pid);
		 
		 request.setAttribute("prod", p);
		 
		 RequestDispatcher rd = request.getRequestDispatcher("updateform.jsp");
		 rd.forward(request, response);
		 
		 
	}

}
