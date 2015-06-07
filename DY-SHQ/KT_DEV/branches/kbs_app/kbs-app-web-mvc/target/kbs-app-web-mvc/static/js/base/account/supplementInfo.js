/**
 * 我的信息=>补充信息
 */
$(document).ready(function() {
	new IBankFileUpload(300);
	
	hide_popup('.hr_pop_1', '.shade');
	hide_popup('.hr_pop_2', '.shade');
	hide_popup('.hr_pop_3', '.shade');
	//点击下载按钮，弹出遮罩层
	$(".a-style1").click(function(){
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
					}
					hide_popup('.hr_pop_1', '.shade');
				}
			});
		});
		show_popup('.hr_pop_1','.shade','.icon_pop_close,.cancel-btn');
	});
	//.shade是遮罩层，不用管
	// 上传档案
	$(".hr_info").click(function(){
		$(".cleardata").val("");
		show_popup('.hr_pop_2','.shade','.icon_pop_close');
	});
	//.shade是遮罩层，不用管
});

//上传文件和UserFile信息
function uploadFileAndUserFile(){
	//参数验证
	agrValidate();
	if(!$("#agrform").valid())
		return;
	return ajaxFileUpload('fileUpload','jpg,png', uploadUserFile);
}

// 上传UserFile
function uploadUserFile() {
	if($("#fileUpload").attr("status") != "success"){
		return false;
	}
	$.ajax({
		url : $('#agrform').attr("action"),
		type : "POST",
		dataType : "json",
		contentType : 'application/x-www-form-urlencoded; charset=UTF-8',
		data : $('#agrform').serialize() + "&filePath=" + $("#fileUpload").attr("filePath"),
		success : function(data) {
			if ("success" == data.status) {
				alert("保存成功！");
				hide_popup('.hr_pop_2', '.shade');
				$("#newUpload")
				.before("<li class=\"hr_icon_poz\">" +
							"<div class=\"pic-box\">" +
								"<img src=\"" + data.result.userFile.filePath + "\" alt=\"\" width=\"104\" height=\"79\" />" +
								"<p class=\"hr_cor_gre\">" + data.result.userFile.fileName +"</p>" +
							"</div>" +
						"<a href=\"#\" class=\"a-style1\" value=\"${ctx}/base/account/download/" + data.result.userFile.fileNo + "\">下载</a>" +
						"<a href=\"#\" class=\"hr_arong\"></a>" +
						"</li>");
			} else {
				alert("保存失败！");
			}
		}
	});
}

// 参数合法性验证
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
	$("#agrform").validate(opts);
}