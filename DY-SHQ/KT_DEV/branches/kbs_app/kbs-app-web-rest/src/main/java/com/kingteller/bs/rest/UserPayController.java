package com.kingteller.bs.rest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kingteller.bs.domain.pay.UserPay;
import com.kingteller.bs.domain.pay.UserPaySessionDomain;
import com.kingteller.bs.framework.json.Json2Object;
import com.kingteller.bs.framework.rest.ErrorCode;
import com.kingteller.bs.framework.rest.ResponseHeader;
import com.kingteller.bs.framework.rest.RestResponse;
import com.kingteller.bs.service.UserPayService;
import com.kingteller.bs.service.UserService;

/**
 * 用户支付
 * 
 * @author wangyafei
 *
 */
@RestController
@RequestMapping("/userpay")
public class UserPayController {

	private static final Logger logger = Logger
			.getLogger(UserPayController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserPayService userPayService;

	/**
	 * 绑定银行卡
	 * @param UserPaySessionDomainStr
	 * @return
	 */
	@RequestMapping(value = "/addpaytool", method = RequestMethod.POST)
	public @ResponseBody RestResponse addPayTool(
			@RequestBody String userPaySessionDomainStr) {
		logger.info("开始绑定银行卡,卡信息是 " + userPaySessionDomainStr);
		RestResponse response = new RestResponse();
		ResponseHeader header = new ResponseHeader();
		response.setResponseHeader(header);
		UserPaySessionDomain userPaySessionDomain = null;
		try {
			userPaySessionDomain = (UserPaySessionDomain) Json2Object
					.deserializeObject(userPaySessionDomainStr,
							UserPaySessionDomain.class);
			boolean isLogin = false;
			// 判断用户是否登录
			if (null != userPaySessionDomain
					&& null != userPaySessionDomain.getSessionId()
					&& !"".equals(userPaySessionDomain.getSessionId())) {
				isLogin = this.userService.isLogin(userPaySessionDomain
						.getSessionId());
			}
			if (isLogin) {
				UserPay userPay = userPaySessionDomain.getUserPay();
				if(null == userPay){
					logger.info("卡绑定绑定信息不能为空");
					response.getResponseHeader().setMessage("绑定信息不能为空");
					response.getResponseHeader().setErrorCode(
							ErrorCode.PARAMS_ERROR);
				} else if(null == userPay.getPayTool() || "".equals(userPay.getPayTool())){
					logger.info("支付方式不能为空");
					response.getResponseHeader().setMessage("请选择支付方式");
					response.getResponseHeader().setErrorCode(
							ErrorCode.PARAMS_ERROR);
				} else if(null == userPay.getCvv() || "".equals(userPay.getCvv())){
					logger.info("支付卡号不能为空");
					response.getResponseHeader().setMessage("请输入支付卡号");
					response.getResponseHeader().setErrorCode(
							ErrorCode.PARAMS_ERROR);
				} else if(null == userPay.getName() || "".equals(userPay.getName())){
					logger.info("户主姓名不能为空");
					response.getResponseHeader().setMessage("请输入户主姓名");
					response.getResponseHeader().setErrorCode(
							ErrorCode.PARAMS_ERROR);
				} else if(null == userPay.getPhone() || "".equals(userPay.getPhone()) || !userPay.getPhone().matches("[0-9]{11}")){
					logger.info("手机号输入错误");
					response.getResponseHeader().setMessage("请输入正确的手机号");
					response.getResponseHeader().setErrorCode(
							ErrorCode.PARAMS_ERROR);
				} else if(null == userPay.getCertificateType() || "".equals(userPay.getCertificateType())){
					logger.info("证件类型不能为空");
					response.getResponseHeader().setMessage("请选择证件类型");
					response.getResponseHeader().setErrorCode(
							ErrorCode.PARAMS_ERROR);
				} else if(null == userPay.getCertificateNumber() || "".equals(userPay.getCertificateNumber())){
					logger.info("证件号码不能为空");
					response.getResponseHeader().setMessage("请输入证件号码");
					response.getResponseHeader().setErrorCode(
							ErrorCode.PARAMS_ERROR);
				} else{
					response = this.userPayService.insertUserPay(userPaySessionDomain);
				}
				
			}else{
				logger.info("用户未登录,请先登录");
				response.getResponseHeader().setMessage("用户未登录,请先登录");
				response.getResponseHeader().setErrorCode(
						ErrorCode.USER_NOT_LOGIN);
			}

		} catch (Exception e) {
			logger.info("绑定银行卡出现异常");
			response.getResponseHeader().setMessage("绑定异常");
			response.getResponseHeader().setErrorCode(
					ErrorCode.INSERT_EXCEPTION);
		}
		return response;
	}

	@RequestMapping(value = "/userpaytools/{sessionId}", method = RequestMethod.GET)
	public RestResponse userPayToolList(@PathVariable String sessionId){
		logger.info("开始查询用户绑定银行卡列表信息,SessionId是 " + sessionId);
		RestResponse response = new RestResponse();
		ResponseHeader header = new ResponseHeader();
		response.setResponseHeader(header);
		try {
			if(null == sessionId || "".equals(sessionId)){
				response.getResponseHeader().setErrorCode(ErrorCode.NULL_OR_BLACK);
				response.getResponseHeader().setMessage("查询用户绑定银行卡列表信息结果为空");
				logger.info("查询用户绑定银行卡列表信息结果为空");
			}else{
				response = this.userPayService.queryUserPayList(sessionId);
			}
		} catch (Exception e) {
			response.getResponseHeader().setErrorCode(ErrorCode.QUERY_EXCEPTION);
			response.getResponseHeader().setMessage("查询用户绑定银行卡列表信息异常");
			logger.error("查询用户绑定银行卡列表信息异常,异常信息是: " + e.getLocalizedMessage(), e);
		}
		return response;
	}
	
}
