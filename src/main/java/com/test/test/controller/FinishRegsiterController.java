/*package com.test.test.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.test.domain.User;
import com.test.test.service.UserService;

@Controller  
@RequestMapping("finishregister.do")
public class FinishRegsiterController {
	 private static final Logger logger = LoggerFactory.getLogger(FinishRegsiterController.class);
	@RequestMapping(params = {"username","password","phonenum","IDcard"},method = {RequestMethod.POST})
	public String finishregister(String username,String password,String phonenum,String IDcard)
    {   		
		UserService userService = new UserService();
		User user1 = new User();
		user1.setUsername(username );
		user1.setPassword(password);
		user1.setPhonenum(phonenum);
		user1.setIDcard(IDcard);
		userService.insertUser(user1);   
		return "home";   
    }
} */