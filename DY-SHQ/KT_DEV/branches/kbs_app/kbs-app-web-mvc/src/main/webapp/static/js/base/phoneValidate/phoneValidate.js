/**
 * 发送手机验证码
 * @param btn：获取手机验证码按钮对应的dom节点
 * @param btnValue：显示在获取验证码按钮上文字，当倒计时的时候会显示：60秒,倒计时结束显示：{btnValue}
 * @param mobileNo手机号
 * @param countDownFunction：倒计时函数
 * @param callBackFunction：回调函数，组件会将手机验证码发送的结果传递给这个函数。
 */
function sendPhoneAuthCode(btn, btnValue, mobileNo, countDownFunction,callBackFunction){
	 if(mobileNo == null) mobileNo = "";//手机号码
	 if(callBackFunction == null) callBackFunction = defaultCallBack;//回调函数
	 if(countDownFunction == null) countDownFunction = defaultPhoneCodeCountDown;//倒计时函数
	 
	//给用户发送短信
	$.ajax({
	    url: ctx + '/phoneAuthCode/send?mobileNo=' + mobileNo,
	    type: 'POST',
	    dataType: 'json',
	    contentType : 'application/json',
	    timeout: 5000,
	    error: function(){
	        alert("手机验证码发送失败，请稍后再试！！");
	    },
	    success: function(data){
	    	countDownFunction(btn, 60, btnValue);//倒计时
	    	callBackFunction(data.result, btn);//回调函数
	    }
	});
}

/**
 * 默认的回调函数
 * @param dateResult：包含手机验证码发送的结果。{status:success}或者{status:failed}
 * @param btn
 */
function defaultCallBack(dateResult, btn){
//	alert("defaultStatus:\n"+dateResult.status);
}

/**
 * 倒计时函数
 * @param btn：获取验证码按钮对应的DOM节点
 * @param second//倒计时的秒数
 * @param btnValue//显示在获取验证码按钮上文字
 */
function defaultPhoneCodeCountDown(btn, second, btnValue){
	if(second > 0){
		if($(btn).get(0).tagName == 'INPUT'){
			btn.value = second+'秒';
		}else{
			$(btn).text(second+"秒");
		}
		setTimeout(function(){defaultPhoneCodeCountDown(btn, --second, btnValue);}, 1000);
	}else{
		if($(btn).get(0).tagName == 'INPUT'){
			btn.value = btnValue;
		}else{
			$(btn).text(btnValue);
		}
	}
}