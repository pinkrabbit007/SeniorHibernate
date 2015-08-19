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

		User user = new User();
		LicencePlate licplate = new LicencePlate();
		user.setUsername("张伟4");
		user.setPassword("0000");
		user.setPhonenum("13735593160");
		user.setIDcard("330726198907280000");

		licplate.setLicencePlateNum("浙A88888");
		licplate.setCarID("3F4K6F8H9D0R13K");
		// user.addLicPlate(licplate);//为什么加了这行就报错？
		licplate.setUser(user);
		userService.insertUserandLicPlate(user, licplate);

		/*
		 * licplate = userService.findOneByLicencePlateNum("浙A77777");//
		 * 这步如果搜不到的话，连test.do?act=test都打不开呢
		 * System.out.println("车主姓名为"+licplate.getUser().getUsername());
		 */

/*		Long it = new Long(1);    //删除一个号牌
	    userService.deleteOneByLicencePlateNum(it);*/

		List<LicencePlate> l = null;

		/*l = userService.findOneByUser(user);

		if (!l.isEmpty()) {
			for (LicencePlate u : l) {
				System.out.println(u.getLicencePlateNum());
			}
		} else
			System.out.println("Nobody is found");*/

		// mav.addObject("name",licplate.getUser().getUsername());
		return mav;
	}
}
