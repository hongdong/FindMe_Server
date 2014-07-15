package com.fm.model;

import java.io.Serializable;

/***********************************************************************
 * Module:  JoinActivities.java
 * Author:  Administrator
 * Purpose: Defines the Class JoinActivities
 ***********************************************************************/

/**
 * 参加活动
 * 
 * 2014-04-25 caizhi 1.0
 */
public class JoinActivities implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 参加活动id
	 * 
	 */
	private String joinId;
	/**
	 * 活动id
	 * 
	 */
	private String joinActId;
	/**
	 * 参加活动的用户id
	 * 
	 */
	private String joinUserId;
	/**
	 * 时间
	 * 
	 */
	private String joinTime;

	public JoinActivities() {
		super();
	}

	public JoinActivities(String joinId) {
		super();
		this.joinId = joinId;
	}

	public JoinActivities(String joinId, String joinActId, String joinUserId,
			String joinTime) {
		super();
		this.joinId = joinId;
		this.joinActId = joinActId;
		this.joinUserId = joinUserId;
		this.joinTime = joinTime;
	}

	/* getter、setter Method */
	public String getJoinId() {
		return joinId;
	}

	public void setJoinId(String joinId) {
		this.joinId = joinId;
	}

	public String getJoinActId() {
		return joinActId;
	}

	public void setJoinActId(String joinActId) {
		this.joinActId = joinActId;
	}

	public String getJoinUserId() {
		return joinUserId;
	}

	public void setJoinUserId(String joinUserId) {
		this.joinUserId = joinUserId;
	}

	public String getJoinTime() {
		return joinTime;
	}

	public void setJoinTime(String joinTime) {
		this.joinTime = joinTime;
	}

}