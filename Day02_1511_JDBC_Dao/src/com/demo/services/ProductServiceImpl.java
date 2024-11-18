package com.demo.services;
import java.util.List;
import java.util.Scanner;

import com.demo.beans.Product;
import com.demo.dao.ProductDao;

public class ProductServiceImpl implements ProductService{
	private ProductDao pdao;
	
	Scanner sc= new Scanner(System.in);
	@Override
	public boolean addNewProduct() {
		
		System.out.println("Enter Product Id :");
		int pid = sc.nextInt();
		System.out.println("Enter Product Name :");
		String pname=sc.next();
		System.out.println("Enter Price :");
		double price=sc.nextDouble();
		
		Product p = new Product(pid,pname,price);
		return pdao.save(p);
	}
	@Override
	public boolean deleteProduct(int id) {
		return pdao.delete(id);
	}
	@Override
	public boolean updateProduct() {
		System.out.println("Enter Product Id :");
		int pid = sc.nextInt();
		System.out.println("Enter Product New Name :");
		String pname=sc.nextLine();
		System.out.println("Enter Product new Price :");
		double price = sc.nextDouble();
		
		Product p = new Product(pid,pname,price);
		return pdao.updateDetails(p);
	}
	@Override
	public List<Product> showAllProduct() {
		return pdao.showProducts();
	}
	@Override
	public Product searchProduct() {
		  System.out.println("Enter the product id :");
		  int id = sc.nextInt();
		  return pdao.searchProduct(id);
	}
	@Override
	public List<Product> sortByProductName() {
		// TODO Auto-generated method stub
		System.out.println("Enter Product Name :");
		String pname = sc.nextLine();
		return pdao.sortByName(pname);
	}
	@Override
	public void closeConnection() {
		pdao.closeMyConnection();
		
	}
	
}
