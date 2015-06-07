package com.kingteller.bs.rest;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kingteller.bs.domain.business.BusinessProductAdvert;
import com.kingteller.bs.framework.check.CollectionUtils;
import com.kingteller.bs.framework.constant.Constant;
import com.kingteller.bs.framework.rest.ErrorCode;
import com.kingteller.bs.framework.rest.ResponseHeader;
import com.kingteller.bs.framework.rest.RestResponse;
import com.kingteller.bs.service.BusinessProductAdvertService;

@RestController
@RequestMapping("/productadvert")
public class BusinessProductAdvertController {

	private static final Logger logger = Logger.getLogger(BusinessProductAdvertController.class);
	
	@Autowired
	private BusinessProductAdvertService businessProductAdvertService;
	
	private static final int ADVERT_COUNT = 5;  //默认查询5条广告信息
	
	/**
	 * 查询最近的5条广告用于展示
	 * @return
	 */
	@RequestMapping(value = "/latestadverts", method = RequestMethod.GET)
	public RestResponse getAllProductCatalogues(){
		logger.info("<-----开始查询广告信息----->");
		RestResponse response = new RestResponse();
		ResponseHeader header = new ResponseHeader();
		List<BusinessProductAdvert> productAdverts = null;
		try {
			productAdverts = this.businessProductAdvertService.getLatestProductAdverts(Constant.PRODUCT_ADVERT_ENABLE, ADVERT_COUNT);
			
			if(CollectionUtils.isEmpty(productAdverts)){
				logger.info("未查询到广告信息");
				header.setErrorCode(ErrorCode.NULL_OR_BLACK);
				header.setMessage("未查询到广告信息");
			}else{
				logger.info("查询到广告信息的数量是:" + productAdverts.size());
				header.setErrorCode(ErrorCode.SUCCESS);
				header.setMessage("查询成功");
			}
		} catch (Exception e) {
			header.setErrorCode(ErrorCode.QUERY_EXCEPTION);
			header.setMessage("查询出现异常");
			logger.error("查询广告信息出错，错误信息为:" + e.getLocalizedMessage(), e);
		}
		response.setResponseHeader(header);
		response.setResponseBody(productAdverts);
		return response;
	}
	
}
