$(document).ready(function() {
	new ComSelect(".js-select");
	/* 分页条点击事件 开始 */
	var addEvent = function() {
		$(".w-page-nav a").each(function() {
			$(this).unbind().bind("click", function() {
				var pageNo = parseInt($(this).attr("data"));
				$.ajax({
					url : ctx + "/example/tableExample/load",
					type : "POST",
					contentType : "application/x-www-form-urlencoded",
					data : {
						pageNo : pageNo,
						pageSize : "6",
						name : "中文",
						money : 1234
					},
					success : function(html) {
						$("#grid").html(html);
						
						addEvent();// 重新给新生成的html添加点击事件
					}
				});
				
				return false;
			});
		});
	};
	
	addEvent();// 执行分页条点击事件方法
});