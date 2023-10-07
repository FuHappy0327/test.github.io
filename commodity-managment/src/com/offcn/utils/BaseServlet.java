package com.offcn.utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * 专门用来被继承的Servlet
 *
 */
public class BaseServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//解决请求中文乱码问题
		request.setCharacterEncoding("utf-8");
		// 1.获取请求参数way,即要调用的方法的方法名
		String methodName = request.getParameter("way");
		try {
			// 2.获取方法对象
			/*
			 * getDeclaredMethod()方法需要传入两种类型的参数： 第一个参数是要调用的方法的方法名
			 * 第二个参数是要调用的方法中需要传入的参数的类型
			 */
			Method method = this.getClass().getDeclaredMethod(methodName, HttpServletRequest.class,
					HttpServletResponse.class);
			// 3.设置访问权限
			method.setAccessible(true);
			// 4.调用方法
			/*
			 * invoke()方法需要传入两种类型的参数 第一个参数是要调用那个对象的方法 第二个参数是调用方法时要传入的参数
			 */
			method.invoke(this, request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
