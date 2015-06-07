package com.kingteller.bs.framework.constant;

/**
 * 定义状态及编码类常量
 * @author wangyafei
 *
 */
public class Constant {

	public static final String PRODUCT_ADVERT_ENABLE = "1"; //商品广告可用
	public static final String PRODUCT_ADVERT_DISABLE = "0"; //商品广告不可用
	
	public static final String PRODUCT_CATALOGUE_WATER = "1001"; //商品类别-送水
	public static final String PRODUCT_CATALOGUE_WASHCLOTHES = "1002"; //商品类别-洗衣
	public static final String PRODUCT_CATALOGUE_WASHCAR = "1003"; //商品类别-洗车
	public static final String PRODUCT_CATALOGUE_HOUSEKEEPING = "1004"; //商品类别-家政
	public static final String PRODUCT_CATALOGUE_SUPERMARKET = "1005"; //商品类别-超市
	
	public static final String PRODUCT_CATALOGUE_ENABLED = "1"; //产品类别-可用
	public static final String PRODUCT_CATALOGUE_DISABLED = "0"; //产品类别-废弃
	
	public static final String USER_TYPE_BUYER = "0"; //用户类型-买家
	public static final String USER_TYPE_SELLER = "1"; //用户类型-卖家
	public static final String USER_TYPE_MANAGER = "2"; //用户类型-管理员
	public static final String USER_TYPE_OTHER = "3"; //用户类型-其他
	
	public static final String ONLINE_STATUS_DEFAULT = "0"; //用户登录状态-默认
	public static final String ONLINE_STATUS_OFF = "1"; //用户登录状态-离线
	public static final String ONLINE_STATUS_ON = "2"; //用户登录状态-在线
	
	public static final String USER_LOGIN_ENABLED = "1"; //用户是否可用-可用
	public static final String USER_LOGIN_DISABLED = "0"; //用户是否可用-不可用
	
	public static final String USER_SESSION_ENABLED = "1"; //用户会话-可用
	public static final String USER_SESSION_DISABLED = "0"; //用户会话-不可用
	
	public static final String SEX_MALE = "0"; //性别-男
	public static final String SEX_FEMALE = "1"; //性别-女
	
	public static final String CART_IS_ORDERED_YES = "1"; //购物车物品是否已下单-是
	public static final String CART_IS_ORDERED_NO = "0"; //购物车物品是否已下单-否
	
	public static final String CART_STATUS_ENABLED = "1"; //购物车状态-正常
	public static final String CART_STATUS_DISABLED = "0"; //购物车状态-删除
	
	public static final String COMMENT_ENABLED = "1"; //商家产品评价-可用
	public static final String COMMENT_DISABLED = "0"; //商家产品评价-不可用
	
	public static final String REGISTER_CHECK_CODE_ENABLED = "1"; //注册验证码-可用
	public static final String REGISTER_CHECK_CODE_DISABLED = "0"; //注册验证码-不可用
	
	public static final String ORDER_STATUS_ENABLED = "1"; //订单状态-正常
	public static final String ORDER_STATUS_DISABLED = "0"; //订单状态-已删除
	
	public static final String ORDER_AUDIT_WAITPAY = "0"; //订单详细状态-待付款
	public static final String ORDER_AUDIT_HASPAID = "1"; //订单详细状态-已支付
	public static final String ORDER_AUDIT_COMPLETE = "2"; //订单详细状态-已完成
	
	
	public static final String USER_STATUS_ENABLED = "0"; //基本信息表中 状态 0-正常
	public static final String USER_STATUS_DISABLED = "1"; //基本信息表中 状态 1-失效
	
	public static final String USERPAY_STATUS_ENABLED = "0"; //支付工具 状态 0-可用
	public static final String USERPAY_STATUS_DISABLED = "1"; //支付工具 状态 1-不可用
	
	public static final String USERPAY_PAYTOOL_DEPOSITCARD = "0"; //支付工具-储蓄卡
	public static final String USERPAY_PAYTOOL_ELECACCOUNT = "1"; //支付工具-电子账户
	public static final String USERPAY_PAYTOOL_TRIPLEPAY = "2"; //支付工具-第三方支付
	
	public static final String BUSINESS_STATUS_ENABLED = "0"; //商家基础信息表 状态 0-可用
	public static final String BUSINESS_STATUS_DISABLED = "1"; //商家基础信息表 状态 1-不可用
	
	public static final String ORDER_BASE_ISINVOICE_YES = "1"; //客户订单是否开发票-开
	public static final String ORDER_BASE_ISINVOICE_NO = "0"; //客户订单是否开发票-不开
	
	public static final String ORDER_BASE_INVOICE_ISCLUB_YES = "0"; //发票抬头是否是公司-是
	public static final String ORDER_BASE_INVOICE_ISCLUB_NO = "1"; //发票抬头是否是公司-否（个人）
	
	public static final String BUSINESS_ACTIVITY_STATUS_ING = "0"; //商家活动状态-进行中
	public static final String BUSINESS_ACTIVITY_STATUS_ED = "1"; //商家活动状态-已结束
	
	public static final String BUSINESS_ACTIVITY_ENABLED = "1"; //商家活动公告是否可用-正常
	public static final String BUSINESS_ACTIVITY_DISABLED = "0"; //商家活动公告是否可用-已删除
	
	public static final String USER_ADDRESS_TYPE_ORDER = "1"; //用户地址类型-订单地址
	public static final String USER_ADDRESS_TYPE_APPOINMENT = "2"; //用户地址类型-预约地址
	
	public static final String USER_ADDRESS_STATUS_ENABLED = "1"; //用户地址状态-可用
	public static final String USER_ADDRESS_STATUS_DISABLED = "0"; //用户地址状态-不可用
	
}
