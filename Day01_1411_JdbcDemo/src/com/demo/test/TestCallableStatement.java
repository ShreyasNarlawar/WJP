package com.demo.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.CallableStatement;
public class TestCallableStatement {

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
			
			CallableStatement cst = conn.prepareCall("call getcnt(?,?)");
			cst.setInt(1,22);
			cst.registerOutParameter(2, java.sql.Types.INTEGER);
			cst.execute();
			
			int cnt = cst.getInt(2);
			System.out.println("Count :"+ cnt);
			
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
