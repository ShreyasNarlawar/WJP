package com.demo.service;

import java.util.List;
import java.util.Scanner;

import com.demo.beans.Department;
import com.demo.dao.DeptDao;
import com.demo.dao.DeptDaoImpl;

public class DepartmentServImpl implements DepartmentServ {
	private DeptDao ddao;
	public DepartmentServImpl() {
		ddao = new DeptDaoImpl();
	}
	Scanner sc = new Scanner(System.in);
	@Override
	public boolean addNewDept() {
		System.out.println("Enter dept id");
		int id = sc.nextInt();
		System.out.println("Enter dept name");
		String name = sc.next();
		System.out.println("Enter dept location");
		String dloc = sc.next();
		
		Department d = new Department(id,name,dloc,null);
		return ddao.save(d);
	}
	@Override
	public boolean deletedept(int id) {
		return ddao.deleteDeptById(id);
	}
	@Override
	public boolean ModifyDepartmentData(int id) {
		System.out.println("Enter new Department name :");
		String name = sc.next();
		System.out.println("Enter new Deaprtment Loc :");
		String dloc = sc.next();
		return ddao.updateDepartment(id,name,dloc);
	}
	@Override
	public Department SearchDeaprtment(int id) {
		return ddao.findDeptById(id);
	}
	@Override
	public List<Department> ShowAllDept() {
		return ddao.showAllDepts();
	}

}
