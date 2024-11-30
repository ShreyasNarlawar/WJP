package com.demo.service;

import java.util.List;

import com.demo.beans.Product;

public interface ProductService {

	boolean addNewProduct();

	List<Product> getAllProducts();

	boolean DeleteById(int id);

	boolean UpdateById(int id, String name, int qty, double price);

	Product SearchId(int id);

	List<Product> sortByNames();

	void closeSessionFact();

}
