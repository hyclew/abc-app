package com.kt.Activity;

import com.kt.kt_shq_dy.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

//===========================================================
//   在线支付activity
//==========================================================

public class OnlinePaymentActivity extends Activity implements OnClickListener{
	private ImageView im_return,iv_payment_atonce;
	private TextView tv_online_way;
	private Intent intent;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_onlinepayment);
		
		byId();
		listener();
	}
	//属性初始化
	public void byId(){
		im_return=(ImageView) findViewById(R.id.im_return);
		iv_payment_atonce=(ImageView) findViewById(R.id.iv_payment_atonce);
		tv_online_way=(TextView) findViewById(R.id.tv_online_way);
		intent=new Intent();
	}
	//监听方法
	public void listener(){
		im_return.setOnClickListener(this);
		iv_payment_atonce.setOnClickListener(this);
		tv_online_way.setOnClickListener(this);
	}
	//监听事件
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.im_return:
			finish();
			break;

		case R.id.iv_payment_atonce:
			intent.setClass(OnlinePaymentActivity.this, PayPasswordActivity.class);
			startActivity(intent);
			break;
		case R.id.tv_online_way:
			intent.setClass(OnlinePaymentActivity.this, PayWayActivity.class);
			startActivity(intent);
			break;
		}
	}
}
