package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Customer;
import com.demo.beans.Employee;
import com.demo.beans.Person;

public class TestTableperClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sf = new Configuration().configure().buildSessionFactory(); 
		Employee e1 = new Employee("shyaam","8542414114","Mechanical","Maintainer");
		Customer c1 = new Customer("babubhai","7747485412","Mumbai","Brother");
		Session sess= sf.openSession();
		Transaction tr = sess.beginTransaction();
		sess.save(e1);
		sess.save(c1);
		tr.commit();
		sess.close();
		sf.close();
	}

}
