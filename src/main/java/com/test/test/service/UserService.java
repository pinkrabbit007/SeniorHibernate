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
	 * @param 按姓名查找车主
	 */
	@Transactional
	public User search(String userName) {
		return userDao.findOneByUsername(userName);
	}
	/**
	 * 
	 * @param 查找车牌
	 */
	@Transactional
	public LicencePlate searchLicPlate(String Num) {
		return licplateDao.findOneByLicencePlateNum(Num);
	}
	/**
	 * 
	 * @param 存储车主以及车牌号
	 *            ，适用于第一次的情况
	 */
	@Transactional
	public void insertUserandLicPlate(User user, LicencePlate Licplate) {
		userDao.save(user);
		licplateDao.save(Licplate); // 暂时还不会级联保存
	}

	/**
	 * 
	 * @param 车主又买了辆车
	 *            ，适用于第二次的情况
	 */
	@Transactional
	public void insertUserandLicPlateagain(User user, LicencePlate Licplate) {

		User temp = userDao.findOneByUsername(user.getUsername());
		temp.addLicPlate(Licplate);
		Licplate.setUser(temp);
		licplateDao.save(Licplate);
		userDao.save(temp);
	
	}

	/**
	 * 
	 * @param 通过车牌查询车主名
	 */
	@Transactional
	public User findOneByLicencePlateNum(String licnum) {
		return licplateDao.findOneByLicencePlateNum(licnum).getUser();
	}

	/**
	 * 
	 * @param 删除一张车牌
	 */
	@Transactional
	public void deleteOneByLicencePlateNum(Long id) {
		licplateDao.delete(id);
	}

	/**
	 * 
	 * @param 通过车主查询其名下车牌
	 */
	public List<LicencePlate> findLicPlateByUser(String Username) {
		User temp = userDao.findOneByUsername(Username);
		return temp.getLicPlate();
	}
	/**
	 * 
	 * @param 更改车主名称
	 */
	public void updateUsername(String oldname,String newname) {
		User temp = userDao.findOneByUsername(oldname);
		temp.setUsername(newname);
		userDao.save(temp);
	}
	/**
	 * 
	 * @param 更改车牌号
	 */
	public void updateLicPlate(String username, String oldnum,String newnum) {
		User temp = userDao.findOneByUsername(username);
		List<LicencePlate> l= temp.getLicPlate();
		for(LicencePlate u:l)
		{
			System.out.println("查到号牌了，他们分别是"+ u.getLicencePlateNum());
			if(u.getLicencePlateNum().equals(oldnum))
				u.setLicencePlateNum(newnum);
		}
		LicencePlate lic = licplateDao.findOneByLicencePlateNum(oldnum);
		lic.setUser(temp);
		lic.setLicencePlateNum(newnum);
		/**
		 * 那么问题来了，假如我上面这句话注释掉，也就是说在user的List<LicencePlate>更新了车牌号
		 * 但是没有在LicencePlate表里面更新车牌号，也不会报错，这样做会有什么后果？
		 */
		licplateDao.save(lic);
		userDao.save(temp);
	}
	/**
	 * 
	 * @param 删除所有数据表
	 */
	public void deleteall()
	{
		licplateDao.deleteAll();
		userDao.deleteAll();
	}
}
