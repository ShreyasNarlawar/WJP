package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static Connection cnn = null;
public static Connection getConnection() {
	try {
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		String url = "jdbc:mysql://192.168.10.127:3306/dac86";
		cnn = DriverManager.getConnection(url,"dac86","welcome");
		if(cnn!=null)
			System.out.println("Connected SuccessFully.");
		else
			System.out.println("Didn't Connected..");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return cnn;
}
public static void closeMyConnection() {
	if(cnn!=null)
		try {
			cnn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
}
}