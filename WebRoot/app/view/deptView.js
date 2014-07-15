

Ext.define("AM.view.deptView",{
	extend:"Ext.tree.Panel",
	alias:"widget.deptTree",
	title:"部门树形",
	width:200,
	height:300,
	padding:"5 3 3 10",
	rootVisible:false,// 控制root不显示
	expanded:false,
	dockedItems:[{
	 	xtype: 'toolbar',
        dock: 'left',
        ui:"footer",
        items: [{
        	xtype:"button",
            text:"add",
            id:"treeAdd"
        },{
        	xtype:"button",
            text:"delete",
            id:"treeDelete"
        },{
        	xtype:"button",
            text:"update",
            id:"treeUpdate"
        }]
		
	},{
		xtype: 'toolbar',
		dock: 'top',
		items: [{
        	xtype:"button",
            text:"展开全部",
            id:"allOpen"
        },{
        	xtype:"button",
            text:"全部收起",
            id:"allClose"
        }]
	}],
	store:'deptStore'
//	{
//		text:"root",
//		id:'0',
//		leaf:false,
//		children:[{
//			text:"技术部门",
//			checked:false,
//			id:'01',
//			leaf:false,
//			children:[{
//				text:"研发部门",
//				checked:false,
//				id:'0101',
//				leaf:true
//			},{
//				text:"实施部门",
//				checked:false,
//				id:'0102',
//				leaf:true
//			}]
//		},{
//			text:"后勤部门",
//			checked:false,
//			id:'02',
//			leaf:false,
//			children:[{
//				text:"人事部",
//				checked:false,
//				id:'0201',
//				leaf:true
//			},{
//				text:"行政部",
//				checked:false,
//				id:'0202',
//				leaf:true
//			}]
//		}]
//	}
});