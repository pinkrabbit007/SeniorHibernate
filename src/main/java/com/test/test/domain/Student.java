package com.test.test.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "zjq4_Student")
public class Student {

	private int id;
	private String name;
	private int age;
	/**
	 * 为什么@OneToOne和@JoinColumn放在内部变量声明前就会报错？
	 * a） 只有OneToOne,OneToMany,ManyToMany上才有mappedBy属性，ManyToOne不存在该属性；
	 * b） mappedBy标签一定是定义在the owned side（被拥有方的），他指向the owning side（拥有方）；
	 * c） 关系的拥有方负责关系的维护，在拥有方建立外键。所以用到@JoinColumn
	 * d）mappedBy跟JoinColumn/JoinTable总是处于互斥的一方
	 */
	private StudentIDCard cardId;

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	// 是对方类里面的自己，表示关系由对方维护，自己将不再维护，就算在自己这端设置值，保存到数据库后外键依然是 null
	@OneToOne(mappedBy = "student")
	// JoinColumn指定外键用，和mappedBy互斥，不能一起用
	// @JoinColumn(name = "cardId")
	public StudentIDCard getCardId() {
		return cardId;
	}

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

	public void setId(int id) {
		this.id = id;
	}

	public void setCardId(StudentIDCard cardId) {
		this.cardId = cardId;
	}

}
