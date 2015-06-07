$(document).ready(function() {
	initNavMenu();
	
	$(".nav_twolist_cur_bg").hover(function() {
		$(this).children("ul").show().end().children("a").addClass("nav_twolist_cur");
	}, function() {
		$(this).children("ul").hide().end().children("a").removeClass("nav_twolist_cur");
	});
})
/**
 * 禁用F5
 */
$(document).keydown(function(event) {
	if (event.keyCode == 116) {
		return false;
	}
});
/**
 * 模拟动态meun效果
 */
function initNavMenu() {
	var mleft = 917;// 菜单容器宽度
	
	$(".fix-li", $("#nav")).click(function(event, flag) {
		var lock = $(".nav_con_list").attr("lock");
		if ("0" == lock) {
			// 加锁
			$(".nav_con_list").attr("lock", "1");
			
			$("a.nav_index").removeClass("nav_list_index");
			$("a.nav_index", $(this)).addClass("nav_list_index");
			$("ul.clearfix", $(this).closest("ul")).hide();
			// 动画
			var _self = $(this);
			var idx0 = $(this).attr("row"), idx1 = $("li[fg=1]").attr("row");
			// 向左移动
			if (parseInt(idx0) > parseInt(idx1)) {
				$(".fix-li").attr({
					"fg" : "0"
				});
				// 移动
				var row = $(this).prevAll("li").size();
				for ( var i = 0; i < row; i++) {
					if (flag === false) {
						$(".nav_list" + (i + 1)).css("left", 80 * i + "px");
						$("ul.clearfix", $(".nav_list" + (i + 1)).closest("ul")).hide();
						$("ul.clearfix", $(".nav_list" + (i + 1))).show();
					} else {
						$(".nav_list" + (i + 1)).stop().animate({
							left : 80 * i + "px"
						}, 1000, "", function() {
							$("ul.clearfix", $(".nav_list" + (i + 1)).closest("ul")).hide();
							
							$("ul.clearfix", $(".nav_list" + (i + 1))).show();
						});
					}
					
				}
				
				if (flag === false) {
					$(".nav_list" + (i + 1)).css("left", 80 * row + "px");
					$("ul.clearfix", $(_self).closest("ul")).hide();
					$("ul.clearfix", $(_self)).show();
					$(".nav_con_list").attr("lock", "0");
				} else {
					$(this).stop().animate({
						left : 80 * row + "px"
					}, 1000, "", function() {
						$("ul.clearfix", $(_self).closest("ul")).hide();
						
						$("ul.clearfix", $(_self)).show();
						// 解锁
						$(".nav_con_list").attr("lock", "0");
						
						linkUrl();// 打开新标签
					});
				}
				
				$(this).attr({
					"fg" : "1"
				});
			} else {
				// 向右移动
				if (parseInt(idx0) < parseInt(idx1)) {
					$(".fix-li").attr({
						"fg" : "0"
					});
					var row = $(this).nextAll("li").size(), ftt = $(".fix-li").size();
					var fts = ftt - row + 1;
					
					for ( var i = ftt; i > fts; i--) {
						
						if (flag === false) {
							$(".nav_list" + i).css("left", (mleft - (ftt - i) * 80) + "px");
							$("ul.clearfix", $(_self).closest("ul")).hide();
							$("ul.clearfix", $(_self)).show();
						} else {
							$(".nav_list" + i).stop().animate({
								left : (mleft - (ftt - i) * 80) + "px"
							}, 1000, function() {
								$("ul.clearfix", $(_self).closest("ul")).hide();
								
								$("ul.clearfix", $(_self)).show();
							});
						}
					}
					
					if (flag === false) {
						$(".nav_list" + fts).css("left", (mleft - (ftt - fts) * 80) + "px");
						$("ul.clearfix", $(_self).closest("ul")).hide();
						$("ul.clearfix", $(_self)).show();
						$(".nav_con_list").attr("lock", "0");
					} else {
						$(".nav_list" + fts).stop().animate({
							left : (mleft - (ftt - fts) * 80) + "px"
						}, 1000, function() {
							$("ul.clearfix", $(_self).closest("ul")).hide();
							
							$("ul.clearfix", $(_self)).show();
							// 解锁
							$(".nav_con_list").attr("lock", "0");
							
							linkUrl();// 打开新标签
						});
					}
					
					$(this).attr({
						"fg" : "1"
					});
				} else {
					// 不移动
					$("ul.clearfix", $(_self).closest("ul")).hide();
					$("ul.clearfix", $(_self)).show();
					// 解锁
					$(".nav_con_list").attr("lock", "0");
					
					if (flag !== false) {
						linkUrl();// 打开新标签
					}
				}
			}
		}
	});
	
	// 设置默认选中功能
	var def = [ "base", "loan", 'lb', "investment", "shopping", "payment" ];
	var cur = $("div[nav]");
	for ( var i = 0; i < def.length; i++) {
		if (def[i] == cur.attr("nav")) {
			$(".fix-li", $("#nav")).eq(i).trigger("click", false);
			break;
		}
	}
}
// 打开窗口
function linkUrl() {
	var url = $("a.nav_list_index").attr("link");
	if (url != "#") {
		window.open($("a.nav_list_index").attr("link"), "_self", "");
	}
}
/**
 * 模拟动态Tab效果
 */
function initTabMenu() {
	$(".ui-tab").each(function(i, s) {
		$(this).click(function() {
			$(".ui-content").stop();
			if ($("div.ui-content:visible").size() > 0) {
				$("div.ui-content:visible").slideUp("slow", function() {
					$(".content-" + i).slideDown(2000);
				});
			} else {
				$(".content-" + i).slideDown(1000);
				
				$(".ui-content-block").css({
					"height" : "320px"
				});
			}
			$($(".ui-tab").removeClass("ui-tab-current")[i]).addClass("ui-tab-current");
		});
	});
}
