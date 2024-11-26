package com.demo.beans;

public class User {
	private String username;
	private String password;
	private String role;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String username, String password, String role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
	}
	public String getUname() {
		return username;
	}
	public void setUname(String uname) {
		this.username = uname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [uname=" + username + ", password=" + password + ", role=" + role + "]";
	}
	
	

}
