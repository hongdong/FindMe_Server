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
Ext.define("FM.model.ActivitiesModel",{
	extend:"Ext.data.Model",
	fields:[
		{name:"actId",type:"string",sortable:true},
		{name:"actUserId",type:"string",sortable:true},
//		{name:"actCId",type:"string",sortable:true},
		{name:"actTitle",type:"string",sortable:true},
		{name:"actContent",type:"string",sortable:true},
		{name:"actReleaseTime",type:"string",sortable:true},
		{name:"actBeginTime",type:"string",sortable:true},
		{name:"actEndTime",type:"string",sortable:true},
		{name:"actAddress",type:"string",sortable:true},
		{name:"actPhoto",type:"string",sortable:true},
		{name:"actReadNumber",type:"int",sortable:true},
		{name:"actMessageNumber",type:"int",sortable:true},
		{name:"actJoinNumber",type:"int",sortable:true},
		{name:"actLastReplyTime",type:"string",sortable:true},
//		{name:"actProNo",type:"string",sortable:true},
//		{name:"actCityNo",type:"string",sortable:true},
//		{name:"actAreaNo",type:"string",sortable:true},
		{name:"actTopType",type:"int",sortable:true},
		{name:"actTag",type:"string",sortable:true},
		{name:"actPublisher",type:"int",sortable:true},
		{name:"actTypeId",type:"string",sortable:true},
		{name:"typeName",type:"string",sortable:true},
		{name:"userNickName",type:"string",sortable:true},
		{name:"userSex",type:"string",sortable:true},
		{name:"userPhoto",type:"string",sortable:true},
		{name:"userDeptName",type:"string",sortable:true},
		{name:"userGrade",type:"string",sortable:true}
//		{name:"actOutTime",type:"int",sortable:true},
//		{name:"actShareCircleId",type:"string",sortable:true},
	]
});
