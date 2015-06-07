package com.kingteller.bs.dao.resources;

import org.springframework.stereotype.Component;

import com.kingteller.bs.dao.mysql.MyBatisDao;
import com.kingteller.bs.domain.resources.Resources;

/**
 * 产品资源DAO
 * @author wangyafei
 *
 */
@Component("resourcesDao")
public class ResourcesDaoImpl extends MyBatisDao implements ResourcesDao {

	private static final String NAMESPACE = "Resources";
	
	@Override
	public Resources getResourceById(Long resourceId) throws Exception {
		return this.getSqlSession().selectOne(NAMESPACE + ".getResourceById", resourceId);
	}

	@Override
	public Resources insertResource(Resources resources) throws Exception {
		int count = this.getSqlSession().insert(NAMESPACE + ".insertResource", resources);
		return count <= 0 ? null : resources;
	}

	@Override
	public void deleteResourceById(Long id) throws Exception {
		this.getSqlSession().delete(NAMESPACE + ".deleteResourceById", id);
		
	}

}
