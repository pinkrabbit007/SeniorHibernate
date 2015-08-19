/*package com.test.test.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.test.test.service.UserService;


@Controller  
@RequestMapping("login.do")
public class LoginController {
	 private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	@RequestMapping(params = {"username","password"},method = { RequestMethod.POST})  
    public ModelAndView login(String username,String password)
    {    

		System.out.println("username is "+ username +" password is "+password);
		UserService userService = new UserService();
 		
		try {
	 		userService.searchUserbySQL(username);
	 		ModelAndView mav = new ModelAndView("succlogging");
	 		if(userService.searchUsergrantedbySQL(username)){
				mav.addObject("granted", "申请成功");
			}
	 		else
	 			mav.addObject("granted", "尚未申请到");
			return mav;
		} catch (Exception e) { 
			ModelAndView mav = new ModelAndView("unsucc"); 
			return mav; 
		} 
   }  
}*/