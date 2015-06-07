package com.kt.Activity;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.kt.Adapter.WaterListAdapter;
import com.kt.Bean.LifeBean;
import com.kt.KtApi.KtInterface;
import com.kt.Util.XListView;
import com.kt.Util.XListView.IXListViewListener;
import com.kt.kt_shq_dy.R;

//===========================================================
//   送水列表activity
//==========================================================

public class BottledWaterActivity extends Activity implements OnClickListener,IXListViewListener{
	//属性初始化
	private ImageView im_return;
	private XListView xlist_water;
	private List<LifeBean> lifebean=new ArrayList<LifeBean>();
	private WaterListAdapter waterAdapter;
	private RequestQueue mQueue;
	private Intent intent;
	private String url;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bottledwater);
		
		byId();
		adapter();
		http();
		listener();
	}
	//赋值
	public void byId(){
		url=KtInterface.WATERLIST+"/0/10";
		mQueue = Volley .newRequestQueue(getApplicationContext());
		intent=new Intent();
		im_return=(ImageView) findViewById(R.id.im_return);
		xlist_water=(XListView) findViewById(R.id.list_water);
		xlist_water.setXListViewListener(this);
		xlist_water.setPullLoadEnable(false);
		
	}
	//监听
	public void listener(){
		xlist_water.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				
				String x=lifebean.get(position-1).getId();
				intent.setClass(BottledWaterActivity.this,WaterDetailsActivity.class);
				intent.putExtra("id",x);
				startActivity(intent);
				
			}
		});
		im_return.setOnClickListener(this);
	}
	//点击事件
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.im_return:
			finish();
			break;

		}
	}
	//网络请求
	public void http(){
		
		StringRequest myStringRequest=new StringRequest(Request.Method.GET,url, new Response.Listener<String>() {

			@Override
			public void onResponse(String response) {
				try {
					org.json.JSONObject json = new org.json.JSONObject(response);
					org.json.JSONObject header=json.getJSONObject("responseHeader");
					String errorCode=header.getString("errorCode");
					String message=header.getString("message");
					if(errorCode.equals("0000")){
						
					List<LifeBean> list = com.alibaba.fastjson.JSONObject.parseArray(
							json.getJSONArray("responseBody").toString(), LifeBean.class);
					
					lifebean.addAll(list);
					xlist_water.setPullLoadEnable(true);
					waterAdapter.notifyDataSetChanged();
					
					}else{
						Toast.makeText(BottledWaterActivity.this, message, Toast.LENGTH_LONG).show();
					}
					onLoad();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}, new Response.ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError error) {
				Log.e("TAG", error.getMessage(), error);
				Toast.makeText(BottledWaterActivity.this,"网络连接错误！", Toast.LENGTH_LONG).show();
			}
	      });
						
		mQueue.add(myStringRequest);
	}
	//adapter适配
	public void adapter(){
		waterAdapter=new WaterListAdapter(this, lifebean);
		xlist_water.setAdapter(waterAdapter);
	}
	//下拉刷新
	@Override
	public void onRefresh() {
		xlist_water.setPullLoadEnable(false);
		lifebean.clear();
		url=KtInterface.WATERLIST+"/0/10";
		http();
	}
	//上拉加载
	@Override
	public void onLoadMore() {
		LifeBean life=new LifeBean();
		life.maxid=lifebean.get(lifebean.size()-1).getId();
		url=KtInterface.WATERLIST+"/"+life.maxid+"/10";
		http();
	}
	
	private void onLoad() {
		xlist_water.stopRefresh();
		xlist_water.stopLoadMore();
		xlist_water.setRefreshTime();
	}
}

