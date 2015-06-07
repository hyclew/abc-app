/**
 *DATE : 2013.10.24
 *
 *自定义添加验证方法
 *
 **/
$(document).ready(function() {
	//手机号码验证
	if(jQuery.validator.methods["isPhoneNumber"] === undefined){
		jQuery.validator.addMethod("isPhoneNumber",function(value,element){
		    var length = value.length;
		    var mobile = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
		    return this.optional(element)||(length == 11 &&mobile.test(value));

		},"手机号码格式错误");
	}

	//身份证号码验证
	if(jQuery.validator.methods["isIDCardNumber"] === undefined){
		jQuery.validator.addMethod("isIDCardNumber",function(value,element){
		    return this.optional(element) || checkIdCardNo(value);

		},"请正确输入您的身份证号码");
	}
	 
	//用户名验证-只允许a-z，A-Z及数字
	if(jQuery.validator.methods["isUserName"] === undefined){
		jQuery.validator.addMethod("isUserName",function(value,element){
		     var userName = /^[0-9a-zA-Z]*$/;
		     return this.optional(element)||(userName.test(value));

		},"用户名只允许数字和字母");
	}
	
	//日期验证
	if(jQuery.validator.methods["isDate"] === undefined){
		jQuery.validator.addMethod("isDate",function(value,element){
			return ibank.isDate(value);
		},"请正确输入日期");
	}
});



