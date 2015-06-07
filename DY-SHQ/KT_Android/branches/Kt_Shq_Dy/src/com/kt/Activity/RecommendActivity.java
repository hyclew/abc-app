package com.kt.Activity;

import com.kt.kt_shq_dy.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

//===========================================================
//   推荐activity
//==========================================================

public class RecommendActivity extends Activity implements OnClickListener{
	private ImageView im_tuijiankk,im_customer,im_return;
	private Intent intent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recommend);
		
		byId();
		listener();
	}
	public void byId(){
		intent=new  Intent();
		im_return=(ImageView) findViewById(R.id.im_return);
		im_customer=(ImageView) findViewById(R.id.im_customer);
		im_tuijiankk=(ImageView) findViewById(R.id.im_tuijiankk);
	}
	public void listener(){
		im_return.setOnClickListener(this);
		im_customer.setOnClickListener(this);
		im_tuijiankk.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.im_return:
			finish();
			break;

		case R.id.im_customer:
			intent.setClass(RecommendActivity.this, RecommendCustomersActivity.class);
			startActivity(intent);
			break;
			
		case R.id.im_tuijiankk:
			intent.setClass(RecommendActivity.this, RecommendedCardActivity.class);
			startActivity(intent);
			break;
		}
	}
	
}
