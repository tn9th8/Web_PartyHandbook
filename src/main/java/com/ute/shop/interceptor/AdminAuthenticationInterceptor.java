package com.ute.shop.interceptor;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AdminAuthenticationInterceptor implements HandlerInterceptor{

	@Autowired
	private HttpSession httpSession;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if(httpSession.getAttribute("username") != null) {
			return true;
		}
		httpSession.setAttribute("redirect-uri", request.getRequestURI());
		response.sendRedirect("/login");
		return false;
	}
	
}
