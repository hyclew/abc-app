package com.kt.Fragment;

import com.kt.Activity.LoginActivity;
import com.kt.Activity.MyOrderActivity;
import com.kt.Activity.PayWayActivity;
import com.kt.Activity.RegisteredActivity;
import com.kt.Activity.SetUpActivity;
import com.kt.Activity.ShopActivity;
import com.kt.Activity.ShoppingTrolleyActivity;
import com.kt.kt_shq_dy.R;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Im;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

//===========================================================
//   我的圈子Fragment
//==========================================================

public class Fragment_MyCircle extends Fragment implements OnClickListener{
	private View view;
	private Intent intent;
	private TextView tv_mycircle_name;
	private ImageView im_my_login,im_my_registered,im_mycircle_you;
	private RelativeLayout rl_my_wallet,rl_my_order,rl_my_shoppingcar,rl_my_kaidian,
					rl_my_setup;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view=inflater.inflate(R.layout.mycircle_fragment,container, false);
		
		byId();
		listener();
		
		return view;
	}
	
	public void byId(){
		intent=new Intent();
		im_my_registered=(ImageView) view.findViewById(R.id.im_my_registered);
		im_my_login=(ImageView) view.findViewById(R.id.im_my_login);
		rl_my_wallet=(RelativeLayout) view.findViewById(R.id.rl_my_wallet);
		rl_my_order=(RelativeLayout) view.findViewById(R.id.rl_my_order);
		rl_my_kaidian=(RelativeLayout) view.findViewById(R.id.rl_my_kaidian);
		rl_my_setup=(RelativeLayout) view.findViewById(R.id.rl_my_setup);
		rl_my_shoppingcar=(RelativeLayout) view.findViewById(R.id.rl_my_shoppingcar);
		im_mycircle_you=(ImageView) view.findViewById(R.id.im_mycircle_you);
		tv_mycircle_name=(TextView) view.findViewById(R.id.tv_mycircle_name);
		
		
	}
	public void listener(){
		im_my_login.setOnClickListener(this);
		im_my_registered.setOnClickListener(this);
		rl_my_wallet.setOnClickListener(this);
		rl_my_order.setOnClickListener(this);
		rl_my_shoppingcar.setOnClickListener(this);
		im_mycircle_you.setOnClickListener(this);
		rl_my_kaidian.setOnClickListener(this);
		rl_my_setup.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.im_my_login:
			intent.setClass(getActivity(), LoginActivity.class);
			startActivity(intent);
			break;

		case R.id.im_my_registered:
			intent.setClass(getActivity(), RegisteredActivity.class);
			startActivity(intent);
			break;
			
		case R.id.rl_my_wallet:
			intent.setClass(getActivity(), PayWayActivity.class);
			startActivity(intent);
			break;
			
		case R.id.rl_my_order:
			intent.setClass(getActivity(), MyOrderActivity.class);
			startActivity(intent);
			break;
			
		case R.id.rl_my_shoppingcar:
			intent.setClass(getActivity(), ShoppingTrolleyActivity.class);
			startActivity(intent);
			break;
		case R.id.rl_my_kaidian:
			intent.setClass(getActivity(), ShopActivity.class);
			startActivity(intent);
			break;
		case R.id.im_mycircle_you:
			
			break;
		case R.id.rl_my_setup:
			intent.setClass(getActivity(), SetUpActivity.class);
			startActivity(intent);
			break;
		}
	}
}
