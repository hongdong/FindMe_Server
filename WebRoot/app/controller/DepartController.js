Ext.define('AM.controller.DepartController',{
	extend:'Ext.app.Controller',
	GridDoActionUtil:Ext.create("AM.util.GridDoActionUtil"),
	init:function(){
		this.getGrid = function(button){
			return button.ownerCt.ownerCt;
		};
		this.getTree = function(button){
			return button.ownerCt.ownerCt.ownerCt.ownerCt
				    	.child('#west-tree').child("#dept-tree");
		};
		
		this.control({
			"departlist button[id=delete]":{
				click:function(btn,e){
					var grid = this.getGrid(btn);
				 	var tree = this.getTree(btn);
				 	this.GridDoActionUtil.doDelete(grid,tree);
				}
			},
			"departlist button[id=save]":{
				click:function(btn,e){
					var grid = this.getGrid(btn);
				 	var tree = this.getTree(btn);
				 	this.GridDoActionUtil.doSave(grid,tree);
				}
			},
			"departlist button[id=add]":{
				click:function(btn,e){
					//alert(btn.text);
					// 获取grid对象
					var grid = this.getGrid(btn);
					var modelObj = {
				        text: '',
		       			id: 'A01',
		       			info :'',
		       			orderIndex:0,
		       			manager:'',
		       			nodeType:'ROOT',
		       			leaf : true
				    };
				    //得到tree
				    var tree = this.getTree(btn);
					this.GridDoActionUtil.doInsert(grid,modelObj,tree);
				}
				
			}
		});
	},
	views:[
		'MainLayout',
		"DepartList",
		"DepartTree"
	],
	stores:[
		"DepartStore",
		"DepartStore4Tree"
	],
	models:[
		"DepartModel"
	]
});