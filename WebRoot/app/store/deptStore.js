
Ext.define("AM.store.deptStore",{
	extend:"Ext.data.TreeStore",
	defaultRoodId:"root",
	proxy:{
		type:'ajax',
		url:"../sys/depttree.do",
		reader:'json',
		root:"deptStore"
	},
	autoLoad:true
});
