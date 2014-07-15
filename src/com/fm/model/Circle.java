package com.fm.model;

import java.io.Serializable;

/***********************************************************************
 * Module:  Circle.java
 * Author:  Administrator
 * Purpose: Defines the Class Circle
 ***********************************************************************/

/**
 * 圈子
 * 
 * 2014-04-25 caizhi 1.0
 */
public class Circle implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 圈子id
	 * 
	 */
	private String cId;
	/**
	 * 圈子名称
	 * 
	 */
	private String cName;
	/**
	 * 圈子Logo
	 * 
	 */
	private String cLogo;
	/**
	 * 圈子描述
	 * 
	 */
	private String cDescription;
	/**
	 * 圈子人数
	 * 
	 */
	private Long cUserCount;
	/**
	 * 圈子人数
	 * 
	 */
	private Integer cUserMaxCount;
	/**
	 * 活动数量
	 * 
	 */
	private Integer cActNumber;
	/**
	 * 圈子类型 1:普通圈子 2：帮帮圈
	 * 
	 */
	private Integer cType;

	public Circle() {
		super();
	}

	public Circle(String cId) {
		super();
		this.cId = cId;
	}

	public Circle(String cId, String cName, String cDescription, Long cUserCount) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.cDescription = cDescription;
		this.cUserCount = cUserCount;
	}

	/* getter、setter Method */
	public String getcId() {
		return cId;
	}

	public void setcId(String cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcLogo() {
		return cLogo;
	}

	public void setcLogo(String cLogo) {
		this.cLogo = cLogo;
	}

	public String getcDescription() {
		return cDescription;
	}

	public void setcDescription(String cDescription) {
		this.cDescription = cDescription;
	}

	public Long getcUserCount() {
		return cUserCount;
	}

	public void setcUserCount(Long cUserCount) {
		this.cUserCount = cUserCount;
	}

	public Integer getcUserMaxCount() {
		return cUserMaxCount;
	}

	public void setcUserMaxCount(Integer cUserMaxCount) {
		this.cUserMaxCount = cUserMaxCount;
	}

	public Integer getcActNumber() {
		return cActNumber;
	}

	public void setcActNumber(Integer cActNumber) {
		this.cActNumber = cActNumber;
	}

	public Integer getcType() {
		return cType;
	}

	public void setcType(Integer cType) {
		this.cType = cType;
	}

}