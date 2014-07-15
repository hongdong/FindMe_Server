package com.fm.model;

import java.util.ArrayList;


public class User {

	private String _id;

	/**
	 * 学校
	 * 
	 */
	private School school;
	/**
	 * 院系
	 * 
	 */
	private Department department;
	/**
	 * 昵称
	 * 
	 */
	private String userNickName;
	/**
	 * 姓名
	 * 
	 */
	private String userRealName;
	/**
	 * 性别
	 * 
	 */
	private String userSex;
	/**
	 * 个性签名
	 * 
	 */
	private String userSignature;
	/**
	 * 头像
	 * 
	 */
	private String userPhoto;
	/**
	 * 星座
	 * 
	 */
	private String userConstellation;
	/**
	 * 年级
	 * 
	 */
	private String userGrade;
	/**
	 * 授权方式 QZone、SinaWeibo
	 * 
	 */
	private String userAuthType;
	/**
	 * OpenId
	 * 
	 */
	private String userOpenId;
	/**
	 * 登录次数
	 * 
	 */
	private Integer userLoginCount;
	/**
	 * 帖子数量
	 * 
	 */
	private Integer userPostNumber;
	/**
	 * 认证用户(1:是 0:不是)
	 * 
	 */
	private Integer userAuth;
	/**
	 * 最后一次登录时间
	 * 
	 */
	private String userLastLoginTime;
	/**
	 * 最后一次登录ip
	 * 
	 */
	private String userLastLoginIpAddress;
	/**
	 * 注册时间
	 * 
	 */
	private String userRegisterTime;
	/**
	 * 设备
	 * 
	 */
	private Equipment userEquipment;
	/**
	 * 相册(URL数组)
	 * 
	 */
	private String[] userAlbum;

	/**
	 * 被喜欢率
	 * 
	 */
	private Double userLikeRate;

	/**
	 * 匹配次数
	 * 
	 */
	private Integer userMatchTimes;

	/**
	 * 当天是否已经like过
	 * 
	 */
	private Integer userIsLike;

	/**
	 * 被like次数
	 * 
	 */
	private Integer userLikeCount;

	/**
	 * 用户匹配
	 * 
	 */
	private ArrayList<Object> userMatch;
	
	
	private ArrayList<Object> userFans;
	
	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getUserNickName() {
		return userNickName;
	}

	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}

	public String getUserRealName() {
		return userRealName;
	}

	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public String getUserPhoto() {
		return userPhoto;
	}

	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}

	public String getUserGrade() {
		return userGrade;
	}

	public void setUserGrade(String userGrade) {
		this.userGrade = userGrade;
	}

	public Integer getUserLoginCount() {
		return userLoginCount;
	}

	public void setUserLoginCount(Integer userLoginCount) {
		this.userLoginCount = userLoginCount;
	}

	public Integer getUserPostNumber() {
		return userPostNumber;
	}

	public void setUserPostNumber(Integer userPostNumber) {
		this.userPostNumber = userPostNumber;
	}

	public Integer getUserAuth() {
		return userAuth;
	}

	public void setUserAuth(Integer userAuth) {
		this.userAuth = userAuth;
	}

	public String getUserLastLoginTime() {
		return userLastLoginTime;
	}

	public void setUserLastLoginTime(String userLastLoginTime) {
		this.userLastLoginTime = userLastLoginTime;
	}

	public String getUserLastLoginIpAddress() {
		return userLastLoginIpAddress;
	}

	public void setUserLastLoginIpAddress(String userLastLoginIpAddress) {
		this.userLastLoginIpAddress = userLastLoginIpAddress;
	}

	public String getUserRegisterTime() {
		return userRegisterTime;
	}

	public void setUserRegisterTime(String userRegisterTime) {
		this.userRegisterTime = userRegisterTime;
	}

	public String getUserConstellation() {
		return userConstellation;
	}

	public void setUserConstellation(String userConstellation) {
		this.userConstellation = userConstellation;
	}

	public Equipment getUserEquipment() {
		return userEquipment;
	}

	public void setUserEquipment(Equipment userEquipment) {
		this.userEquipment = userEquipment;
	}

	public String getUserSignature() {
		return userSignature;
	}

	public void setUserSignature(String userSignature) {
		this.userSignature = userSignature;
	}

	public String[] getUserAlbum() {
		return userAlbum;
	}

	public void setUserAlbum(String[] userAlbum) {
		this.userAlbum = userAlbum;
	}

	public String getUserAuthType() {
		return userAuthType;
	}

	public void setUserAuthType(String userAuthType) {
		this.userAuthType = userAuthType;
	}

	public String getUserOpenId() {
		return userOpenId;
	}

	public void setUserOpenId(String userOpenId) {
		this.userOpenId = userOpenId;
	}

	public Double getUserLikeRate() {
		return userLikeRate;
	}

	public void setUserLikeRate(Double userLikeRate) {
		this.userLikeRate = userLikeRate;
	}

	public Integer getUserMatchTimes() {
		return userMatchTimes;
	}

	public void setUserMatchTimes(Integer userMatchTimes) {
		this.userMatchTimes = userMatchTimes;
	}

	public Integer getUserIsLike() {
		return userIsLike;
	}

	public void setUserIsLike(Integer userIsLike) {
		this.userIsLike = userIsLike;
	}

	public Integer getUserLikeCount() {
		return userLikeCount;
	}

	public void setUserLikeCount(Integer userLikeCount) {
		this.userLikeCount = userLikeCount;
	}

	public ArrayList<Object> getUserMatch() {
		return userMatch;
	}

	public void setUserMatch(ArrayList<Object> userMatch) {
		this.userMatch = userMatch;
	}

	public ArrayList<Object> getUserFans() {
		return userFans;
	}

	public void setUserFans(ArrayList<Object> userFans) {
		this.userFans = userFans;
	}
	
	
}
