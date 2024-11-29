package com.demo.service;

import java.util.List;

import com.demo.beans.Category;
import com.demo.beans.Product;
import com.demo.dao.ProductDao;
import com.demo.dao.ProductDaoImpl;

public class ProductServiceImpl implements ProductService {
	private ProductDao pdao;
	
	public ProductServiceImpl() {
		pdao = new ProductDaoImpl();
	}
	@Override
	public Product getById(int p) {
		// TODO Auto-generated method stub
		
		return pdao.findById(p);
	}
	@Override
	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		return pdao.getAllCat();
	}
	@Override
	public List<Product> getAllProducts(int cid) {
		// TODO Auto-generated method stub
		return pdao.getAllProd(cid);
	}

}
