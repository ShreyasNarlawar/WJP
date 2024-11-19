package com.demo.test;

import java.util.List;
import java.util.Scanner;

import com.demo.beans.Product;
import com.demo.beans.User;
import com.demo.services.LoginServImpl;
import com.demo.services.LoginService;
import com.demo.services.ProductService;
import com.demo.services.ProductServiceImpl;


public class TestProduct {

  public static void main(String[] args) {
	  
	  Scanner sc = new Scanner(System.in);
	  System.out.println("Enter username");
	  String username = sc.next();
	  System.out.println("Enter password");
	  String password = sc.next();
	  
	  LoginService lserv = new LoginServImpl();
	  User user = lserv.authenticateUser(username, password);
	  
	 ProductService pserv = new ProductServiceImpl();
	  int ch = 0;
	  if(user != null && user.getPasswd().equals("admin")) {
		  
		  do {
			  System.out.println("1.Add new Product \n2.Delete Prodcut \n3.Update product");
			  System.out.println("4.Display All \n5.Find by id \n6.Sort by product name");
			  System.out.println("7.Exit \nChoice : ");
			  ch = sc.nextInt();
			  
			  switch(ch) {
				  case 1 ->{
					  boolean status = pserv.addNewProduct();
					  if(status)
						  System.out.println("Product added Successfully..");
					  else
						  System.out.println("Error Occured..");
				  }
				  case 2->{
					  System.out.println("Enter the product id :");
					  int prodid = sc.nextInt();
					  boolean status = pserv.deleteProduct(prodid);
					  if(status)
						  System.out.println("Product deleted successfully..");
					  else
						  System.out.println("Not Found");
				  }
				  case 3->{
					  boolean status = pserv.updateProduct();
					  if(status)
						  System.out.println("Product Updated successfully..");
					  else
						  System.out.println("Not Found");
				  }
				  case 4->{
					  List<Product> plist = pserv.showAllProduct();
					  if(plist!=null)
						  plist.stream().forEach(System.out::println);
					  else
						  System.out.println("Error Occured..");
				  }
				  case 5->{
					  pserv.searchProduct();
				  }
				  case 6 ->{
					  List <Product> plst = pserv.sortByProductName();
					  if(plst==null)
						  System.out.println("Error Occured..");
					  else
						  plst.stream().forEach(System.out::println);
				  }
				  case 7->{
					  System.out.println("THank You so much for Visiting..");
					  pserv.closeConnection();
				  }
			}
		  }while(ch != 7);
	  }
  }
}
