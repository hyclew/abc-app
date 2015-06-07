package com.kingteller.bs.rest;

import java.io.File;
import java.io.FileInputStream;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kingteller.bs.domain.resources.Resources;
import com.kingteller.bs.framework.base64.Base64Converter;
import com.kingteller.bs.framework.check.StringUtils;
import com.kingteller.bs.framework.rest.ErrorCode;
import com.kingteller.bs.framework.rest.ResponseHeader;
import com.kingteller.bs.framework.rest.RestResponse;
import com.kingteller.bs.service.ResourcesService;

@RestController
@RequestMapping("/resources")
public class ResourcesController {

	private static final Logger logger = Logger.getLogger(ResourcesController.class);
	
	@Autowired
	private ResourcesService resourcesService;
	
	/**
	 * 获取资源
	 * @return
	 */
	@RequestMapping(value = "/resource/{resourcesId}", method = RequestMethod.GET)
	public RestResponse getResource(@PathVariable Long resourcesId){
		logger.info("开始查询资源信息，资源ID是:" + resourcesId);
		RestResponse response = new RestResponse();
		ResponseHeader header = new ResponseHeader();
		Resources resource = null;
		try {
			resource = this.resourcesService.getResourceById(resourcesId);
			if(null == resource){
				logger.info("未查询到相关资源数据");
				header.setErrorCode(ErrorCode.NULL_OR_BLACK);
				header.setMessage("未查询到相关资源数据");
			}else{
				String url = resource.getResourceURL();
				if(StringUtils.isEmpty(url)){
					logger.info("此资源ID不存在对应的资源URL");
					header.setErrorCode(ErrorCode.NULL_OR_BLACK);
					header.setMessage("相关资源数据不存在");
				}else{
					File file = new File(url);
					FileInputStream fis = null;
					if(!file.exists()){
						logger.info("资源URL对应的资源不存在");
						header.setErrorCode(ErrorCode.RESOURCE_NOT_EXISTS);
						header.setMessage("资源URL对应的资源不存在");
					}else{ //验证完毕，开始将资源转为base64编码
						logger.info("查询成功,返回的资源URL是:" + resource.getResourceURL() + ",资源名称是:" + resource.getName());
						//当文件太大时可能出现溢出
						byte[] buf = new byte[(int)file.length()];
						fis = new FileInputStream(file);
						fis.read(buf);
						String base64 = Base64Converter.encodeBase64Byte2Str(buf);
						resource.setResourceURL(base64);
						header.setErrorCode(ErrorCode.SUCCESS);
						header.setMessage("查询转换URL成功");
					}
				}
			}
		} catch (Exception e) {
			header.setErrorCode(ErrorCode.QUERY_EXCEPTION);
			header.setMessage("获取资源出现异常");
			logger.error("获取资源出错，错误信息为:" + e.getLocalizedMessage(), e);
		}
		response.setResponseHeader(header);
		response.setResponseBody(resource);
		return response;
	}
	
}
