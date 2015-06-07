/**
 *判断身份证的一些方法
 **/ 

 	var provinceAndCity = {
 		11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古",21:"辽宁",22:"吉林",23:"黑龙江",31:"上海",32:"江苏",
 		33:"浙江",34:"安徽",35:"福建",36:"江西",37:"山东",41:"河南",42:"湖北",43:"湖南",44:"广东",45:"广西",
 		46:"海南",50:"重庆",51:"四川",52:"贵州",53:"云南",54:"西藏",61:"陕西",62:"甘肃",63:"青海",64:"宁夏",
 		65:"新疆",71:"台湾",81:"香港",82:"澳门",91:"国外"
 	};
 	//身份证前17位加权值
 	var powers = ["7","9","10","5","8","4","2","1","6","3","7","9","10","5","8","4","2"];
 	//身份证最后一位校验位
 	var parityBit = ["1","0","X","9","8","7","6","5","4","3","2"];

 	var genders = {male:"男",female:"女"};

 	//判断身份证前6位地址
 	function checkAddressCode(addressCode){
 		var check = /^[1-9]\d{5}$/.test(addressCode);
 		if(!check){
 			return false;
 		}
 		if(provinceAndCity[parseInt(addressCode.substring(0,2))]){
 			return true;
 		}else{
 			return false;
 		}

 	}
 	//判断出生日期
 	function checkBirthDayCode(birthDayCode){
 		var check = /^[1-9]\d{3}((0[1-9])|(1[0-2]))((0[1-9])|([1-2][0-9])|(3[0-1]))$/.test(birthDayCode);
 		if(!check){return false;}
 		var yyyy = parseInt(birthDayCode.substring(0,4),10);
 		var mm = parseInt(birthDayCode.substring(4,6),10);
 		var dd = parseInt(birthDayCode.substring(6),10);

 		var xdate = new Date(yyyy,mm-1,dd);

 		if(xdate > new Date()){
 			return false; //生日不能大于当前日期
 		}else if((xdate.getFullYear() == yyyy) && (xdate.getMonth() == mm-1) && (xdate.getDate() == dd)){
 			return true;
 		}else{
 			return false;
 		}
 	}
 	//根据身份证号码中的前17位，获取最后一位校验位的值
 	function getParityBit(idCardNo){
 		var id17 = idCardNo.substring(0,17);

 		var power = 0;
 		for(var i=0;i<17;i++){
 			power += parseInt(id17.charAt(i),10)*parseInt(powers[i]);
 		}

 		var mod = power%11;
 		return parityBit[mod];
 	}
 	//校验身份证最后一位
 	function checkParityBit(idCardNo){
 		var parityBit = idCardNo.charAt(17).toUpperCase();
 		if(getParityBit(idCardNo) == parityBit){
 			return true;
 		}else{
 			return false;
 		}
 	}
 	//主函数 分别验证18 15位身份证
 	function checkIdCardNo(idCardNo){
 		//15位和18位身份证的基本校验
 		var check = /^d{15}|(\d{17}(\d|x|X))$/.test(idCardNo);
 		if(!check){return false;}

 		if(idCardNo.length == 15){
 			return check15IdCardNo(idCardNo);
 		}else if(idCardNo.length == 18){
 			return check18IdCardNo(idCardNo);
 		}else{
 			return false;
 		}
 	}
 	//验证15位身份证
 	function check15IdCardNo(idCardNo){
 		//基本验证
 		var check = /^[1-9]\d{7}((0[1-9])|(1[0-2]))((0[1-9])|([1-2][0-9])|(3[0-1]))\d{3}$/.test(idCardNo);
 		if (!check){ return false; }
 		//校验地址
 		var addressCode = idCardNo.substring(0,6);
 		check = checkAddressCode(addressCode);
 		if(!check) {return false};
 		//15位的身份证都是1999年前颁发，2000年后增至18位
 		var birthDayCode = '19' +idCardNo.substring(6,12);
 		//校验日期码
 		return isCardNoUtil.checkBirthDayCode(birthDayCode);
 	}
 	//验证18位身份证
 	function check18IdCardNo(idCardNo){
 		//基本格式校验
 		var check = /^[1-9]\d{5}[1-2]\d{3}((0[1-9])|(1[0-2]))((0[1-9])|([1-2][0-9])|(3[0-1]))\d{3}(\d|x|X)$/.test(idCardNo);
 		if(!check) {return false;}
 		//校验地址码
 		var addressCode = idCardNo.substring(0,6);
 		check = checkAddressCode(addressCode);
 		if(!check) {return false;}

 		//验证校验码
 		return checkParityBit(idCardNo);

 	}
 	function formateDateCN(day){
 		var yyyy = day.substring(0,4);
 		var mm = day.substring(4,6);
 		var dd = day.substring(6);
 		return yyyy + "-" + mm +"-"+dd;

 	}

 	//获得身份证的信息
 	function getIdCardInfo(idCardNo){
 		var idCardInfo = {
 			gender:"",//性别
 			birthday:""//出生日期（yyyy-mm-dd）
 		};
 		if(idCardNo.length == 15){
 			var aday = "19" + idCardNo.substring(6,12);
 			idCardInfo.birthday = formateDateCN(aday);
 			if(parseInt(idCardNo.charAt(14))%2 == 0){
 				idCardInfo.gender = genders.female;
 			}else{
 				idCardInfo.gender = genders.male;
 			}
 		}else if(idCardNo.length == 18){
 			var aday = idCardNo.substring(6,14);
 			idCardInfo.birthday = formateDateCN(aday);
 			if(parseInt(idCardNo.charAt(16))%2 == 0){
 				idCardInfo.gender = genders.female;
 			}else{
 				idCardInfo.gender = genders.male;
 			}
 		}
 		return idCardInfo;
 	}
 	