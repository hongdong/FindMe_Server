package com.fm.model;

import java.util.List;

public class School {

	private String _id;
	private List<Department> departments;

	/**
	 * 学校名称
	 * 
	 */
	private String schoolName;
	/**
	 * 教务系统URL
	 * 
	 */
	private String schoolLoginUrl;
	/**
	 * 教务系统验证码URL
	 * 
	 */
	private String schoolCodeUrl;
	/**
	 * 教务系统(cookies)类型
	 * 
	 */
	private Integer schoolCookiesType;
	/**
	 * 同步脚本
	 * 
	 */
	private String schoolSysnScript;

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getSchoolLoginUrl() {
		return schoolLoginUrl;
	}

	public void setSchoolLoginUrl(String schoolLoginUrl) {
		this.schoolLoginUrl = schoolLoginUrl;
	}

	public String getSchoolCodeUrl() {
		return schoolCodeUrl;
	}

	public void setSchoolCodeUrl(String schoolCodeUrl) {
		this.schoolCodeUrl = schoolCodeUrl;
	}

	public Integer getSchoolCookiesType() {
		return schoolCookiesType;
	}

	public void setSchoolCookiesType(Integer schoolCookiesType) {
		this.schoolCookiesType = schoolCookiesType;
	}

	public String getSchoolSysnScript() {
		return schoolSysnScript;
	}

	public void setSchoolSysnScript(String schoolSysnScript) {
		this.schoolSysnScript = schoolSysnScript;
	}

}
