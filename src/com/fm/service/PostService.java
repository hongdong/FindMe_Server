package com.fm.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.fm.model.Post;
import com.fm.model.PostMessage;

public interface PostService {

	/**
	 * 添加水贴
	 * 
	 * @param post
	 * @param request
	 * @return
	 */
	boolean insertPost(Post post, HttpServletRequest request);

	/**
	 * 水贴列表
	 * 
	 * @param postId
	 * @param type
	 *            nl:刷新 ol:加载更多
	 * @return
	 */
	List<Map<String, Object>> queryPostList(String postId, String type);

	/**
	 * 发布留言
	 * 
	 * @param postId
	 * @param postMsg
	 * @param request
	 * @return
	 */
	boolean insertPostMsg(String postId, PostMessage postMsg,
			HttpServletRequest request);

	/**
	 * 留言列表
	 * 
	 * @param postId
	 * @param postMsgId
	 * @param index
	 * @param type
	 *            nl:刷新 ol:加载更多
	 * @param isNews
	 *            1:消息 0:不是消息
	 * @return
	 */
	Map<String, Object> queryPostMsgList(String postId, String postMsgId,
			String index, String type, String isNews);

	/**
	 * 水贴点赞
	 * 
	 * @param postId
	 * @param request
	 * @return
	 */
	boolean updateAddPostPraise(String postId, HttpServletRequest request);

	/**
	 * 取消赞
	 * 
	 * @param postId
	 * @param request
	 * @return
	 */
	boolean updateCancelPostPraise(String postId, HttpServletRequest request);

}
