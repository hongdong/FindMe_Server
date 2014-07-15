package com.fm.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fm.dao.BackStageUserDao;
import com.fm.util.MongoDBUtil;
import com.mongodb.BasicDBObject;


@Repository("backStageUserDao")
public class BackStageUserImpl2Mongo extends BaseDao implements BackStageUserDao {

	public static String collectionName = "bsuser";
	
	public BackStageUserImpl2Mongo() {
		super(collectionName);
	}

	@Override
	public boolean auth(String username, String password) {
		
		BasicDBObject query = new BasicDBObject("username",username).append("password", password);
		
		return 0!=MongoDBUtil.getDB().getCollection(collectionName).count(query);
	}

	@Override
	public boolean AddOpenMatchCity(String city) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<String> getOpenMatchCities() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
