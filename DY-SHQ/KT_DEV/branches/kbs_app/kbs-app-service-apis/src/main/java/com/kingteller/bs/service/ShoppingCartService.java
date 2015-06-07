package com.kingteller.bs.service;

import java.util.List;

import com.kingteller.bs.domain.cart.ShoppingCart;
import com.kingteller.bs.domain.cart.ShoppingCartDomain;
import com.kingteller.bs.framework.rest.RestResponse;

/**
 * 购物车服务
 * @author wangyafei
 *
 */
public interface ShoppingCartService {

	/**
	 * 加入购物车
	 * @return
	 * @throws Exception
	 */
	public RestResponse addToShoppingCart(ShoppingCartDomain shoppingCartDomain) throws Exception;
	
	/**
	 * 更新购物车数量
	 * @param shoppingCart
	 * @return
	 * @throws Exception
	 */
	public RestResponse updateCartCountById(ShoppingCart shoppingCart)
			throws Exception;
	
	/**
	 * 查询用户的购物车商品
	 * @param sessionId
	 * @return
	 * @throws Exception
	 */
	public RestResponse getUserCarts(String sessionId) throws Exception;
	
	/**
	 * 删除购物车，实际上是将购物车商品的状态改为已删除
	 * @param shoppingCart
	 * @return
	 * @throws Exception
	 */
	public int deleteUserCarts(ShoppingCart shoppingCart) throws Exception;
	
	/**
	 * 批量删除购物车
	 * @param shoppingCartList
	 * @return
	 * @throws Exception
	 */
	public RestResponse deleteUserCartsList(List<ShoppingCart> shoppingCartList) throws Exception;
}
