package com.test.test.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.test.test.domain.LicencePlate;
import com.test.test.domain.User;
import com.test.test.service.UserService;

@Controller
@RequestMapping("/test.do")
public class TestController {
	private static final Logger logger = LoggerFactory
			.getLogger(TestController.class);
	@Autowired
	UserService userService;

	@RequestMapping(params = "act=test", method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView testPage() {

		ModelAndView mav = new ModelAndView("index");
		// mav.addObject("name",licplate.getUser().getUsername());
		initialization(); 
		return mav;
	}

	public void initialization() {
		userService.deleteall();
		User user = new User();
		user.setUsername("张伟");
		user.setPassword("0000");
		user.setPhonenum("13735593160");
		user.setIDcard("330726198907280000");

		LicencePlate licplate = new LicencePlate();
		licplate.setLicencePlateNum("浙A00001");
		licplate.setCarID("3F4K6F8H9D0R13K");
		licplate.setUser(user);

		LicencePlate licplate2 = new LicencePlate();
		licplate2.setLicencePlateNum("浙A00002");
		licplate2.setCarID("0F4K678H9S0R68K");
		licplate2.setUser(user);

		userService.insertUserandLicPlate(user, licplate);
		userService.insertUserandLicPlateagain(user, licplate2);

		User user_2 = new User();
		user_2.setUsername("张伟2");
		user_2.setPassword("1111");
		user_2.setPhonenum("13735593160");
		user_2.setIDcard("330726198907280002");
		LicencePlate licplate_3 = new LicencePlate();
		licplate_3.setLicencePlateNum("浙A00003");
		licplate_3.setCarID("3A4U8F8Y9DDR13K");
		licplate_3.setUser(user_2);

		userService.insertUserandLicPlate(user_2, licplate_3);

		User user_3 = new User();
		user_3.setUsername("张伟3");
		user_3.setPassword("3333");
		user_3.setPhonenum("13735593132");
		user_3.setIDcard("330726198907000002");
		LicencePlate licplate_4 = new LicencePlate();
		licplate_4.setLicencePlateNum("浙A00004");
		licplate_4.setCarID("6A4W8F8D9VB413M");

		licplate_4.setUser(user_3);
		licplate_4.setUser(user_3);

		userService.insertUserandLicPlate(user_3, licplate_4);
	}

	/**
	 * 已经有一块牌照了，又加一块牌照
	 */
	public void addnewnumtoAuser() {
		User temp = userService.search("张伟3");
		LicencePlate licplate = new LicencePlate();
		licplate.setLicencePlateNum("浙A00005");
		licplate.setCarID("3F4K6F8H9D0R13K");
		licplate.setUser(temp);
		userService.insertUserandLicPlateagain(temp, licplate);
	}

	/**
	 * 更新用户姓名
	 */
	public void updateUsername() {
		userService.updateUsername("张伟3", "李玮峰");
	}

	/**
	 * 通过车主查询其名下车牌
	 */
	public void findallnumofAuser() {
		List<LicencePlate> l = userService.findLicPlateByUser("张伟");

		if (!l.isEmpty()) {
			for (LicencePlate u : l) {
				System.out.println("查到号牌了，他们分别是" + u.getLicencePlateNum());
			}
		}
	}

	/**
	 * 通过车牌查询车主名
	 */
	public void finduserbyNum() {
		System.out
				.println("牌照浙A00002的车主是"
						+ userService.findOneByLicencePlateNum("浙A00002")
								.getUsername());
	}

	/**
	 * 删除一个号牌
	 */
	public void deleteAnum() {
		Long it = new Long(1); // 删除一个号牌
		userService.deleteOneByLicencePlateNum(it);
	}
	/**
	 * 更改车牌号
	 */
	public void updateAnum()
	{
		userService.updateLicPlate("张伟", "浙A00002","沪B00008");
	}
}
