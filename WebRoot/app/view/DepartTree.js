

Ext.define("AM.view.DepartTree",{
	extend:"Ext.tree.Panel",
	alias:"widget.departTree",
	//title:"部门树形",
	padding:"0 0 0 0",
	rootVisible:false,// 控制root不显示
	expanded:false,
	store:'DepartStore4Tree'
});