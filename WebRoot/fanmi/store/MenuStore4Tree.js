Ext.define("FM.store.MenuStore4Tree",{
	extend:"Ext.data.TreeStore",
	defaultRoodId:"root",
	proxy:{
		type:'ajax',
//		url:"../sys/depttree.do",
		url:"../../fanmi/json/tree.json",
		reader:'json'
		//root:"deptStore"
	},
	autoLoad:true
	
});