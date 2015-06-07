package com.kt.Fragment;

import java.util.ArrayList;
import java.util.List;

import com.android.volley.toolbox.Volley;
import com.kt.Activity.BankActivity;
import com.kt.Activity.ExchangeActivity;
import com.kt.Activity.ExchangePostListActivity;
import com.kt.Activity.LifeserviceActivity;
import com.kt.Activity.RecommendActivity;
import com.kt.Activity.ReservationActivity;
import com.kt.Fragment.Fragment_ServiceLife.LifePagerAdapter;
import com.kt.kt_shq_dy.R;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

//===========================================================
//   首页Fragment
//==========================================================

public class Fragment_newHome extends Fragment implements OnClickListener{
	private View view;
	private ImageView im_recommend,im_exchange,im_reservation,im_lifeservice,im_bank;
	private Intent intent;
	
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
	private LifePagerAdapter pagerAdapter;
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view=inflater.inflate(R.layout.newhome_fragment,container, false);
		
		byId();
		listener();
		initAllItems();
        viewPager();
		return view;
	}
	
	public void byId(){
		listBitmap.add( BitmapFactory. decodeResource (getResources(), R.drawable.b));
        listBitmap.add( BitmapFactory. decodeResource (getResources(), R.drawable.d));
        listBitmap.add( BitmapFactory. decodeResource (getResources(), R.drawable.e));
		
		pager = (ViewPager) view.findViewById(R.id.tuijian_pager);
        mGroup = (RadioGroup) view.findViewById(R.id.radioGroup1);
        im_recommend=(ImageView) view.findViewById(R.id.im_recommend);
        im_exchange=(ImageView) view.findViewById(R.id.im_exchange);
        im_lifeservice=(ImageView) view.findViewById(R.id.im_lifeservice);
        im_reservation=(ImageView) view.findViewById(R.id.im_reservation);
        im_bank=(ImageView) view.findViewById(R.id.im_bank);
        intent=new Intent();
	}
	
	public void listener(){
		im_recommend.setOnClickListener(this);
		im_exchange.setOnClickListener(this);
		im_lifeservice.setOnClickListener(this);
		im_reservation.setOnClickListener(this);
		im_bank.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.im_recommend:
			intent.setClass(getActivity(), RecommendActivity.class);
			startActivity(intent);
			break;
		case R.id.im_exchange:
			intent.setClass(getActivity(), ExchangePostListActivity.class);
			startActivity(intent);
			break;
		case R.id.im_lifeservice:
			intent.setClass(getActivity(), LifeserviceActivity.class);
			startActivity(intent);
			break;
		case R.id.im_reservation:
			intent.setClass(getActivity(), ReservationActivity.class);
			startActivity(intent);
			break;
		case R.id.im_bank:
			intent.setClass(getActivity(), BankActivity.class);
			startActivity(intent);
			break;
		}
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
