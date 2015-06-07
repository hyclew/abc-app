package com.kingteller.bs.rest;

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
import com.kingteller.bs.domain.order.UserOrderAddress;
import com.kingteller.bs.domain.order.UserSessionAndUserAddressDomain;
import com.kingteller.bs.framework.json.Json2Object;
import com.kingteller.bs.framework.rest.ErrorCode;
import com.kingteller.bs.framework.rest.ResponseHeader;
import com.kingteller.bs.framework.rest.RestResponse;
import com.kingteller.bs.service.UserOrderAddressService;
import com.kingteller.bs.service.UserService;

/**
 * 洗车相关操作的Controller
 * 
 * @author wangyafei
 *
 */
@RestController
@RequestMapping("/orderaddress")
public class UserOrderAddressController {

	private static final Logger logger = Logger
			.getLogger(UserOrderAddressController.class);

	@Autowired
	private UserOrderAddressService userOrderAddressService;

	@Autowired
	private UserService userService;

	/**
	 * 获取用户的订单收货地址
	 * 
	 * @param sessionId
	 * @return
	 */
	@RequestMapping(value = "/getaddresses/{sessionId}", method = RequestMethod.GET)
	public RestResponse userOrderAddresses(@PathVariable String sessionId) {
		logger.info("开始查询用户的收货地址信息,SessionId是 " + sessionId);
		RestResponse response = new RestResponse();
		ResponseHeader header = new ResponseHeader();
		response.setResponseHeader(header);
		try {
			if (null == sessionId || "".equals(sessionId)) {
				response.getResponseHeader().setErrorCode(
						ErrorCode.PARAMS_ERROR);
				response.getResponseHeader().setMessage("查询收货人信息SessionId不能为空");
			} else {
				response = this.userOrderAddressService
						.getUserOrderAddresses(sessionId);
			}
		} catch (Exception e) {
			logger.error("查询用户收获地址异常,异常信息是:" + e.getLocalizedMessage(), e);
			response.getResponseHeader()
					.setErrorCode(ErrorCode.QUERY_EXCEPTION);
			response.getResponseHeader().setMessage("查询用户收获地址异常");
			e.printStackTrace();
		}
		return response;
	}

	@RequestMapping(value = "/addaddress", method = RequestMethod.POST)
	public @ResponseBody RestResponse addUserAddress(
			@RequestBody String userAddressDomain) {
		logger.info("开始添加收货人信息,收货人信息是:" + userAddressDomain);
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
					logger.info("传入收货人信息不能为空");
					response.getResponseHeader().setMessage("传入收货人信息不能为空");
					response.getResponseHeader().setErrorCode(
							ErrorCode.PARAMS_ERROR);
				} else if(null == userOrderAddress.getAddress() || "".equals(userOrderAddress.getAddress())){
					logger.info("收货人地址不能为空");
					response.getResponseHeader().setMessage("收货人地址不能为空");
					response.getResponseHeader().setErrorCode(
							ErrorCode.PARAMS_ERROR);
				} else if(null == userOrderAddress.getName() || "".equals(userOrderAddress.getName())){
					logger.info("收货人名字不能为空");
					response.getResponseHeader().setMessage("收货人名字不能为空");
					response.getResponseHeader().setErrorCode(
							ErrorCode.PARAMS_ERROR);
				} else if(null == userOrderAddress.getPhone() || "".equals(userOrderAddress.getPhone()) || !userOrderAddress.getPhone().matches("[0-9]{11}")){
					logger.info("收货人电话不正确");
					response.getResponseHeader().setMessage("收货人电话不正确");
					response.getResponseHeader().setErrorCode(
							ErrorCode.PARAMS_ERROR);
				} else{
					response = this.userOrderAddressService.insertUserOrderAddress(sessionId, userOrderAddress);
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

}
