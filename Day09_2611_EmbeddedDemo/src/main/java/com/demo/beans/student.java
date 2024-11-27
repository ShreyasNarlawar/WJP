package com.demo.beans;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stud01")
public class student {
	@Id
	private int Sid;
	private String Sname;
	private double Salary;
	@Embedded
	private address addr;
	public student() {
		super();
	}
	public student(int sid, String sname, double salary, address addr) {
		super();
		Sid = sid;
		Sname = sname;
		Salary = salary;
		this.addr = addr;
	}
	public int getSid() {
		return Sid;
	}
	public void setSid(int sid) {
		Sid = sid;
	}
	public String getSname() {
		return Sname;
	}
	public void setSname(String sname) {
		Sname = sname;
	}
	public double getSalary() {
		return Salary;
	}
	public void setSalary(double salary) {
		Salary = salary;
	}
	public address getAddr() {
		return addr;
	}
	public void setAddr(address addr) {
		this.addr = addr;
	}
	@Override
	public String toString() {
		return "student [Sid=" + Sid + ", Sname=" + Sname + ", Salary=" + Salary + ", addr=" + addr + "]";
	}
	
}
