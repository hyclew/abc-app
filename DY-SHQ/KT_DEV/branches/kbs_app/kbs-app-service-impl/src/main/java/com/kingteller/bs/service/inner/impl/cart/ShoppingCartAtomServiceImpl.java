package com.kingteller.bs.service.inner.impl.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kingteller.bs.dao.cart.ShoppingCartDao;
import com.kingteller.bs.domain.cart.ShoppingCart;
import com.kingteller.bs.service.inner.cart.ShoppingCartAtomService;

@Component("shoppingCartAtomService")
public class ShoppingCartAtomServiceImpl implements ShoppingCartAtomService {

	@Autowired
	private ShoppingCartDao shoppingCartDao;
	
	@Override
	public boolean insertShoppingCart(ShoppingCart shoppingCart)
			throws Exception {
		return this.shoppingCartDao.insertShoppingCart(shoppingCart);
	}

	@Override
	public int updateCart4Count(ShoppingCart shoppingCart) throws Exception {
		return this.shoppingCartDao.updateCart4Count(shoppingCart);
	}

	@Override
	public int queryCartCount(ShoppingCart shoppingCart) throws Exception {
		return this.shoppingCartDao.queryCartCount(shoppingCart);
	}

	@Override
	public int updateCartCountById(ShoppingCart shoppingCart) throws Exception {
		return this.shoppingCartDao.updateCartCountById(shoppingCart);
	}

	@Override
	public List<ShoppingCart> queryCartsByUserId(ShoppingCart shoppingCart)
			throws Exception {
		return this.shoppingCartDao.queryCartsByUserId(shoppingCart);
	}

	@Override
	public int updateCart2Disabled(ShoppingCart shoppingCart) throws Exception {
		return this.shoppingCartDao.updateCart2Disabled(shoppingCart);
	}

}
