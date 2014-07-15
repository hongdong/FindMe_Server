package com.fm.util;

public class SqlUtil {

	public final static String SQL_SELECT_SC_DEPT = "select deptNo,deptName";

	public final static String SQL_SELECT_PRO = "select proNo,proName";

	public final static String SQL_SELECT_SCHOOL_ONE = "select scNo,scName";

	public final static String SQL_SELECT_SC_CITY_CIRCLE = "select s.scCId,s.scCHelpId,c.cityCId FROM t_school s,t_city c WHERE s.scNo=? AND s.scCityNo=c.cityNo";

	public final static String SQL_SELECT_USER_ONE = "select userNickName,userPhoto,userRealName,userSex,userScName,userDeptName,userSpecialty,userGrade,userEmail,userPhone,userQq,userSignature,userAuth";
	
	public final static String SQL_SELECT_USER_CIRCLE_ONE = "SELECT c.cName,c.cId,c.cLogo,c.cUserCount,c.cDescription,c.cActNumber,c.cType FROM t_circle c,t_user_circle uc,t_user u WHERE u.userId =? AND u.userId = uc.userId AND uc.cId = c.cId";

	public final static String SQL_UPDATE_USER_LOGIN_ONE = "update t_user set userLoginCount=userLoginCount+1,";

	public final static String SQL_UPDATE_USER_PULISH_ACT_NUM = "update t_user set userPublishActNumber=userPublishActNumber+1 ";
	
	public final static String SQL_UPDATE_USER_PULISH_TASK_NUM = "update t_user set userHelpNumber=userHelpNumber+1 ";
	
	public final static String SQL_UPDATE_CIRCLE_PULISH_ACT_NUM = "update t_circle set cActNumber=cActNumber+1 ";

	public final static String SQL_UPDATE_CIRCLE_ONE = "update t_circle set cUserCount=cUserCount+1 where cId=";

	public final static String SQL_INSERT_LOGIN_LOG = "insert into t_login_log(loginId,loginUserId,loginIp,loginTime) ";

	public final static String SQL_INSERT_USER_CIRCLE_PSTMT = "insert into t_user_circle(userCircleId,userId,cId) values(?,?,?)";

	public final static String SQL_INSERT_USER_CIRCLE_STMT = "insert into t_user_circle(userCircleId,userId,cId) ";

	public final static String SQL_INSERT_ACT_STMT = "insert into t_activities(actId,actUserId,actCId,actTitle,actContent,actReleaseTime,actBeginTime,actEndTime,actAddress,actTypeId,actPhoto,actReadNumber,actMessageNumber,actJoinNumber,actOutTime,actLastReplyTime,actTopType,actTag,actPublisher) ";
}
