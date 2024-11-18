package com.demo.services;

import java.util.List;

import com.demo.beans.Product;

public interface ProductService {

	boolean addNewProduct();

	boolean deleteProduct(int id);

	boolean updateProduct();

	List<Product> showAllProduct();

	Product searchProduct();

	List<Product> sortByProductName();

	void closeConnection();

}
