package com.test.test.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "zjq5_StudentIDCard")
public class StudentIDCard {


	private int id; 
	private Date datePublished;
	
	@Column(name = "stu_id")
	private Long students_id;
 
	
	
	@Column(name = "school_id")
	private Long school_id;
	
	

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	 
	public Date getDatePublished() {
		return datePublished;
	}

	public void setDatePublished(Date datePublished) {
		this.datePublished = datePublished;
	}
	
	public Long getStudents_id() {
		return students_id;
	}

	public void setStudents_id(Long students_id) {
		this.students_id = students_id;
	}

	public Long getSchool_id() {
		return school_id;
	}

	public void setSchool_id(Long school_id) {
		this.school_id = school_id;
	}
 
}
