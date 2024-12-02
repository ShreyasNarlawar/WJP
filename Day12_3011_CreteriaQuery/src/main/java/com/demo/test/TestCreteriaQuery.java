package com.demo.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

import com.demo.beans.product;

public class TestCreteriaQuery {
	public static void main(String[] args) {
		SessionFactory sf =new Configuration().configure().buildSessionFactory();
		Session sess = sf.openSession();
		Transaction tr = sess.beginTransaction();
		
		Criteria cr1 = sess.createCriteria(product.class);
		List<product>plst = cr1.list();
		plst.forEach(System.out::println);
		Criterion cri1 = Restrictions.gt("price",200f);
		Criterion cri2 = Restrictions.lt("price",11000f);
		
		Criteria cr2 = sess.createCriteria(product.class);
		LogicalExpression expr1=Restrictions.and(cri1,cri2); 
		cr2.add(expr1);
		List<product>plst1 = cr2.list();
		plst1.forEach(System.out::println);
		
		//select * from product where price>1000 and price< 300 or qty<40
		Criteria cr3 = sess.createCriteria(product.class);
		List<product>plst2 = cr3.list();
		plst2.forEach(System.out::println);
		Criterion cri3 = Restrictions.gt("price", 2f);
		Criterion cri4 = Restrictions.lt("price", 210f);
		Criterion cri5 = Restrictions.lt("qty", 40);
		
		Criteria cr4=sess.createCriteria(product.class);
		LogicalExpression expr2=Restrictions.and(cri3, cri4);
		LogicalExpression expr3=Restrictions.or(expr2,cri5);
		cr4.add(expr2);
		List<product>plst3 = cr4.list();
		plst3.forEach(System.out::println);
	
		tr.commit();
		sess.close();
		sf.close();
	}
}
