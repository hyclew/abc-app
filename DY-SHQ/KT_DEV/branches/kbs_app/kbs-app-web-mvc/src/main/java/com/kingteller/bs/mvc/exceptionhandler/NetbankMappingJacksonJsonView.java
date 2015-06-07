package com.kingteller.bs.mvc.exceptionhandler;

import java.util.Map;

import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

public class NetbankMappingJacksonJsonView extends MappingJackson2JsonView {

	@Override
	protected Object filterModel(Map<String, Object> model) {
		Map<?, ?> resultMap = (Map<?, ?>) super.filterModel(model);
		if(resultMap.size()==1 && resultMap.containsKey("modelMap")){
			return resultMap.values().iterator().next();
		}else{
			return resultMap;
		}
	}

}
