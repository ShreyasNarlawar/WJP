package com.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.demo.beans.Department;
import com.demo.beans.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	static SessionFactory sf;
	static {
		   sf=HibernateConnection.getMyConnection();
	   }
	
	public void closeMyConnection() {
		HibernateConnection.closeMyConnection();	
	}
	@Override
	public boolean save(Employee e) {
		// TODO Auto-generated method stub
		Session sess = sf.openSession();
		Transaction tr = sess.beginTransaction();
		sess.save(e);
		boolean status=false;
		Department d1  = sess.load(Department.class,e.getDepartment().getDeptid());
		if(d1!=null) {
			e.setDepartment(d1);
			sess.saveOrUpdate(e);
			status=true;
		}
		tr.commit();
		sess.close();
		return status;
	}
	@Override
	public boolean deleteEmpbyId(int id) {
		Session sess= sf.openSession();
		Transaction tr=sess.beginTransaction();
		 Employee e = sess.get(Employee.class, id);
		 boolean status = false;
		 if(e != null) {
			 sess.delete(e);
			 status = true;
		 }
		 tr.commit();
		 sess.close();
		return status;
	}
	@Override
	public boolean updateEmpDetails(int eid, String name, double sal, int deptid) {
		Session sess = sf.openSession();
		Transaction tr = sess.beginTransaction();
		Employee e = sess.get(Employee.class, eid);
		boolean status = false;
		if(e!=null) {
			e.setEname(name);
			e.setSal(sal);
			Department d = sess.get(Department.class, deptid);
			e.setDepartment(d);
			sess.update(e);
			status= true;
		}
		tr.commit();
		sess.close();
		return status;
	}
	@Override
	public Employee findEmployee(int id) {
		Session sess= sf.openSession();
		Transaction tr = sess.beginTransaction();
		Employee e = sess.get(Employee.class, id);
		if(e!=null) {
			tr.commit();
			sess.close();
			return e;
		}
		sess.close();
		return null;
	}
	@Override
	public List<Employee> showEmps() {
		Session sess = sf.openSession();
		Transaction tr= sess.beginTransaction();
		Query q = sess.createQuery("from Employee");
		List<Employee >elst = q.getResultList();
		if(elst!=null) {
			tr.commit();
			sess.close();
			return elst;
		}
		sess.close();
		return null;
	}
	@Override
	public List<Employee> sortBySal() {
		Session sess = sf.openSession();
		Transaction tr = sess.beginTransaction();
		Query q = sess.createQuery("from Employees order by sal");
		List<Employee>lst=q.getResultList();
		if(lst!=null) {
			tr.commit();
			sess.close();
			return lst;
		}
		sess.close();
		return null;
	}
}
