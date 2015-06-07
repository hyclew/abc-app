$(document).ready(function() {
	new ComCheckBox("div[type='check']");
	
	
	$(".disap").on('focus', function() {
		$(".disap").removeClass("hover");
		$(this).addClass("hover");
	});

	//登陆名验证
	jQuery.validator.addMethod("isLoginName", function(value, element) {
		//var length = value.length;
		var name = /^([a-zA-Z][a-zA-Z0-9]+)$/;
		var mobile = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
		var email = /^([a-zA-Z0-9]+)+(\@[a-zA-Z0-9]+)+((\.[a-zA-Z0-9]+)+)$/;
		return this.optional(element) || name.test(value) || mobile.test(value) || email.test(value);

	}, "用户名/手机/邮箱 格式错误");
	
	//设置验证规则
	var opts = {
		rules : {
			username : {
				required : true,
				minlength : 2,
				isLoginName : true
			},
			password : {
				required : true,
				rangelength : [ 4, 16 ]
			}

		},
		messages : {
			username : {
				required : "用户名/手机/邮箱  不能为空",
				minlength : jQuery.format("请输入至少 {0} 个字符"),
				isLoginName : "用户名/手机/邮箱 格式错误"
			},
			password : {
				required : "密码不能为空",
				rangelength : jQuery.format("密码必须为{0}至{1}位字符")
			}

		},
		errorPlacement : function(error, element) {
				error.insertAfter($(element).parent());
		}

	};

	$("#loginForm").validate(opts);
	
	/* 添加大写锁定提示 */
	$(window).on("keydown", function(event){
		if(event.keyCode == 20) {
			var wornEl = $("#loginForm ul").find("li[class='login_worn']");
			if(wornEl.length == 1){
				wornEl.remove();
			} else {
				$("#loginForm ul li").first().before("<li class='login_worn'>大写键盘已经打开！</li>");
			}
		}
	});
});
var idforTimer;
var countDownStartWith=60;
$(function(){
	$(".get_password").click(function(){
		 clearInterval(idforTimer);
		 $('#code').val("");
		 $('#mobile').val("");
		 $("#sendCodeBtn").html("发送验证码");
		 $("#sendCodeBtn").addClass("hr_sendcode");
		 $("#sendCodeBtn").removeClass("hr_verify2");
		 $("#sendCodeBtn").addClass("hr_verify");
		 $('.codeError').html("");
		 $('.liContainer').remove();
		show_popup('.hr_findpassword','.shade','.cancel-btn,.icon_pop_close');
		});
	
	$(".hr_sendcode").click(function(){
		if($("#mobile").val()==null||$("#mobile").val()==""){
			return;
		}
		var mobileLength=$("#mobile").val().length;
		var mobileFormat = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
		if(!(mobileLength == 11 &&mobileFormat.test($("#mobile").val()))){
			return;
		}
		
		var continueExe=true;
		var mobileNO = $('#mobile').val();
		$.ajax({
			type : 'POST',
			url : 'login/checkHasMobile',
			data : {
				mobile : mobileNO
			},
			async:false,
			success:function(data){
				if(!data){
					continueExe=false;
				}
			}
		});
		if(!continueExe){
			return ;
		}
		if($("#sendCodeBtn").text() == "发送验证码"){//判断能不能点击“获取验证码”按钮
			sendPhoneAuthCode($("#sendCodeBtn"), "获取验证码", mobileNO, null, null);//发送验证码
		}
		/*if($("#time").length<1){
			$.ajax({
				type : 'POST',
				url : 'login/sendCode',
				data : {
					mobile : $('#mobile').val()
				},
				success:function(data){
					if(data){
						$("#sendCodeBtn").removeClass("hr_verify");
						$("#sendCodeBtn").addClass("hr_verify2");
						$("#sendCodeBtn").removeClass("hr_sendcode");
						$("#sendCodeBtn").html("<div id='time' style='float:left;padding-left:40px'>60</div>秒");
						countDownStartWith=60;
						idforTimer=setInterval("countdown()",1000);
					}
				}
			});
		}*/
	});		
	
	$("#findPwdBtn").click(function(){
		$.ajax({
			type : 'POST',
			url : 'login/findPwd',
			data : {
				code : $('#code').val(),
				mobile : $("#mobile").val()
			},
			success:function(data){
				if(data){
					$('.codeError').html("");
					$('.shade').remove();
					show_popup('.hr_resetpassword','.shade','.cancel-btn,.icon_pop_close');
					$(".hr_pop_confirmcode").hide();
				}else{
					$('.codeError').html("验证码错误");
				}
			}
		});
	});		
	
	$("#savePwdnLoginBtn").click(function(){
		$("#mobile2").val($("#mobile").val());
		var posturl = 'login/resetPwd';
		$('#resetPwdForm').attr('action', posturl);
		$('#resetPwdForm').submit();
	});
  });
function do_submit(){
	$('#loginForm').submit();
	return false;
}

function countdown(){
	
	countDownStartWith--;
	if(countDownStartWith<1){
		clearInterval(idforTimer);
		$("#sendCodeBtn").html("发送验证码");
		$("#sendCodeBtn").addClass("hr_sendcode");
		$("#sendCodeBtn").removeClass("hr_verify2");
		$("#sendCodeBtn").addClass("hr_verify");
	}
	document.getElementById("time").innerHTML=countDownStartWith;
	
}