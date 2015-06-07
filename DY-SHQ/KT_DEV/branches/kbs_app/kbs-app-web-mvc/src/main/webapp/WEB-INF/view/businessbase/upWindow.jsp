<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
  <head>
  	<script type="text/javascript">
		
		function addOrUpdateUser(){
			var r = $('#userForm').form('validate');
			if(!r) {
				return false;
			}
			document.getElementById("businessBase.id").value = document.getElementsByName("id")[0].value;
			document.getElementById("businessBase.name").value = document.getElementsByName("name")[0].value;
			document.getElementsByName("businessBase.address")[0].value = document.getElementsByName("address")[0].value;
			document.getElementsByName("businessBase.contractname")[0].value = document.getElementsByName("contractname")[0].value;
			$.post("businessbase/adUpdate",$("#userForm").serializeArray(),function(data){
				$('#MyPopWindow').window('close');
				$('#userTable').datagrid('reload');  
				$.messager.alert('提示',data.mes,'info');
			});
		}
	</script>
  </head>
  
  <body>
  	<!-- 验证还是jquery-validation好用，这里省事没用 -->
	<form id="userForm" method="post" style="margin: 10; text-align:left;">
		商家名称：<input name="name" style="width: 200" class="easyui-validatebox" required="true"> <br>
		商家地址：<input name="address" style="width: 200"  class="easyui-validatebox" required="true"> <br>
		联  系  人：<input name="contractname" style="width: 200"  class="easyui-validatebox" required="true"> <br><br>
		<!-- 产品分类：
		<input type="checkbox" name="productcatalogueid" value="1001">送水 
		<input type="checkbox" name="productcatalogueid" value="1002">洗衣 
		<input type="checkbox" name="productcatalogueid" value="1003">洗车 
		<input type="checkbox" name="productcatalogueid" value="1004">保洁  -->
		 <br><br><br>
		<input name="id" type="hidden">
		<input name="businessBase.id" id="businessBase.id" type="hidden">
		<input name="businessBase.name" id="businessBase.name" type="hidden">
		<input name="businessBase.address" type="hidden">
		<input name="businessBase.contractname" type="hidden"> 
		 
		<a href="#" id="btn-back" onclick="closeWindow();" class="easyui-linkbutton" iconCls="icon-back">返回</a>
		<a href="#" id="btn-add" onclick="addOrUpdateUser();" class="easyui-linkbutton" iconCls="icon-save">保存</a>
	</form>
  </body>
</html>
