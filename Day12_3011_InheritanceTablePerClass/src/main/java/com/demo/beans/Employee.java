package com.demo.beans;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="emp004")
public class Employee extends Person{

	private String Department;
	private String Designation;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(String pname,String mob,String department, String designation) {
		super(pname,mob);
		Department = department;
		Designation = designation;
	}
	public String getDepartment() {
		return Department;
	}
	public void setDepartment(String department) {
		Department = department;
	}
	public String getDesignation() {
		return Designation;
	}
	public void setDesignation(String designation) {
		Designation = designation;
	}
	@Override
	public String toString() {
		return super.toString()+"Employee [Department=" + Department + ", Designation=" + Designation + "]";
	}
}
