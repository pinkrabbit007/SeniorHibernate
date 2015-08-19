package com.test.test.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.test.test.domain.LicencePlate;

public interface LicplateDao extends PagingAndSortingRepository<LicencePlate, Long>{
	public LicencePlate findOneByLicencePlateNum(String num);  
}
