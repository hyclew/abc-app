package com.kingteller.bs.dao.cart;

import java.util.List;

import com.kingteller.bs.domain.cart.ShoppingCart;

public interface ShoppingCartDao {

	/**
	 * 将商品加入购物车
	 * @param shoppingCart
	 * @return
	 * @throws Exception
	 */
	public boolean insertShoppingCart(ShoppingCart shoppingCart) throws Exception;
	
	/**
	 * 更新购物车的产品数量
	 * @param shoppingCart
	 * @return
	 * @throws Exception
	 */
	public int updateCart4Count(ShoppingCart shoppingCart) throws Exception;
	
	/**
	 * 查询某件商品在购物车中的数量
	 * @param shoppingCart
	 * @return
	 * @throws Exception
	 */
	public int queryCartCount(ShoppingCart shoppingCart) throws Exception;
	
	/**
	 * 根据购物车ID更新购物车数量
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int updateCartCountById(ShoppingCart shoppingCart) throws Exception;
	
	/**
	 * 通过userid查询未生产订单的、未被删除的商品信息
	 * @return
	 * @throws Exception
	 */
	public List<ShoppingCart> queryCartsByUserId(ShoppingCart shoppingCart) throws Exception;
	
	/**
	 * 将购物车状态改为不可用
	 * @param shoppingCart
	 * @return
	 * @throws Exception
	 */
	public int updateCart2Disabled(ShoppingCart shoppingCart) throws Exception;
}
