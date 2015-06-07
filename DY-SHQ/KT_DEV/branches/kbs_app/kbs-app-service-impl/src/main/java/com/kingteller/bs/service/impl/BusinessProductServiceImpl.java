package com.kingteller.bs.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.support.SessionStatus;

import com.kingteller.bs.domain.business.BusinessProduct;
import com.kingteller.bs.domain.business.BusinessProductDomail;
import com.kingteller.bs.domain.user.LoginUser;
import com.kingteller.bs.page.DataGridModel;
import com.kingteller.bs.service.BusinessProductService;
import com.kingteller.bs.service.inner.business.BusinessProductAduitAtomService;
import com.kingteller.bs.service.inner.business.BusinessProductAtomService;
import com.kingteller.bs.service.inner.product.ProductBaseAtomService;

@Component("businessProductService")
public class BusinessProductServiceImpl implements BusinessProductService {

	private static final Logger logger = Logger.getLogger(BusinessProductServiceImpl.class);
	
	@Autowired
	private BusinessProductAtomService businessProductAtomService;
	
	@Autowired 
	private ProductBaseAtomService productBaseAtomService;
	
	@Autowired
	private BusinessProductAduitAtomService businessProductAduitAtomService;

	@Override
	public List<BusinessProduct> getBusinessProductInfos(Long productcatalogId, Long maxId, int dataCount) throws Exception{
		List<BusinessProduct> list = this.businessProductAtomService.getBusinessListBycatalogid(productcatalogId, maxId, dataCount);
		logger.debug("获取到的商家产品数量为" + list.size());
		return list;
	}

	@Override
	public BusinessProduct getBusinessProductDetail(Long businessProductId)
			throws Exception {
		return this.businessProductAtomService.getBusinessProductDetail(businessProductId);
	}

	@Override
	public Map<String, Object> getBusinessProductByAll(DataGridModel dgm,Long businessid,BusinessProduct businessProducts)
			throws Exception {
		
		
		Map<String, Object> result = new HashMap<String, Object>(2); 
		List<BusinessProduct>  businessProduct = new ArrayList<BusinessProduct>();
		businessProduct = businessProductAtomService.getBusinessProductByAll(dgm,Long.valueOf("1"),businessProducts);
		int count = businessProductAtomService.getBusinessProductAll(Long.valueOf("1"),businessProducts);
		
		result.put("total",count);
		result.put("rows", businessProduct);
		
		return result;
	}

	@Override
	public boolean updateBusinessProductAduit(
			BusinessProductDomail businessProductDomail) throws Exception {
		
		try {
			//商品基本信息表
			productBaseAtomService.insertProductBase(businessProductDomail.getProductBase());
			//将基本信息表数据赋值给商品审核信息表
			businessProductDomail.getBusinessProductAduit().setProductId(businessProductDomail.getProductBase().getId());//商家基本信息表ID
			businessProductDomail.getBusinessProductAduit().setProductCatalogueId(businessProductDomail.getProductBase().getProductCatalogueId());//产品分类
			businessProductDomail.getBusinessProductAduit().setName(businessProductDomail.getProductBase().getName());//商品名称
			//添加商品审核表
			businessProductAduitAtomService.insertBusinessProductAduit(businessProductDomail.getBusinessProductAduit());
		} catch (Exception e) {
			logger.info("添加产品失败...." + e.getLocalizedMessage(), e);
			return false;
		}
		
		return true;
	}

}
