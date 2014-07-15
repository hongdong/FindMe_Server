
/**
 * 部门管理main布局
 * 
 */
Ext.define("AM.view.MainLayout",{
	extend:"Ext.panel.Panel",
	alias:"widget.mainlayout",
//	width: 800,
//    height: 400,
	defaults:{
		split:true,
		bodyStyle:"padding:1px"
	},
	layout:"border",
	items:[
		{
			title:"部门树形",
			iconCls:'Databasetable',
			region:"west",
			xtype:"panel",
			margins:"5 2 5 5",
			width:200,
			heigth:520,
			collapsible:true,  // 可折叠
			id:"west-tree",
			layout:"fit",
			items:[{
				id:"dept-tree",
				xtype:"departTree"
			}]
		},{
			title:"部门数据表格",
			iconCls:'Databasetable',
			region:"center",
			xtype:"panel",
			margins:"5 5 5 0",
			//width:'200',
			//collapsible:true,  // 可折叠
			id:"center-grid",
			layout:"fit",
			items:[{
				id:"dept-grid",
				xtype:"departlist"
			}]
		}
	]
});