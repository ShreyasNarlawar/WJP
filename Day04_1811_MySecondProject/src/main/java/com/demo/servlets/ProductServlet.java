package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.demo.beans.Product;
import com.demo.services.ProductService;
import com.demo.services.ProductServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ProductServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		ProductService pserv = new ProductServiceImpl();
		List<Product> plist = pserv.SagleProducts();
		
		if(plist != null) {
			out.println("<tr><th>Product Id</th><th>Name</th><th>Qty</th><th>price</th><th>expiry date</th><th>Actions</th></tr>");
			for(Product p:plist) {
				out.print("<table>");
				out.println("<tr><td>"+p.getPid()+"</td><td>"+p.getPname()+"</td><td>"+p.getPqty()+"/td><td>"+p.getPrice()+"</td>");
				String dt=p.getExpdate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				out.println("<td>"+dt+"</td><td>");
				out.println("<td><a href='#'>edit</a>/<a href='#'>delete</a></td></tr>");
				out.print("</table>");
				out.println("<form action='allProducts.html'>");
				out.println("<button type='submit' name='btn' id='btn' value='add'>Add new Product</button>");
				out.println("</form>");
			}
		}
	}
}
	
