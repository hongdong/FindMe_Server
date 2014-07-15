/**
 * ClassName 部门实体数据集
 */
Ext.define("FM.store.ActivitiesStore",{
	extend:"Ext.data.Store",
	model:"FM.model.ActivitiesModel",
	searchCondition:new SearchCondition(),
//	defaultRoodId:"root",
	pageSize:15,
	proxy:{
		api:{
			update:'../../data/act/sysActList.do',
			remove:'../../data/act/sysActList.do'
		},
		type:'ajax',
		url:"../../data/act/sysActList.do",
		reader:{
			type:'json',
			root:"topics"
		},
		wiriter:{
			type:"json"
		}
	},
	listeners:{
         'beforeload': function(s, operation, eOpts ){
             s.proxy.extraParams= {
                     beginTime: s.searchCondition.beginTime, 
                     endTime: s.searchCondition.endTime,
                     actTypeId: s.searchCondition.actTypeId, 
                     keyWorld: s.searchCondition.keyWorld
                 };
         },
        'load': function( s, records, successful, eOpts ){
        }
    },
	autoLoad:false
});

function SearchCondition(){
        this.beginTime = "";
        this.endTime = "";
        this.actTypeId = "";
        this.keyWorld = "";
        this.reset = function(){
            this.beginTime = "";
            this.endTime = "";
            this.actTypeId = "";
            this.keyWorld = "";
        }
    } 
