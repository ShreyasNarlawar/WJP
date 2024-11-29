package com.demo.service;

import java.util.List;

import com.demo.beans.Category;
import com.demo.beans.Product;

public interface ProductService {

	Product getById(int p);

	List<Category> getAllCategories();

	List<Product> getAllProducts(int cid);

}
