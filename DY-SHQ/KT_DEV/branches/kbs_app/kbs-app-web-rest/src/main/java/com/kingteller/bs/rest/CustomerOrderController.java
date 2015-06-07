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
import com.kingteller.bs.domain.order.CustomerOrderBase;
import com.kingteller.bs.domain.order.OrderCartsDomain;
import com.kingteller.bs.domain.order.UserBaseAndSessionDomain;
import com.kingteller.bs.framework.json.Json2Object;
import com.kingteller.bs.framework.rest.ErrorCode;
import com.kingteller.bs.framework.rest.ResponseHeader;
import com.kingteller.bs.framework.rest.RestResponse;
import com.kingteller.bs.service.CustomerOrderService;
import com.kingteller.bs.service.ProductCatalogueService;
import com.kingteller.bs.service.UserService;

@RestController
@RequestMapping("/order")
public class CustomerOrderController {

	private static final Logger logger = Logger
			.getLogger(CustomerOrderController.class);

	@Autowired
	private CustomerOrderService customerOrderService;

	@Autowired
	private ProductCatalogueService productCatalogueService;

	@Autowired
	private UserService userService;

	/**
	 * 查询订单基本信息和详细信息（暂时不用）
	 * 
	 * @param sessionId
	 * @return
	 */
	@RequestMapping(value = "/userorders/{sessionId}/{detailedAduit}", method = RequestMethod.GET)
	@Deprecated
	public RestResponse getUserOrders(@PathVariable String sessionId,
			@PathVariable String detailedAduit) {
		logger.info("开始查询用户订单信息,SessionId是:" + sessionId + ", 订单状态是:"
				+ detailedAduit);
		RestResponse response = new RestResponse();
		ResponseHeader header = new ResponseHeader();
		response.setResponseHeader(header);
		try {
			if (null == sessionId || "".equals(sessionId)
					|| null == detailedAduit || "".equals(detailedAduit)) {
				response.getResponseHeader().setErrorCode(
						ErrorCode.PARAMS_ERROR);
				response.getResponseHeader().setMessage("查询订单参数不能为空");
				logger.info("查询订单参数不能为空");
			} else {
				response = customerOrderService.getUserOrders(sessionId,
						detailedAduit);
			}
		} catch (Exception e) {
			response.getResponseHeader()
					.setErrorCode(ErrorCode.QUERY_EXCEPTION);
			response.getResponseHeader().setMessage("查询用户订单出现异常");
			logger.error("查询用户订单出现异常,异常信息是:" + e.getLocalizedMessage(), e);
		}
		return response;
	}

	/**
	 * 查看订单基本信息
	 * 
	 * @param sessionId
	 * @return
	 */
	@RequestMapping(value = "/userorderbases/{sessionId}/{detailedAduit}", method = RequestMethod.GET)
	public RestResponse getUserOrderBases(@PathVariable String sessionId,
			@PathVariable String detailedAduit) {
		logger.info("开始查询用户订单列表信息,SessionId是:" + sessionId + ", 订单状态是:"
				+ detailedAduit);
		RestResponse response = new RestResponse();
		ResponseHeader header = new ResponseHeader();
		response.setResponseHeader(header);
		try {
			if (null == sessionId || "".equals(sessionId)
					|| null == detailedAduit || "".equals(detailedAduit)) {
				response.getResponseHeader().setErrorCode(
						ErrorCode.PARAMS_ERROR);
				response.getResponseHeader().setMessage("查询订单基本信息参数不能为空");
				logger.info("查询订单基本信息参数不能为空");
			} else {
				response = this.customerOrderService.getUserOrderBases(
						sessionId, detailedAduit);
			}
		} catch (Exception e) {
			response.getResponseHeader()
					.setErrorCode(ErrorCode.QUERY_EXCEPTION);
			response.getResponseHeader().setMessage("查询订单基本信息出现异常");
			logger.error("查询订单基本信息出现异常,异常信息是:" + e.getLocalizedMessage(), e);
		}
		return response;
	}

	/**
	 * 查看订单详细信息（正在使用）
	 * 
	 * @param orderBaseId
	 * @return
	 */
	@RequestMapping(value = "/orderdetaileds/{orderBaseId}", method = RequestMethod.GET)
	public RestResponse getBusinessAndOrderDetaileds(
			@PathVariable Long orderBaseId) {
		logger.info("开始查询用户订单详细信息, orderBaseId是 " + orderBaseId);
		RestResponse response = new RestResponse();
		ResponseHeader header = new ResponseHeader();
		response.setResponseHeader(header);
		try {
			if (null == orderBaseId || "".equals(orderBaseId)) {
				response.getResponseHeader().setErrorCode(
						ErrorCode.PARAMS_ERROR);
				response.getResponseHeader().setMessage("查询订单详细信息参数不能为空");
				logger.error("查询订单详细信息参数不能为空");
			} else {
				response = this.customerOrderService
						.getBusinessAndOrderDetaileds(orderBaseId);
			}
		} catch (Exception e) {
			response.getResponseHeader()
					.setErrorCode(ErrorCode.QUERY_EXCEPTION);
			response.getResponseHeader().setMessage("查询订单详细信息出现异常");
			logger.error("查询订单基本信息出现异常,异常信息是:" + e.getLocalizedMessage(), e);
		}
		return response;
	}

	/**
	 * 查询订单详细信息（已废弃）
	 * 
	 * @param orderBaseId
	 * @return
	 */
	@RequestMapping(value = "/userorderdetaileds/{orderBaseId}", method = RequestMethod.GET)
	@Deprecated
	public RestResponse getUserOrderDetaileds(@PathVariable Long orderBaseId) {
		logger.info("开始查询用户订单详细信息,orderBaseId是:" + orderBaseId);
		RestResponse response = new RestResponse();
		ResponseHeader header = new ResponseHeader();
		response.setResponseHeader(header);
		try {
			if (null == orderBaseId) {
				response.getResponseHeader().setErrorCode(
						ErrorCode.PARAMS_ERROR);
				response.getResponseHeader().setMessage("查询订单详细信息参数不能为空");
				logger.info("查询订单详细信息参数不能为空");
			} else {
				response = this.customerOrderService
						.getUserOrderDetaileds(orderBaseId);
			}
		} catch (Exception e) {
			response.getResponseHeader()
					.setErrorCode(ErrorCode.QUERY_EXCEPTION);
			response.getResponseHeader().setMessage("查询订单详细信息出现异常");
			logger.error("查询订单详细信息出现异常,异常信息是:" + e.getLocalizedMessage(), e);
		}
		return response;
	}

	/**
	 * 生成订单接口
	 * 
	 * @param userAddressDomain
	 * @return
	 */
	@RequestMapping(value = "/addorder", method = RequestMethod.POST)
	public @ResponseBody RestResponse addUserOrder(
			@RequestBody String orderCartsDomainStr) {
		logger.info("开始生成用户订单信息,传入参数是:" + orderCartsDomainStr);
		RestResponse response = new RestResponse();
		ResponseHeader header = new ResponseHeader();
		response.setResponseHeader(header);
		OrderCartsDomain orderCartsDomain = null;
		try {
			orderCartsDomain = (OrderCartsDomain) Json2Object
					.deserializeObject(orderCartsDomainStr,
							OrderCartsDomain.class);
			boolean isLogin = false;
			// 判断用户是否登录
			if (null != orderCartsDomain
					&& null != orderCartsDomain.getSessionId()
					&& !"".equals(orderCartsDomain.getSessionId())) {
				isLogin = this.userService.isLogin(orderCartsDomain
						.getSessionId());
			}
			if (isLogin) {
				if (null == orderCartsDomain) {
					response.getResponseHeader().setMessage("传入参数不能为空");
					response.getResponseHeader().setErrorCode(
							ErrorCode.PARAMS_ERROR);
					logger.info("传入订单信息不能为空");
				} else if (null == orderCartsDomain.getSessionId()
						|| "".equals(orderCartsDomain.getSessionId())) {
					response.getResponseHeader().setMessage("SessionId不能为空");
					response.getResponseHeader().setErrorCode(
							ErrorCode.PARAMS_ERROR);
					logger.info("SessionId不能为空");
				} else if (null == orderCartsDomain.getBusinessCartDomain()
						|| orderCartsDomain.getBusinessCartDomain().size() <= 0) {
					response.getResponseHeader().setMessage("商品信息不能为空");
					response.getResponseHeader().setErrorCode(
							ErrorCode.PARAMS_ERROR);
					logger.info("商品信息不能为空");
				} else if (null == orderCartsDomain.getCustomerOrderBase()) {
					response.getResponseHeader().setMessage("订单基本信息不能为空");
					response.getResponseHeader().setErrorCode(
							ErrorCode.PARAMS_ERROR);
					logger.info("订单基本信息不能为空");
				} else if (null == orderCartsDomain.getUserOrderAddress()) {
					response.getResponseHeader().setMessage("收货人信息不能为空");
					response.getResponseHeader().setErrorCode(
							ErrorCode.PARAMS_ERROR);
					logger.info("收货人信息不能为空");
				} else {
					response = this.customerOrderService
							.generateUserOrder(orderCartsDomain);
				}
			} else {
				logger.info("用户未登录,请先登录");
				response.getResponseHeader().setMessage("用户未登录,请先登录");
				response.getResponseHeader().setErrorCode(
						ErrorCode.USER_NOT_LOGIN);
			}
		} catch (JsonParseException e) {
			logger.error("生成用户订单失败，失败原因是:" + e.getLocalizedMessage(), e);
			response.getResponseHeader().setMessage("生成用户订单失败，原因为传入参数解析有误");
			response.getResponseHeader().setErrorCode(
					ErrorCode.INSERT_EXCEPTION);
			e.printStackTrace();
		} catch (JsonMappingException e) {
			logger.error("生成用户订单失败，失败原因是:" + e.getLocalizedMessage(), e);
			response.getResponseHeader().setMessage("生成用户订单失败，原因为传入参数解析有误");
			response.getResponseHeader().setErrorCode(
					ErrorCode.INSERT_EXCEPTION);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error("生成用户订单失败，失败原因是:" + e.getLocalizedMessage(), e);
			response.getResponseHeader().setMessage("生成用户订单失败");
			response.getResponseHeader().setErrorCode(
					ErrorCode.INSERT_EXCEPTION);
			e.printStackTrace();
		}
		return response;
	}

	/**
	 * 用户取消订单
	 * @param userBaseAndSessionDomainStr
	 * @return
	 */
	@RequestMapping(value = "/deleteorder", method = RequestMethod.POST)
	public @ResponseBody RestResponse deleteUserOrder(
			@RequestBody String userBaseAndSessionDomainStr) {
		logger.info("开始删除用户订单,传入参数是:" + userBaseAndSessionDomainStr);
		RestResponse response = new RestResponse();
		ResponseHeader header = new ResponseHeader();
		response.setResponseHeader(header);
		UserBaseAndSessionDomain userBaseAndSessionDomain = null;

		try {
			userBaseAndSessionDomain = (UserBaseAndSessionDomain) Json2Object
					.deserializeObject(userBaseAndSessionDomainStr,
							UserBaseAndSessionDomain.class);
			boolean isLogin = false;
			// 判断用户是否登录
			if (null != userBaseAndSessionDomain
					&& null != userBaseAndSessionDomain.getSessionId()
					&& !"".equals(userBaseAndSessionDomain.getSessionId())) {
				isLogin = this.userService.isLogin(userBaseAndSessionDomain
						.getSessionId());
			}
			if (isLogin) {
				CustomerOrderBase customerOrderBase = userBaseAndSessionDomain.getCustomerOrderBase();
				if (null == customerOrderBase) {
					response.getResponseHeader().setMessage("传入参数不能为空");
					response.getResponseHeader().setErrorCode(
							ErrorCode.PARAMS_ERROR);
					logger.info("传入参数不能为空");
				} else if (null == customerOrderBase.getId()) {
					response.getResponseHeader().setMessage("请选择要删除的订单");
					response.getResponseHeader().setErrorCode(
							ErrorCode.PARAMS_ERROR);
					logger.info("请选择要删除的订单");
				} else {
					response = this.customerOrderService
							.deleteUserOrder(customerOrderBase);
				}
			}else{
				logger.info("用户未登录,请先登录");
				response.getResponseHeader().setMessage("用户未登录,请先登录");
				response.getResponseHeader().setErrorCode(
						ErrorCode.USER_NOT_LOGIN);
			}
		} catch (JsonParseException e) {
			logger.error("生成用户订单失败，失败原因是:" + e.getLocalizedMessage(), e);
			response.getResponseHeader().setMessage("生成用户订单失败，原因为传入参数解析有误");
			response.getResponseHeader().setErrorCode(
					ErrorCode.INSERT_EXCEPTION);
			e.printStackTrace();
		} catch (JsonMappingException e) {
			logger.error("生成用户订单失败，失败原因是:" + e.getLocalizedMessage(), e);
			response.getResponseHeader().setMessage("生成用户订单失败，原因为传入参数解析有误");
			response.getResponseHeader().setErrorCode(
					ErrorCode.INSERT_EXCEPTION);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error("生成用户订单失败，失败原因是:" + e.getLocalizedMessage(), e);
			response.getResponseHeader().setMessage("生成用户订单失败");
			response.getResponseHeader().setErrorCode(
					ErrorCode.INSERT_EXCEPTION);
			e.printStackTrace();
		}
		return response;
	}

}
