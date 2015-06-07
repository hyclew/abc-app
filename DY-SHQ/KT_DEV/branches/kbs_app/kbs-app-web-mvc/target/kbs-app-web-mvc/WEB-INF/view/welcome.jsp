<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/taglibs.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>kbs</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript">
		jQuery.ajaxSetup({cache:false});//ajax不缓存
		jQuery(function($){
			
		});
		
		function setmain(title,href){
			$(".combo-panel").parent(".panel").remove(); //清楚所有class为combo-panel的class为panel的父元素，解决combobox在页面缓存的问题
			var centerURL = href;
			var centerTitle = title;
			$('body').layout('panel','center').panel({
				title:"所在位置："+centerTitle,
				href:centerURL
			});
			$('body').layout('panel','center').panel('refresh');
			return false;		
		}
		
		//弹出窗口
		function showWindow(options){
			jQuery("#MyPopWindow").window(options);
		}
		//关闭弹出窗口
		function closeWindow(){
			$("#MyPopWindow").window('close');
		}
	</script>	
  </head>
  <!-- easyui-layout 可分上下左右中五部分，中间的是必须的，支持href，这样就可以不用iframe了 -->
  <body class="easyui-layout" id="mainBody">
  	<!-- 头部 开始 -->
	#parse("../template/common/top.html")
	<!-- 头部 结束 -->
	<!-- 导航 开始 -->
	#parse("common/topnav.html")
	<!-- 导航 结束 -->
		<!-- 上 -->
		<div region="north" split="false" style="height:100px;text-align: center;" border="false">
			<h1>欢迎： ${loginUser.username}</h1>
		</div>
		
		<!-- 左-->
		<div region="west" class="menudiv" split="true" title="系统菜单" style="width:200px;overflow:hidden;">
			<div id="menuDiv" class="easyui-accordion" fit="false" border="false" animate="false">
				<div title="运维管理" style="overflow:hidden;">
					<ul>					
						<li id="rightLi${child.id}" style="cursor: pointer;" 
							onclick="setmain('商家用户管理','${ctx}/businessbase/list')" >商家用户管理</li>
					</ul>	
				</div>
				<div title="商品管理" style="overflow:hidden;">
					<ul>					
						<li id="rightLi${child.id}" style="cursor: pointer;" 
							onclick="setmain('商品管理','${ctx}/businessproduct/list')" >商品管理</li>
					</ul>	
				</div>
			</div>
		</div>
		
		<!-- 中 -->
		<div region="center" class="maindiv" title="所在位置: 首页" style="overflow-x:hidden;padding: 0px;" href="${ctx}/html/welcome.html" ></div>
		<div id="MyPopWindow" modal="true" shadow="false" minimizable="false" cache="false" maximizable="false" collapsible="false" resizable="false" style="margin: 0px;padding: 0px;overflow: auto;"></div>
  </body>
</html>
