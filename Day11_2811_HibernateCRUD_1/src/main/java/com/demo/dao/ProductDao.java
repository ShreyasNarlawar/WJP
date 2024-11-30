package com.demo.dao;

import java.util.List;

import com.demo.beans.Product;

public interface ProductDao {

	boolean save(Product p);

	List<Product> displayAll();

	boolean deleteById(int id);

	boolean updateById(int id, String name, int qty, double price);

	Product searchId(int id);

	List<Product> sortByName();

	void shutdown();

}
