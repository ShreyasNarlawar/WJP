package com.demo.services;

import java.util.List;

import com.demo.beans.Product;
import com.demo.dao.ProductDao;
import com.demo.dao.ProductDaoImpl;

public class ProductServiceImpl implements ProductServices{
	
	private ProductDao pdao;

	public ProductServiceImpl() {
		super();
		pdao = new ProductDaoImpl();
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return pdao.showAllProducts();
	}

	@Override
	public boolean addNewProduct(Product p) {
		// TODO Auto-generated method stub
		return pdao.insertNewProduct(p);
	}

	@Override
	public boolean updateProduct(Product p) {
		// TODO Auto-generated method stub
		return pdao.updateProduct(p);
	}

	@Override
	public Product getById(int pid) {
		// TODO Auto-generated method stub
		return pdao.getProductById(pid);
	}

	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		return pdao.deleteProductById(id);
	}
	
	
	
}
