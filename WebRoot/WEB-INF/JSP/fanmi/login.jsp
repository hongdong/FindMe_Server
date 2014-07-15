<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <%-- <base href="<%=basePath%>"> --%>
    <title>登录</title>
    
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
  
  <script type="text/javascript">
  	Ext.onReady(function(){
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
			                        var msg = "登录失败!";
			                        if(result == true){
			                        	//var tab1 = Ext.getCmp("tab1");
			                        	//alert(tab1);
			                        	//tab1.html = "aaaaaaa";
			                        	//alert(form.ownerCt);
			                        	var loginWindow = Ext.getCmp('loginWindow');
			                        	loginWindow.destroy();
			                        	window.location.href='../../admin/sys/togrid.do';
			                        	//msg = "登录成功!";
			                        	//Ext.MessageBox.alert('提示信息',msg);
			                        	//form.reset();
			                        }else{
			                        	msg = "登录失败!";
			                        	Ext.MessageBox.alert('提示信息',msg);
			                        }
		                        },
		                        failure: function(form, action) {
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
  	});
  </script>
  </head>
  <!-- <div style="width: 500px;height: 500px;border: 1px solid red;" id="t1"></div> -->
  <body>

  </body>
</html>
