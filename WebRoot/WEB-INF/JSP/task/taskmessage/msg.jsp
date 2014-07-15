<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>活动评论</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
	div {text-align: center;}
	</style>
  </head>
  
  <body>
  
  <div>
  	tmTkId-->任务id <br/>
  	tmContent-->内容  <br/>
  	tmUserId-->发布评论的用户Id <br/>
	tmRootId-->被回复的评论id(如果是根留言就传-1) <br/>
	tmRepliedUserId-->被回复的用户(如果是根留言就传发布活动的用户id) <br/>
	tmRepliedUserNickName-->被回复的用户(如果是根留言就传发布活动的用户id) <br/><br/><br/>
    <form action="<%=path%>/data/tkmsg/push.do" method="POST">
  		任务id:<input type="text" name="tmTkId" id="tmTkId" value="2014050916055283660830944"/> <br/>
  		内容:<input type="text" name="tmContent" id="tmContent" value=""/> <br/>
  		发布评论的用户Id:<input type="text" name="tmUserId" id="tmUserId" value="2014050211293367166472892"/> <br/>
  		被回复的评论id:<input type="text" name="tmRootId" id="tmRootId" value="-1"/> <br/>
  		被回复的用户id:<input type="text" name="tmRepliedUserId" id="tmRepliedUserId" value="2014050217331604224894402"/> <br/>
  		被回复的用户昵称:<input type="text" name="tmRepliedUserNickName" id="tmRepliedUserNickName" value="番迷"/> <br/>
  		<input type="submit" />
  	</form>
  </div>
  
  </body>
</html>
