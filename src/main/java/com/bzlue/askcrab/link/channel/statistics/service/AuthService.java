package com.bzlue.askcrab.link.channel.statistics.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户认证服务
 *
 * @author zhidh (mailto:zhitomatobean@163.com)
 */
@RestController
@RequestMapping("/auth")
public class AuthService {
	@PostMapping("/login")
	public Map<String, Object> login(HttpServletRequest request, @RequestBody HashMap<String, Object> param){
		Map<String, Object> result = new HashMap<String, Object>();
		String userName = param.get("userName").toString();
		String password = param.get("password").toString();
		//验证登录
		if("sysadmin".equals(userName) && "000000".equals(password)) {
			request.getSession().setAttribute("userName", userName);
			result.put("retCode", "00000");
		} else {
			result.put("retCode", "-1");
			result.put("msg", "账号或密码不正确");
		}
		return result;
	}
}
