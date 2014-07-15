package com.fm.model;

import java.io.Serializable;

/***********************************************************************
 * Module:  LoginLog.java
 * Author:  Administrator
 * Purpose: Defines the Class LoginLog
 ***********************************************************************/

/**
 * 登录日志
 * 
 * 2014-04-25 caizhi 1.0
 */
public class LoginLog implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 登录日志id
	 * 
	 */
	private String loginId;
	/**
	 * ip地址
	 * 
	 */
	private String loginIp;
	/**
	 * 登录时间
	 * 
	 */
	private String loginTime;
	/**
	 * 用户id
	 * 
	 */
	private String loginUserId;

	public LoginLog() {
		super();
	}

	public LoginLog(String loginId) {
		super();
		this.loginId = loginId;
	}

	public LoginLog(String loginId, String loginIp, String loginTime,
			String loginUserId) {
		super();
		this.loginId = loginId;
		this.loginIp = loginIp;
		this.loginTime = loginTime;
		this.loginUserId = loginUserId;
	}
	
	/* getter、setter Method */
	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public String getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}

	public String getLoginUserId() {
		return loginUserId;
	}

	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}
}