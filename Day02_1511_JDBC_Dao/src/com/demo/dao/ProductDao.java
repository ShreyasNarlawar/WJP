package com.demo.dao;

import java.util.List;

import com.demo.beans.Product;

public interface ProductDao {

	boolean save(Product P);

	boolean delete(int prodid);

	boolean updateDetails(Product p);

	List<Product> showProducts();

	Product searchProduct(int prodid);

	List<Product> sortByName(String descrip);

	void closeMyConnection();

}
