<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>FindMe_院系添加页面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="<%=path%>/js/jquery-1.11.0.min.js"></script>
	<script type="text/javascript">
	 $(function(){
	 	$("#scProNo").change(function(){
	 		var scProNo = $("#scProNo").val();
		 	$.ajax({
			   type: "GET",
			   url: "<%=path%>/data/sc/changsc.do",
			   data: {scProNo:scProNo},
			   dataType: "json",
			   success: function(data){
			   	  $("#deptScNo").empty();
			   	  $.each( data, function(i, obj){
			   	   	  $("#deptScNo").append("<option value='"+obj.scNo+"'>"+obj.scName+"</option>");
				  });
			   }
			});
	 	});
	 	
	 	$("#addDept1").click(function(){
	 		var deptScId = $("#deptScId").val();
	 		var deptNameFormat = $("#deptNameFormat").html();
		 	$.ajax({
			   type: "GET",
			   url: "<%=path%>/data/sc/adddept.do",
			   data: {deptScId:deptScId,deptNameFormat:deptNameFormat},
			   dataType: "json",
			   success: function(data){
			      var flag = data;
			   	  alert(data);
			   	  if(flag == true){
			   	  	   alert("添加成功");
			   	  }else  if(flag == false){
			   	  	   alert("添加失败");
			   	  }
			   }
			});
	 	});
	 }); 
	</script>
  </head>
  
  <body>
  	<form action="<%=path%>/data/sc/adddept.do" method="post">
	    <div align="center">
  		<h2>添加学院</h2>
  		省份：
  		<select name="scProNo" id="scProNo">
  			<c:forEach items="${requestScope.proList}" var="pro">
  				<option value="${pro.proNo}">${pro.proName}</option>
  			</c:forEach>
  		</select>
  		学校：
  		<select name="deptScNo" id="deptScNo"></select><br/>
  		院系 ： 
  		<textarea rows="20" cols="100" name="deptNameFormat" id="deptNameFormat"></textarea>
  		<br/>
  		<!-- <input type="button" id="addDept" name="addDept" value="添加"/> -->
  		<input type="submit" id="addDept" name="addDept" value="添加" style="width: 100px;height: 40px;"/>
  		</div>
  	</form>
  </body>
</html>
