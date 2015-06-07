package com.kingteller.bs.service;

import com.kingteller.bs.domain.pay.UserPaySessionDomain;
import com.kingteller.bs.framework.rest.RestResponse;

public interface UserPayService {

	/**
	 * 绑定银行卡
	 * @param userPaySessionDomain
	 * @return
	 * @throws Exception
	 */
	public RestResponse insertUserPay(UserPaySessionDomain userPaySessionDomain) throws Exception;
	
	/**
	 * 根据用户ID查询绑定银行卡信息
	 * @param userPay
	 * @return
	 * @throws Exception
	 */
	public RestResponse queryUserPayList(String sessionId) throws Exception;
	
	
}
