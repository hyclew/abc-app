package com.kingteller.bs.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kingteller.bs.domain.business.BusinessActivity;
import com.kingteller.bs.framework.constant.Constant;
import com.kingteller.bs.framework.rest.ErrorCode;
import com.kingteller.bs.framework.rest.ResponseHeader;
import com.kingteller.bs.framework.rest.RestResponse;
import com.kingteller.bs.service.BusinessActivityService;
import com.kingteller.bs.service.inner.business.BusinessActivityAtomService;

@Component("businessActivityService")
public class BusinessActivityServiceImpl implements BusinessActivityService{

	private static final Logger logger = Logger.getLogger(BusinessActivityServiceImpl.class);
	
	@Autowired
	private BusinessActivityAtomService businessActivityAtomService;
	
	@Override
	public RestResponse queryBusinessActivitys(Long maxId, int dataCount) throws Exception {
		RestResponse response = new RestResponse();
		ResponseHeader header = new ResponseHeader();
		List<BusinessActivity> businessActivitys = null;
		try {
			BusinessActivity businessActivity = new BusinessActivity();
			businessActivity.setIsEnabled(Constant.BUSINESS_ACTIVITY_ENABLED);
			businessActivitys = this.businessActivityAtomService.queryBusinessActivitys(businessActivity, maxId, dataCount);
			if(null != businessActivitys && businessActivitys.size() > 0){
				logger.info("查询商家活动信息成功");
				header.setErrorCode(ErrorCode.SUCCESS);
				header.setMessage("查询商家活动信息成功");
				response.setResponseBody(businessActivitys);
			}else{
				logger.info("未查询到商家活动信息");
				header.setErrorCode(ErrorCode.NULL_OR_BLACK);
				header.setMessage("未查询到商家活动信息");
			}
		} catch (Exception e) {
			logger.error("查询商家活动信息异常,异常信息是:" + e.getLocalizedMessage(), e);
			header.setErrorCode(ErrorCode.QUERY_EXCEPTION);
			header.setMessage("查询商家活动信息异常");
		}
		response.setResponseHeader(header);
		return response;
	}

}
