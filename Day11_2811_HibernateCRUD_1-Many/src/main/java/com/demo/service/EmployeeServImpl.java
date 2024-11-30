package com.demo.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

import com.demo.beans.Department;
import com.demo.beans.Employee;
import com.demo.dao.EmployeeDao;
import com.demo.dao.EmployeeDaoImpl;

public class EmployeeServImpl implements EmployeeServ {
	private EmployeeDao edao;
	public EmployeeServImpl() {
		edao = new EmployeeDaoImpl();
	}
	Scanner sc = new Scanner(System.in);
	@Override
	public boolean addNewManus() {
		System.out.println("Enter Eid :");
		int id = sc.nextInt();
		System.out.println("Enter name :");
		String name=sc.next();
		System.out.println("Enter Salary :");
		double sal = sc.nextDouble();
		System.out.println("Enter Date of Joining :(dd/MM/yyyy)");
		String doj=sc.next();
		System.out.println("enter deptid");
		int deptid=sc.nextInt();
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
		 Employee e=null;
	        try {
	            LocalDate ldt = LocalDate.parse(doj, formatter);
	            e=new Employee(id,name,sal,ldt,new Department(deptid));
	        } catch (DateTimeParseException a) {
	            System.out.println("Invalid date format. Please enter the date in the format dd/MM/yyyy.");
	        }
        return edao.save(e);
	}
	@Override
	public boolean deleteEmp(int id) {
		return edao.deleteEmpbyId(id);
		
	}
	@Override
	public boolean ModifyEmployeeData(int eid) {
		System.out.println("Enter name :");
		String name=sc.next();
		System.out.println("Enter new Salary :");
		double sal = sc.nextDouble();
		System.out.println("enter new deptid");
		int deptid=sc.nextInt();
		return edao.updateEmpDetails(eid,name,sal,deptid);
	}
	@Override
	public Employee SearchEmployee(int id) {
		return edao.findEmployee(id);
	}
	@Override
	public List<Employee> ShowAllEmp() {
		return edao.showEmps();
	}
	@Override
	public List<Employee> ArrangeEmpBySal() {
		return edao.sortBySal();
	}
}
