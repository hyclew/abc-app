package com.kingteller.bs.rest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.kingteller.bs.domain.user.HeadPortraitDomail;
import com.kingteller.bs.domain.user.LoginUser;
import com.kingteller.bs.domain.user.RegisterCode;
import com.kingteller.bs.domain.user.UserBase;
import com.kingteller.bs.domain.user.UserDetailed;
import com.kingteller.bs.domain.user.UserInfoDomain;
import com.kingteller.bs.framework.check.StringUtils;
import com.kingteller.bs.framework.constant.Constant;
import com.kingteller.bs.framework.json.Json2Object;
import com.kingteller.bs.framework.rest.ErrorCode;
import com.kingteller.bs.framework.rest.ResponseHeader;
import com.kingteller.bs.framework.rest.RestResponse;
import com.kingteller.bs.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	private static final Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	/**
	 * 用户注册接口
	 * 
	 * @param userInfoDomain
	 *            此字段中包括UserBase、UserDetailed、LoginUser三个对象的集合
	 * @return
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public @ResponseBody RestResponse userRegister(
			@RequestBody String userInfoDomain) {
		logger.info("开始注册新用户,用户信息是:" + userInfoDomain);
		RestResponse response = new RestResponse();
		ResponseHeader header = new ResponseHeader();
		response.setResponseHeader(header);
		UserInfoDomain userInfo = null;
		UserBase userBase = null;
		UserDetailed userDetailed = null;
		LoginUser loginUser = null;
		try {
			userInfo = (UserInfoDomain) Json2Object.deserializeObject(
					userInfoDomain, UserInfoDomain.class);
			if (null != userInfoDomain) {
				userBase = userInfo.getUserBase();
				userDetailed = userInfo.getUserDetailed();
				loginUser = userInfo.getLoginUser();
				if (null == userBase || userDetailed == null
						|| loginUser == null) {
					logger.error("注册信息不能为空");
					response.getResponseHeader().setErrorCode(ErrorCode.OPERATE_FAIL);
					response.getResponseHeader().setMessage("注册信息不能为空");
				}else{
					//开始校验字段信息
					String phone = userBase.getPhone();
					String password = loginUser.getPassword();
					String confirmPassword = loginUser.getConfirmPassword();
					String name = userBase.getName(); //真实姓名
					String username = loginUser.getUsername();
					String address = userBase.getAddress();
					if(null == phone || "".equals(phone) || !phone.matches("[0-9]{11}")){
						logger.info("请输入正确的手机号");
						response.getResponseHeader().setErrorCode(ErrorCode.PARAMS_ERROR);
						response.getResponseHeader().setMessage("请输入正确的手机号");
					} else if(null == password || "".equals(password) || !password.matches("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,12}$")){
						logger.info("密码必须是数字和字母的组合,且长度为6到12位");
						response.getResponseHeader().setErrorCode(ErrorCode.PARAMS_ERROR);
						response.getResponseHeader().setMessage("密码必须是数字和字母的组合,且长度为6到12位");
					} else if(!password.equals(confirmPassword)){
						logger.info("两次密码输入必须一致");
						response.getResponseHeader().setErrorCode(ErrorCode.PARAMS_ERROR);
						response.getResponseHeader().setMessage("两次密码输入必须一致");
					} //else if(null == name || "".equals(name) || !name.matches("[\u4E00-\u9FA5]{2,}") ){
						//logger.info("真实姓名必须是2位以上汉字");
						//response.getResponseHeader().setErrorCode(ErrorCode.PARAMS_ERROR);
						//response.getResponseHeader().setMessage("真实姓名必须是2位以上汉字");
					//} 
					else if(null == username || "".equals(username)){
						logger.info("用户名不能为空");
						response.getResponseHeader().setErrorCode(ErrorCode.PARAMS_ERROR);
						response.getResponseHeader().setMessage("用户名不能为空");
					} else if(null == address || "".equals(address)){
						logger.info("地址不能为空");
						response.getResponseHeader().setErrorCode(ErrorCode.PARAMS_ERROR);
						response.getResponseHeader().setMessage("地址不能为空");
					} else if(null == name || "".equals(name)){
						logger.info("真实姓名不能为空");
						response.getResponseHeader().setErrorCode(ErrorCode.PARAMS_ERROR);
						response.getResponseHeader().setMessage("真实姓名不能为空");
					} else{
						response = this.userService.register(userBase, userDetailed, loginUser);
					}
				}
				
			}else {
				header.setErrorCode(ErrorCode.OPERATE_FAIL);
				header.setMessage("注册信息不能为空");
			}
		} catch (JsonParseException e) {
			logger.error("注册失败,失败原因是:" + e.getLocalizedMessage(), e);
			response.getResponseHeader().setMessage("注册失败,原因为传入参数解析有误");
			response.getResponseHeader().setErrorCode(
					ErrorCode.INSERT_EXCEPTION);
		} catch (JsonMappingException e) {
			logger.error("注册失败,失败原因是:" + e.getLocalizedMessage(), e);
			response.getResponseHeader().setMessage("注册失败,原因为传入参数解析有误");
			response.getResponseHeader().setErrorCode(
					ErrorCode.INSERT_EXCEPTION);
		} catch (Exception e) {
			logger.error("注册失败,失败原因是:" + e.getLocalizedMessage(), e);
			response.getResponseHeader().setMessage("注册失败");
			response.getResponseHeader().setErrorCode(
					ErrorCode.INSERT_EXCEPTION);
		}
		return response;
	}

	/**
	 * 上传头像
	 * 
	 * @param userInfoDomain
	 * @return
	 */
	@RequestMapping(value = "/uploadportrait", method = RequestMethod.POST)
	public @ResponseBody RestResponse uploadPortrait(
			@RequestBody String headPortraitDomail) {
		logger.info("开始上传头像,头像信息是:" + headPortraitDomail);
		RestResponse response = new RestResponse();
		ResponseHeader header = new ResponseHeader();
		response.setResponseHeader(header);
		HeadPortraitDomail headPortrait = null;
		try {
			headPortrait = (HeadPortraitDomail) Json2Object.deserializeObject(
					headPortraitDomail, HeadPortraitDomail.class);
			if (null == headPortrait) {
				logger.info("传入参数不能为空");
				response.getResponseHeader().setMessage("上传头像失败,传入参数不能为空");
				response.getResponseHeader().setErrorCode(
						ErrorCode.PARAMS_ERROR);
			} else if (null == headPortrait.getHeadPortrait()
					|| "".equals(headPortrait.getHeadPortrait())
					|| null == headPortrait.getPicSuffix()
					|| "".equals(headPortrait.getPicSuffix())
					|| null == headPortrait.getSessionId()
					|| "".equals(headPortrait.getSessionId())) {
				logger.info("头像信息不能为空");
				response.getResponseHeader().setMessage("上传头像失败,头像详细信息不能为空");
				response.getResponseHeader().setErrorCode(
						ErrorCode.PARAMS_ERROR);
			}else{
				response = this.userService.uploadPortrait(headPortrait);
			}

		} catch (JsonParseException e) {
			logger.error("上传头像失败,失败原因是:" + e.getLocalizedMessage(), e);
			response.getResponseHeader().setMessage("上传头像失败,原因为传入参数解析有误");
			response.getResponseHeader().setErrorCode(
					ErrorCode.INSERT_EXCEPTION);
		} catch (JsonMappingException e) {
			logger.error("上传头像失败,失败原因是:" + e.getLocalizedMessage(), e);
			response.getResponseHeader().setMessage("上传头像失败,原因为传入参数解析有误");
			response.getResponseHeader().setErrorCode(
					ErrorCode.INSERT_EXCEPTION);
		} catch (Exception e) {
			logger.error("上传头像失败,失败原因是:" + e.getLocalizedMessage(), e);
			response.getResponseHeader().setMessage("上传头像失败");
			response.getResponseHeader().setErrorCode(
					ErrorCode.INSERT_EXCEPTION);
		}
		return response;
	}

	/**
	 * 用户登录
	 * 
	 * @param userInfoDomain
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody RestResponse userLogin(@RequestBody String loginUser) {
		logger.info("开始使用账号密码进行登录,用户信息是:" + loginUser);
		RestResponse response = new RestResponse();
		ResponseHeader header = new ResponseHeader();
		response.setResponseHeader(header);
		LoginUser user = null;
		try {
			user = (LoginUser) Json2Object.deserializeObject(loginUser,
					LoginUser.class);
			if (null == user) {
				logger.info("登录失败,用户信息不能为空");
				response.getResponseHeader().setMessage("登录失败,用户信息不能为空");
				response.getResponseHeader().setErrorCode(
						ErrorCode.PARAMS_ERROR);
			} else if (null == user.getUsername()
					|| "".equals(user.getUsername())
					|| null == user.getPassword()
					|| "".equals(user.getPassword())) {
				logger.info("账号或密码不能为空");
				response.getResponseHeader().setMessage("登录失败,账号或密码不能为空");
				response.getResponseHeader().setErrorCode(
						ErrorCode.PARAMS_ERROR);
			} else {
				String username = user.getUsername();
				String password = user.getPassword();
				response = this.userService.login(username, password);
			}
		} catch (JsonParseException e) {
			logger.error("登录失败,失败原因是:" + e.getLocalizedMessage(), e);
			response.getResponseHeader().setMessage("登录失败,原因为传入参数解析有误");
			response.getResponseHeader().setErrorCode(ErrorCode.PARAMS_ERROR);
		} catch (JsonMappingException e) {
			logger.error("登录失败,失败原因是:" + e.getLocalizedMessage(), e);
			response.getResponseHeader().setMessage("登录失败,原因为传入参数解析有误");
			response.getResponseHeader().setErrorCode(ErrorCode.PARAMS_ERROR);
		} catch (Exception e) {
			logger.error("登录失败,失败原因是:" + e.getLocalizedMessage(), e);
			response.getResponseHeader().setMessage("登录失败");
			response.getResponseHeader().setErrorCode(ErrorCode.PARAMS_ERROR);
		}
		return response;
	}
	
	/**
	 * 获取验证码
	 * @param phone
	 * @return
	 */
	@RequestMapping(value = "/generatecode", method = RequestMethod.POST)
	public @ResponseBody RestResponse generateCode(@RequestBody String phone) {
		logger.info("开始获取验证码,请求信息是:" + phone);
		RestResponse response = new RestResponse();
		ResponseHeader header = new ResponseHeader();
		response.setResponseHeader(header);
		RegisterCode registerCode = null;
		try {
			registerCode = (RegisterCode) Json2Object.deserializeObject(phone,
					RegisterCode.class);
			if(null == registerCode){
				logger.info("获取验证码失败,手机号不能为空");
				response.getResponseHeader().setMessage("获取验证码失败,手机号不能为空");
				response.getResponseHeader().setErrorCode(
						ErrorCode.PARAMS_ERROR);
			}else if(null == registerCode.getPhone() || "".equals(registerCode.getPhone())){
				logger.info("获取验证码失败,手机号不能为空");
				response.getResponseHeader().setMessage("获取验证码失败,手机号不能为空");
				response.getResponseHeader().setErrorCode(
						ErrorCode.PARAMS_ERROR);
			}else{
				String checkCode = StringUtils.generateCheckCode(registerCode.getPhone());
				registerCode.setCheckCode(checkCode);
				response = this.userService.generateCheckCode(registerCode);
			}
		} catch (JsonParseException e) {
			logger.error("获取验证码失败,失败原因是:" + e.getLocalizedMessage(), e);
			response.getResponseHeader().setMessage("获取验证码失败,原因为传入参数解析有误");
			response.getResponseHeader().setErrorCode(ErrorCode.PARAMS_ERROR);
		} catch (JsonMappingException e) {
			logger.error("获取验证码失败,失败原因是:" + e.getLocalizedMessage(), e);
			response.getResponseHeader().setMessage("获取验证码失败,原因为传入参数解析有误");
			response.getResponseHeader().setErrorCode(ErrorCode.PARAMS_ERROR);
		} catch (Exception e) {
			logger.error("获取验证码失败,失败原因是:" + e.getLocalizedMessage(), e);
			response.getResponseHeader().setMessage("获取验证码失败");
			response.getResponseHeader().setErrorCode(ErrorCode.OPERATE_FAIL);
		}
		return response;
	}
	
}
