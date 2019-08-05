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
 * Created on 2019年6月21日
 *******************************************************************************/

package com.bzlue.askcrab.link.channel.statistics.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.bzlue.askcrab.link.channel.statistics.IConstans;
import com.bzlue.askcrab.link.channel.statistics.RedisTemplateService;
import com.bzlue.askcrab.link.channel.statistics.dao.ActivityRepository;
import com.bzlue.askcrab.link.channel.statistics.dao.ChannelRepository;
import com.bzlue.askcrab.link.channel.statistics.model.Activity;
import com.bzlue.askcrab.link.channel.statistics.model.Channel;

/**
 * 渠道管理服务
 *
 * @author zhidh (mailto:zhitomatobean@163.com)
 */
@RestController
@RequestMapping("/channel")
public class ChannelService {

	@Autowired
	private ChannelRepository channelRepository;

	@Autowired
	private ActivityRepository activityRepository;
	
	@Autowired
	RedisTemplateService redistemp;
	
	@Value("${operation.domain-url}")
	private String domainUrl;

	@PostMapping
	public void addChannel(@RequestBody Channel channel) {
		String channelCode = UUID.randomUUID().toString().replaceAll("-", "");
		channel.setChannelCode(channelCode);
		channel.setUrl(domainUrl + "/rediect/" + channelCode);
		
		JSONObject channelInf = new JSONObject();
		channelInf.put("channelCode", channel.getChannelCode());
		channelInf.put("channelName", channel.getChannelName());
		channelInf.put("channelUrl", channel.getUrl());
		channelInf.put("activityId", channel.getActivityId());
		Optional<Activity> activity = activityRepository.findById(Long.parseLong(channel.getActivityId()));
		channelInf.put("activityUrl", activity.get().getBaseUrl());
		redistemp.set(channel.getChannelCode()+IConstans.CHANNEL_CACHE_INF_KEY, channelInf.toJSONString());
		
		channelRepository.save(channel);
	}
}
