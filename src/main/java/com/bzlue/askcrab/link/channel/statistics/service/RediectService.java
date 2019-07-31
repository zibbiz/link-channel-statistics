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
 * Created on 2019年6月4日
 *******************************************************************************/


package com.bzlue.askcrab.link.channel.statistics.service;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bzlue.askcrab.link.channel.statistics.RedisTemplateService;
import com.bzlue.askcrab.link.channel.statistics.dao.ActivityRepository;
import com.bzlue.askcrab.link.channel.statistics.dao.ChannelRepository;
import com.bzlue.askcrab.link.channel.statistics.model.Activity;
import com.bzlue.askcrab.link.channel.statistics.model.Channel;


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
	public void rediect(HttpServletRequest request, HttpServletResponse response, @PathVariable String code) throws IOException {
		Channel channel = channelRepository.findChannelByChannelCode(code);
		if(channel != null) {
			Optional<Activity> activity = activityRepository.findById(Long.parseLong(channel.getActivityId()));
			response.sendRedirect(activity.get().getBaseUrl());
			redistemp.incr(code, 1);
		}
	}
}
