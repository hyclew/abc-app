package com.kt.Activity;

import com.kt.kt_shq_dy.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

//===========================================================
//   生活服务activity
//==========================================================

public class LifeserviceActivity extends Activity implements OnClickListener{
	private ImageView im_return,im_news_car,im_news_shui,
						im_news_chao;
	private Intent intent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lifeservice);
		
		buId();
		listener();
	}
	public void buId(){
		intent=new Intent();
		im_return=(ImageView) findViewById(R.id.im_return);
		im_news_car=(ImageView) findViewById(R.id.im_news_car);
		im_news_shui=(ImageView) findViewById(R.id.im_news_shui);
		im_news_chao=(ImageView) findViewById(R.id.im_news_chao);
		
	}
	
	public void listener(){
		im_return.setOnClickListener(this);
		im_news_car.setOnClickListener(this);
		im_news_shui.setOnClickListener(this);
		im_news_chao.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.im_return:
			finish();
			break;
		case R.id.im_news_car:
			
			break;
		case R.id.im_news_shui:
			intent.setClass(LifeserviceActivity.this, BottledWaterActivity.class);
			startActivity(intent);
			break;
		case R.id.im_news_chao:
	
			break;
		}
		
	}
}
