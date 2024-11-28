package com.demo.dao;

import java.util.List;

import com.demo.beans.Category;
import com.demo.beans.Product;

public interface ProductDao {

	Product findById(int p);

	List<Category> getAllCat();

	List<Product> getAllProd(int cid);

}
