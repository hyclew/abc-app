function testpass(password) {
	var score = 0;
	score += password.length * 4;
	score += (repeat(1, password).length - password.length) * 1;
	score += (repeat(2, password).length - password.length) * 1;
	score += (repeat(3, password).length - password.length) * 1;
	score += (repeat(4, password).length - password.length) * 1;
	if (password.match(/(.*[0-9].*[0-9].*[0-9])/)) {
		score += 5;
	}
	if (password.match(/(.*[!,@,#,$,%,^,&,*,?,_,~].*[!,@,#,$,%,^,&,*,?,_,~])/)) {
		score += 5;
	}
	if (password.match(/([a-z].*[A-Z])|([A-Z].*[a-z])/)) {
		score += 10;
	}
	if (password.match(/([a-zA-Z])/) && password.match(/([0-9])/)) {
		score += 15;
	}
	if (password.match(/([!,@,#,$,%,^,&,*,?,_,~])/)
			&& password.match(/([0-9])/)) {
		score += 15;
	}
	if (password.match(/([!,@,#,$,%,^,&,*,?,_,~])/)
			&& password.match(/([a-zA-Z])/)) {
		score += 15;
	}
	if (password.match(/^w+$/) || password.match(/^d+$/)) {
		score -= 10;
	}
	if (score < 0) {
		score = 0;
	}
	if (score > 100) {
		score = 100;
	}
	return score;

	function repeat(len, str) {
		var res = "";
		for ( var i = 0; i < str.length; i++) {
			var repeated = true;
			for ( var j = 0, max = str.length - i - len; j < len && j < max; j++) {
				repeated = repeated
						&& (str.charAt(j + i) == str.charAt(j + i + len));
			}
			if (j < len)
				repeated = false;
			if (repeated) {
				i += len - 1;
				repeated = false;
			} else {
				res += str.charAt(i);
			}
		}
		return res;
	}
}
function checkpass(pass) {
	var score = testpass(pass.value);
	if(score<34){
		document.getElementById("pwdLevel").value="1";
	}else if(score<68){
		document.getElementById("pwdLevel").value="2";
	}else{
		document.getElementById("pwdLevel").value="3";
	}
}