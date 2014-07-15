package com.fm.util;

public enum NewsEnum {

	// 消息大类型
	HELP(1), CIRCLE(2), ACTIVITIES(3), LETTER(4),
	// 消息小类型
	TYPE_ONE(1), TYPE_TWO(2), TYPE_THREE(3), TYPE_FOUR(4),
	// 推送消息标题
	TITLE_LETTER("私信"), TITLE_HELP_ENROLL("报名"), TITLE_HELP_MSG("留言"), TITLE_ACT_JOIN(
			"参加活动"), TITLE_ACT_CMT("活动评论");

	// 消息类型
	public Integer TYPE_NO;

	// 消息title
	public String TITLE;

	private NewsEnum(Integer TYPE_NO) {
		this.TYPE_NO = TYPE_NO;
	}

	private NewsEnum(String TITLE) {
		this.TITLE = TITLE;
	}

}
