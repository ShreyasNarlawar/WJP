package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Course;
import com.demo.beans.Faculty;

public class TestOneToOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Course c = new Course("java",5);
		Faculty f = new Faculty("rahul","pune",c);
//		Session sess = sf.openSession();
//		Transaction tr = sess.beginTransaction(); 
//		sess.save(c);
//		sess.save(f);
//		tr.commit();
//		sess.close();
		Session sesh = sf.openSession();
		Faculty f1 = sesh.get(Faculty.class,2);
		System.out.println(f1);
		Course c1 = sesh.get(Course.class, 1);
		System.out.println(c1);
		sf.close();
	}

}
