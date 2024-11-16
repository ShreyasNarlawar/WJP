package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static Connection conn=null;
	public static void main(String[] args) throws SQLException {
	      try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String url="jdbc:mysql://192.168.10.127:3306/dac86?useSSL=false";
			conn=DriverManager.getConnection(url,"dac86","welcome");
			if(conn!=null) {
				System.out.println("Connected");
			}else
				System.out.println("Error");
		   }catch (Exception e) {
			// TODO: handle exception
			   e.printStackTrace();
		}
	}
}