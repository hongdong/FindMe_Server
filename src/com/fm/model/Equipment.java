package com.fm.model;

public class Equipment {

	private String equitNo;
	private String osType;
	private Integer badge;
	private String sound;

	public Equipment(String equitNo, String osType) {
		super();
		this.equitNo = equitNo;
		this.osType = osType;
	}

	public Equipment(String equitNo, String osType, Integer badge, String sound) {
		super();
		this.equitNo = equitNo;
		this.osType = osType;
		this.badge = badge;
		this.sound = sound;
	}

	public Equipment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getEquitNo() {
		return equitNo;
	}

	public void setEquitNo(String equitNo) {
		this.equitNo = equitNo;
	}

	public String getOsType() {
		return osType;
	}

	public void setOsType(String osType) {
		this.osType = osType;
	}

	public Integer getBadge() {
		return badge;
	}

	public void setBadge(Integer badge) {
		this.badge = badge;
	}

	public String getSound() {
		return sound;
	}

	public void setSound(String sound) {
		this.sound = sound;
	}

}
