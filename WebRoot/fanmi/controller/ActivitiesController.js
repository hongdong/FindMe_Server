Ext.define('FM.controller.ActivitiesController',{
	extend:'Ext.app.Controller',
	GridDoActionUtil:Ext.create("FM.util.GridDoActionUtil"),
	WindowUtil:Ext.create("FM.util.WindowUtil"),
	init:function(){
		this.getGrid = function(button){
			return button.ownerCt.ownerCt;
		};
		this.getTree = function(button){
			return button.ownerCt.ownerCt.ownerCt.ownerCt
				    	.child('#west-tree').child("#dept-tree");
		};
		
		this.control({
			"activitieslist button[id=delete]":{
				click:function(btn,e){
					var grid = this.getGrid(btn);
				 	var tree = this.getTree(btn);
				 	this.GridDoActionUtil.doDelete(grid,tree);
				}
			},
			"activitieslist button[id=save]":{
				click:function(btn,e){
					var grid = this.getGrid(btn);
				 	var tree = this.getTree(btn);
				 	this.GridDoActionUtil.doSave(grid,tree);
				}
			},
			"activitieslist button[id=add]":{
				click:function(btn,e){
//					//alert(btn.text);
//					// 获取grid对象
//					var grid = this.getGrid(btn);
//					var modelObj = {
//				        text: '',
//		       			id: 'A01',
//		       			info :'',
//		       			orderIndex:0,
//		       			manager:'',
//		       			nodeType:'ROOT',
//		       			leaf : true
//				    };
//				    //得到tree
//				    var tree = this.getTree(btn);
//					this.GridDoActionUtil.doInsert(grid,modelObj,tree);
					this.WindowUtil.doCreateActWindow();
				}
			},
			"activitieslist button[id=searchAct]":{
				click:function(btn,e){
					var keyWorld = Ext.getCmp("searchKeyWorld").getValue();
					var actTypeId = Ext.getCmp("searchActTypeId").getValue();
					var beginTime = Ext.getCmp("searchBeginTime").getValue();
					var endTime = Ext.getCmp("searchEndTime").getValue();
					
					var newGrid = Ext.getCmp('act_grid');
	            	var st = newGrid.store;
	            	var sear = st.searchCondition;
	            	sear.reset();
	            	sear.beginTime = beginTime;
			        sear.endTime = endTime;
			        sear.keyWorld = keyWorld;
			        sear.actTypeId = actTypeId;
	            	st.load();
				}
			},
			"activitieslist button[id=searchReset]":{
				click:function(btn,e){
					Ext.getCmp("searchKeyWorld").setValue("");
					Ext.getCmp("searchActTypeId").setValue("");
					Ext.getCmp("searchBeginTime").setValue("");
					Ext.getCmp("searchEndTime").setValue("");
				}
			}
		});
	},
	views:[
		'MainLayout',
		"MenuTree",
		"ActivitiesList"
	],
	stores:[
		"ActivitiesStore",
		"MenuStore4Tree",
		"CircleStore",
		"TypeStore"
	],
	models:[
		"ActivitiesModel",
		"CircleModel",
		"TypeModel"
	]
});