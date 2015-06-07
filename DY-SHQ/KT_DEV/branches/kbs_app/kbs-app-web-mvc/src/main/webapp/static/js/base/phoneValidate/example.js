/**
 * 发送手机验证码的发起函数，在这里可以在发送手机验证码之前添加一些业务逻辑
 */
function sendPhoneAuthCodeCaller(){
	var mobileNo = $("#mobilePhone").val();
	var btn = $("#sendCodeBtn");
	
	/*=====以上是各个业务自已的的业务逻辑======*/
	
	if(btn.text() == "获取验证码"){
		//传递的五个参数依次是：获取验证码按钮对应的DOM节点；要显示在按钮上的文字；手机号码；倒计时函数；回调函数。后三个参数不存在的时候，用null填充。
		sendPhoneAuthCode(btn, "获取验证码", mobileNo, null, null);//发送验证码
	}
}