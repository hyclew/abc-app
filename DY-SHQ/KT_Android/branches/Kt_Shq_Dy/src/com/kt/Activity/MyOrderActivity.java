package com.kt.Activity;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.kt.Adapter.MyOrderAdapter;
import com.kt.Bean.MyOrderBean;
import com.kt.KtApi.KtInterface;
import com.kt.kt_shq_dy.R;

//===========================================================
//   我的订单activity
//==========================================================

public class MyOrderActivity extends Activity implements OnClickListener{
	private ListView lv_myorder_list;
	private MyOrderAdapter adapter;
	private List<MyOrderBean> orderList =new ArrayList<MyOrderBean>();
	private RequestQueue mQueue;
	private String url,sessionId;
	private ImageView im_return,iv_stay_ayment,iv_stay_pay,iv_stay_finish;
	private Intent intent;
	private String s;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_myorder);
		
		buId();
		setAdapter();
		orderHttp();
		listener();
	}
	//初始化
	public void buId(){
		lv_myorder_list=(ListView) findViewById(R.id.lv_myorder_list);
		SharedPreferences sharedPreferences= getSharedPreferences("test", Activity.MODE_PRIVATE); 
		sessionId= sharedPreferences.getString("sessionId","");
		url=KtInterface.MYORDER+"5D1AC4544EA774BD20E527C38CB8BB33"+"/0";
		mQueue=Volley.newRequestQueue(this);
		intent=new Intent();
		im_return=(ImageView) findViewById(R.id.im_return);
		iv_stay_ayment=(ImageView) findViewById(R.id.iv_stay_ayment);
		iv_stay_pay=(ImageView) findViewById(R.id.iv_stay_pay);
		iv_stay_finish=(ImageView) findViewById(R.id.iv_stay_finish);
	}
	//监听方法
	public void listener(){
		lv_myorder_list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View view, int arg2,
					long arg3) {
				
				intent.setClass(MyOrderActivity.this, OrderListActivity.class);
				intent.putExtra("id", orderList.get(arg2).getId());
				intent.putExtra("s", s);
				intent.putExtra("number",orderList.get(arg2).getOrderNumber());
				startActivity(intent);
			}
		});
		im_return.setOnClickListener(this);
		iv_stay_ayment.setOnClickListener(this);
		iv_stay_pay.setOnClickListener(this);
		iv_stay_finish.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.im_return:
			finish();
			break;

		case R.id.iv_stay_ayment:
			iv_stay_ayment.setImageResource(R.drawable.hui_stay_ayment);
			iv_stay_pay.setImageResource(R.drawable.bai_stay_pay);
			iv_stay_finish.setImageResource(R.drawable.bai_stay_finish);
			s="0";
			orderList.clear();
			adapter.notifyDataSetChanged();
			url=KtInterface.MYORDER+"5D1AC4544EA774BD20E527C38CB8BB33"+"/0";
			orderHttp();
			break;
			
		case R.id.iv_stay_pay:
			
			iv_stay_ayment.setImageResource(R.drawable.bai_stay_ayment);
			iv_stay_pay.setImageResource(R.drawable.hui_stay_pay);
			iv_stay_finish.setImageResource(R.drawable.bai_stay_finish);
			s="1";
			orderList.clear();
			adapter.notifyDataSetChanged();
			url=KtInterface.MYORDER+"5D1AC4544EA774BD20E527C38CB8BB33"+"/1";
			orderHttp();
			break;
			
		case R.id.iv_stay_finish:
			iv_stay_ayment.setImageResource(R.drawable.bai_stay_ayment);
			iv_stay_pay.setImageResource(R.drawable.bai_stay_pay);
			iv_stay_finish.setImageResource(R.drawable.hui_stay_finish);
			s="2";
			orderList.clear();
			adapter.notifyDataSetChanged();
			url=KtInterface.MYORDER+"5D1AC4544EA774BD20E527C38CB8BB33"+"/2";
			orderHttp();
			break;
		}
		
	}
	
	//列表适配
	public void setAdapter(){
		adapter=new MyOrderAdapter(this, orderList);
		lv_myorder_list.setAdapter(adapter);
	}
	//我的订单网络请求
	public void orderHttp(){
		StringRequest sRequest=new StringRequest(Request.Method.GET,
				url, new Response.Listener<String>() {

			@Override
			public void onResponse(String response) {
				Log.e("............................", response);
				try {
					org.json.JSONObject json = new org.json.JSONObject(response);
					org.json.JSONObject header=json.getJSONObject("responseHeader");
					String errorCode=header.getString("errorCode");
					String message=header.getString("message");
					
					if(errorCode.equals("0000")){
					orderList = com.alibaba.fastjson.JSONObject.parseArray(
							json.getJSONArray("responseBody").toString(), MyOrderBean.class);
					
					adapter.notifyDataSetChanged();
					setAdapter();
				
					Toast.makeText(MyOrderActivity.this, message, Toast.LENGTH_LONG).show();
					}else{
					Toast.makeText(MyOrderActivity.this, message, Toast.LENGTH_LONG).show();
					}
				} catch (JSONException e) {
					
					e.printStackTrace();
				}
				}
			}, new Response.ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError error) {
				Log.e("TAG", error.getMessage(), error);
				Toast.makeText(MyOrderActivity.this, "网络连接错误！",Toast.LENGTH_LONG).show();
			}
		});
		mQueue.add(sRequest);
	}
	
}
