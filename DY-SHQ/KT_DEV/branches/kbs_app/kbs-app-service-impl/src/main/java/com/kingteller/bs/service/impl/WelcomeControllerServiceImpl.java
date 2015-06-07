package com.kingteller.bs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kingteller.bs.domain.user.LoginUser;
import com.kingteller.bs.service.WelcomeControllerService;
import com.kingteller.bs.service.inner.user.LoginUserAtomService;

@Component("welcomeControllerService")
public class WelcomeControllerServiceImpl implements WelcomeControllerService {

	@Autowired
	private LoginUserAtomService loginUserAtomService;

	@Override
	public LoginUser queryUserByNameAndPwd(String username, String password)
			throws Exception {
		return this.loginUserAtomService.queryUserByNameAndPwd(username, password);
	}
}
