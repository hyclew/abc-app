package com.kingteller.bs.dao.pay;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.kingteller.bs.dao.mysql.MyBatisDao;
import com.kingteller.bs.dao.pay.UserPayDao;
import com.kingteller.bs.domain.pay.UserPay;

@Component("userPayDao")
public class UserPayDaoImpl extends MyBatisDao implements UserPayDao {

	private static final String NAMESPACE = "UserPay";
	
	@Override
	public UserPay insertUserBase(UserPay userPay) throws Exception {
		int count = this.getSqlSession().insert(NAMESPACE + ".insertUserPay", userPay);
		return count <= 0 ? null : userPay;
	}

	@Override
	public UserPay queryUserPayAllByID(Long userId) throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userid", userId);
		return this.getSqlSession().selectOne(NAMESPACE + ".queryUserPayAllByID", params);
	}

	@Override
	public List<UserPay> queryUserPayListByUserID(UserPay userPay)
			throws Exception {
		return this.getSqlSession().selectList(NAMESPACE + ".queryUserPayListByUserID", userPay);
	}

}
