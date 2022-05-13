package com.springboot.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
	@Id
	private String studentid;
	private String studentname;
	private String studentphone;

	public Student() {
		super();
	}

	public Student(String studentid, String studentname, String studentphone) {
		super();
		this.studentid = studentid;
		this.studentname = studentname;
		this.studentphone = studentphone;
	}

	public String getStudentid() {
		return studentid;
	}

	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}

	public String getStudentname() {
		return studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

	public String getStudentphone() {
		return studentphone;
	}

	public void setStudentphone(String studentphone) {
		this.studentphone = studentphone;
	}

	@Override
	public String toString() {
		return "Student [studentid=" + studentid + ", studentname=" + studentname + ", studentphone=" + studentphone
				+ "]";
	}


}
