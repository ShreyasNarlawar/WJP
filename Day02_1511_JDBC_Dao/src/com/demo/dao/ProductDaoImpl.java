package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.beans.Product;

public class ProductDaoImpl  implements ProductDao{

	static Connection cnn;
	static PreparedStatement padd,pdel,pupd,psel,psea,psbn;
	static {
		try {
			cnn=DBConnection.getConnection();
			padd=cnn.prepareStatement("insert into product values (?,?,?)");
			pdel=cnn.prepareStatement("delete from product where prodid=?");
			pupd=cnn.prepareStatement("update product set descrip=? , price=? where prodid=?");
			psel=cnn.prepareStatement("select * from Product");
			psea=cnn.prepareStatement("select * from product where prodid=?");
			psbn=cnn.prepareStatement("select * from Product order by descrip asc");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean save(Product P) {
		try {
			padd.setInt(1,P.getprodid());
			padd.setString(2, P.getdescrip());
			padd.setDouble(3, P.getPrice());
			int res=padd.executeUpdate();
			if(res>0)
				return true;
			else
				return false;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean delete(int prodid) {
			try {
				pdel.setInt(1, prodid);
				int res=pdel.executeUpdate();
				if(res>0)
					return true;
				else
					return false;
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return false;
	}
	
	public boolean updateDetails(Product P) {
			try {
				pupd.setString(1, P.getdescrip());
				pupd.setDouble(2,P.getPrice());
				pupd.setInt(3, P.getprodid());
				int res =pupd.executeUpdate();
				if(res>0)
					return true;
				else
					return false;
		
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return false;
	}
	
	public List<Product> showProducts() {
		List <Product>plt= new ArrayList<Product>();
		try {
			ResultSet rs = psel.executeQuery();
			System.out.println( "\tprod id \t Product Name\t\tPrice\n");
			while(rs.next()) {
				Product P = new Product(rs.getInt(1),rs.getString(2),rs.getDouble(3));
				plt.add(P);
			}
			if(plt.size() > 0)
				return plt;	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Product searchProduct(int prodid) {

		try {
			psea.setInt(1,prodid);
			ResultSet rs = psea.executeQuery();
			if(rs.next())	
			return new Product(rs.getInt(1),rs.getString(2),rs.getDouble(3));
			
			} catch (SQLException e) {
				e.printStackTrace();
		}
		return null;
	}
	
	public List<Product> sortByName(String descrip) {
	
		List<Product> plst = new ArrayList<Product>();
		try {
			ResultSet rs = psbn.executeQuery();
			while(rs.next()) {
				Product P = new Product(rs.getInt(1),rs.getString(2),rs.getDouble(3));
				plst.add(P);
			}
			if(plst.size()>0)
				return plst;	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void closeMyConnection() {
		DBConnection.closeMyConnection();
		
	}
}
