package com.kt.Activity;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import org.json.JSONObject;

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
import com.kt.Bean.AddCart;
import com.kt.Bean.CommentBean;
import com.kt.Bean.LifeBean;
import com.kt.KtApi.KtInterface;
import com.kt.kt_shq_dy.R;

//===========================================================
//   送水详情activity
//==========================================================

public class WaterDetailsActivity extends Activity implements OnClickListener {
	// viewpager属性
	private int[] imgResIDs = new int[] { R.drawable.b,
			R.drawable.b, R.drawable.b };
	private int[] radioButtonID = new int[] { R.id.radio0, R.id.radio1,
			R.id.radio2 };
	private ViewPager pager;
	private RadioGroup mGroup;
	private ArrayList<View> items = new ArrayList<View>();
	private int mCurrentItem = 0;
	private int mItem;
	private Runnable mPagerAction;
	private boolean isFrist = true;

	// 基本属性
	private Intent intent;
	private ImageView im_return;
	private TextView tv_details_introduction, tv_details_ample,
			tv_details_level, tv_details_card, water_comment_name,
			water_comment, water_comment_more;
	private Button bt_details_join;
	private RequestQueue mQueue;
	private String url;
	private String commenturl;

	// 购物加减
	private ImageView iv_shopping_minus;
	private ImageView iv_shopping_add;
	private TextView tv_water_number;
	private int num=1;
	private int numbers;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_waterdetails);

		byId();
		http();
		commentHttp();
		viewPager();
		litener();
		initAllItems();
	}

	// 属性初始化
	public void byId() {
		// 加入参数拼接的接口
		url = KtInterface.WATERDETAILS + getIntent().getStringExtra("id");
		commenturl = KtInterface.COMMENT + getIntent().getStringExtra("id")
				+ "/0" + "/1";

		im_return = (ImageView) findViewById(R.id.im_return);
		mQueue = Volley.newRequestQueue(this);
		intent = new Intent();
		tv_details_introduction = (TextView) findViewById(R.id.tv_details_introduction);
		tv_details_ample = (TextView) findViewById(R.id.tv_details_ample);
		tv_details_level = (TextView) findViewById(R.id.tv_details_level);
		tv_details_card = (TextView) findViewById(R.id.tv_details_card);
		bt_details_join = (Button) findViewById(R.id.bt_details_join);
		tv_water_number = (TextView) findViewById(R.id.tv_water_number);
		iv_shopping_add = (ImageView) findViewById(R.id.iv_shopping_add);
		iv_shopping_minus = (ImageView) findViewById(R.id.iv_shopping_minus);
		water_comment_name = (TextView) findViewById(R.id.water_comment_name);
		water_comment = (TextView) findViewById(R.id.water_comment);
		water_comment_more = (TextView) findViewById(R.id.water_comment_more);
	}

	// 监听事件
	public void litener() {
		im_return.setOnClickListener(this);
		bt_details_join.setOnClickListener(this);
		iv_shopping_minus.setOnClickListener(this);
		iv_shopping_add.setOnClickListener(this);
		water_comment_more.setOnClickListener(this);
	}

	// 监听方法
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.im_return:
			finish();
			break;
		//加入购物车
		case R.id.bt_details_join:
			try {
				shoppingHttp();
			} catch (JSONException e) {
				e.printStackTrace();
			}
						
			break;
		case R.id.iv_shopping_add:
			if(num<numbers){
			num++;
			tv_water_number.setText(Integer.toString(num));
			}
			break;
		case R.id.iv_shopping_minus:
			if(numbers==num||numbers>num&&1<num){
			num--;
			tv_water_number.setText(Integer.toString(num));
			}
			break;

		case R.id.water_comment_more:

			break;
		}
	}

	// 请求网络，实现列表数据
	public void http() {
		StringRequest myStringRequest = new StringRequest(Request.Method.GET,
				url, new Response.Listener<String>() {

					@Override
					public void onResponse(String response) {
						try {
							org.json.JSONObject json = new org.json.JSONObject(response);
							org.json.JSONObject header=json.getJSONObject("responseHeader");
							String errorCode=header.getString("errorCode");
							String message=header.getString("message");
							if(errorCode.equals("0000")){
							
							Gson gson = new Gson();
							LifeBean obj = gson.fromJson(
									json.getJSONObject("responseBody").toString(), LifeBean.class);

							NumberFormat formatter = NumberFormat.getCurrencyInstance();

							tv_details_introduction.setText("简介："+ obj.getIntroduce());
							tv_details_ample.setText(formatter.format(obj.getSalePrice()));
							tv_details_level.setText(formatter.format(obj.getUnitPrice()));
							tv_details_level.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG ); 
							tv_details_card.setText(formatter.format(obj.getPreferPrice()));
							numbers=Integer.valueOf(obj.getNumbers());
							}else{
								Toast.makeText(WaterDetailsActivity.this, message, Toast.LENGTH_LONG).show();
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}, new Response.ErrorListener() {
					@Override
					public void onErrorResponse(VolleyError error) {
						Log.e("TAG", error.getMessage(), error);
						Toast.makeText(WaterDetailsActivity.this, "网络连接错误！",
								Toast.LENGTH_LONG).show();
					}
				});

		mQueue.add(myStringRequest);

	}

	// 评论网络请求
	public void commentHttp() {
		StringRequest commentRequest = new StringRequest(Request.Method.GET,
				commenturl, new Response.Listener<String>() {
					@Override
					public void onResponse(String response) {
						try {
							org.json.JSONObject json = new org.json.JSONObject(response);

							org.json.JSONObject header = json.getJSONObject("responseHeader");
							String errorCode = header.getString("errorCode");
							String message = header.getString("message");
							
							if (errorCode.equals("0000")) {
							List<CommentBean> cobj = com.alibaba.fastjson.JSONObject.parseArray(json
									.getJSONArray("responseBody").toString(),
									CommentBean.class);

								water_comment_name.setText(cobj.get(0).getUsername());
								water_comment.setText(cobj.get(0).getComment());

							} else {
								Toast.makeText(WaterDetailsActivity.this,
										message, Toast.LENGTH_LONG).show();
							}

						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}, new Response.ErrorListener() {
					@Override
					public void onErrorResponse(VolleyError error) {
						Log.e("TAG", error.getMessage(), error);
						Toast.makeText(WaterDetailsActivity.this, "网络连接错误！",
								Toast.LENGTH_LONG).show();
					}
				});
		mQueue.add(commentRequest);
	}
	
	//加入购物车接口请求
	public void shoppingHttp()throws JSONException{
		AddCart addcart=new AddCart();
		SharedPreferences sharedPreferences= getSharedPreferences("test", Activity.MODE_PRIVATE); 
		addcart.sessionId= sharedPreferences.getString("sessionId","");
		addcart.shoppingCart.count=tv_water_number.getText().toString();
		addcart.shoppingCart.businessProductId=getIntent().getStringExtra("id");
		
		Gson gson2 = new Gson();
		String strid =gson2.toJson(addcart);
        org.json.JSONObject jsonObject =new org.json.JSONObject(strid);
        Log.e("..................", jsonObject.toString());
        JsonRequest<JSONObject> jsonRequest = new JsonObjectRequest(Method.POST,KtInterface.ADDCART, jsonObject,
        	    new Response.Listener<JSONObject>() {
        	        @Override
        	        public void onResponse(JSONObject response) {
        	        	Log.e("----------------------", response.toString());
						try {
							org.json.JSONObject ojb = new JSONObject(response.toString());
							org.json.JSONObject header=ojb.getJSONObject("responseHeader");
							String error= header.getString("errorCode");
							String message=header.getString("message");
							if(error.equals("0000")){
								dialog();
							}else{
								Toast.makeText(WaterDetailsActivity.this, message, Toast.LENGTH_LONG).show();
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
        	        }
        	    }, new Response.ErrorListener() {
        	        @Override
        	        public void onErrorResponse(VolleyError error) {
        	            Log.e("TAG", error.getMessage(), error);
        	            Toast.makeText(WaterDetailsActivity.this,"请检查网络后重试！", Toast.LENGTH_LONG).show();
        	        }
        	    })
        	    {
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
	
	// 加入购物车提示框
	public void dialog() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage("加入成功！")
				.setCancelable(false)
				.setPositiveButton("进入购物车",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								intent.setClass(WaterDetailsActivity.this,ShoppingTrolleyActivity.class);
								startActivity(intent);
							}
						})
				.setNegativeButton("继续浏览",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								dialog.cancel();
							}
						});
		builder.create().show();
	}

	// 广告轮播图
	public void viewPager() {
		pager = (ViewPager) findViewById(R.id.tuijian_pager);
		mGroup = (RadioGroup) findViewById(R.id.radioGroup1);

		pager.setAdapter(new PagerAdapter() {
			// 创建
			@Override
			public Object instantiateItem(View container, int position) {
				View layout = items.get(position % items.size());
				pager.addView(layout);
				return layout;
			}

			// 销毁
			@Override
			public void destroyItem(View container, int position, Object object) {
				View layout = items.get(position % items.size());
				pager.removeView(layout);
			}

			@Override
			public boolean isViewFromObject(View arg0, Object arg1) {
				return arg0 == arg1;
			}

			@Override
			public int getCount() {
				return imgResIDs.length;
			}

		});
		pager.setOnPageChangeListener(new OnPageChangeListener() {
			@Override
			public void onPageSelected(final int arg0) {
				mCurrentItem = arg0 % items.size();
				pager.setCurrentItem(mCurrentItem);
				mGroup.check(radioButtonID[mCurrentItem]);
				// items.get(arg0).findViewById(R.id.tuijian_header_img).setOnClickListener(new
				// OnClickListener()
				// {});
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
			}
		});
		mPagerAction = new Runnable() {
			@Override
			public void run() {
				if (mItem != 0) {
					if (isFrist == true) {
						mCurrentItem = 0;
						isFrist = false;
					} else {
						if (mCurrentItem == items.size() - 1) {
							mCurrentItem = 0;
						} else {
							mCurrentItem++;
						}
					}
					pager.setCurrentItem(mCurrentItem);
					mGroup.check(radioButtonID[mCurrentItem]);

				}
				pager.postDelayed(mPagerAction, 2500);
			}
		};
		pager.postDelayed(mPagerAction, 100);
	}

	private void initAllItems() {
		// 初始化Viewpager的所有item
		for (int i = 0; i < imgResIDs.length; i++) {
			items.add(initPagerItem(imgResIDs[i]));
		}
		mItem = items.size();
	}

	private View initPagerItem(int resID) {
		View layout1 = getLayoutInflater().inflate(R.layout.tuijian_tohead,
				null);
		ImageView imageView1 = (ImageView) layout1
				.findViewById(R.id.tuijian_toheader_img);
		imageView1.setImageResource(resID);
		return layout1;
	}
}
