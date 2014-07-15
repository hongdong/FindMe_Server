Ext.define("AM.store.DepartStore4Tree",{
	extend:"Ext.data.TreeStore",
	defaultRoodId:"root",
	proxy:{
		type:'ajax',
		url:"../sys/depttree.do",
		reader:'json'
		//root:"deptStore"
	},
	autoLoad:true
	
});