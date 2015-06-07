// 加密密码
function encryptPIN() {
	var key = RSAUtils.getKeyPair('23', '', '11');
	var decrypt = $keyboard.input.value;// 密码键盘输入的值
	var encrypt = RSAUtils.encryptedString(key, decrypt);

	return encrypt;
}
// 显示软键盘
function showSoftKeyPad(obj) {
	if (!obj || !obj.id) { // 必须有id值
		return;
	}
	$keyboard.show(obj);
}

function commit() {
 alert($("#key_input").val());
}
