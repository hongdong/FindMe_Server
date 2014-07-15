package com.fm.model;

/**
 * 院系
 * 
 * @author caizhi 2014-04-28 1.0
 * 
 */
public class ScDepartment {

	/**
	 * 院系id
	 * 
	 */
	private String deptId;
	/**
	 * 院系编码
	 * 
	 */
	private String deptNo;
	/**
	 * 所属学校id
	 * 
	 */
	private String deptScNo;
	/**
	 * 院系名称
	 * 
	 */
	private String deptName;

	public ScDepartment() {
		super();
	}

	public ScDepartment(String deptId) {
		super();
		this.deptId = deptId;
	}

	/* getter、setter Method */
	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}

	public String getDeptScNo() {
		return deptScNo;
	}

	public void setDeptScNo(String deptScNo) {
		this.deptScNo = deptScNo;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}



}
