package com.kt.Fragment;

import java.util.ArrayList;

import com.kt.kt_shq_dy.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

//===========================================================
//   银行咨讯Fragment
//==========================================================

public class Fragment_ConvenientService extends Fragment {
	private View view;
	
	//广告轮播图属性
		private int[] imgResIDs = new int[]
			    { R.drawable.b, R.drawable.d, R.drawable.e };
		private int[] radioButtonID = new int[]
			    { R.id.radio0, R.id.radio1, R.id.radio2};
		private ViewPager pager;
		private RadioGroup mGroup;
		private ArrayList<View> items = new ArrayList<View>();
		private Runnable runnable;
		private int mCurrentItem = 0;
		private int mItem;
		private Runnable mPagerAction;
		private boolean isFrist = true;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view=inflater.inflate(R.layout.convenientservice_fragment,container, false);
		
		
		return view;
	}
}
