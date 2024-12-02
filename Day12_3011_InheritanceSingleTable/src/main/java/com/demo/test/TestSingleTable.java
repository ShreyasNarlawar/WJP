package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Customer;
import com.demo.beans.Employee;

public class TestSingleTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sf = new Configuration().configure().buildSessionFactory(); 
		Employee e1 = new Employee("sharad","6345362167","CSE","Developer");
		Customer c1 = new Customer("deepak","7486428743","Pune","Guest");
		Customer c2 = new Customer();
		Session sess= sf.openSession();
		Transaction tr = sess.beginTransaction();
		sess.save(e1);
		sess.save(c1);
		tr.commit();
		sess.close();
		sf.close();
	}

}
