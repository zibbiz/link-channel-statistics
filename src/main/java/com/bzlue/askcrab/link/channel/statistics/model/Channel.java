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

package com.bzlue.askcrab.link.channel.statistics.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "channel")
public class Channel implements Serializable {

	private static final long serialVersionUID = 6126788337198853018L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "activityId")
	private String activityId;

	@Column(name = "channelCode")
	private String channelCode;

	@Column(name = "channelName")
	private String channelName;

	@Column(name = "url")
	private String url;

	@Column(name = "remark")
	private String remark;

	@Column(name = "total")
	private int total;

	/**
	 * @return Returns the id.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return Returns the activityId.
	 */
	public String getActivityId() {
		return activityId;
	}

	/**
	 * @param activityId The activityId to set.
	 */
	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}

	/**
	 * @return Returns the channelCode.
	 */
	public String getChannelCode() {
		return channelCode;
	}

	/**
	 * @param channelCode The channelCode to set.
	 */
	public void setChannelCode(String channelCode) {
		this.channelCode = channelCode;
	}

	/**
	 * @return Returns the channelName.
	 */
	public String getChannelName() {
		return channelName;
	}

	/**
	 * @param channelName The channelName to set.
	 */
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	/**
	 * @return Returns the remark.
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark The remark to set.
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * @return Returns the total.
	 */
	public int getTotal() {
		return total;
	}

	/**
	 * @param total The total to set.
	 */
	public void setTotal(int total) {
		this.total = total;
	}

	/**
	 * @return Returns the url.
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url The url to set.
	 */
	public void setUrl(String url) {
		this.url = url;
	}

}
