package com.kt.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;

import com.kt.kt_shq_dy.R;

//===========================================================
//		支付密码activity
//==========================================================

public class PayPasswordActivity extends Activity {
	private ImageView imageView1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_paypassword);
		
		imageView1=(ImageView) findViewById(R.id.imageView1);
		
		imageView1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(PayPasswordActivity.this, "支付成功", Toast.LENGTH_LONG).show();
				Intent intent =new Intent();
				intent.setClass(PayPasswordActivity.this, MainActivity.class);
				startActivity(intent);
			}
		});
	}
}
