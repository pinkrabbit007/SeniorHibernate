package com.test.test.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 为什么@OneToOne和@JoinColumn放在内部变量声明前就会报错？ a）
 * 只有OneToOne,OneToMany,ManyToMany上才有mappedBy属性，ManyToOne不存在该属性； b）
 * mappedBy标签一定是定义在the owned side（被拥有方的），他指向the owning side（拥有方）； c）
 * 关系的拥有方负责关系的维护，在拥有方建立外键。所以用到@JoinColumn
 * d）mappedBy跟JoinColumn/JoinTable总是处于互斥的一方
 */

@Entity
@Table(name = "zjq5_Student")
public class Student {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private int age;

	@Column(name = "school_id")
	private Long school_id;

	@OneToMany
	@JoinColumn(name = "stu_id")
	private List<StudentIDCard> cardId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Long getSchool_id() {
		return school_id;
	}

	public void setSchool_id(Long school_id) {
		this.school_id = school_id;
	}

	public List<StudentIDCard> getCardId() {
		return cardId;
	}

	public void setCardId(List<StudentIDCard> cardId) {
		this.cardId = cardId;
	}
}
