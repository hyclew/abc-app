package com.kingteller.bs.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kingteller.bs.domain.business.BusinessBase;
import com.kingteller.bs.domain.business.BusinessBaseDomail;
import com.kingteller.bs.domain.business.BusinessCatalogue;
import com.kingteller.bs.domain.pay.UserPay;
import com.kingteller.bs.domain.user.UserBase;
import com.kingteller.bs.framework.constant.Constant;
import com.kingteller.bs.service.BusinessBaseService;
import com.kingteller.bs.service.inner.business.BusinessBaseAtomService;
import com.kingteller.bs.service.inner.business.BusinessCatalogueAtomService;
import com.kingteller.bs.service.inner.user.UserBaseAtomService;
import com.kingteller.bs.service.inner.pay.UserPayAtomService;;

@Component("businessBaseService")
public class BusinessBaseServiceImpl implements BusinessBaseService {

	private static final Logger logger = Logger
	.getLogger(BusinessBaseServiceImpl.class);
	
	@Autowired
	private BusinessBaseAtomService businessBaseAtomService;
	
	@Autowired
	private UserBaseAtomService userBaseAtomService;
	
	@Autowired
	private UserPayAtomService userPayAtomService;
	
	@Autowired
	private BusinessCatalogueAtomService businessCatalogueAtomService;
	
	/**
	 * 商家信息查询
	 * 根据电话和商家名称进行查询商家用户信息表
	 */
	@Override
	public List<BusinessBase> queryBusinessBaseAll(String businessName,String userbaseName) throws Exception {
		// TODO Auto-generated method stub
		
		List<BusinessBase> businessBaseList = new ArrayList<BusinessBase>();
		List<BusinessCatalogue> businessCatalogueList = new ArrayList<BusinessCatalogue>();
		String cataloguecode = "";
		try {
			businessBaseList = businessBaseAtomService.queryBusinessBaseByAll(userbaseName, businessName);//查询出商家信息
			for (int i = 0; i < businessBaseList.size(); i++) {
				cataloguecode = "";
				businessCatalogueList = businessCatalogueAtomService.queryUserBaseByList(businessBaseList.get(i).getId().toString());
				for (int j = 0; j < businessCatalogueList.size(); j++) {
					cataloguecode += businessCatalogueList.get(j).getCataloguecode().toString();//查询商家产品分类进行赋值
				}
				businessBaseList.get(i).setProductcatalogueid(Long.valueOf(cataloguecode));
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("查询商家失败...." + e.getLocalizedMessage(), e);
		}
		return businessBaseList;
	}

	/**
	 * 商家账户添加
	 * 
	 * 关联三张表 分别为   商家基础信息、用户基本信息表、支付工具表
	 */
	@Override
	public boolean insertBusinessBase(BusinessBaseDomail businessBaseDomail)
			throws Exception {

		try {
			
			BusinessBase businessBase = businessBaseAtomService.queryBusinessBaseByName(businessBaseDomail.getBusinessBase().getName());
			logger.info("添加商家账户---查询商家账户！");
			if(businessBase != null){//判断表中是否已有商家，如果已有商家则更新商家产品分类
				//businessBaseAtomService.updateBusinessBaseById(businessBase.getId(), businessBaseDomail.getBusinessBase().getProductcatalogueid());
				
				BusinessCatalogue businessCatalogue = new BusinessCatalogue();
				businessCatalogue.setBusinessid(businessBase.getId());
				businessCatalogue.setName("");
				for (int i = 0; i < businessBaseDomail.getProductcatalogueid().size(); i++) {
					businessCatalogue.setCataloguecode(Long.valueOf(businessBaseDomail.getProductcatalogueid().get(i).toString()));
					businessCatalogueAtomService.insertBusinessCatalogue(businessCatalogue);
				}
			}else{
				//添加用户基本信息表
				businessBaseDomail.getUserBase().setName(businessBaseDomail.getBusinessBase().getContractname());//将商家联系人封装到基本信息联系人中，
				businessBaseDomail.getUserBase().setStatus(Constant.USER_STATUS_DISABLED);//设置状态默认为0
				businessBaseDomail.getUserBase().setUserType(Constant.USER_TYPE_SELLER);//设置为商家
				UserBase userBase = userBaseAtomService.insertUserBase(businessBaseDomail.getUserBase());
				logger.info("添加商家账户---用户基本信息表入库成功！");
				//添加支付工具表
				businessBaseDomail.getUserPay().setStatus(Constant.USERPAY_STATUS_ENABLED);//设置卡状态 默认为0
				businessBaseDomail.getUserPay().setUserId(userBase.getId());//得到用户基本新表中ID值
				UserPay userPay = userPayAtomService.insertUserBase(businessBaseDomail.getUserPay());
				logger.info("添加商家账户---支付工具信息表入库成功！");
				//添加商家基本信息表
				businessBaseDomail.getBusinessBase().setPaytool(userPay.getPayTool());//得到支付工具
				businessBaseDomail.getBusinessBase().setStatus(Constant.BUSINESS_STATUS_ENABLED);//默认商家状态为0-可用
				businessBaseDomail.getBusinessBase().setUserid(userBase.getId());//得到用户基本信息表ID
				businessBase = businessBaseAtomService.insertBusinessBase(businessBaseDomail.getBusinessBase());
				logger.info("添加商家账户---商家基本信息表入库成功！");
				//添加商家产品表
				BusinessCatalogue businessCatalogue = new BusinessCatalogue();
				businessCatalogue.setBusinessid(businessBase.getId());
				businessCatalogue.setName("");
				for (int i = 0; i < businessBaseDomail.getProductcatalogueid().size(); i++) {
					businessCatalogue.setCataloguecode(Long.valueOf(businessBaseDomail.getProductcatalogueid().get(i).toString()));
					businessCatalogueAtomService.insertBusinessCatalogue(businessCatalogue);
				}
			}
			
		} catch (Exception e) {
			logger.error("添加商家账户添加出现异常 ，异常信息为:" + e.getLocalizedMessage(), e);
			return false;
		}
		return true;
	}

	/**
	 * 更新商家状态
	 */
	@Override
	public boolean updateBusinessBaseBStatus(List list) throws Exception {
		try {
			for (int i = 0; i < list.size(); i++) {
				//更新商家状态  参数说明  1.商家ID  2.商家状态值 1-失效
				businessBaseAtomService.updateBusinessBaseBStatus(Long.valueOf(list.get(i).toString()), Constant.BUSINESS_STATUS_DISABLED.toString());
			}
			return true;
		} catch (Exception e) {
			logger.error("添加商家账户添加出现异常 ，异常信息为:" + e.getLocalizedMessage(), e);
			return false;
		}
	}
	public BusinessBase queryBusinessBaseAllByID(Long id) throws Exception{
		BusinessBase businessBase = new BusinessBase();
		try {
			businessBase = businessBaseAtomService.queryBusinessById(id);
		} catch (Exception e) {
			logger.error("根据ID查询商家失败 ，异常信息为:" + e.getLocalizedMessage(), e);
		}
		
		return businessBase;
	}

	@Override
	public boolean updateBusinessBase(BusinessBase businessBase)
			throws Exception {
		try {
			businessBaseAtomService.updateBusinessBase(businessBase);
			return true;
		} catch (Exception e) {
			logger.error("根据ID查询商家失败 ，异常信息为:" + e.getLocalizedMessage(), e);
		}
		return false;
	}

	/**
	 * 根据商家ID查询
	 * 查询商家基础信息表
	 * 查询用户基本信息表
	 * 查询支付工具表
	 * @return
	 * @throws Exception
	 */
	@Override
	public BusinessBaseDomail queryBusinessBaseAll(Long id)
			throws Exception {
		BusinessBaseDomail businessBaseDomail = new BusinessBaseDomail();
		//通过ID查询商家信息
		BusinessBase businessBase = new BusinessBase();
		businessBase = businessBaseAtomService.queryBusinessById(id);
		String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(businessBase.getUpdateTime()); 
	//	businessBase.setUpdateTime(Date.parse(nowTime));
		businessBaseDomail.setBusinessBase(businessBase);
		//通过USERID查询基础信息表
		UserBase userBase = new UserBase();
		userBase = userBaseAtomService.queryByUserId(businessBase.getUserid());
		businessBaseDomail.setUserBase(userBase);
		//查询支付工具表
		UserPay userPay = new UserPay();
		userPay = userPayAtomService.queryUserPayAllByID(userBase.getId());
		businessBaseDomail.setUserPay(userPay);
		//查询商家产品分类表
		/*List<BusinessCatalogue> businessCatalogue = new  ArrayList<BusinessCatalogue>();
		businessCatalogue = businessCatalogueAtomService.queryUserBaseByList(businessBase.getId().toString());
		businessBaseDomail.setBusinessCatalogue(businessCatalogue);*/
		return businessBaseDomail;
	}
	


}
