package com.demo.dao;

import java.util.List;

import com.demo.beans.Employee;

public interface EmployeeDao {

	boolean save(Employee e);

	boolean deleteEmpbyId(int id);

	boolean updateEmpDetails(int eid, String name, double sal, int deptid);

	Employee findEmployee(int id);

	List<Employee> showEmps();

	List<Employee> sortBySal();

}
