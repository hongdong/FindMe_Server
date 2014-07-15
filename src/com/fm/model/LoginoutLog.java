package com.fm.model;

import java.io.Serializable;

/***********************************************************************
 * Module:  LoginoutLog.java
 * Author:  Administrator
 * Purpose: Defines the Class LoginoutLog
 ***********************************************************************/

/**
 * 注销日志
 * 
 * 2014-04-25 caizhi 1.0
 * 
 */
public class LoginoutLog implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 注销日志id
	 * 
	 */
	private String loginoutId;
	/**
	 * ip地址
	 * 
	 */
	private String loginoutIp;
	/**
	 * 注销时间
	 * 
	 */
	private String loginoutTime;
	/**
	 * 用户id
	 * 
	 */
	private String loginoutUserId;

	public LoginoutLog() {
		super();
	}

	public LoginoutLog(String loginoutId) {
		super();
		this.loginoutId = loginoutId;
	}

	public LoginoutLog(String loginoutId, String loginoutIp, String loginoutTime,
			String loginoutUserId) {
		super();
		this.loginoutId = loginoutId;
		this.loginoutIp = loginoutIp;
		this.loginoutTime = loginoutTime;
		this.loginoutUserId = loginoutUserId;
	}
	
	/* getter、setter Method */
	public String getLoginoutId() {
		return loginoutId;
	}

	public void setLoginoutId(String loginoutId) {
		this.loginoutId = loginoutId;
	}

	public String getLoginoutIp() {
		return loginoutIp;
	}

	public void setLoginoutIp(String loginoutIp) {
		this.loginoutIp = loginoutIp;
	}

	public String getLoginoutTime() {
		return loginoutTime;
	}

	public void setLoginoutTime(String loginoutTime) {
		this.loginoutTime = loginoutTime;
	}

	public String getLoginoutUserId() {
		return loginoutUserId;
	}

	public void setLoginoutUserId(String loginoutUserId) {
		this.loginoutUserId = loginoutUserId;
	}

}