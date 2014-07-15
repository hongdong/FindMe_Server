package com.fm.model;

import java.io.Serializable;

/**
 * 私信
 * 
 * @author caizhi 2014-05-14 1.0
 * 
 */
public class Letter implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 私信Id
	 * 
	 */
	private String letterId;

	/**
	 * 发送方id
	 * 
	 */
	private String letterSendUserId;

	/**
	 * 接收方id
	 * 
	 */
	private String letterReceiveUserId;

	/**
	 * 发送时间
	 * 
	 */
	private String letterTime;

	/**
	 * 内容
	 * 
	 */
	private String letterContent;

	public Letter() {
		super();
	}

	public Letter(String letterId) {
		this.letterId = letterId;
	}

	/* getter、setter method */
	public String getLetterId() {
		return letterId;
	}

	public void setLetterId(String letterId) {
		this.letterId = letterId;
	}

	public String getLetterSendUserId() {
		return letterSendUserId;
	}

	public void setLetterSendUserId(String letterSendUserId) {
		this.letterSendUserId = letterSendUserId;
	}

	public String getLetterReceiveUserId() {
		return letterReceiveUserId;
	}

	public void setLetterReceiveUserId(String letterReceiveUserId) {
		this.letterReceiveUserId = letterReceiveUserId;
	}

	public String getLetterTime() {
		return letterTime;
	}

	public void setLetterTime(String letterTime) {
		this.letterTime = letterTime;
	}

	public String getLetterContent() {
		return letterContent;
	}

	public void setLetterContent(String letterContent) {
		this.letterContent = letterContent;
	}

}
