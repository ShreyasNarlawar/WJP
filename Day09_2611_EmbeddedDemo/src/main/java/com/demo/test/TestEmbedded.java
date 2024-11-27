package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.address;
import com.demo.beans.student;

public class TestEmbedded {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		address adr1 = new address(1,"Maharashtra","pune","411001");
		student s1 = new student(05,"suraj",23756.67,adr1);
		Session session1 = sf.openSession();
		Transaction tr=session1.beginTransaction();
		session1.save(s1);
		tr.commit();
		session1.close();
		sf.close();
	}

}
