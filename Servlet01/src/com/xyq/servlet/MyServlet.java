package com.xyq.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置服务器解析编码格式
			req.setCharacterEncoding("utf-8");
		//设置服务器响应编码格式
			resp.setCharacterEncoding("utf-8");
		//设置浏览器解析编码格式
			resp.setContentType("text/html; charset=utf-8");
			
			System.out.println("************请求消息********************");
		//请求
			//获取请求内容
				String uname = req.getParameter("uname");
				String pwd = req.getParameter("pwd");
				System.out.println("uname: " + uname + "pwd: " + pwd);
				System.out.println("************响应消息********************");
		//响应
			//响应内容
				resp.getWriter().write("name: " + uname + "pwd: " + pwd);
	}
}
