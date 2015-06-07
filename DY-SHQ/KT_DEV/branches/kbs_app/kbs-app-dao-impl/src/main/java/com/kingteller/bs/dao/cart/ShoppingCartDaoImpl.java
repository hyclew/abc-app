package com.kingteller.bs.dao.cart;

import java.util.List;

import org.springframework.stereotype.Component;

import com.kingteller.bs.dao.mysql.MyBatisDao;
import com.kingteller.bs.domain.cart.ShoppingCart;

@Component("shoppingCartDao")
public class ShoppingCartDaoImpl extends MyBatisDao implements ShoppingCartDao {

	private static final String NAMESPACE = "ShoppingCart";
	
	@Override
	public boolean insertShoppingCart(ShoppingCart shoppingCart)
			throws Exception {
		int count = this.getSqlSession().insert(NAMESPACE + ".insertShoppingCart", shoppingCart);
		return count <= 0 ? false : true;
	}

	@Override
	public int updateCart4Count(ShoppingCart shoppingCart)
			throws Exception {
		return this.getSqlSession().update(NAMESPACE + ".updateCart4Count", shoppingCart);
	}

	@Override
	public int queryCartCount(ShoppingCart shoppingCart) throws Exception {
		Integer count = (Integer)this.getSqlSession().selectOne(NAMESPACE + ".queryCartCount", shoppingCart);
		return count;
	}

	@Override
	public int updateCartCountById(ShoppingCart shoppingCart) throws Exception {
		return this.getSqlSession().update(NAMESPACE + ".updateCartCountById", shoppingCart);
	}

	@Override
	public List<ShoppingCart> queryCartsByUserId(ShoppingCart shoppingCart)
			throws Exception {
		List<ShoppingCart> carts = this.getSqlSession().selectList(NAMESPACE + ".queryCartsByUserId", shoppingCart);
		return carts;
	}

	@Override
	public int updateCart2Disabled(ShoppingCart shoppingCart) throws Exception {
		return this.getSqlSession().update(NAMESPACE + ".updateCart2Disabled", shoppingCart);
	}

}
