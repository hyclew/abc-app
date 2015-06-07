/**
 * 我的信息》》基本信息：点击修改控制
 */
$(document).ready(function() {
	// 字典翻译
	$(".ui-select", $(".info-container")).each(function() {
		var _self = $(this);
		var value = $(".ui-text", $(_self).closest("li")).attr("val");
		$("option", $(_self)).each(function() {
			if (value == $(this).val()) {
				$(".ui-text", $(_self).closest("li")).text($(this).text());
				// 选中
				$(this).attr("selected", "selected");
			}
		});
	});
	// 操作按钮控制
	$(".ui-person_modify").bind("click", function() {
		var _self = $(this);
		// 页面校验
		// agrValidate();
		// 显示按钮
		$(".ui-text", $(".info-container")).hide().next().show();
		// 提交绑定
		$("#submit").show().unbind("click").bind("click", function() {
			$.ajax({
				url : $('#agrform').attr("action"),
				type : "POST",
				dataType : "json",
				contentType : 'application/x-www-form-urlencoded; charset=UTF-8',//
				data : $('#agrform').serialize(),// {name:"tomcat",code:"1"},
				success : function(data) {
					if ("success" == data.status) {
						alert("保存成功！");

						$(".ui-text", $(".info-container")).show().next().hide();
						// 处理数据,主要对input，select
						var val = "";
						$(".ui-input,.ui-select", $(".info-container")).each(function() {
							if ($(this).hasClass("ui-input")) {
								val = $(this).val();
							} else {
								val = $("option:selected", $(this)).text();
							}
							$(".ui-text", $(this).closest("li")).text(val);
						});
						$(".ui-btn").hide();
						// 显示修改
						$(_self).show();
					} else {
						alert("保存失败！");
					}
				}
			});
		});
		// 取消绑定
		$("#cancel").show().bind("click", function() {
			$(".ui-text", $(".info-container")).show().next().hide();

			$(".ui-btn").hide();
			// 显示修改
			$(_self).show();
		});

		$(_self).hide();
	});
});
function agrValidate() {
	var opts = {
		rules : {
			name : {
				required : true,
				maxlength : 32
			}
		},
		messages : {
			name : {
				required : "<br/><font color='#FF0000'>姓名不能为空</font>",
				maxlength : jQuery.format("<br/><font color='#FF0000'>不能超过{0} 个字符</font>")
			}
		},
		errorPlacement : function(error, element) {
			error.appendTo(element.parent());
		}
	};
	$("#agrform").validate(opts);
}