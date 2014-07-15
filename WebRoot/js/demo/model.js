// User类

Ext.define("user",{
	extend:"Ext.data.Model",
	fields:[
		{name:"name",type:"string",sortable:true},
		{name:"age",type:"int",sortable:true},
		{name:"email",type:"string",sortable:true}
	]
});
// user的对象
//var user = Ext.create("user",{});
Ext.create("Ext.data.Store",{
	model:"user",
	storeId:"s_user",
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