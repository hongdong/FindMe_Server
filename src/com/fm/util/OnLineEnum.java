package com.fm.util;

public enum OnLineEnum {
	// 利用构造函数传参
	ONLINE(1), NOTONLINE(0);

	// 定义私有变量
	private Integer onLine;

	// 构造函数，枚举类型只能为私有
	private OnLineEnum(int onLine) {
		this.onLine = onLine;
	}

	public Integer getOnLine() {
		return this.onLine;
	}

	@Override
	public String toString() {
		return String.valueOf(this.onLine);
	}
}
