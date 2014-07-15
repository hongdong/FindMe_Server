package com.fm.dao;

import java.util.List;
import java.util.Map;

import com.fm.model.Post;
import com.fm.model.PostMessage;

public interface PostDao {

	/**
	 * 插入一条水贴
	 * 
	 * @param post
	 * @return
	 */
	boolean insertPost(Post post);

	/**
	 * 刷新水贴列表
	 * 
	 * @param pageSize
	 * @return
	 */
	List<Map<String, Object>> queryPostListByRefresh(Integer pageSize);

	/**
	 * 加载更多的水贴
	 * 
	 * @param postId
	 * @param pageSize
	 * @return
	 */
	List<Map<String, Object>> queryPostListByLoadMore(String postId,
			Integer pageSize);

	/**
	 * 插入一条留言
	 * 
	 * @param postId 
	 * @param postMsg
	 * @return
	 */
	boolean insertPostMsg(String postId, PostMessage postMsg);

	/**
	 * 查询留言
	 * 
	 * @param postId
	 * @param pageSize
	 * @return
	 */
	Map<String, Object> queryPostMsgListByRefresh(String postId,
			Integer pageSize);

	/**
	 * 加载更多留言
	 * 
	 * @param postId
	 * @param beginIndex
	 * @param endIndex
	 * @return
	 */
	Map<String, Object> queryPostMsgListByLoadMore(String postId,
			int beginIndex, int endIndex);
	
	/**
	 * 水贴点赞
	 * 
	 * @param postId
	 * @param userId
	 * @return
	 */
	boolean updateAddPostPraise(String postId, String userId);
	
	/**
	 * 取消点赞
	 * 
	 * @param postId
	 * @param sessionUserId
	 * @return
	 */
	boolean updateCancelPostPraise(String postId, String userId);
	
	/**
	 * 用户是否已经点赞
	 * 
	 * @param postId
	 * @param userId 
	 * @return
	 */
	boolean queryPostPraiseByUser(String postId, String userId);

	/**
	 * 增加水贴阅读量
	 * 
	 * @param postId
	 */
	void updateAddPostReadNumber(String postId);

}
