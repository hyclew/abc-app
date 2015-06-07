package com.kt.Activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.Request.Method;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.kt.Bean.BusinessCartDomain;
import com.kt.Bean.GoodsReceiptBean;
import com.kt.Bean.LifeBean;
import com.kt.Bean.ListBusinessCart;
import com.kt.Bean.NewGoodsReceipt;
import com.kt.Bean.SubmitOrders;
import com.kt.KtApi.KtInterface;
import com.kt.kt_shq_dy.R;
import com.kt.kt_shq_dy.R.id;

//===========================================================
//   信息确认activity
//==========================================================

public class InformationActivity extends Activity implements OnClickListener{
	private ImageView im_return,im_information_submit,im_information_xuan,iv_information_add,im_information_personal,im_information_firm;
	private TextView tv_information_Address,tv_information_name,tv_information_phone,tv_new_address;
	private EditText et_information_new_name,et_information_new_addrress,
						et_information_new_phone,ed_firm;
	private LinearLayout ll_information_new_address,ll_information_invoice,ll_information_you;
	private RadioGroup invoice;
	private RadioButton male,female;
	private boolean c=true ,d=true,f;
	private String sessionId,url,id;
	private String isClub;
	private RequestQueue mQueue;
	private int isInvoice;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_information);
		
		byId();
		addressHttp();
		listener();
		checkBox();
	}
	//属性初始化
	public void byId(){
		SharedPreferences sharedPreferences= getSharedPreferences("test", Activity.MODE_PRIVATE); 
		sessionId= sharedPreferences.getString("sessionId","");
		url=KtInterface.COLLECT+sessionId;
		mQueue=Volley.newRequestQueue(this);
		
		im_return=(ImageView) findViewById(R.id.im_return);
		im_information_submit=(ImageView) findViewById(R.id.im_information_submit);
		tv_information_Address=(TextView) findViewById(R.id.tv_information_Address);
		tv_information_name=(TextView) findViewById(R.id.tv_information_name);
		tv_information_phone=(TextView) findViewById(R.id.tv_information_phone);
		et_information_new_name=(EditText) findViewById(R.id.et_information_new_name);
		et_information_new_addrress=(EditText) findViewById(R.id.et_information_new_addrress);
		et_information_new_phone=(EditText) findViewById(R.id.et_information_new_phone);
		im_information_xuan=(ImageView) findViewById(R.id.im_information_xuan);
		tv_new_address=(TextView) findViewById(R.id.tv_new_address);
		ll_information_new_address=(LinearLayout) findViewById(R.id.ll_information_new_address);
		invoice=(RadioGroup) findViewById(R.id.invoice);
		male=(RadioButton) findViewById(R.id.male);
		female=(RadioButton) findViewById(R.id.female);
		ll_information_invoice=(LinearLayout) findViewById(R.id.ll_information_invoice);
		iv_information_add=(ImageView) findViewById(R.id.iv_information_add);
		ll_information_you=(LinearLayout) findViewById(R.id.ll_information_you);
		im_information_personal=(ImageView) findViewById(R.id.im_information_personal);
		im_information_firm=(ImageView) findViewById(R.id.im_information_firm);
		ed_firm=(EditText) findViewById(R.id.ed_firm);
	}
	//监听方法
	public void listener(){
		im_return.setOnClickListener(this);
		im_information_submit.setOnClickListener(this);
		tv_new_address.setOnClickListener(this);
		im_information_xuan.setOnClickListener(this);
		iv_information_add.setOnClickListener(this);
		ll_information_you.setOnClickListener(this);
		im_information_personal.setOnClickListener(this);
		im_information_firm.setOnClickListener(this);
		invoice.setOnCheckedChangeListener(new OnCheckedChangeListenerImp());
	}
	//单选按钮
	private class OnCheckedChangeListenerImp implements OnCheckedChangeListener {

		public void onCheckedChanged(RadioGroup group, int checkedId) {
			
			if (InformationActivity.this.male.getId() == checkedId) {
				ll_information_invoice.setVisibility(View.VISIBLE);
				isInvoice=1;
				isClub="1";
			} else if (InformationActivity.this.female.getId() == checkedId) {
				ll_information_invoice.setVisibility(View.GONE);
				isInvoice=0;
				if(isInvoice==0){
					isClub="";
					ed_firm.getText().toString().equals(null);
					return;
				}
			}
		}
	}
	
	//监听事件
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		//返回按钮
		case R.id.im_return:
			finish();
			break;
			//默认按钮
		case R.id.im_information_xuan:
			if(c==true){
				im_information_xuan.setImageResource(R.drawable.im_shopping_no);
				et_information_new_name.setEnabled(true);
				et_information_new_addrress.setEnabled(true);
				et_information_new_phone.setEnabled(true);
				c=false;
			}else{
				im_information_xuan.setImageResource(R.drawable.im_shopping_yes);
				et_information_new_name.setEnabled(false);
				et_information_new_addrress.setEnabled(false);
				et_information_new_phone.setEnabled(false);
				c=true;
			}
			break;
			//提交按钮
		case R.id.im_information_submit:
			try {
				submitHttp();
			} catch (JSONException e1) {
				e1.printStackTrace();
			}

			break;
			//添加新地址按钮
		case R.id.tv_new_address:
			if(d==true){
				ll_information_new_address.setVisibility(View.VISIBLE);
				d=false;
			}else{
				ll_information_new_address.setVisibility(View.GONE);
				d=true;
			}
			break;
			//确认添加
		case R.id.iv_information_add:
			try {
				newHttp();
			} catch (JSONException e) {
				e.printStackTrace();
			}
			break;
			//跳转地址列表
		case R.id.ll_information_you:
			
			break;
			//发票个人
		case R.id.im_information_personal:
			f=true;
			if(f==true){
				im_information_personal.setImageResource(R.drawable.im_shopping_yes);
				im_information_firm.setImageResource(R.drawable.im_shopping_no);
				isClub="1";
				ed_firm.setEnabled(false);
				f=false;
			}
			break;
			//发票单位
		case R.id.im_information_firm:
			f=false;
			if(f==false){
				im_information_personal.setImageResource(R.drawable.im_shopping_no);
				im_information_firm.setImageResource(R.drawable.im_shopping_yes);
				isClub="0";
				ed_firm.setEnabled(true);
				f=true;
			}
			break;
		}
	}
	//判断输入框能不能输入
	public void checkBox(){
		if(c==true){
			et_information_new_name.setEnabled(false);
			et_information_new_addrress.setEnabled(false);
			et_information_new_phone.setEnabled(false);
		}else{
			et_information_new_name.setEnabled(true);
			et_information_new_addrress.setEnabled(true);
			et_information_new_phone.setEnabled(true);
		}
	}
	//默认地址网络请求
	public void addressHttp(){
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
						List<GoodsReceiptBean> list=com.alibaba.fastjson.JSONObject.parseArray(
								json.getJSONArray("responseBody").toString(), GoodsReceiptBean.class);
					id=list.get(0).getId();
					tv_information_Address.setText("收货地址："+list.get(0).getAddress());
					tv_information_name.setText("联系人："+list.get(0).getName());
					tv_information_phone.setText("联系电话："+list.get(0).getPhone());
					
					Toast.makeText(InformationActivity.this, message, Toast.LENGTH_LONG).show();
					}else{
					Toast.makeText(InformationActivity.this, message, Toast.LENGTH_LONG).show();
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
				}
			}, new Response.ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError error) {
				Log.e("TAG", error.getMessage(), error);
				Toast.makeText(InformationActivity.this, "网络连接错误！",Toast.LENGTH_LONG).show();
			}
		});
		mQueue.add(sRequest);
	}
	//添加新地址网络请求
	public void newHttp()throws JSONException{
		NewGoodsReceipt goods=new NewGoodsReceipt();
		goods.userSession.sessionId=sessionId;
		goods.userOrderAddress.address=et_information_new_addrress.getText().toString();
		goods.userOrderAddress.name=et_information_new_name.getText().toString();
		goods.userOrderAddress.phone=et_information_new_phone.getText().toString();
		
		Gson gson=new Gson();
		String str=gson.toJson(goods);
		org.json.JSONObject jsonObject = new org.json.JSONObject(str);
		
		JsonRequest<JSONObject> jsonRequest = new JsonObjectRequest(
				Method.POST, KtInterface.NEWCOLLECT, jsonObject,
				new Response.Listener<JSONObject>() {
					@Override
					public void onResponse(JSONObject response) {
						Log.e("TAG", response.toString());
						try {
							org.json.JSONObject ojb = new JSONObject(response.toString());
							org.json.JSONObject header = ojb.getJSONObject("responseHeader");
							String error = header.getString("errorCode");
							String message = header.getString("message");
							if (error.equals("0000")) {
								
								Toast.makeText(InformationActivity.this,message, Toast.LENGTH_LONG).show();
							} else {
								Toast.makeText(InformationActivity.this,message,Toast.LENGTH_LONG).show();
							}
							
						} catch (JSONException e) {
							e.printStackTrace();
						}
					}
				}, new Response.ErrorListener() {
					@Override
					public void onErrorResponse(VolleyError error) {
						Log.e("TAG", error.getMessage(), error);
						Toast.makeText(InformationActivity.this,"网络连接错误！", Toast.LENGTH_LONG).show();
					}
				}) {

			@Override
			public Map<String, String> getHeaders() {
				HashMap<String, String> headers = new HashMap<String, String>();
				headers.put("Accept", "application/json");
				headers.put("Content-Type", "application/json; charset=UTF-8");

				return headers;
			}
		};
		mQueue.add(jsonRequest);
	}
	//提交订单网络请求
	public void submitHttp() throws JSONException{
		
		SubmitOrders so=new SubmitOrders();
		so.sessionId=sessionId;
		so.customerOrderBase.isInvoice=String.valueOf(isInvoice);
		so.customerOrderBase.isClub=isClub;
		so.customerOrderBase.invoiceTitle=ed_firm.getText().toString();
		so.userOrderAddress.id=id;
		so.businessCartDomain=ListBusinessCart.blist;
		
		Gson gson =new Gson();
		String str=gson.toJson(so);
		org.json.JSONObject jsonObject = new org.json.JSONObject(str);
		Log.e("json~~~~~~~~~~~~~~~~~~~~~~~~", jsonObject.toString());
		
		JsonRequest<JSONObject> jsonRequest = new JsonObjectRequest(Method.POST, KtInterface.SUBMITORDER, jsonObject,
				new Response.Listener<JSONObject>() {
					@Override
					public void onResponse(JSONObject response) {
						Log.e("TAG", response.toString());
						try {
							org.json.JSONObject ojb = new JSONObject(response.toString());
							org.json.JSONObject header = ojb.getJSONObject("responseHeader");
							String error = header.getString("errorCode");
							String message = header.getString("message");
							if (error.equals("0000")) {
								
								Toast.makeText(InformationActivity.this,message, Toast.LENGTH_LONG).show();
								Intent intent=new Intent();
								intent.setClass(InformationActivity.this, OnlinePaymentActivity.class);
								startActivity(intent);
							} else {
								Toast.makeText(InformationActivity.this,message,Toast.LENGTH_LONG).show();
							}
							
						} catch (JSONException e) {
							e.printStackTrace();
						}
					}
				}, new Response.ErrorListener() {
					@Override
					public void onErrorResponse(VolleyError error) {
						Log.e("TAG", error.getMessage(), error);
						Toast.makeText(InformationActivity.this,"网络连接错误！", Toast.LENGTH_LONG).show();
					}
				}) {

			@Override
			public Map<String, String> getHeaders() {
				HashMap<String, String> headers = new HashMap<String, String>();
				headers.put("Accept", "application/json");
				headers.put("Content-Type", "application/json; charset=UTF-8");

				return headers;
			}
		};
		mQueue.add(jsonRequest);
	}
}
