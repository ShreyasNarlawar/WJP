package com.demo.beans;

import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="emp002")
public class Employee {
    @Id
    private int eid;
    private String ename;
    private double sal;
    private LocalDate lod;

    @ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name="deptid", nullable = false) // Ensure department is not null
    private Department department; // Renamed for clarity

    // Default constructor
    public Employee() {
        super();
    }

    // Parameterized constructor
    public Employee(int eid, String ename, double sal, LocalDate lod, Department department) {
        super();
        this.eid = eid;
        this.ename = ename;
        this.sal = sal;
        this.lod = lod;
        this.department = department;
    }

    // Getters and Setters
    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public LocalDate getLod() {
        return lod;
    }

    public void setLod(LocalDate lod) {
        this.lod = lod;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee [eid=" + eid + ", ename=" + ename + ", sal=" + sal + ", lod=" + lod + ", department=" + department + "]";
    }
}