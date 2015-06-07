var USER_CENTER_PAGE_SIZE="8";
$(document).ready(function(){
	new ComCheckBox({
		selector : "div[type='check']"
	});
	
	$(".index_icon_delete").click(function(){
		$(this).parent(".index_user_bg").hide();
	});
	$(".shouqi").click(function(){
		$(this).parents().siblings(".shouqi1").hide();
	});
	$(".zhankai").click(function(){
		$(this).parents().siblings(".shouqi1").show();
		$(this).parents().find(".index_user_bg").css("display","block");
	});
	
	$(".tianjia").click(function(){
			show_popup('.div_zy4','.shade','.div_close_ks,.icon_pop_close');
			});
	/**批量删除确认框**/
	addDelConfirmEvent();	
		
	$(".div_close_ks").click(function(){
		$(this).parents().find(".financing_p2p_zy123").show();
		});
	//.shade是遮罩层，不用管
	
	$(".guangzhou").click(function(){
			show_popup('.div_zy1','.shade','.div_close_zy,.quxiao');
	});

	initNavMenu();
	addEvent();//执行分页条点击事件方法
	addMsgDetailClickEvent();
	/* 分页条点击事件   结束  */
	
	$("div.nav_menu_con ul li a").on('click', function() {
		$("div.nav_menu_con ul li a").removeClass("nav_menu_con_cur");
		$(this).addClass("nav_menu_con_cur");
		var title=$("div.nav_menu_con ul li a.nav_menu_con_cur").attr("data-title");
		$.ajax({
			url : ctx + "/base/userCenter/load",
			type : "POST",
			//dataType : "json",
			contentType : 'application/x-www-form-urlencoded; charset=UTF-8',//
			data : {pageNo : "1",
				pageSize : USER_CENTER_PAGE_SIZE,
				queryContent :"",
				title:title
			},
			success : function(html) {
				onSuccess(html);
			}
		});
		
	});
	
	$("#search").on('click',loadTableAfterSearch);
	$("#deleteBatchBtn").on('click',batchDelete);
});
function addEvent(){
	$(".w-page-nav a").each(function(i){
		$(this).off("click").on("click", function(e){
			var pageNo = parseInt($(this).attr("data"));
			var param=$("#queryContent").val();
			var title=$("div.nav_menu_con ul li a.nav_menu_con_cur").attr("data-title");
			$.ajax({
				url : ctx + "/base/userCenter/load",
				type: "POST",
				contentType : "application/x-www-form-urlencoded",
				data : {
					pageNo : pageNo,
					pageSize : USER_CENTER_PAGE_SIZE,
					queryContent :param,
					title:title
				},
				success : function(html) {
					onSuccess(html);
				}
			});
			
			return false;
		});
	});
}

function onSuccess(html){
	$("#pageTable").html(html);
	$("#search").on('click',loadTableAfterSearch);
	$("#deleteBatchBtn").on('click',batchDelete);
	
	//批量删除按钮弹出框
	addDelConfirmEvent();
	//查看详细信息click事件
	addMsgDetailClickEvent();
	addEvent();//重新给新生成的html添加点击事件
	new ComCheckBox({
		selector : "div[type='check']"
	});
	
}
function loadTableAfterSearch(){
	var pageNo = "1";
	var param=$("#queryContent").val();
	var title=$("div.nav_menu_con ul li a.nav_menu_con_cur").attr("data-title");
	$.ajax({
		url : ctx + "/base/userCenter/load",
		type: "POST",
		contentType : "application/x-www-form-urlencoded",
		data : {
			pageNo : pageNo,
			pageSize : USER_CENTER_PAGE_SIZE,
			queryContent :param,
			title:title
		},
		success : function(html) {
			onSuccess(html);
		}
	});
	
}

function batchDelete(){
	var delData="";
	$("div.com_check_on").each(function(){
		delData=delData+$(this).attr("data")+",";
	});
	var param=$("#queryContent").val();
	var pageNo = $("div.w-page-nav a.current").attr("data");
	var title=$("div.nav_menu_con ul li a.nav_menu_con_cur").attr("data-title");
	$.ajax({
		url : ctx + "/base/userCenter/delete",
		type: "POST",
		contentType : "application/x-www-form-urlencoded",
		data : {
			pageNo : pageNo,
			pageSize : USER_CENTER_PAGE_SIZE,
			queryContent :param,
			title:title,
			delData:delData
		},
		success : function(html) {
			onSuccess(html);
		}
	});
}

function addDelConfirmEvent(){
	$(".nav_menu_content_del").click(function(){
		if(comfirmSelected()){
			show_popup('.div_zy2','.shade','.div_close_zy,.quxiao');
		}else{
			show_popup('.div_zy3','.shade','.div_close_zy,.quxiao2');
		}
	});
}
function addMsgDetailClickEvent(){
	$(".msg-detail").click(function(){
		var recNo=$(this).parent().parent().children(0).attr("data");
		var param=$("#queryContent").val();
		var pageNo = $("div.w-page-nav a.current").attr("data");
		var title=$("div.nav_menu_con ul li a.nav_menu_con_cur").attr("data-title");
		$.ajax({
			url : ctx + "/base/userCenter/msgDetail",
			type: "POST",
			contentType : "application/x-www-form-urlencoded",
			data : {
				recNo : recNo
			},
			success : function(html) {
				$("#grid").html(html);
				//注册返回列表和删除的按钮点击事件
				$(".return-list").click(function(){
					$.ajax({
						url : ctx + "/base/userCenter/load",
						type: "POST",
						contentType : "application/x-www-form-urlencoded",
						data : {
							pageNo : pageNo,
							pageSize : USER_CENTER_PAGE_SIZE,
							queryContent :param,
							title:title
						},
						success : function(html) {
							onSuccess(html);
						}
					});
				});
				
				$(".delete-msg").click(function(){
					$.ajax({
						url : ctx + "/base/userCenter/delete",
						type: "POST",
						contentType : "application/x-www-form-urlencoded",
						data : {
							pageNo : pageNo,
							pageSize : USER_CENTER_PAGE_SIZE,
							queryContent :param,
							title:title,
							delData:recNo+","
						},
						success : function(html) {
							onSuccess(html);
						}
					});
				});
			}
		});
	});
}
function comfirmSelected(){
	var delData="";
	$("div.com_check_on").each(function(){
		delData=delData+$(this).attr("data")+",";
	});
	if(delData==""){
		return false;
	}else{
		return true;
	}
}
function goTopEx(){
        var obj=document.getElementById("goTopBtn");
        function getScrollTop(){
        	return document.documentElement.scrollTop || document.body.scrollTop;
        }
        function setScrollTop(value){
                if(document.documentElement.scrollTop){
                    document.documentElement.scrollTop=value;
                }else{
                    document.body.scrollTop=value;
                }
            }    
        window.onscroll=function(){getScrollTop()>1000?obj.style.display="":obj.style.display="none";}  

//getScrollTop()>500 距离顶部500px 时候显示返回顶部按钮。自己设置哦
        obj.onclick=function(){
            var goTop=setInterval(scrollMove,10);
            function scrollMove(){
                setScrollTop(getScrollTop()/1.1);
                if(getScrollTop()<1)clearInterval(goTop);
            }
        }
    }
