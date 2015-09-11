package com.test.test.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @date 2015-09-11
 * @aim 用response实现文件的下载
 * @web http://localhost:8080/seniorhibernate/test.downloadservlet
 */
 
public class Servlet_3 extends HttpServlet {
	
	private static final long serialVersionUID = -8960927332270206331L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = this.getServletContext().getRealPath("/WEB-INF/upload/1.jpg");
		String filename = path.substring(path.lastIndexOf("\\") + 1);
		
		response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8"));
		
        InputStream in = null;
        OutputStream out = null;
        
       
        try {
        	in = new FileInputStream(path);
        	int len = 0;
        	 byte[] buffer = new byte[1024];
        	 out = response.getOutputStream();
        	while((len = in.read(buffer)) > 0) {
        		out.write(buffer,0,len);
        	}
        	
        }catch(Exception e) {
        	throw new RuntimeException(e);
        }finally {
        	if(in != null) {
        		try {
        			in.close();
        		}catch(Exception e) {
        			throw new RuntimeException(e);
        		}
        		
        	}
        }
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
