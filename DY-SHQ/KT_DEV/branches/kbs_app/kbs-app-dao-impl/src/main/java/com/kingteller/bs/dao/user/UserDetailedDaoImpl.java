package com.kingteller.bs.dao.user;

import org.springframework.stereotype.Component;

import com.kingteller.bs.dao.mysql.MyBatisDao;
import com.kingteller.bs.domain.user.UserDetailed;

@Component("userDetailedDao")
public class UserDetailedDaoImpl extends MyBatisDao implements UserDetailedDao{

	private static final String NAMESPACE = "UserDetailed";
	
	@Override
	public boolean insertUserDetailed(UserDetailed userDetailed)
			throws Exception {
		int count = this.getSqlSession().insert(NAMESPACE + ".insertUserDetailed", userDetailed);
		return count <=0 ? false : true;
	}

}
