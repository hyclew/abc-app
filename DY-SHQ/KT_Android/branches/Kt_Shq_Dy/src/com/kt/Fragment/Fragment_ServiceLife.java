package com.kt.Fragment;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.kt.Activity.BottledWaterActivity;
import com.kt.Activity.SubscribeLifeActivity;
import com.kt.Bean.AdvertisementBean;
import com.kt.KtApi.KtInterface;
import com.kt.kt_shq_dy.R;

//===========================================================
//   生活服务Fragment
//==========================================================

public class Fragment_ServiceLife extends Fragment implements OnClickListener{
	private View view;
	//广告轮播图属性
	private List<Bitmap> listBitmap=new ArrayList<Bitmap>();
	private int[] radioButtonID = new int[]
		    { R.id.radio0, R.id.radio1, R.id.radio2};
	private ViewPager pager;
	private RadioGroup mGroup;
	private ArrayList<View> items = new ArrayList<View>();
	private int mCurrentItem = 0;
	private int mItem;
	private Runnable mPagerAction;
	private boolean isFrist = true;
	
	//服务功能属性
	private Intent intent;
	private ImageView iv_life_water;
	private ImageView iv_life_yu_cleaning;
	private RequestQueue mQueue;
	private Bitmap bitmapOne;
	private Bitmap bitmapTwo;
	private Bitmap bitmapThree;
	private String urlOne;
	private String urlTwo;
	private String urlThree;
	private LifePagerAdapter pagerAdapter;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view=inflater.inflate(R.layout.servicelife_fragment,container, false);
		
		byId();
		initAllItems();
		viewPager();
		listener();
//		http();
		return view;
	}
	
	//初始化
	public void byId(){
		listBitmap.add( BitmapFactory. decodeResource (getResources(), R.drawable.b));
        listBitmap.add( BitmapFactory. decodeResource (getResources(), R.drawable.d));
        listBitmap.add( BitmapFactory. decodeResource (getResources(), R.drawable.e));
		
		intent=new Intent();
		mQueue = Volley .newRequestQueue(getActivity());
		iv_life_water=(ImageView) view.findViewById(R.id.iv_life_water);
		iv_life_yu_cleaning=(ImageView) view.findViewById(R.id.iv_life_yu_cleaning);
		pager = (ViewPager) view.findViewById(R.id.tuijian_pager);
        mGroup = (RadioGroup) view.findViewById(R.id.radioGroup1);
	}
	//监听
	public void listener(){
		iv_life_water.setOnClickListener(this);
		iv_life_yu_cleaning.setOnClickListener(this);
	}
	//点击事件
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.iv_life_water:
			intent.setClass(getActivity(), BottledWaterActivity.class);
			startActivity(intent);
			break;
			
		case R.id.iv_life_yu_cleaning:
			intent.setClass(getActivity(), SubscribeLifeActivity.class);
			startActivity(intent);
			break;
		}
		
	}
	//广告列表网络请求
	public void http(){
		StringRequest myStringRequest=new StringRequest(Request.Method.GET,KtInterface.ADVERT, new Response.Listener<String>() {

			@Override
			public void onResponse(String response) {
				try {
					org.json.JSONObject json = new org.json.JSONObject(response);
					List<AdvertisementBean> list = com.alibaba.fastjson.JSONObject.parseArray(
							json.getJSONArray("responseBody").toString(), AdvertisementBean.class);
					
					urlOne=KtInterface.WATERHEAD+list.get(0).getResourceId();
					urlTwo=KtInterface.WATERHEAD+list.get(1).getResourceId();
					urlThree=KtInterface.WATERHEAD+list.get(2).getResourceId();
					
					Log.e("111111111111111111111111", urlOne);
					Log.e("222222222222222222222222", urlTwo);
					Log.e("333333333333333333333333", urlThree);
					listBitmap.clear();
					advertOneHttp();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}, new Response.ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError error) {
				Log.e("TAG", error.getMessage(), error);
				Toast.makeText(getActivity(),"网络连接错误！", Toast.LENGTH_LONG).show();
			}
	      });
		mQueue.add(myStringRequest);
	
	}
	//第一张图片请求
	public void advertOneHttp(){
		StringRequest myRequest=new StringRequest(Request.Method.GET,urlOne, new Response.Listener<String>() {

			@Override
			public void onResponse(String response) {
				try {
					org.json.JSONObject json = new org.json.JSONObject(response);
					org.json.JSONObject urljson=json.getJSONObject("responseBody");
					String headurl=urljson.getString("resourceURL");
					//base64解码
					byte[] byteIcon = Base64.decode(headurl,Base64.DEFAULT);
					bitmapOne = BitmapFactory.decodeByteArray(byteIcon,0,byteIcon.length);
					Log.e("1111111111111111", bitmapOne.toString());

					listBitmap.add(bitmapOne);
					advertTwoHttp();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}, new Response.ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError error) {
				Log.e("TAG", error.getMessage(), error);
				Toast.makeText(getActivity(),"第一张图片加载失败！", Toast.LENGTH_LONG).show();
			}
	      });
		mQueue.add(myRequest);
    
	}
	//第二张图片请求
	public void advertTwoHttp(){
		StringRequest myRequest=new StringRequest(Request.Method.GET,urlTwo, new Response.Listener<String>() {

			@Override
			public void onResponse(String response) {
				try {
					org.json.JSONObject json = new org.json.JSONObject(response);
					org.json.JSONObject urljson=json.getJSONObject("responseBody");
					String headurl=urljson.getString("resourceURL");
					//base64解码
					byte[] byteIcon = Base64.decode(headurl,Base64.DEFAULT);
					bitmapTwo = BitmapFactory.decodeByteArray(byteIcon,0,byteIcon.length);
					Log.e("1111111111111111", bitmapTwo.toString());
					listBitmap.add(bitmapTwo);
					advertThreeHttp();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}, new Response.ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError error) {
				Log.e("TAG", error.getMessage(), error);
				Toast.makeText(getActivity(),"第二张图片加载失败！", Toast.LENGTH_LONG).show();
			}
	      });
		mQueue.add(myRequest);
    
	}
	//第三张图片请求
	public void advertThreeHttp(){
		StringRequest myRequest=new StringRequest(Request.Method.GET,urlThree, new Response.Listener<String>() {

			@Override
			public void onResponse(String response) {
				try {
					org.json.JSONObject json = new org.json.JSONObject(response);
					org.json.JSONObject urljson=json.getJSONObject("responseBody");
					String headurl=urljson.getString("resourceURL");
					//base64解码
					byte[] byteIcon = Base64.decode(headurl,Base64.DEFAULT);
				    bitmapThree = BitmapFactory.decodeByteArray(byteIcon,0,byteIcon.length);
					Log.e("1111111111111111", bitmapThree.toString());
					listBitmap.add(bitmapThree);
					Log.e("list-----------------------", listBitmap.toString());
					pagerAdapter.notifyDataSetChanged();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}, new Response.ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError error) {
				Log.e("TAG", error.getMessage(), error);
				Toast.makeText(getActivity(),"第三张图片加载失败！", Toast.LENGTH_LONG).show();
			}
	      });
		mQueue.add(myRequest);
    
	}
	//广告轮播图
		public void viewPager(){
	        pagerAdapter=new LifePagerAdapter();
	        pager.setAdapter(pagerAdapter);
	        pager.setOnPageChangeListener(new OnPageChangeListener()
	        {
	            @Override
	            public void onPageSelected(final int arg0)
	            {
	                mCurrentItem = arg0 % items.size();
	                pager.setCurrentItem(mCurrentItem);
	                mGroup.check(radioButtonID[mCurrentItem]);
	                items.get(arg0).findViewById(R.id.tuijian_header_img).setOnClickListener(new OnClickListener()
	                {
	                    @Override
	                    public void onClick(View v)
	                    {
	                    	if(arg0==0){
	                    		Toast.makeText(getActivity(),"0", Toast.LENGTH_LONG).show();
	                    	}else if(arg0==1){
	                    		Toast.makeText(getActivity(),"1", Toast.LENGTH_LONG).show();
	                    	}else if(arg0==2){
	                    		Toast.makeText(getActivity(),"2", Toast.LENGTH_LONG).show();
	                    	}
	                    }
	                });
	            }
	            
	            @Override
	            public void onPageScrolled(int arg0, float arg1, int arg2)
	            {
	                // TODO Auto-generated method stub
	            }
	            
	            @Override
	            public void onPageScrollStateChanged(int arg0)
	            {
	                // TODO Auto-generated method stub
	            }
	        });
	        mPagerAction = new Runnable()
	        {
	            @Override
	            public void run()
	            {
	                if (mItem != 0)
	                {
	                    if (isFrist == true)
	                    {
	                        mCurrentItem = 0;
	                        isFrist = false;
	                    }
	                    else
	                    {
	                        if (mCurrentItem == items.size() - 1)
	                        {
	                            mCurrentItem = 0;
	                        }
	                        else
	                        {
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
		
		public class LifePagerAdapter extends PagerAdapter {
		    // 创建
		    @Override
		    public Object instantiateItem(View container, int position)
		    {
		        View layout = items.get(position % items.size());
		        pager.addView(layout);
		        return layout;
		    }
		    
		    // 销毁
		    @Override
		    public void destroyItem(View container, int position, Object object)
		    {
		        View layout = items.get(position % items.size());
		        pager.removeView(layout);
		    }
		    
		    @Override
		    public boolean isViewFromObject(View arg0, Object arg1)
		    {
		        return arg0 == arg1;
		    }
		    
		    @Override
		    public int getCount()
		    {
		        return listBitmap.size();
		    }
		   
		}
		
	private void initAllItems()
    {
        // 初始化Viewpager的所有item
        for (int i = 0; i < listBitmap.size(); i++)
        {
            items.add(initPagerItem(listBitmap.get(i)));
        }
        mItem = items.size();
    }
    
    private View initPagerItem(Bitmap bitmap)
    {
        View layout1 = getLayoutInflater(getArguments()).inflate(R.layout.tuijian_header, null);
        ImageView imageView1 = (ImageView) layout1.findViewById(R.id.tuijian_header_img);
        imageView1.setImageBitmap(bitmap);
        return layout1;
    }
	
}
