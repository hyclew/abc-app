package com.kt.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.kt.kt_shq_dy.R;

//===========================================================
//     活动时间Activity
//==========================================================

public class ExerciseTimeActivity extends Activity{
	private ImageView im_return,iv_complete;
	private Intent intent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_exercisetime);
		
		byId();
	}

	private void byId() {
		intent= new Intent();
		im_return=(ImageView) findViewById(R.id.im_return);
		iv_complete=(ImageView) findViewById(R.id.iv_complete);
		im_return.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		
		iv_complete.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				intent.setClass(ExerciseTimeActivity.this, ExchangePostListActivity.class);
				startActivity(intent);
				
			}
		});
	}
}
