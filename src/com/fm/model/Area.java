package com.fm.model;

import java.io.Serializable;

/***********************************************************************
 * Module:  Area.java
 * Author:  Administrator
 * Purpose: Defines the Class Area
 ***********************************************************************/

/**
 * 地区（县）
 * 
 * 2014-04-25 caizhi 1.0
 * 
 */
public class Area implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 地区id
	 * 
	 */
	private String areaId;
	/**
	 * 城市id
	 * 
	 */
	private String areaCityId;
	/**
	 * 地区名称
	 * 
	 */
	private String areaName;
	/**
	 * 地区编码
	 * 
	 */
	private String areaNo;
	/**
	 * 归属城市编码
	 * 
	 */
	private String areaCityNo;

	public Area() {
		super();
	}

	public Area(String areaId) {
		super();
		this.areaId = areaId;
	}

	public Area(String areaId, String areaCityId, String areaName,
			String areaNo, String areaCityNo) {
		super();
		this.areaId = areaId;
		this.areaCityId = areaCityId;
		this.areaName = areaName;
		this.areaNo = areaNo;
		this.areaCityNo = areaCityNo;
	}

	/* getter、setter Method */
	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	public String getAreaCityId() {
		return areaCityId;
	}

	public void setAreaCityId(String areaCityId) {
		this.areaCityId = areaCityId;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getAreaNo() {
		return areaNo;
	}

	public void setAreaNo(String areaNo) {
		this.areaNo = areaNo;
	}

	public String getAreaCityNo() {
		return areaCityNo;
	}

	public void setAreaCityNo(String areaCityNo) {
		this.areaCityNo = areaCityNo;
	}

}