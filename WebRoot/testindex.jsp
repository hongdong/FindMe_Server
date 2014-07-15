<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>FindMe测试页面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  	<%-- <form action="<%=path%>/data/user/login.do" method="post">
	    <div align="center">
	    <h2>用户登录</h2>
  		学校 ： <input type="text" name="school" id="school" value="00007" /> <br/>
  		学号： <input type="text" name="student_id" id="student_id" value="3100302417" /><br/>
  		密码 ： <input type="password" name="pwd" id="pwd" value="860410"/><br/>
  		<input type="submit"/>
  		</div>
  	</form>
  	<br/>
  	<form action="<%=path%>/data/user/tran.do" method="post">
	    <div align="center">
	    <h2>事物测试</h2>
  		用户 ： <input type="text" name="id_1" id="id_1" value="1" /> <br/>
  		排行榜 ： <input type="text" name="id_2" id="id_2" value="1" /><br/>
  		pull ： <input type="text" name="id_3" id="id_3" value="1"/><br/>
  		<input type="submit"/>
  		</div>
  	</form> --%>
  	<form action="<%=path%>/data/user/rgst_user.do" method="post" enctype="multipart/form-data">
	    <div align="center">
  		<h2>用户注册</h2>
  		昵称 ： <input type="text" name="userNickName" id="userNickName" value="破晓" /> <br/>
  		<!-- 头像 ： <input type="text" name="userPhoto" id="userPhoto" value="Http://localhost:8080/user/photo.jpg" /><br/> -->
  		学校Id ： <input type="text" name="school._id" id="user.school._id" value="2014042916362582626084732"/><br/>
  		学校名称 ： <input type="text" name="school.schoolName" id="user.school.schoolName" value="福建工程学院"/><br/>
  		院系编码： <input type="text" name="department._id" id="user.department._id" value="2014042916362587894406009"/><br/>
  		院系名称 ： <input type="text" name="department.deptName" id="user.department.deptName" value="计算机与信息科学系"/><br/>
  		星座 ： <input type="text" name="userConstellation" id="userConstellation" value="摩羯座"/><br/>
  		年级 ： <input type="text" name="userGrade" id="userGrade" value="2010"/><br/>
  		性别 ： <input type="text" name="userSex" id="userSex" value="男"/><br/>
  		equitNo ： <input type="text" name="userEquipment.equitNo" id="userEquipment.equitNo" value="756213"/><br/>
  		osType:<input type="text" name="userEquipment.osType" id="userEquipment.osType" value="1" /> <br/>
  		openId ： <input type="text" name="userOpenId" id="userOpenId" value="123456789"/><br/>
  		type ： <input type="text" name="userAuthType" id="userAuthType" value="QZone"/><br/>
  		姓名 ： <input type="text" name="userRealName" id="userRealName" value="张三"/><br/>
  		头像：<input type="file" name="userPhoto1" id="userPhoto1"/> 
  		被喜欢率 ： <input type="text" name="userLikeRate" id="userLikeRate" value="0"/><br/>
  		匹配次数 ： <input type="text" name="userMatchTimes" id="userMatchTimes" value="0"/><br/>
  		userIsLike ： <input type="text" name="userIsLike" id="userIsLike" value="0"/><br/>
  		<input type="submit"/>
  		</div>
  	</form>
  	<form action="<%=path%>/data/user/grant_user.do" method="post">
	    <div align="center">
  		<h2>用户授权</h2>
  		openid： <input type="text" name="userOpenId" id="userOpenId" value="123456789" /> <br/>
  		type ： <input type="text" name="userAuthType" id="userAuthType" value="QZone" /><br/>
  		equitNo:<input type="text" name="equitNo" id="equitNo" value="15686565655" /> <br/>
	    osType:<input type="text" name="osType" id="osType" value="1" /> <br/>
	    backLogin:<input type="text" name="backLogin" id="backLogin" value="0" /> <br/>
  		<input type="submit"/>
  		</div>
  	</form>
  	
  	<a href="<%=path%>/data/act/actlist.do?cId=2014050209530102380028891&actId=&type=nl">活动列表（向下拉）</a>
  	<a href="<%=path%>/data/act/actlist.do?cId=2014050209530102380028891&actId=2014050418121446970800069&type=ul">活动列表（向上拉）</a>
  	<a href="<%=path%>/data/comt/tocomt.do">活动评论</a>
  	<a href="<%=path%>/data/user/touphoto.do">修改用户头像</a>
  	<a href="<%=path%>/data/task/topush.do">发布任务</a>
  	<a href="<%=path%>/data/tkmsg/tomsg.do">任务留言</a>
  	<a href="<%=path%>/data/post/topushpost.do">发布水贴</a>
  	<a href="<%=path%>/data/post/topushpostmsg.do">发布水贴留言</a>
  	<a href="<%=path%>/data/user/toalbum.do">相册</a>
  	
  </body>
</html>
