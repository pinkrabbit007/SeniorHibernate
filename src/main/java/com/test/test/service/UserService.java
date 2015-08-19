package com.test.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.test.dao.LicplateDao;
import com.test.test.dao.UserDao;
import com.test.test.domain.LicencePlate;
import com.test.test.domain.User;

@Service
public class UserService {

	@Autowired
	UserDao userDao;
	@Autowired
	LicplateDao licplateDao;

	/**
	 * 
	 * @param 只存车主名
	 */
	@Transactional
	public void insert(User user) {
		userDao.save(user);
	}
	/**
	 * 
	 * @param 查找车主是否存在
	 */
	@Transactional
	public User search(String userName) {
		return userDao.findOneByUsername(userName);
	}
	/**
	 * 
	 * @param 存储车主以及车牌号，适用于第一次的情况
	 */
	@Transactional
	public void insertUserandLicPlate(User user, LicencePlate Licplate) {
		userDao.save(user);
		licplateDao.save(Licplate); //暂时还不会级联保存
	}
	/**
	 * 
	 * @param 车主又买了辆车，适用于第二次的情况
	 */
	@Transactional
	public void insertUserandLicPlateagain(User user, LicencePlate Licplate) {
		//userDao.save(user);
		licplateDao.save(Licplate); 
	}
	/**
	 * 
	 * @param 通过车牌查询车主名
	 */
	@Transactional
	public LicencePlate findOneByLicencePlateNum(String licnum) {
		return licplateDao.findOneByLicencePlateNum(licnum);
	}
	
	/**
	 * 
	 * @param 删除一张车牌
	 */
	@Transactional
	public void deleteOneByLicencePlateNum(Long id) {
		licplateDao.delete(id);
		
	}

/*	public List<LicencePlate> findOneByUser(User user)
	{
		return userDao.findByUsername(user.getUsername());
	}*/
}
