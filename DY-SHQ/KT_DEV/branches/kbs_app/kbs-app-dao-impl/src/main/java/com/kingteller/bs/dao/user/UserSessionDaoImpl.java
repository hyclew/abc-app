package com.kingteller.bs.dao.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.kingteller.bs.dao.mysql.MyBatisDao;
import com.kingteller.bs.domain.user.UserSession;

@Component("userSessionDao")
public class UserSessionDaoImpl extends MyBatisDao implements UserSessionDao {

	private static final String NAMESPACE = "UserSession";
	
	@Override
	public UserSession insertUserSession(UserSession userSession)
			throws Exception {
		int count = this.getSqlSession().insert(NAMESPACE + ".insertUserSession", userSession);
		return count <= 0 ? null : userSession;
	}

	@Override
	public int updateUserSessionByUsername(String username, String status)
			throws Exception {
		Map<String , String> params = new HashMap<String, String>();
		params.put("username", username);
		params.put("status", status);
		return this.getSqlSession().update(NAMESPACE + ".updateStatusByUsername", params);
	}

	@Override
	public UserSession queryBySessionId(String sessionId) throws Exception {
		return this.getSqlSession().selectOne(NAMESPACE + ".queryBySessionId", sessionId);
	}

}
