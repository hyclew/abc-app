/**
 *实现表单的验证
 *
 *
 *
 *
 *
 **/

$(document).ready(function() {
            //自定义设置验证方法
            //身份证号码验证
           /* jQuery.validator.addMethod("isIDCardNumber",function(value,element){
                return this.optional(element) || isCardNoUtil.checkIdCardNo(value);

            },"请正确输入您的身份证号码");*/
            
            
            //设置验证规则
            opts = {
            	ignore: "",
                rules:{
                    userName:{
                      required:true,
                      maxlength:15,
                      isUserName:true,
                      remote:"checkUserName"
                    },
                    pwd:{
                        required:true,
                        rangelength:[6,16]
                    },
                    pwdAgain:{
                        required:true,
                        rangelength:[6,16],
                        equalTo:"#pwd"

                    },
                    mobile:{
                        required:true,
                        isPhoneNumber:true,
                        remote:"checkMobile"
                    },
                    mobileCode:{
                        required:true
                    },
                    agree:{
                        required:true
                    },
                    activateCode:{
                        required:true
                    },
                    orgCode:{
                        required:true
                    }
                },
                messages:{
                    userName:{
                      required:"用户名不能为空",
                      maxlength:jQuery.format("用户名必须小于{0}位字符"),
                      remote:"该用户名已经被注册"
                    },
                    pwd:{
                        required:"密码不能为空",
                        rangelength:jQuery.format("密码必须为{0}至{1}位字符")
                    },
                    pwdAgain:{
                        required:"重复密码不能为空",
                        rangelength:jQuery.format("密码必须为{0}至{1}位字符"),
                        equalTo:"两次输入的密码不一致"
                    },
                    mobile:{
                        required:"手机号不能为空",
                        remote:"该手机号已经被注册"
                       // isPhoneNumber:"您输入的手机号码格式不正确，请确认后重新输入"
                    },
                    mobileCode:{
                        required:"手机验证码不能为空"
                       // isPhoneNumber:"您输入的手机号码格式不正确，请确认后重新输入"
                    },
                    agree:{
                        required:"请同意服务协议"
                    },
                    activateCode:{
                        required:"激活码不能为空"
                    },
                    orgCode:{
                        required:"组织机构代码不能为空"
                    }

                },
                errorPlacement: function (error,element){
                	if(element.is("#userName")||element.is("#mobile")){
                		if(element.next().is("label")){
                			element.next().remove();
                		}
                		error.appendTo(element.parent());
                	}else{
                		error.appendTo(element.parent());
                	}
                }
                
            };
            
            $("#registerForm").validate(opts);
        });