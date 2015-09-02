/*package com.test.test.util;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

*//**
 * @author zjq
 * 
 *         create-time 2015年9月1日
 *//*
@Component
public class SessionAccount {

	private static final Logger logger = LoggerFactory
			.getLogger(SessionAccount.class);

	@Autowired
	HttpServletRequest request;

	@Autowired
	HttpServletResponse response;

	//@Value(value = "${session.maxtime}")
	@Value(value = "10")
	private int time;

	private static final String UNIONID = "unionId";

	*//**
	 * 创建session
	 * 
	 * @param unionId
	 *//*
	public void setSession(String unionId) {
		HttpSession session = request.getSession(true);
		session.setAttribute(UNIONID, unionId);
		session.setMaxInactiveInterval(time * 60);
		logger.info("setsession  id : {}", session.getId());
	}

	public String getSessionUnionId() throws IOException {
		logger.info("session id : {} {}", request.getRemoteAddr(), request
				.getSession().getId());

		String unionId = (String) request.getSession().getAttribute(UNIONID);

		logger.info("sessin unionId : {}", unionId);

		if (unionId != null) {
			return unionId;
		} else {
			logger.info("direct into login page");
			response.sendRedirect("loginAgain.htm");
			return "";
		}
	}

}
*/