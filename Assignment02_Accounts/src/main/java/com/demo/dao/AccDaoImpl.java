package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccDaoImpl implements AccDao {
	static Connection cnn;
	static PreparedStatement padd,pupd,pdel;
	static {
		try {
			padd = cnn.prepareStatement("insert into accounts values(?,?,?,?)");
			pupd = cnn.prepareStatement("update accounts set name= ?,email=?,balance=? where aid=?");
			pdel = cnn.prepareStatement("delete from accounts where aid=?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public boolean createNewAcc(int aid, String name, String email, double balance) {
		// TODO Auto-generated method stub
		try {
			padd.setInt(1, aid);
			padd.setString(2, name);
			padd.setString(3, email);
			padd.setDouble(4, balance);
			int n = padd.executeUpdate();
			if(n > 0) {
				return true;
			}	 	 	
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean updateAccount(int id, String name, String email, double balance) {
		// TODO Auto-generated method stub
		try {
			pupd.setString(1, name);
			pupd.setString(2, email);
			pupd.setDouble(3,balance);
			pupd.setInt(4, id);
			
			int n = pupd.executeUpdate();
			if(n > 0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		
		return false;
	}

}
