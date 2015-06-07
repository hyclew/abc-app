package com.kingteller.bs.mvc.login;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kingteller.bs.domain.login.Dept;

@Controller
@RequestMapping("/dept")
public class DeptController {


	@RequestMapping(value="/queryAll")
	@ResponseBody         
	public Map<String, Object> queryAll() throws Exception{
	    return null;//deptService.getAllJson(); //可以返回map
	}
	
	@RequestMapping(value="/allList")
	@ResponseBody         
	public List<Dept> allList() throws Exception{
	    return null;//deptService.getDeptList(); //也可以返回list
	}
}

