package com.demo.dao;

import java.util.List;

import com.demo.beans.Product;

public interface ProductDao {

	boolean addNewProduct(Product p);

	boolean removeById(int pid);

	Product getById(int pid);

	List<Product> showAllProducts();

	boolean updateProduct(Product p);

}
