package com.demo.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.demo.beans.Product;
import com.demo.services.ProductServices;
import com.demo.services.ProductServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet("/showprods")
public class showprods extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String s = (String)session.getAttribute("role");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		ProductServices pserv = new ProductServiceImpl();
		List <Product> plist = pserv.getAllProducts();
		if(plist != null) {
			out.println("<table border='2><tr> <th>Product Id</th> <th>Name</th> <th>Qty</th> <th>Price</th> <th>Date</th> </th>cid>");
			
			for(Product p : plist) {
				out.println("<tr><td>"+p.getPid() +"</td> <td>"+p.getPname() +"</td> <td>"+p.getQty() +"</td> <td>"+p.getPrice()+"</td>");
				String dt = p.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				
				out.println(" <td>"+dt +"</td> <td>"+p.getCid() +"</td>");
				
				out.println("<td><a href='editprod ?pid ='"+p.getPid() +"'>edit</a> / <a href='deleteprod ?pid = "+p.getPid()+"'>delete</a></td> </tr>");
				
				out.print("</table>");
				
				out.println("<form action='addprods.html'>");
				
				out.println("<button type ='submit' id = 'btn' value = 'add' name ='btn'>Add new product</button>");
				
				out.println("</form>");
				
				out.println("<a href ='logout'>Logout</a>");
				
			}
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			rd.forward(request, response);
		}
	}

}
