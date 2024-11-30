package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.demo.beans.Product;
import com.demo.service.*;

@WebServlet("/getProducts")
public class FindProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		ProductService pserv = new ProductServiceImpl();
		int cid = Integer.parseInt(request.getParameter("cid"));
		List<Product> plist = pserv.getAllProducts(cid);
		if(plist != null) {
			request.setAttribute("plist", plist);
			RequestDispatcher rd = request.getRequestDispatcher("showproduct.jsp");
			rd.forward(request, response);
		}else {
			out.println("Please select new Category!! No product Found");
			RequestDispatcher rd= request.getRequestDispatcher("categories");
			rd.include(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
