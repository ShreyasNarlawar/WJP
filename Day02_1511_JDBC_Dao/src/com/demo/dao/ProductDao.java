package com.demo.dao;

import java.util.List;

import com.demo.beans.Product;

public interface ProductDao {

	boolean save(Product P);

	boolean delete(int id);

	boolean updateDetails(Product p);

	List<Product> showProducts();

	Product searchProduct(int id);

	List<Product> sortByName(String pname);

	void closeMyConnection();

}
