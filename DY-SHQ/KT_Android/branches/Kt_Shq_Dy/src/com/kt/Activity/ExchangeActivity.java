package com.kt.Activity;

import com.kt.kt_shq_dy.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

//===========================================================
//   交流activity
//==========================================================

public class ExchangeActivity extends Activity implements OnClickListener{
	private ImageView im_return,im_post,im_activity,im_vote;
	private Intent intent;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_exchange);
		
		byId();
		listener();
	}
	//属性初始化
	public void byId(){
		intent=new Intent();
		im_return=(ImageView) findViewById(R.id.im_return);
		im_post=(ImageView) findViewById(R.id.im_post);
		im_activity=(ImageView) findViewById(R.id.im_activity);
		im_vote=(ImageView) findViewById(R.id.im_vote);
		
	}
	//监听方法
	public void listener(){
		im_return.setOnClickListener(this);
		im_post.setOnClickListener(this);
		im_activity.setOnClickListener(this);
		im_vote.setOnClickListener(this);
		
	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.im_return:
			finish();
			break;
		case R.id.im_post:
			intent.setClass(ExchangeActivity.this, HairNeedActivity.class);
			startActivity(intent);
			break;
		case R.id.im_activity:
			intent.setClass(ExchangeActivity.this, HairActivity.class);
			startActivity(intent);
			break;
		case R.id.im_vote:
			intent.setClass(ExchangeActivity.this, HairVoteActivity.class);
			startActivity(intent);
			break;
		}
	}

}
