package com.demo.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.beans.HelloWorld;
import com.demo.beans.Product;

import org.springframework.context.ApplicationContext;

public class TestHelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("springconfig.xml");
		System.out.println("before BEANS");
		HelloWorld hw =(HelloWorld)ctx.getBean("hwbean");
		hw.sayHello();
		Product p=(Product)ctx.getBean("p1");
		System.out.println("After BEANS");
	}

}
