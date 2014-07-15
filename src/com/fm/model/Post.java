package com.fm.model;

import java.util.List;

/***********************************************************************
 * Module:  Post.java
 * Author:  Administrator
 * Purpose: Defines the Class Post
 ***********************************************************************/

/**
 * 水贴
 * 
 * 2014-04-25 caizhi 1.0
 * 
 */
public class Post {
	/**
	 * 水贴id
	 * 
	 */
	private String _id;
	/**
	 * 发布人
	 * 
	 */
	private User postUser;
	/**
	 * 发布时间
	 * 
	 */
	private String postReleaseTime;
	/**
	 * 内容
	 * 
	 */
	private String postContent;
	/**
	 * 图片(URL数组)
	 * 
	 */
	private String[] postPhoto;
	/**
	 * 留言
	 * 
	 */
	private List<PostMessage> postMessage;
	/**
	 * 浏览数
	 * 
	 */
	private Integer postReadNumber;
	/**
	 * 留言数
	 * 
	 */
	private Integer postMsgNumber;
	/**
	 * 顶或赞
	 * 
	 */
	private Integer postPraise;
	/**
	 * 顶或赞的用户
	 * 
	 */
	private List<User> postPraiseUser;
	/**
	 * 最后回复时间
	 * 
	 */
	private String postLastReplyTime;
	/**
	 * 置顶(1:置顶 0:不置顶)
	 * 
	 */
	private Integer postTop;
	/**
	 * 官方发布(1:官方 2：个人)
	 * 
	 */
	private Integer postOfficial;

	public Post() {
		super();
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public User getPostUser() {
		return postUser;
	}

	public void setPostUser(User postUser) {
		this.postUser = postUser;
	}

	public String getPostReleaseTime() {
		return postReleaseTime;
	}

	public void setPostReleaseTime(String postReleaseTime) {
		this.postReleaseTime = postReleaseTime;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public String[] getPostPhoto() {
		return postPhoto;
	}

	public void setPostPhoto(String[] postPhoto) {
		this.postPhoto = postPhoto;
	}

	public List<PostMessage> getPostMessage() {
		return postMessage;
	}

	public void setPostMessage(List<PostMessage> postMessage) {
		this.postMessage = postMessage;
	}

	public Integer getPostReadNumber() {
		return postReadNumber;
	}

	public void setPostReadNumber(Integer postReadNumber) {
		this.postReadNumber = postReadNumber;
	}

	public Integer getPostMsgNumber() {
		return postMsgNumber;
	}

	public void setPostMsgNumber(Integer postMsgNumber) {
		this.postMsgNumber = postMsgNumber;
	}

	public Integer getPostPraise() {
		return postPraise;
	}

	public void setPostPraise(Integer postPraise) {
		this.postPraise = postPraise;
	}

	public List<User> getPostPraiseUser() {
		return postPraiseUser;
	}

	public void setPostPraiseUser(List<User> postPraiseUser) {
		this.postPraiseUser = postPraiseUser;
	}

	public String getPostLastReplyTime() {
		return postLastReplyTime;
	}

	public void setPostLastReplyTime(String postLastReplyTime) {
		this.postLastReplyTime = postLastReplyTime;
	}

	public Integer getPostTop() {
		return postTop;
	}

	public void setPostTop(Integer postTop) {
		this.postTop = postTop;
	}

	public Integer getPostOfficial() {
		return postOfficial;
	}

	public void setPostOfficial(Integer postOfficial) {
		this.postOfficial = postOfficial;
	}

}