package com.demo.service;

import java.util.List;
import java.util.Scanner;

import com.demo.beans.Product;
import com.demo.dao.ProductDao;
import com.demo.dao.ProductDaoImpl;

public class ProductServiceImpl implements ProductService {
	Scanner sc = new Scanner(System.in);
	private ProductDao pdao;
	
	public ProductServiceImpl() {
		super();
		pdao = new ProductDaoImpl();
	}


	@Override
	public boolean addNewProduct() {
		// TODO Auto-generated method stub
		System.out.println("Enter product name ");
		String name = sc.next();
		System.out.println("Enter price");
		int price = sc.nextInt();
		System.out.println("Enter Quantity ");
		int qty = sc.nextInt();
		Product p = new Product(name,price,qty);
		
		return pdao.save(p);
	}


	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return pdao.displayAll();
	}


	@Override
	public boolean DeleteById(int id) {
		// TODO Auto-generated method stub
		return pdao.deleteById(id);
	}


	@Override
	public boolean UpdateById(int id,String name, int qty, double price) {
		// TODO Auto-generated method stub
		return pdao.updateById(id,name,qty,price);
	}


	@Override
	public Product SearchId(int id) {
		// TODO Auto-generated method stub
		return pdao.searchId(id);
	}


	@Override
	public List<Product> sortByNames() {
		// TODO Auto-generated method stub
		return pdao.sortByName();
	}


	@Override
	public void closeSessionFact() {
		// TODO Auto-generated method stub
		pdao.shutdown();
	}

}
