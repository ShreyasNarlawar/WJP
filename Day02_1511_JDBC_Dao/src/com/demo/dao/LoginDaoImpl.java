package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.demo.beans.User;

public class LoginDaoImpl implements LoginDao{
	private static Connection cnn;
	private static PreparedStatement ps1;
	static {
		cnn=DBConnection.getConnection();
		try {
			ps1=cnn.prepareStatement("select uname , role from user where uname = ? and passwd = ?");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public User validateUser(String username, String password) {
		// TODO Auto-generated method stub
		try {
			ps1.setString(1, username);
			ps1.setString(2, password);
			
			ResultSet rs = ps1.executeQuery();
			
			if(rs.next())
				return new User(rs.getString(1), rs.getString(2), rs.getString(3));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}
}
