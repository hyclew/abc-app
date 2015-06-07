package com.kingteller.bs.rest;

import java.util.Calendar;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.kingteller.bs.domain.appointment.CustomerAppointment;
import com.kingteller.bs.domain.appointment.CustomerAppointmentSessionDomain;
import com.kingteller.bs.domain.order.UserOrderAddress;
import com.kingteller.bs.domain.order.UserSessionAndUserAddressDomain;
import com.kingteller.bs.framework.json.Json2Object;
import com.kingteller.bs.framework.rest.ErrorCode;
import com.kingteller.bs.framework.rest.ResponseHeader;
import com.kingteller.bs.framework.rest.RestResponse;
import com.kingteller.bs.service.CustomerAppointmentService;
import com.kingteller.bs.service.UserService;

@RestController
@RequestMapping("/appointment")
public class CustomerAppointmentController {

	private static final Logger logger = Logger
			.getLogger(CustomerAppointmentController.class);
	
	@Autowired
	private CustomerAppointmentService customerAppointmentService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/addappointment", method = RequestMethod.POST)
	public @ResponseBody RestResponse addAppointment(
			@RequestBody String customerAppointmentSessionDomainStr) {
		logger.info("开始提交用户预约信息,传入参数为:" + customerAppointmentSessionDomainStr);
		RestResponse response = new RestResponse();
		ResponseHeader header = new ResponseHeader();
		response.setResponseHeader(header);
		CustomerAppointmentSessionDomain customerAppointmentSessionDomain = null;
		try {
			customerAppointmentSessionDomain = (CustomerAppointmentSessionDomain) Json2Object
					.deserializeObject(customerAppointmentSessionDomainStr,
							CustomerAppointmentSessionDomain.class);
			boolean isLogin = false;
			// 判断用户是否登录
			if (null != customerAppointmentSessionDomain
					&& null != customerAppointmentSessionDomain.getSessionId()
					&& !"".equals(customerAppointmentSessionDomain.getSessionId())) {
				isLogin = this.userService.isLogin(customerAppointmentSessionDomain
						.getSessionId());
			}
			if(isLogin){
				CustomerAppointment customerAppointment = customerAppointmentSessionDomain.getCustomerAppointment();
				if(null == customerAppointment){
					logger.info("预约信息不能为空");
					response.getResponseHeader().setMessage("预约信息不能为空");
					response.getResponseHeader().setErrorCode(
							ErrorCode.PARAMS_ERROR);
				}else if(null == customerAppointment.getProductCatalogId()){
					logger.info("预约商品类别不能为空");
					response.getResponseHeader().setMessage("预约商品类别不能为空");
					response.getResponseHeader().setErrorCode(
							ErrorCode.PARAMS_ERROR);
				}else if(null == customerAppointment.getAppointComment()){
					logger.info("预约商品描述不能为空");
					response.getResponseHeader().setMessage("预约商品描述不能为空");
					response.getResponseHeader().setErrorCode(
							ErrorCode.PARAMS_ERROR);
				}else if(null == customerAppointment.getAppointStartTime()){
					logger.info("预约开始时间不能为空");
					response.getResponseHeader().setMessage("预约开始时间不能为空");
					response.getResponseHeader().setErrorCode(
							ErrorCode.PARAMS_ERROR);
				}else if(null == customerAppointment.getAppointEndTime()){
					logger.info("预约结束时间不能为空");
					response.getResponseHeader().setMessage("预约结束时间不能为空");
					response.getResponseHeader().setErrorCode(
							ErrorCode.PARAMS_ERROR);
				}else{
					Calendar startTime = Calendar.getInstance();
					Calendar endTime = Calendar.getInstance();
					startTime.setTime(customerAppointment.getAppointStartTime());
					endTime.setTime(customerAppointment.getAppointEndTime());
					if(endTime.before(startTime)){
						logger.info("预约结束时间不能在预约开始时间之前");
						response.getResponseHeader().setMessage("预约结束时间不能在预约开始时间之前");
						response.getResponseHeader().setErrorCode(
								ErrorCode.PARAMS_ERROR);
					}else {
						response = this.customerAppointmentService.insertAppointment(customerAppointmentSessionDomain);
					}
				}
			}else{
				logger.info("用户未登录,请先登录");
				response.getResponseHeader().setMessage("用户未登录,请先登录");
				response.getResponseHeader().setErrorCode(
						ErrorCode.USER_NOT_LOGIN);
			}
		} catch (JsonParseException e) {
			logger.error("提交用户预约信息失败，失败原因是:" + e.getLocalizedMessage(), e);
			response.getResponseHeader().setMessage("提交用户预约信息失败，原因为传入参数解析有误");
			response.getResponseHeader().setErrorCode(
					ErrorCode.INSERT_EXCEPTION);
			e.printStackTrace();
		} catch (JsonMappingException e) {
			logger.error("提交用户预约信息失败，失败原因是:" + e.getLocalizedMessage(), e);
			response.getResponseHeader().setMessage("提交用户预约信息失败，原因为传入参数解析有误");
			response.getResponseHeader().setErrorCode(
					ErrorCode.INSERT_EXCEPTION);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error("提交用户预约信息失败，失败原因是:" + e.getLocalizedMessage(), e);
			response.getResponseHeader().setMessage("提交用户预约信息失败");
			response.getResponseHeader().setErrorCode(
					ErrorCode.INSERT_EXCEPTION);
			e.printStackTrace();
		}
		return response;
	}
	
	@RequestMapping(value = "/getappointments/{sessionId}", method = RequestMethod.GET)
	public RestResponse userUserAppointments(@PathVariable String sessionId) {
		logger.info("开始查询用户的预约地址信息,SessionId是 " + sessionId);
		RestResponse response = new RestResponse();
		ResponseHeader header = new ResponseHeader();
		response.setResponseHeader(header);
		try {
			boolean isLogin = false;
			// 判断用户是否登录
			if (null != sessionId && !"".equals(sessionId)) {
				isLogin = this.userService.isLogin(sessionId);
			}
			if(isLogin){
				response = this.customerAppointmentService.getCustomerAppointments(sessionId);
			}else{
				logger.info("用户未登录,请先登录");
				response.getResponseHeader().setMessage("用户未登录,请先登录");
				response.getResponseHeader().setErrorCode(
						ErrorCode.USER_NOT_LOGIN);
			}
		} catch (Exception e) {
			logger.error("查询用户预约信息失败，失败原因是:" + e.getLocalizedMessage(), e);
			response.getResponseHeader().setMessage("查询用户预约信息失败");
			response.getResponseHeader().setErrorCode(
					ErrorCode.QUERY_EXCEPTION);
			e.printStackTrace();
		}
		return response;
	}
	
	/**
	 * 插入预约地址信息
	 * @param userAddressDomain
	 * @return
	 */
	@RequestMapping(value = "/addaddress", method = RequestMethod.POST)
	public @ResponseBody RestResponse addUserAddress(
			@RequestBody String userAddressDomain) {
		logger.info("开始添加预约收货人信息,收货人信息是:" + userAddressDomain);
		RestResponse response = new RestResponse();
		ResponseHeader header = new ResponseHeader();
		response.setResponseHeader(header);
		UserSessionAndUserAddressDomain userSessionAndUserAddressDomain = null;
		String sessionId = null;
		try {
			userSessionAndUserAddressDomain = (UserSessionAndUserAddressDomain) Json2Object
					.deserializeObject(userAddressDomain,
							UserSessionAndUserAddressDomain.class);
			boolean isLogin = false;
			// 判断用户是否登录
			if (null != userSessionAndUserAddressDomain) {
				sessionId = userSessionAndUserAddressDomain.getUserSession().getSessionId();
				if (null != sessionId && !"".equals(sessionId)) {
					// 根据SessionId判断用户是否处于登录状态
					isLogin = this.userService.isLogin(sessionId);
				} else {
					logger.info("SessionId不存在,用户未登录");
					response.getResponseHeader().setMessage(
							"SessionId不存在,用户未登录");
					response.getResponseHeader().setErrorCode(
							ErrorCode.USER_NOT_LOGIN);
				}
			}
			if(isLogin){
				UserOrderAddress userOrderAddress = userSessionAndUserAddressDomain.getUserOrderAddress();
				if(null == userOrderAddress){
					logger.info("传入地址信息不能为空");
					response.getResponseHeader().setMessage("传入地址信息不能为空");
					response.getResponseHeader().setErrorCode(
							ErrorCode.PARAMS_ERROR);
				} else if(null == userOrderAddress.getAddress() || "".equals(userOrderAddress.getAddress())){
					logger.info("预约地址不能为空");
					response.getResponseHeader().setMessage("预约地址不能为空");
					response.getResponseHeader().setErrorCode(
							ErrorCode.PARAMS_ERROR);
				} else if(null == userOrderAddress.getName() || "".equals(userOrderAddress.getName())){
					logger.info("预约人姓名不能为空");
					response.getResponseHeader().setMessage("预约人姓名不能为空");
					response.getResponseHeader().setErrorCode(
							ErrorCode.PARAMS_ERROR);
				} else if(null == userOrderAddress.getPhone() || "".equals(userOrderAddress.getPhone()) || !userOrderAddress.getPhone().matches("[0-9]{11}")){
					logger.info("预约人电话不正确");
					response.getResponseHeader().setMessage("预约人电话不正确");
					response.getResponseHeader().setErrorCode(
							ErrorCode.PARAMS_ERROR);
				} else{
					response = this.customerAppointmentService.insertUserAppointmentAddress(sessionId, userOrderAddress);
				}
			}else{
				logger.info("用户未登录,请先登录");
				response.getResponseHeader().setMessage("用户未登录,请先登录");
				response.getResponseHeader().setErrorCode(
						ErrorCode.USER_NOT_LOGIN);
			}
		} catch (JsonParseException e) {
			logger.error("添加新地址失败,失败原因是:" + e.getLocalizedMessage(), e);
			response.getResponseHeader().setMessage("添加新地址失败,原因为传入参数解析有误");
			response.getResponseHeader().setErrorCode(
					ErrorCode.INSERT_EXCEPTION);
			e.printStackTrace();
		} catch (JsonMappingException e) {
			logger.error("添加新地址失败,失败原因是:" + e.getLocalizedMessage(), e);
			response.getResponseHeader().setMessage("添加新地址失败,原因为传入参数解析有误");
			response.getResponseHeader().setErrorCode(
					ErrorCode.INSERT_EXCEPTION);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error("添加新地址失败,失败原因是:" + e.getLocalizedMessage(), e);
			response.getResponseHeader().setMessage("添加新地址失败");
			response.getResponseHeader().setErrorCode(
					ErrorCode.INSERT_EXCEPTION);
			e.printStackTrace();
		}
		return response;
	}
	
	/**
	 * 获取用户的订单收货地址
	 * 
	 * @param sessionId
	 * @return
	 */
	@RequestMapping(value = "/getaddresses/{sessionId}", method = RequestMethod.GET)
	public RestResponse userOrderAddresses(@PathVariable String sessionId) {
		logger.info("开始查询用户的预约地址信息,SessionId是 " + sessionId);
		RestResponse response = new RestResponse();
		ResponseHeader header = new ResponseHeader();
		response.setResponseHeader(header);
		try {
			if (null == sessionId || "".equals(sessionId)) {
				response.getResponseHeader().setErrorCode(
						ErrorCode.PARAMS_ERROR);
				response.getResponseHeader().setMessage("查询预约地址信息SessionId不能为空");
			} else {
				response = this.customerAppointmentService
						.getUserAppointmentAddresses(sessionId);
			}
		} catch (Exception e) {
			logger.error("查询用户预约地址异常,异常信息是:" + e.getLocalizedMessage(), e);
			response.getResponseHeader()
					.setErrorCode(ErrorCode.QUERY_EXCEPTION);
			response.getResponseHeader().setMessage("查询用户预约地址异常");
			e.printStackTrace();
		}
		return response;
	}
	
	
}
