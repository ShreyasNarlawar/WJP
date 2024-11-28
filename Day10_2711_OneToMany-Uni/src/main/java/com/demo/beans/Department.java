package com.demo.beans;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="dept001")
public class Department {
	@Id
	private int did;
	private String dname;
	private String dloc;
	@OneToMany(mappedBy ="d")
	Set<Employee> elist;
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Department(int did, String dname, String dloc, Set<Employee> elist) {
		super();
		this.did = did;
		this.dname = dname;
		this.dloc = dloc;
		this.elist = elist;
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getDloc() {
		return dloc;
	}
	public void setDloc(String dloc) {
		this.dloc = dloc;
	}
	public Set<Employee> getElist() {
		return elist;
	}
	public void setElist(Set<Employee> elist) {
		this.elist = elist;
	}
	@Override
	public String toString() {
		return "Department [did=" + did + ", dname=" + dname + ", dloc=" + dloc + ", elist=" + elist + "]";
	}
	
}
