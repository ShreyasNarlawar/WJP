package com.demo.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class TestPreparedStatement2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Scanner sc = new Scanner(System.in);
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			
			String url = "jdbc:mysql://192.168.10.127:3306/dac86?useSSL=false";
			
			Connection cnn = DriverManager.getConnection(url,"dac86","welcome");
			if(cnn != null)
				System.out.println("connected");
			else
				System.out.println("not connected");
			
//			PreparedStatement pst = cnn.prepareStatement("select * from student");
//			
//			ResultSet rs = pst.executeQuery();
//			
//			System.out.println();
//			while(rs.next()) {
//				
//				System.out.println("ID :"+rs.getInt(1));
//				System.out.println("First Name :"+rs.getString(2));
//				System.out.println("Last Name :"+rs.getString(3));
//				System.out.println("DOB :"+rs.getDate(4));
//				System.out.println("Email ID :"+rs.getString(5));
//				
//				System.out.println("---------------------------------");
//			}
			
			int id = sc.nextInt();
			sc.next();
			String firstname = sc.nextLine();
			String lastname = sc.nextLine();
			LocalDate dt = DateTimeFormatter;
			
			
			PreparedStatement pst = cnn.prepareStatement("select * from student where ?,?,?,?,?");
			pst.setInt(1, id);
			pst.setString(2, firstname);
			pst.setString(3, lastname);
			pst.setString(4,dt);
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
