<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
  <head>
    <script type="text/javascript">
    jQuery(function($){
		$('#businessProductTable').datagrid({
			title:'产品信息列表', //标题
			method:'post',
			iconCls:'icon-edit', //图标
			singleSelect:false, //多选
			height:360, //高度
			fitColumns: true, //自动调整各列，用了这个属性，下面各列的宽度值就只是一个比例。
			striped: true, //奇偶行颜色不同
			collapsible:true,//可折叠
			url:"businessproduct/queryList", //数据来源
			sortName: 'id', //排序的列
			sortOrder: '', //倒序
			remoteSort: true, //服务器端排序
			idField:'uid', //主键字段
			queryParams:{}, //查询条件
			pagination:true, //显示分页
			rownumbers:true, //显示行号
			columns:[[
				{field:'ck',checkbox:true,width:2}, //显示复选框
				{field:'name',title:'商品名称',width:20,sortable:true,
					formatter:function(value,row,index){return row.name;} //需要formatter一下才能显示正确的数据
				},{field:'numbers',title:'商品数量',width:20,sortable:true,
					formatter:function(value,row,index){return row.numbers;} //需要formatter一下才能显示正确的数据
				},{field:'unitPrice',title:'市场价',width:20,sortable:true,
					formatter:function(value,row,index){return row.unitPrice;} //需要formatter一下才能显示正确的数据
				},{field:'salePrice',title:'促销价格',width:20,sortable:true,
					formatter:function(value,row,index){return row.salePrice;} //需要formatter一下才能显示正确的数据
				},{field:'preferPrice',title:'xx银行卡价格',width:20,sortable:true,
					formatter:function(value,row,index){return row.preferPrice;} //需要formatter一下才能显示正确的数据
				},{field:'saleStartTime',title:'促销开始时间',width:20,sortable:true,
					formatter:function(value,row,index){return new Date(parseInt(row.saleStartTime)).toLocaleDateString();} //需要formatter一下才能显示正确的数据
				},{field:'saleOverTime',title:'促销结束时间',width:20,sortable:true,
					formatter:function(value,row,index){
						return new Date(parseInt(row.saleOverTime)).toLocaleDateString();
					} //需要formatter一下才能显示正确的数据
				},{field:'isSale',title:'是否促销',width:20,sortable:true,
					formatter:function(value,row,index){
						if(row.isSale=="1"){
							return "是";
						}else{
							return "否";
						}
					} //需要formatter一下才能显示正确的数据
				},{field:'onSale',title:'是否在架',width:20,sortable:true,
					formatter:function(value,row,index){
						if(row.onSale=="1"){
							return "否";
						}else{
							return "是";
						}
					} //需要formatter一下才能显示正确的数据
				},{field:'updateTime',title:'更新时间',width:20,sortable:true,
					formatter:function(value,row,index){return new Date(parseInt(row.updateTime)).toLocaleDateString();} //需要formatter一下才能显示正确的数据
				}
			]],
			toolbar:[{
				text:'新增',
				iconCls:'icon-add',
				handler:function(){
					addrow();
				}
			},'-',{
				text:'更新',
				iconCls:'icon-edit',
				handler:function(){
					updaterow();
				}
			},'-',{
				text:'删除',
				iconCls:'icon-remove',
				handler:function(){
					deleterow();
				}
			},'-'],
			onLoadSuccess:function(){
				$('#businessProductTable').datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
			}
		});
    	

	});
    
    //查看详细信息
    function viewDetails (date){
   		showWindow({
    			title:'商家详细信息',
    			href:'businessbase/viewDetails',
    			width:400,
    			height:250,
    			onLoad: function(){
    				$.post('businessbase/viewDetail?id='+date,function(data){
   		        	$("#userFormXXXX").form('load', data);
   	        	});
    		}
   		}); 
    }
    
    //新增
    function addrow(){
    	showWindow({
  			title:'添加商家商品信息',
  			href:'businessproduct/addWindow',
  			width:800,
  			height:590,
  			onLoad: function(){
  				//$('#userForm').form('clear');
  			}
  			
  		});
	}
	
  //更新
    function updaterow(){
		var rows = $('#businessProductTable').datagrid('getSelections');
		//这里有一个jquery easyui datagrid的一个小bug，必须把主键单独列出来，要不然不能多选
		if(rows.length==0){
			$.messager.alert('提示',"请选择你要更新的用户",'info');
			return;
		}
		if(rows.length > 1){
			$.messager.alert('提示',"只能选择一位用户进行更新",'info');
			return;
		}
		showWindow({
			title:'更新用户信息',
			href:'businessbase/upWindow',
			width:300,
			height:250,
			onLoad: function(){
			//自动将数据填充到表单中，无需再查询数据库，这里需要注意：
			//如果用的是struts2，它的表单元素的名称都是user.id这样的，那load的时候不能加.user要.form('load', rows[0]);
			//而spring mvc中表单元素的名称不带对象前缀，直拉就是id，所以这里load的时候是：.form('load', rows[0].user)
				$("#userForm").form('load', rows[0]);
			}
		});
	}
  	
  //删除
  	function deleterow(){
  		$.messager.confirm('提示','确定要删除吗?',function(result){
	        if (result){
	        	var rows = $('#businessProductTable').datagrid('getSelections');
	        	var ps = "";
	        	$.each(rows,function(i,n){
	        		if(i==0) 
	        			ps += "?uid="+n.id;
	        		else
	        			ps += "&uid="+n.id;
	        	});
	        	$.post('businessbase/delete'+ps,function(data){
		        	$('#businessProductTable').datagrid('reload'); 
	        		$.messager.alert('提示',data.mes,'info');
	        	});
	        }
	    });
  	}
    //表格查询
	function searchUser(){
		var params = $('#businessProductTable').datagrid('options').queryParams; //先取得 datagrid 的查询参数
		var fields =$('#queryForm').serializeArray(); //自动序列化表单元素为JSON对象
		$.each( fields, function(i, field){
			params[field.name] = field.value; //设置查询参数
		}); 
		$('#businessProductTable').datagrid('reload'); //设置好查询参数 reload 一下就可以了
	}
	//清空查询条件
	function clearForm(){
		$('#queryForm').form('clear');
		searchUser();
	}
    
	</script>	
  </head>
  
  <body>
    <form id="queryForm" style="margin:10;text-align: center;">
		<table width="100%">
			<tr>
				<td align="center">商品名称：<input name="name" ></td>
				<td align="right"><a href="#" onclick="clearForm();" class="easyui-linkbutton" iconCls="icon-search">清空</a></td>
				<td align="left"><a href="#" onclick="searchUser();" class="easyui-linkbutton" iconCls="icon-search">查询</a></td>
			</tr>
		</table>
	</form>
	<div style="padding:10" id="tabdiv">
		<table id="businessProductTable"></table>
	</div>
  </body>
</html>
