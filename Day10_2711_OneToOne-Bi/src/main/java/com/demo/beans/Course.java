package com.demo.beans;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Coursetab")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cid;
	private String cname;
	private int duration;
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="courseid")
	private Faculty f;
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Course(int cid, String cname, int duration, Faculty f) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.duration = duration;
		this.f = f;
	}
	public Course(String cname, int duration, Faculty f) {
		super();
		this.cname = cname;
		this.duration = duration;
		this.f = f;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public Faculty getF() {
		return f;
	}
	public void setf(Faculty f) {
		this.f = f;
	}
	@Override
	public String toString() {
		return "Course [cid=" + cid + ", cname=" + cname + ", duration=" + duration + ", f=" + f + "]";
	}
	
	
}
