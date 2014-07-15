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
  	cmtActId-->活动id <br/>
  	cmtContent-->内容  <br/>
  	cmtUserId-->发布评论的用户Id <br/>
	cmtRootId-->被回复的评论id(如果是根留言就传-1) <br/>
	cmtRepliedUserId-->被回复的用户(如果是根留言就传发布活动的用户id) <br/><br/><br/>
    <form action="<%=path%>/data/comt/cmt.do" method="post">
  		活动id:<input type="text" name="cmtActId" id="cmtActId" value="2014050610535345272014646"/> <br/>
  		内容:<input type="text" name="cmtContent" id="cmtContent" value=""/> <br/>
  		发布评论的用户Id:<input type="text" name="cmtUserId" id="cmtUserId" value="2014050211293367166472892"/> <br/>
  		被回复的评论id:<input type="text" name="cmtRootId" id="cmtRootId" value="-1"/> <br/>
  		被回复的用户:<input type="text" name="cmtRepliedUserId" id="cmtRepliedUserId" value="2014050217331604224894402"/> <br/>
  		<input type="submit" />
  	</form>
  </div>
  
  </body>
</html>
