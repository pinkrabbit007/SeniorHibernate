package com.test.test.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author zjq
 * @aim 浏览器里输入http://localhost:8080/seniorhibernate/test.helloservlet
 * 只要是.helloservlet结尾的，都可以被拦进Servlet_1这个servlet。
 * 今天也是第一次尝试自己做一个servlet
 */
public class Servlet_1 extends HttpServlet{
	public void doGet(HttpServletRequest request,
			  HttpServletResponse response)throws IOException,ServletException{
			  //第三步：获取HTTP请求中的参数信息
			  String clientName=request.getParameter("clientName");
			  if(clientName!=null)
			   clientName=new String(clientName.getBytes("ISO-8859-1"),"GB2312");
			  else
			   clientName="我自己写了一个servlet";

			  //第四步：生成HTTP响应结果
			  PrintWriter out;
			  String title="Servlet_1";
			  String heading1="Servlet_1的doGet方法的输出是：";
			  //set content type
			  response.setContentType("text/html;charset=GB2312");
			  //write html page
			  out=response.getWriter();
			  out.print("<HTML><HEAD><TITLE>"+title+"</TITLE>");
			  out.print("</HEAD><BODY>");
			  out.print(heading1);
			  out.println("<h1><p>"+clientName+" 在2015年9月2日</h1>");
			  out.print("</BODY></HTML>");

			  out.close();

	}
}
