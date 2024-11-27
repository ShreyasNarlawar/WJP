package com.demo.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product1")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int pid;
	private String pname;
	private int qty;
	private double price;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int pid, String pname, int qty, double price) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.qty = qty;
		this.price = price;
		
	}
	public Product(String pname, int qty, double price) {
		super();
		this.pname = pname;
		this.qty = qty;
		this.price = price;
	}
	
}
