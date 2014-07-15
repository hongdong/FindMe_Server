Ext.define('AM.controller.deptController',{
	extend:'Ext.app.Controller',
	init:function(){
		this.control({
			"deptTree button[id=allOpen]":{
				click:function(btn,e){
					var tree = btn.ownerCt.ownerCt;
					tree.expandAll(function(){
						//alert("expandAll")
					},this);
					//alert(btn.text);
				}
			},
			"deptTree button[id=allClose]":{
				click:function(btn,e){
					var tree = btn.ownerCt.ownerCt;
					tree.collapseAll(function(){
						//alert("expandAll")
					},this);
					//alert(btn.text);
				}
			},
			"deptTree button[id=treeAdd]":{
				click:function(btn,e){
					var tree = btn.ownerCt.ownerCt;
					var nodes = tree.getChecked();
					if(nodes.length == 1){
						var node = nodes[0];
						node.appendChild({
							//children:{
								text:"技术架构组",
								checked:true,
								id:'0103',
								leaf:true
							//}
						});
					}else{
						alert("只能选择一个节点");
					}
//					tree.collapseAll(function(){
//						//alert("expandAll")
//					},this);
//					alert(btn.text);
				}
			},
			"deptTree":{
				itemclick:function( view, record, item, index, e, eOpts ){
						alert(record.get('id'));		
				}
			}
		});
	},
	views:[
		'deptView'
	],
	stores:[
		'deptStore'
	],
	models:[
		
	]
});