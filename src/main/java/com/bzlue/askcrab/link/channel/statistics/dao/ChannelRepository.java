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


package com.bzlue.askcrab.link.channel.statistics.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.bzlue.askcrab.link.channel.statistics.model.Channel;

@Component
public interface ChannelRepository extends JpaRepository<Channel, Long>{
	
	Channel findChannelByChannelCode(String channelCode);
	
	List<Channel> findChannelsByActivityId(String activityId);
}
