package com.demo.beans;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Faculty01")
public class Faculty {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int fid;
	private String name;
	private String addr;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="courseid")
	private Course c1;
	public Faculty() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Faculty(String name, String addr, Course c1) {
		super();
		this.name = name;
		this.addr = addr;
		this.c1 = c1;
	}

	public Faculty(int fid, String name, String addr, Course c1) {
		super();
		this.fid = fid;
		this.name = name;
		this.addr = addr;
		this.c1 = c1;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public Course getC1() {
		return c1;
	}
	public void setC1(Course c1) {
		this.c1 = c1;
	}
	@Override
	public String toString() {
		return "Faculty [fid=" + fid + ", name=" + name + ", addr=" + addr + ", c1=" + c1 + "]";
	}
	
	
}
