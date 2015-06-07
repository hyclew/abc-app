package com.kt.Activity;

import com.kt.kt_shq_dy.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

//===========================================================
//   推荐客户activity
// ==========================================================

public class RecommendCustomersActivity extends Activity implements OnClickListener{
	private ImageView im_return,iv_complete;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recommendcustomers);
	
		byId();
		listener();
	}

	public void byId() {
		im_return=(ImageView) findViewById(R.id.im_return);
		iv_complete=(ImageView) findViewById(R.id.iv_complete);
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
		
		 	break;
		}
		
	}
	
	
}
