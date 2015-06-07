package com.kingteller.bs.rest;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.kingteller.bs.domain.cart.ShoppingCart;
import com.kingteller.bs.domain.cart.ShoppingCartDomain;
import com.kingteller.bs.domain.cart.ShoppingCartListDomain;
import com.kingteller.bs.framework.constant.Constant;
import com.kingteller.bs.framework.json.Json2Object;
import com.kingteller.bs.framework.rest.ErrorCode;
import com.kingteller.bs.framework.rest.ResponseHeader;
import com.kingteller.bs.framework.rest.RestResponse;
import com.kingteller.bs.service.ShoppingCartService;
import com.kingteller.bs.service.UserService;

@RestController
@RequestMapping("/shoppingcart")
public class ShoppingCartController {

	private static final Logger logger = Logger
			.getLogger(ShoppingCartController.class);

	@Autowired
	private ShoppingCartService shoppingCartService;

	@Autowired
	private UserService userService;

	/**
	 * 将商品加入购物车
	 * 
	 * @return
	 */
	@RequestMapping(value = "/addcart", method = RequestMethod.POST)
	public @ResponseBody RestResponse addToShoppingCart(
			@RequestBody String cartDomail) {
		logger.info("开始添加购物车,购物车信息是:" + cartDomail);
		RestResponse response = new RestResponse();
		ResponseHeader header = new ResponseHeader();
		response.setResponseHeader(header);
		ShoppingCartDomain shoppingCartDomain = null;
		try {
			shoppingCartDomain = (ShoppingCartDomain) Json2Object
					.deserializeObject(cartDomail, ShoppingCartDomain.class);
			boolean isLogin = false;
			// 判断用户是否登录
			if (null != shoppingCartDomain) {
				String sessionId = shoppingCartDomain.getSessionId();
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
			// 如果用户已经登录,就添加购物车
			if (isLogin) {
				if (null == shoppingCartDomain.getShoppingCart()
						|| null == shoppingCartDomain.getShoppingCart()
								.getBusinessProductId()
						|| null == shoppingCartDomain.getShoppingCart()
								.getCount()
						|| shoppingCartDomain.getShoppingCart().getCount() <= 0) {
					logger.info("产品ID或产品数量不能为空");
					response.getResponseHeader().setMessage("产品ID或产品数量不能为空");
					response.getResponseHeader().setErrorCode(
							ErrorCode.OPERATE_FAIL);
				} else {
					response = this.shoppingCartService
							.addToShoppingCart(shoppingCartDomain);
				}
			} else {
				logger.info("用户未登录,请先登录");
				response.getResponseHeader().setMessage("用户未登录,请先登录");
				response.getResponseHeader().setErrorCode(
						ErrorCode.USER_NOT_LOGIN);
			}
		} catch (JsonParseException e) {
			logger.error("加入购物车失败，失败原因是:" + e.getLocalizedMessage(), e);
			response.getResponseHeader().setMessage("加入购物车失败，原因为传入参数解析有误");
			response.getResponseHeader().setErrorCode(
					ErrorCode.INSERT_EXCEPTION);
			e.printStackTrace();
		} catch (JsonMappingException e) {
			logger.error("加入购物车失败，失败原因是:" + e.getLocalizedMessage(), e);
			response.getResponseHeader().setMessage("加入购物车失败，原因为传入参数解析有误");
			response.getResponseHeader().setErrorCode(
					ErrorCode.INSERT_EXCEPTION);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error("加入购物车失败，失败原因是:" + e.getLocalizedMessage(), e);
			response.getResponseHeader().setMessage("加入购物车失败");
			response.getResponseHeader().setErrorCode(
					ErrorCode.INSERT_EXCEPTION);
			e.printStackTrace();
		}
		return response;
	}

	/**
	 * 更新购物车
	 * 
	 * @param cart
	 * @return
	 */
	@RequestMapping(value = "/updatecart", method = RequestMethod.POST)
	public @ResponseBody RestResponse updateCart(@RequestBody String cart) {
		logger.info("开始更新购物车,购物车信息是:" + cart);
		RestResponse response = new RestResponse();
		ResponseHeader header = new ResponseHeader();
		response.setResponseHeader(header);
		ShoppingCartDomain shoppingCartDomain = null;
		try {
			shoppingCartDomain = (ShoppingCartDomain) Json2Object
					.deserializeObject(cart, ShoppingCartDomain.class);
			boolean isLogin = false;
			// 判断用户是否登录
			if (null != shoppingCartDomain) {
				String sessionId = shoppingCartDomain.getSessionId();
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
			if (isLogin) {
				ShoppingCart shoppingCart = shoppingCartDomain
						.getShoppingCart();
				if (null == shoppingCart) {
					logger.info("传入购物车信息不能为空");
					response.getResponseHeader().setMessage("传入购物车信息不能为空");
					response.getResponseHeader().setErrorCode(
							ErrorCode.PARAMS_ERROR);
				} else if (null == shoppingCart.getId()) {
					logger.info("传入购物车ID不能为空");
					response.getResponseHeader().setMessage("传入购物车ID不能为空");
					response.getResponseHeader().setErrorCode(
							ErrorCode.PARAMS_ERROR);
				} else if (null == shoppingCart.getCount()) {
					logger.info("传入商品数量不能为空");
					response.getResponseHeader().setMessage("传入商品数量不能为空");
					response.getResponseHeader().setErrorCode(
							ErrorCode.PARAMS_ERROR);
				} else {
					// 更新购物车
					response = this.shoppingCartService
							.updateCartCountById(shoppingCart);
				}
			} else {
				logger.info("用户未登录,请先登录");
				response.getResponseHeader().setMessage("用户未登录,请先登录");
				response.getResponseHeader().setErrorCode(
						ErrorCode.USER_NOT_LOGIN);
			}
		} catch (JsonParseException e) {
			logger.error("更新购物车失败，失败原因是:" + e.getLocalizedMessage(), e);
			response.getResponseHeader().setMessage("更新购物车失败，原因为传入参数解析有误");
			response.getResponseHeader().setErrorCode(
					ErrorCode.INSERT_EXCEPTION);
			e.printStackTrace();
		} catch (JsonMappingException e) {
			logger.error("更新购物车失败，失败原因是:" + e.getLocalizedMessage(), e);
			response.getResponseHeader().setMessage("更新购物车失败，原因为传入参数解析有误");
			response.getResponseHeader().setErrorCode(
					ErrorCode.INSERT_EXCEPTION);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error("更新购物车失败，失败原因是:" + e.getLocalizedMessage(), e);
			response.getResponseHeader().setMessage("更新购物车失败");
			response.getResponseHeader().setErrorCode(
					ErrorCode.INSERT_EXCEPTION);
			e.printStackTrace();
		}
		return response;
	}

	/**
	 * 用户查看购物车
	 * 
	 * @param sessionId
	 *            用户会话ID
	 * @return
	 */
	@RequestMapping(value = "/usercarts/{sessionId}", method = RequestMethod.GET)
	public RestResponse showUserCarts(@PathVariable String sessionId) {
		logger.info("开始查看购物车,用户会话ID是 " + sessionId);
		RestResponse response = new RestResponse();
		ResponseHeader header = new ResponseHeader();
		response.setResponseHeader(header);
		try {
			if (null == sessionId || "".equals(sessionId)) {
				response.getResponseHeader().setMessage("SessionId不能为空");
				response.getResponseHeader().setErrorCode(
						ErrorCode.PARAMS_ERROR);
			} else {
				response = this.shoppingCartService.getUserCarts(sessionId);
			}
		} catch (Exception e) {
			logger.error("查看购物车异常，异常信息是:" + e.getLocalizedMessage(), e);
			response.getResponseHeader().setMessage("更新购物车失败，原因为传入参数解析有误");
			response.getResponseHeader().setErrorCode(
					ErrorCode.INSERT_EXCEPTION);
			e.printStackTrace();
		}
		return response;
	}

	/**
	 * 删除购物车,其实是将购物车的状态改为不可用,不做真正的数据删除
	 * 
	 * @return
	 */
	@RequestMapping(value = "/delcart", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@Deprecated
	public void deleteUserCart(@RequestBody String cartDomail) {
		logger.info("开始单笔删除购物车,购物车信息是:" + cartDomail);
		ShoppingCartDomain shoppingCartDomain = null;
		try {
			shoppingCartDomain = (ShoppingCartDomain) Json2Object
					.deserializeObject(cartDomail, ShoppingCartDomain.class);
			boolean isLogin = false;
			// 判断用户是否登录
			if (null != shoppingCartDomain
					&& null != shoppingCartDomain.getSessionId()
					&& !"".equals(shoppingCartDomain.getSessionId())) {
				isLogin = this.userService.isLogin(shoppingCartDomain
						.getSessionId());
			}
			if (isLogin) {
				ShoppingCart shoppingCart = shoppingCartDomain
						.getShoppingCart();
				if (null != shoppingCart) {
					shoppingCart.setStatus(Constant.CART_STATUS_DISABLED);
					this.shoppingCartService.deleteUserCarts(shoppingCart);
				}
			}
		} catch (JsonParseException e) {
			logger.error("删除购物车失败，失败原因是:" + e.getLocalizedMessage(), e);
			e.printStackTrace();
		} catch (JsonMappingException e) {
			logger.error("删除购物车失败，失败原因是:" + e.getLocalizedMessage(), e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error("删除购物车失败，失败原因是:" + e.getLocalizedMessage(), e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 批量删除购物车,其实是将购物车的状态改为不可用,不做真正的数据删除
	 */
	@RequestMapping(value = "/delcartlist", method = RequestMethod.POST)
	public @ResponseBody RestResponse deleteUserCarts(@RequestBody String cartListDomain){
		logger.info("开始批量删除购物车，购物车信息是:" + cartListDomain);
		RestResponse response = new RestResponse();
		ResponseHeader header = new ResponseHeader();
		response.setResponseHeader(header);
		ShoppingCartListDomain shoppingCartListDomain = null;
		try {
			shoppingCartListDomain = (ShoppingCartListDomain) Json2Object
					.deserializeObject(cartListDomain, ShoppingCartListDomain.class);
			boolean isLogin = false;
			//判断用户是否登录
			if (null != shoppingCartListDomain
					&& null != shoppingCartListDomain.getSessionId()
					&& !"".equals(shoppingCartListDomain.getSessionId())) {
				isLogin = this.userService.isLogin(shoppingCartListDomain
						.getSessionId());
			}
			if(isLogin){
				List<ShoppingCart> shoppingCartList = shoppingCartListDomain.getShoppingCartList();
				response = this.shoppingCartService.deleteUserCartsList(shoppingCartList);
			}else{
				logger.info("用户未登录");
				response.getResponseHeader().setMessage("用户未登录");
				response.getResponseHeader().setErrorCode(
						ErrorCode.USER_NOT_LOGIN);
			}
		} catch (JsonParseException e) {
			logger.error("删除购物车失败，失败原因是:" + e.getLocalizedMessage(), e);
			response.getResponseHeader().setMessage("删除购物车失败，原因为传入参数解析有误");
			response.getResponseHeader().setErrorCode(
					ErrorCode.UPDATE_EXCEPTION);
			e.printStackTrace();
		} catch (JsonMappingException e) {
			logger.error("删除购物车失败，失败原因是:" + e.getLocalizedMessage(), e);
			response.getResponseHeader().setMessage("删除购物车失败，原因为传入参数解析有误");
			response.getResponseHeader().setErrorCode(
					ErrorCode.UPDATE_EXCEPTION);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error("删除购物车失败，失败原因是:" + e.getLocalizedMessage(), e);
			response.getResponseHeader().setMessage("删除购物车失败");
			response.getResponseHeader().setErrorCode(
					ErrorCode.UPDATE_EXCEPTION);
			e.printStackTrace();
		}
		return response;
	}

}
