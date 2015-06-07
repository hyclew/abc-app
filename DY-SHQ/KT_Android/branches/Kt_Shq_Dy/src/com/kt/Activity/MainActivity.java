package com.kt.Activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.kt.Fragment.Fragment_ConvenientService;
import com.kt.Fragment.Fragment_MyCircle;
import com.kt.Fragment.Fragment_ServiceLife;
import com.kt.Fragment.Fragment_newHome;
import com.kt.kt_shq_dy.R;
import com.kt.kt_shq_dy.R.color;

//===========================================================
//   项目主activity
//==========================================================

public class MainActivity extends FragmentActivity implements OnClickListener {
	// 定义Fragment 四个底部按钮
	// 文字
	private TextView tv_life_word, tv_seller_word, tv_convenient_word,
			tv_circle_word;
	// 图片
	private ImageView im_fragment_life, im_fragment_seller,
			im_frgment_convenient, im_fragment_circle;
	private LinearLayout ll_life, ll_seller, ll_convenient, ll_circle;
	// 倒入Fragment 界面
	private Fragment_ServiceLife life;
	private Fragment_newHome newHome;
	private Fragment_ConvenientService convenient;
	private Fragment_MyCircle circle;
	private long firstTime = 0; 

	private FragmentManager fragmentManager;
	private Fragment topFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		byId();
		listener();
	}

	public void fragment() {
		// 默认加载首页fragment
		fragmentManager = getSupportFragmentManager();
		// 初始化好所有fragment
		life = new Fragment_ServiceLife();
		newHome = new Fragment_newHome();
		convenient = new Fragment_ConvenientService();
		circle = new Fragment_MyCircle();

		// 添加所有fragment

		fragmentManager.beginTransaction().add(R.id.ll_fragment_home, life)
				.add(R.id.ll_fragment_home, newHome)
				.add(R.id.ll_fragment_home, convenient)
				.add(R.id.ll_fragment_home, circle).commit();

		topFragment = life;
	}

	public void changeFragment(Fragment fragment) {
		fragmentManager.beginTransaction().hide(topFragment).show(fragment)
				.commit();
		topFragment = fragment;

	}

	// 初始化UI
	public void byId() {
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.ll_fragment_home, new Fragment_newHome())
				.commit();
		im_fragment_life = (ImageView) findViewById(R.id.im_fragment_life);
		im_fragment_seller = (ImageView) findViewById(R.id.im_fragment_seller);
		im_frgment_convenient = (ImageView) findViewById(R.id.im_frgment_convenient);
		im_fragment_circle = (ImageView) findViewById(R.id.im_fragment_circle);
		ll_life = (LinearLayout) findViewById(R.id.ll_life);
		ll_seller = (LinearLayout) findViewById(R.id.ll_seller);
		ll_convenient = (LinearLayout) findViewById(R.id.ll_convenient);
		ll_circle = (LinearLayout) findViewById(R.id.ll_circle);
		tv_life_word = (TextView) findViewById(R.id.tv_life_word);
		tv_seller_word = (TextView) findViewById(R.id.tv_seller_word);
		tv_convenient_word = (TextView) findViewById(R.id.tv_convenient_word);
		tv_circle_word = (TextView) findViewById(R.id.tv_circle_word);
	}

	// 监听事件
	public void listener() {
		ll_life.setOnClickListener(this);
		ll_seller.setOnClickListener(this);
		ll_convenient.setOnClickListener(this);
		ll_circle.setOnClickListener(this);
	}

	// 点击方法
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.ll_life:
			// 图片变色
			im_fragment_seller.setImageResource(R.drawable.tabbar_life);
			im_fragment_circle.setImageResource(R.drawable.tabbar_circle);
			im_frgment_convenient.setImageResource(R.drawable.tabbar_service);
			im_fragment_life .setImageResource(R.drawable.im_new_home);
			// 文字变色
			tv_life_word.setTextColor(getResources().getColor(color.theme_color));
			tv_seller_word.setTextColor(getResources().getColor(color.typeface_color));
			tv_convenient_word.setTextColor(getResources().getColor(color.typeface_color));
			tv_circle_word.setTextColor(getResources().getColor(color.typeface_color));
			getSupportFragmentManager().beginTransaction()
					.replace(R.id.ll_fragment_home, new Fragment_newHome())
					.commit();
			break;
		case R.id.ll_seller:
			// 图片变色
			im_fragment_life
					.setImageResource(R.drawable.im_new_home_hui);
			im_fragment_seller.setImageResource(R.drawable.tabbar_life_selected);
			im_fragment_circle.setImageResource(R.drawable.tabbar_circle);
			im_frgment_convenient.setImageResource(R.drawable.tabbar_service);
			// 文字变色
			tv_life_word.setTextColor(getResources().getColor(color.typeface_color));
			tv_seller_word.setTextColor(getResources().getColor(color.theme_color));
			tv_convenient_word.setTextColor(getResources().getColor(color.typeface_color));
			tv_circle_word.setTextColor(getResources().getColor(color.typeface_color));
			getSupportFragmentManager().beginTransaction()
					.replace(R.id.ll_fragment_home,
							new Fragment_ServiceLife()).commit();
			break;
		case R.id.ll_convenient:
			// 图片变色
			im_frgment_convenient
					.setImageResource(R.drawable.tabbar_service_selected);
			im_fragment_seller .setImageResource(R.drawable.tabbar_life);
			im_fragment_circle.setImageResource(R.drawable.tabbar_circle);
			im_fragment_life.setImageResource(R.drawable.im_new_home_hui);
			// 文字变色
			tv_life_word.setTextColor(getResources().getColor(color.typeface_color));
			tv_seller_word.setTextColor(getResources().getColor(color.typeface_color));
			tv_convenient_word.setTextColor(getResources().getColor(color.theme_color));
			tv_circle_word.setTextColor(getResources().getColor(color.typeface_color));
			getSupportFragmentManager().beginTransaction()
					.replace(R.id.ll_fragment_home,
							new Fragment_ConvenientService()).commit();
			break;
		case R.id.ll_circle:
			// 图片变色
			im_fragment_circle
					.setImageResource(R.drawable.tabbar_circle_selected);
			im_frgment_convenient.setImageResource(R.drawable.tabbar_service);
			im_fragment_life .setImageResource(R.drawable.im_new_home_hui);
			im_fragment_seller.setImageResource(R.drawable.tabbar_life);
			// 文字变色
			tv_life_word.setTextColor(getResources().getColor(color.typeface_color));
			tv_seller_word.setTextColor(getResources().getColor(color.typeface_color));
			tv_convenient_word.setTextColor(getResources().getColor(color.typeface_color));
			tv_circle_word.setTextColor(getResources().getColor(color.theme_color));
			getSupportFragmentManager().beginTransaction()
					.replace(R.id.ll_fragment_home, new Fragment_MyCircle())
					.commit();
			break;
		}
	}
	//安卓自带返回键退出
	
	  @Override  
	  public boolean onKeyUp(int keyCode, KeyEvent event) {  
	         // TODO Auto-generated method stub  
	         switch(keyCode)  
	         {  
	        case KeyEvent.KEYCODE_BACK:  
	              long secondTime = System.currentTimeMillis();   
	               if (secondTime - firstTime > 2000) {                                         //如果两次按键时间间隔大于2秒，则不退出  
	                   Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();   
	                  firstTime = secondTime;//更新firstTime  
	                   return true;   
	               } else {                                                    //两次按键小于2秒时，退出应用  
	              System.exit(0);  
	               }   
	            break;  
	         }  
	       return super.onKeyUp(keyCode, event);  
	  }  
}
