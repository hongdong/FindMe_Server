/**
 * ClassName 部门的实体
 * text : 部门的名称
 * id : id主键
 * info : 信息
 * orderIndex : 排序字段
 * manager : 部门的经理
 * nodeType : 节点类型
 * leaf :  是否叶子
 */
Ext.define("AM.model.DepartModel",{
	extend:"Ext.data.Model",
	fields:[
		{name:"text",type:"string",sortable:true},
		{name:"id",type:"string",sortable:true},
		{name:"info",type:"string",sortable:true},
		{name:"orderIndex",type:"int",sortable:true},
		{name:"manager",type:"string",sortable:true},
		{name:"nodeType",type:"string",sortable:true},
		{name:"leaf",type:"string",sortable:true}
	]
});
