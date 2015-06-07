<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style type="text/css">
#preview{width:260px;height:190px;border:1px solid #999;margin: 0 auto;}
#imghead {filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=image);}
</style>
<html>
  <head>
  	<script type="text/javascript">
		jQuery(function($){
			//下拉表格初始化
			$('#addDeptId').combobox({
				valueField:'id', //值字段
			    textField:'name', //显示的字段
			    url:'dept/allList',
			    panelHeight:'auto',
			    required:true,
				editable:false//不可编辑，只能选择
			});
		});
		
		function addOrUpdateUser(){
			document.getElementById('businessProductAduit.attachmentUrl').value = document.getElementById('url').value;
			var r = $('#userForm').form('validate');
			if(!r) {
				return false;
			}
			$.post("businessproduct/addBusinessProduct",$("#userForm").serializeArray(),function(data){
				$('#MyPopWindow').window('close');
				$('#userTable').datagrid('reload');  
				$.messager.alert('提示',data.mes,'info');
			});
		}
		
		
		  //图片上传预览    IE是用了滤镜。
        function previewImage(file){
          var MAXWIDTH  = 260; 
          var MAXHEIGHT = 180;
          var div = document.getElementById('preview');
          if (file.files && file.files[0]){
              div.innerHTML ='<img id=imghead>';
              var img = document.getElementById('imghead');
              img.onload = function(){
                var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth, img.offsetHeight);
                img.width  =  rect.width;
                img.height =  rect.height;
                img.style.marginTop = rect.top+'px';
              }
              var reader = new FileReader();
              reader.onload = function(evt){img.src = evt.target.result;}
              reader.readAsDataURL(file.files[0]);
          }else{
            var sFilter='filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src="';
            file.select();
            var src = document.selection.createRange().text;
            div.innerHTML = '<img id=imghead>';
            var img = document.getElementById('imghead');
            img.filters.item('DXImageTransform.Microsoft.AlphaImageLoader').src = src;
            var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth, img.offsetHeight);
            status =('rect:'+rect.top+','+rect.left+','+rect.width+','+rect.height);
            div.innerHTML = "<div id=divhead style='width:"+rect.width+"px;height:"+rect.height+"px;margin-top:"+rect.top+"px;"+sFilter+src+"\"'></div>";
          }
        }
        function clacImgZoomParam( maxWidth, maxHeight, width, height ){
            var param = {top:0, left:0, width:width, height:height};
            if( width>maxWidth || height>maxHeight ){
                rateWidth = width / maxWidth;
                rateHeight = height / maxHeight;
                if( rateWidth > rateHeight ){
                    param.width =  maxWidth;
                    param.height = Math.round(height / rateWidth);
                }else{
                    param.width = Math.round(width / rateHeight);
                    param.height = maxHeight;
                }
            }
            param.left = Math.round((maxWidth - param.width) / 2);
            param.top = Math.round((maxHeight - param.height) / 2);
            return param;
        }
	</script>
  </head>
  
  <body>
  	<!-- 验证还是jquery-validation好用，这里省事没用 -->
	<form id="userForm" method="post" style="margin: 10; text-align:center;">
		商品名称：<input name="productBase.name" style="width: 200" class="easyui-validatebox" > <br>
		商品简介：<input name="productBase.introduce" style="width: 200" class="easyui-validatebox" > <br>
		单&nbsp;&nbsp;价：<input name="businessProductAduit.unitprice" style="width: 200" class="easyui-validatebox" > <br>
		数&nbsp;&nbsp;量：<input name="businessProductAduit.numbers" style="width: 200" class="easyui-validatebox" > <br>
		产品单位：<input name="productBase.unit" style="width: 200" class="easyui-validatebox" > <br>
		产品规格：<input name="productBase.specification" style="width: 200" class="easyui-validatebox" > <br>
		产品备注：<input name="productBase.comment" style="width: 200" class="easyui-validatebox" > <br>
		产品分类：<input name="productBase.productCatalogueId" style="width: 200" class="easyui-validatebox" > <br>
		协议条款：<textarea name="businessProductAduit.protocal" rows="5" cols="20" style="width: 200" class="easyui-validatebox" ></textarea> <br><br>
		<input type="hidden" name="businessProductAduit.attachmentUrl" id="businessProductAduit.attachmentUrl" >
		商品图片：<input name="url" id="url" type="file" onchange="previewImage(this)" style="width: 200" > <br><br>
		图片预览：			 
		<div id="preview" >
		   <img id="imghead" border=0 >
		</div>
		 <br>
		<a href="#" id="btn-back" onclick="closeWindow();" class="easyui-linkbutton" iconCls="icon-back">返回</a>
		<a href="#" id="btn-add" onclick="addOrUpdateUser();" class="easyui-linkbutton" iconCls="icon-save">保存</a>
	</form>
  </body>
</html>
