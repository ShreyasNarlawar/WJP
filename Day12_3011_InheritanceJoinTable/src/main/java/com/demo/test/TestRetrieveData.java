package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Customer;
import com.demo.beans.Employee;

public class TestRetrieveData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sess = sf.openSession();
		Transaction tr= sess.beginTransaction();
		Customer c12=sess.get(Customer.class,2);
		System.out.println(c12);
		Employee e1 = sess.get(Employee.class,1);
		System.out.println(e1);
		tr.commit();
		sess.close();
		sf.close();
	}
}
