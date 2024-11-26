package com.demo.dao;

import java.util.List;

import com.demo.beans.Product;

public interface ProductDao {

	List<Product> showAllProducts();

	boolean insertNewProduct(Product p);

	boolean updateProduct(Product p);

	Product getProductById(int pid);

	boolean deleteProductById(int id);

	
}
