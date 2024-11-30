package com.demo.service;

import java.util.List;

import com.demo.beans.Department;

public interface DepartmentServ {

	boolean addNewDept();

	boolean deletedept(int id);

	boolean ModifyDepartmentData(int id);

	Department SearchDeaprtment(int id);

	List<Department> ShowAllDept();

}
