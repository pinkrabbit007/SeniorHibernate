package com.test.test.controller;
   
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
/**
 * 
 * @author zhangjunqiao
 * @aim The homepage of web service
 */

@Controller  
@RequestMapping("home.do")
//@ResponseBody
public class HomeController {
	
	 private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(method = { RequestMethod.POST,
			RequestMethod.GET })  
	//public String login2(@RequestParam String str)
    public String login2()
    {    
        return "home";
    }  

}
 