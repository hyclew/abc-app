package com.kt.Activity;

import com.kt.kt_shq_dy.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

//===========================================================
//   银行业务预约activity
//==========================================================

public class BankActivity extends Activity implements OnClickListener{
	private ImageView im_kaika,im_paihao,im_return;
	private Intent intent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bank);
		
		byId();
		listener();
	}
	//属性初始化
	private void byId() {
		intent= new Intent();
		im_return=(ImageView) findViewById(R.id.im_return);
		im_kaika=(ImageView) findViewById(R.id.im_kaika);
		im_paihao=(ImageView) findViewById(R.id.im_paihao);
	}
	//监听方法
	public void listener(){
		im_return.setOnClickListener(this);
		im_kaika.setOnClickListener(this);
		im_paihao.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.im_return:
			finish();
			break;

		case R.id.im_kaika:
			intent.setClass(BankActivity.this, AppointmentCardActivity.class);
			startActivity(intent);
			break;
		case R.id.im_paihao:
			intent.setClass(BankActivity.this, DotQueryActivity.class);
			startActivity(intent);
			break;
		}
		
	}
	
}
