package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.beans.Person;
import com.demo.beans.Product;
import com.demo.beans.User;

public class LoginDaoImpl implements LoginDao {
	static Connection cnn;
	static PreparedStatement psel,adduser,details ,getall;
	static {
		try {
			cnn = DBConnection.getMyConnection();
			psel = cnn.prepareStatement("select * from user where username=? password=?");
			adduser = cnn.prepareStatement("insert into user(username,password,role) values(?,?,?");
			details = cnn.prepareStatement("insert into person(fname,lname,gender,degree,city,skills) values(?,?,?,?,?,?)");
			getall = cnn.prepareStatement("select * from product");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public boolean saveDetails(Person p1,User u1) {
		// TODO Auto-generated method stub
		try {
			adduser.setString(1, u1.getUname());
			adduser.setString(1, u1.getPassword());
			adduser.setString(1, u1.getRole());
			adduser.executeUpdate();
			details.setString(1, p1.getFname());
			details.setString(2, p1.getLname());
			details.setString(3, p1.getGender());
			details.setString(4, p1.getDegree());
			details.setString(1, p1.getCity());
			details.setString(6,String.join(",", p1.getSkills()));
			details.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}
	@Override
	public User validateUser(String username, String password) {
		// TODO Auto-generated method stub
		try {
			psel.setString(1, username);
			psel.setString(2, password);
			ResultSet rs = psel.executeQuery();
			
			if(rs.next()) {
				return new User(rs.getString(1),rs.getString(2),rs.getString(3));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	

}
