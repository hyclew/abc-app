package com.kingteller.bs.rest;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kingteller.bs.domain.product.ProductCatalogue;
import com.kingteller.bs.framework.check.CollectionUtils;
import com.kingteller.bs.framework.rest.ErrorCode;
import com.kingteller.bs.framework.rest.ResponseHeader;
import com.kingteller.bs.framework.rest.RestResponse;
import com.kingteller.bs.service.ProductCatalogueService;

@RestController
@RequestMapping("/productcatalogue")
public class ProductCatalogueController {

	private static final Logger logger = Logger.getLogger(ProductCatalogueController.class);
	
	@Autowired
	private ProductCatalogueService productCatalogueService;
	
	/**
	 * 获取所有商品类别
	 * @return
	 */
	@RequestMapping(value = "/productcatalogues", method = RequestMethod.GET)
	public RestResponse getAllProductCatalogues(){
		logger.info("开始查询产品类别信息...");
		RestResponse response = new RestResponse();
		ResponseHeader header = new ResponseHeader();
		List<ProductCatalogue> productCatalogues = null;
		try {
			productCatalogues = this.productCatalogueService.getProductCatalogues();
			if(CollectionUtils.isEmpty(productCatalogues)){
				logger.info("未查询到相关数据");
				header.setErrorCode(ErrorCode.NULL_OR_BLACK);
				header.setMessage("未查询到相关数据");
			}else{
				logger.info("查询成功,返回的产品类别的数量是:" + productCatalogues.size());
				header.setErrorCode(ErrorCode.SUCCESS);
				header.setMessage("查询成功");
			}
		} catch (Exception e) {
			header.setErrorCode(ErrorCode.QUERY_EXCEPTION);
			header.setMessage("查询出现异常");
			logger.error("查询产品类别信息出错，错误信息为:" + e.getLocalizedMessage(), e);
		}
		response.setResponseHeader(header);
		response.setResponseBody(productCatalogues);
		return response;
	}
	
}
