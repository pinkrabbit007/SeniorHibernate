package com.test.test.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller  
@RequestMapping("register.do")
public class RegisterController {
	 private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);
	@RequestMapping(method = {RequestMethod.POST})
	public String login()
    {   
		return "register";   
    }
    
}
