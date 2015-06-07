package com.kingteller.bs.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kingteller.bs.domain.appointment.CustomerAppointment;
import com.kingteller.bs.domain.appointment.CustomerAppointmentSessionDomain;
import com.kingteller.bs.domain.order.UserOrderAddress;
import com.kingteller.bs.domain.user.LoginUser;
import com.kingteller.bs.domain.user.UserSession;
import com.kingteller.bs.framework.constant.Constant;
import com.kingteller.bs.framework.rest.ErrorCode;
import com.kingteller.bs.framework.rest.ResponseHeader;
import com.kingteller.bs.framework.rest.RestResponse;
import com.kingteller.bs.service.CustomerAppointmentService;
import com.kingteller.bs.service.inner.appointment.CustomerAppointmentAtomService;
import com.kingteller.bs.service.inner.order.UserOrderAddressAtomService;
import com.kingteller.bs.service.inner.user.LoginUserAtomService;
import com.kingteller.bs.service.inner.user.UserSessionAtomService;

@Component("customerAppointmentService")
public class CustomerAppointmentServiceImpl implements
		CustomerAppointmentService {

	private static final Logger logger = Logger
			.getLogger(CustomerAppointmentServiceImpl.class);
	
	@Autowired
	private CustomerAppointmentAtomService customerAppointmentAtomService;
	
	@Autowired
	private UserSessionAtomService userSessionAtomService;
	
	@Autowired
	private LoginUserAtomService loginUserAtomService;
	
	@Autowired
	private UserOrderAddressAtomService userOrderAddressAtomService;
	
	@Override
	public RestResponse insertAppointment(
			CustomerAppointmentSessionDomain customerAppointmentSessionDomain) {
		RestResponse response = new RestResponse();
		ResponseHeader header = new ResponseHeader();
		UserSession userSession = null;
		LoginUser loginUser = null;
		CustomerAppointment customerAppointment = null;
		try {
			userSession = this.userSessionAtomService
					.queryBySessionId(customerAppointmentSessionDomain.getSessionId());
			loginUser = this.loginUserAtomService
					.queryLoginUserByUsername(userSession.getUsername());
			logger.info("查询订单，获取到的登录用户为:" + loginUser);
			Long userBaseId = loginUser.getUserId();
			
			customerAppointment = customerAppointmentSessionDomain.getCustomerAppointment();
			customerAppointment.setAppointTime(new Date());
			customerAppointment.setUserId(userBaseId);
			customerAppointment = this.customerAppointmentAtomService.insertCustomerAppointment(customerAppointment);
			if(null != customerAppointment.getId() && 0 != customerAppointment.getId()){
				logger.error("提交用户预约信息成功");
				header.setErrorCode(ErrorCode.SUCCESS);
				header.setMessage("提交用户预约信息成功");
			} else{
				logger.error("提交用户预约信息失败");
				header.setErrorCode(ErrorCode.OPERATE_FAIL);
				header.setMessage("提交用户预约信息失败");
			}
		} catch (Exception e) {
			logger.error("提交用户预约信息异常,异常信息为:" + e.getLocalizedMessage(), e);
			header.setErrorCode(ErrorCode.INSERT_EXCEPTION);
			header.setMessage("提交用户预约信息异常");
		}
		response.setResponseHeader(header);
		return response;
	}
	
	@Override
	public RestResponse insertUserAppointmentAddress(String sessionId, UserOrderAddress userOrderAddress)
			throws Exception {
		RestResponse response = new RestResponse();
		ResponseHeader header = new ResponseHeader();
		UserSession userSession = null;
		LoginUser loginUser = null;
		try {
			userSession = this.userSessionAtomService.queryBySessionId(sessionId);
			loginUser = this.loginUserAtomService.queryLoginUserByUsername(userSession.getUsername());
			Long userBaseId = loginUser.getUserId();
			userOrderAddress.setUserId(userBaseId);
			userOrderAddress.setAddressType(Constant.USER_ADDRESS_TYPE_APPOINMENT);
			userOrderAddress.setStatus(Constant.USER_ADDRESS_STATUS_ENABLED);
			userOrderAddress.setUpdateTime(new Date());
			boolean flag = this.userOrderAddressAtomService.insertUserOrderAddress(userOrderAddress);
			if(flag){
				logger.info("添加收货人信息成功");
				header.setErrorCode(ErrorCode.SUCCESS);
				header.setMessage("添加收货人信息成功");
			}else{
				logger.info("添加收货人信息失败");
				header.setErrorCode(ErrorCode.OPERATE_FAIL);
				header.setMessage("添加收货人信息失败");
			}
			
		} catch (Exception e) {
			logger.error("添加收货人信息出现异常,异常信息是:" + e.getLocalizedMessage(), e);
			header.setErrorCode(ErrorCode.INSERT_EXCEPTION);
			header.setMessage("添加收货人信息出现异常");
			e.printStackTrace();
		}
		response.setResponseHeader(header);
		return response;
	}
	
	@Override
	public RestResponse getUserAppointmentAddresses(String sessionId)
			throws Exception {
		RestResponse response = new RestResponse();
		ResponseHeader header = new ResponseHeader();
		UserSession userSession = null;
		LoginUser loginUser = null;
		try {
			userSession = this.userSessionAtomService.queryBySessionId(sessionId);
			if(null != userSession){
				loginUser = this.loginUserAtomService.queryLoginUserByUsername(userSession.getUsername());
				Long userBaseId = loginUser.getUserId();
				UserOrderAddress userOrderAddress = new UserOrderAddress();
				userOrderAddress.setUserId(userBaseId);
				userOrderAddress.setAddressType(Constant.USER_ADDRESS_TYPE_APPOINMENT);
				userOrderAddress.setStatus(Constant.USER_ADDRESS_STATUS_ENABLED);
				
				List<UserOrderAddress> orderAddresses = this.userOrderAddressAtomService.queryAddressByUserId(userOrderAddress);
				if(null != orderAddresses && orderAddresses.size() > 0){
					response.setResponseBody(orderAddresses);
					header.setErrorCode(ErrorCode.SUCCESS);
					header.setMessage("查询用户预约地址信息成功");
				}else{
					header.setErrorCode(ErrorCode.NULL_OR_BLACK);
					header.setMessage("未查询到用户预约地址信息");
				}
			}else{
				header.setErrorCode(ErrorCode.USER_NOT_LOGIN);
				header.setMessage("未查询到会话信息,请重新登录");
				logger.info("未查询到会话信息,请重新登录");
			}
		} catch (Exception e) {
			logger.error("查询预约信息出现异常,异常信息是:" + e.getLocalizedMessage(), e);
			header.setErrorCode(ErrorCode.QUERY_EXCEPTION);
			header.setMessage("查询预约信息出现异常");
			e.printStackTrace();
		}
		response.setResponseHeader(header);
		return response;
	}

	@Override
	public RestResponse getCustomerAppointments(String sessionId) throws Exception {
		RestResponse response = new RestResponse();
		ResponseHeader header = new ResponseHeader();
		UserSession userSession = null;
		LoginUser loginUser = null;
		List<CustomerAppointment> customerAppointments = null;
		try {
			userSession = this.userSessionAtomService
					.queryBySessionId(sessionId);
			loginUser = this.loginUserAtomService
					.queryLoginUserByUsername(userSession.getUsername());
			logger.info("查询订单，获取到的登录用户为:" + loginUser);
			Long userBaseId = loginUser.getUserId();
			CustomerAppointment customerAppointment = new CustomerAppointment();
			customerAppointment.setUserId(userBaseId);
			customerAppointments = this.customerAppointmentAtomService.queryCustomerAppointmentByUserId(customerAppointment);
			if(null == customerAppointments || customerAppointments.size() <= 0){
				logger.info("查询用户预约信息没有任何记录");
				header.setErrorCode(ErrorCode.NULL_OR_BLACK);
				header.setMessage("查询用户预约信息没有任何记录");
			}else{
				logger.info("查询成功");
				header.setErrorCode(ErrorCode.SUCCESS);
				header.setMessage("查询成功");
				response.setResponseBody(customerAppointments);
			}
		} catch (Exception e) {
			logger.error("查询用户预约信息失败,失败原因是:" + e.getLocalizedMessage(), e);
			header.setMessage("查询用户预约信息失败");
			header.setErrorCode(ErrorCode.QUERY_EXCEPTION);
			e.printStackTrace();
		}
		response.setResponseHeader(header);
		return response;
	}

}
