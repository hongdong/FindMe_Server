package com.fm.model;

import java.io.Serializable;

/**
 * 推送信息实体
 * 
 * @author caizhi 2014-06-12 1.0
 * 
 */
public class PushInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 推送id与userId共享主键
	 * 
	 */
	private String pushId;
	/**
	 * 设备编码
	 * 
	 */
	private String pushRegisterId;
	/**
	 * 设备类型 1：IOS 2：Android
	 * 
	 */
	private Integer pushType;
	/**
	 * 是否接收推送消息 0:不接收 1:接收
	 * 
	 */
	private Integer pushReceive;

	/**
	 * 是否在线 0:不在线 1:在线
	 * 
	 */
	private Integer pushOnLine;

	public PushInfo() {
		super();
	}

//	public PushInfo(String pushId, Integer pushReceive) {
//		super();
//		this.pushId = pushId;
//		this.pushReceive = pushReceive;
//	}
	
	public PushInfo(String pushId, Integer pushOnLine) {
		super();
		this.pushId = pushId;
		this.pushOnLine = pushOnLine;
	}

	public PushInfo(String pushId, String pushRegisterId, Integer pushType,
			Integer pushReceive,Integer pushOnLine) {
		super();
		this.pushId = pushId;
		this.pushRegisterId = pushRegisterId;
		this.pushType = pushType;
		this.pushReceive = pushReceive;
		this.pushOnLine = pushOnLine;
	}

	public String getPushId() {
		return pushId;
	}

	public void setPushId(String pushId) {
		this.pushId = pushId;
	}

	public String getPushRegisterId() {
		return pushRegisterId;
	}

	public void setPushRegisterId(String pushRegisterId) {
		this.pushRegisterId = pushRegisterId;
	}

	public Integer getPushType() {
		return pushType;
	}

	public void setPushType(Integer pushType) {
		this.pushType = pushType;
	}

	public Integer getPushReceive() {
		return pushReceive;
	}

	public void setPushReceive(Integer pushReceive) {
		this.pushReceive = pushReceive;
	}

	public Integer getPushOnLine() {
		return pushOnLine;
	}

	public void setPushOnLine(Integer pushOnLine) {
		this.pushOnLine = pushOnLine;
	}

}
