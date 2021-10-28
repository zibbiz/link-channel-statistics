
package com.bzlue.askcrab.link.channel.statistics;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.bzlue.askcrab.link.channel.statistics.dao.ActivityRepository;
import com.bzlue.askcrab.link.channel.statistics.dao.ChannelRepository;
import com.bzlue.askcrab.link.channel.statistics.model.Activity;
import com.bzlue.askcrab.link.channel.statistics.model.Channel;

@Component
public class InitHandler implements ApplicationListener<ApplicationStartedEvent>{

	
	@Autowired
	ChannelRepository channelRepo; 
	
	@Autowired
	ActivityRepository activityRepository;
	
	@Autowired
	RedisTemplateService redistemp;
	
	@Override
	public void onApplicationEvent(ApplicationStartedEvent event) {
		System.out.println("开始加载各渠道数据至缓存中");
		List<Channel> channelList = channelRepo.findAll();
		for(Channel channel : channelList) {
			JSONObject channelInf = new JSONObject();
			channelInf.put("channelCode", channel.getChannelCode());
			channelInf.put("channelName", channel.getChannelName());
			channelInf.put("channelUrl", channel.getUrl());
			channelInf.put("activityId", channel.getActivityId());
			Optional<Activity> activity = activityRepository.findById(Long.parseLong(channel.getActivityId()));
			channelInf.put("activityUrl", activity.get().getBaseUrl());
			redistemp.set(channel.getChannelCode()+IConstans.CHANNEL_CACHE_INF_KEY, channelInf.toJSONString());
		}
		System.out.println("完成加载各渠道数据至缓存中");
	}
}
