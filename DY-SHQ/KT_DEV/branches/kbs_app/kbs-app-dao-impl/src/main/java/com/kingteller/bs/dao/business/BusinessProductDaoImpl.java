package com.kingteller.bs.dao.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.kingteller.bs.dao.mysql.MyBatisDao;
import com.kingteller.bs.domain.business.BusinessProduct;
import com.kingteller.bs.page.DataGridModel;

@Component("businessProductDao")
public class BusinessProductDaoImpl extends MyBatisDao implements
		BusinessProductDao {

	private static final String NAMESPACE = "BusinessProduct";

	@Override
	public List<BusinessProduct> getBusinessproductBycatalogid(
			Long productcatalogId, Long maxId, int dataCount) throws Exception {
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("productcatalogueid", productcatalogId);
		map.put("maxId", maxId);
		map.put("dataCount", dataCount);
		return this.getSqlSession().selectList(
				NAMESPACE + ".getBusinessproductBycatalogid", map);
	}

	@Override
	public BusinessProduct getBusinessProductDetail(Long businessProductId) throws Exception {
		return this.getSqlSession().selectOne(NAMESPACE + ".getBusinessProductById", businessProductId);
	}

	@Override
	public List<BusinessProduct> getBusinessProductByAll(DataGridModel dgm,Long businessid,BusinessProduct businessProduct) throws Exception {
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("page", (dgm.getPage() - 1) * dgm.getRows());
		map.put("rows", dgm.getRows());
		map.put("businessid", businessid);
		map.put("name", businessProduct.getName()==""?null:businessProduct.getName());
		return this.getSqlSession().selectList(NAMESPACE + ".getBusinessProductByAll", map);
	}

	@Override
	public int getBusinessProductAll(Long businessid,BusinessProduct businessProduct)
			throws Exception {
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("name", businessProduct.getName()==""?null:businessProduct.getName());
		map.put("businessid", businessid);
		return this.getSqlSession().selectOne(NAMESPACE + ".getBusinessProductAll",map);
	}
	
}