$(document).ready(function() {
	//自定义验证规则  - 手机号码验证
	$.validator.addMethod("isPhoneNumber",function(value, element){
	    var length = value.length;
	    var mobile = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
	    return this.optional(element)||(length == 11 && mobile.test(value));
	}, "手机号码格式错误");
	
	var vopts = {
		ignore: "",//不忽略隐藏域
        rules : {
        	name : {
              required : true,
              maxlength : 15,
              minlength : 3
            },
            phoneNo : {
            	required : true,
            	isPhoneNumber : true
            },
            sex : {
            	required : true
            }, 
            inputDate : {
            	required : true,
            	isDate : true
            },
            checkboxname1 : {
            	required : true
            }
        },
		messages : {
			name : {
	          required : "用户名不能为空",
	          maxlength : jQuery.format("用户名必须小于{0}位字符"),
	          minlength : jQuery.format("用户名必须大于{0}位字符")
	        },
	        phoneNo : {
            	required : "手机号码不能为空"
            },
	        sex : {
	        	required : "性别不能为空"
	        },
	        inputDate : {
	        	required : "日期不能为空"
	        },
	        checkboxname1 : {
            	required : "多选不能为空"
            }
		},
		errorPlacement: function (error, element){
			//设置提示信息位置
			var name = element.attr("name"); 
			if(name == "sex" || name == "checkboxname1"){
				error.appendTo(element.parent().next());
			} else {
				error.appendTo(element.parent());
			}
        }
	};
	
	var validator =  $("#form1").validate(vopts);//注册验证规则到表单
	
	// 生成下拉
	var selt = new ComSelect({
		selector : ".js-select",
		validator : validator	//设置验证规则
	});
	
	// 生成多选
	var check = new ComCheckBox({
		selector : "span[type='check']",
		validator : validator	//设置验证规则
	});
	
	//日期控件
	$("input[name='inputDate']").datepicker({
		picker : "<img class='picker' align='middle' src='"
				+ ctx
				+ "/static/component/wdDatePicker/css/images/cal.gif' alt=''/>",
		validator : validator,
		listeners : {
			"change" : function(obj, val, ipt){
			}
		}
	});
	
	//点击按钮事件
	$("#submit").on("click", function(){
		if(validator.form()){
			$.ajax({
				url : ctx + "/example/validateform/save",
				type : "POST",
				contentType : "application/x-www-form-urlencoded",
				dataType : "json",
				data : $("#form1").serialize(),
				success : function(json) {
					if("success" == json.status){
						ibank.alert("保存成功！", "提示");
					} else {
						ibank.alert(json.result, "提示");
					}
				}
			});
		}
	});
	
});