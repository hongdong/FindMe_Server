package com.fm.model;

import java.io.Serializable;

/***********************************************************************
 * Module:  City.java
 * Author:  Administrator
 * Purpose: Defines the Class City
 ***********************************************************************/

/**
 * 城市
 * 
 * 2014-04-25 caizhi 1.0
 */
public class City implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 城市id
	 * 
	 */
	private String cityId;
	/**
	 * 城市编码
	 * 
	 */
	private String cityNo;
	/**
	 * 城市名称
	 * 
	 */
	private String cityName;
	/**
	 * 归属省编码
	 * 
	 */
	private String cityProNo;
	/**
	 * 圈子id
	 * 
	 */
	private String cityCId;

	public City() {
		super();
	}

	public City(String cityId) {
		super();
		this.cityId = cityId;
	}

	public City(String cityId, String cityNo, String cityName,
			String cityProNo) {
		super();
		this.cityId = cityId;
		this.cityNo = cityNo;
		this.cityName = cityName;
		this.cityProNo = cityProNo;
	}


	/* getter、setter Method */
	
	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getCityNo() {
		return cityNo;
	}

	public void setCityNo(String cityNo) {
		this.cityNo = cityNo;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCityProNo() {
		return cityProNo;
	}

	public void setCityProNo(String cityProNo) {
		this.cityProNo = cityProNo;
	}

	public String getCityCId() {
		return cityCId;
	}

	public void setCityCId(String cityCId) {
		this.cityCId = cityCId;
	}

}