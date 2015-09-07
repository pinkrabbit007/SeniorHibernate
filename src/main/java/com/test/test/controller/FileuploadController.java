package com.test.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @date 2015-9-7
 * @author zhangjunqiao
 * @aim 学习file upload
 */

@Controller
@RequestMapping("fileupload.do")
public class FileuploadController {
	@RequestMapping(method = { RequestMethod.POST, RequestMethod.GET })
	public String login2() {
		return "fileupload";
	}
}
