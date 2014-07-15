package com.fm.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.fm.dao.NewsDao;
import com.fm.util.CommonVariables;
import com.fm.util.MongoDBUtil;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.DBRef;

@Repository("newsDao")
public class NewsDaoImpl2Mongo extends BaseDao implements NewsDao {

	private static String newsCollection = "news";

	public NewsDaoImpl2Mongo() {
		super(newsCollection);
	}

	@Override
	public void createPostNews(Map<String, Object> postNews,
			String collectionName, String postId) {

		DB db = MongoDBUtil.getDB();
		DBRef dbRef = new DBRef(db, collectionName, postId);
		postNews.put("post", dbRef);

		DBCollection collection = db.getCollection(newsCollection);
		BasicDBObject news = new BasicDBObject(postNews);
		collection.insert(news);

		// super.insertByJson(postNews);
	}

	@Override
	public Map<String, Object> queryByparams(String postId, String userId) {
		// TODO Auto-generated method stub

		BasicDBObject query = new BasicDBObject();
		query.put("post.$id", postId);
		query.put("users._id", userId);

		return super.findOneByParams(query,
				new BasicDBObject("users", 0).append("post", 0));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> updateAndFind(String postId,
			String userId, String updateTime, int type) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> userList = new ArrayList<Map<String, Object>>();
		DB db = MongoDBUtil.getDB();
		if (type == 1) {

			// List<Map<String, Object>> users = new ArrayList<Map<String,
			// Object>>();
			Map<String, Object> user = new HashMap<String, Object>();

			DBRef userDbRef = new DBRef(db, "user", userId);
			user.put("user", userDbRef);
			user.put("isRead", "1");// 是否已经阅读 1：已阅读 0：未阅读
			user.put("isDel", 0);// 是否删除 1：删除 0：未删除
			user.put("_id", userId);

			BasicDBObject users = new BasicDBObject(user);
			BasicDBObject update = new BasicDBObject("users", users);

			Map<String, Object> newsMap = super.findAndModify(
					new BasicDBObject("post.$id", postId),
					new BasicDBObject("$set", new BasicDBObject("updateTime",
							updateTime)).append("$push", update));

			BasicDBList obj = (BasicDBList) newsMap.get("users");
			for (int i = 0; i < obj.size(); i++) {
				BasicDBObject userObj = (BasicDBObject) obj.get(i);
				DBRef user1 = (DBRef) userObj.get("user");
				DBObject user2 = user1.fetch();
				BasicDBObject userEquipment = (BasicDBObject) user2
						.get("userEquipment");
				Map<String, Object> u = userEquipment.toMap();

				String isRead = (String) userObj.get("isRead");
				String userIdAddbadge = (String) userObj.get("_id");
				u.put("isRead", isRead);
				u.put("_id", userIdAddbadge);
				userList.add(u);

				if (isRead.equals("1")) {// 已读用户badge加1
					this.addUserBadge(userIdAddbadge);
					// 同时将已读改为未读
					this.updateReadState(userIdAddbadge);
				}
			}
		} else if (type == 0) {
			Map<String, Object> newsMap = super.findAndModify(
					new BasicDBObject("post.$id", postId),
					new BasicDBObject("$set", new BasicDBObject("updateTime",
							updateTime)));

			super.update(new BasicDBObject("users._id", userId),
					new BasicDBObject("$set", new BasicDBObject("users.isRead",
							"1")), false, true);

			BasicDBList obj = (BasicDBList) newsMap.get("users");
			for (int i = 0; i < obj.size(); i++) {
				BasicDBObject userObj = (BasicDBObject) obj.get(i);
				DBRef user1 = (DBRef) userObj.get("user");
				DBObject user2 = user1.fetch();
				BasicDBObject userEquipment = (BasicDBObject) user2
						.get("userEquipment");
				Map<String, Object> u = userEquipment.toMap();

				String isRead = (String) userObj.get("isRead");
				String userIdAddbadge = (String) userObj.get("_id");
				u.put("isRead", isRead);
				u.put("_id", userIdAddbadge);
				userList.add(u);

				if (isRead.equals("1") && !userId.equals(userIdAddbadge)) {// 已读用户badge加1
					this.addUserBadge(userIdAddbadge);
					// 同时将已读改为未读
					this.updateReadState(userIdAddbadge);
				}
			}

		}
		return userList;

	}

	private void updateReadState(String userId) {
		DB db = MongoDBUtil.getDB();
		DBCollection users = db.getCollection("news");
		BasicDBObject query = new BasicDBObject("users._id", userId);
		BasicDBObject update = new BasicDBObject("$set", new BasicDBObject(
				"users.$.isRead", "0"));
		users.update(query, update);
	}

	private void addUserBadge(String userId) {
		DB db = MongoDBUtil.getDB();
		DBCollection users = db.getCollection("user");
		BasicDBObject query = new BasicDBObject("_id", userId);
		BasicDBObject update = new BasicDBObject("$inc", new BasicDBObject(
				"userEquipment.badge", 1));
		users.update(query, update);
	}

	// @Override
	// public Map<String, Object> updateAndFind(String postId, String userId,
	// String updateTime) {
	// // TODO Auto-generated method stub
	//
	// Map<String, Object> newsMap = super.findAndModify(new BasicDBObject(
	// "post.$id", postId), new BasicDBObject("$set",
	// new BasicDBObject("updateTime", updateTime)));
	// super.update(new BasicDBObject("users._id", userId), new BasicDBObject(
	// "$set", new BasicDBObject("users.isRead", 0)), false, true);
	// return newsMap;
	// }

	@Override
	public boolean updateState(String postId) {
		// TODO Auto-generated method stub

		BasicDBObject q = new BasicDBObject("post.$id", postId);

		Map<String, Object> news = super.findOneByParams(q, null);
		BasicDBList users = (BasicDBList) news.get("users");

		for (int i = 0; i < users.size(); i++) {
			BasicDBObject user = (BasicDBObject) users.get(i);

			BasicDBObject query = new BasicDBObject();
			query.append("_id", postId);
			query.append("users._id", user.get("_id"));

			BasicDBObject update = new BasicDBObject();
			update.append("$set", new BasicDBObject("users." + i + ".isDel", 0));
			update.append("$inc", new BasicDBObject("users." + i
					+ ".userEquipment.badge", 1));

			super.update(query, update, false, true);
		}
		return true;
	}

	@Override
	public void createPostNews(String postId, String userId) {
		// TODO Auto-generated method stub
		DB db = MongoDBUtil.getDB();

		List<Map<String, Object>> users = new ArrayList<Map<String, Object>>();

		Map<String, Object> user = new HashMap<String, Object>();

		DBRef userDbRef = new DBRef(db, "user", userId);
		user.put("user", userDbRef);
		user.put("isRead", "1");// 是否已经阅读 1：已阅读 0：未阅读
		user.put("isDel", 1);// 是否删除 1：删除 0：未删除
		user.put("_id", userId);

		users.add(user);

		Map<String, Object> postNews = new HashMap<String, Object>();
		postNews.put("_id", super.methodUtil.getUUID());
		postNews.put("users", users);
		postNews.put("updateTime", methodUtil.formatDate(new Date(), null, 0));

		// DBRef dbRef = new DBRef(db, "post", "2014062509521826635294167");

		DBRef dbRef = new DBRef(db, "post", postId);
		postNews.put("post", dbRef);

		DBCollection collection = db.getCollection(newsCollection);
		BasicDBObject news = new BasicDBObject(postNews);
		collection.insert(news);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> queryNewsListByRefresh(String userId) {

		List<Map<String, Object>> postList = new ArrayList<Map<String, Object>>();
		BasicDBObject query = new BasicDBObject();
		query.put("users._id", userId);
		query.put("users.isDel", 0);
		BasicDBObject sort = new BasicDBObject();
		sort.put("updateTime", -1);
		List<Map<String, Object>> m = super.findByParams(query, sort,
				CommonVariables.PAGE_SIZE, null);
		for (Map<String, Object> map : m) {

			DBRef dbRef = (DBRef) map.get("post");
			BasicDBObject post = (BasicDBObject) dbRef.fetch();
			post.remove("postMessage");
			Map<String, Object> postMap = post.toMap();
			postMap.put("updateTime", map.get("updateTime"));

			BasicDBList users = (BasicDBList) map.get("users");
			for (int i = 0; i < users.size(); i++) {
				BasicDBObject user = (BasicDBObject) users.get(i);
				String _id = user.getString("_id");
				if (_id.equals(userId)) {
					postMap.put("isRead", user.getString("isRead"));
					break;
				}
			}
			postList.add(postMap);
		}
		return postList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> queryNewsListByLoadMore(String userId,
			String newsId) {
		List<Map<String, Object>> postList = new ArrayList<Map<String, Object>>();
		BasicDBObject query = new BasicDBObject();
		query.put("users._id", userId);
		query.put("users.isDel", 0);
		query.put("_id", new BasicDBObject("$lt",newsId));
		
		BasicDBObject sort = new BasicDBObject();
		sort.put("updateTime", -1);
		List<Map<String, Object>> m = super.findByParams(query, sort,
				CommonVariables.PAGE_SIZE, null);
		for (Map<String, Object> map : m) {

			DBRef dbRef = (DBRef) map.get("post");
			BasicDBObject post = (BasicDBObject) dbRef.fetch();
			post.remove("postMessage");
			Map<String, Object> postMap = post.toMap();
			postMap.put("updateTime", map.get("updateTime"));

			BasicDBList users = (BasicDBList) map.get("users");
			for (int i = 0; i < users.size(); i++) {
				BasicDBObject user = (BasicDBObject) users.get(i);
				String _id = user.getString("_id");
				if (_id.equals(userId)) {
					postMap.put("isRead", user.getString("isRead"));
					break;
				}
			}
			postList.add(postMap);
		}
		return postList;
	}
}
