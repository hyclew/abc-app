package com.kingteller.bs.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kingteller.bs.domain.pay.UserPay;
import com.kingteller.bs.domain.pay.UserPaySessionDomain;
import com.kingteller.bs.domain.user.LoginUser;
import com.kingteller.bs.domain.user.UserSession;
import com.kingteller.bs.framework.constant.Constant;
import com.kingteller.bs.framework.rest.ErrorCode;
import com.kingteller.bs.framework.rest.ResponseHeader;
import com.kingteller.bs.framework.rest.RestResponse;
import com.kingteller.bs.service.UserPayService;
import com.kingteller.bs.service.inner.pay.UserPayAtomService;
import com.kingteller.bs.service.inner.user.LoginUserAtomService;
import com.kingteller.bs.service.inner.user.UserSessionAtomService;

@Component("userPayService")
public class UserPayServiceImpl implements UserPayService {

	private static final Logger logger = Logger.getLogger(UserPayServiceImpl.class);
	
	@Autowired
	private UserSessionAtomService userSessionAtomService;
	
	@Autowired
	private LoginUserAtomService loginUserAtomService;
	
	@Autowired
	private UserPayAtomService userPayAtomService;
	
	@Override
	public RestResponse insertUserPay(UserPaySessionDomain userPaySessionDomain)
			throws Exception {
		RestResponse response = new RestResponse();
		ResponseHeader header = new ResponseHeader();
		UserSession userSession = null;
		LoginUser loginUser = null;
		try {
			userSession = this.userSessionAtomService.queryBySessionId(userPaySessionDomain.getSessionId());
			loginUser = this.loginUserAtomService.queryLoginUserByUsername(userSession.getUsername());
			Long userBaseId = loginUser.getUserId();
			logger.info("查询到的用户ID是 : " + userBaseId);
			UserPay userPay = userPaySessionDomain.getUserPay();
			userPay.setUserId(userBaseId);
			userPay.setStatus(Constant.USERPAY_STATUS_ENABLED);
			//注:此方法是MVC模块设计方法,后期需要修改
			userPay = this.userPayAtomService.insertUserBase(userPay);
			if(null != userPay.getId() && 0 != userPay.getId()){
				logger.info("绑定银行卡成功");
				header.setErrorCode(ErrorCode.SUCCESS);
				header.setMessage("绑定银行卡成功");
			} else{
				logger.info("绑定银行卡失败");
				header.setErrorCode(ErrorCode.OPERATE_FAIL);
				header.setMessage("绑定银行卡失败");
			}
			
		} catch (Exception e) {
			header.setErrorCode(ErrorCode.INSERT_EXCEPTION);
			header.setMessage("绑定银行卡异常");
		}
		response.setResponseHeader(header);
		return response;
	}

	@Override
	public RestResponse queryUserPayList(String sessionId) throws Exception {
		RestResponse response = new RestResponse();
		ResponseHeader header = new ResponseHeader();
		
		UserSession userSession = null;
		LoginUser loginUser = null;
		List<UserPay> userPayList = null;
		try {
			userSession = this.userSessionAtomService.queryBySessionId(sessionId);
			if(null != userSession){
				loginUser = this.loginUserAtomService.queryLoginUserByUsername(userSession.getUsername());
				Long userBaseId = loginUser.getUserId();
				UserPay userPay = new UserPay();
				userPay.setUserId(userBaseId);
				userPay.setStatus(Constant.USERPAY_STATUS_ENABLED);
				userPayList = this.userPayAtomService.queryUserPayListByUserID(userPay);
				if(null == userPayList || userPayList.size() <= 0){
					logger.info("查询用户绑定银行卡信息结果为空");
					header.setErrorCode(ErrorCode.NULL_OR_BLACK);
					header.setMessage("查询用户绑定银行卡信息结果为空");
				}else{
					logger.info("查询用户绑定银行卡信息成功");
					header.setErrorCode(ErrorCode.SUCCESS);
					header.setMessage("查询用户绑定银行卡信息成功");
					response.setResponseBody(userPayList);
				}
			}else{
				logger.info("用户未登录,请先登录");
				header.setMessage("用户未登录,请先登录");
				header.setErrorCode(ErrorCode.USER_NOT_LOGIN);
			}
		} catch (Exception e) {
			logger.error("查询用户绑定银行卡信息异常, 异常信息是:" + e.getLocalizedMessage(), e);
			header.setErrorCode(ErrorCode.QUERY_EXCEPTION);
			header.setMessage("查询用户绑定银行卡信息异常");
		}
		response.setResponseHeader(header);
		return response;
	}

	
	
}
