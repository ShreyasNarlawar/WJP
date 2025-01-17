package com.demo.beans;

import java.time.LocalDate;

public class Product {
	private int pid;
	private String pname;
	private int pqty;
	private double price;
	private LocalDate expdate;
	
	public Product() {
		super();
	}

	public Product(int pid, String pname, int pqty, double price, LocalDate expdate) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pqty = pqty;
		this.price = price;
		this.expdate = expdate;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getPqty() {
		return pqty;
	}

	public void setPqty(int pqty) {
		this.pqty = pqty;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDate getExpdate() {
		return expdate;
	}

	public void setExpdate(LocalDate expdate) {
		this.expdate = expdate;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", pqty=" + pqty + ", price=" + price + ", expdate="
				+ expdate + "]";
	}
	
	
	
}
