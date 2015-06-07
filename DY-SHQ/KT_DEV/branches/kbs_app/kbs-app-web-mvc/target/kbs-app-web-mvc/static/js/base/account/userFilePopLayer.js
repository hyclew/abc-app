/**
 * UserFile 弹出层JS
 */
$(document).ready(function() {
	//初始化上传文件控件
	new IBankFileUpload(300);
	
	//隐藏所有弹出层
	hide_popup('.pop', '.shade');
	
	// 1 上传档案
	$(".btnup").click(uploadFile);
	
	// 2 下载档案
	$(".click_down").click(downloadFile);
	
	// 3 删除档案
	$(".btndel").click(deleteFile);
	
	// 4 预览档案
	$(".btnsee").click(previewFile);
	
	// 5 取消按钮
	$(".cancelButton").click(function(){
		hide_popup('.pop', '.shade');
	});
});

// 上传文件（弹出层）
function uploadFile(){
	$(".cleardata").val("");
	$("#fileTypeSpan").text($(this).parent("li").attr("value"));
	$("#fileTypeInput").val($(this).parent("li").attr("id"));
	show_popup('.popup','.shade','.icon_pop_close');
}

// 上传文件和UserFile信息
function uploadFileAndUserFile(){
	//参数验证
	agrValidate();
	if(!$("#uploadForm").valid())
		return;
	return ajaxFileUpload('fileUpload','jpg,png', 5120, uploadUserFile);
}

// 上传UserFile
function uploadUserFile() {
	if($("#fileUpload").attr("status") != "success"){
		return false;
	}
	$.ajax({
		url : $('#uploadForm').attr("action"),
		type : "POST",
		dataType : "json",
		contentType : 'application/x-www-form-urlencoded; charset=UTF-8',
		data : $('#uploadForm').serialize() + "&filePath=" + $("#fileUpload").attr("fileName"),
		success : function(data) {
			if ("success" == data.status) {
				alert("保存成功！");
				$("#" + data.result.userFile.fileType)
				.html("<div class=\"text-box posiR\">" +
						"<div class=\"describe\">" +
							"<img src=\"" + data.result.userFile.filePath + "\" alt=\"\" width=\"104\" height=\"79\" />" +
							"<p class=\"hr_cor_gre\">" + data.result.userFile.fileName +"</p>" +
						"</div>" +
						"<p>" + data.result.userFile.fileName + "<br />" + data.result.userFile.uploadTime + "</p>" +
						//"<a href=\"#\" class=\"index_icon_delete zhr_wronggreen btndel\" value=\"" + ctx + "/base/account/userFile/delete/" + data.result.userFile.fileNo + "\"></a>" +
						"<a href=\"#\" class=\"click_down\" value=\"" + ctx + "/base/account/userFile/download/" + data.result.userFile.fileNo + "\">点击下载</a>" +
					  "</div>" +
					  "<a href=\"#\" class=\"a-style1 btnsee\">预览</a>");
				$(".click_down", "#" + data.result.userFile.fileType).click(downloadFile);
				//上传后，默认不显示删除
				$(".btndel", "#" + data.result.userFile.fileType).click(deleteFile);
				hide_popup('.popup', '.shade');
			} else {
				alert("保存失败！");
			}
		}
	});
}

// 下载文件
function downloadFile(){
	var downloadURI = $(this).attr("value");
	$("#downloadButton").unbind("click").bind("click", function(event, data){
		$.ajax({
			url: downloadURI,
			type: "POST",
			dataType : "json",
			contentType : 'application/x-www-form-urlencoded; charset=UTF-8',
			success : function(data){
				if("fail" == data.status){
					alert("下载失败！");
					return;
				}
				hide_popup('.popdown', '.shade');
			}
		});
	});
	show_popup('.popdown','.shade','.icon_pop_close,.cancel-btn');
}

// 删除文件
function deleteFile(){
	var deleteURI = $(this).attr("value");
	var fileType = $(this).closest("li").attr("id");
	$("#deleteButton").unbind("click").bind("click", function(event, data){
		$.ajax({
			url: deleteURI,
			type: "POST",
			dataType : "json",
			contentType : 'application/x-www-form-urlencoded; charset=UTF-8',
			success : function(data){
				if("success" == data.status){
					alert("删除成功！");
				 	var configName = $("#" + fileType).attr("value");
				 	$("#" + fileType)
				 	.html("<div class=\"text-box posiR\">" +
					 			"<div class=\"describe\">" +
					 			"<img src=\"\" alt=\"\" width=\"104\" height=\"79\" />" +
					 			"<p class=\"hr_cor_gre\"></p>" +
					 			"</div>" +
					 			"<p>" + configName + "<br /></p>" +
				 			"</div>" +
				 			"<a href=\"#\" class=\"a-style1 btnup\">上传</a>");
					$(".btnup", "#" + fileType).click(uploadFile);
					hide_popup('.poprest', '.shade');
				}else{
					alert("删除失败！");
				}
			},
			error : function(data){
				alert("删除失败！");
			}
		});
	});
	show_popup('.poprest','.shade','.icon_pop_close');
}

// 预览文件
function previewFile(){
	show_popup('.popsee','.shade','.icon_pop_close');
}

//参数合法性验证
function agrValidate() {
	var opts = {
		rules : {
			fileName : {
				required : true,
				maxlength : 30
			},
			fileYear : {
				digits : true,
				min : 1900,
				max : 9999
			},
			description : {
				maxlength : 64
			}
		},
		messages : {
			fileName : {
				required : "请输入档案名称",
				maxlength : jQuery.format("不能超过{0}个字符")
			},
			fileYear : {
				digits : "请输入年份，例如2013",
				min : "请输入年份，例如2013",
				max: "请输入年份，例如2013"
			},
			description : {
				maxlength : jQuery.format("<font color='#FF0000'>不能超过{0}个字符</font>")
			}
		},
		errorPlacement : function(error, element) {
			error.appendTo(element.parent());
		}
	};
	$("#uploadForm").validate(opts);
}