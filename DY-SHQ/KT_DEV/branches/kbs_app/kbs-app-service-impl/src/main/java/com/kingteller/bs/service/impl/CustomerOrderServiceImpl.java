package com.kingteller.bs.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kingteller.bs.domain.business.BusinessBase;
import com.kingteller.bs.domain.business.BusinessProduct;
import com.kingteller.bs.domain.cart.BusinessCartDomain;
import com.kingteller.bs.domain.cart.ShoppingCart;
import com.kingteller.bs.domain.order.BusinessOrder;
import com.kingteller.bs.domain.order.BusinessOrderDetailDomain;
import com.kingteller.bs.domain.order.CustomerOrderBase;
import com.kingteller.bs.domain.order.CustomerOrderDetailed;
import com.kingteller.bs.domain.order.OrderBaseAndDetailDomain;
import com.kingteller.bs.domain.order.OrderCartsDomain;
import com.kingteller.bs.domain.order.OrderDetailBusinessDomain;
import com.kingteller.bs.domain.product.ProductCatalogue;
import com.kingteller.bs.domain.user.LoginUser;
import com.kingteller.bs.domain.user.UserSession;
import com.kingteller.bs.framework.constant.Constant;
import com.kingteller.bs.framework.rest.ErrorCode;
import com.kingteller.bs.framework.rest.ResponseHeader;
import com.kingteller.bs.framework.rest.RestResponse;
import com.kingteller.bs.service.CustomerOrderService;
import com.kingteller.bs.service.inner.business.BusinessBaseAtomService;
import com.kingteller.bs.service.inner.business.BusinessProductAtomService;
import com.kingteller.bs.service.inner.cart.ShoppingCartAtomService;
import com.kingteller.bs.service.inner.order.BusinessOrderAtomService;
import com.kingteller.bs.service.inner.order.CustomerOrderBaseAtomService;
import com.kingteller.bs.service.inner.order.CustomerOrderDetailedAtomService;
import com.kingteller.bs.service.inner.product.ProductCatalogueAtomService;
import com.kingteller.bs.service.inner.user.LoginUserAtomService;
import com.kingteller.bs.service.inner.user.UserBaseAtomService;
import com.kingteller.bs.service.inner.user.UserSessionAtomService;

@Component("customerOrderService")
public class CustomerOrderServiceImpl implements CustomerOrderService {

	private static final Logger logger = Logger
			.getLogger(CustomerOrderServiceImpl.class);

	@Autowired
	private ProductCatalogueAtomService productCatalogueAtomService;
	
	/**
	 * 存放数据库中获取到的产品类别序列
	 */
	private static Map<String, AtomicLong> numberSerialize = new HashMap<String, AtomicLong>();

	public static Map<String, AtomicLong> getNumberSerialize() {
		return numberSerialize;
	}

	@Autowired
	private CustomerOrderBaseAtomService customerOrderBaseAtomService;

	@Autowired
	private CustomerOrderDetailedAtomService customerOrderDetailedAtomService;

	@Autowired
	private BusinessProductAtomService businessProductAtomService;

	@Autowired
	private UserBaseAtomService userBaseAtomService;

	@Autowired
	private UserSessionAtomService userSessionAtomService;

	@Autowired
	private LoginUserAtomService loginUserAtomService;

	@Autowired
	private BusinessOrderAtomService businessOrderAtomService;

	@Autowired
	private BusinessBaseAtomService businessBaseAtomService;
	
	@Autowired
	private ShoppingCartAtomService shoppingCartAtomService;

	@Override
	public RestResponse getUserOrders(String sessionId, String detailedAduit)
			throws Exception {
		RestResponse response = new RestResponse();
		ResponseHeader header = new ResponseHeader();
		UserSession userSession = null;
		LoginUser loginUser = null;
		List<OrderBaseAndDetailDomain> orderBaseAndDetailDomains = new ArrayList<OrderBaseAndDetailDomain>();
		try {
			userSession = this.userSessionAtomService
					.queryBySessionId(sessionId);
			loginUser = this.loginUserAtomService
					.queryLoginUserByUsername(userSession.getUsername());
			logger.info("查询订单，获取到的登录用户为:" + loginUser);
			Long userBaseId = loginUser.getUserId();

			CustomerOrderBase orderBase = new CustomerOrderBase();
			orderBase.setUserBaseId(userBaseId);
			orderBase.setStatus(Constant.ORDER_STATUS_ENABLED);
			orderBase.setDetailedAduit(detailedAduit);
			logger.info("查询订单,查询条件是:" + orderBase);
			List<CustomerOrderBase> customerOrderBases = this.customerOrderBaseAtomService
					.queryOrderBaseByUserIdAndAduit(orderBase);
			logger.info("获取到的OrderBase的列表是:" + customerOrderBases);
			for (CustomerOrderBase customerOrderBase : customerOrderBases) {
				OrderBaseAndDetailDomain orderBaseAndDetailDomain = new OrderBaseAndDetailDomain();
				// 设置OrderBase信息
				orderBaseAndDetailDomain
						.setCustomerOrderBase(customerOrderBase);

				List<OrderDetailBusinessDomain> orderDetailBusinessDomains = new ArrayList<OrderDetailBusinessDomain>();
				// 设置orderDetailBusinessDomains的值
				CustomerOrderDetailed customerOrderDetailed = new CustomerOrderDetailed();
				customerOrderDetailed.setCustomerOrderId(customerOrderBase
						.getId());
				List<CustomerOrderDetailed> customerOrderDetaileds = this.customerOrderDetailedAtomService
						.getUserOrderDetailsByOrderId(customerOrderDetailed);
				for (CustomerOrderDetailed orderDetailed : customerOrderDetaileds) {
					OrderDetailBusinessDomain orderDetailBusinessDomain = new OrderDetailBusinessDomain();
					orderDetailBusinessDomain
							.setCustomerOrderDetailed(orderDetailed);
					BusinessProduct businessProduct = this.businessProductAtomService
							.getBusinessProductDetail(orderDetailed
									.getBusinessProductId());
					orderDetailBusinessDomain
							.setBusinessProduct(businessProduct);
					orderDetailBusinessDomains.add(orderDetailBusinessDomain);
				}
				orderBaseAndDetailDomain
						.setOrderDetailBusinessDomain(orderDetailBusinessDomains);
				orderBaseAndDetailDomains.add(orderBaseAndDetailDomain);
			}
			header.setErrorCode(ErrorCode.SUCCESS);
			header.setMessage("查询订单成功");
		} catch (Exception e) {
			logger.error("查看订单异常,异常信息是:" + e.getLocalizedMessage(), e);
			header.setErrorCode(ErrorCode.QUERY_EXCEPTION);
			header.setMessage("查看订单异常");
		}
		response.setResponseHeader(header);
		response.setResponseBody(orderBaseAndDetailDomains);
		return response;
	}

	@Override
	public RestResponse getUserOrderBases(String sessionId, String detailedAduit)
			throws Exception {
		RestResponse response = new RestResponse();
		ResponseHeader header = new ResponseHeader();
		UserSession userSession = null;
		LoginUser loginUser = null;
		List<CustomerOrderBase> customerOrderBases = null;
		try {
			userSession = this.userSessionAtomService
					.queryBySessionId(sessionId);
			loginUser = this.loginUserAtomService
					.queryLoginUserByUsername(userSession.getUsername());
			logger.info("查询订单，获取到的登录用户为:" + loginUser);
			Long userBaseId = loginUser.getUserId();

			CustomerOrderBase orderBase = new CustomerOrderBase();
			orderBase.setUserBaseId(userBaseId);
			orderBase.setStatus(Constant.ORDER_STATUS_ENABLED);
			orderBase.setDetailedAduit(detailedAduit);

			logger.info("查询订单基本信息,查询条件是:" + orderBase);
			customerOrderBases = this.customerOrderBaseAtomService
					.queryOrderBaseByUserIdAndAduit(orderBase);
			if (null != customerOrderBases && customerOrderBases.size() > 0) {
				header.setErrorCode(ErrorCode.SUCCESS);
				header.setMessage("查询订单成功");
			} else {
				header.setErrorCode(ErrorCode.NULL_OR_BLACK);
				header.setMessage("未查询到订单信息");
			}

		} catch (Exception e) {
			logger.error("查看订单基本信息异常,异常信息是:" + e.getLocalizedMessage(), e);
			header.setErrorCode(ErrorCode.QUERY_EXCEPTION);
			header.setMessage("查看订单基本信息异常");
		}
		response.setResponseHeader(header);
		response.setResponseBody(customerOrderBases);
		return response;
	}

	@Override
	public RestResponse getUserOrderDetaileds(Long orderBaseId)
			throws Exception {
		RestResponse response = new RestResponse();
		ResponseHeader header = new ResponseHeader();
		OrderBaseAndDetailDomain orderBaseAndDetailDomain = new OrderBaseAndDetailDomain();
		try {
			CustomerOrderBase customerOrderBase = this.customerOrderBaseAtomService
					.queryOrderBaseById(orderBaseId);
			orderBaseAndDetailDomain.setCustomerOrderBase(customerOrderBase);
			List<OrderDetailBusinessDomain> orderDetailBusinessDomains = new ArrayList<OrderDetailBusinessDomain>();
			// 初始化orderDetailBusinessDomain的值
			CustomerOrderDetailed customerOrderDetailed = new CustomerOrderDetailed();
			customerOrderDetailed.setCustomerOrderId(orderBaseId);
			List<CustomerOrderDetailed> customerOrderDetaileds = this.customerOrderDetailedAtomService
					.getUserOrderDetailsByOrderId(customerOrderDetailed);
			for (CustomerOrderDetailed orderDetailed : customerOrderDetaileds) {
				OrderDetailBusinessDomain orderDetailBusinessDomain = new OrderDetailBusinessDomain();
				orderDetailBusinessDomain
						.setCustomerOrderDetailed(orderDetailed);
				// 查询BusinessProduct
				BusinessProduct businessProduct = this.businessProductAtomService
						.getBusinessProductDetail(orderDetailed
								.getBusinessProductId());
				orderDetailBusinessDomain.setBusinessProduct(businessProduct);
				orderDetailBusinessDomains.add(orderDetailBusinessDomain);
			}
			orderBaseAndDetailDomain
					.setOrderDetailBusinessDomain(orderDetailBusinessDomains);
			logger.info("查看订单详细信息成功");
			header.setErrorCode(ErrorCode.SUCCESS);
			header.setMessage("查看订单详细信息成功");
		} catch (Exception e) {
			logger.error("查看订单详细信息异常,异常信息是:" + e.getLocalizedMessage(), e);
			header.setErrorCode(ErrorCode.QUERY_EXCEPTION);
			header.setMessage("查看订单详细信息异常");
		}
		response.setResponseHeader(header);
		response.setResponseBody(orderBaseAndDetailDomain);
		return response;
	}

	@Override
	public RestResponse getBusinessAndOrderDetaileds(Long orderBaseId)
			throws Exception {
		RestResponse response = new RestResponse();
		ResponseHeader header = new ResponseHeader();
		List<BusinessOrderDetailDomain> businessOrderDetailDomains = new ArrayList<BusinessOrderDetailDomain>();
		try {
			List<BusinessOrder> businessOrders = this.businessOrderAtomService
					.getBusinessOrderByOrderBaseId(orderBaseId);
			for (BusinessOrder businessOrder : businessOrders) {
				BusinessOrderDetailDomain businessOrderDetailDomain = new BusinessOrderDetailDomain();
				businessOrderDetailDomain.setBusinessOrder(businessOrder);
				BusinessBase businessBase = this.businessBaseAtomService
						.queryBusinessById(businessOrder.getBusinessId());
				businessOrderDetailDomain.setBusinessBase(businessBase);
				List<CustomerOrderDetailed> customerOrderDetaileds = this.customerOrderDetailedAtomService
						.getUserOrderDetailsByBusinessOrderId(businessOrder
								.getId());
				List<OrderDetailBusinessDomain> orderDetailBusinessDomain = new ArrayList<OrderDetailBusinessDomain>();
				for(CustomerOrderDetailed customerOrderDetailed : customerOrderDetaileds){
					OrderDetailBusinessDomain orderDetailBusiness = new OrderDetailBusinessDomain();
					orderDetailBusiness.setCustomerOrderDetailed(customerOrderDetailed);
					BusinessProduct bp = this.businessProductAtomService.getBusinessProductDetail(customerOrderDetailed.getBusinessProductId());
					orderDetailBusiness.setBusinessProduct(bp);
					orderDetailBusinessDomain.add(orderDetailBusiness);
				}
				businessOrderDetailDomain.setOrderDetailBusinessDomain(orderDetailBusinessDomain);
				businessOrderDetailDomains.add(businessOrderDetailDomain);
			}
			header.setErrorCode(ErrorCode.SUCCESS);
			header.setMessage("查询订单详细信息成功");
		} catch (Exception e) {
			logger.error("查看订单详细信息异常,异常信息是:" + e.getLocalizedMessage(), e);
			header.setErrorCode(ErrorCode.QUERY_EXCEPTION);
			header.setMessage("查看订单详细信息异常");
		}
		response.setResponseHeader(header);
		response.setResponseBody(businessOrderDetailDomains);
		return response;
	}

	/**
	 * 更成订单号
	 * 
	 * @param code
	 * @return
	 */
	public String generateOrderNumber(String code) {
		AtomicLong serialize = numberSerialize.get(code);
		logger.info("正在生成订单号,商品类别Code是 " + code);
		Long orderSerialize = serialize.incrementAndGet();
		ProductCatalogue productCatalogue = new ProductCatalogue();
		try {
			// 如果内存中的值是1000的倍数,则重新生成内存中的值
			if (orderSerialize % 1000 == 0) {
				productCatalogue.setCode(code);
				productCatalogue = this.productCatalogueAtomService
						.queryProductCatalogByCode(productCatalogue);
				
//				Integer count = 0;
//				// 更新产品类别，将序列加1000
//				count = this.productCatalogueAtomService
//						.updateProductCatalogSerialize(productCatalogue);
//				while (count == 0 && count < MAX_AUTO_TRY) {
//					logger.info("更新商品类别序列，正在进行第 " + (count + 1) + " 次重试");
//					productCatalogue = this.productCatalogueAtomService
//							.queryProductCatalogByCode(productCatalogue);
//					count = this.productCatalogueAtomService
//							.updateProductCatalogSerialize(productCatalogue);
//					count++;
//				}
				
				productCatalogue = this.productCatalogueAtomService.cycleTryUpdateSerializeAddThousand(productCatalogue);
				
				Long serializeNew = productCatalogue.getSerialize();
				//如果序列超过8位数，则将此序列置1000重新开始
				if(serializeNew > 99999999){
					logger.info("获取到Code为 " + code + " 的商品类别的序列是 " + serialize);
					productCatalogue = this.resetSerialize(productCatalogue);
				}
				
				numberSerialize.put(code,
						new AtomicLong(productCatalogue.getSerialize()));
				// 在更新内存中值后重新获取
				serialize = numberSerialize.get(code);
				orderSerialize = serialize.incrementAndGet();
			}
			String orderSerializeStr = String.valueOf(orderSerialize);
			// 如果不足八位,就在前面补0
			if (orderSerializeStr.length() < 8) {
				int zeroCount = 8 - orderSerializeStr.length();
				for (int i = 0; i < zeroCount; i++) {
					orderSerializeStr = "0" + orderSerializeStr;
				}
			}
			DateFormat format = new SimpleDateFormat("yyyyMMdd");
			String currentDate = format.format(new Date());
			String orderNumber = currentDate + code + orderSerializeStr;
			logger.info("商品类别为 " + code + " 生成的订单号是 " + orderNumber);
			return orderNumber;
		} catch (Exception e) {
			logger.error("生成订单号出现异常,异常信息是:" + e.getLocalizedMessage(), e);
			e.printStackTrace();
		}
		return null;
	}
	
	private ProductCatalogue resetSerialize(ProductCatalogue productCatalogue) throws Exception{
		try {
			return this.productCatalogueAtomService.resetSerialize(productCatalogue);
		} catch (Exception e) {
			logger.error("重置Code为 " + productCatalogue.getCode() + " 的商品序列异常");
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 生成订单详细的订单号
	 * 
	 * @return
	 */
	public String generateOrderDetailNumber(String orderBaseNumber, int index) {
		String indexStr = String.valueOf(index);
		String orderDetailedNumber = null;
		// 如果长度小于3，就在前面补0
		if (indexStr.length() < 3) {
			int zeroCount = 3 - indexStr.length();
			for (int i = 0; i < zeroCount; i++) {
				indexStr = "0" + indexStr;
			}
		}
		// 如果长度大于3，就直接跟在orderBaseNumber后
		orderDetailedNumber = orderBaseNumber + indexStr;
		return orderDetailedNumber;
	}

	@Override
	public RestResponse generateUserOrder(OrderCartsDomain orderCartsDomain)
			throws Exception {
		RestResponse response = new RestResponse();
		ResponseHeader header = new ResponseHeader();
		CustomerOrderBase customerOrderBase = null;
		List<BusinessCartDomain> businessCartDomains = null;
		UserSession userSession = null;
		LoginUser loginUser = null;
		try {
			userSession = this.userSessionAtomService
					.queryBySessionId(orderCartsDomain.getSessionId());
			loginUser = this.loginUserAtomService
					.queryLoginUserByUsername(userSession.getUsername());
			logger.info("查询订单，获取到的登录用户为:" + loginUser);
			//用户ID
			Long userBaseId = loginUser.getUserId();
			
			Date currentDate = new Date();
			
			customerOrderBase = orderCartsDomain
					.getCustomerOrderBase();
			businessCartDomains = orderCartsDomain
					.getBusinessCartDomain();
			// 订单号,多件不同的商品,取第一件商品的类别ID生成订单号
			String orderNumberBase = this.generateOrderNumber(String
					.valueOf(businessCartDomains.get(0)
							.getBusinessProductCatalogId()));
			
			//List<CustomerOrderDetailed> customerOrderDetaileds = new ArrayList<CustomerOrderDetailed>();
			
			//此Map中的Key保存商家ID,Value保存订单详细信息,表示商家订单与订单详细的对应关系
			Map<Long, List<CustomerOrderDetailed>> businessProductMap = new HashMap<Long, List<CustomerOrderDetailed>>();
			
			//保存所有的购物车ID
			List<Long> shoppingCartIds = new ArrayList<Long>();
			
			//一个订单下所有商品的总价
			float totalCash = 0f;
			//一个订单下所有商品的总数量
			Integer totalNumbers = 0;
			for (int i = 0; i < businessCartDomains.size(); i++) {
				shoppingCartIds.add(businessCartDomains.get(i).getCartId());
				
				CustomerOrderDetailed customerOrderDetailed = new CustomerOrderDetailed();
				
				Integer numbers = businessCartDomains.get(i).getCount();
				Float productSalePrice = businessCartDomains.get(i).getProductSalePrice();
				Float productPreferPrice = businessCartDomains.get(i).getProductPreferPrice();
				Float detailTotal = numbers * productSalePrice;
				
				Long businessProductId = businessCartDomains.get(i).getBusinessProductId();
				
				customerOrderDetailed.setNumbers(numbers);
				customerOrderDetailed.setSalePrice(productSalePrice);
				customerOrderDetailed.setPreferPrice(productPreferPrice);
				customerOrderDetailed.setUserBaseId(userBaseId);
				customerOrderDetailed.setTotal(detailTotal);
				customerOrderDetailed.setUpdateTime(currentDate);
				customerOrderDetailed.setBusinessProductId(businessProductId);
				
				//在计算每种商品总价的时候，将所有商品的总价和总数量一并计算出来
				totalCash += detailTotal;
				totalNumbers += numbers;
				
				//查询商家产品
				BusinessProduct businessProduct = this.businessProductAtomService.getBusinessProductDetail(businessProductId);
				Long businessId = businessProduct.getBusinessId();
				List<CustomerOrderDetailed> businessOrderDetaileds = businessProductMap.get(businessId);
				if(null == businessOrderDetaileds || businessOrderDetaileds.size() <= 0){
					List<CustomerOrderDetailed> list = new  ArrayList<CustomerOrderDetailed>();
					list.add(customerOrderDetailed);
					businessProductMap.put(businessId, list);
				} else {
					businessOrderDetaileds.add(customerOrderDetailed);
				}
				//customerOrderDetaileds.add(customerOrderDetailed);
			}
			logger.info("该订单的商品总数是 " + totalNumbers + ", 这些商品的总价是 " + totalCash);
			logger.info("该订单一共购买了 " + businessProductMap.size() + " 个商家的商品");
			
			//开始保存订单基础信息
			//保存CustomerOrderBase的订单号
			customerOrderBase.setOrderNumber(orderNumberBase);
			customerOrderBase.setTotalCash(totalCash);
			customerOrderBase.setTotalNumbers(totalNumbers);
			customerOrderBase.setUpdateTime(currentDate);
			//将订单状态设置为待支付
			customerOrderBase.setDetailedAduit(Constant.ORDER_AUDIT_WAITPAY);
			//订单状态为正常
			customerOrderBase.setStatus(Constant.ORDER_STATUS_ENABLED);
			customerOrderBase.setUserBaseId(userBaseId);
			//保存收货人地址
			customerOrderBase.setOrderAddressId(orderCartsDomain.getUserOrderAddress().getId());
			logger.info("开始保存订单基本信息,订单基本信息是 " + customerOrderBase);
			//向数据库中插入订单基本信息
			customerOrderBase = this.customerOrderBaseAtomService.insertCustomerOrderBase(customerOrderBase);
			
			Long customerOrderBaseId = customerOrderBase.getId();
			logger.info("插入后的订单基本信息的ID是 " + customerOrderBaseId);
			Set<Long> businessIds = businessProductMap.keySet();
			int index = 0;
			//遍历商家信息，并保存此商家订单信息和此商家下面的订单详细信息
			for(Iterator<Long> iter = businessIds.iterator();iter.hasNext();){
				Long businessId = iter.next();
				
				//生成商家订单的订单号
				String businessOrderNumber = this.generateOrderDetailNumber(
						orderNumberBase, index + 1);
				index++;
				//生成商家订单信息
				BusinessOrder businessOrder = new BusinessOrder();
				businessOrder.setOrderBaseId(customerOrderBaseId);
				businessOrder.setBusinessId(businessId);
				businessOrder.setOrderNumber(businessOrderNumber);
				
				Integer businessOrderNumbers = 0;
				Float businessOrderTotal = 0f;
				List<CustomerOrderDetailed> businessOrderDetaileds = businessProductMap.get(businessId);
				//遍历每个订单详情，计算商家订单的总钱数和总数量
				for(CustomerOrderDetailed businessOrderDetailed : businessOrderDetaileds){
					Integer numbers = businessOrderDetailed.getNumbers();
					Float total = businessOrderDetailed.getTotal();
					businessOrderNumbers += numbers;
					businessOrderTotal += total;
				}
				
				businessOrder.setCount(businessOrderNumbers);
				businessOrder.setTotalCash(businessOrderTotal);
				businessOrder.setUpdateTime(currentDate);
				//保存商家订单信息
				businessOrder = this.businessOrderAtomService.insertBusinessOrder(businessOrder);
				Long businessOrderId = businessOrder.getId();
				logger.info("新增的商家订单的ID是 " + businessOrderId);
				//保存订单详细信息
				for(CustomerOrderDetailed customerOrderDetailed : businessOrderDetaileds){
					customerOrderDetailed.setBusinessOrderId(businessOrderId);
					customerOrderDetailed.setCustomerOrderId(customerOrderBaseId);
					customerOrderDetailed.setDetailOrderNumber(businessOrderNumber);
					customerOrderDetailed = this.customerOrderDetailedAtomService.insertCustomerOrderDetailed(customerOrderDetailed);
				}
			}
			//最后，还需要更新购物车中相应商品的状态
			//shoppingCartIds
			for(Long shoppingCartId : shoppingCartIds){
				ShoppingCart shoppingCart = new ShoppingCart();
				shoppingCart.setId(shoppingCartId);
				shoppingCart.setStatus(Constant.CART_STATUS_DISABLED);
				this.shoppingCartAtomService.updateCart2Disabled(shoppingCart);
			}
			response.setResponseBody(customerOrderBase);
			header.setErrorCode(ErrorCode.SUCCESS);
			header.setMessage("生成订单成功");
		} catch (Exception e) {
			logger.error("生成用户订单异常,异常信息是:" + e.getLocalizedMessage(), e);
			header.setErrorCode(ErrorCode.INSERT_EXCEPTION);
			header.setMessage("生成订单异常");
		}
		response.setResponseHeader(header);
		return response;
	}

	@Override
	public RestResponse deleteUserOrder(CustomerOrderBase customerOrderBase)
			throws Exception {
		RestResponse response = new RestResponse();
		ResponseHeader header = new ResponseHeader();
		try {
			customerOrderBase.setStatus(Constant.ORDER_STATUS_DISABLED);
			int count = this.customerOrderBaseAtomService.updateCustomerOrderBase2Disabled(customerOrderBase);
			if(count > 0){
				logger.info("删除订单成功");
				header.setErrorCode(ErrorCode.SUCCESS);
				header.setMessage("删除订单成功");
			}else{
				logger.info("删除订单失败");
				header.setErrorCode(ErrorCode.OPERATE_FAIL);
				header.setMessage("删除订单失败");
			}
			
		} catch (Exception e) {
			logger.info("删除订单异常,异常信息是:" + e.getLocalizedMessage(), e);
			header.setErrorCode(ErrorCode.UPDATE_EXCEPTION);
			header.setMessage("删除订单异常");
		}
		response.setResponseHeader(header);
		return response;
	}

}
