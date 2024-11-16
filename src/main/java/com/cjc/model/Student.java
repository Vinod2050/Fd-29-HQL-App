package com.cjc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT_DTLS")
public class Student {

	@Id
	@Column(name = "STUDENT_ROLLNO")
	private int rollno;

	@Column(name = "STUDENT_NAME")
	private String name;

	@Column(name = "STUDENT_ADDRESS")
	private String address;

	@Column(name = "STUDENT_MARKS")
	private float marks;

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(int rollno, String name, String address, float marks) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.address = address;
		this.marks = marks;
	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public float getMarks() {
		return marks;
	}

	public void setMarks(float marks) {
		this.marks = marks;
	}

}
