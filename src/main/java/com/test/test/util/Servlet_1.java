/*package com.test.test.util;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Servlet_1 {
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, java.io.IOException {
		PrintWriter out = res.getWriter();
		out.println("<html>"); // 向 客户端浏览器 显示 信息
		out.println("<b>FirstServlet</b>");
		out.println("</html>");

		
		 * 或者 OutputStream out = res.getOutputStream ;
		 * out.write("FirstServlet".getBytes());
		 

	}
}
*/