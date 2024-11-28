package com.demo.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Department;
import com.demo.beans.Employee;

public class TestOneToMany {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Department d1 = new Department();
		d1.setDid(11);
		d1.setDname("Developer");
		d1.setDloc("pune");
		Department d2 = new Department();
		d2.setDid(12);
		d2.setDname("Testing");
		d2.setDloc("banglore");
		Employee e1 = new Employee(1,"kunal",54561,d1);
		Employee e2 = new Employee(2,"smith",64596,d2);
		Employee e3 = new Employee(3,"willams",96856,d1);
		Employee e4 = new Employee(4,"kane",595465,d2);
		Set<Employee> s1 = new HashSet<>();
		s1.add(e1);
		s1.add(e2);
		d1.setElist(s1);
		Set<Employee> s2 = new HashSet<>();
		s2.add(e3);
		s2.add(e4);
		d2.setElist(s2);
		
		Session sesh = sf.openSession();
		Transaction tr = sesh.beginTransaction();
		sesh.save(d1);
		sesh.save(d2);
		sesh.save(e1);
		sesh.save(e2);
		sesh.save(e3);
		sesh.save(e4);
		
		tr.commit();
		sesh.close();
		sf.close();

	}

}
