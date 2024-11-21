package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.demo.beans.Person;
import com.demo.beans.User;

public class LoginDaoImpl implements LoginDao {
	static Connection conn;
	static PreparedStatement seluser,reguser,addPerson;
	static{
		conn = DBConnection.getMyConnection();
		try {
			seluser = conn.prepareStatement("select * from User where username = ? and password = ?");
			reguser = conn.prepareStatement("insert into user (uname,password,role)(?,?,?)");
			addPerson = conn.prepareStatement("insert into Person values(?,?,?,?,?,?) ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public User CheckUser(String uname, String passwd) {
		try {
			seluser.setString(1, uname);
			seluser.setString(2,passwd);
			
			ResultSet rs = seluser.executeQuery();
			if(rs.next())
				return new User(rs.getString(1), rs.getString(2),rs.getString(3));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	@Override
	public boolean registersathi(User u1, Person p1) {
		try {
			reguser.setString(1,u1.getUsername());
			reguser.setString(2,u1.getPassword());
			reguser.setString(3,u1.getRole());
			reguser.executeUpdate();
			
			addPerson.setString(1,p1.getFname());
			addPerson.setString(2,p1.getLname());
			addPerson.setString(3,p1.getGender());
			addPerson.setString(4,p1.getDegree());
			addPerson.setString(5,p1.getCity());
			addPerson.setString(6,String.join(",",p1.getSkills()));
			addPerson.executeUpdate();
			conn.commit();
			return true;
			
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		finally {
			try {
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}return false;
	}

}
