// User类
Ext.define("AM.model.User",{
	extend:"Ext.data.Model",
	fields:[
		{name:"name",type:"string",sortable:true},
		{name:"age",type:"int",sortable:true},
		{name:"email",type:"string",sortable:true},
		{name:"birthDay",type:"string",sortable:true},
		{name:"deposit",type:"int",sortable:true},
		{name:"it",type:'string',sortable:true},
		{name:"sex",type:'string',sortable:true}
	]
});
