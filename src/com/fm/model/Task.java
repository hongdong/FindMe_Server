package com.fm.model;

import java.io.Serializable;

/***********************************************************************
 * Module:  Task.java
 * Author:  Administrator
 * Purpose: Defines the Class Task
 ***********************************************************************/

/**
 * 任务
 * 
 * 2014-04-25 caizhi 1.0
 * 
 */
public class Task implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 任务id
	 * 
	 */
	private String tkId;
	/**
	 * 发布人id
	 * 
	 */
	private String tkUserId;
	/**
	 * 归属圈子id
	 * 
	 */
	private String tkCId;
	/**
	 * 图片（多张图片用','分隔）
	 * 
	 */
	private String tkPhoto;
	/**
	 * 内容
	 * 
	 */
	private String tkContent;
	/**
	 * 发布时间
	 * 
	 */
	private String tkReleaseTime;
	/**
	 * 截至时间
	 * 
	 */
	private String tkEndTime;
	/**
	 * 报酬
	 * 
	 */
	private String tkReward;
	/**
	 * 浏览数
	 * 
	 */
	private Integer tkReadNumber;
	/**
	 * 留言数
	 * 
	 */
	private Integer tkMsgNumber;
	/**
	 * 报名数
	 * 
	 */
	private Integer tkRegistrationNumber;
	/**
	 * 完结
	 * 
	 */
	private Integer tkFinish;
	/**
	 * 过期
	 * 
	 */
	private Integer tkOutTime;
	/**
	 * 完结时间
	 * 
	 */
	private String tkFinishTime;
	/**
	 * 最后回复时间
	 * 
	 */
	private String tkLastReplyTime;
	/**
	 * 任务类型
	 * 
	 */
	private String tkTypeId;

	public Task() {
		super();
	}

	public Task(String tkId) {
		super();
		this.tkId = tkId;
	}

	/* getter、setter Method */

	public String getTkId() {
		return tkId;
	}

	public void setTkId(String tkId) {
		this.tkId = tkId;
	}

	public String getTkUserId() {
		return tkUserId;
	}

	public void setTkUserId(String tkUserId) {
		this.tkUserId = tkUserId;
	}

	public String getTkCId() {
		return tkCId;
	}

	public void setTkCId(String tkCId) {
		this.tkCId = tkCId;
	}

	public String getTkPhoto() {
		return tkPhoto;
	}

	public void setTkPhoto(String tkPhoto) {
		this.tkPhoto = tkPhoto;
	}

	public String getTkContent() {
		return tkContent;
	}

	public void setTkContent(String tkContent) {
		this.tkContent = tkContent;
	}

	public String getTkReleaseTime() {
		return tkReleaseTime;
	}

	public void setTkReleaseTime(String tkReleaseTime) {
		this.tkReleaseTime = tkReleaseTime;
	}

	public String getTkEndTime() {
		return tkEndTime;
	}

	public void setTkEndTime(String tkEndTime) {
		this.tkEndTime = tkEndTime;
	}

	public String getTkReward() {
		return tkReward;
	}

	public void setTkReward(String tkReward) {
		this.tkReward = tkReward;
	}

	public Integer getTkReadNumber() {
		return tkReadNumber;
	}

	public void setTkReadNumber(Integer tkReadNumber) {
		this.tkReadNumber = tkReadNumber;
	}

	public Integer getTkMsgNumber() {
		return tkMsgNumber;
	}

	public void setTkMsgNumber(Integer tkMsgNumber) {
		this.tkMsgNumber = tkMsgNumber;
	}

	public Integer getTkRegistrationNumber() {
		return tkRegistrationNumber;
	}

	public void setTkRegistrationNumber(Integer tkRegistrationNumber) {
		this.tkRegistrationNumber = tkRegistrationNumber;
	}

	public Integer getTkFinish() {
		return tkFinish;
	}

	public void setTkFinish(Integer tkFinish) {
		this.tkFinish = tkFinish;
	}

	public Integer getTkOutTime() {
		return tkOutTime;
	}

	public void setTkOutTime(Integer tkOutTime) {
		this.tkOutTime = tkOutTime;
	}

	public String getTkFinishTime() {
		return tkFinishTime;
	}

	public void setTkFinishTime(String tkFinishTime) {
		this.tkFinishTime = tkFinishTime;
	}

	public String getTkLastReplyTime() {
		return tkLastReplyTime;
	}

	public void setTkLastReplyTime(String tkLastReplyTime) {
		this.tkLastReplyTime = tkLastReplyTime;
	}

	public String getTkTypeId() {
		return tkTypeId;
	}

	public void setTkTypeId(String tkTypeId) {
		this.tkTypeId = tkTypeId;
	}

}