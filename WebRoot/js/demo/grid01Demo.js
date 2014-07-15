
Ext.onReady(function(){
	Ext.QuickTips.init();
	// 创建grid高级组件会用到grid面板
	var grid = Ext.create("Ext.grid.Panel",{
		title:"Grid Demo", // 标题
		frame:true,
		//forceFit:true,// 自动填充列的宽度
		width:600,
		height:280,
		columns:[ // 列模式的集合
			{text:"name",dataIndex:"name",width:100},
			{text:"age",dataIndex:"age",width:100},
			{text:"email",dataIndex:"email",width:360,
				field:{
					xtype: 'textfield',
					allowBlank:false
				}
			}
		],
		tbar:[
			{ 
				xtype: 'button', 
				text:'添加',
				iconCls : 'Applicationadd'
			},
			{ 
				xtype: 'button', 
				text:'删除',
				iconCls:'Applicationdelete',
				handler:function(btn){
//					var gridp = btn.findParentByType('gridpanel');
					var grid = btn.ownerCt.ownerCt;
//					alert(grid.getStore().getCount());
					var date = grid.getSelectionModel().getSelection();
					if(date.length == 0){
						Ext.Msg.alert("提示","您最少选择一条数据!");
					}else{
						//1、先得到id的数据[name]
						var st = grid.getStore();
						var ids = [];
						Ext.Array.each(date,function(record){
							ids.push(record.get('name'));
//							alert(record.get('name'));

						});
						//2、后台操作
						Ext.Ajax.request({
						    url: '../sys/delusers.do',
						    params: {ids:ids.join(",")},
						    method:'POST',
						    timeout:2000,
						    success: function(response,opts){
						        //var text = response.responseText;
						        //alert(text);
								//3、前台DOM删除
							    Ext.Array.each(date,function(record){
									st.remove(record);		
								});
						    }
						});
					}
				}
			},
			{ xtype: 'button', text:'修改',iconCls:'Applicationedit'},
			{ xtype: 'button', text:'查看',iconCls:'Applicationcascade'}
		],
		plugins:[
			Ext.create('Ext.grid.plugin.CellEditing',function(){
				clicksToEdit:1
			})
		],
		dockedItems:[// 分页组件
			{
				xtype:'pagingtoolbar',
				store:Ext.data.StoreManager.lookup("s_user"),
				dock:'bottom',
				displayInfo:true
			}
		],
		selType:'checkboxmodel',
		multiSelect:true,// 多选
		renderTo:"gridDemo",
		store:Ext.data.StoreManager.lookup("s_user")
	});
});