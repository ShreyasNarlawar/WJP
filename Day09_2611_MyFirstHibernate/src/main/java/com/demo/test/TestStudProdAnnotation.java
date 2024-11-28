package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Product;
import com.demo.beans.Student;

public class TestStudProdAnnotation {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Student s1 = new Student("Vedant",34839);
		Student s2 = new Student("Varsha",42479);
		Student s3 = new Student("amit",85764);
		Student s4 = new Student("harsha",65424);
		Product p1 = new Product("Audii",4635461,2);
		Product p2 = new Product("BMW",7874254,1);
		
		Session sess = sf.openSession();
		Transaction tr= sess.beginTransaction();
		Student ss1 = sess.get(Student.class, 1);
		System.out.println(ss1);
		System.out.println("Before Get Method..");
		
		Product pp1 = sess.load(Product.class, 2);
		System.out.println(pp1.getPname());
		
		tr.commit();
		sess.close();
		sf.close();
	}
}
