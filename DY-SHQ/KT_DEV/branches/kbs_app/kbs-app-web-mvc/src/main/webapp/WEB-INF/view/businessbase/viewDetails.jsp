<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
  <head>
  	<script type="text/javascript">
	  	jQuery(function($){
	  		/* var da = $("data");
	  		for(var x in da){
				//alert(x+"="+da[x]);
				document.write(x+"="+da[x]);
			} */
	  		//$("#a").val('123');
	  	});
  	</script>
  </head>
  
  <body>
  	<!-- 验证还是jquery-validation好用，这里省事没用 -->
	<form id="userFormXXXX" method="post" style="margin: 10; text-align:left;">
		商家名称：<input  name="businessBase.name" readOnly="true" style="width: 200" class="easyui-validatebox" required="true"> <br>
		商家地址：<input  name="businessBase.address" readOnly="true"  style="width: 200" class="easyui-validatebox" required="true"><br>
		<!-- 商家地理信息：<input  name="businessBase.geogeo" style="width: 200" class="easyui-validatebox" required="true"><br> -->
		<!-- 支付工具：<input  name="userPay.payTool" style="width: 200" class="easyui-validatebox" required="true"><br> -->
		卡&nbsp;&nbsp;号：<input  name="userPay.cvv" readOnly="true"  style="width: 200" class="easyui-validatebox" required="true"><br>
		<!-- 商家状态：<input  name="businessBase.status" style="width: 200" class="easyui-validatebox" required="true"><br> -->
		联   系  人：<input  name="businessBase.contractname" readOnly="true"  style="width: 200" class="easyui-validatebox" required="true"><br>
		手   机  号：<input  name="userBase.phone" readOnly="true"  style="width: 200" class="easyui-validatebox" required="true"><br>
		固定电话：<input  name="userBase.telephone" readOnly="true"  style="width: 200" class="easyui-validatebox" required="true"><br>
		更新时间：<input  name="businessBase.updateTime" readOnly="true"  style="width: 200" class="easyui-validatebox" required="true"><br>
		<!-- 商家产品：<input  name="" style="width: 200" class="easyui-validatebox" required="true"><br>--> <br>
		
		<a href="#" id="btn-back" onclick="closeWindow();" class="easyui-linkbutton" iconCls="icon-back">返回</a>
		<!-- <a href="#" id="btn-add" onclick="addOrUpdateUser();" class="easyui-linkbutton" iconCls="icon-save">更新</a> -->
	</form>
  </body>
</html>
