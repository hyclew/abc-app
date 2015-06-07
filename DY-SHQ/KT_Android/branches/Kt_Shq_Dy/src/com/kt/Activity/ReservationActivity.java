package com.kt.Activity;

import com.kt.kt_shq_dy.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

//===========================================================
// 预约服务activity
//==========================================================

public class ReservationActivity extends Activity implements OnClickListener{
	private ImageView im_return,im_reservation_baojie,im_reservation_jia;
	private Intent intent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reservation);
		byId();
		listener();
	}
	public void byId(){
		intent=new Intent();
		im_return=(ImageView) findViewById(R.id.im_return);
		im_reservation_baojie=(ImageView) findViewById(R.id.im_reservation_baojie);
		im_reservation_jia=(ImageView) findViewById(R.id.im_reservation_jia);
	}
	public void listener(){
		im_return.setOnClickListener(this);
		im_reservation_baojie.setOnClickListener(this);
		im_reservation_jia.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.im_return:
			finish();
			break;
		case R.id.im_reservation_baojie:
			intent.setClass(ReservationActivity.this, SubscribeLifeActivity.class);
			startActivity(intent);
			break;
		case R.id.im_reservation_jia:
	
			break;
		}
		
	}
}
