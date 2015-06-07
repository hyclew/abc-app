$(document).ready(function(){
	var c = $("#rebindingEmailForm").validate({
		rules:{
			email:{
				required: true,
				isNewEmail: true,
				remote:"checkEmailIsUnique"
			}
		},
		messages:{
			email:{
				required: "请输入新邮箱",
				remote:"该邮箱已经被使用"
			}
		}
	});
	
	$('#nextStep').on('click', function() {
		if($("#rebindingEmailForm").valid()){
			$("#rebindingEmailForm").submit();
		}
		
	});
});

jQuery.validator.addMethod("isNewEmail",function(value,element){
	var oldEmail = $("#oldEmail").text();
	if(value == oldEmail){
		return false;
	}else{
		return true;
	}
},"新邮箱不能和原有邮箱相同");