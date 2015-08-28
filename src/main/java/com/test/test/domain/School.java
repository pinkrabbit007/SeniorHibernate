package com.test.test.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "zjq5_School")

public class School {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;

	@OneToMany
	@JoinColumn(name = "school_id")
	private List<Student> Student;

	/*
	@JoinColumn(name = "school_id")
	private List<StudentIDCard> StudentIDCard_id;*/
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Student> getStudent() {
		return Student;
	}

	public void setStudent(List<Student> student) {
		Student = student;
	}
	
/*	public List<StudentIDCard> getStudentIDCard_id() {
		return StudentIDCard_id;
	}

	public void setStudentIDCard_id(List<StudentIDCard> studentIDCard_id) {
		StudentIDCard_id = studentIDCard_id;
	}*/

}
