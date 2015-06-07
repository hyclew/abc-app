package com.kingteller.bs.service.inner.impl.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kingteller.bs.dao.user.UserDetailedDao;
import com.kingteller.bs.domain.user.UserDetailed;
import com.kingteller.bs.service.inner.user.UserDetailedAtomService;

@Component("userDetailedAtomService")
public class UserDetailedAtomServiceImpl implements UserDetailedAtomService {

	@Autowired
	private UserDetailedDao userDetailedDao;

	@Override
	public boolean insertUserDetailed(UserDetailed userDetailed)
			throws Exception {
		return this.userDetailedDao.insertUserDetailed(userDetailed);
	}
	
}
