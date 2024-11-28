package com.demo.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="studenttab01")
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int sid;
	private String sname;
	private double salary;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String sname, double salary) {
		super();
		this.sname = sname;
		this.salary = salary;
	}
	public Student(int sid, String sname, double salary) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.salary = salary;
	}
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", salary=" + salary + "]";
	}
	
	
}
