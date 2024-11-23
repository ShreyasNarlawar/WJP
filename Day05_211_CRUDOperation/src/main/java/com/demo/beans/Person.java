package com.demo.beans;

import java.util.Arrays;

public class Person {
	private String fname;
	private String lname;
	private String gender;
	private String degree;
	private String city;
	private String[] skills;
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(String fname, String lname, String gender, String degree, String city, String[] skills) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.gender = gender;
		this.degree = degree;
		this.city = city;
		this.skills = skills;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String[] getSkills() {
		return skills;
	}

	public void setSkills(String[] skills) {
		this.skills = skills;
	}

	@Override
	public String toString() {
		return "Person [ fname=" + fname + ", lname=" + lname + ", gender=" + gender + ", degree="
				+ degree + ", city=" + city + ", skills=" + Arrays.toString(skills) + "]";
	}
	
	
}
