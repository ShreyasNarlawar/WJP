package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.demo.beans.User;

public class LoginDaoImpl implements LoginDao{
	
	static Connection cnn;
	static PreparedStatement psel;
	
	static {
		try {
			cnn = DBConnection.getMyConnection();
			psel = cnn.prepareStatement("select username, password, role from user where username=? and password=?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public User authenticateUser(String username, String password) {
		// TODO Auto-generated method stub
		try {
			psel.setString(1, username);
			psel.setString(2, password);
			
			ResultSet rs = psel.executeQuery();
			if(rs.next()) {
				return new User(rs.getString(1),rs.getString(2),rs.getString(3)) ;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
