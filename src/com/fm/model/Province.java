package com.fm.model;

import java.io.Serializable;

/***********************************************************************
 * Module:  Province.java
 * Author:  Administrator
 * Purpose: Defines the Class Province
 ***********************************************************************/

/**
 * 省份
 * 
 * 2014-04-25 caizhi 1.0
 * 
 */
public class Province implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 省份id
	 * 
	 */
	private String proId;
	/**
	 * 省份编码
	 * 
	 */
	private String proNo;
	/**
	 * 省份名称
	 * 
	 */
	private String proName;

	public Province() {
		super();
	}

	public Province(String proId) {
		super();
		this.proId = proId;
	}

	public Province(String proId, String proNo, String proName) {
		super();
		this.proId = proId;
		this.proNo = proNo;
		this.proName = proName;
	}

	/* getter、setter Method */
	public String getProId() {
		return proId;
	}

	public void setProId(String proId) {
		this.proId = proId;
	}

	public String getProNo() {
		return proNo;
	}

	public void setProNo(String proNo) {
		this.proNo = proNo;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	@Override
	public String toString() {
		String str = "proId:" + proId + "\tproName:" + proName + "\tproNo:" + proNo; 
		return str;
	}

}