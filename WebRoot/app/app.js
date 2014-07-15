Ext.onReady(function(){
	Ext.QuickTips.init();
	// 启动自动加载
	Ext.Loader.setConfig({
		enabled:true
	});
	Ext.application({
		name:'AM', // 应用的名称
		appFolder:'../../app', // 应用的目录
		launch: function(){ // 当页面装载完成后自动调用
			Ext.create('Ext.container.Viewport', {
				 //layout: 'fit',
				padding:"15 15 15 15",
				 items:[
//				 	{
//					 	xtype:'userlist',
//					 	title:'Users',
//					 	html:'List fo users will go here'
//					 },{
//					 	xtype:'deptTree'
//				 	}
				 	{
				 		xtype:'mainlayout',
				 		width:800,
				 		height:520
				 		
				 	}
				 ]
			});
		},
		controllers:[
			'DepartController'//'Users','deptController',
		]
	});
});