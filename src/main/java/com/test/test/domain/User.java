package com.test.test.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author zjq
 * 
 */
@Entity
@Table(name = "zjq3_User_table")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 1024, name = "username")
	private String username;
	@Column(length = 1024, name = "password")
	private String password;
	private String phonenum;
	private String IDcard;
	private String granted;
 
	
	@OneToMany(mappedBy = "user")
	private List<LicencePlate> licPlate;


	/**
	 *  
	 * @param 手动构造添加车牌的方法
	 */
	public void addLicPlate(LicencePlate su) {
		if (su != null) {
			licPlate.add(su);
		}
	}
	/**
	 * 
	 * @List<LicencePlate> set and get
	 */
	public List<LicencePlate> getLicPlate() {
		return licPlate;
	}

	public void setLicPlate(List<LicencePlate> licPlate) {
		this.licPlate = licPlate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhonenum() {
		return phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

	public String getIDcard() {
		return IDcard;
	}

	public void setIDcard(String iDcard) {
		IDcard = iDcard;
	}

	public String getGranted() {
		return granted;
	}

	public void setGranted(String granted) {
		this.granted = granted;
	}

	/*
	 * public Set<LicencePlate> getLicencePlate() { return licencePlate; }
	 * 
	 * public void setLicencePlate(Set<LicencePlate> licencePlate) {
	 * this.licencePlate = licencePlate; }
	 */

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=");
		builder.append(id);
		builder.append(", username=");
		builder.append(username);
		builder.append(", phonenum=");
		builder.append(phonenum);
		builder.append(", IDcard=");
		builder.append(IDcard);
		builder.append("]");
		return builder.toString();
	}

}
