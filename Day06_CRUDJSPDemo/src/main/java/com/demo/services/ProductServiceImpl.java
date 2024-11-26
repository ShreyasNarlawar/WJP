package com.demo.services;


import java.util.List;

import com.demo.beans.Product;

import com.demo.dao.ProductDao;
import com.demo.dao.ProductDaoImpl;

public class ProductServiceImpl implements ProductService {
	
	private ProductDao pdao;
	
	public  ProductServiceImpl() {
		pdao = new ProductDaoImpl();
	}
	

	@Override
	public boolean addNewProduct(Product p) {
		return pdao.addNewProduct(p);
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean deleteById(int pid) {
		// TODO Auto-generated method stub
		return pdao.removeById(pid);
	}


	@Override
	public Product getById(int pid) {
		// TODO Auto-generated method stub
		return pdao.getById(pid);
	}


	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return pdao.showAllProducts();
	}


	@Override
	public boolean updateProduct(Product p) {
		// TODO Auto-generated method stub
		return pdao.updateProduct(p);
	}

}