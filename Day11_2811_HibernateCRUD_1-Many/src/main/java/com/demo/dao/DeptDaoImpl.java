package com.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.demo.beans.Department;
import com.demo.beans.Employee;

public class DeptDaoImpl implements DeptDao{
	static SessionFactory sf;
	static {
		   sf=HibernateConnection.getMyConnection();
	   }
	public void closeMyConnection() {
		HibernateConnection.closeMyConnection();
		
	}
	@Override
	public boolean save(Department d) {
		// TODO Auto-generated method stub
		Session sess = sf.openSession();
		Transaction tr = sess.beginTransaction();
		boolean status=false;
		if(d!=null) {
			sess.save(d);
			status=true;
		}
		tr.commit();
		sess.close();
		return status;
	}
	@Override
	public boolean deleteDeptById(int id) {
		// TODO Auto-generated method stub
		Session sess = sf.openSession();
		Transaction tr = sess.beginTransaction();
		Department dpt = sess.get(Department.class, id);
		boolean status=false;
		if(dpt!=null) {
			sess.delete(dpt);
			status=true;
		}
		tr.commit();
		sess.close();
		return status;
	}
	@Override
	public boolean updateDepartment(int id, String name, String dloc) {
		Session sess = sf.openSession();
		Transaction tr = sess.beginTransaction();
		Department d = sess.get(Department.class, id);
		boolean status = false;
		if(d!=null) {
			d.setDname(name);
			d.setDloc(dloc);
			sess.update(d);
			status= true;
		}
		tr.commit();
		sess.close();
		return status;
	}
	@Override
	public Department findDeptById(int id) {
		Session sess = sf.openSession();
		Transaction tr=sess.beginTransaction();
		Department d=sess.get(Department.class,id);
		if(d!=null) {
			tr.commit();
			sess.close();
			return d;
		}
		sess.close();
		return null;
	}
	@Override
	public List<Department> showAllDepts() {
		Session sess = sf.openSession();
		Transaction tr= sess.beginTransaction();
		Query q = sess.createQuery("from Department");
		List<Department>dlst = q.getResultList();
		if(dlst!=null) {
			tr.commit();
			sess.close();
			return dlst;
		}
		sess.close();
		return null;
	}
}
