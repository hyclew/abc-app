package com.kt.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.kt.kt_shq_dy.R;

//===========================================================
//    发投票activity
//==========================================================

public class HairVoteActivity extends Activity implements OnClickListener{
	private ImageView im_return,iv_complete;
	private Intent intent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hairvote);
		
		byId();
		listener();
	}
	public  void byId(){
		im_return=(ImageView) findViewById(R.id.im_return);
		iv_complete=(ImageView) findViewById(R.id.iv_complete);
		intent=new Intent();
	}
	
	public void listener(){
		im_return.setOnClickListener(this);
		iv_complete.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.im_return:
			finish();
			break;

		case R.id.iv_complete:
			intent.setClass(HairVoteActivity.this, EditOptionsActivity.class);
			startActivity(intent);
			break;
		}
		
	}
}
