package com.kingteller.bs.mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/base/index")
public class HomeController {
		
	Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * 获取session统一管理开关是否打开
	 */
//	@Autowired
//	private CacheSessionFilter cacheSessionFilter;
	
	/**
	 * 登录
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView home(Model model) {
		return new ModelAndView("/base/index.html");
	}
}
