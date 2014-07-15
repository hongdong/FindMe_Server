package com.fm.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.fm.model.ActiveBucket;
import com.fm.model.User;
import com.fm.model.UserCountTime;

public interface StatsDao {
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
	
	/**
	 * 按日查询每日用户数量
	 * @param sex  		性别
	 * @param cursor	第几条起
	 * @param size		多少条
	 * @return
	 */
	public List<UserCountTime> getUserCountActiveStatsBy(String sex,int cursor,int size);
	/**
	 * 按星期
	 * @param sex
	 * @param cursor
	 * @param size
	 * @return
	 */
	public List<UserCountTime> getUserCountActiveStatsWeek(String sex,int cursor,int size);
	
	/**
	 * 按月
	 * @param sex
	 * @param cursor
	 * @param size
	 * @return
	 */
	public List<UserCountTime> getUserCountActiveStatsMonth(String sex,int cursor,int size);
	
	/**
	 * 查看某一天用户登录情况
	 * @param date
	 * @return 按小时返回
	 */
	public List<ActiveBucket> getUserActiveBucket(Date date);
	
	/**
	 * 获取用户数量
	 * 总数量
	 * 男生数量
	 * 女生数量
	 * @return
	 */
	public Map<String,Long> getTotalUserCountInfo();
	/**
	 * 根据学校获取用户数量
	 * @param school
	 * @return
	 */
	public Map<String,Long> getUserCountInfoBySchool(String school);
	/**
	 * 根据地图获取用户数量
	 * @param city
	 * @return
	 */
	public Map<String,Long> getUserCountInfoByCity(String city);
}
