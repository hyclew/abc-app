package com.kt.Activity;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;

//===========================================================
//	 广告轮播图viewpager
//==========================================================

public class MyViewPager extends ViewPager
{
    
    public MyViewPager(Context context)
    {
        super(context);
    }
    
    @Override
    public boolean onInterceptTouchEvent(MotionEvent arg0)
    {
        return false;
    }
    
    @Override
    public boolean onTouchEvent(MotionEvent arg0)
    {
        return false;
    }
}
