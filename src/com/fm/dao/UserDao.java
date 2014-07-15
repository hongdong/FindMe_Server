package com.fm.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.fm.model.Equipment;
import com.fm.model.User;
import com.mongodb.BasicDBList;

public interface UserDao {

	/**
	 * 通过QQ_openid方式登录
	 * 
	 * @param openId
	 * @return
	 */
	Map<String, Object> queryUserByQqOpenId(String openId);

	/**
	 * 通过Sina_openid方式登录
	 * 
	 * @param openId
	 * @return
	 */
	Map<String, Object> queryUserBySinaOpenId(String openId);

	/**
	 * 插入一个用户
	 * 
	 * @param user
	 * @return
	 */
	void insertUser(User user);

	/**
	 * 通过id查询一个user
	 * 
	 * @param get_id
	 * @return
	 */
	Map<String, Object> findOneById(String get_id);

	/**
	 * 更新用户登录信息
	 * 
	 * @param userId
	 * @param ipAddress
	 * @param loginTime
	 */
	void updateUserLoginLog(String userId, String ipAddress, String loginTime,
			Integer isOnLine, Equipment newUserEquipment);

	/**
	 * 注销用户
	 * 
	 * @param sessionUserId
	 * @return
	 */
	boolean updateOnLine(String userId);

	/**
	 * 查询用户信息
	 * 
	 * @param userId
	 * @return
	 */
	Map<String, Object> queryUserById(String userId);

	/**
	 * 更新用户信息
	 * 
	 * @param userNickName
	 * @param userSignature
	 * @param userId
	 * @return
	 */
	boolean updateUserInfo(String userNickName, String userSignature,
			String userId);

	/**
	 * 修改用户头像
	 * 
	 * @param userPhoto
	 * @param userId
	 * @return
	 */
	Map<String, Object> updateUserHeadPhotoAndFindUser(String userPhoto,
			String userId);

	/**
	 * 添加用户相册照片
	 * 
	 * @param userAlbum
	 * @param userId
	 * @return
	 */
	boolean updateUserAlbum(String[] userAlbum, String userId);

	/**
	 * 删除用户相册照片
	 * 
	 * @param photoUrl
	 * @param userId
	 * @return
	 */
	boolean updateDelUserAlbum(String photoUrl, String userId);

	/**
	 * 添加like用户
	 * 
	 * @param likeUserId
	 * @param userId
	 * @return
	 */
	boolean insertLikeUser(String likeUserId, String userId);

	/**
	 * 判断userId是否对likeUserId用户like
	 * 
	 * @param userId
	 * @param likeUserId
	 * @return
	 */
	boolean isLikeUser(String userId, String likeUserId);

	/**
	 * 互相添加好友
	 * 
	 * @param userId
	 * @param likeUserId
	 * @return
	 */
	boolean addFriend(String userId, String likeUserId);

	/**
	 * 判断userId是否是likeUserId用户的好友
	 * 
	 * @param userId
	 * @param likeUserId
	 * @return
	 */
	boolean isFriend(String userId, String likeUserId);

	/**
	 * 查询用户的好友列表
	 * 
	 * @param userId
	 * @return
	 */
	List<Map<String, Object>> queryUserFriendList(String userId);

	/**
	 * 通过openid方式登录
	 * 
	 * @param authType
	 * @param openId
	 * @return
	 */
	Map<String, Object> queryUserByOpenId(String authType, String openId);

	/**
	 * 推送用户测试
	 * 
	 * @param sort
	 * @return
	 */
	Map<String, Object> queryPushUser(String sort);

	/**
	 * 删除用户
	 * 
	 * @param userId
	 * @return
	 */
	boolean deleteUserById(String userId);

	/**
	 * 减少一个badge
	 * 
	 * @param userId
	 */
	void minusUserBadge(String userId);
	
	/**
	 * 增加一个badge
	 * 
	 * @param userId
	 */
	void addUserBadge(String userId);

	/**
	 * 女生匹配的用户信息
	 * @param type 1:女生 0：男生
	 * 
	 * @return
	 */
	List<Equipment> queryGirlsMatching(String type);

	/**
	 * 查询匹配用户信息
	 * 
	 * @param userId
	 * @return
	 */
	BasicDBList queryUserMatchs(String userId);
	
	/**
	 * 更新匹配用户的isPass:1
	 * 
	 * @param userId
	 * @param userMatchId
	 * @return
	 */
	boolean updateUserMatchPass(String userId, String userMatchId);
	
	/**
	 * 增加请求次数
	 * 
	 * @param userId
	 * @return
	 */
	Integer updateAddUserRequestCountAndFind(String userId);

	/**
	 * 男like女，将男插入到女fans集合中(女未like男的情况才会用到)
	 * 
	 * @param girlId
	 * @param boyId
	 * @return
	 */
	boolean insertUserFans(String girlId, String boyId);

	/**
	 * 女生like男，将女生插入到男生userMatch中
	 * 
	 * @param boyId
	 * @param girlId
	 * @return
	 */
	boolean insertUserBoyMatch(String boyId, String girlId);

	/**
	 * 删除男生的match中的user
	 * 
	 * @param userId
	 * @param likeUserId
	 * @return
	 */
	boolean deleteBoyUserMatch(String userId, String userMathId);

	/**
	 * 如果女生是通过userFans加好友则将userFans中的用户删除
	 * 
	 * @param userId
	 * @param likeUserId
	 * @return
	 */
	boolean deleteUserFans(String userId, String likeUserId);

	/**
	 * userFans列表
	 * 
	 * @param userId 
	 * @return
	 */
	List<Map<String, Object>> queryUserFansList(String userId);
	
	
	/**
	 * 获取某一天的新增用户
	 * @param cursor    	第几条
	 * @param page_size		取多少条
	 * @param date			时间
	 * @return
	 */
	List<Map<String, Object>> getNewUserList(int cursor,int page_size,Date date);
	
	
}
