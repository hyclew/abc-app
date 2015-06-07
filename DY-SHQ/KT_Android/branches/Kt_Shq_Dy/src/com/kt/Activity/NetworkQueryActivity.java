package com.kt.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.kt.kt_shq_dy.R;

//===========================================================
//   网点查询4级activity
//==========================================================

public class NetworkQueryActivity extends Activity{
	private ImageView im_return;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_networkquery);
		
		
		im_return=(ImageView) findViewById(R.id.im_return);
		
		im_return.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}
}
