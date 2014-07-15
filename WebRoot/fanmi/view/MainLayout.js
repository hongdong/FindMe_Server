
/**
 * 部门管理main布局
 * 
 */
Ext.define("FM.view.MainLayout",{
	extend:"Ext.panel.Panel",
	alias:"widget.mainlayout",
	defaults:{
		split:false,
		bodyStyle:"padding:0px"
	},
	layout:"border",
	items:[{
	//		title:"顶部",
	//		iconCls:'Databasetable',
			region:"north",
//			xtype:"panel",
			xtype:"container",
			margins:"0 0 0 0",
			collapsible:false,  // 可折叠
			id:"north-top",
			border: 1,//#000000
//			layout: {
//                type: 'hbox',
//                align: 'middle'
//            },
			layout:'column',
			contentEl:'top',
		    style: {borderColor:'#84B335',backgroundColor: '#84B335',borderStyle:'solid', borderWidth:'1px'},
		    defaults: {
		        //labelWidth: 80,
		        // 隐式创建容器通过指定的xtype
		        xtype: 'component',
		        //flex: 1,
		        style: {
		            padding: '0 0 0 50'
		        }
		    },
			height:30
			//layout:"fit"
		},{
			title:"菜单",
			iconCls:'Databasetable',
			region:"west",
			xtype:"panel",
			margins:"0 2 5 5",
			width:200,
			height:520,
			split: true,//不允许改变大小
			collapsible:true,  // 可折叠
			id:"west-tree",
			layout:"fit",
			items:[{
				id:"menu-tree",
				xtype:"menuTree"
			}]
		},{
			//title:"部门数据表格",
			//iconCls:'Databasetable',
			region:"center",
			xtype:"tabpanel",
			margins:"0 5 5 0",
			//width:'200',
			//collapsible:false,  // 可折叠
			id:"center-grid",
			layout:"fit",
			items:[
//				{
//				id:"dept-grid",
//				title: 'activitieslist',
//				xtype:"activitieslist"
//			},
				{
			    id: "tab1",
	            title: '首页',
	            //html: "这只是一个非常普通的Tab。",
	            //autoLoad:top.jsp,
	            contentEl :'gg',
//	            items:[{xtype:'button',text:'按钮',handler:function(btn){
//	            	var tabs = Ext.getCmp('center-grid');
//	            	var newTab = Ext.getCmp('newTab');
//	            	if(!newTab){
//				            tabs.add({
//				                title: '新Tab ',
//				                id: "newTab",
//				                html: '选项卡文本部分 <br/><br/>',
//				                //active:true,
//				                closable: true
//				            });
//				            tabs.activate("newTab");
//	            	}else{
//	            		tabs.setActiveTab(2);
//	            	}
//	            	
//	            }}],
	            closable: false      
			}]
		},{
		//		title:"顶部",
		//		iconCls:'Databasetable',
				region:"south",
	//			xtype:"panel",
				xtype:"container",
				margins:"0 0 0 0",
				collapsible:false,  // 可折叠
				id:"south-foot",
				border: 1,//#000000
	//			layout: {
	//                type: 'hbox',
	//                align: 'middle'
	//            },
				layout:'column',
				//html:"aaaaa",
				contentEl:'foot',
			    style: {borderColor:'#84B335',backgroundColor: '#84B335',borderStyle:'solid', borderWidth:'1px'},
			    defaults: {
			        //labelWidth: 80,
			        // 隐式创建容器通过指定的xtype
			        xtype: 'component',
			        //flex: 1,
			        style: {
			            padding: '0 0 0 0'
			        }
			    },
				height:20
				//layout:"fit"
			}
	]
});