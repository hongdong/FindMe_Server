package com.fm.dao.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.fm.dao.UserDao;
import com.fm.model.Equipment;
import com.fm.model.User;
import com.fm.util.MongoDBUtil;
import com.fm.util.OnLineEnum;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.DBRef;
import com.mongodb.WriteResult;

@Repository("userDao")
public class UserDaoImpl2Mongo extends BaseDao implements UserDao {

	private static String userCollection = "user";

	public UserDaoImpl2Mongo() {
		super(userCollection);
	}

	@Override
	public Map<String, Object> queryUserByQqOpenId(String openId) {

		return super.findOneByParams(new BasicDBObject("userQqOpenId", openId),
				new BasicDBObject("userLoginLog", 0));
	}

	@Override
	public Map<String, Object> queryUserBySinaOpenId(String openId) {

		return super.findOneByParams(
				new BasicDBObject("userSinaOpenId", openId), new BasicDBObject(
						"userLoginLog", 0));
	}

	@Override
	public void insertUser(User user) {

		super.insertByJson(user);

	}

	@Override
	public Map<String, Object> findOneById(String _id) {

		return super.findOneById(_id, new BasicDBObject("userLoginLog", 0));
	}

	@Override
	public void updateUserLoginLog(String userId, String ipAddress,
			String loginTime, Integer isOnLine, Equipment newUserEquipment) {

		BasicDBObject newObj = new BasicDBObject();
		newObj.put("userLastLoginIpAddress", ipAddress);
		newObj.put("userLastLoginTime", loginTime);
		newObj.put("isOnLine", isOnLine);
		newObj.put("userEquipment.equitNo", newUserEquipment.getEquitNo());
		newObj.put("userEquipment.osType", newUserEquipment.getOsType());

		BasicDBObject newObj2 = new BasicDBObject("userLoginCount", 1);

		BasicDBObject newObj3 = new BasicDBObject("userLoginLog",
				new BasicDBObject("loginIpAddress", ipAddress).append(
						"loginTime", loginTime));

		super.update(new BasicDBObject("_id", userId), new BasicDBObject(
				"$set", newObj).append("$inc", newObj2)
				.append("$push", newObj3), false, true);

	}

	@Override
	public boolean updateOnLine(String userId) {

		return super.update(new BasicDBObject("_id", userId),
				new BasicDBObject("$set", new BasicDBObject("isOnLine",
						OnLineEnum.NOTONLINE.getOnLine())), false, true);
	}

	@Override
	public Map<String, Object> queryUserById(String userId) {

		return super.findOneById(
				userId,
				new BasicDBObject("userLoginLog", 0).append("userEquipment", 0)
						.append("userLastLoginIpAddress", 0)
						.append("userLastLoginTime", 0).append("userMatch", 0)
						.append("userFriend", 0).append("userLike", 0)
						.append("userFans", 0));
	}

	@Override
	public boolean updateUserInfo(String userNickName, String userSignature,
			String userId) {
		BasicDBObject newObj = new BasicDBObject();

		if (userNickName != null && !userNickName.equals("")) {
			newObj.put("userNickName", userNickName);
		}
		if (userSignature != null && !userSignature.equals("")) {
			newObj.put("userSignature", userSignature);
		}
		return super.update(new BasicDBObject("_id", userId),
				new BasicDBObject("$set", newObj), false, true);
	}

	@Override
	public Map<String, Object> updateUserHeadPhotoAndFindUser(String userPhoto,
			String userId) {

		return super.findAndModify(new BasicDBObject("_id", userId),
				new BasicDBObject("$set", new BasicDBObject("userPhoto",
						userPhoto)));
	}

	@Override
	public boolean updateUserAlbum(String[] userAlbum, String userId) {

		return super.update(new BasicDBObject("_id", userId),
				new BasicDBObject("$pushAll", new BasicDBObject("userAlbum",
						userAlbum)), false, true);
	}

	@Override
	public boolean updateDelUserAlbum(String photoUrl, String userId) {

		String[] photos = photoUrl.split(",");
		return super.update(new BasicDBObject("_id", userId),
				new BasicDBObject("$pullAll", new BasicDBObject("userAlbum",
						photos)), false, true);
	}

	@Override
	public boolean insertLikeUser(String likeUserId, String userId) {
		// TODO Auto-generated method stub

		// 判断userId用户是否已经对likeUserId用户like，如果没有则添加like
		boolean flag = this.isLikeUser(userId, likeUserId);
		if (!flag) {
			flag = super.update(new BasicDBObject("_id", userId),
					new BasicDBObject("$push", new BasicDBObject("userLike",
							likeUserId)), false, true);
		}
		// 将likeUserId用户的userLikeCount加1
		if (flag) {

			super.update(new BasicDBObject("_id", userId), new BasicDBObject(
					"$set", new BasicDBObject("userIsLike", 1)), false, true);

			super.update(new BasicDBObject("_id", likeUserId),
					new BasicDBObject("$inc", new BasicDBObject(
							"userLikeCount", 1)), false, true);

		}

		// 将被like的用户存放进likeduser集合中
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", likeUserId);
		super.saveByJson(map, "likeduser");

		return flag;
	}

	@Override
	public boolean isLikeUser(String userId, String likeUserId) {
		// TODO Auto-generated method stub
		Map<String, Object> map = super.findOneByParams(new BasicDBObject(
				"_id", userId).append("userLike", likeUserId), null);
		if (map == null || map.isEmpty() == true)
			return false;
		return true;
	}

	@Override
	public boolean addFriend(String userId, String likeUserId) {
		// TODO Auto-generated method stub

		DB db = MongoDBUtil.getDB();
		DBCollection users = db.getCollection(userCollection);

		BasicDBObject user = new BasicDBObject("_id", userId);
		DBRef friendREF = new DBRef(db, userCollection, likeUserId);
		BasicDBObject friend = new BasicDBObject("userFriend", friendREF);

		boolean flag = false;
		// userId用户添加likeUserId用户好友
		WriteResult result = users.update(user, new BasicDBObject("$push",
				friend), false, true);
		int i = result.getN();

		if (i > 0) {
			BasicDBObject user2 = new BasicDBObject("_id", likeUserId);
			DBRef friendREF2 = new DBRef(db, userCollection, userId);
			BasicDBObject friend2 = new BasicDBObject("userFriend", friendREF2);
			// likeUserId用户添加userId用户好友
			result = users.update(user2, new BasicDBObject("$push", friend2),
					false, true);
			i = result.getN();
			if (i > 0)
				flag = true;
		}
		return flag;
	}

	@Override
	public boolean isFriend(String userId, String likeUserId) {
		// TODO Auto-generated method stub
		Map<String, Object> map = super.findOneByParams(new BasicDBObject(
				"_id", userId).append("userFriend.$id", likeUserId), null);
		if (map == null || map.isEmpty() == true)
			return false;
		return true;
	}

	@Override
	public List<Map<String, Object>> queryUserFriendList(String userId) {
		// TODO Auto-generated method stub
		BasicDBObject column = new BasicDBObject("userFriend", 1);
		Map<String, Object> user = super.findOneById(userId, column);
		BasicDBList friendList = (BasicDBList) user.get("userFriend");
		List<Map<String, Object>> friends = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < friendList.size(); i++) {
			DBRef friend = (DBRef) friendList.get(i);
			DBObject friendObj = friend.fetch();
			Map<String, Object> fre = new HashMap<String, Object>();
			fre.put("_id", friendObj.get("_id"));
			fre.put("userNickName", friendObj.get("userNickName"));
			fre.put("userPhoto", friendObj.get("userPhoto"));
			fre.put("userSignature", friendObj.get("userSignature"));
			// System.out.println(fre);
			friends.add(fre);
		}

		return friends;
	}

	@Override
	public Map<String, Object> queryUserByOpenId(String authType, String openId) {
		// TODO Auto-generated method stub
		return super.findOneByParams(new BasicDBObject("userOpenId", openId)
				.append("userAuthType", authType), new BasicDBObject(
				"userLoginLog", 0));
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> queryPushUser(String sort) {
		// TODO Auto-generated method stub
		DB db = MongoDBUtil.getDB();
		DBCollection users = db.getCollection("puser");

		BasicDBObject user = new BasicDBObject("sort", Integer.parseInt(sort));

		DBObject u = users.findOne(user);
		DBRef puser = (DBRef) u.get("user");
		BasicDBObject obj = (BasicDBObject) puser.fetch();
		obj.remove("userLoginLog");
		obj.remove("userAuthType");
		obj.remove("userEquipment");
		obj.remove("userLastLoginIpAddress");
		obj.remove("userLastLoginTime");
		if (obj != null && obj.isEmpty() == false) {
			return obj.toMap();
		}
		return null;
	}

	@Override
	public boolean deleteUserById(String userId) {
		BasicDBObject query = new BasicDBObject();
		query.put("_id", userId);
		return super.removeObject(query);
	}

	@Override
	public void minusUserBadge(String userId) {
		BasicDBObject query = new BasicDBObject("_id", userId);
		BasicDBObject update = new BasicDBObject("$inc", new BasicDBObject(
				"userEquipment.badge", -1));
		super.update(query, update, false, true);
	}

	@Override
	public void addUserBadge(String userId) {
		BasicDBObject query = new BasicDBObject("_id", userId);
		BasicDBObject update = new BasicDBObject("$inc", new BasicDBObject(
				"userEquipment.badge", 1));
		super.update(query, update, false, true);
	}

	@Override
	public List<Equipment> queryGirlsMatching(String type) {
		// TODO Auto-generated method stub

		BasicDBObject query = new BasicDBObject();

		if (type != null && type.equals("1"))
			query.put("userSex", "女");
		else if (type != null && type.equals("0"))
			query.put("userSex", "男");

		List<Map<String, Object>> girls = super.findByParams(query, null, null,
				null);
		List<Equipment> equipments = new ArrayList<Equipment>();
		for (Map<String, Object> map : girls) {
			String _id = (String) map.get("_id");

			BasicDBObject pushUser = (BasicDBObject) map.get("userEquipment");
			String equitNo = pushUser.getString("equitNo");
			String osType = pushUser.getString("osType");
			Integer badge = pushUser.getInt("badge");
			String sound = pushUser.getString("sound");

			try {
				super.update(new BasicDBObject("_id", _id), new BasicDBObject(
						"$inc", new BasicDBObject("userEquipment.badge", 1)),
						false, true);
			} catch (Exception e) {
				e.printStackTrace();
			}

			Equipment equipment = new Equipment(equitNo, osType, badge + 1,
					sound);

			equipments.add(equipment);
		}
		return equipments;
	}

	@Override
	public BasicDBList queryUserMatchs(String userId) {

		Map<String, Object> user = super.findOneById(userId, null);
		if (user != null && user.isEmpty() == false) {
			return (BasicDBList) user.get("userMatch");
		}
		return new BasicDBList();
	}

	@Override
	public boolean updateUserMatchPass(String userId, String userMatchId) {
		// TODO Auto-generated method stub
		BasicDBObject query = new BasicDBObject();
		query.put("_id", userId);
		query.put("userMatch.user.$id", userMatchId);

		BasicDBObject update = new BasicDBObject();
		update.put("$set", new BasicDBObject("userMatch.$.isPass", 1));

		return super.update(query, update, false, true);
	}

	@Override
	public Integer updateAddUserRequestCountAndFind(String userId) {
		// TODO Auto-generated method stub
		BasicDBObject query = new BasicDBObject();
		query.put("_id", userId);
		BasicDBObject update = new BasicDBObject();
		update.put("$inc", new BasicDBObject("userReqCount", 1));
		Map<String, Object> map = super.findAndModify(query, update);

		Integer userReqCount = 0;

		if (map != null && map.isEmpty() == false) {
			userReqCount = (Integer) map.get("userReqCount");
		}

		return userReqCount;
	}

	@Override
	public boolean insertUserFans(String girlId, String boyId) {
		// TODO Auto-generated method stub

		DB db = MongoDBUtil.getDB();
		BasicDBObject girl = new BasicDBObject();
		girl.put("_id", girlId);

		DBRef boyDbRef = new DBRef(db, "user", boyId);

		BasicDBObject update = new BasicDBObject();
		update.put("user", boyDbRef);
		update.put("isPass", 0);

		DBCollection users = db.getCollection(userCollection);

		WriteResult res = users.update(girl, new BasicDBObject("$addToSet",
				new BasicDBObject("userFans", update)), false, true);

		return res.getN() > 0 ? true : false;
	}

	@Override
	public boolean insertUserBoyMatch(String boyId, String girlId) {
		// TODO Auto-generated method stub

		DB db = MongoDBUtil.getDB();
		BasicDBObject boy = new BasicDBObject();
		boy.put("_id", boyId);
		DBRef girlDbRef = new DBRef(db, "user", girlId);

		BasicDBObject update = new BasicDBObject();
		update.put("user", girlDbRef);
		update.put("isPass", 0);

		DBCollection users = db.getCollection(userCollection);

		WriteResult res = users.update(boy, new BasicDBObject("$addToSet",
				new BasicDBObject("userMatch", update)), false, true);

		return res.getN() > 0 ? true : false;
	}

	@Override
	public boolean deleteBoyUserMatch(String userId, String userMatchId) {
		// TODO Auto-generated method stub

		BasicDBObject query = new BasicDBObject();
		query.put("_id", userId);

		BasicDBObject user = new BasicDBObject();
		user.put("user.$id", userMatchId);
		BasicDBObject update = new BasicDBObject();
		update.put("userMatch", user);

		return super.update(query, new BasicDBObject("$pull", update), false,
				true);
	}

	@Override
	public boolean deleteUserFans(String userId, String likeUserId) {
		// TODO Auto-generated method stub
		BasicDBObject query = new BasicDBObject();
		query.put("_id", userId);

		BasicDBObject user = new BasicDBObject();
		user.put("user.$id", likeUserId);
		BasicDBObject update = new BasicDBObject();
		update.put("userFans", user);

		return super.update(query, new BasicDBObject("$pull", update), false,
				true);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> queryUserFansList(String userId) {
		// TODO Auto-generated method stub

		Map<String, Object> user = super.findOneById(userId, null);
		List<Map<String, Object>> fans = new ArrayList<Map<String, Object>>();
		if (user != null && user.isEmpty() == false) {
			BasicDBList userFans = (BasicDBList) user.get("userFans");
			for (int i = 0; i < userFans.size(); i++) {
				BasicDBObject _obj = (BasicDBObject) userFans.get(i);
				DBRef dbRef = (DBRef) _obj.get("user");
				BasicDBObject obj = (BasicDBObject) dbRef.fetch();
				obj.remove("userEquipment");
				obj.remove("userOpenId");
				obj.remove("userLastLoginIpAddress");
				obj.remove("userLoginLog");
				obj.remove("userMatch");
				obj.remove("userFans");
				obj.remove("userLike");
				obj.remove("userFriend");
				fans.add(obj.toMap());
			}
		}

		return fans;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> getNewUserList(int cursor, int page_size, Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		
		long start = cal.getTimeInMillis();
		cal.add(Calendar.DAY_OF_MONTH, 1);
		long end = cal.getTimeInMillis();
		
		BasicDBObject query = new BasicDBObject("time",new BasicDBObject("",start).append("", end));
		DBCursor cur  =  MongoDBUtil.getDB().getCollection("user").find(query).skip(cursor).limit(page_size);
		
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		while(cur.hasNext()){
			BasicDBObject obj  = (BasicDBObject) cur.next();
			list.add(obj.toMap());
		}
		return list;
	}
	
	
}
