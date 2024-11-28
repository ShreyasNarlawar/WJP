package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Course;
import com.demo.beans.Faculty;

public class TestOneToOneBi {
	
	public static void main(String[] args) {
		
	
	SessionFactory sf = new Configuration().configure().buildSessionFactory();
	Course c = new Course();
	c.setCname("C++");
	c.setDuration(8);
	Faculty f = new Faculty("kabir","Delhi",c);
	c.setf(f);
	Course c2 = new Course();
	c2.setCname("Acting");
	c2.setDuration(2);
	Faculty f2 = new Faculty("vicky","Mumbai",c2);
	c2.setf(f2);
	Session sess = sf.openSession();
	Transaction tr2  = sess.beginTransaction();
	sess.save(c);
	sess.save(f);
	sess.save(c2);
	sess.save(f2);
	
	tr2.commit();
	sess.close();
	sf.close();
	
//	Session sesh = sf.openSession();
//	Transaction tr = sesh.beginTransaction();
//	Course c = sesh.get(Course.class, 1);
//	if(c!= null)
//		sesh.delete(c);
//	tr.commit();
//	sesh.close();
//	sf.close();
	
	}
}
