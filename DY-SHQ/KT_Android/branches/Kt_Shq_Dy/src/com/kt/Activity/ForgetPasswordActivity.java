package com.kt.Activity;

import com.kt.kt_shq_dy.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

//===========================================================
//   忘记密码activity
//==========================================================

public class ForgetPasswordActivity extends Activity implements OnClickListener{
	private ImageView im_return;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_forgetword);
		
		byId();
		listener();
	}

	private void byId() {
		im_return=(ImageView) findViewById(R.id.im_return);
		
	}

	private void listener() {
		im_return.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.im_return:
			finish();
			break;

		default:
			break;
		}
		
	}
}
