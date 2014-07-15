package com.fm.model;

import java.io.Serializable;

/***********************************************************************
 * Module:  Activities.java
 * Author:  caizhi
 * Purpose: Defines the Class Activities
 ***********************************************************************/

/**
 * 活动
 * 
 * @author 2014-04-25 caizhi 1.0
 */
public class Activities implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 活动id
	 * 
	 */
	private String actId;
	/**
	 * 发布人id
	 * 
	 */
	private String actUserId;
	/**
	 * 所属圈子id
	 * 
	 */
	private String actCId;
	/**
	 * 标题
	 * 
	 */
	private String actTitle;
	/**
	 * 内容
	 * 
	 */
	private String actContent;
	/**
	 * 发布时间
	 * 
	 */
	private String actReleaseTime;
	/**
	 * 开始时间
	 * 
	 */
	private String actBeginTime;
	/**
	 * 结束时间
	 * 
	 */
	private String actEndTime;
	/**
	 * 举办地址
	 * 
	 */
	private String actAddress;
	/**
	 * 类别
	 * 
	 */
	private String actTypeId;
	/**
	 * 图片 (多图用'|'分隔)
	 * 
	 */
	private String actPhoto;
	/**
	 * 省编码
	 * 
	 */
	private String actProNo;
	/**
	 * 城市编码
	 * 
	 */
	private String actCityNo;
	/**
	 * 地区(县)编码
	 * 
	 */
	private String actAreaNo;
	/**
	 * 浏览数
	 * 
	 */
	private Integer actReadNumber;
	/**
	 * 留言数
	 * 
	 */
	private Integer actMessageNumber;
	/**
	 * 参加人数
	 * 
	 */
	private Integer actJoinNumber;
	/**
	 * 过期
	 * 
	 */
	private Integer actOutTime;
	/**
	 * 分享圈子id（多个用|分开）
	 * 
	 */
	private String actShareCircleId;
	/**
	 * 最后回复时间
	 * 
	 */
	private String actLastReplyTime;
	/**
	 * 是否热门（1：是 0：不是）
	 * 
	 */
	private Integer actTopType;
	/**
	 * 标签
	 * 
	 */
	private String actTag;
	/**
	 * 发布方 1:官方 2:个人
	 * 
	 */
	private Integer actPublisher;

	public Activities() {
		super();
	}

	public Activities(String actId) {
		super();
		this.actId = actId;
	}

	/* getter、setter Method */

	public String getActId() {
		return actId;
	}

	public void setActId(String actId) {
		this.actId = actId;
	}

	public String getActUserId() {
		return actUserId;
	}

	public void setActUserId(String actUserId) {
		this.actUserId = actUserId;
	}

	public String getActCId() {
		return actCId;
	}

	public void setActCId(String actCId) {
		this.actCId = actCId;
	}

	public String getActTitle() {
		return actTitle;
	}

	public void setActTitle(String actTitle) {
		this.actTitle = actTitle;
	}

	public String getActContent() {
		return actContent;
	}

	public void setActContent(String actContent) {
		this.actContent = actContent;
	}

	public String getActReleaseTime() {
		return actReleaseTime;
	}

	public void setActReleaseTime(String actReleaseTime) {
		this.actReleaseTime = actReleaseTime;
	}

	public String getActBeginTime() {
		return actBeginTime;
	}

	public void setActBeginTime(String actBeginTime) {
		this.actBeginTime = actBeginTime;
	}

	public String getActEndTime() {
		return actEndTime;
	}

	public void setActEndTime(String actEndTime) {
		this.actEndTime = actEndTime;
	}

	public String getActAddress() {
		return actAddress;
	}

	public void setActAddress(String actAddress) {
		this.actAddress = actAddress;
	}

	public String getActTypeId() {
		return actTypeId;
	}

	public void setActTypeId(String actTypeId) {
		this.actTypeId = actTypeId;
	}

	public String getActPhoto() {
		return actPhoto;
	}

	public void setActPhoto(String actPhoto) {
		this.actPhoto = actPhoto;
	}

	public String getActProNo() {
		return actProNo;
	}

	public void setActProNo(String actProNo) {
		this.actProNo = actProNo;
	}

	public String getActCityNo() {
		return actCityNo;
	}

	public void setActCityNo(String actCityNo) {
		this.actCityNo = actCityNo;
	}

	public String getActAreaNo() {
		return actAreaNo;
	}

	public void setActAreaNo(String actAreaNo) {
		this.actAreaNo = actAreaNo;
	}

	public Integer getActReadNumber() {
		return actReadNumber;
	}

	public void setActReadNumber(Integer actReadNumber) {
		this.actReadNumber = actReadNumber;
	}

	public Integer getActMessageNumber() {
		return actMessageNumber;
	}

	public void setActMessageNumber(Integer actMessageNumber) {
		this.actMessageNumber = actMessageNumber;
	}

	public Integer getActJoinNumber() {
		return actJoinNumber;
	}

	public void setActJoinNumber(Integer actJoinNumber) {
		this.actJoinNumber = actJoinNumber;
	}

	public Integer getActOutTime() {
		return actOutTime;
	}

	public void setActOutTime(Integer actOutTime) {
		this.actOutTime = actOutTime;
	}

	public String getActShareCircleId() {
		return actShareCircleId;
	}

	public void setActShareCircleId(String actShareCircleId) {
		this.actShareCircleId = actShareCircleId;
	}

	public String getActLastReplyTime() {
		return actLastReplyTime;
	}

	public void setActLastReplyTime(String actLastReplyTime) {
		this.actLastReplyTime = actLastReplyTime;
	}

	public Integer getActTopType() {
		return actTopType;
	}

	public void setActTopType(Integer actTopType) {
		this.actTopType = actTopType;
	}

	public String getActTag() {
		return actTag;
	}

	public void setActTag(String actTag) {
		this.actTag = actTag;
	}

	public Integer getActPublisher() {
		return actPublisher;
	}

	public void setActPublisher(Integer actPublisher) {
		this.actPublisher = actPublisher;
	}

}