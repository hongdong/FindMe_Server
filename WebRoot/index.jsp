<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <title>番迷-首页</title>
    <link rel="shortcut icon" href="<%=path%>/css/images/ico/favicon.ico"></link>
    <META http-equiv="X-UA-Compatible" content="IE=8" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<%=path%>/css/home.css">
	
	<script type="text/javascript" src="<%=path%>/js/jquery-1.11.0.min.js"></script>
  </head>
  
  <body class="homeBody">
  	<!-- 上半部分--开始 -->
  	<div class="top">
  	  <div class="topDown">
  		<div class="topMenueBar">
  			<div class="topBarMiddle">
  			<div class="logo leftFloat"></div>
  			<div class="menueMiddle leftFloat">
	  			<div class="menue">
	  				<ol >
	  					<li><a class="visited visitedColor" href="<%=path%>/home/page/home_page.do" target="_self">首页</a></li>
	  					<li><a class="menueColor" href="<%=path%>/home/page/about_fm.do" target="_self">关于番迷</a></li>
	  					<li><a class="menueColor" href="<%=path%>/home/page/dynamic_fm.do" target="_self">番迷动态</a></li>
	  					<li><a class="menueColor" href="<%=path%>/home/page/phone_us.do" target="_self">联系我们</a></li>
	  					<li><a class="menueColor" href="<%=path%>/home/page/about_us.do" target="_self">关于我们</a></li>
	  					<li><a class="menueColor" href="<%=path%>/home/page/join_us.do" target="_self">加入我们</a></li>
	  				</ol>
	  			</div>
  			</div>
  			</div>
  		</div>
  		
  		<div class="clear"></div>
  		
  		<div class=topMiddle>
  			<div class="downloadDiv leftFloat">
		  		<div class="download">
		  			<ol >
		  				<li><a class="downloadIphone" href="#" target="_self"></a></li>
		  				<li><a class="downloadAndroid" href="#" target="_self"></a></li>
		  			</ol>
		  		</div>
	  		</div>
	  		<div class="phoneDiv leftFloat">
	  			<div class="phone"></div>
	  		</div>
  		</div>
  	  </div>
  	</div>
  	<!-- 上半部分--结束 -->
  	<!-- 中间部分--开始 -->
  	<div class="centerMiddle">
	  	<div class="centerBlock">
		  	<div class="leftFloat" id="columnLeft"></div>
		  	<div class="content leftFloat">
		  		<div class="cntRowTop"></div>
		  		<div class="cntRow clear">
		  			<div class="leftFirstPic leftFloat"></div>
		  			<div class="rightText leftFloat">
		  				<h2>发现精彩活动，体验不同大学生活经历</h2>
						<p>1.寻找校园活动，快速变身活动达人</p>
						<p>2.邀请同学一起参加，共同体验不同大学经历</p>
						<p>3.智能的日程管理，轻轻松松安排你我每次出行</p>
		  			</div>
		  		</div>
		  		<div class="cntRow clear">
		  			<div class="rightFirstPic rightFloat"></div>
		  			<div class="leftText leftFloat">
		  				<h2>正能量“雷锋帮帮忙”,学长学姐来帮忙</h2>
						<p>1.遇到问题找“雷锋”，百万学长学姐帮你忙</p>
						<p>2.快速解你得疑惑，收集满满的正能量</p>
						<p>3.帮帮学弟学妹，收获意外的惊喜</p>
		  			</div>
		  		</div>
		  		<div class="cntRow clear">
		  			<div class="leftSecondPic leftFloat"></div>
		  			<div class="rightText leftFloat">
		  				<h2>实名认证找同学，共同参加活动去</h2>
						<p>1.与教务系统安全实名认证，1秒完成</p>
						<p>2.邀请同学一起去玩，收获难忘的回忆</p>
						<p>3.真实的同学真实的活动，体验真实的经历</p>
		  			</div>
		  		</div>
		  		<div class="cntRow clear">
		  			<div class="rightSecondPic rightFloat"></div>
		  			<div class="leftText leftFloat">
		  				<h2>精美日历，帮助你管理每天日程 </h2>
						<p>1.快速查看参加的活动日期</p>
						<p>2.便捷的操作流程</p>
						<p>3.及时的活动时间提醒</p>
		  			</div>
		  		</div>
		  		<div class="cntRowbottum"></div>
		  	</div>
		  	<div class="leftFloat" id="columnRight"></div>
	  	</div>
  	</div>
  	<!-- 中间部分--结束 -->
  	<!-- 底部开始 -->
  	<div class="foot clear">
  		<div class="footBlock">
		  	<div class="footMiddle">
			  	<div class="footTop">
				  	<ol>
				  		<li><a href="#">关于番迷</a></li>
				  		<li><a href="#">用户协议</a></li>
				  		<li><a href="#">加入我们</a></li>
				  		<li><a href="#">联系我们</a></li>
				  	</ol>
			  	</div>
			  	<div class="footButttom">
			  		<p><a href="#">www.ifanmi.cn</a></p>
			  		<p>&copy;2014  番迷网   <a href="http://www.miitbeian.gov.cn"> 闽ICP备14008676号</a></p>
			  	</div>
		  	</div>
	  	</div>
  	</div>
  	<!-- 底部结束 -->
  </body>
</html>