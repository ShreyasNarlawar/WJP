package com.demo.p1;

public class P1{
	private int a;
	public P1(){
		this.a=10;
	}
	public P1(int val) {
		this.a=val;
	}
	public void my() {
		System.out.println("From Module1 Package p1 "+a);
	}
}