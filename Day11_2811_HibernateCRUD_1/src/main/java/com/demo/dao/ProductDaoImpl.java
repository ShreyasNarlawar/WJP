package com.demo.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Product;

public class ProductDaoImpl implements ProductDao {
	
	static SessionFactory sf = new Configuration().configure().buildSessionFactory();
	
	@Override
	public boolean save(Product p) {
		// TODO Auto-generated method stub
		Session sess = sf.openSession();
		Transaction tr = sess.beginTransaction();
		sess.save(p);
		tr.commit();
		sess.close();
		return true;
	}

	@Override
	public List<Product> displayAll() {
		// TODO Auto-generated method stub
		Session sess = sf.openSession();
		Transaction tr = sess.beginTransaction();
		Query q = sess.createQuery("from Product");
		List<Product>plist = q.getResultList();
		tr.commit();
		sess.close();
		return plist;
	}

	@Override
	public boolean deleteById(int id) {
		Session sess = sf.openSession();
		Transaction tr = sess.beginTransaction();
		Product p = sess.get(Product.class, id);
		boolean status;
		if(p != null) {
			sess.delete(p);
			status= true;
		}else {
			status= false;
		}
		tr.commit();
		sess.close();
		return status;
	}

	@Override
	public boolean updateById(int id,String name, int qty, double price) {
		Session sess = sf.openSession();
		Transaction tr =sess.beginTransaction();
		Product p = sess.get(Product.class, id);
		if(p != null) {
			p.setPname(name);
			p.setQty(qty);
			p.setPrice(price);
			sess.update(p);
			tr.commit();
			sess.close();
			return true;
		}
		sess.close();
		return false;
	}

	@Override
	public Product searchId(int id) {
		// TODO Auto-generated method stub
		Session sess = sf.openSession();
		Transaction tr = sess.beginTransaction();
		Product p = sess.get(Product.class, id);
		if(p!=null) {
		tr.commit();
		sess.close();
		return p;
		}
		sess.close();
		return null;
	}

	@Override
	public List<Product> sortByName() {
		// TODO Auto-generated method stub
		Session sess = sf.openSession();
		Transaction tr = sess.beginTransaction();
		Query q = sess.createQuery("from Product order by pname");
		List<Product>ls = q.getResultList();
		tr.commit();
		sess.close();
		return ls;
	}

	@Override
	public void shutdown() {
		// TODO Auto-generated method stub
		HibernateUtil.closeMyConnection();
	}
	
	

}
