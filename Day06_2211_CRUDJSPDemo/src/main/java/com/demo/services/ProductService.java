package com.demo.services;

import java.util.List;

import com.demo.beans.Product;

public interface ProductService {

	boolean addNewProduct(Product p);

	boolean deleteById(int pid);

	Product getById(int pid);

	List<Product> getAllProducts();

	boolean updateProduct(Product p);

}
