Ext.define('FM.controller.MenuTreeController',{
	extend:'Ext.app.Controller',
	WindowUtil:Ext.create("FM.util.WindowUtil"),
	init:function(){
		this.control({
			"menuTree":{
				itemclick:function( view, record, item, index,e,eOpts ){
					var id = record.data.id;
					if(id == "actList"){
						//alert(id);
						//var g = Ext.create("FM.view.ActivitiesList",{});
						var tabs = Ext.getCmp('center-grid');
		            	var actTab = Ext.getCmp('actTab');
		            	
		            	if(!actTab){
					            tabs.add({
					                title: '活动',
					                id: "actTab",
					                //html: '选项卡文本部分 <br/><br/>',
					                //active:true,
					                closable: true,
					                items:[{
						                id:"act_grid",
										//title: 'activitieslist',
										xtype:"activitieslist"
					                }]
					            });
		            			//tabs.add(g);
			            	tabs.setActiveTab("actTab");
		            	}else{
		            		tabs.setActiveTab("actTab");
		            	}
		            	var newGrid = Ext.getCmp('act_grid');
		            	var st = newGrid.store;
//		            	var sear = st.searchCondition;
//		            	sear.reset();
//		            	sear.beginTime = "2016-05-01";
//				        sear.endTime = "2017-06-08";
//				        sear.actTypeId = "手动加载标题";
//				        sear.keyWorld = "手动加载内容";
		            	st.load();
					}else if(id == "actPublish"){
						//alert("发布活动！");
						this.WindowUtil.doCreateActWindow();
					}
				}
			}
		});
	},
	views:[
		"MenuTree"
	],
	stores:[
	],
	models:[
	]
});