Ext.onReady(function(){
	Ext.QuickTips.init();
	// 启动自动加载
	Ext.Loader.setConfig({
		enabled:true
	});
	Ext.application({
		name:'FM', // 应用的名称
		appFolder:'../../fanmi', // 应用的目录
		launch: function(){ // 当页面装载完成后自动调用
			Ext.create('Ext.container.Viewport', {
				 layout: 'fit',
				 padding:"0 0 0 0",
				 items:[
				 	{
				 		xtype:'mainlayout',
				 		width:'100%',
				 		height:'100%'
				 		
				 	}
				 ]
			});
		},
		controllers:[
			"ActivitiesController","MenuTreeController"//'DepartController'//'Users','deptController',
		]
	});
});