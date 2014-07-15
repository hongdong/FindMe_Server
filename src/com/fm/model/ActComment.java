package com.fm.model;

import java.io.Serializable;

/***********************************************************************
 * Module:  ActComment.java
 * Author:  caizhi
 * Purpose: Defines the Class ActComment
 ***********************************************************************/

/**
 * 活动评论
 * 
 * @author caizhi 2014-04-25 1.0
 */
public class ActComment implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 评论id
	 * 
	 */
	private String cmtId;
	/**
	 * 活动id
	 * 
	 */
	private String cmtActId;
	/**
	 * 评论发布人id
	 * 
	 */
	private String cmtUserId;
	/**
	 * 内容
	 * 
	 */
	private String cmtContent;
	/**
	 * 评论时间
	 * 
	 */
	private String cmtTime;
	/**
	 * 被回复的评论id
	 * 
	 */
	private String cmtRootId;
	/**
	 * 被回复的用户Id
	 * 
	 */
	private String cmtRepliedUserId;
	/**
	 * 被回复的用户昵称
	 * 
	 */
	private String cmtRepliedUserNickName;

	public ActComment() {
		super();
	}

	public ActComment(String cmtId, String cmtActId, String cmtUserId,
			String cmtContent, String cmtTime, String cmtRootId,
			String cmtRepliedUserId) {
		super();
		this.cmtId = cmtId;
		this.cmtActId = cmtActId;
		this.cmtUserId = cmtUserId;
		this.cmtContent = cmtContent;
		this.cmtTime = cmtTime;
		this.cmtRootId = cmtRootId;
		this.cmtRepliedUserId = cmtRepliedUserId;
	}

	/* getter、setter Method */
	public String getCmtId() {
		return cmtId;
	}

	public void setCmtId(String cmtId) {
		this.cmtId = cmtId;
	}

	public String getCmtActId() {
		return cmtActId;
	}

	public void setCmtActId(String cmtActId) {
		this.cmtActId = cmtActId;
	}

	public String getCmtUserId() {
		return cmtUserId;
	}

	public void setCmtUserId(String cmtUserId) {
		this.cmtUserId = cmtUserId;
	}

	public String getCmtContent() {
		return cmtContent;
	}

	public void setCmtContent(String cmtContent) {
		this.cmtContent = cmtContent;
	}

	public String getCmtTime() {
		return cmtTime;
	}

	public void setCmtTime(String cmtTime) {
		this.cmtTime = cmtTime;
	}

	public String getCmtRootId() {
		return cmtRootId;
	}

	public void setCmtRootId(String cmtRootId) {
		this.cmtRootId = cmtRootId;
	}

	public String getCmtRepliedUserId() {
		return cmtRepliedUserId;
	}

	public void setCmtRepliedUserId(String cmtRepliedUserId) {
		this.cmtRepliedUserId = cmtRepliedUserId;
	}

	public String getCmtRepliedUserNickName() {
		return cmtRepliedUserNickName;
	}

	public void setCmtRepliedUserNickName(String cmtRepliedUserNickName) {
		this.cmtRepliedUserNickName = cmtRepliedUserNickName;
	}

}