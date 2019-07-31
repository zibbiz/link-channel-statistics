/*******************************************************************************
 * $Header$
 * $Revision$
 * $Date$
 *
 *==============================================================================
 *
 * Copyright (c) 2016-2026 Primeton Technologies, Ltd.
 * All rights reserved.
 * 
 * Created on 2019年2月13日
 *******************************************************************************/

package com.bzlue.askcrab.link.channel.statistics;

import javax.annotation.Resource;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 
 * TODO 此处填写 class 信息
 *
 * @author zhidh (mailto:zhidh@primeton.com)
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
	@Resource
	private LoginInterceptor loginInterceptor;

	/**
	 * 跨域解决
	 */
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "POST", "DELETE")
				.allowedHeaders("Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
						"Access-Control-Request-Headers")
				.exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials")
				.allowCredentials(true).maxAge(3600);
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		// 配置拦截器
		registry.addInterceptor(loginInterceptor).addPathPatterns("/**"). // 配置所有页面拦截
				excludePathPatterns("/login").excludePathPatterns("/auth/login"); // 排除登录调用接口
	}

}
