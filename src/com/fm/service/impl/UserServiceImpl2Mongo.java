package com.fm.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.fm.model.Equipment;
import com.fm.model.User;
import com.fm.service.UserService;
import com.fm.util.CommonVariables;
import com.fm.util.OnLineEnum;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBRef;

@Service("userService")
public class UserServiceImpl2Mongo extends BaseService implements UserService {

	@Override
	public boolean grantOrLogin(User user, String backLogin,
			HttpServletRequest request) throws Exception {

		String openId = user.getUserOpenId();
		String authType = user.getUserAuthType();

		Map<String, Object> userMap = super.userDao.queryUserByOpenId(authType,
				openId);

		if (userMap != null && userMap.isEmpty() == false) {

			Equipment newUserEquipment = user.getUserEquipment();

			sessionUtil.setSessionUser(userMap, request);
			// 不是后台登录，记录登录日志
			if (backLogin != null && backLogin.equals("0")) {
				this.updateUserLoginLog((String) userMap.get("_id"),
						OnLineEnum.ONLINE.getOnLine(), newUserEquipment,
						request);

				this.forcedUserLoginOut(userMap, newUserEquipment, request);
			}

			return true;
		} else {
			return false;
		}

	}

	@SuppressWarnings("unchecked")
	private void forcedUserLoginOut(Map<String, Object> userMap,
			Equipment newUserEquipment, HttpServletRequest request) {
		// 判断用户是否已经登录
		Map<String, Object> oldUserEquipmentMap = (Map<String, Object>) userMap
				.get("userEquipment");

		if (oldUserEquipmentMap != null
				&& oldUserEquipmentMap.isEmpty() == false) {

			Equipment oldUserEquipment = new Equipment();
			oldUserEquipment.setEquitNo((String) oldUserEquipmentMap
					.get("equitNo"));
			oldUserEquipment.setOsType((String) oldUserEquipmentMap
					.get("osType"));
			oldUserEquipment.setBadge((Integer) oldUserEquipmentMap
					.get("badge"));
			oldUserEquipment
					.setSound((String) oldUserEquipmentMap.get("sound"));

			Integer isOnLine = (Integer) userMap.get("isOnLine");

			super.forcedOffline(isOnLine, oldUserEquipment, newUserEquipment,
					request);
		}
	}

	@SuppressWarnings("static-access")
	private void updateUserLoginLog(String userId, Integer isOnLine,
			Equipment newUserEquipment, HttpServletRequest request) {
		String ipAddress = super.methodUtil.getIpAddr(request);
		String loginTime = super.methodUtil.formatDate(new Date(), null, 0);

		// 刷新session中的用户登录记录
		Map<String, Object> userMap = sessionUtil.getSessionUser(request);
		userMap.put("userLastLoginTime", loginTime);
		userMap.put("userLastLoginIpAddress", ipAddress);
		userMap.put("isOnLine", OnLineEnum.ONLINE.getOnLine());
		sessionUtil.setSessionUser(userMap, request);

		super.userDao.updateUserLoginLog(userId, ipAddress, loginTime,
				isOnLine, newUserEquipment);
	}

	@Override
	public boolean insertUser(User user, HttpServletRequest request) {

		String userSignature = user.getUserSignature();
		if (userSignature == null || userSignature.equals("")) {
			user.setUserSignature(CommonVariables.USER_SIGNATURE);
		}
		user.setUserAuth(0);
		Equipment e = user.getUserEquipment();
		e.setBadge(0);
		e.setSound("happy");
		user.setUserEquipment(e);

		user.setUserLikeCount(0);
		user.setUserIsLike(0);
		user.setUserLikeRate(0.001);
		user.setUserMatch(new ArrayList<Object>());

		user.setUserMatchTimes(0);
		user.setUserRegisterTime(methodUtil.formatDate(new Date(), null, 0));

		// 插入一条新用户
		super.userDao.insertUser(user);
		// 查询插入的用户
		Map<String, Object> userMap = super.userDao.findOneById(user.get_id());
		// 注册成功则直接登录
		if (userMap != null && userMap.isEmpty() == false) {
			sessionUtil.setSessionUser(userMap, request);
			this.updateUserLoginLog(user.get_id(),
					OnLineEnum.ONLINE.getOnLine(), user.getUserEquipment(),
					request);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean updateOnLine(String userId) {
		return this.userDao.updateOnLine(userId);
	}

	@Override
	public Map<String, Object> queryUserById(String userId) {
		return this.userDao.queryUserById(userId);
	}

	@Override
	public boolean updateUserInfo(String userNickName, String userSignature,
			HttpServletRequest request) {
		return this.userDao.updateUserInfo(userNickName, userSignature,
				sessionUtil.getSessionUserId(request));
	}

	@Override
	public Map<String, Object> updateUserHeadPhoto(String userPhoto,
			String userId) {
		return this.userDao.updateUserHeadPhotoAndFindUser(userPhoto, userId);
	}

	@Override
	public boolean updateUserAlbum(String[] userAlbum, String userId) {
		return this.userDao.updateUserAlbum(userAlbum, userId);
	}

	@Override
	public boolean updateDelUserAlbum(String photoUrl, String userId) {
		return this.userDao.updateDelUserAlbum(photoUrl, userId);
	}

	@Override
	public Integer insertLikeUser(String likeUserId, String userId,
			String type, HttpServletRequest request) {
		// TODO 添加好友需要推送(完成)、like后推送(完成) --事务控制未完成 --代码没优化

		boolean flag = this.userDao.insertLikeUser(likeUserId, userId);

		Integer i = 20001; // 插入like成功

		if (flag) {// 是否是好友
			boolean isFriend = this.userDao.isFriend(userId, likeUserId);
			if (!isFriend) {// 不是好友则判断对方是否已经like自己
				boolean isLike = this.userDao.isLikeUser(likeUserId, userId);
				if (isLike) { // 若对方也已经like自己，则加好友
					flag = this.userDao.addFriend(userId, likeUserId);
					if (flag) {
						i = 20002; // 添加好友成功
						String userSex = sessionUtil.getSessionUserSex(request);
						if (userSex != null && userSex.equals("男")) {
							// 如果当前用户是男生，且女生已经like男生，男女加好友成功，需要将男生的match中删除这个女生用户
							this.userDao.deleteBoyUserMatch(userId, likeUserId);
						} else if (userSex != null && userSex.equals("女")) {
							if (type != null && type.equals("2")) {
								// 表示是userFans中的用户，则需要删除用户
								this.userDao.deleteUserFans(userId, likeUserId);
							}
						}

						// 推送好友消息
						Map<String, Object> map = this.userDao
								.findOneById(likeUserId);
						BasicDBObject userEquipment = (BasicDBObject) map
								.get("userEquipment");

						String equitNo = userEquipment.getString("equitNo");
						String osType = userEquipment.getString("osType");
						Integer badge = userEquipment.getInt("badge");
						String sound = userEquipment.getString("sound");

						Equipment equipment = new Equipment(equitNo, osType,
								badge, sound);
						Map<String, String> params = new HashMap<String, String>();
						params.put("type", "10005");
						super.pushNews(equipment, null, "添加好友", params);
					} else {
						// 删除之前添加的like 未完成
						i = 10002; // 添加好友失败
					}
				} else {

					String userSex = sessionUtil.getSessionUserSex(request);
					if (userSex != null && userSex.equals("男")) {
						// 如果当前用户是男生，则表示男生like女生，则需要将男生插入到女生fans数组中
						this.userDao.insertUserFans(likeUserId, userId);
						// 如果当前用户是男生，表示男生like女生，需要将男生的match中删除这个女生用户
						this.userDao.deleteBoyUserMatch(userId, likeUserId);

						// 推送好友消息
						Map<String, Object> map = this.userDao
								.findOneById(likeUserId);
						BasicDBObject userEquipment = (BasicDBObject) map
								.get("userEquipment");

						String equitNo = userEquipment.getString("equitNo");
						String osType = userEquipment.getString("osType");
						Integer badge = userEquipment.getInt("badge");
						String sound = userEquipment.getString("sound");

						Equipment equipment = new Equipment(equitNo, osType,
								badge, sound);
						Map<String, String> params = new HashMap<String, String>();
						params.put("type", "10004");
						super.pushNews(equipment, null, "有男生like你", params);

					} else if (userSex != null && userSex.equals("女")) {

						this.userDao.insertUserBoyMatch(likeUserId, userId);

						// 推送好友消息
						Map<String, Object> map = this.userDao
								.findOneById(likeUserId);
						BasicDBObject userEquipment = (BasicDBObject) map
								.get("userEquipment");

						String equitNo = userEquipment.getString("equitNo");
						String osType = userEquipment.getString("osType");
						Integer badge = userEquipment.getInt("badge");
						String sound = userEquipment.getString("sound");

						Equipment equipment = new Equipment(equitNo, osType,
								badge, sound);
						Map<String, String> params = new HashMap<String, String>();
						params.put("type", "10004");
						super.pushNews(equipment, null, "有女生like你", params);
					}

				}
			}
		} else {
			i = 10001; // 插入like失败
		}
		return i;
	}

	@Override
	public List<Map<String, Object>> queryUserFriendList(String userId) {
		return this.userDao.queryUserFriendList(userId);
	}

	@Override
	public Map<String, Object> queryPushUser(String sort) {
		return this.userDao.queryPushUser(sort);
	}

	@Override
	public boolean deleteUserById(String userId) {
		return this.userDao.deleteUserById(userId);
	}

	@Override
	public void girlsMatching(String type) {
		// TODO Auto-generated method stub
		if (type != null && type.equals("1")) {
			// 女生匹配
			List<Equipment> userList = this.userDao.queryGirlsMatching(type);
			String content = "番迷君算到你的姻缘已到";
			// for (Equipment equipment : userList) {
			Map<String, String> params = new HashMap<String, String>();
			params.put("type", "10003");// 匹配的消息
			super.pushNews(userList, null, content, params);
		} else if (type != null && type.equals("0")) {
			// 男生匹配
			List<Equipment> userList = this.userDao.queryGirlsMatching(type);
			String content = "妹子来了";
			// for (Equipment equipment : userList) {
			Map<String, String> params = new HashMap<String, String>();
			params.put("type", "10003");// 匹配的消息
			super.pushNews(userList, null, content, params);
		}
		// }
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> userMatchInfo(String userMatchId, String userId,
			String type) {
		// TODO Auto-generated method stub
		Map<String, Object> userMap = new HashMap<String, Object>();

		if (type != null && type.equals("2")) {
			// 删除userFans中的用户
			boolean isflag = this.userDao.deleteUserFans(userId, userMatchId);
			userMap.put("fansPass", isflag);

		} else if (type != null && type.equals("1")) {

			// 如果是第一次请求则badge减一
			Integer requestCount = this.userDao
					.updateAddUserRequestCountAndFind(userId);
			if (requestCount == 0) {
				this.userDao.minusUserBadge(userId);
			}

			boolean flag = true;
			if (userMatchId != null && !userMatchId.equals("")) {
				flag = this.userDao.updateUserMatchPass(userId, userMatchId);
				userMap.put("success", flag);
			}
			if (flag) {
				// 查询匹配的用户
				Map<String, Object> user_Map = this.userDao.findOneById(userId);
				Integer userIsLike = 0;
				if (user_Map != null && user_Map.isEmpty() == false) {
					userIsLike = (Integer) user_Map.get("userIsLike");
				}
				if (userIsLike == 0) {
					BasicDBList userMatchs = new BasicDBList();
					Map<String, Object> uMap = this.userDao.findOneById(userId);

					if (uMap != null && uMap.isEmpty() == false) {
						userMatchs = (BasicDBList) uMap.get("userMatch");
					}

					for (int i = 0; i < userMatchs.size(); i++) {
						BasicDBObject userMatch = (BasicDBObject) userMatchs
								.get(i);
						Integer isPass = userMatch.getInt("isPass");
						if (isPass == 1)
							continue;
						else {
							DBRef userDBRef = (DBRef) userMatch.get("user");
							DBObject user = userDBRef.fetch();
							user.removeField("userLoginLog");
							userMap = user.toMap();
							if (userMap != null && userMap.isEmpty() == false) {
								userMap.put("likeToday", uMap.get("userIsLike"));
								userMap.remove("userEquipment");
								userMap.remove("userOpenId");
								userMap.remove("userLastLoginIpAddress");
								userMap.remove("userLoginLog");
								userMap.remove("userMatch");
								userMap.remove("userFans");
								userMap.remove("userLike");
								userMap.remove("userFriend");
							}
							break;
						}
					}
				}
			}
		}

		return userMap;
	}

	@Override
	public List<Map<String, Object>> userFansList(String userId) {
		return this.userDao.queryUserFansList(userId);
	}

}
