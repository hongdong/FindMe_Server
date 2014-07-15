Ext.define('AM.controller.Users',{
	extend:'Ext.app.Controller',
	init:function(){
		this.control({
//			"userlist":{
//				itemclick:function(view , record, item, index, e, eOpts ){
//					var sm = view.getSelectionModel();
////					alert(Ext.JSON.encode(sm.getCurrentPosition()));
//				}
//			},
//			"userlist":{
//				edit:function(editor,  e,  eOpts){
//					// model
//					// 调用ajax
//					e.record.commit();
//					//alert("edit");
//				}
//			},
			"userlist button[id=save]":{
				click:function(btn){
					var grid = btn.ownerCt.ownerCt;
					var st = grid.getStore();
					st.sync();
					var records = st.getUpdatedRecords();
					Ext.Array.each(records,function(model){
						model.commit();
					});
					//alert(btn.text);
				}
			},
			"userlist button[id=delete]":{
				click:function(btn){
//					var grid = btn.findParentByType('gridpanel');
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
			"userlist actioncolumn[id=actionDelete]":{
				click:function(grid,item,rowIndex,colIndex,e){
//					alert(rowIndex + "   " + colIndex);
					var st = grid.getStore();
					var record = st.getAt(rowIndex);
					st.remove(record);
//					alert(record);
				}
			},
			"userlist button[id=selection]":{
				click:function(btn){
//					alert(btn.text);
					var grid = btn.ownerCt.ownerCt;
					var sm = grid.getSelectionModel();
//					sm.deselect(0);
//					alert(sm.getLastSelected().get("name"));
				}
			}
		});
	},
	views:[
		'List'
	],
	stores:[
		'Users'
	],
	models:[
		'User'
	]
});