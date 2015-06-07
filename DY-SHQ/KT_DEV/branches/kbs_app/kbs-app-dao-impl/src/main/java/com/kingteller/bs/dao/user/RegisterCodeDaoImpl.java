package com.kingteller.bs.dao.user;

import org.springframework.stereotype.Component;

import com.kingteller.bs.dao.mysql.MyBatisDao;
import com.kingteller.bs.domain.user.RegisterCode;

@Component("registerCodeDao")
public class RegisterCodeDaoImpl extends MyBatisDao implements RegisterCodeDao {

	private static final String NAMESPACE = "RegisterCode";
	
	@Override
	public int insertRegisterCode(RegisterCode registerCode) throws Exception {
		return this.getSqlSession().insert(NAMESPACE + ".insertRegisterCode", registerCode);
	}

	@Override
	public RegisterCode queryCodeById(RegisterCode registerCode)
			throws Exception {
		return this.getSqlSession().selectOne(NAMESPACE + ".queryCodeById", registerCode);
	}

	@Override
	public void updateCodeByPhone(RegisterCode registerCode) throws Exception {
		this.getSqlSession().delete(NAMESPACE + ".updateCodeByPhone", registerCode);
	}

}
