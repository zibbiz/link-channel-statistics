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

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.bzlue.askcrab.link.channel.statistics.model.Activity;

@Component
public interface ActivityRepository extends JpaRepository<Activity, Long>{
}