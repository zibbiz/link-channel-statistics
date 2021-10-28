
package com.bzlue.askcrab.link.channel.statistics.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.bzlue.askcrab.link.channel.statistics.model.Channel;

/**
 * 渠道数据库操作
 *
 * @author zhidh (mailto:zhitomatobean@163.com)
 */
@Component
public interface ChannelRepository extends JpaRepository<Channel, Long>{
	
	Channel findChannelByChannelCode(String channelCode);
	
	List<Channel> findChannelsByActivityId(String activityId);
}
