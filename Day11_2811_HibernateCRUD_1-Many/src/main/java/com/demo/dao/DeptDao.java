package com.demo.dao;

import java.util.List;

import com.demo.beans.Department;

public interface DeptDao {

	boolean save(Department d);

	boolean deleteDeptById(int id);

	boolean updateDepartment(int id, String name, String dloc);

	Department findDeptById(int id);

	List<Department> showAllDepts();

}
