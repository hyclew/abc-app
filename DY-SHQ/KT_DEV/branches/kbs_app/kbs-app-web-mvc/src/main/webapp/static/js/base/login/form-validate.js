/**
 *实现表单的验证
 **/

$(document).ready(function() {
            //设置验证规则
            opts = {
                rules:{
                    pwd:{
                        required:true,
                        rangelength:[6,16]
                    },
                    pwdAgain:{
                        required:true,
                        rangelength:[6,16],
                        equalTo:"#pwd"
                    }
                },
                messages:{
                    pwd:{
                        required:"登陆密码不能为空",
                        rangelength:jQuery.format("密码必须为{0}至{1}位字符")
                    },
                    pwdAgain:{
                        required:"确认密码不能为空",
                        rangelength:jQuery.format("密码必须为{0}至{1}位字符"),
                        equalTo:"两次输入的密码不一致"
                    }
                },
                errorPlacement: function (error,element){
                		$("<li class='liContainer'></li>").insertAfter(element.parent());
                		error.appendTo(element.parent().next());
                },
                success:function(label){
                	label.parent().remove();
                }
            };
            
            $("#resetPwdForm").validate(opts);
            
            
            opts2 = {
                    rules:{
                    	mobile:{
                            required:true,
                            isPhoneNumber:true,
                            remote:"login/checkHasMobile"
                        }
                    },
                    messages:{
                    	mobile:{
                            required:"手机号不能为空",
                            remote:"该手机号从未被注册"
                        }
                    },
                    errorPlacement: function (error,element){
                    		$("<li class='liContainer2'></li>").insertAfter(element.parent());
                    		error.appendTo(element.parent().next());
                    },
                    success:function(label){
                    	label.parent().remove();
                    }
                };
                
                $("#inputMobileCodeForm").validate(opts2);
            
            
            
        });