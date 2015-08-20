package com.test.test.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author zhangjunqiao
 * 
 */
@Entity
@Table(name = "zjq3_LicPlate_table")
public class LicencePlate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_licenceplate;

	private String licencePlateNum;

	private String carID;

	public String getCarID() {
		return carID;
	}

	public void setCarID(String carID) {
		this.carID = carID;
	}

	
	
	
	
	@ManyToOne
	@JoinColumn(name = "userid")
	private User user;

	
	
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getId_licenceplate() {
		return id_licenceplate;
	}

	public void setId_licenceplate(Long id_licenceplate) {
		this.id_licenceplate = id_licenceplate;
	}

	public String getLicencePlateNum() {
		return licencePlateNum;
	}

	public void setLicencePlateNum(String licencePlateNum) {
		this.licencePlateNum = licencePlateNum;
	}

}
