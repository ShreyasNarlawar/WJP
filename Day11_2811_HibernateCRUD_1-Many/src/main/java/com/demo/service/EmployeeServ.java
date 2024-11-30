package com.demo.service;

import java.util.List;

import com.demo.beans.Employee;

public interface EmployeeServ {

	boolean addNewManus();

	boolean deleteEmp(int id);

	boolean ModifyEmployeeData(int id);

	Employee SearchEmployee(int id);

	List<Employee> ShowAllEmp();

	List<Employee> ArrangeEmpBySal();

}
