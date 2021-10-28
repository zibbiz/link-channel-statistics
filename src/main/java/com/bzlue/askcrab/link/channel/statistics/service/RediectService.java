
package com.bzlue.askcrab.link.channel.statistics.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.bzlue.askcrab.link.channel.statistics.IConstans;
import com.bzlue.askcrab.link.channel.statistics.RedisTemplateService;
import com.bzlue.askcrab.link.channel.statistics.dao.ActivityRepository;
import com.bzlue.askcrab.link.channel.statistics.dao.ChannelRepository;

/**
 * 跳转处理服务
 *
 * @author zhidh (mailto:zhitomatobean@163.com)
 */
@RestController
@RequestMapping("/rediect")
public class RediectService {

	@Autowired
	RedisTemplateService redistemp;

	@Autowired
	ChannelRepository channelRepository;

	@Autowired
	ActivityRepository activityRepository;

	@GetMapping("/{code}")
	public void rediect(HttpServletRequest request, HttpServletResponse response, @PathVariable String code)
			throws IOException {
		String channelInfStr = redistemp.get(code + IConstans.CHANNEL_CACHE_INF_KEY);
		JSONObject channelInf = JSONObject.parseObject(channelInfStr);
		try {
			redistemp.incr(code+IConstans.CHANNEL_CACHE_COUNT_KEY, 1);
		} catch (Exception e) {
			System.err.println(String.format("[%s]redis 处理出错", code));
		}

		response.sendRedirect(channelInf.getString("activityUrl"));

	}
}
