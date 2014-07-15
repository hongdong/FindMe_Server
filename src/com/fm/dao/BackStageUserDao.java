package com.fm.dao;

import java.util.List;


public interface BackStageUserDao {
	
	public boolean auth(String username,String password);
	
	/**
	 * 开放匹配城市
	 * @param city
	 * @return
	 */
	public boolean AddOpenMatchCity(String city);
	
	/**
	 * 获取开放城市列表
	 * @return
	 */
	public List<String> getOpenMatchCities();
	
	
	
}
