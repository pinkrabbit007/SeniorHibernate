package com.test.test.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
		user.setUsername("段誉");
		user.setPassword("0000");

		userService.insert(user);

		user = userService.search("张俊俏2");// 这步如果搜不到的话，连test.do?act=test都打不开呢
		System.out.println(user.toString());
/*
		String sql = "select * from User";
		List<User> list = userService.queryBySql(sql);
		System.out.println("---" + list.size());
		for (Object u : list) {
			System.out.println(u + "=============");
		}
		mav.addObject("info", "asdfasdf");*/
		return mav;
	}
}
