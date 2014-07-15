<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <%-- <base href="<%=basePath%>"> --%>
    <title>My JSP 'grid01.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="<%=path%>/js/extjs/resources/css/ext-all-neptune.css">
	<%-- <link rel="stylesheet" type="text/css" href="<%=path%>/js/extjs/resources/css/ext-all.css"> --%>
	<link rel="stylesheet" type="text/css" href="<%=path%>/js/extjs/icon/icon-css.css">
	<script type="text/javascript" charset="UTF-8" src="<%=path%>/js/extjs/bootstrap.js" ></script>
	<script type="text/javascript" charset="UTF-8" src="<%=path%>/js/extjs/ext-lang-zh_CN.js" ></script>
 
	<%-- <script type="text/javascript" charset="UTF-8" src="<%=path%>/js/demo/model.js" ></script> --%>
	<script type="text/javascript" charset="UTF-8" src="<%=path%>/fanmi/app.js" ></script>
	<script type="text/javascript" charset="UTF-8" src="<%=path%>/js/extjs/Go/form/field/DateTime.js" ></script>
	<script type="text/javascript" charset="UTF-8" src="<%=path%>/js/extjs/Go/picker/Color.js" ></script>
	<script type="text/javascript" charset="UTF-8" src="<%=path%>/js/extjs/Go/picker/DateTime.js" ></script>
	<script type="text/javascript" charset="UTF-8" src="<%=path%>/js/extjs/Go/picker/Month.js" ></script>
	<script type="text/javascript" charset="UTF-8" src="<%=path%>/js/extjs/Go/picker/Time.js" ></script>
  	<style type="text/css">
  		html,body,div,p,span,ol,li,h1,h2,hr {margin:0;padding:0;zoom:1;}
  	</style>
  	<script type="text/javascript">
	  	Ext.onReady(function(){
	  	var u = '${sessionScope.user.userNickName}';
	  	/* 	window.alert(u);
	  	var h = document.getElementById("sysuser").value;
	  	window.alert(h); */
	  		if(u == null || u == ""){
		  		Ext.create('Ext.window.Window', {
				    title: '登录',
				    height: 200,
				    width: 400,
				    layout: 'fit',
				    id:'loginWindow',
				    draggable : false,
				    closable : false,
				    modal:true,
				    //renderTo:Ext.getDom('t1'),
				    items: {  
				        xtype: 'form',
				        border: false,
				        id:'loginForm',
				        frame : true,
				        padding:'20 0 0 0',
				        //layout: 'form',
				        defaultType:'textfield',
						defaults:{
							labelSeparator :": ",
							labelWidth : 50,
							width : 300,
							allowBlank: false,
							msgTarget : 'side',
							labelAlign:'left'
						},items : [{
				        	fieldLabel:'用户名',
				        	labelWidth:100,
				        	labelAlign:'right',
							name:'userName',
							id:'userName',
							value:'fanmi',
							selectOnFocus:true
						},{
							inputType:'password',
							fieldLabel:'密码',
				        	labelWidth:100,
				        	labelAlign:'right',
							name:'password',
							id:'password',
							value:'fanmi123456',
							selectOnFocus:true
						}],
						buttonAlign: 'center',
					    buttons  : [{
							text:"提交",
				        	width:50,
				        	handler:function(btn){
				        		var loginForm = Ext.getCmp("loginForm");
				        		var formValue = loginForm.getValues();
				        		console.log(formValue);
				        		var form = this.up('form').getForm();
				                if(form.isValid()){
				                    form.submit({
				                        url: '../../admin/sys/login.do',
				                        params:{formValue:Ext.encode(formValue)},
				                        type:'ajax',
				                        waitMsg: '正在登录...',
				                        success: function(form, action) {
				                        	var result = Ext.decode(action.response.responseText);
				                        	//console.log(result);
					                        //var msg = "登录失败!";
					                        //if(result.success == true){
				                        	var pDom = Ext.getDom('userInfo');
				                        	pDom.innerHTML = result.userNickName + " 你好，<a style='color: red;border:0px solid red;text-decoration: none;' href='../../admin/sys/sys_logout.do' title='退出登录'>退出登录</a>"; 
				                        	var pDomInfo = Ext.getDom('userLoginInfo');
				                        	pDomInfo.innerHTML = "上次登录时间:" + result.userLastLoginTime + " 本次登录ip:" + result.userLoginIp + " 登录次数:" + result.userLoginCount; 
				                        	var loginWindow = Ext.getCmp('loginWindow');
				                        	loginWindow.destroy();
					                       // }else{
					                        	//msg = "登录失败!";
					                        	//Ext.MessageBox.alert('提示信息',msg);
					                       // }
				                        },
				                        failure: function(form, action) {
				                        	var result = Ext.decode(action.response.responseText);
				                        	var msg = "登录失败,用户名或密码错误!";
					                        if(result.success == false){
					                        	Ext.MessageBox.alert('提示信息',msg);
					                        	return;
					                        }
									        switch (action.failureType) {
									            case Ext.form.action.Action.CLIENT_INVALID:
									                Ext.Msg.alert('Failure', 'Form fields may not be submitted with invalid values');
									                break;
									            case Ext.form.action.Action.CONNECT_FAILURE:
									                Ext.Msg.alert('Failure', 'Ajax communication failed');
									                break;
									            case Ext.form.action.Action.SERVER_INVALID:
									               Ext.Msg.alert('Failure', action.result.msg);
									        }
									    }
				                    });
				                }
				        	}
			        	},{
			        		text:"重置",
				        	width:50,
				        	handler:function(btn){
				        		//btn.ownerCt.ownerCt.ownerCt.destroy();
				        	}
			        	}]
				    }
				}).show();
	  		}
	  	
	  	});
	  </script>
  </head>
  
  <body>
  <div id="gridDemo"></div>
  <%-- <div id="gg">
  	<p style="text-align: right;color: red;">${sessionScope.user.userNickName} 番迷 你好，欢迎登录</p>
  </div> --%>
  <div id="top">
	  	<h1 style="float: left;width: 300px;height: 30px;text-align:right;line-height:30px;overflow: hidden;">番迷后台管理系统</h1>
	  	<p id="userInfo" style="text-align:right; float: right;width: 300px;height: 300px;">
	  	 <c:if test="${sessionScope.user == null}">
		  	 你好,请登录
	  	 </c:if>
	  	 <c:if test="${sessionScope.user != null}">
	  	 	${sessionScope.user.userNickName} 你好，<a style="color: red;border:0px solid red;text-decoration: none;" href="<%=path%>/admin/sys/sys_logout.do" title="退出登录">退出登录</a>
	  	 </c:if>
	  	</p>
  </div>
  <div id="gg">
  	<div style="float: left;width: 300px;height: 300px;"><img style="width: 250px;height: 250px;" alt="公告" title="公告" src="../../css/images/sys_images/gonggao.jpg"></div>
  	<div style="float: left;width: 300px;height: 300px;"><img style="width: 250px;height: 250px;" alt="代办事务" title="代办事务" src="../../css/images/sys_images/daiban.jpg"></div>
  </div>
  <%-- <input type="text" id="sysuser" value="${sessionScope.user.userNickName}"/> --%>
  <div id="foot">
	  	<p id="userLoginInfo" style="text-align:right;width: 100%;height: 20px;line-height:20px;overflow: hidden;border:0px solid red;margin-top: 0;">
	  	 	上次登录时间:${sessionScope.user.userLastLoginTime} 本次登录ip:${sessionScope.userLoginIp} 登录次数:${sessionScope.user.userLoginCount} 
	  	</p>
  </div>
  </body>
</html>
