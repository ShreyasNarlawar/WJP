package com.demo.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/calTax")
public class calculateTax extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public calculateTax() {
        super();
        }

	public void init(ServletConfig config) throws ServletException {
		
	}
	

	
	public void destroy() {
		}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
