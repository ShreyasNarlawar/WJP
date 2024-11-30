package com.demo.test;

import java.util.List;
import java.util.Scanner;

import com.demo.beans.Product;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;

public class TestCRUD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ProductService pserv = new ProductServiceImpl();
		int ch = 0;
		do {
			System.out.println("1.Add new product \n2.Display All Product\n3.Delete By Id");
			System.out.println("4.Update By Id \n5.search by Id \n6.Sort By Name\n7.Exit");
			System.out.println("Choice :");
			ch = sc.nextInt();
			switch(ch) {
			case 1 :
					boolean status = pserv.addNewProduct();
					 if(status)
						 System.out.println("Product added Successfully");
					 else
						 System.out.println("Error Occured");
					break;
			
			case 2: 
					List<Product> plist = pserv.getAllProducts();
					plist.forEach(System.out::println);
					break;

			case 3: 
					System.out.println("Enter id to delete");
					int id = sc.nextInt();
					status = pserv.DeleteById(id);
					 if(status)
						 System.out.println("Product deleted Successfully");
					 else
						 System.out.println("Error Occured");
					break;
					
			case 4:	
					System.out.println("Enter id for update");
					id = sc.nextInt();
					System.out.println("Enter name");
					String name = sc.next();
					System.out.println("Enter qty");
					int qty = sc.nextInt();
					System.out.println("Enter price");
					double price = sc.nextDouble();
					status = pserv.UpdateById(id,name,qty,price);
					 if(status)
						 System.out.println("Product updated Successfully");
					 else
						 System.out.println("Error Occured");
					 break;
					 
			case 5: 
					System.out.println("Enter Id to search :");
					id=sc.nextInt();
					Product p= pserv.SearchId(id);
					if(p != null)
					System.out.println(p);
					else
						System.out.println("Product not Found..");
					break;

			case 6:
					List<Product> ls = pserv.sortByNames();
					if(ls!=null)
						ls.forEach(System.out::println);
					else
						System.out.println("No data found..");
					break;
			
			case 7:
					System.out.println("Thanks For Visiting..");
					sc.close();
					pserv.closeSessionFact();
					break;
			
			default:
					System.out.println("Invalid Input..");
			}
					
		}while(ch!=7);

	}

}
