package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.beans.Product;

public class ProductDaoImpl implements ProductDao{
	
	static Connection cnn;
	static PreparedStatement padd, prem, psel, pall,pupd;
	static {
		try {
			cnn = DBConnection.getMyConnection();
			padd = cnn.prepareStatement("insert into product values(?,?,?,?,?.?)");
			prem = cnn.prepareStatement("delete from product where pid = ?");
			psel = cnn.prepareStatement("select * from product where pid =?");
			pall = cnn.prepareStatement("select * from product");
			pupd = cnn.prepareStatement("update product set pname =?, qty=?, price=?, expdate=?, cid=? where pid = ?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public boolean addNewProduct(Product p) {
		// TODO Auto-generated method stub
		try {
			padd.setInt(1, p.getPid());
			padd.setString(2, p.getPname());
			padd.setInt(3, p.getQty());
			padd.setDouble(4, p.getPrice());
			padd.setDate(5, java.sql.Date.valueOf(p.getExpdate()));
			padd.setInt(6,p.getCid());
			
			int i = padd.executeUpdate();
			
			if(i > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	@Override
	public boolean removeById(int pid) {
		// TODO Auto-generated method stub
		try {
			prem.setInt(1, pid);
			int n = prem.executeUpdate();
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
	public Product getById(int pid) {
		// TODO Auto-generated method stub
		try {
			psel.setInt(1, pid);
			ResultSet rs = psel.executeQuery();
			if(rs.next()) {
				return new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4),rs.getDate(5).toLocalDate(),rs.getInt(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	@Override
	public List<Product> showAllProducts() {
		// TODO Auto-generated method stub
		try {
			List <Product> plist  = new ArrayList<>();
			ResultSet rs = pall.executeQuery();
			
			while(rs.next()) {
				plist.add(new Product(rs.getInt(1),rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getDate(5).toLocalDate(), rs.getInt(6)));
			}
			if(plist.size()> 0) {
				return plist;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public boolean updateProduct(Product p) {
		// TODO Auto-generated method stub
		try {
			pupd.setInt(1, p.getPid());
			pupd.setString(2, p.getPname());
			pupd.setInt(2, p.getQty());
			pupd.setDouble(2, p.getPrice());
			pupd.setDate(2, java.sql.Date.valueOf(p.getExpdate()));
			pupd.setInt(2, p.getCid());
			
			int c = pupd.executeUpdate();
			if(c > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
}
