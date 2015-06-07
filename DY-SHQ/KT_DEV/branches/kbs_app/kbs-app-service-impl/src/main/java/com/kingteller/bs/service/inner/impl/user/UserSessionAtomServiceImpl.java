package com.kingteller.bs.service.inner.impl.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kingteller.bs.dao.user.UserSessionDao;
import com.kingteller.bs.domain.user.UserSession;
import com.kingteller.bs.service.inner.user.UserSessionAtomService;

@Component("userSessionAtomService")
public class UserSessionAtomServiceImpl implements UserSessionAtomService {

	@Autowired
	private UserSessionDao userSessionDao;
	
	@Override
	public UserSession insertUserSession(UserSession userSession) throws Exception {
		return this.userSessionDao.insertUserSession(userSession);
	}

	@Override
	public int updateUserSessionByUsername(String username, String status)
			throws Exception {
		return this.userSessionDao.updateUserSessionByUsername(username, status);
	}

	@Override
	public UserSession queryBySessionId(String sessionId) throws Exception {
		return this.userSessionDao.queryBySessionId(sessionId);
	}

}
