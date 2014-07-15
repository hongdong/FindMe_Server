package com.fm.model;

public class TaskEnroll {

	/**
	 * 任务报名id
	 * 
	 */
	private String enrollId;
	/**
	 * 任务id
	 * 
	 */
	private String enrollTkId;
	/**
	 * 用户id
	 * 
	 */
	private String enrollUserId;
	/**
	 * 报名时间
	 * 
	 */
	private String enrollTime;

	public TaskEnroll() {
		super();
	}

	/* getter、setter Method */
	public String getEnrollId() {
		return enrollId;
	}

	public void setEnrollId(String enrollId) {
		this.enrollId = enrollId;
	}

	public String getEnrollTkId() {
		return enrollTkId;
	}

	public void setEnrollTkId(String enrollTkId) {
		this.enrollTkId = enrollTkId;
	}

	public String getEnrollUserId() {
		return enrollUserId;
	}

	public void setEnrollUserId(String enrollUserId) {
		this.enrollUserId = enrollUserId;
	}

	public String getEnrollTime() {
		return enrollTime;
	}

	public void setEnrollTime(String enrollTime) {
		this.enrollTime = enrollTime;
	}

}
