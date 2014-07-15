Ext.define("AM.view.List", {
	extend : 'Ext.grid.Panel',
	title : "Grid Demo", // 标题
	frame : true,
	alias:'widget.userlist',
	// forceFit:true,// 自动填充列的宽度
	width : '100%',
	height : 280,
	columns : [{
				text : "序号",
				xtype: 'rownumberer',
				width:50,
				align:'center'
			},{ // 列模式的集合
				text : "name",
				dataIndex : "name",
				width : 100
			},{
				text : "sex",
				dataIndex : "sex",
				width : 50,
				renderer:function(value){
					if(value){
						if(value == "女"){
							return "<font color='green'>"+value+"</font>";
						}else if(value == "男"){
							return "<font color='red'>"+value+"</font>";
						}
					}
				}
			}, {
				text : "age",
				dataIndex : "age",
				width : 100
			}, {
				text : "email",
				dataIndex : "email",
				width : 160,
				field : {
					xtype : 'textfield',
					allowBlank : false
				}
			},{
				text:"isIt",
				dataIndex:"it",
				width:50,
				xtype: "booleancolumn",
				falseText:"否",
				trueText:"是"
			},{ // 不支持长整型的毫秒时间
				text:"birthDay",
				dataIndex:"birthDay",
				width:150,
				xtype: "datecolumn",
				format:"Y-m-d"
			},{
				text:"deposit",
				dataIndex:"deposit",
				width:150,
				xtype: "numbercolumn",
				format:'0,000'
			},{
				text:'Action',
				xtype:'actioncolumn',
				id:'actionDelete',
				iconCls:'Applicationdelete'
			},{
				text:'描述',
				xtype:'templatecolumn',
				tpl:'用户的姓名是{name},年龄是{age}'
			}
	],
	tbar : [{
				xtype : 'button',
				text : '添加',
				iconCls : 'Applicationadd'
			}, {
				xtype : 'button',
				id:'delete',
				text : '删除',
				iconCls : 'Applicationdelete'
			}, {
				xtype : 'button',
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
	plugins : [Ext.create('Ext.grid.plugin.CellEditing', function() {
				clicksToEdit : 2
			})
	],
	dockedItems : [{// 分页组件
	
				xtype : 'pagingtoolbar',
				store : 'Users',
				dock : 'bottom',
				displayInfo : true
			}
	],
//	selType : 'checkboxmodel',
//	selType : 'rowmodel',
	selType: 'cellmodel',
	multiSelect : true,// 多选
	store :'Users',
	initComponent:function(){
		this.callParent(arguments);
	}
});