/**
 * 判断选中密码的安全性等级 （弱 1，中 2，强 3） 判断方法：弱：只含有数字、小写字母、大写字母中的一种, 中：含有数字、小写字母、大写字母的两种
 * 强：含有数字、小写字母、大写字母
 * 
 * 2013.11.26
 */
var PWD_SECURITYLEVEL;
function showPasswordSecurityLevel(e) {
	var level = 0; // 默认level为 弱1 中2 强3 三个等级

	var password = $(e).val();

	var pattern_1 = /^.*([\W_])+.*$/i;
	var pattern_2 = /^.*([a-zA-Z])+.*$/i;
	var pattern_3 = /^.*([0-9])+.*$/i;
	var level = 0;
	if (password.length > 10) {
		level++;
	}
	if (pattern_1.test(password)) {
		level++;
	}
	if (pattern_2.test(password)) {
		level++;
	}
	if (pattern_3.test(password)) {
		level++;
	}
	if (level > 3) {
		level = 3;
	}
	return level;
	
		
}

function addClassABC(level,e){
	
	var password = $(e).val();
	if ($("span", $(e).parent()).size() == 0) {

		$(e).parent().append('<span id="pwdstrength" style="display: inline;"><b></b></span>');
	}
	var element = $("#pwdstrength", $(e).parent());
	if (password.length < 6 || password.length > 16) {
		element.hide();
		return 0;
	} else{
		switch (level) {
		case 1:
			element.removeClass().addClass("strengthA");
			element.show();
			break;
		case 2:
			element.removeClass().addClass("strengthB");
			element.show();
			break;
		case 3:
			element.removeClass().addClass("strengthC");
			element.show();
			break;
		default:
			break;
		}
		
	}
	
}

$(document).ready(function() {
	$("#pwd").keyup(function() {
		PWD_SECURITYLEVEL = showPasswordSecurityLevel($(this));
		addClassABC(PWD_SECURITYLEVEL,$(this));
	});
	

});
