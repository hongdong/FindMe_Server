package com.fm.service.impl;


import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.fm.service.BackStageService;

@Service("backStageService")
public class BackStageServiceImpl2Mongo extends BaseService implements BackStageService {

	@Override
	public boolean auth(String username, String password) {
		// TODO Auto-generated method stub
		return super.backStageUserDao.auth(username, password);
	}

	@Override
	public List<Map<String, Object>> getNewUserList(int cursor, int page_size,
			Date date) {
		// TODO Auto-generated method stub
		return super.userDao.getNewUserList(cursor, page_size, date);
	}

}
