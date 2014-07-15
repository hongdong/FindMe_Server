package com.fm.model;

import java.io.Serializable;

/***********************************************************************
 * Module:  TaskMessage.java
 * Author:  Administrator
 * Purpose: Defines the Class TaskMessage
 ***********************************************************************/

/**
 * 任务留言
 * 
 * 2014-04-25 caizhi 1.0
 * 
 */
public class TaskMessage implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 留言id
	 * 
	 */
	private String tmId;
	/**
	 * 留言人id
	 * 
	 */
	private String tmUserId;
	/**
	 * 任务id
	 * 
	 */
	private String tmTkId;
	/**
	 * 内容
	 * 
	 */
	private String tmContent;
	/**
	 * 时间
	 * 
	 */
	private String tmTime;
	/**
	 * 被回复的用户Id
	 * 
	 */
	private String tmRepliedUserId;
	/**
	 * 被回复的用户昵称
	 * 
	 */
	private String tmRepliedUserNickName;
	/** 
	 * 被回复的留言id（根）
	 * 
	 */
	private String tmRootId;

	public TaskMessage() {
		super();
	}

	public TaskMessage(String tmId) {
		super();
		this.tmId = tmId;
	}
	
	
	/* getter、setter Method */
	public String getTmId() {
		return tmId;
	}

	public void setTmId(String tmId) {
		this.tmId = tmId;
	}

	public String getTmUserId() {
		return tmUserId;
	}

	public void setTmUserId(String tmUserId) {
		this.tmUserId = tmUserId;
	}

	public String getTmTkId() {
		return tmTkId;
	}

	public void setTmTkId(String tmTkId) {
		this.tmTkId = tmTkId;
	}

	public String getTmContent() {
		return tmContent;
	}

	public void setTmContent(String tmContent) {
		this.tmContent = tmContent;
	}

	public String getTmTime() {
		return tmTime;
	}

	public void setTmTime(String tmTime) {
		this.tmTime = tmTime;
	}

	public String getTmRepliedUserId() {
		return tmRepliedUserId;
	}

	public void setTmRepliedUserId(String tmRepliedUserId) {
		this.tmRepliedUserId = tmRepliedUserId;
	}

	public String getTmRepliedUserNickName() {
		return tmRepliedUserNickName;
	}

	public void setTmRepliedUserNickName(String tmRepliedUserNickName) {
		this.tmRepliedUserNickName = tmRepliedUserNickName;
	}

	public String getTmRootId() {
		return tmRootId;
	}

	public void setTmRootId(String tmRootId) {
		this.tmRootId = tmRootId;
	}
	
}