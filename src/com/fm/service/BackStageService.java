package com.fm.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface BackStageService {
	
	public boolean auth(String username, String password);
	
	public List<Map<String, Object>> getNewUserList(int cursor,int page_size,Date date);
}
