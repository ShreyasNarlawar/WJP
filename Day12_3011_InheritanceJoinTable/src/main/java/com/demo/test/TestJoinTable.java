package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Customer;
import com.demo.beans.Employee;

public class TestJoinTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		Employee em1=new Employee("mona","8464354654","mgr","Developer");
		Customer cs1=new Customer("sona","7453446466","Pune","neighbour");
		Session sess = sf.openSession();
		Transaction tr= sess.beginTransaction();
		sess.save(em1);
		sess.save(cs1);
		
		tr.commit();
		sess.close();
		sf.close();
	}
}
