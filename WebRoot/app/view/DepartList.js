

Ext.define("AM.view.DepartList",{
	extend : 'Ext.grid.Panel',
	//title : "部门数据表格", // 标题
	alias:'widget.departlist',
	store :'DepartStore',
	width : '100%',
	height : '100%',
	selModel:{
		selType : 'checkboxmodel'
	},
	multiSelect : false,// 多选
	frame : true,
	border:0,
	enableKeyNav:true,
	columnLines:true,
	columns : [
//		{
//				text : "序号",
//				xtype: 'rownumberer',
//				width:50,
//				align:'center'
//			},
				{ // 列模式的集合
				text : "部门名称",
				dataIndex : "text",
				width : 100,
				field:{
					xtype:"textfield",
					allowBlank:false
				}
			},{
				text : "部门经理",
				dataIndex : "manager",
				width : 100,
				field:{
					xtype:"textfield",
					allowBlank:false
				}
//				renderer:function(value){
//					if(value){
//						if(value == "女"){
//							return "<font color='green'>"+value+"</font>";
//						}else if(value == "男"){
//							return "<font color='red'>"+value+"</font>";
//						}
//					}
//				}
			}, {
				text : "排序",
				dataIndex : "orderIndex",
				width : 50
			}, {
				text : "职能简介",
				dataIndex : "info",
				width : 160
//				field : {
//					xtype : 'textfield',
//					allowBlank : false
//				}
			}
	],
	initComponent:function(){
		this.editing = Ext.create("Ext.grid.plugin.CellEditing");
		this.plugins = [this.editing];
		this.callParent(arguments);
	},
	tbar : [{
				xtype : 'button',
				id:'add',
				text : '添加',
				iconCls : 'Applicationadd'
			}, {
				xtype : 'button',
				id:'delete',
				text : '删除',
				iconCls : 'Applicationdelete'
			}, {
				xtype : 'button',
				id:'update',
				text : '修改',
				iconCls : 'Applicationedit'
			}, {
				xtype : 'button',
				text : '查看',
				iconCls : 'Applicationcascade'
			}, {
				xtype : 'button',
				id : 'selection',
				text : 'selection',
				iconCls : 'Shapesmanyselect'
			}, {
				xtype : 'button',
				id : 'save',
				text : '保存',
				iconCls : 'Save'
			}
	],
	dockedItems : [{// 分页组件
	
				xtype : 'pagingtoolbar',
				store : 'DepartStore',
				dock : 'bottom',
				displayInfo : true
			}
	]
});