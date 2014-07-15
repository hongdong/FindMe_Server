package com.fm.service;

import com.fm.model.User;

public interface StatsService {
	/**
	 * 每日用户数量统计
	 * @return
	 */
	public boolean userCountStatsPerDay(User user);
	/**
	 * 每日用户活跃统计
	 * @param _id
	 * @return
	 */
	public boolean UserActiveStatsPerDay(User user);
}
