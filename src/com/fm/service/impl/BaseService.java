package com.fm.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.fm.dao.BackStageUserDao;
import com.fm.dao.NewsDao;
import com.fm.dao.PostDao;
import com.fm.dao.SchoolDao;
import com.fm.dao.StatsDao;
import com.fm.dao.UserDao;
import com.fm.model.Equipment;
import com.fm.thread.PushInfoThread;
import com.fm.thread.PushListInfoThread;
import com.fm.util.MethodUtil;
import com.fm.util.SessionUtil;

public class BaseService {

	protected MethodUtil methodUtil = MethodUtil.getInstance();
	protected SessionUtil sessionUtil = SessionUtil.getInstance();

	@Resource(name = "userDao")
	protected UserDao userDao;

	@Resource(name = "schoolDao")
	protected SchoolDao schoolDao;

	@Resource(name = "postDao")
	protected PostDao postDao;

	@Resource(name = "newsDao")
	protected NewsDao newsDao;

	
	@Resource(name = "statsDao")
	protected StatsDao statsDao;
	
	@Resource(name = "backStageUserDao")
	protected BackStageUserDao backStageUserDao;
	/**
	 * 线程
	 * 
	 */
	@Resource(name = "taskExecutor")
	protected ThreadPoolTaskExecutor taskExecutor;

	/**
	 * 强迫用户下线
	 * 
	 * @param isOnLine
	 *            是否在线 1:是 0:否
	 * @param oldUserEquipment
	 *            旧的设备(设备编码,系统类型1:IOS 2:ANDROID)
	 * @param newUserEquipment
	 *            新的设备编码(设备编码,系统类型1:IOS 2:ANDROID)
	 */
	public void forcedOffline(Integer isOnLine, Equipment oldUserEquipment,
			Equipment newUserEquipment, HttpServletRequest request) {
		// 用户在线
		if (isOnLine != null && isOnLine == 1) {
			String oldEquitCode = oldUserEquipment.getEquitNo();
			String newEquitCode = newUserEquipment.getEquitNo();
			if (!oldEquitCode.equals(newEquitCode)) {
				// 说明不是同一台设备,发送推送消息，强迫下线
				String ipAddress = sessionUtil
						.getSessionUserLastLoginIpAddress(request);
				String loginTime = sessionUtil
						.getSessionUserLastLoginTime(request);
				String content = "您已在另一台设备上登陆";
				// 推送的参数
				Map<String, String> params = new HashMap<String, String>();
				params.put("type", "10001");
				params.put("loginIp", ipAddress);
				params.put("loginTime", loginTime);
				// 调用推送方法
				this.pushNews(oldUserEquipment, null, content, params);

				System.out.println("正在推送...\t" + content);
			}
		}
	}

	/**
	 * 推送水贴消息
	 * 
	 * @param postId
	 * @param userId
	 * @param userEquipment
	 */
	public void sendPostNews(String postId, String userId,
			Map<String, Object> userEquipment) {
		// TODO 消息状态还未修改(已完成第一版的消息)

		// 先将用户的isDel改成0 和 badge
		this.newsDao.updateState(postId);

		Map<String, Object> newsMap = this.newsDao
				.queryByparams(postId, userId);
		String updateTime = methodUtil.formatDate(new Date(), null, 0);
		List<Map<String, Object>> resultList = null;
		// 当前用户不存在该消息,先将该用户添加消息
		if (newsMap == null || newsMap.isEmpty() == true) {

			// 将该用户添加到该消息中
			resultList = this.newsDao.updateAndFind(postId, userId, updateTime,
					1);
			// System.out.println(users);
		} else {
			// 当前用户已经存在，修改消息的时间
			resultList = this.newsDao.updateAndFind(postId, userId, updateTime,
					0);
		}
		if (resultList != null && resultList.size() > 0) {
			// 获取用户
			// BasicDBList obj = (BasicDBList) resultMap.get("users");
			for (int i = 0; i < resultList.size(); i++) {
				Map<String, Object> userObj = (Map<String, Object>) resultList
						.get(i);

				String _id = (String) userObj.get("_id");
				// Map<String, Object> userEq = (Map<String, Object>) userObj
				// .get("userEquipment");
				String equitNo = (String) userObj.get("equitNo");
				String osType = (String) userObj.get("osType");
				String isRead = (String) userObj.get("isRead");

				// 若是已读用户则推送消息
				if (isRead.equals("1") && !_id.equals(userId)) {
					Equipment equipment = new Equipment();

					equipment.setEquitNo(equitNo);
					equipment.setOsType(osType);

					if (osType.equals("1")) {
						equipment.setBadge((Integer) userObj.get("badge") + 1); // 得到的badge是未更新前的值,所以要加一
						equipment.setSound((String) userObj.get("sound"));
					}

					String content = "你有一条新的消息";
					Map<String, String> params = new HashMap<String, String>();
					params.put("type", "10002");// 水贴的消息
					// 推送水贴消息
					this.pushNews(equipment, null, content, params);

					System.out.println("正在推送用户:" + _id + "\tequitNo:" + equitNo
							+ "\tosType:" + osType);

				}
			}
		}
	}

	/**
	 * 创建post消息
	 * 
	 * @param postId
	 * @param userId
	 * @param userEquipment
	 */
	public void createPostNews(String postId, String userId,
			Map<String, Object> userEquipment) {
		// TODO Auto-generated method stub

		// List<Map<String, Object>> users = new ArrayList<Map<String,
		// Object>>();
		//
		// Map<String, Object> user = new HashMap<String, Object>();
		// user.put("_id", userId);
		// user.put("isRead", 1);// 是否已经阅读 1：已阅读 0：未阅读
		// user.put("isDel", 0);// 是否删除 1：删除 0：未删除
		// user.put("userEquipment", userEquipment);
		//
		// users.add(user);
		//
		// Map<String, Object> postNews = new HashMap<String, Object>();
		// postNews.put("_id", methodUtil.getUUID());
		// postNews.put("users", users);
		// postNews.put("updateTime", methodUtil.formatDate(new Date(), null,
		// 0));

		// DBRef dbRef = new DBRef(db, "post", "2014062509521826635294167");

		this.newsDao.createPostNews(postId, userId);
	}

	/**
	 * 推送
	 * 
	 * @param equipment
	 *            设备信息(包括：registerId(equitNo)，osType，badge，sound) android则没有后两项
	 * @param title
	 *            通知栏的标题
	 * @param content
	 *            通知栏的内容
	 * @param params
	 *            自定义参数
	 */
	public void pushNews(Equipment equipment, String title, String content,
			Map<String, String> params) {
		taskExecutor.execute(new PushInfoThread(equipment, title, content,
				params));
	}

	/**
	 * 推送批量信息
	 * 
	 * @param userList
	 *            设备信息集合(包括：registerId(equitNo)，osType，badge，sound)
	 *            android则没有后两项
	 * @param title
	 *            通知栏的标题
	 * @param content
	 *            通知栏的内容
	 * @param params
	 *            自定义参数
	 */
	public void pushNews(List<Equipment> equipments, String title,
			String content, Map<String, String> params) {
		PushListInfoThread pushListInfoThread = new PushListInfoThread(
				equipments, title, content, params);
		Thread thread = new Thread(pushListInfoThread);
		thread.start();
//		taskExecutor.equals(pushListInfoThread);
	}
}
