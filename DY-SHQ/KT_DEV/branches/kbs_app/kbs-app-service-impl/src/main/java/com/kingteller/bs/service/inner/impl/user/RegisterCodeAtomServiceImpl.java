package com.kingteller.bs.service.inner.impl.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kingteller.bs.dao.user.RegisterCodeDao;
import com.kingteller.bs.domain.user.RegisterCode;
import com.kingteller.bs.framework.constant.Constant;
import com.kingteller.bs.service.inner.user.RegisterCodeAtomService;

@Component("registerCodeAtomService")
public class RegisterCodeAtomServiceImpl implements RegisterCodeAtomService {

	@Autowired
	private RegisterCodeDao registerCodeDao;
	
	@Override
	public int insertRegisterCode(RegisterCode registerCode) throws Exception {
		return this.registerCodeDao.insertRegisterCode(registerCode);
	}

	@Override
	public RegisterCode queryCodeById(RegisterCode registerCode)
			throws Exception {
		return this.registerCodeDao.queryCodeById(registerCode);
	}

	@Override
	public void updateCodeByPhone(RegisterCode registerCode) throws Exception {
		this.registerCodeDao.updateCodeByPhone(registerCode);
	}

}
