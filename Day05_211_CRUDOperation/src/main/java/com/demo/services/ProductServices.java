package com.demo.services;

import java.util.List;

import com.demo.beans.Product;

public interface ProductServices {

	List<Product> getAllProducts();

	boolean addNewProduct(Product p);

	boolean updateProduct(Product p);

	Product getById(int id);

	boolean deleteById(int id);

}
