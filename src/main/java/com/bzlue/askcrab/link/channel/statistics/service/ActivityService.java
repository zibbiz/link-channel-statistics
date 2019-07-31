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

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bzlue.askcrab.link.channel.statistics.RedisTemplateService;
import com.bzlue.askcrab.link.channel.statistics.dao.ActivityRepository;
import com.bzlue.askcrab.link.channel.statistics.dao.ChannelRepository;
import com.bzlue.askcrab.link.channel.statistics.model.Activity;
import com.bzlue.askcrab.link.channel.statistics.model.Channel;

@RestController
@RequestMapping("/activity")
public class ActivityService {

	@Autowired
	private ActivityRepository activityDao;

	@Autowired
	private ChannelRepository channelRepository;

	@Autowired
	RedisTemplateService redistemp;

	@PostMapping()
	public void addActivity(@RequestBody Activity activity) {
		activity.setCreateTime(new Date());
		activityDao.save(activity);
	}
	
	@GetMapping
	public List<Activity> findAllActivity() {
		List<Activity> list= activityDao.findAll();
		return list;
	}

	@GetMapping("/{activityId}")
	public List<Channel> getChannelsByActivity(@PathVariable String activityId) {
		List<Channel> channelList = channelRepository.findChannelsByActivityId(activityId);
		for (Channel tempChannel : channelList) {
			String channelCode = tempChannel.getChannelCode();
			String total = redistemp.get(channelCode);
			tempChannel.setTotal(Integer.parseInt(total == null ? "0" : total));
		}
		return channelList;

	}
}
