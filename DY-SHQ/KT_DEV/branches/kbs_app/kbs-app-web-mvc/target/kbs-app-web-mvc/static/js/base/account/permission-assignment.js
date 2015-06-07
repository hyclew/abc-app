/**
 * 实现表单的验证
 * 
 */

$(document).ready(function() {
	new ComCheckBox("div[type='check']");
	$('#operatorSaveBtn').on('click', function() {
		var posturl = 'saveOperator';
		$('#addOperatorForm').attr('action', posturl);
		$('#addOperatorForm').submit();
	});
	$('#comfirmDeleteOperatorBtn').on('click', function() {
		$("#userNoToBeDelete").val();
		var posturl = 'permissionAssignment/deleteOperator';
		$('#deleteOperatorForm').attr('action', posturl);
		$('#deleteOperatorForm').submit();
	});

	
	// 设置验证规则
	opts = {

		rules : {
			name : {
				required : true,
				maxlength : 32
			},
			identNo : {
				required : true,
				isIDCardNumber : true
			},

			mobile : {
				required : true,
				isPhoneNumber : true,
				remote : "../../checkMobile"
			},
			email : {
				required : true,
				email : true,
				remote : "../../checkEmail"
			},
			pwd : {
				required : true,
				rangelength : [ 6, 16 ]
			}
		},
		messages : {
			name : {
				required : "姓名不能为空",
				maxlength : jQuery.format("用户名必须小于{0}位字符")
			},
			identNo : {
				required : "身份证号不能为空",
				isIDCardNumber : "身份证号错误，请重新填写"
			},
			mobile : {
				required : "手机号不能为空",
				remote : "该手机号已经被注册"
			// isPhoneNumber:"您输入的手机号码格式不正确，请确认后重新输入"
			},
			email : {
				required : "电子邮箱不能为空",
				email : "请输入正确有效的电子邮箱，例如“xx@xx.com”",
				remote : "该电子邮件已经被注册"
			},
			pwd : {
				required : "密码不能为空",
				rangelength : jQuery.format("密码必须为{0}至{1}位字符")
			}
		}
	};

	$("#addOperatorForm").validate(opts);
	
	new ComSelect({
		selector : ".js-select"
		
	});
	
	$("#delOperatorBtn").click(function(){
		if($("#pageIndex").val()=="1"){
			if($("#code").val()==null||$("#code").val()==""){
				$('.delete_success').text("请输入验证码");
				return;
			}
			//删除操作员
			var curname=$("#nameToDelSpan").text();
			$.ajax({
				type : 'POST',
				url : 'permissionAssignment/deleteOperator',
				data : {
					mobile : $("#mobileToDel").val(),
					code:$("#code").val()
				},
				success:function(data){
					if(data.length==5){
						//验证码错误
						$('.delete_success').text(data);
					}else{
						var content=data.substring(0,4)+curname+data.substring(4);
						$('.delete_success').text(content);
						if(data.substring(4)=="成功"){
							$("#pageIndex").val("2");
						}
					}
				}
			});
		}else{
			//删除成功后关闭对话框
			window.location.href=ctx + "/base/account/permissionAssignment";
		}
	});		
});

$(function() {
	var options = [ "@qq.com", "@163.com", "@126.com", "@yeah.net", "@189.com",
			"@sina.com", "@hotmail.com", "@21cn.com", "@yahoo.com",
			"@sohu.com", "@foxmail.com", "@outlook.com", "@gmail.com",
			"@abchina.com", "@live.com" ];

	$("#email").autocomplete({
		source : options
	});

	$("#email").keyup(function() {
		/* Act on the event */
		var new_options = [];
		for ( var i = 0; i < options.length; i++) {
			new_options[i] = $(this).val() + options[i];
		}
		$(this).autocomplete("option", "source", new_options);
	});
	
	$(".btndel").click(function(){
		//$("#userNoToBeDelete").val($(this).next().val());
		var name=$(this).parent().prev().prev().prev().text();
		$("#nameToDelSpan").text(name);
		$("#nameToDelSpan2").text(name);
		var curMobile=$(this).parent().prev().prev().prev().prev().prev().text();
		$("#mobileToDel").val(curMobile);
		show_popup('.popdel','.shade','.icon_pop_close,.hr_btn_aw');
	});	
	
	$(".cancel-btn").click(function(){
		hide_popup('.popdel','.shade');
	});	
	
	$("#showPwd").click(function(){
		if($("#pwd").attr("type")=="password"){
			$("#pwd").attr("type","text");
		}else{
			$("#pwd").attr("type","password");
		}
		
	});	
	

	$(".hr_sendcode").click(function(){
		if($("#mobileToDel").val()==null||$("#mobileToDel").val()==""){
			return;
		}
		var mobileNO = $("#mobileToDel").val();
		if($("#sendCodeBtn").text() == "获手机验证码"){
			sendPhoneAuthCode($("#sendCodeBtn"), "获手机验证码", mobileNO, null, null);//发送验证码
		}
	});		
});