/**
 * @class 公共类,建议只放一些工具类的方法,不要把前端业务逻辑写在这里 2013.11.26
 */
ibank = {};

/**
 * 返回顶部函数
 * 
 */
ibank.gotoTop = function() {
	
	var obj = document.getElementById("goTopBtn");
	function getScrollTop() {
		return document.documentElement.scrollTop || document.body.scrollTop;
	}
	function setScrollTop(value) {
		if (document.documentElement.scrollTop) {
			document.documentElement.scrollTop = value;
		} else {
			document.body.scrollTop = value;
		}
	}
	window.onscroll = function() {
		getScrollTop() > 1000 ? obj.style.display = "" : obj.style.display = "none";
	};
	
	// getScrollTop()>500 距离顶部500px 时候显示返回顶部按钮。自己设置哦
	obj.onclick = function() {
		var goTop = setInterval(scrollMove, 10);
		function scrollMove() {
			setScrollTop(getScrollTop() / 1.1);
			if (getScrollTop() < 1) {
				clearInterval(goTop);
			}
		}
	}
};

/** ***数字处理方法--开始************ */
/**
 * 数字转化十进制格式
 * 
 * @sample ibank.NumberToDecimal("12002");
 * @result 12,002
 */

ibank.NumberToDecimal = function(num) {
	if (/^.*\..*$/.test(num)) {
		var pointIndex = num.lastIndexOf(".");
		var intPart = num.substring(0, pointIndex);
		var pointPart = num.substring(pointIndex + 1, num.length);
		intPart = intPart + "";
		var re = /(-?\d+)(\d{3})/;
		while (re.test(intPart)) {
			intPart = intPart.replace(re, "$1,$2");
		}
		num = intPart + "." + pointPart;
	} else {
		num = num + "";
		var re = /(-?\d+)(\d{3})/;
		while (re.test(num)) {
			num = num.replace(re, "$1,$2");
		}
	}
	return num;
};

ibank.formatNumber = function(obj) {
	if (obj.value != "") {
		// add 0 pre .
		if (obj.value.indexOf(".") == 0) {
			obj.value = "0" + obj.value;
		}
		// remove 0 after .
		if (obj.value.match(/\.[0-9]*[0]+/)) {
			
			obj.value = obj.value.replace(/[0]+$/, "");
			if (obj.value.lastIndexOf(".") == obj.value.length - 1) {
				obj.value = obj.value.replace(/\.$/, "");
			}
		}
		// remove 0 pre when interger
		if (obj.value.indexOf(".") < 0 && obj.value.match(/^[0]+/)) {
			obj.value = obj.value.replace(/^[0]+/, "");
			if (obj.value == "") {
				obj.value = 0;
			}
		}
		// remove last .
		if (obj.value.lastIndexOf(".") == obj.value.length - 1) {
			obj.value = obj.value.replace(/\.$/, "");
		}
		// remove chinese
		obj.value = obj.value.replace(/[\u4e00-\u9fa5]/g, "");
		obj.value = obj.value.replace(/[\u3002\uff1b\uff0c\uff1a\u201c\u201d\uff08\uff09\u3001\uff1f\u300a\u300b]/g, "");
		// remove char
		obj.value = obj.value.replace(/[a-zA-Z]*/g, "");
		
		// clean ,
		obj.value = obj.value.replace(/,/g, "");
		if (obj.value == ".") {
			obj.value = "";
		}
		// format xx,xxx,xxx
		obj.value = ibank.NumberToDecimal(obj.value);
		
	}
	
};
/**
 * 是否是整数
 */
ibank.isInt = function(str) {
	var regex = /^\d*$/;
	if (regex.test(str)) {
		return true;
	} else {
		return false;
	}
};
ibank.isNotInt = function(str) {
	return !ibank.isInt(str);
};
/**
 * 浮点数(小数点后两位)
 * 
 * @param str
 * @returns {Boolean}
 */
ibank.isFloat = function(str) {
	var regex = /^(-|\+)?\d+(\.\d+)?$/;
	if (regex.test(str)) {
		return true;
	} else {
		return false;
	}
};
ibank.isNotFloat = function(str) {
	return !ibank.isFloat(str);
};

ibank.floatFormat = function(s) {
	if (ibank.isNull(s)) {
		return "";
	}
	
	s = parseFloat((s + "").replace(/[^\d\.-]/g, "")).toFixed(2) + "";
	
	var lt = s.split(".")[0].split("").reverse();
	var lk = s.split(".")[1];
	var tk = "";
	for ( var i = 0; i < lt.length; i++) {
		tk += lt[i] + ((i + 1) % 3 == 0 && (i + 1) != lt.length ? "," : "");
	}
	tk = tk.split("").reverse().join("") + "." + lk;
	
	tk = ibank.strReplaceAll(tk + "", ",", "");
	
	return tk;
};
/**
 * 利用正则表达式进行全局替换
 * 
 * @param str
 * @param sp
 * @param tp
 * @returns
 */
ibank.strReplaceAll = function(strExps, regExp, tp) {
	strExps = strExps + "";
	if (ibank.isNotNull(strExps)) {
		strExps = strExps.replace(eval("/" + regExp + "/g"), tp);
	} else {
		strExps = "";
	}
	return strExps;
};

/** ***数字处理方法--结束************ */

/** ***Cookie 操作系列方法----开始********** */
/**
 * 获取cookie信息
 * 
 * @param name
 * @returns cookie的value值
 */
ibank.getCookie = function(name) {
	var start = document.cookie.indexOf(name + "=");
	var len = start + name.length + 1;
	if ((!start) && (name != document.cookie.substring(0, name.length))) {
		return null;
	}
	if (start == -1) {
		return null;
	}
	var end = document.cookie.indexOf(';', len);
	if (end == -1) {
		end = document.cookie.length;
	}
	return unescape(document.cookie.substring(len, end));
};

/**
 * cookie存放信息，前两个参数name和value为必填
 * 
 * @param name
 *            名称
 * @param value
 *            cookie的值
 * @param expires
 *            时效
 * @param path
 *            路径
 * @param domain
 * @param secure
 */
ibank.setCookie = function(name, value, expires, path, domain, secure) {
	var today = new Date();
	today.setTime(today.getTime());
	if (expires) {
		expires = expires * 1000 * 60 * 60 * 24;
	}
	var expires_date = new Date(today.getTime() + (expires));
	document.cookie = name + '=' + escape(value) + ((expires) ? ';expires=' + expires_date.toGMTString() : '') + // expires.toGMTString()
	((path) ? ';path=' + path : '') + ((domain) ? ';domain=' + domain : '') + ((secure) ? ';secure' : '');
};

/**
 * 根据名称删除cookie信息，第一个参数name必填
 */
ibank.deleteCookie = function(name, path, domain) {
	if (this.getCookie(name)) {
		document.cookie = name + '=' + ((path) ? ';path=' + path : '') + ((domain) ? ';domain=' + domain : '') + ';expires=Thu, 01-Jan-1970 00:00:01 GMT';
	}
};

/** ***Cookie 操作系列方法----结束********** */

/** ***json 操作系列方法----开始********** */
/**
 * String to Object
 * 
 * @param {}
 *            jsonStr
 * @return {}
 */
ibank.toJSON = function(jsonStr) {
	if (jsonStr == null) {
		return null;
	}
	return eval("(" + jsonStr + ")");
};

/**
 * object to string
 * 
 * @param {}
 *            jsonObj
 * @return {}
 */
ibank.fromJSON = function(jsonObj) {
	return ibank.stringify(jsonObj);
};
/**
 * 转换
 * 
 * @param value
 * @param replacer
 * @param space
 * @returns
 */
ibank.stringify = function(value, replacer, space) {
	var i;
	gap = '';
	indent = '';
	if (typeof space === 'number') {
		for (i = 0; i < space; i += 1) {
			indent += ' ';
		}
	} else if (typeof space === 'string') {
		indent = space;
	}
	rep = replacer;
	if (replacer && typeof replacer !== 'function' && (typeof replacer !== 'object' || typeof replacer.length !== 'number')) {
		throw new Error('JSON2.stringify');
	}
	return str('', {
		'' : value
	});
	function quote(string) {
		var cx = /[\u0000\u00ad\u0600-\u0604\u070f\u17b4\u17b5\u200c-\u200f\u2028-\u202f\u2060-\u206f\ufeff\ufff0-\uffff]/g, escapable = /[\\\"\x00-\x1f\x7f-\x9f\u00ad\u0600-\u0604\u070f\u17b4\u17b5\u200c-\u200f\u2028-\u202f\u2060-\u206f\ufeff\ufff0-\uffff]/g, gap, indent, meta = { // table
			// of
			// substitutions
			'\b' : '\\b',
			'\t' : '\\t',
			'\n' : '\\n',
			'\f' : '\\f',
			'\r' : '\\r',
			'"' : '\\"',
			'\\' : '\\\\'
		}, rep;
		escapable.lastIndex = 0;
		return escapable.test(string) ? '"' + string.replace(escapable, function(a) {
			var c = meta[a];
			return typeof c === 'string' ? c : '\\u' + ('0000' + a.charCodeAt(0).toString(16)).slice(-4);
		}) + '"' : '"' + string + '"';
	}
	function str(key, holder) {
		var i, // The loop counter.
		k, // The member key.
		v, // The member value.
		length, mind = gap, partial, value = holder[key];
		if (value && typeof value === 'object' && typeof value.toJSON === 'function') {
			value = value.toJSON(key);
		}
		if (typeof rep === 'function') {
			value = rep.call(holder, key, value);
		}
		switch (typeof value) {
		case 'string':
			return quote(value);
		case 'number':
			return isFinite(value) ? String(value) : 'null';
		case 'boolean':
		case 'null':
			return String(value);
		case 'object':
			if (!value) {
				return 'null';
			}
			gap += indent;
			partial = [];
			if (Object.prototype.toString.apply(value) === '[object Array]') {
				length = value.length;
				for (i = 0; i < length; i += 1) {
					partial[i] = str(i, value) || 'null';
				}
				v = partial.length === 0 ? '[]' : gap ? '[\n' + gap + partial.join(',\n' + gap) + '\n' + mind + ']' : '[' + partial.join(',') + ']';
				gap = mind;
				return v;
			}
			if (rep && typeof rep === 'object') {
				length = rep.length;
				for (i = 0; i < length; i += 1) {
					k = rep[i];
					if (typeof k === 'string') {
						v = str(k, value);
						if (v) {
							partial.push(quote(k) + (gap ? ': ' : ':') + v);
						}
					}
				}
			} else {
				for (k in value) {
					if (Object.hasOwnProperty.call(value, k)) {
						v = str(k, value);
						if (v) {
							partial.push(quote(k) + (gap ? ': ' : ':') + v);
						}
					}
				}
			}
			v = partial.length === 0 ? '{}' : gap ? '{\n' + gap + partial.join(',\n' + gap) + '\n' + mind + '}' : '{' + partial.join(',') + '}';
			gap = mind;
			return v;
		}
	}
};

/** ***json 操作系列方法----结束********** */

/** ****日期 操作系列方法----开始******** */
/**
 * 输入两个日期串（YYYY-MM-DD）,返回两个日期相差几天 @ sample
 * ibank.fetchDateSegMent("2013-04-28","2014-04-30"); @ result 367
 */
ibank.fetchDateSegMent = function(a, b) {
	
	if (a == "" || b == "") {
		return 0;
	} else {
		var a1 = a.substring(0, 4);
		var a2 = a.substring(5, 7);
		var a3 = a.substring(8, 10);
		var b1 = b.substring(0, 4);
		var b2 = b.substring(5, 7);
		var b3 = b.substring(8, 10);
		/* 把日期格式更新为：MM/DD/YYYY 即月/日/年 */
		var dt1 = a2 + "/" + a3 + "/" + a1;
		var dt2 = b2 + "/" + b3 + "/" + b1;
		
		var dateObj1 = new Date(dt1);
		var dateObj2 = new Date(dt2);
		return (dateObj2 - dateObj1) / (24 * 3600 * 1000);
	}
};

/**
 * 短时间，形如 (13:04:06)
 */
ibank.isTime = function(str) {
	var a = str.match(/^(\d{1,2})(:)?(\d{1,2})\2(\d{1,2})$/);
	if (a == null) {
		return false;
	}
	if (a[1] > 24 || a[3] > 60 || a[4] > 60) {
		return false;
	}
	return true;
};
ibank.isNotTime = function(str) {
	return !ibank.isTime(str);
};
/**
 * 短日期，形如 (2003-12-05)
 * 
 * @param str
 * @returns {Boolean}
 */
ibank.isDate = function(str) {
	var r = str.match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/);
	if (r == null) {
		return false;
	}
	var d = new Date(r[1], r[3] - 1, r[4]);
	return (d.getFullYear() == r[1] && (d.getMonth() + 1) == r[3] && d.getDate() == r[4]);
};
ibank.isNotDate = function(str) {
	return !ibank.isDate(str);
};
/**
 * 长时间，形如 (2003-12-05 13:04:06)
 * 
 * @param str
 * @returns {Boolean}
 */
ibank.isDateTime = function(str) {
	var reg = /^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2}) (\d{1,2}):(\d{1,2}):(\d{1,2})$/;
	var r = str.match(reg);
	if (r == null) {
		return false;
	}
	var d = new Date(r[1], r[3] - 1, r[4], r[5], r[6], r[7]);
	return (d.getFullYear() == r[1] && (d.getMonth() + 1) == r[3] && d.getDate() == r[4] && d.getHours() == r[5] && d.getMinutes() == r[6] && d.getSeconds() == r[7]);
};
ibank.isNotDateTime = function(str) {
	return !ibank.isDateTime(str);
};

/**
 * 获取当前年月日，格式例如：2013-11-26
 */
ibank.getCurrentDate = function() {
	var dateObj = new Date();
	
	var nt = dateObj.getFullYear();// 年
	var mt = dateObj.getMonth() + 1;// 月
	var xt = dateObj.getDate();// 日
	
	return nt + "-" + (mt < 10 ? "0" : "") + mt + "-" + (xt < 10 ? "0" : "") + xt;
};
/**
 * 获取当前年月，格式例如：2013-11
 */
ibank.getDateExt = function() {
	var dateObj = new Date();
	
	var nt = dateObj.getFullYear();// 年
	var mt = dateObj.getMonth() + 1;// 月
	
	return nt + "-" + (mt < 10 ? "0" : "") + mt;
};
/**
 * 获取当前年，格式例如：2013
 */
ibank.getYearExt = function() {
	return (new Date()).getFullYear();// 年
};

/** ****日期 操作系列方法----结束******** */

/** ****字符串 操作系列方法---开始********* */
/**
 * 处理字符串 ，为空时使用默认值
 */
ibank.cgNull = function(str, ds) {
	
	if (ibank.isNull(str)) {
		return ds;
	} else {
		return str;
	}
};
/**
 * 检查是否为空
 * 
 * @param str
 * @returns {Boolean}
 */
ibank.isNull = function(str) {
	str = $.trim(str);
	if (NaN == str || str == undefined || str == "undefined" || str == null || str.length == 0 || str == "null" || "--" == str) {
		return true;
	} else {
		var ft = /^\s*$/; // 半角正则
		
		if (ft.test(str)) {
			return true;
		}
		var st = /[\u3000]/g; // 全角正则
		
		if (st.test(str)) {
			return true;
		}
		
		return false;
	}
};
ibank.isNotNull = function(str) {
	return !ibank.isNull(str);
};

/** *******字符串 操作系列方法---结束********* */

/**
 * 提示框，类似于window.alert。
 * 
 * @param msg
 * 提示信息 @ date 2013.11.25 @ sample " ibank.alert("abchina!!")"
 */
ibank.alert = function(msg, title, callback) {
	
	var content = "<div id=\"jQueryAlertDialogId\" class=\"pop \" style=\"width: 450px; margin: 0px auto; position: fixed; z-index: 10; display: block; left: 566.5px; top: 225px;\">" + "<h3 class=\"pop_h3\"><a class=\"icon_pop_close\" href=\"#\"></a><span class=\"ui-alert-title\">" + (title || "提示") + "</span></h3>" + "<div>" + "<span id=\"alertContentId\" style=\"height:50px;line-height:50px;font-size:20px;\" class=\"ui-alert-content\"></span>" + "</div>" + "<div class=\"btn-box\">" + "<a  class=\"btn pop_alert_ok\" href=\"#\">确定</a>" + "</div>" + "</div>";
	if ($("#jQueryAlertDialogId").size() == 0) {
		$(document.body).append(content);
	} else {
		$(".ui-alert-title", $("#jQueryAlertDialogId")).html(title || "提示");
	}
	
	$(".ui-alert-content", $("#jQueryAlertDialogId")).html("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + msg);
	
	var dw = $(window).width(), dy = $(window).height(), w = $("#jQueryAlertDialogId").width(), y = $("#jQueryAlertDialogId").height(), bh = $('body').height();
	
	$('<div/>').prependTo('body').addClass('shade').fadeIn(300).css('height', bh - dy > 0 ? bh : dy + 'px');
	$("#jQueryAlertDialogId").is(':visible') ? $("#jQueryAlertDialogId").hide() : $("#jQueryAlertDialogId").show();
	$("#jQueryAlertDialogId").show().css({
		'left' : (dw / 2 - w / 2) + 'px',
		'top' : (dy / 2 - y / 2) + 'px'
	});
	$(".pop_alert_ok", $("#jQueryAlertDialogId")).focus();
	
	$(".pop_alert_ok", $("#jQueryAlertDialogId")).unbind().bind("click", function() {
		$(".shade").remove();
		$("#jQueryAlertDialogId").hide();
		
		$(".ui-alert-title,.ui-alert-content", $("#jQueryAlertDialogId")).html("");
		if (callback) {
			callback.call();
		}
	});
	
	$(".icon_pop_close", $("#jQueryAlertDialogId")).unbind().bind("click", function() {
		$(".shade").remove();
		$("#jQueryAlertDialogId").hide();
		
		$(".ui-alert-title,.ui-alert-content", $("#jQueryAlertDialogId")).html("");
		if (callback) {
			callback.call();
		}
	});
	
};

/**
 * 确定框，类似于window.confirm。
 * 
 * @param msg
 *            提示信息
 * @param callback
 * 回调函数 @ date 2013.11.25 @ sample ibank.confirm("确定","are you sure?",call);
 * 
 */
ibank.confirm = function(msg, title, callback) {
	
	var content = "<div id=\"jQueryConfirmDialogId\" class=\"pop \" style=\"width: 450px; margin: 0px auto; position: fixed; z-index: 10; display: block; left: 566.5px; top: 225px;\">" + "<h3 class=\"pop_h3\"><a class=\"icon_pop_close\" href=\"#\"></a><span class=\"ui-confirm-title\">" + (title || "确认") + "</span></h3>" + "<div>" + "<span id=\"confirmContentId\" style=\"height:50px;line-height:50px;font-size:20px;\" class=\"ui-confirm-content\"></span>" + "</div>" + "<div class=\"btn-box\">" + "<a  class=\"btn pop_confirm_ok\" href=\"#\">确定</a>" + "&nbsp;&nbsp;&nbsp;&nbsp;" + "<a  class=\"btn pop_confirm_cancel\" href=\"#\">取消</a>" + "</div>" + "</div>";
	if ($("#jQueryConfirmDialogId").size() == 0) {
		$(document.body).append(content);
	} else {
		$(".ui-confirm-title", $("#jQueryConfirmDialogId")).html(title || "确认");
	}
	// 处理对话框
	var _self = $("#jQueryConfirmDialogId");
	
	$(".ui-confirm-content", $(_self)).html("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + msg);
	
	var dw = $(window).width(), dy = $(window).height(), w = $(_self).width(), y = $(_self).height(), bh = $('body').height();
	
	$('<div/>').prependTo('body').addClass('shade').fadeIn(300).css('height', bh - dy > 0 ? bh : dy + 'px');
	$(_self).is(':visible') ? $(_self).hide() : $(_self).show();
	$(_self).show().css({
		'left' : (dw / 2 - w / 2) + 'px',
		'top' : (dy / 2 - y / 2) + 'px'
	});
	
	$(".pop_confirm_cancel,.icon_pop_close", $(_self)).unbind().bind("click", function() {
		$(_self).hide();
		
		$(".shade").remove();
		
		$(".ui-confirm-title,.ui-confirm-content", $(_self)).html("");
		
		return false;
	});
	// 确定、取消按键样式切换
	$(".pop_confirm_ok", $(_self)).focus();
	$(".pop_confirm_ok", $(_self)).addClass("w-btn1_hover");
	
	$(".pop_confirm_ok", $(_self)).mouseenter(function() {
		$(".pop_confirm_ok", $(_self)).addClass("w-btn1_hover");
	});
	$(".pop_confirm_ok", $(_self)).mouseout(function() {
		$(".pop_confirm_ok", $(_self)).removeClass("w-btn1_hover");
	});
	
	$(".pop_confirm_cancel", $(_self)).mouseenter(function() {
		$(".pop_confirm_ok", $(_self)).removeClass("w-btn1_hover");
	});
	// 增加键盘事件Tab
	$(window).keydown(function(event) {
		if (event.keyCode == 9) {
			if ($(".pop_confirm_ok", $(_self)).hasClass("w-btn1_hover")) {
				$(".pop_confirm_ok", $(_self)).removeClass("w-btn1_hover");
				$(".pop_confirm_cancel", $(_self)).addClass("w-btn1_hover");
				
			} else {
				$(".pop_confirm_ok", $(_self)).addClass("w-btn1_hover");
				$(".pop_confirm_cancel", $(_self)).removeClass("w-btn1_hover");
			}
		}
		;
	});
	$(".pop_confirm_ok", $(_self)).unbind().bind("click", function() {
		$(_self).hide();
		
		$(".shade").remove();
		
		$(".ui-confirm-title,.ui-confirm-content", $(_self)).html("");
		
		if (callback) {
			callback.call();
		}
		return true;
	});
	
};
/**
 * 打开对话框
 * 
 * @param divId
 * @param title
 *            标题
 * @param width
 *            宽度
 * @param btns
 *            按钮数
 * @param btnName1
 *            第一个按钮名称，为空时，默认为“保存”
 * @param btnCallback1，第一个按钮事件，为空时，默认不调用
 * @param btnName2
 *            第二个按钮名称，为空时，默认为“取消”
 * @param btnCallback2
 *            第二个按钮事件，为空时，默认不调用
 */
ibank.openDialog = function(divId, title, width, btns, btnName1, btnCallback1, btnName2, btnCallback2) {
	var btn1 = btnName1 || "保存";
	var btn2 = btnName2 || "取消";
	var html = "";
	
	var temp = "";
	if ("1" == btns) {
		temp = "<a class=\"btn pop_dialog_ok\" href=\"#\">" + btn1 + "</a>";
	} else {
		temp = "<a class=\"btn pop_dialog_ok\" href=\"#\">" + btn1 + "</a>&nbsp;&nbsp;&nbsp;&nbsp;<a  class=\"btn pop_dialog_cancel\" href=\"#\">" + btn2 + "</a>";
	}
	html = "<div id=\"jQueryOpenDialogId\" class=\"pop\" style=\"width: " + (width || 350) + "px; margin: 0px auto; position: fixed; z-index: 10; display: block; left: 566.5px; top: 225px;\">" + "<h3 class=\"pop_h3\"><a class=\"icon_pop_close\" href=\"#\"></a><span class=\"ui-dialog-title\">" + (title || "确认") + "</span></h3>" + "<div><div class=\"ui-dialog-content\" style=\"align:center;margin:10px 10px 10px 10px;\"></div></div>" + "<div class=\"btn-box\">" + temp + "</div>" + "</div>";
	
	if ($("#jQueryOpenDialogId").size() == 0) {
		$(document.body).append(html);
	} else {
		$(".ui-dialog-title", $("#jQueryOpenDialogId")).html(title || "确认");
	}
	// 处理对话框
	var _self = $("#jQueryOpenDialogId");
	
	$(".ui-dialog-content", $(_self)).html($("#" + divId).html());
	
	var dw = $(window).width(), dy = $(window).height(), w = $(_self).width(), y = $(_self).height(), bh = $('body').height();
	
	$('<div/>').prependTo('body').addClass('shade').fadeIn(300).css('height', bh - dy > 0 ? bh : dy + 'px');
	$(_self).is(':visible') ? $(_self).hide() : $(_self).show();
	$(_self).show().css({
		'left' : (dw / 2 - w / 2) + 'px',
		'top' : (dy / 2 - y / 2) + 'px'
	});
	// 按钮绑定
	$(".icon_pop_close", $(_self)).unbind().bind("click", function() {
		$(_self).hide();
		
		$(".shade").remove();
		
		$(".ui-dialog-title,.ui-dialog-content", $(_self)).html("");
	});
	
	$(".pop_dialog_ok", $(_self)).unbind().bind("click", function() {
		$(_self).hide();
		
		$(".shade").remove();
		
		$(".ui-dialog-title,.ui-dialog-content", $(_self)).html("");
		
		if (btnCallback1) {
			btnCallback1.call();
		}
	});
	$(".pop_dialog_cancel", $(_self)).unbind().bind("click", function() {
		$(_self).hide();
		
		$(".shade").remove();
		
		$(".ui-dialog-title,.ui-dialog-content", $(_self)).html("");
		
		if (btnCallback2) {
			btnCallback2.call();
		}
	});
};

/**
 * 浮动层,显示、隐藏
 * 
 * @param compment
 *            jQuery 对象
 * @param msg
 *            提示信息
 * @param position
 *            位置：0为上，1为下，2为右，默认为右
 * 
 * sample ibank.showTip($("#id"),"提示：“用户名”为必输项！"，"2");
 * 
 * 
 * 
 */
ibank.showTip = function(compment, msg, position) {
	var p = "", s = "";
	if (position) {
		s = position;
	} else {
		s = "2";
	}
	switch (s) {
	case "0":
		p = "5-7";// 上
		break;
	case "1":
		p = "7-5";// 下
		break;
	case "2":
		p = "6-8";// 右
		break;
	default:
		p = "6-8";
		break;
	}
	compment.powerFloat({
		eventType : null,
		targetMode : "remind",
		target : msg,
		position : p
	});
};
/**
 * 隐藏提示层
 */
ibank.hideTip = function() {
	$.powerFloat.hide();
};
/**
 * 操作提交
 * 
 * @param msg
 */
ibank.showMsg = function(msg) {
	if (!$("#targetFixed").size() > 0) {
		$("<span id='targetFixed' class='target-fixed'></span>").prependTo($("body"));
	}
	if (!window.XMLHttpReqest) {
		$("#targetFixed").css("top", $(document).scrollTop + 2);
	}
	if (!$("#overlay").size() > 0) {
		$("<div id='overlay'></div>").prependTo($("body"));
		$("#overlay").css({
			"position" : "absolute",
			"background-color" : "#000000",
			"opacity" : 0.2,
			"left" : "0px;",
			"top" : "0px",
			"z-index" : 9999
		}).height($(document).height());
	}
	$("#targetFixed").powerFloat({
		eventType : null,
		targetMode : "doing",
		target : msg,
		position : "2-1"
	});
	$(".float_doing_box").removeAttr("style").css({
		"position" : "absolute",
		"right" : "5px",
		"top" : "5px",
		"z-index" : 9999
	});
	window.setTimeout(function() {
		$("#overlay").remove();
		
		$.powerFloat.hide();
	}, 2000);
};

/**
 * 显示弹出层
 * 
 * @param popupClassName
 *            弹出层className
 */
ibank.showPopup = function(popupClassName) {
	var dw = $(window).width(), dy = $(window).height(), w = $("." + popupClassName).width(), y = $("." + popupClassName).height(), bh = $("body").height();
	
	$("<div/>").prependTo("body").addClass("shade").fadeIn(300).css("height", bh - dy > 0 ? bh : dy + "px");
	$("." + popupClassName).is(":visible") ? $("." + popupClassName).hide() : $("." + popupClassName).show();
	$("." + popupClassName).show().css({
		"left" : (dw / 2 - w / 2) + "px",
		"top" : (dy / 2 - y / 2) + "px"
	});
	if ("undefined" == typeof (document.body.style.maxHeight)) {
		var timeout = false;
		$(window).scroll(function() {
			if (timeout) {
				clearTimeout(timeout);
			}
			function t() {
				// do
				var scroll_sh = $(window).scrollTop(), scroll_bh = $("body").height();
				$("." + popupClassName).css({
					"position" : "absolute",
					"top" : (scroll_bh / 2 - y / 2 - scroll_sh) + "px"
				});
			}
			
			timeout = setTimeout(t, 100);
		});
	}
	$(".icon_pop_close").click(function() {
		$(".shade").remove();
		
		$("." + popupClassName).hide();
		return false;
	});
};
/**
 * 隐藏弹出层
 * 
 * @param popupClassName
 */
ibank.hidePopup = function(popupClassName) {
	$(".shade").remove();
	
	$("." + popupClassName).hide();
};

/**
 * 文件上传
 * 
 * @param width
 * @returns {IBankFileUpload}
 */
IBankFileUpload = function(width) {
	this.width = 300 || width;
	this.init(this.width);
};

IBankFileUpload.prototype = {
	init : function(width) {
		// 初始化所有
		$('span[type="file"]').each(function() {
			var _self = $(this);
			if ($(".ui-file-spanht", $(_self)).size() == 0) {
				$(_self).html('<input type="text" class="hr_inp ui-file-select" value="" style="width:' + width + 'px" /><span class="ui-file-spanht"></span><a href="#" class="btn ui-file-button">浏览文件</a><img src="' + ctx + '/static/images/loading.gif" class="loading" style="position:relative;left:10px;top:5px;width:20px;height:20px;display:none;">');
			}
			// 绑定事件
			$(".ui-file-button", $(_self)).unbind().bind("click", function() {
				// 增加文件
				$(".ui-file-spanht", $(_self)).html('<input type="file" class="ui-file-hidden" name="" style="display:none;" />');
				// 模拟点击
				$(".ui-file-hidden", $(_self)).trigger("click");
				// 返回路径
				$(".ui-file-hidden", $(_self)).change(function() {
					$(".ui-file-select", $(_self)).val($(this).val());
				});
			});
		});
	}
};
/**
 * 文件上传
 * 
 * @param it
 * @param allowFile
 * @param callBack
 * @returns {Boolean}
 */
function ajaxFileUpload(it, allowFile, limitSize, fileUploadCallback, thumbnail) {
	$(".loading", $("#" + it)).show();// 开始上传文件时显示一个图片
	
	$(".ui-file-hidden", $("#" + it)).attr("name", it);
	
	$.ajaxFileUpload({
		url : ctx + '/base/file/fileUpload',// 用于文件上传的服务器端请求地址
		secureuri : false,// 一般设置为false
		fileElementId : 'fileUpload',// 文件上传空间的id属性
		allowFile : allowFile || "xls,xlsx,doc,docx,pdf,txt,swf,wmv,gif,png,jpg,jpeg,bmp,rar,zip",
		limitSize : limitSize || 1024,// 文件大写限制
		thumbnail : thumbnail || "",// 是否需要缩略图，为空时，默认无缩略图,不为空时，长和宽
		dataType : 'json',// 返回值类型 一般设置为json
		success : function(data, status) // 服务器成功响应处理函数
		{
			$(".loading", $("#" + it)).hide();
			// 清除
			$(".ui-file-spanht", $("#" + it)).html('');
			// 从服务器返回的json中取出message中的数据
			$("#" + it).attr({
				"fileName" : "" || data.result.fileName,
				"fileNail" : "" || data.result.fileNail,
				"status" : data.status
			});
			// 绑定
			$(".ui-file-button", $("#" + it)).unbind().bind("click", function() {
				// 增加文件
				$(".ui-file-spanht", $("#" + it)).html('<input type="file" class="ui-file-hidden" name="" style="display:none;" />');
				// 模拟点击
				$(".ui-file-hidden", $("#" + it)).trigger("click");
				// 返回路径
				$(".ui-file-hidden", $("#" + it)).change(function() {
					$(".ui-file-select", $("#" + it)).val($(this).val());
				});
			});
			if (fileUploadCallback) {
				fileUploadCallback.call();
			}
		},
		error : function(data, status, e)// 服务器响应失败处理函数
		{
			ibank.alert(e);
		}
	});
	return false;
}