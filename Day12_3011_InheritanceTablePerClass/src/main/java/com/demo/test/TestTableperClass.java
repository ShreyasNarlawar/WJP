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
		Employee e1 = new Employee("shar","9565435343","CSE","Developer");
		Customer c1 = new Customer("dona","8097684841","Pune","Guest");
		Person   p1 = new Person("Shrey" ,"7454855451");
		Session sess= sf.openSession();
		Transaction tr = sess.beginTransaction();
		sess.save(e1);
		sess.save(c1);
		sess.save(p1);
		tr.commit();
		sess.close();
		sf.close();
	}

}
