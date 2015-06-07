package com.kingteller.bs.mvc.businessproduct;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kingteller.bs.domain.business.BusinessProduct;
import com.kingteller.bs.domain.business.BusinessProductAduit;
import com.kingteller.bs.domain.business.BusinessProductDomail;
import com.kingteller.bs.domain.product.ProductBase;
import com.kingteller.bs.domain.user.LoginUser;
import com.kingteller.bs.mvc.util.Constants;
import com.kingteller.bs.page.DataGridModel;
import com.kingteller.bs.service.BusinessProductService;

@Controller
@RequestMapping("businessproduct")
@SessionAttributes(value = {Constants.USER_INFO_SESSION})
public class BusinessProductController {

	@Autowired
	private BusinessProductService businessProductService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(Model model) throws Exception{
		return "businessproduct/list";
	}
	
	/**
	 * 查询商家商品
	 * @param loginUser 得到登录信息
	 * @param dgm分页数据
	 * @param businessProducts 根据条件查询
	 * @return 返回数据
	 * @throws Exception
	 */
	@RequestMapping(value="/queryList",method=RequestMethod.POST)
	@ResponseBody         
	public  Map<String, Object> queryList(@ModelAttribute("loginUser")LoginUser loginUser, DataGridModel dgm,BusinessProduct businessProducts) throws Exception{
		//可以自动装配两个对象  会自动的装返回的Map转换成JSON对象
		
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			map = businessProductService.getBusinessProductByAll(dgm,loginUser.getId(),businessProducts);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		return map;
	}
	
	@RequestMapping(value="/addWindow",method=RequestMethod.GET)
	public String addWindow() throws Exception{
		return "businessproduct/addWindow";
	}
	
	@RequestMapping(value="/addBusinessProduct",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> addBusinessProduct(@ModelAttribute("loginUser")LoginUser loginUser,BusinessProductDomail businessProductDomail) throws Exception{
		//spring会利用jackson自动将返回值封装成JSON对象，比struts2方便了很多
		Map<String, String> map = new HashMap<String, String>();
		try {
			boolean bool = businessProductService.updateBusinessProductAduit(businessProductDomail);
			if (bool) {
				map.put("mes", "操作成功");
			}else{
				map.put("mes", "操作成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put("mes", "操作失败");
			throw e;
		}
		return map; 
	}
	
	
}
