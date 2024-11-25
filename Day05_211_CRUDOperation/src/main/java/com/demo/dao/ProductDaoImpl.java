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
	static PreparedStatement psel,padd,pupd,pget,pdel;
	static {
		
		try {
			Connection cnn= DBConnection.getMyConnection();
			psel = cnn.prepareStatement("select * from product");
			padd = cnn.prepareStatement("insert into product values (?,?,?,?,?,?)");
			pupd = cnn.prepareStatement("update product set pname = ?, qty=?,price=?,date=?,cid =? where pid = ? ");
			pget = cnn.prepareStatement("select * from prodcut where pid = ?");
			pdel = cnn.prepareStatement("delete from product where pid = ?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Product> showAllProducts() {
		// TODO Auto-generated method stub
		List<Product> plist = new ArrayList<>();
		try {
			ResultSet rs = psel.executeQuery();
			while(rs.next()) {
				plist.add(new Product (rs.getInt(1), rs.getString(2), rs.getInt(3),rs.getDouble(4),rs.getDate(5).toLocalDate(), rs.getInt(6)));
			}
			
			if(plist.size() > 0) {
				return plist;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean insertNewProduct(Product p) {
		// TODO Auto-generated method stub
		try {
			padd.setInt(1, p.getPid());
			padd.setString(1, p.getPname());
			padd.setInt(1, p.getQty());
			padd.setDouble(1, p.getPrice());
			padd.setDate(1, java.sql.Date.valueOf(p.getDate()));
			padd.setInt(1, p.getCid());
			
			int i  = padd.executeUpdate();
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
	public boolean updateProduct(Product p) {
		// TODO Auto-generated method stub
		try {
			pupd.setString(1, p.getPname());
			pupd.setInt(1, p.getQty());
			pupd.setDouble(1, p.getPrice());
			pupd.setDate(1, java.sql.Date.valueOf(p.getDate()));
			pupd.setInt(1, p.getCid());
			
			int i = pupd.executeUpdate();
			if(i > 0) 
				return true;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public Product getProductById(int pid) {
		// TODO Auto-generated method stub
		try {
			pget.setInt(1, pid);
			ResultSet rs = pget.executeQuery();
			
			while(rs.next()) {
				return new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4),rs.getDate(5).toLocalDate(),rs.getInt(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean deleteProductById(int id) {
		// TODO Auto-generated method stub
		try {
			pdel.setInt(1, id);
			int rs = pdel.executeUpdate();
			
			if(rs > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
