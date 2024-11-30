package com.demo.test;

import java.util.List;
import java.util.Scanner;

import com.demo.beans.Department;
import com.demo.beans.Employee;
import com.demo.dao.HibernateConnection;
import com.demo.service.DepartmentServ;
import com.demo.service.DepartmentServImpl;
import com.demo.service.EmployeeServ;
import com.demo.service.EmployeeServImpl;

public class TestHibernateCRUD {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		EmployeeServ eserv = new EmployeeServImpl();
		DepartmentServ dserv = new DepartmentServImpl();
		int ch = 0;
	do {
		System.out.println("\n\t\tMenu");
		System.out.println("1. Add new Employee   \n2.  Add new Department\n");
		System.out.println("3. delete employee    \n4.  delete Department\n");
		System.out.println("5. modify employee    \n6.  modify Department\n");
		System.out.println("7. search employee    \n8.  search Department\n");
		System.out.println("9. show all employees \n10. Show all Departments\n");
		System.out.println("11.Employee by sal    \n12. exit \n\n\t Choice :");
		ch = sc.nextInt();

		switch(ch) {
			case 1 : 
					boolean status =eserv.addNewManus();
					if(status)
						System.out.println("Employee Added.");
					else
						System.out.println("Not added..");
					break;
			
			case 2:
					status =dserv.addNewDept();
					if(status)
						System.out.println("Department Added.");
					else
						System.out.println("Not added..");
					break;
			
			case 3:
					System.out.println("Enter Employee Id to delete :");
					int id = sc.nextInt();
					status = eserv.deleteEmp(id);
					if(status)
						System.out.println("Employee Deleted.");
					else
						System.out.println("Employee Not Found..");
					break; 
			
			case 4:
					System.out.println("Enter Department Id to delete :");
					id = sc.nextInt();
					status = dserv.deletedept(id);
					if(status)
						System.out.println("Department Deleted.");
					else
						System.out.println("Department not found..");
					break;
			
			case 5:
					System.out.println("Enter Employee Id to update :");
					id = sc.nextInt();
					status=eserv.ModifyEmployeeData(id);
					if(status)
						System.out.println("Employee Details Updated.");
					else
						System.out.println("Employeee not found..");
					break;
					
			case 6:
					System.out.println("Enter Department Id to update :");
					id=sc.nextInt();
					status=dserv.ModifyDepartmentData(id);
					if(status)
						System.out.println("Department Modified Successfully.");
					else
						System.out.println("Department not Found..");
					break;
			
			case 7:
					System.out.println("Enter Employee Id to search : ");
					id=sc.nextInt();
					Employee e=eserv.SearchEmployee(id);
					if(e!=null)
						System.out.println(e);
					else
						System.out.println("Employee Not Found.");
					break;
					
			case 8:
					System.out.println("Enter Department Id to search : ");
					id=sc.nextInt();
					Department d=dserv.SearchDeaprtment(id);
					if(d!=null)
						System.out.println(d);
					else
						System.out.println("Employee Not Found.");
					break;
					
			case 9:
					List<Employee>elist=eserv.ShowAllEmp();
					if(elist!=null)
						elist.forEach(System.out::println);
					else
						System.out.println("No more Employees..");
					break;
			
			case 10:
					List<Department>dlist=dserv.ShowAllDept();
					if(dlist!=null)
						dlist.forEach(System.out::println);
					else
						System.out.println("No more Departments..");
					break;
			
			case 11:
					elist=eserv.ArrangeEmpBySal();
					if(elist!=null)
						elist.forEach(System.out::println);
					else
						System.out.println("No more Employees..");
					break;
			
			case 12:
					System.out.println("Thanks For Visiting..");
					HibernateConnection.closeMyConnection();
					sc.close();
					break;
					
			default :
					System.out.println("Invalid Choice..");
					break;
			}
		}while(ch!=12);
	}
}
