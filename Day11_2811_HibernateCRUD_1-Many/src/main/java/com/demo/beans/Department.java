package com.demo.beans;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="dept002")
public class Department {
    @Id
    private int deptid;
    private String dname;
    private String dloc;

    @OneToMany(fetch=FetchType.EAGER, mappedBy="department", orphanRemoval = true, cascade=CascadeType.REFRESH) // Updated mappedBy
    private Set<Employee> elist;

    // Default constructor
    public Department() {
        // Default constructor
    }

    // Constructor with deptid
    public Department(int deptid) {
        super();
        this.deptid = deptid;
    }

    // Full constructor ```java
    public Department(int deptid, String dname, String dloc, Set<Employee> elist) {
        super();
        this.deptid = deptid;
        this.dname = dname;
        this.dloc = dloc;
        this.elist = elist;
    }

    // Getters and Setters
    public int getDeptid() {
        return deptid;
    }

    public void setDeptid(int deptid) {
        this.deptid = deptid;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDloc() {
        return dloc;
    }

    public void setDloc(String dloc) {
        this.dloc = dloc;
    }

    public Set<Employee> getElist() {
        return elist;
    }

    public void setElist(Set<Employee> elist) {
        this.elist = elist;
    }

    @Override
    public String toString() {
        return "Department [deptid=" + deptid + ", dname=" + dname + ", dloc=" + dloc + "]";
    }
}