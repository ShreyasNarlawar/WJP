package com.demo.beans;

public class CartItem {
	private int pid;
	private String pname;
	private int ordQty;
	private double price;
	public CartItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CartItem(int pid, String pname, int ordQty, double price) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.ordQty = ordQty;
		this.price = price;
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
	public int getOrdQty() {
		return ordQty;
	}
	public void setOrdQty(int ordQty) {
		this.ordQty = ordQty;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "CartItem [pid=" + pid + ", pname=" + pname + ", ordQty=" + ordQty + ", price=" + price + "]";
	}
	
}
