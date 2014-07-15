package com.fm.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.fm.model.Post;
import com.fm.model.PostMessage;
import com.fm.model.User;
import com.fm.service.PostService;
import com.fm.util.CommonVariables;

@Service("postService")
public class PostServiceImpl2Mongo extends BaseService implements PostService {

	@Override
	public boolean insertPost(Post post, HttpServletRequest request) {
		User user = new User();
		user.set_id(sessionUtil.getSessionUserId(request));

		post.setPostUser(user);
		// post.set_id(methodUtil.getUUID());
		// 置顶(1:置顶 0:不置顶) 默认不置顶
		post.setPostTop(0);
		post.setPostReleaseTime(methodUtil.formatDate(new Date(), null, 0));

		post.setPostReadNumber(0);
		post.setPostMsgNumber(0);
		post.setPostPraise(0);

		boolean flag = this.postDao.insertPost(post);
		if (flag) {
			super.createPostNews(post.get_id(),
					sessionUtil.getSessionUserId(request),
					sessionUtil.getSessionUserEquipment(request));
		}

		return flag;
	}

	@Override
	public List<Map<String, Object>> queryPostList(String postId, String type) {
		List<Map<String, Object>> postList = new ArrayList<Map<String, Object>>();
		if (type != null && type.equals("nl")) {
			postList = this.postDao
					.queryPostListByRefresh(CommonVariables.PAGE_SIZE);
		} else if (type != null && type.equals("ol")) {
			postList = this.postDao.queryPostListByLoadMore(postId,
					CommonVariables.PAGE_SIZE);
		}
		return postList;
	}

	@Override
	public boolean insertPostMsg(String postId, PostMessage postMsg,
			HttpServletRequest request) {
		User user = new User();
		user.set_id(sessionUtil.getSessionUserId(request));

		postMsg.setPostMsgUser(user);
		postMsg.set_id(methodUtil.getUUID());

		postMsg.setPostMsgTime(methodUtil.formatDate(new Date(), null, 0));

		boolean flag = this.postDao.insertPostMsg(postId, postMsg);

		if (flag) {
			super.sendPostNews(postId, sessionUtil.getSessionUserId(request),
					sessionUtil.getSessionUserEquipment(request));
		}

		return flag;
	}

	@Override
	public Map<String, Object> queryPostMsgList(String postId, String index,
			String type, String userId, String isNews) {
		Map<String, Object> postMsg = new HashMap<String, Object>();
		if (type != null && type.equals("nl")) {
			postMsg = this.postDao.queryPostMsgListByRefresh(postId,
					CommonVariables.PAGE_SIZE);
			// 增加水贴的阅读量
			this.postDao.updateAddPostReadNumber(postId);
		} else if (type != null && type.equals("ol")) {
			int beginIndex = Integer.parseInt(index);
			int endIndex = beginIndex + CommonVariables.PAGE_SIZE;
			postMsg = this.postDao.queryPostMsgListByLoadMore(postId,
					beginIndex, endIndex);
		}
		if (userId != null && !userId.equals("")) {
			// 用户是否已经点赞
			boolean flag = this.postDao.queryPostPraiseByUser(postId, userId);
			postMsg.put("isPraise", flag);
		}
		if (isNews != null && isNews.equals("1")) {
			// 是消息列表中请求，将badge减1
			this.userDao.minusUserBadge(userId);
		}
		return postMsg;
	}

	@Override
	public boolean updateAddPostPraise(String postId, HttpServletRequest request) {
		return this.postDao.updateAddPostPraise(postId,
				sessionUtil.getSessionUserId(request));
	}

	@Override
	public boolean updateCancelPostPraise(String postId,
			HttpServletRequest request) {
		return this.postDao.updateCancelPostPraise(postId,
				sessionUtil.getSessionUserId(request));
	}

}
