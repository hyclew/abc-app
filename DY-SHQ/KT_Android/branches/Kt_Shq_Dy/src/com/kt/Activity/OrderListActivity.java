package com.kt.Activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.kt.Adapter.OrderListAdapter;
import com.kt.Bean.OrderListBean;
import com.kt.KtApi.KtInterface;
import com.kt.kt_shq_dy.R;

//===========================================================
//   订单列表activity
//==========================================================

public class OrderListActivity extends Activity implements OnClickListener{
	private ListView lt_order_list;
	private TextView tv_order_number,tv_order_money;
	private ImageView iv_immediatepay,iv_cancelorder,im_return;
	private String url;
	private RequestQueue mQueue;
	private List<OrderListBean> olist=new ArrayList<OrderListBean>();
	private OrderListAdapter orderlistAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_orderlist);
		
		byId();
		listener();
		orderHttp();
		setAdapter();
	}
	//初始化
	public void byId(){
		im_return=(ImageView) findViewById(R.id.im_return);
		lt_order_list=(ListView) findViewById(R.id.lt_order_list);
		tv_order_number=(TextView) findViewById(R.id.tv_order_number);
		tv_order_money=(TextView) findViewById(R.id.tv_order_money);
		iv_immediatepay=(ImageView) findViewById(R.id.iv_immediatepay);
		iv_cancelorder=(ImageView) findViewById(R.id.iv_cancelorder);
		url=KtInterface.ORDERLIST+getIntent().getStringExtra("id");
		mQueue=Volley.newRequestQueue(this);
		
		tv_order_number.setText("订单号："+getIntent().getStringExtra("number"));

//		if(getIntent().getStringExtra("s").equals("1")){
//			iv_cancelorder.setVisibility(View.INVISIBLE);
//			iv_immediatepay.setVisibility(View.INVISIBLE);
//		}
	}
	//监听方法
	public void listener(){
		im_return.setOnClickListener(this);
		iv_immediatepay.setOnClickListener(this);
		iv_cancelorder.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		//返回
		case R.id.im_return:
			finish();
			break;
		//取消
		case R.id.iv_cancelorder:
			
			break;
		//支付
		case R.id.iv_immediatepay:
			
			break;
		}
		
	}
	//列表适配器
	public void setAdapter(){
		orderlistAdapter= new OrderListAdapter(this,olist);
		lt_order_list.setAdapter(orderlistAdapter);
		
	}
	//列表网络请求
	public void orderHttp(){
		StringRequest myStringRequest = new StringRequest(Request.Method.GET,
				url, new Response.Listener<String>() {

					@Override
					public void onResponse(String response) {
						Log.e("lllllllllllllllllllllllllll", response);
						try {
							org.json.JSONObject json = new org.json.JSONObject(response);
							org.json.JSONObject header=json.getJSONObject("responseHeader");
							String errorCode=header.getString("errorCode");
							String message=header.getString("message");
							if(errorCode.equals("0000")){
							olist=com.alibaba.fastjson.JSONObject.parseArray(json
										.getJSONArray("responseBody").toString(),OrderListBean.class);
							
							Log.e("sssssssss", olist.toString());
							
							setAdapter();
							}else{
								Toast.makeText(OrderListActivity.this, message, Toast.LENGTH_LONG).show();
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}, new Response.ErrorListener() {
					@Override
					public void onErrorResponse(VolleyError error) {
						Log.e("TAG", error.getMessage(), error);
						Toast.makeText(OrderListActivity.this, "网络连接错误！",
								Toast.LENGTH_LONG).show();
					}
				});
		mQueue.add(myStringRequest);
	}
}
