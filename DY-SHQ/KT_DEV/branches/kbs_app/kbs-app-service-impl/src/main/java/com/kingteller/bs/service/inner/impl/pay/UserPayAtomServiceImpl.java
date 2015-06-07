package com.kingteller.bs.service.inner.impl.pay;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kingteller.bs.dao.pay.UserPayDao;
import com.kingteller.bs.domain.pay.UserPay;
import com.kingteller.bs.service.inner.pay.UserPayAtomService;

@Component("userPayAtomService")
public class UserPayAtomServiceImpl implements UserPayAtomService {

	@Autowired
	private UserPayDao userPayDao;
	
	@Override
	public UserPay insertUserBase(UserPay userPay) throws Exception {
		// TODO Auto-generated method stub
		return userPayDao.insertUserBase(userPay);
	}

	@Override
	public UserPay queryUserPayAllByID(Long userId) throws Exception {
		// TODO Auto-generated method stub
		return userPayDao.queryUserPayAllByID(userId);
	}
	
	public List<UserPay> queryUserPayListByUserID(UserPay userPay) throws Exception{
		return this.userPayDao.queryUserPayListByUserID(userPay);
	}

}
