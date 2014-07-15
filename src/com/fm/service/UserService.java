package com.fm.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.fm.model.User;

public interface UserService {

	/**
	 * 用户授权
	 * 
	 * @param user
	 * @param backLogin
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public boolean grantOrLogin(User user, String backLogin,
			HttpServletRequest request) throws Exception;

	/**
	 * 插入一个用户
	 * 
	 * @param user
	 * @param request
	 * @return
	 */
	public boolean insertUser(User user, HttpServletRequest request);

	/**
	 * 注销用户
	 * 
	 * @param sessionUserId
	 * @return
	 */
	public boolean updateOnLine(String userId);

	/**
	 * 通过用户id查询用户信息
	 * 
	 * @param userId
	 * @return
	 */
	public Map<String, Object> queryUserById(String userId);

	/**
	 * 更新用户信息
	 * 
	 * @param userNickName
	 *            昵称
	 * @param userSignature
	 *            个性签名
	 * @param request
	 * @return
	 */
	public boolean updateUserInfo(String userNickName, String userSignature,
			HttpServletRequest request);

	/**
	 * 修改用户头像
	 * 
	 * @param userPhoto
	 * @param userId
	 * @return
	 */
	public Map<String, Object> updateUserHeadPhoto(String userPhoto,
			String userId);

	/**
	 * 添加用户相册照片
	 * 
	 * @param userAlbum
	 * @param userId
	 * @return
	 */
	public boolean updateUserAlbum(String[] userAlbum, String userId);

	/**
	 * 删除用户相册照片
	 * 
	 * @param photoUrl
	 * @param userId
	 * @return
	 */
	public boolean updateDelUserAlbum(String photoUrl, String userId);

	/**
	 * 添加like用户
	 * 
	 * @param likeUserId
	 * @param userId
	 * @param type
	 *            1:userMatch 2:userFans
	 * @param request
	 * @return
	 */
	public Integer insertLikeUser(String likeUserId, String userId,
			String type, HttpServletRequest request);

	/**
	 * 用户的好友列表
	 * 
	 * @param userId
	 * @return
	 */
	public List<Map<String, Object>> queryUserFriendList(String userId);

	/**
	 * 测试推送用户
	 * 
	 * @param sort
	 * @return
	 */
	public Map<String, Object> queryPushUser(String sort);

	/**
	 * 删除用户
	 * 
	 * @param userId
	 * @return
	 */
	public boolean deleteUserById(String userId);

	/**
	 * 女生用户匹配
	 * 
	 * @param type
	 *            1:女生 2：男生
	 * 
	 */
	public void girlsMatching(String type);

	/**
	 * 查询匹配的用户信息
	 * 
	 * @param userMatchId
	 * @param userId
	 * @param type
	 *            1:userMatch 2:userFans
	 * @return
	 */
	public Map<String, Object> userMatchInfo(String userMatchId, String userId,
			String type);

	/**
	 * 男生like女生的用户列表
	 * 
	 * @param userId
	 * @return
	 */
	public List<Map<String, Object>> userFansList(String userId);

}
