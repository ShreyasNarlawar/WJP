package com.demo.beans;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Cust003")
public class Customer extends Person{
	private String address;
	private String relationMgr;
	public Customer() {
		super();
	}
	
	public Customer( String pname, String mob,String address,String relationMgr) {
		super(pname, mob);
		this.address=address;
		this.relationMgr=relationMgr;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRelationMgr() {
		return relationMgr;
	}
	public void setRelationMgr(String relationMgr) {
		this.relationMgr = relationMgr;
	}
	@Override
	public String toString() {
		return super.toString()+"Customer [address=" + address + ", relationMgr=" + relationMgr + "]";
	}
}
