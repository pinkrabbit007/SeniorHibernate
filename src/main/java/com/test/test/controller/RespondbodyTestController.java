package com.test.test.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.test.domain.User;
/**
 * 
 * @author zhangjunqiao
 * @用途 測試responsebody
 */
@Controller
@RequestMapping("/respondbody")
public class RespondbodyTestController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(RespondbodyTestController.class);
	
	@RequestMapping(value = "/user/{userID}.do", method = { RequestMethod.POST,
			RequestMethod.GET })
	public @ResponseBody
	User queryStudent(@PathVariable("userID") int userID) {

		System.out.println("进入到@ResponseBody函数内部了，userID是"+userID); 
		User user = new User();
		Long uid = new Long(userID);
		user.setId(uid);
		user.setUsername("乔治.W.布什");
		
		user.setIDcard("3307261989123481210");
		user.setPhonenum("168699211710");
		return user;
	}
}
