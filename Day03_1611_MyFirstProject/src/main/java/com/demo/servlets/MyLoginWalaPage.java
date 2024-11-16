package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MyLoginWalaPage extends HttpServlet {
   
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        
        String uname = req.getParameter("uname");
        String passwd = req.getParameter("passwd");
        
        if (uname != null && passwd != null && "admin".equals(uname) && "admin".equals(passwd)) {
            out.println("<h1>Login successfully..</h1>");
        } else {
            out.println("<h1>Invalid Credentials..</h1>");
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        doPost(req, res);
    }
}