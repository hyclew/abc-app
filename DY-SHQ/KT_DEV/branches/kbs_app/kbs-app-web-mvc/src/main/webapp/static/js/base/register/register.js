$(document).ready(function() {
	var v = $("#registerForm").validate();
	
	new ComCheckBox({
		selector : "div[type='check']",
		validate : v//验证表单时需要
	});
	//生成单选-验证码
	new ComRadios("span[type='radio']");
	
	$(".disap").on('focus', function() {
		$(".disap").removeClass("hover");
		$(this).addClass("hover");
	});
	
	
	$('#register').on('click', function() {
		var posturl = 'save';
		$('#registerForm').attr('action', posturl);
		var interest=0;
		$("li span em").each(function(i){
			if($(this).hasClass("current")){
				interest+=parseInt($(this).attr("ind"));
			}
		});
		if(interest==0){
			$("#interestError").attr("style","display:inline-block");
			return;
		}
		document.getElementById("interest").value=""+interest;
		document.getElementById("pwdLevel").value=""+PWD_SECURITYLEVEL;
		$('#registerForm').submit();
	});
	
	$('em').on('click', function() {
		if($(this).hasClass("current")){
			$(this).removeClass("current");
		}else{
			$(this).addClass("current");
		}
	});
	
	$(".activation-radio").on('click', function() {
		if($(this).attr("data")=="1"){
			$(".hide-activate").css("display","none");
			$("#activateCode").attr("disabled","disabled");
			$("#orgCode").attr("disabled","disabled");
		}else{
			$(".hide-activate").css("display","block");
			$("#activateCode").removeAttr("disabled");
			$("#orgCode").removeAttr("disabled");
		}
	});
	
	if($("#showCode").val()=="1"){
		$(".hide-activate").css("display","block");
		$("#activateCode").removeAttr("disabled");
		$("#orgCode").removeAttr("disabled");
		
		$("span.activation-radio:first").removeClass("com_radio_on");
		$("span.activation-radio:first").addClass("com_radio_off");
		$("span.activation-radio:last").removeClass("com_radio_off");
		$("span.activation-radio:last").addClass("com_radio_on");
	}
});
var idforTimer;
var countDownStartWith=60;
$(function(){
	$("#sendCodeBtn").click(function(){
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
			url : 'checkMobile',
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
		if($("#sendCodeBtn").text() == "获取验证码"){//判断能不能点击“获取验证码”按钮
			sendPhoneAuthCode($("#sendCodeBtn"), "获取验证码", mobileNO, null, null);//发送验证码
		}
	});
  });