$(document).ready(function(){
	initNavMenu();
	
	$(".a-style1").click(function(){
		show_popup('.hr_pop_1','.shade','.icon_pop_close');
		});
	//.shade是遮罩层，不用管
	
	$(".hr_info").click(function(){
		show_popup('.hr_pop_2','.shade','.icon_pop_close');
		});
	//.shade是遮罩层，不用管
	$(".hr_info").click(function(){
		show_popup('.hr_pop_3','.shade','.icon_pop_close');
		});
      $(".btnsave").click(function(){
		show_popup('.popsave','.shade','.icon_pop_close');
		});
     $(".btnup").click(function(){
		show_popup('.popup','.shade','.icon_pop_close,.cancel-btn');
		});
	//.shade是遮罩层，不用管
	
	$(".btnsee").click(function(){
		show_popup('.popsee','.shade','.icon_pop_close');
	}); 
});

function nextStep(){
	$.ajax({
		url : ctx + "/example/loanApply",
		type: "POST",
		contentType : "application/x-www-form-urlencoded",
		data : {
			currentPageNo : pageNo,
			rowsOfPage : "6",
			name : "中文",
			money : 1234
		},
		success : function(html) {
			onSuccess(html);
		}
	});
}