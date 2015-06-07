package com.kingteller.bs.mvc;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kingteller.bs.service.TopContactService;


@Controller
@RequestMapping("/article")
public class UserController {
	
		
	@Autowired
	TopContactService topContactService;
	
	@RequestMapping("/search")
	@ResponseBody
	public ModelAndView listall(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mav=new ModelAndView("/pages/list.jsp");
		topContactService.addTopContact("", 100L, 100L);
		List<Article> articles=new ArrayList<Article>();
		Article act=new Article();
		act.setContent("test");
		act.setId(100);
		act.setTitle("test");
		mav.addObject("articles",articles);
		return mav;
	}
	
	
}
