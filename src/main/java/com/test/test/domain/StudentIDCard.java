package com.test.test.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "zjq4_StudentIDCard")
public class StudentIDCard {
	
	private int id;
	private String kinds;
	private Date datePublished;
	private Student student;

	@OneToOne
	@JoinColumn(name = "stu_zjq")
	public Student getStudent() {
		return student;
	}
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getKinds() {
		return kinds;
	}

	public void setKinds(String kinds) {
		this.kinds = kinds;
	}

	public Date getDatePublished() {
		return datePublished;
	}

	public void setDatePublished(Date datePublished) {
		this.datePublished = datePublished;
	}



	public void setStudent(Student student) {
		this.student = student;
	}
}
