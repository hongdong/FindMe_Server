package com.fm.service.impl;

import org.springframework.stereotype.Service;

import com.fm.model.User;
import com.fm.service.StatsService;

@Service("statsService")
public class StatsServiceImpl2Mongo extends BaseService implements StatsService {

	@Override
	public boolean userCountStatsPerDay(User user) {
		// TODO Auto-generated method stub
		return statsDao.userCountStatsPerDay(user);
	}

	@Override
	public boolean UserActiveStatsPerDay(User user) {
		// TODO Auto-generated method stub
		return statsDao.UserActiveStatsPerDay(user);
	}

	
}
