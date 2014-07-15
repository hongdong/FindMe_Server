package com.fm.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fm.model.Equipment;
import com.fm.model.User;
import com.fm.util.CommonVariables;
import com.fm.util.HttpUtil;

/**
 * 用户
 * 
 * @author caizhi 2014-05-04
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/data/user")
public class UserController extends BaseController {

	private Logger log = Logger.getLogger(this.getClass().getName());

	// 以下是mongo的数据库

	/**
	 * 用户授权或登录
	 * 
	 * @param openId
	 *            授权id
	 * @param type
	 *            授权类型 QZone或SinaWeibo
	 * @param equipment
	 *            equitNo:设备编码 osType:系统类型(1:IOS 2:ANDROID)
	 * @param backLogin
	 *            是否后台登录1：是 0：否
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/grant_user", method = RequestMethod.POST)
	@ResponseBody
	public void userGrantOrLogin(String userOpenId, String userAuthType,
			Equipment equipment, String backLogin, HttpServletRequest request,
			HttpServletResponse response) {
		// 输出参数日志，用于调试
		log.info("openId:" + userOpenId + "\ttype:" + userAuthType);

		try {
			// 判断参数是否为空
			if ((userOpenId != null && !userOpenId.equals(""))
					&& (userAuthType != null && !userAuthType.equals(""))) {
				User user = new User();
				// 判断用户是哪种方式授权
				user.setUserAuthType(userAuthType);
				user.setUserOpenId(userOpenId);
				// if (type.equals("QZone")) {
				// user.setUserQqOpenId(openId);
				// } else if (type.equals("SinaWeibo")) {
				// user.setUserSinaOpenId(openId);
				// } else {
				// super.printMessage("10001", "msg", "参数错误！", response);
				// return;
				// }

				user.setUserEquipment(equipment);

				// 判断是否授权过
				boolean flag = this.userService.grantOrLogin(user, backLogin,
						request);
				// u == null 还未授权
				if (flag == false) {
					super.printMessage("10001", "msg", "未注册！", response);
				} else {
					// 用户已授权，并且登录成功
					super.printMessage("20001", "userId",
							sessionUtil.getSessionUserId(request), response);
					
					
					/**
					 * 数据统计
					 */
					statsService.UserActiveStatsPerDay(user);
				}
			} else {
				super.printMessage("10001", "msg", "错误！", response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
			super.printMessage("30001", "msg", "系统错误！", response);
		}
	}

	/**
	 * 用户注册
	 * 
	 * @param user
	 *            昵称 ：userNickName, 头像 ：userPhoto,<br>
	 *            学校Id ：school._id,学校名称 ：school.schoolName<br>
	 *            院系id：department._id,院系名称 ：department.deptName<br>
	 *            星座 ：userConstellation, 年级 ：userGrade<br>
	 *            性别 ：userSex,equitNo:userEquipment.equitNo<br>
	 *            osType:userEquipment.osType,<br>
	 *            openId:openId,type:type<br>
	 *            个性签名:userSignature<br>
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/rgst_user", method = RequestMethod.POST)
	@ResponseBody
	public void registerUser(User user, String openId, String type,
			HttpServletRequest request, HttpServletResponse response) {

		try {
			// 判断用户是哪种方式授权
			// if (type.equals("QZone")) {
			// user.setUserQqOpenId(openId);
			// } else if (type.equals("SinaWeibo")) {
			// user.setUserSinaOpenId(openId);
			// } else {
			// super.printMessage("10001", "msg", "失败！", response);
			// return;
			// }

			user.set_id(super.methodUtil.getUUID());

			String userPhoto = this.uploadPicture(request,
					CommonVariables.PICTURE_USER_PATH + "/" + user.get_id(), 1);
			if (userPhoto != null && userPhoto.equals("")) {
				// 图片处理失败了
				// uploadFlag = false;
				super.printMessage("10001", "msg", "失败!", response);
			} else {
				if (userPhoto != null) {
					userPhoto = userPhoto.substring(5);
				}
				user.setUserPhoto(userPhoto);
				// 用户注册
				boolean flag = this.userService.insertUser(user, request);
				
				/**
				 * 数据统计
				 */
				statsService.userCountStatsPerDay(user);
				
				if (flag == true) {
					// 注册环信用户
					HttpUtil httpUtil = new HttpUtil();
					flag = httpUtil.doRegisterUser(
							sessionUtil.getSessionUserId(request),
							CommonVariables.HUANXIN_PASSWORD);
					if (flag) {
						// 注册成功,并且登录成功
						super.printMessage("20001", "userId",
								sessionUtil.getSessionUserId(request), response);
					} else {
						flag = this.userService.deleteUserById(sessionUtil
								.getSessionUserId(request));
						this.deletePictureByServerPath(
								userPhoto,
								CommonVariables.PICTURE_USER_PATH + "/"
										+ user.get_id(), 1, request);
						sessionUtil.loginOut(request);
						super.printMessage("10001", "msg", "失败!", response);
					}
				} else {
					this.deletePictureByServerPath(
							userPhoto,
							CommonVariables.PICTURE_USER_PATH + "/"
									+ user.get_id(), 1, request);
					super.printMessage("10001", "msg", "失败!", response);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
			super.printMessage("10001", "msg", "失败!", response);
		}
	}

	/**
	 * 获取用户信息
	 * 
	 * @param userId
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/user_info", method = RequestMethod.GET)
	@ResponseBody
	public void userInfo(String userId, HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> userMap = this.userService.queryUserById(userId);
		super.printObject("userInfo", userMap, response);
	}

	/**
	 * 修改用户信息
	 * 
	 * @param userNickName
	 *            昵称
	 * @param userSignature
	 *            个性签名
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/update_info", method = RequestMethod.POST)
	@ResponseBody
	public void updateUserInfo(String userNickName, String userSignature,
			HttpServletRequest request, HttpServletResponse response) {

		boolean flag = this.userService.updateUserInfo(userNickName,
				userSignature, request);
		if (flag == true)
			super.printMessage("20001", "msg", "成功!", response);
		else
			super.printMessage("10001", "msg", "失败!", response);
	}

	@RequestMapping(value = "/touphoto", method = RequestMethod.GET)
	public String touphoto(HttpServletRequest request,
			HttpServletResponse response) {

		return "/user/uphoto";
	}

	@RequestMapping(value = "/toalbum", method = RequestMethod.GET)
	public String toalbum(HttpServletRequest request,
			HttpServletResponse response) {

		return "/user/ualbum";
	}

	/**
	 * 修改用户头像
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/user_uphoto", method = RequestMethod.POST)
	@ResponseBody
	public void userUpdatePhoto(HttpServletRequest request,
			HttpServletResponse response) {

		boolean uploadFlag = true;
		// 服务器上的图片路径
		String userPhoto = null;
		try {
			userPhoto = this.uploadPicture(
					request,
					CommonVariables.PICTURE_USER_PATH + "/"
							+ sessionUtil.getSessionUserId(request), 0);
			if (userPhoto != null && userPhoto.equals("")) {
				// 图片处理失败了
				uploadFlag = false;
			} else {
				if (userPhoto != null) {
					userPhoto = userPhoto.substring(5);
				}

				// 修改头像
				Map<String, Object> newUser = this.userService
						.updateUserHeadPhoto(userPhoto,
								sessionUtil.getSessionUserId(request));
				// 修改头像成功
				if (newUser != null && newUser.isEmpty() == false) {
					String mUserPhoto = sessionUtil
							.getSessionUserPhoto(request);
					if (mUserPhoto != null) {
						int isMyServer = mUserPhoto
								.indexOf(CommonVariables.SERVER_NAME);
						// 头像服务器中存在,先删除服务器中的旧头像
						if (isMyServer != -1) {
							this.deletePictureByServerPath(
									mUserPhoto,
									CommonVariables.PICTURE_USER_PATH
											+ "/"
											+ sessionUtil
													.getSessionUserId(request),
									0, request);
						}
					}
					// 将最新的用户信息放入session中
					newUser.put("userPhoto", userPhoto);
					sessionUtil.setSessionUser(newUser, request);
					uploadFlag = true;
				} else {// 修改头像失败则删除图片
					uploadFlag = false;
					this.deletePictureByServerPath(userPhoto,
							CommonVariables.PICTURE_USER_PATH + "/"
									+ sessionUtil.getSessionUserId(request), 0,
							request);
				}
			}
		} catch (Exception e) {
			super.printMessage("10001", "msg", "失败！", response);
			e.printStackTrace();
			return;
		}
		if (uploadFlag == false) {
			super.printMessage("10001", "msg", "失败！", response);
		} else {
			super.printMessage("20001", "userPhoto", userPhoto, response);
		}
	}

	/**
	 * 添加用户相册照片
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/add_album_uphoto", method = RequestMethod.POST)
	@ResponseBody
	public void userUpdateAlbum(HttpServletRequest request,
			HttpServletResponse response) {

		// 服务器上的图片路径
		String userPhoto = null;
		try {
			userPhoto = this.uploadPicture(
					request,
					CommonVariables.PICTURE_USER_PATH + "/"
							+ sessionUtil.getSessionUserId(request), 0);
			if (userPhoto != null && userPhoto.equals("")) {
				// 图片处理失败了
				super.printMessage("10001", "msg", "失败！", response);
				return;
			} else {
				String[] userAlbum = new String[] {};
				if (userPhoto != null) {
					userPhoto = userPhoto.substring(5);
					userAlbum = userPhoto.split(",");
				}

				// 修改头像
				boolean flag = this.userService.updateUserAlbum(userAlbum,
						sessionUtil.getSessionUserId(request));
				// 修改头像成功
				if (flag == false) {
					// 头像服务器中存在,先删除服务器中的旧头像

					this.deletePictureByServerPath(userPhoto,
							CommonVariables.PICTURE_USER_PATH + "/"
									+ sessionUtil.getSessionUserId(request), 0,
							request);

					super.printMessage("10001", "msg", "失败！", response);
				} else {
					super.printObject("20001", "userAlbum", userAlbum, response);
				}
			}
		} catch (Exception e) {
			super.printMessage("10001", "msg", "失败！", response);
			e.printStackTrace();
		}
	}

	/**
	 * 删除用户相册照片
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/del_album_uphoto", method = RequestMethod.GET)
	@ResponseBody
	public void userDelAlbum(String photoUrl, HttpServletRequest request,
			HttpServletResponse response) {

		try {
			this.deletePictureByServerPath(
					photoUrl,
					CommonVariables.PICTURE_USER_PATH + "/"
							+ sessionUtil.getSessionUserId(request), 0, request);
			// 删除相册照片
			boolean flag = this.userService.updateDelUserAlbum(photoUrl,
					sessionUtil.getSessionUserId(request));
			// 删除相册照片成功
			if (flag == false) {
				super.printMessage("10001", "msg", "失败！", response);
			} else {
				super.printMessage("20001", "msg", "成功！", response);
			}

		} catch (Exception e) {
			super.printMessage("10001", "msg", "失败！", response);
			e.printStackTrace();
		}
	}

	/**
	 * 推送用户
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/push_user", method = RequestMethod.GET)
	@ResponseBody
	public void pushUser(String sort, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			Map<String, Object> pUser = this.userService.queryPushUser(sort);
			super.printObject("pushUser", pUser, response);
		} catch (Exception e) {
			e.printStackTrace();
			super.printMessage("30001", "msg", "错误！", response);
		}
	}

	/**
	 * 添加like用户
	 * 
	 * @param likeUserId
	 * @param type
	 *            1:userMatch 2:userFans
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/like_user", method = RequestMethod.GET)
	@ResponseBody
	public void addLikeUser(String likeUserId, String type,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			Integer flag = this.userService.insertLikeUser(likeUserId,
					sessionUtil.getSessionUserId(request), type, request);
			super.printMessage(flag.toString(), "msg", "提示！", response);
		} catch (Exception e) {
			e.printStackTrace();
			super.printMessage("30001", "msg", "错误！", response);
		}
	}

	/**
	 * 用户的好友列表
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/user_friend", method = RequestMethod.GET)
	@ResponseBody
	public void userFriendList(HttpServletRequest request,
			HttpServletResponse response) {
		List<Map<String, Object>> friendList = this.userService
				.queryUserFriendList(sessionUtil.getSessionUserId(request));
		super.printObject("friendList", friendList, response);
	}

	/**
	 * 注销
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/login_out", method = RequestMethod.POST)
	@ResponseBody
	public void userLoginOut(HttpServletRequest request,
			HttpServletResponse response) {
		boolean flag = this.userService.updateOnLine(this.sessionUtil
				.getSessionUserId(request));
		if (flag == true) {
			this.sessionUtil.loginOut(request);
			super.printMessage("20001 ", "msg", "注销成功！", response);
		} else {
			super.printMessage("10001 ", "msg", "注销失败！", response);
		}
	}

	/**
	 * 用户匹配
	 * 
	 * @param type
	 *            1 :女生 2：男生
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/user_match", method = RequestMethod.GET)
	@ResponseBody
	public void userMatch(String type, HttpServletRequest request,
			HttpServletResponse response) {
		this.userService.girlsMatching(type);
	}

	/**
	 * 用户匹配用户信息(pass)
	 * 
	 * @param userId
	 * @param type
	 *            1:userMatch 2:userFans
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/match_info", method = RequestMethod.GET)
	@ResponseBody
	public void userMatchInfo(String userMatchId, String type,
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> userMap = this.userService.userMatchInfo(
				userMatchId, sessionUtil.getSessionUserId(request), type);
		System.out.println("LOG || userMap:" + userMap);
		super.printObject("userMatch", userMap, response);
	}

	/**
	 * 男生like女生的用户列表
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/fans_list", method = RequestMethod.GET)
	@ResponseBody
	public void userFansList(HttpServletRequest request,
			HttpServletResponse response) {
		List<Map<String, Object>> userMap = this.userService
				.userFansList(sessionUtil.getSessionUserId(request));
		System.out.println("LOG || userMap:" + userMap);
		super.printObject("userFans", userMap, response);
	}

}
