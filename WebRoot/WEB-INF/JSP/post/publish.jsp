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
  <form action="<%=path%>/data/post/release_post.do" method="post" enctype="multipart/form-data">
  	
	 内容：<input type="text" name="postContent" id="postContent" />
	  <br/>
	  <br/>
 	postOfficial：<input type="text" name="postOfficial" id="postOfficial" value="1"/> 官方发布(1:官方 2：个人)
 	 <br/>
	  <br/>
  	  图片1：<input type="file" name="file1" id="file1"/> 
  	  图片2：<input type="file" name="file2" id="file2"/> 
  	  图片3：<input type="file" name="file3" id="file3"/> <br/>
  	  图片4：<input type="file" name="file4" id="file4"/> 
  	  图片5：<input type="file" name="file5" id="file5"/> 
  	  图片6：<input type="file" name="file6" id="file6"/> <br/>
  	  图片7：<input type="file" name="file7" id="file7"/> 
  	  图片8：<input type="file" name="file8" id="file8"/> 
  	  图片9：<input type="file" name="file9" id="file9"/> <br/>
  	  <br/>
  	  <input type="submit" id="sub" />
  </form>
  </div>
  </body>
</html>
