package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static Connection cnn = null;

	public static Connection getMyConnection() {
		// TODO Auto-generated method stub
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String url = "jdbc:mysql://192.168.10.127";
			cnn = DriverManager.getConnection(url,"dac86","welcome");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return null;
	}

}
