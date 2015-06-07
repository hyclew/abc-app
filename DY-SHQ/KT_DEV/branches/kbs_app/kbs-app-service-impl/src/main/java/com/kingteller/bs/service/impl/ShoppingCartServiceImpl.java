package com.kingteller.bs.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kingteller.bs.domain.business.BusinessProduct;
import com.kingteller.bs.domain.cart.BusinessCartDomain;
import com.kingteller.bs.domain.cart.ShoppingCart;
import com.kingteller.bs.domain.cart.ShoppingCartDomain;
import com.kingteller.bs.domain.user.LoginUser;
import com.kingteller.bs.domain.user.UserSession;
import com.kingteller.bs.framework.constant.Constant;
import com.kingteller.bs.framework.rest.ErrorCode;
import com.kingteller.bs.framework.rest.ResponseHeader;
import com.kingteller.bs.framework.rest.RestResponse;
import com.kingteller.bs.service.ShoppingCartService;
import com.kingteller.bs.service.inner.business.BusinessProductAtomService;
import com.kingteller.bs.service.inner.cart.ShoppingCartAtomService;
import com.kingteller.bs.service.inner.user.LoginUserAtomService;
import com.kingteller.bs.service.inner.user.UserSessionAtomService;

@Component("shoppingCartService")
public class ShoppingCartServiceImpl implements ShoppingCartService {

	private static final Logger logger = Logger
			.getLogger(ShoppingCartServiceImpl.class);
	
	@Autowired
	private ShoppingCartAtomService shoppingCartAtomService;
	
	@Autowired
	private UserSessionAtomService userSessionAtomService;
	
	@Autowired
	private LoginUserAtomService loginUserAtomService;
	
	@Autowired
	private BusinessProductAtomService businessProductAtomService;

	

	@Override
	public RestResponse addToShoppingCart(ShoppingCartDomain shoppingCartDomain)
			throws Exception {
		RestResponse response = new RestResponse();
		ResponseHeader header = new ResponseHeader();
		ShoppingCart shoppingCart = null;
		try {
			shoppingCart = shoppingCartDomain.getShoppingCart();
			//查找userBaseId
			String sessionId = shoppingCartDomain.getSessionId();
			UserSession userSession = this.userSessionAtomService.queryBySessionId(sessionId);
			if(null != userSession){
				String username = userSession.getUsername();
				logger.info("根据SessionId " + sessionId + " 查找到的用户名是 " + username);
				LoginUser loginUser = this.loginUserAtomService.queryLoginUserByUsername(username);
				
				shoppingCart.setUserBaseId(loginUser.getUserId());
				shoppingCart.setIsOrdered(Constant.CART_IS_ORDERED_NO);
				shoppingCart.setStatus(Constant.CART_STATUS_ENABLED);

				int count = this.shoppingCartAtomService
						.updateCart4Count(shoppingCart);

				// 如果有数据被更新，说明此商品已经被此用户添加进购物车，无需再次添加
				if (count > 0) {
					logger.info("加入购物车成功");
					header.setErrorCode(ErrorCode.SUCCESS);
					header.setMessage("加入购物车成功");
				} else { // 否则再在购物车中加入一条信息
					boolean flag = this.shoppingCartAtomService
							.insertShoppingCart(shoppingCart);
					if (flag) {
						logger.info("加入购物车成功");
						header.setErrorCode(ErrorCode.SUCCESS);
						header.setMessage("加入购物车成功");
					} else {
						logger.info("没有任何商品被添加到购物车");
						header.setErrorCode(ErrorCode.OPERATE_FAIL);
						header.setMessage("没有任何商品被添加到购物车");
					}
				}
			}else{
				logger.info("添加购物车有误,SessionId已失效,请重新登录");
				logger.info("没有任何商品被添加到购物车");
				header.setErrorCode(ErrorCode.USER_NOT_LOGIN);
				header.setMessage("添加购物车有误,SessionId已失效，请重新登录");
			}
		} catch (Exception e) {
			logger.error("加入购物车失败,失败信息是:" + e.getLocalizedMessage(), e);
			header.setErrorCode(ErrorCode.INSERT_EXCEPTION);
			header.setMessage("加入购物车发生异常");
		}
		response.setResponseHeader(header);
		// 如果加入购物车成功，返回购物车商品数量
		if (ErrorCode.SUCCESS.equals(header.getErrorCode())) {
			Integer cartCount = this.shoppingCartAtomService
					.queryCartCount(shoppingCart);
			response.setResponseBody(cartCount);
		} else {
			response.setResponseBody(null);
		}
		return response;
	}

	public RestResponse updateCartCountById(ShoppingCart shoppingCart)
			throws Exception {
		RestResponse response = new RestResponse();
		ResponseHeader header = new ResponseHeader();
		try {
			int count = this.shoppingCartAtomService
					.updateCartCountById(shoppingCart);
			if (count <= 0) {
				logger.info("没有购物车被更新:" + shoppingCart);
				header.setErrorCode(ErrorCode.OPERATE_FAIL);
				header.setMessage("没有购物车被更新");
			} else {
				logger.info("更新购物车成功:" + shoppingCart);
				header.setErrorCode(ErrorCode.SUCCESS);
				header.setMessage("更新购物车成功");
			}
		} catch (Exception e) {
			logger.error("更新购物车失败,异常信息是:" + e.getLocalizedMessage(), e);
			header.setErrorCode(ErrorCode.INSERT_EXCEPTION);
			header.setMessage("更新购物车发生异常");
		}
		response.setResponseHeader(header);
		return response;
	}

	@Override
	public RestResponse getUserCarts(String sessionId) throws Exception {
		RestResponse response = new RestResponse();
		ResponseHeader header = new ResponseHeader();
		try {
			UserSession userSession = this.userSessionAtomService.queryBySessionId(sessionId);
			logger.info("根据SessionId " + sessionId + " 查找到的UserSession是 " + userSession);
			if(null != userSession){
				String username = userSession.getUsername();
				LoginUser loginUser = this.loginUserAtomService.queryLoginUserByUsername(username);
				logger.info("根据username " + username + " 查找到的LoginUser是 " + loginUser);
				Long userBaseId = loginUser.getUserId();
				
				ShoppingCart shoppingCart = new ShoppingCart();
				shoppingCart.setUserBaseId(userBaseId);
				shoppingCart.setIsOrdered(Constant.CART_IS_ORDERED_NO);
				shoppingCart.setStatus(Constant.CART_STATUS_ENABLED);
				
				List<ShoppingCart> carts = this.shoppingCartAtomService.queryCartsByUserId(shoppingCart);
				
				if(null == carts || carts.size() == 0){
					logger.info("根据SessionId " + sessionId + "未查询到购物车信息");
					header.setErrorCode(ErrorCode.NULL_OR_BLACK);
					header.setMessage("未查询到购物车信息");
				}else{
					List<BusinessCartDomain> businessCart = new ArrayList<BusinessCartDomain>();
					for(ShoppingCart cart: carts){
						logger.info("购物车信息是 " + cart);
						Long productId = cart.getBusinessProductId();
						logger.info("查看购物车中商品的ID是 " + productId);
						BusinessProduct bp = this.businessProductAtomService.getBusinessProductDetail(productId);
						logger.info("购物车中的商品是 " + bp);
						BusinessCartDomain bcd = new BusinessCartDomain();
						bcd.setCartId(cart.getId());
						bcd.setBusinessProductId(bp.getId());
						bcd.setBusinessProductCatalogId(bp.getProductCatalogueId());
						bcd.setProductName(bp.getName());
						bcd.setCount(cart.getCount());
						bcd.setProductIntroduce(bp.getIntroduce());
						bcd.setProductSalePrice(bp.getSalePrice());
						bcd.setProductPreferPrice(bp.getPreferPrice());
						bcd.setResourceId(bp.getResourceId());
						businessCart.add(bcd);
					}
					response.setResponseBody(businessCart);
					header.setErrorCode(ErrorCode.SUCCESS);
					header.setMessage("查询购物车成功");
				}
			}else{
				header.setErrorCode(ErrorCode.USER_NOT_LOGIN);
				header.setMessage("SessionId不存在");
			}
		} catch (Exception e) {
			logger.error("查询购物车异常,异常信息是:" + e.getLocalizedMessage(), e);
			header.setErrorCode(ErrorCode.QUERY_EXCEPTION);
			header.setMessage("查询购物车发生异常");
		}
		
		response.setResponseHeader(header);
		return response;
	}

	@Override
	public int deleteUserCarts(ShoppingCart shoppingCart) throws Exception {
		try {
			return this.shoppingCartAtomService.updateCart2Disabled(shoppingCart);
		} catch (Exception e) {
			logger.error("删除购物车异常,异常信息是:" + e.getLocalizedMessage(), e);
		}
		return 0;
	}

	@Override
	public RestResponse deleteUserCartsList(List<ShoppingCart> shoppingCartList)
			throws Exception {
		RestResponse response = new RestResponse();
		ResponseHeader header = new ResponseHeader();
		try {
			if(null != shoppingCartList && shoppingCartList.size() > 0){
				boolean flag = true;
				for(ShoppingCart shoppingCart : shoppingCartList){
					shoppingCart.setStatus(Constant.CART_STATUS_DISABLED);
					int count = this.shoppingCartAtomService.updateCart2Disabled(shoppingCart);
					if(count <= 0){
						flag = false;
					}
				}
				if(flag){
					logger.info("删除购物车成功");
					header.setErrorCode(ErrorCode.SUCCESS);
					header.setMessage("删除购物车成功");
				}else{
					logger.info("删除购物车失败");
					header.setErrorCode(ErrorCode.OPERATE_FAIL);
					header.setMessage("删除购物车失败");
				}
			}else{
				logger.info("请选择要删除的产品");
				header.setErrorCode(ErrorCode.NULL_OR_BLACK);
				header.setMessage("请选择要选择的产品");
			}
		} catch (Exception e) {
			logger.error("批量删除购物车异常,异常信息是:" + e.getLocalizedMessage(), e);
			header.setErrorCode(ErrorCode.UPDATE_EXCEPTION);
			header.setMessage("删除购物车发生异常");
		}
		response.setResponseHeader(header);
		return response;
	}
	
	

}
