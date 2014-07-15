

Ext.define("FM.util.WindowUtil",{
	
	doCreateActWindow:function(){
		
		var window = Ext.getCmp("windowActPublish");
		if(!window){
			Ext.create('Ext.window.Window', {
			    title: '发布活动',
			    id:"windowActPublish",
			    height: 570,
			    width: 600,
			    border: false,
			    layout: 'fit',
			    modal:true,
			    iconCls:'Applicationadd',
			    items: {  
			        xtype: 'form',
			        border: false,
			        id:'act_form',
			        frame : true,
			        padding:'10 0 0 0',
			        //layout: 'form',
			        defaultType:'textfield',
					defaults:{
						labelSeparator :": ",
						labelWidth : 50,
						width : 500,
						allowBlank: false,
						msgTarget : 'side',
						labelAlign:'left'
					},
			        items : [{
			        	fieldLabel:'标题',
			        	labelWidth:100,
			        	labelAlign:'right',
						name:'actTitle',
						id:'actTitle',
						selectOnFocus:true
					},{
						xtype:'combobox',
						labelWidth:100,
						labelAlign:'right',
						listConfig:{//控制下拉列表的样式
							emptyText:'没有找到匹配的数值',
							maxHeight:200
						},
						fieldLabel:'选择圈子',
						name:'actCId',
						id:'actCId',
						queryMode:'remot',//[local|remot]
						store:"CircleStore",
						valueField:"cId",
						displayField :'cName',
						forceSelection:true,//不运行使用数据集合中没有的数值
						typeAhead : true,
						value:'001'
//						listeners:{select:provinceSelect}//添加监听器..当下拉列表选择某项时触发，实现级联
					},{
						xtype:'combobox',
						labelWidth:100,
						labelAlign:'right',
						listConfig:{//控制下拉列表的样式
							emptyText:'没有找到匹配的数值',
							maxHeight:200
						},
						fieldLabel:'选择类型',
						name:'actTypeId',
						id:'actTypeId',
						queryMode:'remot',//[local|remot]
						store:"TypeStore",
						valueField:"typeId",
						displayField :'typeName',
						forceSelection:true,//不运行使用数据集合中没有的数值
						typeAhead : true
//						value:'001'
					},{
						xtype: 'panel',
						frame : true,
						width : 500,
						baseCls:'my-panel-no-border',
						padding:'5 0 5 0',
						border:false,
//						layout: {
//					        type: 'hbox',
//					        align: 'stretch'
//					    },
						layout: 'column',
					    items:[{
						    xtype:'datefield',
						    columnWidth: 0.5,
						    border:false,
						    flex:1,
							fieldLabel:'开始日期',
							name:'beginDate',
							id:'beginDate',
							labelWidth:100,
							labelAlign:'right',
							format : "Y-m-d",
							minValue:'1948-02-01',  
					        maxValue:'2109-12-31',  
					        allowBlank:false,  
					        value:new Date() 
							//minValue:'01/01/2011',
							//maxValue:'31/12/2011',
							//disabledDays :[0,8],
							//disabledDates:['11年11月08日'],
							//disabledDatesText:'这个日期你不能选择'
					    },{
					    
					    	xtype:'timefield',
					    	columnWidth: 0.5,
					    	flex:1,
					    	panding:'0 0 0 0',
							fieldLabel:'开始时间',
							name:'beginTime',
							id:'beginTime',
							labelWidth:100,
							labelAlign:'right',
	//						minValue:'9:00',
	//						maxValue:'18:00',
	//						minText:'时间要大于{0}',
	//						maxText:'时间要小于{0}',
							format:'H:i',
							increment:60,
							allowBlank: false,
							msgTarget : 'side',
							invalidText:'时间格式错误',
							pickerMaxHeight :100 
					    }]
						
					},{
						xtype: 'panel',
						width : 500,
						frame : true,
						baseCls:'my-panel-no-border',
						padding:'5 0 10 0',
						border:false,
						layout: 'column',
					    items:[{
					    	xtype:'datefield',
							fieldLabel:'结束日期',
							columnWidth: 0.5,
							name:'endDate',
							id:'endDate',
							labelWidth:100,
							labelAlign:'right',
							format : "Y-m-d",
							value:new Date()
							//minValue:'01/01/2011',
							//maxValue:'31/12/2011',
							//disabledDays :[0,8],
							//disabledDates:['11年11月08日'],
							//disabledDatesText:'这个日期你不能选择'
					    },{
						    xtype:'timefield',
							fieldLabel:'结束时间',
							columnWidth: 0.5,
							name:'endTime',
							id:'endTime',
							labelWidth:100,
							labelAlign:'right',
	//						minValue:'9:00',
	//						maxValue:'18:00',
	//						minText:'时间要大于{0}',
	//						maxText:'时间要小于{0}',
							format:'H:i',
							allowBlank: false,
							msgTarget : 'side',
							increment:60,
							invalidText:'时间格式错误',
							pickerMaxHeight :100 
					    }]
						
					},{
				    	fieldLabel:'主办方',
			        	labelWidth:100,
			        	labelAlign:'right',
						name:'actHoster',
						id:'actHoster',
						selectOnFocus:true
					},{
						fieldLabel:'地址',
			        	labelWidth:100,
			        	labelAlign:'right',
						name:'actAddress',
						id:'actAddress',
						selectOnFocus:true
					},{
						xtype:'textareafield',
						fieldLabel:'内容',
						labelWidth:100,
						labelAlign:'right',
						height:100,
						name:'actContent',
						id:'actContent'
			        },{
			        	fieldLabel:'标签',
			        	labelWidth:100,
			        	labelAlign:'right',
						name:'actTag',
						allowBlank: true,
						id:'actTag'
//						selectOnFocus:true
			        },{
			        	xtype:'checkboxgroup',
						//fieldLabel:'标签',
			        	padding:'0 0 0 100',
						labelWidth:100,
						labelAlign:'right',
						allowBlank: true,
						//width:335,
						columns:6,	
						items:[{
								xtype:'checkboxfield',
								inputValue:'免费',
								name:'actTag',
								//id:'actTag',
								boxLabel:'免费'
							},{
								xtype:'checkboxfield',
								inputValue:'演唱会',
								name:'actTag',
								//id:'actTag',
								boxLabel:'演唱会'
							},{
								xtype:'checkboxfield',
								inputValue:'运动',
								name:'actTag',
								//id:'actTag',
//								checked:true,
								boxLabel:'运动'
							},{
								xtype:'checkboxfield',
								inputValue:'交友',
								name:'actTag',
								//id:'actTag',
								boxLabel:'交友'
							},{
								xtype:'checkboxfield',
								inputValue:'歌剧',
								name:'actTag',
								//id:'actTag',
								boxLabel:'歌剧'
							}]
			        },{
			        	xtype: 'filefield',
				        name: 'actPhoto1',
				        fieldLabel: '图片1',
				        maxWidth:500,
				        labelWidth:100,
						labelAlign:'right',
				        msgTarget: 'side',
				        allowBlank: true,
				        anchor: '100%',
				        buttonText: '选择文件'
			        },{
			        	xtype: 'filefield',
				        name: 'actPhoto2',
				        fieldLabel: '图片2',
				        maxWidth:500,
				        labelWidth:100,
						labelAlign:'right',
				        msgTarget: 'side',
				        allowBlank: true,
				        anchor: '100%',
				        buttonText: '选择文件'
			        },{
			        	xtype: 'filefield',
				        name: 'actPhoto3',
				        fieldLabel: '图片3',
				        maxWidth:500,
				        labelWidth:100,
						labelAlign:'right',
				        msgTarget: 'side',
				        allowBlank: true,
				        anchor: '100%',
				        buttonText: '选择文件'
			        },{// 设置发布方为官方
				        xtype: 'hiddenfield',
				        name: 'actPublisher',
				        id: 'actPublisher',
				        value: 1
			        }],
			        buttonAlign: 'center',
			        buttons  : [{
						text:"提交",
			        	width:50,
			        	handler:function(btn){
			        		var act_form = Ext.getCmp("act_form");
			        		var formValue = act_form.getValues();
			        		console.log(formValue);
			        		var form = this.up('form').getForm();
			                if(form.isValid()){
			                    form.submit({
			                        url: '../../data/act/push.do',
			                        params:{formValue:Ext.encode(formValue)},
			                        type:'ajax',
			                        waitMsg: '正在保存文件...',
			                        success: function(form, action) {
			                        	var result = Ext.decode(action.response.responseText);
				                        var msg = "发布失败!";
				                        if(result == true){
				                        	msg = "发布成功!";
				                        	Ext.MessageBox.alert('提示信息',msg);
				                        	form.reset();
//				                        	form.findField('actTitle').reset();
//					                        form.findField('actCId').reset();
//					                        form.findField('actTypeId').reset();
//					                        form.findField('beginDate').reset();
//					                        form.findField('beginTime').reset();
//					                        form.findField('endDate').reset();
//					                        form.findField('endTime').reset();
//					                        form.findField('actAddress').reset();
//					                        form.findField('actHoster').reset();
//					                        form.findField('actContent').reset();
//					                        form.findField('actPhoto1').setRawValue('');
//					                        form.findField('actPhoto2').setRawValue('');
//					                        form.findField('actPhoto3').setRawValue('');
				                        }else{
				                        	msg = "发布失败!";
				                        	Ext.MessageBox.alert('提示信息',msg);
				                        }
			                        },
			                        failure: function(form, action) {
			                        	//alert('bbbbbbbbbbbbbbbbbbb');
								        switch (action.failureType) {
									            case Ext.form.action.Action.CLIENT_INVALID:
									                Ext.Msg.alert('Failure', 'Form fields may not be submitted with invalid values');
									                break;
									            case Ext.form.action.Action.CONNECT_FAILURE:
									                Ext.Msg.alert('Failure', 'Ajax communication failed');
									                break;
									            case Ext.form.action.Action.SERVER_INVALID:
									               Ext.Msg.alert('Failure', action.result.msg);
									       }
									    }
			                    });
			                }
			        	}
		        	},{
		        		text:"取消",
			        	width:50,
			        	handler:function(btn){
			        		btn.ownerCt.ownerCt.ownerCt.destroy();
			        	}
		        	}]
			    }
			    
			}).show();
		}
	}
});