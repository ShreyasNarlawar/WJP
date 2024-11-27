package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Product;
import com.demo.beans.Student;

public class TestStudMapping {
    public static void main(String[] args) {
       
            SessionFactory sf = new Configuration().configure().buildSessionFactory();
            Session session= sf.openSession();
            Transaction tr= session.beginTransaction();

            Student s1 = new Student("ajay", 4543);
            Student s2 = new Student("pankaj", 945346);
            Product p1 = new Product("nano",10,100000.00);
            session.save(s1);
            session.save(s2);
            session.save(p1);
            tr.commit();
            if(p1 != null && s1 != null && s2 != null) {
            	System.out.println("Students saved successfully!");
            	System.out.println("product added successfully");
            }else
            	System.out.println("error");

            session.close();
            sf.close(); 
    }
}