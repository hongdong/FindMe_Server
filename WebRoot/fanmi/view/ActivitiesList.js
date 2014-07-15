

Ext.define("FM.view.ActivitiesList",{
	extend : 'Ext.grid.Panel',
	//title : "部门数据表格", // 标题
	alias:'widget.activitieslist',
	store :'ActivitiesStore',
	width : '100%',
	height : 540,
	selModel:{
		selType : 'checkboxmodel'
	},
	scroll:true,
	multiSelect : false,// 多选
	frame : true,
	border:0,
	enableKeyNav:true,
	columnLines:true,
	columns : [{
				text : "序号",
				xtype: 'rownumberer',
				width:50,
				align:'center'
			},{ // 列模式的集合
				text : "活动标题",
				dataIndex : "actTitle",
				width : 200,
				field:{
					xtype:"textfield",
					allowBlank:false
				}
			},{
				text : "活动内容",
				dataIndex : "actContent",
				width : 150,
				field:{
					xtype:"textfield",
					allowBlank:false
				}
			}, {
				text : "发布时间",
				dataIndex : "actReleaseTime",
				width : 140
			},{
				text : "开始时间",
				dataIndex : "actBeginTime",
				width : 140
			},{
				text : "结束时间",
				dataIndex : "actEndTime",
				width : 140
			}, {
				text : "举办地址",
				dataIndex : "actAddress",
				width : 160
//				field : {
//					xtype : 'textfield',
//					allowBlank : false
//				}
			},{
				text : "浏览数",
				dataIndex : "actReadNumber",
				width : 55
			},{
				text : "留言数",
				dataIndex : "actMessageNumber",
				width : 55
			},{
				text : "参加人数",
				dataIndex : "actJoinNumber",
				width : 67
			},{
				text : "最后回复时间",
				dataIndex : "actLastReplyTime",
				width : 140
			},{
				text : "置顶类型",
				dataIndex : "actTopType",
				width : 60,
//				field:{
//					xtype:"textfield",
//					allowBlank:false
//				},
				renderer:function(value){
					if(value){
						if(value == 1){
							return "普通";
						}else if(value == 2){
							return "热门";
						}else if(value == 3){
							return "发现置顶";
						}
					}
				}
			},{
				text : "标签",
				dataIndex : "actTag",
				width : 130
			},{
				text : "发布方",
				dataIndex : "actPublisher",
				width : 60,
				renderer:function(value){
					if(value){
						if(value == 1){
							return "官方";
						}else if(value == 2){
							return "个人";
						}
					}
				}
			},{
				text : "类型",
				dataIndex : "typeName",
				width : 50
			},{
				text : "发布人",
				dataIndex : "userNickName",
				width : 50
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
			},{
				xtype: 'form',
		        border: false,
		        id:'act_search_form',
		        frame : true,
		        padding:'0 0 0 0',
		        layout: 'column',
		        defaultType:'textfield',
		        baseCls:'my-panel-no-border',
				defaults:{
					labelSeparator :": ",
					labelWidth : 50,
					width : 170,
					allowBlank: true,
					msgTarget : 'side',
					labelAlign:'left'
				},
				items : [{
		        	fieldLabel:'关键字',
		        	labelWidth:50,
		        	padding:'0 10 0 30',
		        	labelAlign:'right',
					name:'searchKeyWorld',
					id:'searchKeyWorld',
					columnWidth: 0.15,
					selectOnFocus:true
				},{
					xtype:'combobox',
					labelWidth:50,
					labelAlign:'right',
					listConfig:{//控制下拉列表的样式
						emptyText:'没有找到匹配的数值',
						maxHeight:200
					},
					columnWidth: 0.15,
					padding:'0 10 0 0',
					fieldLabel:'选择类型',
					name:'searchActTypeId',
					id:'searchActTypeId',
					queryMode:'remot',//[local|remot]
					store:"TypeStore",
					valueField:"typeId",
					displayField :'typeName',
					forceSelection:true,//不运行使用数据集合中没有的数值
					typeAhead : true
				},{
					xtype:'datetimefield',
					fieldLabel:'开始日期',
					padding:'0 10 0 0',
					width:200,
					labelWidth:50,
					id:'searchBeginTime',
					name:'searchBeginTime',
					columnWidth: 0.2
				},{
					xtype:'datetimefield',
					fieldLabel:'结束日期',
					width:200,
					labelWidth:50,
					padding:'0 10 0 0',
					id:'searchEndTime',
					name:'searchEndTime',
					columnWidth: 0.2
				},{
					xtype:'button',
					width:50,
					columnWidth: 0.15,
					padding:'0 10 0 10',
					id:'searchAct',
					text:'查询'
				},{
					xtype:'button',
					columnWidth: 0.15,
					width:50,
					padding:'0 10 0 10',
					id:'searchReset',
					text:'重置'
				}]
			}
	],
	dockedItems : [{// 分页组件
				xtype : 'pagingtoolbar',
				store : 'ActivitiesStore',
				dock : 'bottom',
				displayInfo : true
			}
	]
});