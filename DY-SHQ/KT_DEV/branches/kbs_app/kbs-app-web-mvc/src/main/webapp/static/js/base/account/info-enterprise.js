/**
 * 我的信息》》经营信息：点击修改控制
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
	$(".ui-enterprise_modify").bind("click", function() {
		var _self = $(this);
		// 页面校验
		agrValidate();
		// 显示按钮
		$(".ui-text", $(".info-container")).hide().next().show();
		// 提交绑定
		$("#submit").show().unbind("click").bind("click", function() {
			if(!$("#agrform").valid()){
				return;
			}
			$.ajax({
				url : $('#agrform').attr("action"),
				type : "POST",
				dataType : "json",
				contentType : 'application/x-www-form-urlencoded; charset=UTF-8',//
				data : $('#agrform').serialize(),
				success : function(data) {
					if ("success" == data.status) {
						alert("保存成功！");
						$(".ui-text", $(".info-container")).show().next().hide();
						// 标题信息
						$("#hr_exam_name").text(data.result.enterprise.chineseFullname);
						$("#hr_exam_info").text(Math.round(data.result.enterprise.infoProcess * 100) + '%');
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
	//登陆名验证
	jQuery.validator.addMethod("isLegalIdentNo", function(value, element){
		var identType = $("#corpIdentTypeSelect option:selected").attr("value");
		if(identType ==  "1"){
			return checkIdCardNo(value);
		}
		return true;
		}, "证件号码错误");
	
	var opts = {
		rules : {
			chineseFullname : {
				required : true,
				maxlength : 30
			},
			chineseName : {
				maxlength : 5
			},
			englishFullname : {
				maxlength : 100
			},
			englishName : {
				maxlength : 15
			},
			orgCode : {
				maxlength : 20
			},
			busiLicense : {
				maxlength : 20
			},
			corpName : {
				maxlength : 30
			},
			corpIdentNo : {
				maxlength : 20,
				isLegalIdentNo : true,
			},
			corpIdentMobile : {
				maxlength : 11
			}
		},
		messages : {
			chineseFullname : {
				required : "<font color='#FF0000'>“中文全称”不能为空</font>",
				maxlength : jQuery.format("<font color='#FF0000'>“中文全称”不能超过{0}个字符</font>")
			},
			chineseName : {
				maxlength : jQuery.format("<font color='#FF0000'>“中文简称”不能超过{0}个字符</font>")
			},
			englishFullname : {
				maxlength : jQuery.format("<font color='#FF0000'>“英文全称”不能超过{0}个字符</font>")
			},
			englishName : {
				maxlength : jQuery.format("<font color='#FF0000'>“英文简称”不能超过{0}个字符</font>")
			},
			orgCode : {
				maxlength : jQuery.format("<font color='#FF0000'>“组织机构代码”不能超过{0}个字符</font>")
			},
			busiLicense : {
				maxlength : jQuery.format("<font color='#FF0000'>“营业执照代码”不能超过{0}个字符</font>")
			},
			corpName : {
				maxlength : jQuery.format("<font color='#FF0000'>“企业法人代表名称”不能超过{0}个字符</font>")
			},
			corpIdentNo : {
				maxlength : jQuery.format("<font color='#FF0000'>“企业法人代表有效证件号码”不能超过{0}个字符</font>"),
				isLegalIdentNo : "证件号码错误"
			},
			corpIdentMobile : {
				maxlength : jQuery.format("<font color='#FF0000'>“企业法人代表手机号”不能超过{0}个字符</font>")
			}
		},
		errorPlacement : function(error, element) {
			error.appendTo(element.parent());
		}
	};
	$("#agrform").validate(opts);
}
