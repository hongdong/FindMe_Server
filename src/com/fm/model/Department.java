package com.fm.model;


public class Department {

	private String _id;
	/**
	 * 院系名称
	 * 
	 */
	private String deptName;
	/**
	 * 所属学校
	 * 
	 */
	private School school;

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

}
