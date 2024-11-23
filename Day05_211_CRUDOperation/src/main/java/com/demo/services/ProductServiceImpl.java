package com.demo.services;

import com.demo.dao.ProductDao;
import com.demo.dao.ProductDaoImpl;

public class ProductServiceImpl implements ProductServices{
	
	private ProductDao pdao;

	public ProductServiceImpl() {
		super();
		pdao = new ProductDaoImpl();
	}
	
	
	
}
