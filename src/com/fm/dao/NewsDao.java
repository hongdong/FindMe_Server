package com.fm.dao;

import java.util.List;
import java.util.Map;

public interface NewsDao {

	/**
	 * 插入一条消息
	 * 
	 * @param postNews
	 * @param collectionName
	 * @param postId
	 */
	void createPostNews(Map<String, Object> postNews, String collectionName,
			String postId);

	/**
	 * 通过postId和userId查询消息
	 * 
	 * @param postId
	 * @param userId
	 * @return
	 */
	Map<String, Object> queryByparams(String postId, String userId);

	/**
	 * 将用户插入消息中
	 * 
	 * @param postId
	 * @param user
	 * @param updateTime 
	 * @return
	 */
//	Map<String, Object> updateAndFind(String postId, Map<String, Object> user,
//			String updateTime);

	/**
	 * 修改消息同时返回消息
	 * 
	 * @param postId
	 * @param user
	 * @param updateTime 
	 * @param type 1表示插入，0表示更新
	 * @return
	 */
	List<Map<String, Object>> updateAndFind(String postId, String userId, String updateTime, int type);
	
	/**
	 * 将该消息的所有用户的消息状态isDel改为0(未删除)
	 * 
	 * @param postId
	 * @return
	 */
	boolean updateState(String postId);
	
	/**
	 * 创建消息
	 * 
	 * @param postId
	 * @param userId
	 */
	void createPostNews(String postId, String userId);
	
	/**
	 * 刷新消息列表
	 * @param userId 
	 * 
	 * @return
	 */
	List<Map<String, Object>> queryNewsListByRefresh(String userId);
	
	/**
	 * 加载更多的消息列表
	 * 
	 * @param userId
	 * @param newsId
	 * @return
	 */
	List<Map<String, Object>> queryNewsListByLoadMore(String userId,
			String newsId);

}
