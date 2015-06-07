package com.kingteller.bs.rest;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kingteller.bs.domain.business.BusinessProduct;
import com.kingteller.bs.framework.check.CollectionUtils;
import com.kingteller.bs.framework.rest.ErrorCode;
import com.kingteller.bs.framework.rest.ResponseHeader;
import com.kingteller.bs.framework.rest.RestResponse;
import com.kingteller.bs.service.BusinessProductService;

/**
 * 送水相关操作的Controller
 * @author wangyafei
 *
 */
@RestController
@RequestMapping("/water")
public class SendingWaterController {
	
	private static final Logger logger = Logger.getLogger(SendingWaterController.class);
	
	@Autowired
	private BusinessProductService businessProductService;
	
	/**
	 * 查询送水列表
	 * @param catalogueid 产品类别ID
	 * @param maxId 最大ID，根据此最大ID查询后面的数据
	 * @param dataCount 查询数据条数
	 * @return
	 */
	@RequestMapping(value = "/waterinformations/{catalogueid}/{maxId}/{dataCount}", method = RequestMethod.GET)
	public RestResponse waterInformationsList(@PathVariable Long catalogueid, @PathVariable Long maxId, @PathVariable int dataCount){
		logger.info("开始查询送水列表,查询的最大ID是:" + maxId + ",查询条数是:" + dataCount);
		RestResponse response = new RestResponse();
		ResponseHeader header = new ResponseHeader();
		List<BusinessProduct> products = null;
		try {
			products = this.businessProductService.getBusinessProductInfos(catalogueid, maxId, dataCount);
			
			if(CollectionUtils.isEmpty(products)){
				logger.info("未查询到相关数据");
				header.setErrorCode(ErrorCode.NULL_OR_BLACK);
				header.setMessage("未查询到相关数据");
			}else{
				logger.info("查询到送水信息的数量是:" + products.size());
				header.setErrorCode(ErrorCode.SUCCESS);
				header.setMessage("查询成功");
			}
		} catch (Exception e) {
			header.setErrorCode(ErrorCode.QUERY_EXCEPTION);
			header.setMessage("查询出现异常");
			logger.error("查询送水列表信息出错，错误信息为:" + e.getLocalizedMessage(), e);
		}
		response.setResponseHeader(header);
		response.setResponseBody(products);
		return response;
	}
	
	/**
	 * 根据产品ID查询产品详细信息
	 * @param businessProductId
	 * @return
	 */
	@RequestMapping(value = "/waterdetail/{businessProductId}", method = RequestMethod.GET)
	public RestResponse waterDetailInfo(@PathVariable Long businessProductId){
		logger.info("开始查询送水服务详细信息，查询ID为:" + businessProductId);
		RestResponse response = new RestResponse();
		ResponseHeader header = new ResponseHeader();
		BusinessProduct product = null;
		try {
			product = this.businessProductService.getBusinessProductDetail(businessProductId);
			if(null == product){
				logger.info("送水服务未查询到相关数据");
				header.setErrorCode(ErrorCode.NULL_OR_BLACK);
				header.setMessage("未查询到相关数据");
			}else{
				logger.info("送水服务查询成功，返回信息为:" + product);
				header.setErrorCode(ErrorCode.SUCCESS);
				header.setMessage("查询成功");
			}
		} catch (Exception e) {
			header.setErrorCode(ErrorCode.QUERY_EXCEPTION);
			header.setMessage("查询出现异常");
			logger.error("查询送水详细信息出错，错误信息为:" + e.getLocalizedMessage(), e);
		}
		response.setResponseHeader(header);
		response.setResponseBody(product);
		return response;
	}
	
}
