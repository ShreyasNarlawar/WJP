package com.demo.beans;

public class address {
	private int addrid;
	private String state;
	private String city;
	private String pincode;
	
	public address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public address(int addrid, String state, String city, String pincode) {
		super();
		this.addrid = addrid;
		this.state = state;
		this.city = city;
		this.pincode = pincode;
	}
	public int getAddrid() {
		return addrid;
	}
	public void setAddrid(int addrid) {
		this.addrid = addrid;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "address [addrid=" + addrid + ", state=" + state + ", city=" + city + ", pincode=" + pincode + "]";
	}
	
}
