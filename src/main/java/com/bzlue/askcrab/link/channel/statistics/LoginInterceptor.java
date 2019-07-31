package com.bzlue.askcrab.link.channel.statistics;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;


/**
 * 登录验证拦截器
 * @author zhidh
 *
 */
@Component
public class LoginInterceptor implements HandlerInterceptor{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		response.setHeader("Content-Type", "text/html;charset=UTF-8");
		if(request.getSession().getAttribute("userName") == null){
			response.sendRedirect(request.getContextPath() + "/login");
			return false;
		}
		return true;
	}
}
