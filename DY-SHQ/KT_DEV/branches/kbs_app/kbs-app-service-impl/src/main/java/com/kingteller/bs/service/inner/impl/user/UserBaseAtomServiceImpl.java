package com.kingteller.bs.service.inner.impl.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kingteller.bs.dao.user.UserBaseDao;
import com.kingteller.bs.domain.user.UserBase;
import com.kingteller.bs.service.inner.user.UserBaseAtomService;

@Component("userBaseAtomService")
public class UserBaseAtomServiceImpl implements UserBaseAtomService{

	@Autowired
	private UserBaseDao userBaseDao;

	@Override
	public UserBase insertUserBase(UserBase userBase) throws Exception {
		return this.userBaseDao.insertUserBase(userBase);
	}

	@Override
	public UserBase queryUserBaseByPhone(String phone, String userType) throws Exception {
		return this.userBaseDao.queryUserBaseByPhone(phone, userType);
	}

	@Override
	public Integer queryUserBaseCountByPhone(String phone) throws Exception {
		return this.userBaseDao.queryUserBaseCountByPhone(phone);
	}

	@Override
	public void updateResorceIdByUserId(Long userId, Long resourceId)
			throws Exception {
		this.userBaseDao.updateResorceIdByUserId(userId, resourceId);
	}

	@Override
	public UserBase queryByUserId(Long userId) throws Exception {
		return this.userBaseDao.queryByUserId(userId);
	}

	@Override
	public UserBase queryUserBaseByName(String name, String userType)
			throws Exception {
		return this.userBaseDao.queryUserBaseByName(name, userType);
	}
	
}
