package com.demo.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.demo.beans.CartItem;
import com.demo.beans.Product;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/addtocart")
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String btn = request.getParameter("btn");
		switch("btn"){
			case "add"->{
					HttpSession session = request.getSession();
					List<CartItem> clist = (List<CartItem>) session.getAttribute("cart");
					if(clist == null)
						clist = new ArrayList<>();
					String[] parr = request.getParameterValues("prod");
					ProductService pserv = new ProductServiceImpl();
					
					for(String p : parr) {
						Product p1 =  pserv.getById(Integer.parseInt(p));
						int ordQty = Integer.parseInt(request.getParameter("p"+p));
						
						if(p1.getQty() > ordQty) {
							CartItem c = new CartItem(p1.getPid(),p1.getPname(),ordQty,p1.getPrice());
							clist.add(c);
						}else {
							CartItem  c = new CartItem(p1.getPid(),p1.getPname(),p1.getQty(),p1.getPrice());
							clist.add(c);
						}
						
						System.out.println(clist);
						session.setAttribute("cart",clist);	
						RequestDispatcher rd = request.getRequestDispatcher("category");
						rd.forward(request, response);
						
					}
				}
			case "show"->{
				RequestDispatcher rd = request.getRequestDispatcher("showprods.jsp");
				rd.forward(request, response);
			}
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
