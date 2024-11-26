package com.demo.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.demo.beans.Product;
import com.demo.beans.User;
import com.demo.services.ProductService;
import com.demo.services.ProductServiceImpl;

@WebServlet("/addProduct")
public class addProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int pid = Integer.parseInt(request.getParameter("pid"));
		String pname = request.getParameter("pname");
		int qty = Integer.parseInt(request.getParameter("qty"));
		double price = Double.parseDouble(request.getParameter("price"));
		String dt = request.getParameter("expdate");
		LocalDate date = LocalDate.parse(dt,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		int cid = Integer.parseInt(request.getParameter("cid"));
		
		Product p = new Product(pid,pname,qty,price,date,cid);
		
		ProductService pserv = new ProductServiceImpl();
		pserv.addNewProduct(p);
		RequestDispatcher rd = request.getRequestDispatcher("showprods");
		rd.forward(request, response);
	}

}
