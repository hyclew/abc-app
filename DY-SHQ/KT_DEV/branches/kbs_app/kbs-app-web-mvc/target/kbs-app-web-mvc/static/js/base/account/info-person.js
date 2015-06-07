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
	
	// 工作省市字典翻译-特殊处理
	getWorkProvinceAndCity();

	// 操作按钮控制
	$(".ui-person_modify").bind("click", function() {
		var _self = $(this);
		// 显示按钮
		$(".ui-text", $(".info-container")).hide().next().show();
		// 提交绑定
		$("#submit").show().unbind("click").bind("click", function() {
			// 页面校验
			agrValidate();
			if(!$("#agrform").valid())
				return;
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
						$("#hr_exam_name").text(data.result.person.name);
						$("#hr_exam_info").text(Math.round(data.result.person.infoProcess * 100) + '%');
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
						setWorkProvinceAndCity();
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
		
		// 选择省份，请求相应的地级市
		$("#workProvince").change(function(){
			//省份下拉菜单的change事件
            var params = $(this).val();
            if (params == "请选择") {
            	$("#workCity").html("<option value=\"请选择\">请选择</option>");
            }else{
            	$.ajax({
    				url : "/ibank-web/base/area/cityList",
    				type : "POST",
    				dataType : "json",
    				contentType : 'application/x-www-form-urlencoded; charset=UTF-8',
    				data: {provinceCode: $("#workProvince").val()[0]},
    				success : function(cities) {
    					var cityOptions = "";
    					for(var i = 0; i < cities.result.length; i++){
    						cityOptions	+= "<option value=\"" + cities.result[i].areaCode +"\">" + cities.result[i].areaName + "</option>";
    					}
    					$("#workCity").html(cityOptions);
    				}
    			});
            }
		});
	});
});
function agrValidate() {
	//登陆名验证
	jQuery.validator.addMethod("isIdCardNo", function(value, element) {
		if(value == null || value == '')
			return true;
		return checkIdCardNo(value);

	}, "身份证号错误");
	var opts = {
		rules : {
			name : {
				maxlength : 30
			},
			identNo : {
				isIdCardNo : true
			},
			age : {
				required : true,
				digits : true,
				minlength : 1,
				maxlength : 3
			},
			urgentPerson : {
				maxlength : 30
			},
			urgentTel : {
				maxlength : 15
			},
			address : {
				maxlength : 30
			},
			company : {
				maxlength : 30
			},
			position : {
				maxlength : 15
			}
		},
		messages : {
			name : {
				maxlength : jQuery.format("不能超过{0}个字符")
			},
			identNo : {
				isIdCardNo : "身份证号错误"
			},
			age : {
				required : "请输入年龄",
				digits : "请输入数字",
				minlength : "请输入年龄",
				maxlength : jQuery.format("<font color='#FF0000'>不能超过{0}个字符</font>")
			},
			urgentPerson : {
				maxlength : jQuery.format("<font color='#FF0000'>不能超过{0}个字符</font>")
			},
			urgentTel : {
				maxlength : jQuery.format("<font color='#FF0000'>不能超过{0}个字符</font>")
			},
			address : {
				maxlength : jQuery.format("<font color='#FF0000'>不能超过{0}个字符</font>")
			},
			company : {
				maxlength : jQuery.format("<font color='#FF0000'>不能超过{0}个字符</font>")
			},
			position : {
				maxlength : jQuery.format("<font color='#FF0000'>不能超过{0}个字符</font>")
			}
		},
		errorPlacement : function(error, element) {
			error.appendTo(element.parent());
		}
	};
	$("#agrform").validate(opts);
}

// 工作省市字典翻译-特殊处理
function getWorkProvinceAndCity(){
	var value = $("#workProvinceAndCity").attr("val");
	$("#workProvinceAndCity").empty();
	$.each(value.split(","),function(i,e){
		var id = "";
		if(i == 0){
			id="#workProvince";
		}else{
			id="#workCity";
		}
		$("option", id).each(function(){
			if (e == $(this).val()) {
				$("#workProvinceAndCity").append($(this).text()+" ");
				// 选中
				$(this).attr("selected", "selected");
			}
		});
	});
}

function setWorkProvinceAndCity(){
	var province = $("option:selected", "#workProvince").text();
	var city = $("option:selected", "#workCity").text();
	$("#workProvinceAndCity").text(province + " " + city);
}