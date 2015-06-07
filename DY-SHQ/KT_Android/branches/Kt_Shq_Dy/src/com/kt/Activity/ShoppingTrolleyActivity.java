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
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.kt.Adapter.ShoppingListAdapter;
import com.kt.Bean.BusinessCartDomain;
import com.kt.Bean.DeleteCart;
import com.kt.Bean.ListBusinessCart;
import com.kt.Bean.ShoppingCartBean;
import com.kt.Bean.ShoppingCartId;
import com.kt.KtApi.KtInterface;
import com.kt.kt_shq_dy.R;

//===========================================================
//   购物车activity
//==========================================================

public class ShoppingTrolleyActivity extends Activity implements OnClickListener{
	private ShoppingListAdapter shoppingListAdapter;
	private ListView shopping_list;
	private CheckBox iv_shopping_cb;
	private String url,rid;
	private RequestQueue mQueue;
	private List<BusinessCartDomain> blist=new ArrayList<BusinessCartDomain>();
	private List<ShoppingCartBean> shoppingList=new ArrayList<ShoppingCartBean>();
	private List<ShoppingCartId> idList=new ArrayList<ShoppingCartId>();
	private ImageView iv_shopping_delete,iv_shopping_settlement,im_return;
	private Double s=0.00,p=0.00;
	private TextView tv_shopping_total,tv_shopping_total_deyang;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shoppingtrolley);
		
		byId();
		litener();
		getHttp();
		total();
	}
	
	//属性初始化
	public void byId(){
		shopping_list=(ListView) findViewById(R.id.shopping_list);
		im_return=(ImageView) findViewById(R.id.im_return);
		iv_shopping_settlement=(ImageView) findViewById(R.id.iv_shopping_settlement);
		iv_shopping_cb=(CheckBox) findViewById(R.id.iv_shopping_cb);
		iv_shopping_delete=(ImageView) findViewById(R.id.iv_shopping_delete);
		tv_shopping_total=(TextView) findViewById(R.id.tv_shopping_total);
		tv_shopping_total_deyang=(TextView) findViewById(R.id.tv_shopping_total_deyang);
		mQueue = Volley.newRequestQueue(this);
		SharedPreferences sharedPreferences= getSharedPreferences("test", Activity.MODE_PRIVATE); 
		rid= sharedPreferences.getString("sessionId","");
		url=KtInterface.GETCART+rid;
	}
	//监听方法
	public void litener(){
		im_return.setOnClickListener(this);
		iv_shopping_delete.setOnClickListener(this);
		iv_shopping_settlement.setOnClickListener(this);
		iv_shopping_cb.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				total();
			}
		});
    }  
	
	//监听事件
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.im_return:
			finish();
			break;
		
		case R.id.iv_shopping_delete:
			try {
				deleteHttp();
			} catch (JSONException e) {
				e.printStackTrace();
			}
			break;
		case R.id.iv_shopping_settlement:
			Intent intent=new Intent();
			if(idList.size()>0){
				intent.setClass(ShoppingTrolleyActivity.this, InformationActivity.class);
				startActivity(intent);
			
			}else{
				Toast.makeText(ShoppingTrolleyActivity.this, "请选择要选择的 产品", Toast.LENGTH_LONG).show();
			}
			break;
		}
	}
	//listviw适配
	public void setAdapter(){
		shoppingListAdapter=new ShoppingListAdapter(this,shoppingList,idList,blist,rid,s,p,tv_shopping_total,tv_shopping_total_deyang);
		shopping_list.setAdapter(shoppingListAdapter);
		
	}
	//查看购物车列表数据
	public void getHttp(){
		StringRequest myStringRequest = new StringRequest(Request.Method.GET,url, 
					new Response.Listener<String>() {

					@Override
					public void onResponse(String response) {
						Log.e("122311111111111111111111", response);
						try {
							org.json.JSONObject json = new org.json.JSONObject(response);
							org.json.JSONObject header=json.getJSONObject("responseHeader");
							String errorCode=header.getString("errorCode");
							String message=header.getString("message");
							if(errorCode.equals("0000")){
								shoppingList = com.alibaba.fastjson.JSONObject.parseArray(
										json.getJSONArray("responseBody").toString(), ShoppingCartBean.class);
								
								setAdapter();
								
							}else{
								Toast.makeText(ShoppingTrolleyActivity.this, message, Toast.LENGTH_LONG).show();
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}, new Response.ErrorListener() {
					@Override
					public void onErrorResponse(VolleyError error) {
						Log.e("TAG", error.getMessage(), error);
						Toast.makeText(ShoppingTrolleyActivity.this, "网络连接错误！",
								Toast.LENGTH_LONG).show();
					}
				});

		mQueue.add(myStringRequest);
	}
	//删除购物车
	public void deleteHttp()throws JSONException{
		DeleteCart delete= new  DeleteCart();
		delete.sessionId=rid;
		delete.shoppingCartList=idList;
		
		Gson gson=new Gson();
		String str = gson.toJson(delete);
		org.json.JSONObject jsonObject = new org.json.JSONObject(str);
		Log.e("..................................", jsonObject.toString());
		
		JsonRequest<JSONObject> jsonRequest = new JsonObjectRequest(Method.POST, KtInterface.DELCART, jsonObject,
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
								//删除成功
								Log.e("1111111111111111111111111", shoppingList.size()+"");
								Toast.makeText(ShoppingTrolleyActivity.this,message, Toast.LENGTH_LONG).show();
								shoppingList.clear();
								shoppingListAdapter.notifyDataSetChanged();
								getHttp();
								tv_shopping_total.setText("合计"+"0.00"+"元");
				            	tv_shopping_total_deyang.setText("合计"+"0.00"+"元");
							} else {
								Toast.makeText(ShoppingTrolleyActivity.this,message,Toast.LENGTH_LONG).show();
							}
							
						} catch (JSONException e) {
							e.printStackTrace();
						}
					}
				}, new Response.ErrorListener() {
					@Override
					public void onErrorResponse(VolleyError error) {
						Log.e("TAG", error.getMessage(), error);
						Toast.makeText(ShoppingTrolleyActivity.this,"网络连接错误！", Toast.LENGTH_LONG).show();
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
	//总计s
	public void total(){
		if(shoppingList.size()>0){
			
			 // 遍历list的长度，将已选的设为未选，未选的设为已选  
           for (int i = 0; i < shoppingList.size(); i++) {  
               if (iv_shopping_cb.isChecked()==true) {  
               	shoppingListAdapter.getIsSelected().put(i, true); 
               	p+=Double.parseDouble(shoppingList.get(i).getProductPreferPrice())*Double.parseDouble(shoppingList.get(i).getCount());;
               	s+=Double.parseDouble(shoppingList.get(i).getProductSalePrice())*Double.parseDouble(shoppingList.get(i).getCount());
               	
               } else {  
               	shoppingListAdapter.getIsSelected().put(i, false);  
               	p-=Double.parseDouble(shoppingList.get(i).getProductPreferPrice())*Double.parseDouble(shoppingList.get(i).getCount());
               	s-=Double.parseDouble(shoppingList.get(i).getProductSalePrice())*Double.parseDouble(shoppingList.get(i).getCount());
               }  
               Log.e("sssssssssssssssssssssssssssssssssssssss", s+"");
       		Log.e("ppppppppppppppppppppppppppppppppppppppp", p+"");
               tv_shopping_total.setText("合计："+String.valueOf(s)+"元");
       		tv_shopping_total_deyang.setText("合计："+String.valueOf(p)+"元");
           }  
           shoppingListAdapter.notifyDataSetChanged();
		}
	}
}