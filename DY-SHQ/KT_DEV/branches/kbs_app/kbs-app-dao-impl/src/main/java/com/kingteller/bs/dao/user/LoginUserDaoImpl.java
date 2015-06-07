package com.kingteller.bs.dao.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.kingteller.bs.dao.mysql.MyBatisDao;
import com.kingteller.bs.domain.user.LoginUser;

@Component("loginUserDao")
public class LoginUserDaoImpl extends MyBatisDao implements LoginUserDao {

	private static final String NAMESPACE = "LoginUser";
	
	@Override
	public boolean insertLoginUser(LoginUser loginUser) throws Exception {
		int count = this.getSqlSession().insert(NAMESPACE + ".insertLoginUser", loginUser);
		return count <=0 ? false : true;
	}

	@Override
	public LoginUser queryUserByNameAndPwd(String username, String password)
			throws Exception {
		Map<String, String> params = new HashMap<String, String>();
		params.put("username", username);
		params.put("password", password);
		return this.getSqlSession().selectOne(NAMESPACE + ".queryUserByNameAndPwd", params);
	}

	@Override
	public LoginUser queryUserByUserBaseIdAndPwd(Long userBaseId,
			String password) throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userBaseId", userBaseId);
		params.put("password", password);
		return this.getSqlSession().selectOne(NAMESPACE + ".queryUserByUserIdAndPwd", params);
	}

	@Override
	public Integer queryUserCountByUsername(String username) throws Exception {
		return (Integer)this.getSqlSession().selectOne(NAMESPACE + ".queryUserCountByUsername", username);
	}

	@Override
	public LoginUser queryLoginUserByUsername(String username) throws Exception {
		return this.getSqlSession().selectOne(NAMESPACE + ".queryLoginUserByUsername", username);
	}

}
