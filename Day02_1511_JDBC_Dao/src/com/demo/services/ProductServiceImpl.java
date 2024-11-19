package com.demo.services;
import java.util.List;
import java.util.Scanner;

import com.demo.beans.Product;
import com.demo.dao.ProductDao;
import com.demo.dao.ProductDaoImpl;

public class ProductServiceImpl implements ProductService{
	private ProductDao pdao;
	
	Scanner sc= new Scanner(System.in);
	
	public ProductServiceImpl() {
		pdao = new ProductDaoImpl();
	}
	
	@Override
	public boolean addNewProduct() {
		
		System.out.println("Enter Product Id :");
		int prodid = sc.nextInt();
		System.out.println("Enter Product Name :");
		String descrip=sc.next();
		System.out.println("Enter Price :");
		double price=sc.nextDouble();
		
		Product p = new Product(prodid,descrip,price);
		return pdao.save(p);
	}
	@Override
	public boolean deleteProduct(int prodid) {
		return pdao.delete(prodid);
	}
	@Override
	public boolean updateProduct() {
		System.out.println("Enter Product Id :");
		int prodid = sc.nextInt();
		System.out.println("Enter Product New Name :");
		String descrip=sc.next();
		System.out.println("Enter Product new Price :");
		double price = sc.nextDouble();
		
		Product p = new Product(prodid,descrip,price);
		return pdao.updateDetails(p);
	}
	@Override
	public List<Product> showAllProduct() {
		return pdao.showProducts();
	}
	@Override
	public Product searchProduct() {
		  System.out.println("Enter the product id :");
		  int prodid = sc.nextInt();
		  return pdao.searchProduct(prodid);
	}
	@Override
	public List<Product> sortByProductName() {
		// TODO Auto-generated method stub
		System.out.println("Enter Product Name :");
		String descrip = sc.nextLine();
		return pdao.sortByName(descrip);
	}
	@Override
	public void closeConnection() {
		pdao.closeMyConnection();
	}
}
