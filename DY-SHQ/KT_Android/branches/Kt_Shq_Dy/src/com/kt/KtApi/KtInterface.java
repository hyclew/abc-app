package com.kt.KtApi;

public class KtInterface {
//	private static final String HOST = "http://192.168.2.103:8090/";
	private static final String HOST ="http://172.20.10.3:8090/";
	
	//送水列表
	public static final String WATERLIST=HOST+"water/waterinformations/1001";
	//送水详情
	public static final String WATERDETAILS=HOST+"water/waterdetail/";
	//送水列表头像
	public static final String WATERHEAD=HOST+"resources/resource/";
	//注册
	public static final String REGISTER=HOST+"user/register";
	//登录
	public static final String LOGIN=HOST+"user/login/";
	//送水详情评论
	public static final String COMMENT=HOST+"productcomment/productcomments/";
	//广告列表
	public static final String ADVERT=HOST+"productadvert/latestadverts";
	//加入购物车
	public static final String ADDCART=HOST+"shoppingcart/addcart";
	//更新购物车
	public static final String UPDATECART=HOST+"shoppingcart/updatecart";
	//查看购物车
	public static final String GETCART=HOST+"shoppingcart/usercarts/";
	//删除购物车
	public static final String DELCART=HOST+"shoppingcart/delcartlist";
	//我的订单列表
	public static final String MYORDER=HOST+"order/userorderbases/";
	//查看收货人
	public static final String COLLECT=HOST+"orderaddress/getaddresses/";
	//新增收货人
	public static final String NEWCOLLECT=HOST+"orderaddress/addaddress";
	//提交订单
	public static final String SUBMITORDER=HOST+"order/addorder";
	//订单详细
	public static final String ORDERLIST=HOST+"order/orderdetaileds/";
	
	
}
