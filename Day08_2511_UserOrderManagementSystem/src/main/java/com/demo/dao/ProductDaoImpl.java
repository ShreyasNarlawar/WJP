package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.beans.Category;
import com.demo.beans.Product;

public class ProductDaoImpl implements ProductDao {
	static Connection con;
	static PreparedStatement selCategory,selProduct,selById; 
	static {
		try {
			con=DBConnection.getMyConnection();
			selCategory = con.prepareStatement("select * from category");
			selProduct  = con.prepareStatement("select * from product where cid=?");
			selById     = con.prepareStatement("select * from product where pid=?");
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Product findById(int p) {
		try {
			selById.setInt(1, p);
			ResultSet rs = selById.executeQuery();
			if(rs.next())
				return new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4),rs.getDate(5).toLocalDate(),rs.getInt(6));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Category> getAllCat() {
		try {
			List<Category> clist = new ArrayList<>();
			ResultSet rs = selCategory.executeQuery();
			while(rs.next()) {
				clist.add(new Category(rs.getInt(1),rs.getString(2),rs.getString(3)));
			}
			return clist;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Product> getAllProd(int cid) {		
		try {
			List<Product> plist = new ArrayList<>();
			selProduct.setInt(1, cid);
			ResultSet rs  = selProduct.executeQuery();
			while(rs.next())
				plist.add(new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4),rs.getDate(5).toLocalDate(),rs.getInt(6)));
			if(plist.size()>0)
				return plist;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
