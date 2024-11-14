package com.demo.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TestCreateStatement {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			
			String url = "jdbc:mysql://192.168.10.127:3306/dac86?useSSL=false";
			
			Connection conn = DriverManager.getConnection(url,"dac86","welcome");
			
			if(conn != null)
				System.out.println("Connected...");
			else
				System.out.println("Can't Connect...");
			
			Statement st = conn.createStatement();
			String query="select * from product;";
			ResultSet rs = st.executeQuery(query);
			System.out.println(query);
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
				sc.next();
				System.out.println("Enter Product Description :");
				String Pdesc=sc.next();
				System.out.println("Enter Product Price :");
				double price=sc.nextDouble();
				
				String query2 = "insert into product values("+id+",'"+Pdesc+"',"+price+")";
				cnt=st.executeUpdate(query2);
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
