// User数据集合类
Ext.define("AM.store.Users",{
	extend:'Ext.data.Store',
	storeId:"s_user",
	model:'AM.model.User',
	pageSize:6,// 设置每页显示多少条数据
	proxy:{
		type:"ajax",
		url:"../sys/getusers.do",
		reader:{
			type:"json",
			root:"topics"
		},
		writer:{
			type:"json"
		}
	},
	autoLoad:true
});