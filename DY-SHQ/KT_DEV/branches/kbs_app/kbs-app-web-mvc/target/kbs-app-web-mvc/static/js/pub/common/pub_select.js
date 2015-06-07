/*******************************************************************************
 * 单选框分组
 */
var ComRadios = function(selector) {
	this.selector = selector;
	this.radios = {};
	this.className = {
		on : "com_radio_on",
		off : "com_radio_off"
	};
	this.inputKey = "_input";

	this.init();
};
ComRadios.prototype = {
	init : function() {
		var self = this;
		$(self.selector).each(function(i) {
			var group = $(this).attr("group");
			if (self.radios[group]) {
				self.radios[group].push($(this));
			} else {
				self.radios[group] = new Array();
				self.radios[group + self.inputKey] = $(this).parent().find("input");
				self.radios[group].push($(this));
			}

			$(this).on("click", function() {
				if ($(this).prop("class").indexOf(self.className.on) != -1) {
					return;
				}
				(self.radios[group + self.inputKey]).val($(this).attr("data"));
				self.changeClass($(this), $(this).prop("class").indexOf(self.className.on) != -1 ? self.className.off : self.className.on);
			});

			// 设置默认显示
			self.defaultDispaly(self.radios[group], self.radios[group + self.inputKey]);
		});
	},
	getGroupRadios : function(radio) {
		return this.radios[$(radio).attr("group")];
	},
	changeClass : function(radio, cls) {
		var cls1 = "";
		if (cls == this.className.off)
			cls1 = this.className.on;
		if (cls == this.className.on)
			cls1 = this.className.off;
		var radios = this.getGroupRadios(radio);
		for ( var i = 0; i < radios.length; i++) {
			if (radio.get(0) == radios[i].get(0)) {
				$(radios[i]).removeClass(cls1);
				$(radios[i]).addClass(cls);
			} else {
				$(radios[i]).removeClass(cls);
				$(radios[i]).addClass(cls1);
			}
		}
	},
	defaultDispaly : function(groupArr, inputEl) {
		var valArr = inputEl.val().split(this.split);
		for ( var m = 0; m < groupArr.length; m++) {
			var _el = $(groupArr[m]);
			for ( var n = 0; n < valArr.length; n++) {
				if (_el.attr("data") == valArr[n]) {
					_el.removeClass(this.className.off);
					_el.addClass(this.className.on);
					break;
				}
			}
		}
	}
};
/*******************************************************************************
 * 多选框分组
 */
var ComCheckBox = function(opt) {
	this.selector = opt;
	this.opt = opt;
	this.split = ",";
	if (jQuery.isPlainObject(opt)) {
		this.selector = opt.selector;
		this.split = opt.split || this.split;
		this.form = opt.form;
		this.validator = opt.validator;
	}

	/*
	 * 存放分组的checkbox {"groupname1" : [spanElement1, spanElement2]}
	 */
	this.checks = {};
	this.inputKey = "_check";
	this.className = {
		on : "com_check_on",
		off : "com_check_off"
	};

	this.init();
};
ComCheckBox.prototype = {
	init : function() {
		var self = this;
		$(this.selector).each(function(i) {
			/*
			 * 页面所有的checkbox按group分组存放到this.checks中
			 */
			var group = $(this).attr("group");
			if (self.checks[group]) {
				self.checks[group].push($(this));
			} else {
				self.checks[group] = new Array();
				self.checks[group + self.inputKey] = $(this).next();
				self.checks[group].push($(this));
			}

			/*
			 * 添加点击事件 没有data属性的为全选 1.设置选中(取消)的值到隐藏域 2.设置选中(取消)的span的样式
			 */
			if ($(this).attr("data")) {
				$(this).on("click", function() {
					var val = self.checks[group + self.inputKey].val();// 已有的选中值
					var chkVal = $(this).attr("data");// 当前选中值

					if ($(this).prop("class").indexOf(self.className.on) != -1) {
						// 取消选中 从已有值中删除当前值
						var valArr = val.split(self.split);

						var dx = self.getValueIndexInArray(valArr, chkVal);// 查找待删除值在数组中的下标
						valArr.splice(dx, 1);// 删除
						self.checks[group + self.inputKey].val(valArr.join(self.split));// 分隔字符保存
					} else {
						// 选中时 当前值增加到已有值
						if (val != "") {
							self.checks[group + self.inputKey].val(val + self.split + chkVal);
						} else {
							self.checks[group + self.inputKey].val(chkVal);
						}
					}
					self.changeClass($(this), $(this).prop("class").indexOf(self.className.on) != -1 ? self.className.off : self.className.on);

					self.validate(group);
				});
			} else {
				$(this).on("click", function() {
					var ipt = self.checks[group + self.inputKey];
					if ($(this).prop("class").indexOf(self.className.off) != -1) {
						var valArr = [];
						for ( var k = 0; k < self.checks[group].length; k++) {
							valArr.push($(self.checks[group][k]).attr("data"));
							self.changeClass($(self.checks[group][k]), self.className.on);
						}
						$(ipt).val(valArr.join(self.split));
					} else {
						$(ipt).val("");
						for ( var k = 0; k < self.checks[group].length; k++) {
							self.changeClass($(self.checks[group][k]), self.className.off);
						}
					}
					
					self.validate(group);
				});
			}

			// 根据默认值设置选中
			self.defaultDispaly(self.checks[group], self.checks[group + self.inputKey]);
		});
	},
	validate : function(group){
		if(this.validator){
			this.validator.element(this.checks[group + this.inputKey]);
		}
	},
	getGroupCheckBox : function(check) {
		return this.checks[$(check).attr("group")];
	},
	getValueIndexInArray : function(arr, val) {
		for ( var i = 0; i < arr.length; i++) {
			if (arr[i] == val) {
				return i;
			}
		}
		return 0;
	},
	changeClass : function(check, cls) {
		var cls1 = "";
		if (cls == this.className.off)
			cls1 = this.className.on;
		if (cls == this.className.on)
			cls1 = this.className.off;
		check.removeClass(cls1);
		check.addClass(cls);
	},
	/**
	 * 根据默认值设置显示 groupArr：多选组中的element inputEl：隐藏域element
	 */
	defaultDispaly : function(groupArr, inputEl) {
		var valArr = inputEl.val().split(this.split);
		for ( var m = 0; m < groupArr.length; m++) {
			var _el = $(groupArr[m]);
			for ( var n = 0; n < valArr.length; n++) {
				if (_el.attr("data") == valArr[n]) {
					this.changeClass(_el, this.className.on);
					break;
				}
			}
		}
	}
};

/**
 * 下拉列表
 */
var ComSelect = function(opt) {
	this.selector = opt;
	this.opt = opt;
	if (jQuery.isPlainObject(opt)) {
		this.selector = opt.selector;
		this.validator = opt.validator;
		this.allowInput = opt.allowInput || false;
		this.chain = opt.chain;
		
		var listeners = opt.listeners || [];
		for(var type in listeners){
			var handler = listeners[type];
			$(this).bind(type, handler);
		}
	}
	
	this.datas = [];
	this.config = {
		height : 140
	};
	
	this.obj = [];
	
	this.init();
};
ComSelect.prototype = {
	init : function() {
		var self = this;
		
		$(document).click(function(){
			$(".js-select-open").hide();
        }); 
		
		$(this.selector).each(function(i) {
			var wrapper = $(this);// 下拉框div
			var list = $(this).next().next();// 下拉列表div
			
			var sigle = function(wrapper, list, input){
				this.wrapper = wrapper;	//显示位置的div
				this.list = list;		//下拉列表div
				this.input = input;		//隐藏域的input
			};
			sigle.prototype = {
				getInput : function(){
					return this.input;
				},
				getList : function(){
					return this.list;
				},
				getWrapper : function(){
					return this.wrapper;
				}
			};
			self.obj.push(new sigle(wrapper, list, wrapper.next()));
			
			list.hide();

			// 下拉框事件
			$(this).on("click", function(event) {
				event.stopPropagation();
				
				//允许输入时,只能点击右边图标弹出下拉列表
				if(self.allowInput===true && event.clientX < $(this).outerWidth(true) + $(this).offset().left - 30){
					return false;
				}
				
				self.changeDisplay(list, wrapper);
			});

			// 下拉列表事件,并保存下拉列表值
			self.addListEvent(wrapper, list);
			
			//输入框事件
			if(this.allowInput === true){
				$("input", wrapper).on("change", function(){
					var flag = false;
					for(var i=0; i<self.datas.length; i++){
						if(self.datas[i][$(this).val()]){
							flag = true;
							break;
						}
					}
					if(flag == false){
						self.setDisplayValue(wrapper, $(this).val());
						$(self).triggerHandler("change", [$(this).val(), $(this).val(), wrapper.next()]);
					}
				});
			}

			self.defaultDisplay(list, wrapper, wrapper.next().val());
		});
	},
	getObject : function(){
		if(this.obj.length == 1)
			return this.obj[0];
		else
			return this.obj;
	},
	setListSize : function(wrapper, list){
		if(list.sizeFlag === undefined || list.sizeFlag === false){
			if (list.outerHeight(false) > this.config.height) {
				list.css("height", this.config.height);
				list.css("width", list.outerWidth(false) + 17);// 出现垂直滚动条时，宽度增加滚动条的宽度17
			}
			if (list.outerWidth(false) < wrapper.outerWidth(false)) {
				list.css("width", wrapper.outerWidth(false));
			}
			
			list.sizeFlag = true;
		}
	},
	/* 根据默认值设置显示样式 */
	defaultDisplay : function(list, wrapper, value) {
		if (value != "") {
			var self = this;
			list.find("a").each(function(i) {
				if ($(this).attr("data") == value) {
					self.setDisplayValue(wrapper, $(this).html());
					return;
				}
			});
		}
	},
	changeDisplay : function(list, wrapper){
		if (list.css("display") == "none") {
			list.show();
			
			this.setListSize(wrapper, list);
		} else {
			list.hide();
		}
	},
	/**
	 * 设置隐藏域的值
	 * @param {} value
	 * @param {} wrapper
	 */
	setValue : function(value, wrapper){
		wrapper.next().val(value);
	},
	/**
	 * 获取隐藏域的值
	 * @return {}
	 */
	getValue : function(){
		return this.getObject().getInput().val();
	},
	/**
	 * 设置显示值
	 * @param {} wrapper
	 * @param {} text
	 */
	setDisplayValue : function(wrapper, text){
		if(this.allowInput === true){
			$("input", wrapper).val(text);
		} else {
			wrapper.html(text);
		}
		
		if(this.chain){
			var obj = this.getObject();
			var name = obj.getInput().attr("name");
			var data = {};
			data[name] = this.getValue();
			if(this.chain.data){
				for(var tmp in this.chain.data){
					data[tmp] = this.chain.data[tmp] || data[tmp];
				}
			}
			
			this.reloadChain(data);
		}
	},
	/**
	 * 重载下级数据
	 * @param {} data
	 */
	reloadChain : function(data){
		var obj = this.getObject();
		if($(this).triggerHandler("beforeLoadChain", [obj.getInput().val(), data]) === false){
			return;
		}
		this.clearValue.call(this.chain.next);
		this.loadNext.call(this.chain.next, data, this.chain, this);
	},
	/**
	 * 清除显示值,隐藏域值,下拉列表内容
	 */
	clearValue : function(){
		var obj = this.getObject();
		if($.isArray(obj) == false){
			obj.getInput().val("");
			obj.getList().html("");
			obj.getWrapper().html("");
			
			obj.getList().sizeFlag = false;
		}
		
		if(this.chain){
			this.clearValue.call(this.chain.next);
		}
	},
	/**
	 * 验证
	 * @param {} hidden
	 */
	validate : function(hidden){
		if(this.validator){
			this.validator.element(hidden);
		}
	},
	/**
	 * 添加下拉列表事件
	 * @param {} wrapper
	 * @param {} list
	 */
	addListEvent : function(wrapper, list){
		var self = this;
		list.find("a").each(function(i) {
			var value = $(this).attr("data");
			var text = $(this).html();
			self.datas.push({
				value : value,
				text : text
			});
			$(this).off("click").on("click", function() {
				self.setValue(value, wrapper);// 设置当前选中的值到隐藏input中
				self.setDisplayValue(wrapper, text);// 设置当前选中的显示值到下拉框div中
				
				self.changeDisplay(list, wrapper);

				self.validate(wrapper.next().get(0));
				
				//增加change事件
				$(self).triggerHandler("change", [value, text, wrapper.next()]);
				
				return false;// 返回false防止页面滚动到屏幕最上面
			});
		});
	},
	/**
	 * 获取下级列表数据
	 * @param {} data
	 * @param {} chain
	 * @param {} parent
	 */
	loadNext : function(data, chain, parent){
		var self = this;
		
		$.ajax({
			url : chain.url,
			type: "POST",
			contentType : "application/x-www-form-urlencoded",
			data : data,
			dataType : "json",
			success : function(json) {
				if($(parent).triggerHandler("afterLoadChain", [json]) === false){
					return;
				}
				
				if(json.status == "success"){
					var html = "<ul>";
					for(var i=0; i<json.result.length; i++){
						html += "<li><a href=\"#\" data='"+json.result[i][chain.keys.value]+"'>"+json.result[i][chain.keys.text]+"</a></li>"
					}
					html += "</ul>";
					
					var nextObj = chain.next.getObject();
					nextObj.getList().html(html);
					
					self.addListEvent(nextObj.getWrapper(), nextObj.getList());
				} else {
					alert(json.error);
				}
			}
		});
	}
};