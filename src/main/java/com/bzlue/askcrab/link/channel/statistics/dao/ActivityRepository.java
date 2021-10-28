
package com.bzlue.askcrab.link.channel.statistics.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.bzlue.askcrab.link.channel.statistics.model.Activity;

/**
 * 活动数据库操作
 *
 * @author zhidh (mailto:zhitomatobean@163.com)
 */
@Component
public interface ActivityRepository extends JpaRepository<Activity, Long>{
}
