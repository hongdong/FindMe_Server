<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'result.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		var flag = ${requestScope.uploadFlag};
		if(flag == true){
			alert("添加成功！");
			window.location.href="<%=path%>/data/act/topush.do";
		}else if(flag == false){
			alert("添加失败！");
			window.history.back();
		}
	</script>
  </head>
  
  <body>
    This is my JSP page. <br>
  </body>
</html>
