/**
 * ClassName 部门实体数据集
 */
Ext.define("AM.store.DepartStore",{
	extend:"Ext.data.Store",
	model:"AM.model.DepartModel",
//	defaultRoodId:"root",
	proxy:{
		api:{
			update:'../sys/delusers.do',
			remove:'../sys/delusers.do'
		},
		type:'ajax',
		url:"../sys/getusers.do",
		reader:{
			type:'json',
			root:"topics"
		},
		wiriter:{
			type:"json"
		}
	},
	autoLoad:true
});


