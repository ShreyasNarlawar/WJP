package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/calculate")
public class CalculateServlet extends HttpServlet{

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		int num1 = Integer.parseInt(req.getParameter("num1"));
		int num2 = Integer.parseInt(req.getParameter("num2"));
		
		String button = req.getParameter("btn");
		switch(button) {
			case "add":
				out.println("<h1>Addition : "+(num1 + num2)+" </h1>");
				break;
			case "sub":
				out.println("<h1>Substration :"+(num1 - num2)+"</h1>");
				break;
			case "multi":
				out.println("<h1>Multiplication :"+(num1 * num2)+"</h1>");
				break;
			case "div":
				out.println("<h1>Division :"+(num1 / num2)+"</h1>");
				break;
		}
		
		
	}
}
