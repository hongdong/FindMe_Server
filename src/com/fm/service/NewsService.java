package com.fm.service;

import java.util.List;
import java.util.Map;

public interface NewsService {

	/**
	 * 消息列表
	 * 
	 * @param userId
	 * @param type
	 *            nl,ol
	 * @param newsId
	 * @return
	 */
	List<Map<String, Object>> queryNewsList(String userId, String type,
			String newsId);

	/**
	 * 消息详情
	 * 
	 * @param type
	 *            消息类型(水贴消息是10002)
	 * @param newsId
	 * @return
	 */
	Map<String, Object> queryNewsDetail(String type, String newsId);

}
