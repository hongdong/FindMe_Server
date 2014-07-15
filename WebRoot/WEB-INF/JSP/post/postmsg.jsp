<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>水贴发布</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="<%=path%>/js/jquery-1.11.0.min.js"></script>
	<script type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>
  <style type="text/css">
  	div {text-align: center;margin-top: 10px;}
  	#actTitle {width: 600px;}
  	#actAddress {width: 600px;}
  	#sub {width: 100px;height: 30px;}
  </style>
  </head>
  
  <body>
  <div >
  <form action="<%=path%>/data/post/post_msg.do" method="post" >
  	
	 内容：<input type="text" name="postMsgContent" id="postMsgContent" />
	  <br/>
	  <br/>
 	postId：<input type="text" name="postId" id="postId" value="2014062510374223247332797"/>
 	 <br/>
	  <br/>
  	  <br/>
  	  <input type="submit" id="sub" />
  </form>
  </div>
  </body>
</html>
