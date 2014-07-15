package com.fm.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.fm.service.NewsService;

@Service("newsService")
public class NewsServiceImpl2Mongo extends BaseService implements NewsService {

	@Override
	public List<Map<String, Object>> queryNewsList(String userId, String type,
			String newsId) {
		// TODO 还未测试
		List<Map<String, Object>> newsList = new ArrayList<Map<String, Object>>();
		if (type != null && type.equals("nl")) {
			newsList = this.newsDao.queryNewsListByRefresh(userId);
		} else if (type != null && type.equals("ol")) {
			newsList = this.newsDao.queryNewsListByLoadMore(userId, newsId);
		}
		return newsList;
	}

	@Override
	public Map<String, Object> queryNewsDetail(String type, String newsId) {
		// TODO Auto-generated method stub
		// 水贴消息
		return null;
	}

}
