package com.demo.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String url = "jdbc:mysql://192.168.10.127:3306/dac86";
			//String url = "jdbc:mysql://192.168.10.127:3306/dac86?useSSL=false";
			Connection conn = DriverManager.getConnection(url,"dac86","welcome");
			if(conn != null)
				System.out.println("Connected...");
			else
				System.out.println("Can't Connect...");
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
