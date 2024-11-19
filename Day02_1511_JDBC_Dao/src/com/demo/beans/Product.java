package com.demo.beans;

public class Product {
	private int prodid;
	private String descrip;
	private double price;
	public Product() {
		super();
	}
	public Product(int prodid, String descrip, double price) {
		super();
		this.prodid = prodid;
		this.descrip = descrip;
		this.price = price;
	}
	public int getprodid() {
		return prodid;
	}
	public void setprodid(int prodid) {
		this.prodid = prodid;
	}
	public String getdescrip() {
		return descrip;
	}
	public void setPname(String descrip) {
		this.descrip = descrip;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "\t" + prodid + "\t\t"+ descrip + "\t\t" + price +"\n";
	}
}

