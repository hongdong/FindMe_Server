package com.fm.model;

import java.io.Serializable;

/**
 * 消息
 * 
 * @author caizhi 2014-05-14 1.0
 * 
 */
public class News implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 消息id
	 * 
	 */
	private String newsId;

	/**
	 * 1、校园帮帮圈消息 2、圈子消息 3、活动消息 4、私信消息
	 * 
	 */
	private Integer newsBigType;

	/**
	 * 1.1、被留言、或被回复 1.2、有人报名了你的任务 2.1、参加活动 2.2、评论 4.1、私信为1
	 * 
	 */
	private Integer newsSmallType;

	/**
	 * 消息发起者id
	 * 
	 */
	private String newsSendUserId;

	/**
	 * 消息响应者id
	 * 
	 */
	private String newsReceiveUserId;

	/**
	 * 消息归属地ID
	 * 
	 */
	private String newsSourceId;

	/**
	 * 消息概要
	 * 
	 */
	private String newsContent;

	/**
	 * 消息生成时间
	 * 
	 */
	private String newsTime;

	public News() {
		super();
	}

	public News(String newsId, Integer newsBigType, Integer newsSmallType,
			String newsSendUserId, String newsReceiveUserId,
			String newsSourceId, String newsContent, String newsTime) {
		super();
		this.newsId = newsId;
		this.newsBigType = newsBigType;
		this.newsSmallType = newsSmallType;
		this.newsSendUserId = newsSendUserId;
		this.newsReceiveUserId = newsReceiveUserId;
		this.newsSourceId = newsSourceId;
		this.newsContent = newsContent;
		this.newsTime = newsTime;
	}

	/* getter、setter Method */
	public String getNewsId() {
		return newsId;
	}

	public void setNewsId(String newsId) {
		this.newsId = newsId;
	}

	public Integer getNewsBigType() {
		return newsBigType;
	}

	public void setNewsBigType(Integer newsBigType) {
		this.newsBigType = newsBigType;
	}

	public Integer getNewsSmallType() {
		return newsSmallType;
	}

	public void setNewsSmallType(Integer newsSmallType) {
		this.newsSmallType = newsSmallType;
	}

	public String getNewsSendUserId() {
		return newsSendUserId;
	}

	public void setNewsSendUserId(String newsSendUserId) {
		this.newsSendUserId = newsSendUserId;
	}

	public String getNewsReceiveUserId() {
		return newsReceiveUserId;
	}

	public void setNewsReceiveUserId(String newsReceiveUserId) {
		this.newsReceiveUserId = newsReceiveUserId;
	}

	public String getNewsSourceId() {
		return newsSourceId;
	}

	public void setNewsSourceId(String newsSourceId) {
		this.newsSourceId = newsSourceId;
	}

	public String getNewsContent() {
		return newsContent;
	}

	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}

	public String getNewsTime() {
		return newsTime;
	}

	public void setNewsTime(String newsTime) {
		this.newsTime = newsTime;
	}

}
