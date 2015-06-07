package com.kingteller.bs.dao.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.kingteller.bs.dao.mysql.MyBatisDao;
import com.kingteller.bs.domain.user.UserBase;

@Component("userBaseDao")
public class UserBaseDaoImpl extends MyBatisDao implements UserBaseDao {

	private static final String NAMESPACE = "UserBase";
	
	@Override
	public UserBase insertUserBase(UserBase userBase) throws Exception {
		int count = this.getSqlSession().insert(NAMESPACE + ".insertUserBase", userBase);
		return count <= 0 ? null : userBase;
	}

	@Override
	public UserBase queryUserBaseByPhone(String phone, String userType) throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("phone", phone);
		params.put("userType", userType);
		return this.getSqlSession().selectOne(NAMESPACE + ".queryUserBaseByPhone", params);
	}

	@Override
	public Integer queryUserBaseCountByPhone(String phone) throws Exception {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectOne(NAMESPACE + ".queryUserBaseCountByPhone", phone);
	}

	@Override
	public void updateResorceIdByUserId(Long userId, Long resourceId)
			throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", userId);
		params.put("resourceId", resourceId);
		this.getSqlSession().update(NAMESPACE + ".updateResorceIdByUserId", params);
	}

	@Override
	public UserBase queryByUserId(Long userId) throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", userId);
		return this.getSqlSession().selectOne(NAMESPACE + ".queryByUserId", params);
	}

	@Override
	public UserBase queryUserBaseByName(String name, String userType)
			throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", name);
		params.put("userType", userType);
		return this.getSqlSession().selectOne(NAMESPACE + ".queryUserBaseByName", params);
	}

}
