package com.fm.model;


/***********************************************************************
 * Module:  PostMessage.java
 * Author:  Administrator
 * Purpose: Defines the Class PostMessage
 ***********************************************************************/

/**
 * 水贴留言
 * 
 * 2014-04-25 caizhi 1.0
 * 
 */
public class PostMessage {
	/**
	 * 留言id
	 * 
	 */
	private String _id;
	/**
	 * 留言发布人
	 * 
	 */
	private User postMsgUser;
	/**
	 * 内容
	 * 
	 */
	private String postMsgContent;
	/**
	 * 时间
	 * 
	 */
	private String postMsgTime;

	public PostMessage() {
		super();
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public User getPostMsgUser() {
		return postMsgUser;
	}

	public void setPostMsgUser(User postMsgUser) {
		this.postMsgUser = postMsgUser;
	}

	public String getPostMsgContent() {
		return postMsgContent;
	}

	public void setPostMsgContent(String postMsgContent) {
		this.postMsgContent = postMsgContent;
	}

	public String getPostMsgTime() {
		return postMsgTime;
	}

	public void setPostMsgTime(String postMsgTime) {
		this.postMsgTime = postMsgTime;
	}

}