package com.stu.ShoppingManagement.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/*
 * 字符集编码拦截器
 * 
 */
public class EncodingInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		return true;
	}
	
}
