$(document).ready(function() {
	new IBankFileUpload(300);
});
/**
 * 回调
 */
function fileUploadCallback() {
	ibank.alert("文件名：" + $("#fileUpload").attr("fileName") + " 状态：" + $("#fileUpload").attr("status"));
}