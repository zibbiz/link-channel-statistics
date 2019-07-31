package com.bzlue.askcrab.link.channel.statistics.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 页面跳转处理
 *
 * @author zhidh (mailto:zhitomatobean@163.com)
 */
@Controller
public class PageController {
	 
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
}
