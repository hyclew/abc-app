$(document).ready(function(){
	initNavMenu();
	
	// 生成单选
	new ComRadios("span[type='radio']");
	// 生成多选
	new ComCheckBox("span[type='check']");
	// 生成下拉
	new ComSelect({
		selector : ".js-select",
		listeners : {
			/**
			 * @param comselect对象
			 * @param value选中的值
			 * @param input隐藏域jquery对象
			 */
			change : function(comselect, value, input){
				alert(value+"|"+input);
			}
		}
	});
	
	//带输入框的下拉列表
	new ComSelect({
		selector : ".js-allow-input",
		allowInput : true,
//		chain : {
//			url : "",
//			selector : "",
//			keys : {
//				value : "",
//				label : ""
//			}
//		},
		listeners : {
			/**
			 * @param comselect对象
			 * @param value选中的值
			 * @param input隐藏域jquery对象
			 */
			change : function(comselect, value, input){
				alert(value);
			}
		}
	});
	
	//级联下拉列表3
	var comsel3 = new ComSelect({
		selector : ".js-select-chain3",//级联下拉需要保证选择器返回唯一元素
		listeners : {
			/**
			 * @param comselect对象
			 * @param value选中的值
			 * @param input隐藏域jquery对象
			 */
			change : function(comselect, value, input){
				alert(value);
			}
		}
	});
	//级联下拉列表2
	var comsel2 = new ComSelect({
		selector : ".js-select-chain2",//级联下拉需要保证选择器返回唯一元素
		chain : {
			url : ctx + "/example/chainData3",
			next : comsel3,
			keys : {
				value : "code",
				text : "name"
			}
		},
		listeners : {
			/**
			 * @param comselect对象
			 * @param value选中的值
			 * @param input隐藏域jquery对象
			 */
			change : function(comselect, value, input){
				alert(value);
			},
			/**
			 * @param comselect对象
			 * @param json 后端返回的数据
			 * @return false 阻止默认的成功事件(默认成功事件会生成下一个列表)
			 */
			afterLoadChain : function(comselect, json){
				//console.log(comselect);
				//console.log(json);
				
				return false;
			}
		}
	});
	//级联下拉列表1
	var comsel1 = new ComSelect({
		selector : ".js-select-chain",//级联下拉需要保证选择器返回唯一元素
		chain : {
			url : ctx + "/example/chainData2",
			next : comsel2,
			data : {
				test : "中文",
				test2 : "数据"
			},
			keys : {
				value : "code",
				text : "name"
			}
		},
		listeners : {
			/**
			 * @param comselect对象
			 * @param value选中的值
			 * @param input隐藏域jquery对象
			 */
			change : function(comselect, value, input){
				alert(value);
			}
		}
	});
	
});
