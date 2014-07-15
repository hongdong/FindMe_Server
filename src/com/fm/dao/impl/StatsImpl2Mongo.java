package com.fm.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.fm.dao.StatsDao;
import com.fm.model.ActiveBucket;
import com.fm.model.User;
import com.fm.model.UserCountTime;
import com.fm.util.MongoDBUtil;
import com.mongodb.BasicDBObject;


@Repository("statsDao")
public class StatsImpl2Mongo extends BaseDao implements StatsDao {

	public static String UserCountStats = "usercountstats";

	public static String UserActiveStats = "useractivestats";
	
	
	public StatsImpl2Mongo() {
		super(UserCountStats);
	}

	@Override
	public boolean userCountStatsPerDay(User user) {
		/**
		 * _id 用户id 时间
		 */
		return null != MongoDBUtil.getDB().getCollection(UserCountStats).save(
				new BasicDBObject("userId",user.get_id()).append("time", new Date().getTime()));
	}

	@Override
	public boolean UserActiveStatsPerDay(User user) {
		
		return null != MongoDBUtil.getDB().getCollection(UserActiveStats).save(
				new BasicDBObject("userId",user.get_id()).append("time", new Date().getTime()));
	}

	@Override
	public List<UserCountTime> getUserCountActiveStatsBy(String sex,
			int cursor, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserCountTime> getUserCountActiveStatsWeek(String sex,
			int cursor, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserCountTime> getUserCountActiveStatsMonth(String sex,
			int cursor, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ActiveBucket> getUserActiveBucket(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Long> getTotalUserCountInfo() {
		
		Map<String, Long> map= new HashMap<String, Long>();
		
		long total = MongoDBUtil.getDB().getCollection("user").count();
		long girl = MongoDBUtil.getDB().getCollection("user").count(new BasicDBObject("userSex","女"));
		long boy = MongoDBUtil.getDB().getCollection("user").count(new BasicDBObject("userSex","男"));
		
		map.put("total", total);
		map.put("girl", girl);
		map.put("boy", boy);
		
		return map;
	}

	@Override
	public Map<String, Long> getUserCountInfoBySchool(String school) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Long> getUserCountInfoByCity(String city) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
