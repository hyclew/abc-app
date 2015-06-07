$(document).ready(function() {
	/* (1)、分页条点击事件 开始 */
	var addEvent = function() {
		$("a", $(".w-page-nav")).each(function() {
			$(this).unbind().bind("click", function() {
				var pageNo = parseInt($(this).attr("data"));
				$.ajax({
					url : ctx + "/example/splitpage/pagedata",
					type : "POST",
					contentType : "application/x-www-form-urlencoded; charset=UTF-8",
					data : {
						pageNo : pageNo,
						pageSize : "6"
					},
					success : function(html) {
						$("#dataGrid").html(html);
						
						addEvent();// 重新给新生成的html添加点击事件
					}
				});
				
				return false;
			});
		});
		// 格式化金额
		$(".ui-currency", $("#dataGrid")).formatCurrency();
		// 查看事件
		addViewBtnEvent();
	};
	
	addEvent();
});
/**
 * 查看事件
 */
function addViewBtnEvent() {
	/* (2)、查看点击事件 开始 */
	$(".ui-msg-list-view", $("#dataGrid")).unbind().bind("click", function() {
		var html = "";
		// 创建模拟form
		html += "<form id='msgListViewFormId' action='" + ctx + "/example/splitpage/pageJump' method='POST' target='_blank'>";
		html += "  <input type='hidden' name='recNo' value='" + $(this).attr("data") + "'>";
		html += "</form>";
		// 是否创建form
		if ($("#msgListViewFormId").size() > 0) {
			$("#msgListViewFormId").remove();
		}
		$("body").prepend(html);
		// 提交
		$("#msgListViewFormId").submit();
	});
}
