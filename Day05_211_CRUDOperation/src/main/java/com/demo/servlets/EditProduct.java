package com.demo.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.demo.services.ProductServices;
import com.demo.beans.Product;
import com.demo.services.ProductServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/EditProduct")
public class EditProduct extends HttpServlet {
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
			Product p = pserv.getById(id);
			
			if(p != null) {
				out.println("<form action = 'UpdateServlet'>");
				out.println("Product Id :<input type='text' name='pid' id='pid' values='"+p.getPid()+"'readonly>");
				out.println("Product Name :<input type='text' name='pname' id='pname' values='"+p.getPname()+"'>");
				out.println("Quantity :<input type='text' name='qty' id='qty' values='"+p.getQty()+"'>");
				out.println("Price :<input type='text' name='price' id='price' values='"+p.getPrice()+"'>");
				out.println("Expiry Date :<input type='text' name='Date' id='date' values='"+p.getDate()+"'>");
				out.println("Cid :<input type='text' name='cid' id='cid' values='"+p.getCid()+"'>");
				
				out.println("<button type= 'submit' id='btn' name='btn'value ='add'>Update Product</button>");
				
				out.println("</form> <br>");
				out.println("<a href='logout'>Logout</a>");
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("showprods");
				rd.forward(request, response);
			}
 		
		}else {
			out.println("<h2>Please login to app</h2>");
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			rd.include(request, response);
		}
	}

}
