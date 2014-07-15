

Ext.define("FM.view.MenuTree",{
	extend:"Ext.tree.Panel",
	alias:"widget.menuTree",
	//title:"部门树形",
	padding:"0 0 0 0",
	rootVisible:false,// 控制root不显示
	expanded:false,
	store:'MenuStore4Tree'
});