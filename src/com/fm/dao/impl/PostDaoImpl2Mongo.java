package com.fm.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.fm.dao.PostDao;
import com.fm.model.Post;
import com.fm.model.PostMessage;
import com.fm.util.JsonUtil;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;

@Repository("postDao")
public class PostDaoImpl2Mongo extends BaseDao implements PostDao {

	private static String postCollection = "post";

	public PostDaoImpl2Mongo() {
		super(postCollection);
	}

	@Override
	public boolean insertPost(Post post) {
		return super.insertByJsonReturnInfo(post, post.get_id());
	}

	@Override
	public List<Map<String, Object>> queryPostListByRefresh(Integer pageSize) {
		BasicDBObject sort = new BasicDBObject("postReleaseTime", -1);
		BasicDBObject column = new BasicDBObject();
		column.put("postPraiseUser", 0);
		column.put("postMessage", 0);
		return super.findByParams(null, sort, pageSize, column);
	}

	@Override
	public List<Map<String, Object>> queryPostListByLoadMore(String postId,
			Integer pageSize) {
		BasicDBObject query = new BasicDBObject("_id", new BasicDBObject("$lt",
				postId));
		BasicDBObject sort = new BasicDBObject("postReleaseTime", -1);
		BasicDBObject column = new BasicDBObject();
		column.put("postPraiseUser", 0);
		column.put("postMessage", 0);
		return super.findByParams(query, sort, pageSize, column);
	}

	@Override
	public boolean insertPostMsg(String postId, PostMessage postMsg) {

		BasicDBObject newObj2 = new BasicDBObject("postMsgNumber", 1);

		String json = JsonUtil.Object2Json(postMsg);
		json = json.replace("id", "_id");
		DBObject dbObject = (DBObject) JSON.parse(json);

		BasicDBObject newObj3 = new BasicDBObject("postMessage", dbObject);

		return super.update(new BasicDBObject("_id", postId),
				new BasicDBObject("$inc", newObj2).append("$push", newObj3),
				false, true);

	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> queryPostMsgListByRefresh(String postId,
			Integer pageSize) {
		int[] slice = new int[] { 0, pageSize };
		BasicDBObject query = new BasicDBObject();
		query.put("_id", postId);
		BasicDBObject column = new BasicDBObject();
		column.put("postMessage", new BasicDBObject("$slice", slice));

		Map<String, Object> postMap = super.findOneByParams(query, column);

		List<Map<String, Object>> postMsgList = new ArrayList<Map<String, Object>>();
		Map<String, Object> postMsg = new HashMap<String, Object>();

		if (postMap != null && postMap.isEmpty() == false) {
			postMsgList = (List<Map<String, Object>>) postMap
					.get("postMessage");
			// 下标
			Map<String, Object> index = new HashMap<String, Object>();
			index.put("beginIndex", 0);
			if(postMsgList != null && postMsgList.isEmpty() == false)
				index.put("endIndex", postMsgList.size());
			else
				index.put("endIndex", 0);
				
			postMsg.put("postMsgList", postMsgList);
			postMsg.put("index", index);
		}
		return postMsg;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> queryPostMsgListByLoadMore(String postId,
			int beginIndex, int endIndex) {
		int[] slice = new int[] { beginIndex, endIndex };
		BasicDBObject query = new BasicDBObject();
		query.put("_id", postId);
		BasicDBObject column = new BasicDBObject();
		column.put("postMessage", new BasicDBObject("$slice", slice));

		Map<String, Object> postMap = super.findOneByParams(query, column);

		List<Map<String, Object>> postMsgList = new ArrayList<Map<String, Object>>();
		Map<String, Object> postMsg = new HashMap<String, Object>();

		if (postMap != null && postMap.isEmpty() == false) {
			postMsgList = (List<Map<String, Object>>) postMap
					.get("postMessage");
			// 下标
			Map<String, Object> index = new HashMap<String, Object>();
			index.put("beginIndex", beginIndex);
			if(postMsgList != null && postMsgList.isEmpty() == false)
				index.put("endIndex", beginIndex + postMsgList.size());
			else
				index.put("endIndex", beginIndex);
				
			postMsg.put("postMsgList", postMsgList);
			postMsg.put("index", index);
		}
		return postMsg;
	}

	@Override
	public boolean updateAddPostPraise(String postId, String userId) {

		BasicDBObject newObj2 = new BasicDBObject("postPraise", 1);

		BasicDBObject newObj3 = new BasicDBObject("postPraiseUser",
				new BasicDBObject("_id", userId));

		return super.update(new BasicDBObject("_id", postId),
				new BasicDBObject("$inc", newObj2).append("$push", newObj3),
				false, true);
	}

	@Override
	public boolean updateCancelPostPraise(String postId, String userId) {

		BasicDBObject newObj2 = new BasicDBObject("postPraise", -1);

		BasicDBObject newObj3 = new BasicDBObject("postPraiseUser",
				new BasicDBObject("_id", userId));

		return super.update(new BasicDBObject("_id", postId),
				new BasicDBObject("$inc", newObj2).append("$pull", newObj3),
				false, true);
	}

	@Override
	public boolean queryPostPraiseByUser(String postId, String userId) {
		BasicDBObject query = new BasicDBObject();
		query.put("_id", postId);
		query.put("postPraiseUser._id", userId);
		Map<String, Object> resultMap = super.findOneByParams(query, null);
		if (resultMap != null && resultMap.isEmpty() == false)
			return true;
		return false;
	}

	@Override
	public void updateAddPostReadNumber(String postId) {

		BasicDBObject newObj2 = new BasicDBObject("postReadNumber", 1);

		super.update(new BasicDBObject("_id", postId), new BasicDBObject(
				"$inc", newObj2), false, true);

	}

}
