package com.kt.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;

import com.kt.Adapter.ExchangePostListAdapter;
import com.kt.kt_shq_dy.R;

//===========================================================
//		交流帖子列表activity
//==========================================================

public class ExchangePostListActivity extends Activity{
	private ImageView im_return,iv_complete;
	private ListView post_list;
	private ExchangePostListAdapter eAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_exchangepostlist);
		
		byId();
		setAdapter();
	}

	private void byId() {
		im_return=(ImageView) findViewById(R.id.im_return);
		post_list=(ListView) findViewById(R.id.post_list);
		iv_complete=(ImageView) findViewById(R.id.iv_complete);
		im_return.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		iv_complete.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
				intent.setClass(ExchangePostListActivity.this, ExchangeActivity.class);
				startActivity(intent);
			}
		});
	}
	
	public void setAdapter(){
		eAdapter=new ExchangePostListAdapter(this);
		post_list.setAdapter(eAdapter);
	}
}
