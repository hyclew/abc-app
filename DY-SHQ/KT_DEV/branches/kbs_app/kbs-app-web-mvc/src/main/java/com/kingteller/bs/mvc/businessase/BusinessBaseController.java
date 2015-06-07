package com.kingteller.bs.mvc.businessase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kingteller.bs.domain.business.BusinessBase;
import com.kingteller.bs.domain.business.BusinessBaseDomail;
import com.kingteller.bs.mvc.util.DataGridModel;
import com.kingteller.bs.service.BusinessBaseService;

@Controller
@RequestMapping("businessbase")
public class BusinessBaseController {

	@Autowired
	private BusinessBaseService businessBaseService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(Model model) throws Exception{
		return "businessbase/list";
	}
	
	@RequestMapping(value="/queryList",method=RequestMethod.POST)
	@ResponseBody         
	public  Map<String, Object> queryList(DataGridModel dgm,BusinessBaseDomail businessBaseDomail) throws Exception{
		//可以自动装配两个对象  会自动的装返回的Map转换成JSON对象
	    //return userService.getPageListByExemple(dgm, user); 
		List<BusinessBase>  businessBase = new ArrayList<BusinessBase>();
		if (businessBaseDomail.getUserBase() != null) {
			businessBase = businessBaseService.queryBusinessBaseAll(businessBaseDomail.getBusinessBase().getName(), businessBaseDomail.getUserBase().getName());
		}else{
			businessBase = businessBaseService.queryBusinessBaseAll("","");
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", businessBase.size());
		map.put("rows", businessBase);
		return map;
	}
	
	@RequestMapping(value="/popWindow",method=RequestMethod.GET)
	public String popWindow() throws Exception{
		return "businessbase/popWindow";
	}
	
	@RequestMapping(value="/addOrUpdate",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> addOrUpdate(BusinessBaseDomail businessBaseDomail) throws Exception{
		
		Map<String, String> map = new HashMap<String, String>();
		try {
			boolean bool = businessBaseService.insertBusinessBase(businessBaseDomail);
			if (bool) {
				map.put("mes", "操作成功");
			}else{
				map.put("mes", "操作失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put("mes", "操作失败");
			throw e;
		}
		return map; 
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> delete(@RequestParam("uid") List<Integer> uid)throws Exception{
		//spring mvc 还可以将参数绑定为list类型
		Map<String, String> map = new HashMap<String, String>();
		try {
			//userService.deleteUsers(uid);
			Boolean bool = businessBaseService.updateBusinessBaseBStatus(uid);
			if(bool){
				map.put("mes", "删除成功");
			}else{
				map.put("mes", "删除失败");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			map.put("mes", "删除失败");
			throw e;
		}
		return map;//重定向
	}
	
	
	@RequestMapping(value="/upWindow",method=RequestMethod.GET)
	public String upWindow() throws Exception{
		return "businessbase/upWindow";
	}
	
	@RequestMapping(value="/upOrUpdate",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> upOrUpdate(Long id) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		List list = new ArrayList();
		try {
			BusinessBase businessBase = new BusinessBase();
			businessBase = businessBaseService.queryBusinessBaseAllByID(id);
			list.add(businessBase);
			map.put("total", 1);
			map.put("rows", list);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return map; 
	}
	
	@RequestMapping(value="/adUpdate",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> adUpdate(BusinessBaseDomail businessBaseDomail) throws Exception{
		
		Map<String, String> map = new HashMap<String, String>();
		BusinessBase businessBase = new BusinessBase();
		businessBase = businessBaseDomail.getBusinessBase();
		try {
			boolean bool = businessBaseService.updateBusinessBase(businessBase);
			if (bool) {
				map.put("mes", "操作成功");
			}else{
				map.put("mes", "操作失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put("mes", "操作失败");
			throw e;
		}
		return map; 
	}
	
	@RequestMapping(value="/viewDetails",method=RequestMethod.GET)
	public String viewDetails(Long id) throws Exception{
		return "businessbase/viewDetails";
	}
	@RequestMapping(value="/viewDetail",method=RequestMethod.POST)
	@ResponseBody
	public BusinessBaseDomail viewDetail(Long id) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		BusinessBaseDomail businessBaseDomail = new BusinessBaseDomail();
		//List<BusinessBaseDomail>  businessBaseDomail = new ArrayList<BusinessBaseDomail>();
		try {
			
			businessBaseDomail = businessBaseService.queryBusinessBaseAll(id);
			map.put("total", 1);
			map.put("rows", businessBaseDomail);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return businessBaseDomail; 
	}
	
	
	
}
