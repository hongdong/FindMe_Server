package com.fm.util;

import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtil {

	/**
	 * SessionUtil 对象用于单例
	 * 
	 */
	private static SessionUtil sessionUtil = null;

	/**
	 * 私有构造方法，不让new实例
	 * 
	 */
	private SessionUtil() {

	}

	/**
	 * 获取一个实例(单例)
	 * 
	 * @return
	 */
	public static SessionUtil getInstance() {
		if (sessionUtil == null)
			sessionUtil = new SessionUtil();
		return sessionUtil;
	}

	/**
	 * 在session中保存user
	 * 
	 * @param request
	 */
	public void setSessionUser(Map<String, Object> user,
			HttpServletRequest request) {
		request.getSession().setAttribute(CommonVariables.LOGIN_USER, user);
	}

	/**
	 * 在session中获取user
	 * 
	 * @param request
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getSessionUser(HttpServletRequest request) {
		return (Map<String, Object>) request.getSession().getAttribute(
				CommonVariables.LOGIN_USER);
	}

	/**
	 * 在session中保存Object
	 * 
	 * @param request
	 */
	public void setSessionAttribute(String objName, Object obj,
			HttpServletRequest request) {
		request.getSession().setAttribute(objName, obj);
	}

	/**
	 * 在session中获取Object
	 * 
	 * @param request
	 */
	public Object getSessionAttribute(String objName, HttpServletRequest request) {
		return request.getSession().getAttribute(objName);
	}

	/**
	 * 在session中获取当前用户的头像
	 * 
	 * @param request
	 */
	public String getSessionUserPhoto(HttpServletRequest request) {
		Map<String, Object> user = this.getSessionUser(request);
		if (user != null && user.isEmpty() == false) {
			return (String) user.get("userPhoto");
		} else {
			return null;
		}
	}

	/**
	 * 在session中获取当前用户的id
	 * 
	 * @param request
	 */
	public String getSessionUserId(HttpServletRequest request) {
		Map<String, Object> user = this.getSessionUser(request);
		if (user != null && user.isEmpty() == false) {
			return (String) user.get("_id");
		} else {
			return null;
		}
	}

	/**
	 * 在session中获取当前用户的性别
	 * 
	 * @param request
	 */
	public String getSessionUserSex(HttpServletRequest request) {
		Map<String, Object> user = this.getSessionUser(request);
		if (user != null && user.isEmpty() == false) {
			return (String) user.get("userSex");
		} else {
			return null;
		}
	}

	/**
	 * 在session中获取当前用户的设备信息
	 * 
	 * @param request
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getSessionUserEquipment(
			HttpServletRequest request) {
		Map<String, Object> user = this.getSessionUser(request);
		if (user != null && user.isEmpty() == false) {
			return (Map<String, Object>) user.get("userEquipment");
		} else {
			return null;
		}
	}

	/**
	 * 在session中获取当前用户的昵称
	 * 
	 * @param request
	 */
	public String getSessionUserNickName(HttpServletRequest request) {
		Map<String, Object> user = this.getSessionUser(request);
		if (user != null && user.isEmpty() == false) {
			return (String) user.get("userNickName");
		} else {
			return null;
		}
	}

	/**
	 * 用户最后登录时间
	 * 
	 * @param request
	 * @return
	 */
	public String getSessionUserLastLoginTime(HttpServletRequest request) {
		Map<String, Object> user = this.getSessionUser(request);
		if (user != null && user.isEmpty() == false) {
			return (String) user.get("userLastLoginTime");
		} else {
			return null;
		}
	}

	/**
	 * 用户最后登录ip地址
	 * 
	 * @param request
	 * @return
	 */
	public String getSessionUserLastLoginIpAddress(HttpServletRequest request) {
		Map<String, Object> user = this.getSessionUser(request);
		if (user != null && user.isEmpty() == false) {
			return (String) user.get("userLastLoginIpAddress");
		} else {
			return null;
		}
	}

	/**
	 * 在session中获取当前用户的学校名称
	 * 
	 * @param request
	 */
	// public String getSessionUserScNo(HttpServletRequest request) {
	// return this.getSessionUser(request).getUserScNo();
	// }

	/**
	 * 清空session中的所有内容
	 * 
	 * @param request
	 */
	@SuppressWarnings("rawtypes")
	public void loginOut(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Enumeration e = session.getAttributeNames();
		while (e.hasMoreElements()) {
			String attributeName = (String) e.nextElement();
			// System.out.println("存在的Attribute有："+attributeName);
			session.removeAttribute(attributeName);
		}
	}

}
