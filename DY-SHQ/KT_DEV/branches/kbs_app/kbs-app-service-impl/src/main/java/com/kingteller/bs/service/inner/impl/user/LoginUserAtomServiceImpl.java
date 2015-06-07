package com.kingteller.bs.service.inner.impl.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kingteller.bs.dao.user.LoginUserDao;
import com.kingteller.bs.domain.user.LoginUser;
import com.kingteller.bs.service.inner.user.LoginUserAtomService;

@Component("loginUserAtomService")
public class LoginUserAtomServiceImpl implements LoginUserAtomService {

	@Autowired
	private LoginUserDao loginUserDao;

	@Override
	public boolean insertLoginUser(LoginUser loginUser) throws Exception {
		return this.loginUserDao.insertLoginUser(loginUser);
	}

	@Override
	public LoginUser queryUserByNameAndPwd(String username, String password)
			throws Exception {
		return this.loginUserDao.queryUserByNameAndPwd(username, password);
	}

	@Override
	public LoginUser queryUserByUserBaseIdAndPwd(Long userBaseId,
			String password) throws Exception {
		return this.loginUserDao.queryUserByUserBaseIdAndPwd(userBaseId, password);
	}

	@Override
	public Integer queryUserCountByUsername(String username) throws Exception {
		return this.loginUserDao.queryUserCountByUsername(username);
	}

	@Override
	public LoginUser queryLoginUserByUsername(String username) throws Exception {
		return this.loginUserDao.queryLoginUserByUsername(username);
	}
	
}
