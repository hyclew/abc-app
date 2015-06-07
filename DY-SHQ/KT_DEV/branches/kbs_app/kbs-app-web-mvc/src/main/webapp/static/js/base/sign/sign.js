$(document).ready(function() {
	initSignLoad("EntPay");
});
/**
 * 初始化签名数据
 * 
 * @param formId
 */
function initSignLoad(formId) {
	$.ajax({
		url : ctx + "/base/sign",
		type : "POST",
		contentType : "application/x-www-form-urlencoded; charset=UTF-8",
		data : {
			formCode : formId
		},
		success : function(data) {
			if ("1" == data.status) {
				FTCtrl = null;// 全局变量
				// 处理数据
				for (idx in data.result.signFields) {
					var signField = data.result.signFields[idx];
					// 取值
					var signValue = $("*[name='" + signField.fieldEnName + "']", $("#" + formId)).val();
					// 序号
					var signIndex = parseInt(signField.indexNo, 10) < 10 ? ("0" + signField.indexNo) : signField.indexNo;
					
					alert("signFlag= " + signField.signFlag + " fieldEnName=" + signField.fieldEnName + " signIndex=" + signIndex + " value=" + signValue);
					// 添加数据项至控件
					// FTCtrl.AddFormItem(signField.signFlag, signIndex, signField.fieldEnName, signValue);
				}
			}
		}
	});
}