package com.kingteller.bs.dao.mysql;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kingteller.bs.dao.TopContactDao;
import com.kingteller.bs.domain.TopContact;


@Component
public class TopContactDaoImpl extends MyBatisDao implements TopContactDao {
	private static final String NAMESPACE="TopContactMapper";
	@Override
	public Integer deleteById(Long id) {
		return this.getSqlSession().update(NAMESPACE+".deleteById", id);
	}
	
	
	
//	@Override
//	public Integer insert(TopContact record) {
//		return this.getSqlSession().insert(NAMESPACE+".insert", record);
//	}

	@Override
	public TopContact selectById(Long id) {
		return (TopContact)this.getSqlSession().selectOne(NAMESPACE+".selectById", id);
	}

	@Override
	public Integer updateByParams(Map map) {
		return this.getSqlSession().update(NAMESPACE+".updateByParams", map);
	}

//	@Override
//	public Integer updateById(TopContact record) {
//		return this.getSqlSession().update(NAMESPACE+".updateById", record);
//	}

	@Override
	public List<TopContact> queryTopContactListByOwnerUserId(Long ownerUserId){
		Map map=new HashMap();
		map.put("ownerUserId", ownerUserId);
		return this.getSqlSession().selectList(NAMESPACE+".queryTopContactListByOwnerUserId", map);
	}

	@Override
	public Integer updateStatusById(Long id) {
		return this.getSqlSession().update(NAMESPACE+".updateStatusById", id);
	}

	public Integer updateStatusByOrgIdMemberIdOwnerUserId(Long orgId, Long orgMemberId,Long ownerUserId) {
		Map map=new HashMap();
		map.put("orgId", orgId);
		map.put("orgMemberId", orgMemberId);
		map.put("ownerUserId", ownerUserId);
		return this.getSqlSession().update(NAMESPACE+".updateStatusByOrgIdMemberIdOwnerUserId", map);
	}
	@Override
	public TopContact queryByOrgIdMemberIdOwnerUserId(Long orgId,
			Long orgMemberId, Long ownerUserId) {
		Map<String,Long> map=new HashMap<String,Long>();
		map.put("orgId", orgId);
		map.put("orgMemberId", orgMemberId);
		map.put("ownerUserId", ownerUserId);
		return (TopContact)getSqlSession().selectOne(NAMESPACE+".queryByOrgIdMemberIdOwnerUserId", map);
	}

	@Override
	public Integer updateByOrgIdMemberIdOwnerUserId(Long orgId, Long orgMemberId,
			Long ownerUserId,Integer sourceType) {
		Map map=new HashMap();
		map.put("orgId", orgId);
		map.put("orgMemberId", orgMemberId);
		map.put("ownerUserId", ownerUserId);
		map.put("sourceType", sourceType);
		return this.getSqlSession().update(NAMESPACE+".updateByOrgIdMemberIdOwnerUserId", map);
	}

	@Override
	public List<TopContact> queryByMemberIdsOwnerUserId(
			List<Long> orgMemberIdList, Long ownerUserId) {
		Map map=new HashMap();
		map.put("ownerUserId", ownerUserId);
		map.put("orgMemberIdList", orgMemberIdList);
		return this.getSqlSession().selectList(NAMESPACE+".queryByMemberIdsOwnerUserId", map);
	}

	@Override
	public Integer updateRecommendByOrgIdMemberIdOwnerUserId(Long orgId,
			Long orgMemberId, Long ownerUserId, Integer contectTotal) {
		Map map=new HashMap();
		map.put("orgId", orgId);
		map.put("orgMemberId", orgMemberId);
		map.put("ownerUserId", ownerUserId);
		map.put("contectTotal", contectTotal);
		return this.getSqlSession().update(NAMESPACE+".updateByOrgIdMemberIdOwnerUserId", map);
	}

	@Override
	public Integer updateById(TopContact record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer insert(TopContact record) {
		// TODO Auto-generated method stub
		return null;
	}
}
