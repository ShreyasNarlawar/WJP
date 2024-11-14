package com.demo.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class TestPreparedStatement {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Connection conn = null;
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String url = "jdbc:mysql://192.168.10.127:3306/dac86?useSSL=false";
			conn = DriverManager.getConnection(url,"dac86","welcome");
			
			if(conn != null)
				System.out.println("connected");
			else
				System.out.println("not connected");
			
			PreparedStatement pst = conn.prepareStatement("select * from product");
			ResultSet rs = pst.executeQuery();
		
			System.out.println("PID\t|\t\t PDesc \t\t|\t Price");
			System.out.println("-------------------------------------------------------------");
			while(rs.next())
				System.out.println(rs.getInt(1)+"\t|\t"+rs.getString(2)+"\t|\t"+rs.getDouble(3));
			
			System.out.println("\n\n\n\t Enter how many products you want to add :");
			int total = sc.nextInt();
			
			
			int cnt=0;
			for(int i=1;i<=total;i++) {
				System.out.println("Enter Product Id :");
				int id=sc.nextInt();
				sc.nextLine();
				System.out.println("Enter Product Description :");
				String Pdesc=sc.nextLine();
				System.out.println("Enter Product Price :");
				double price=sc.nextDouble();
				
				PreparedStatement pst1=conn.prepareStatement( "insert into product values(?,?,?)");
				pst1.setInt(1, id);
				pst1.setString(2, Pdesc);
				pst1.setDouble(3, price);
				cnt=pst1.executeUpdate();
			}
			if(cnt>0)
				System.out.println("updated "+cnt+"rows..");
			else
				System.out.println("error occured..");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
