package com.kt.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;

import com.kt.Adapter.SubscribeListAdapter;
import com.kt.kt_shq_dy.R;

//===========================================================
//   地址列表activity
//==========================================================

public class SubscribeListActivity extends Activity {
	private ListView lv_address_list;
	private ImageView im_return;
	private SubscribeListAdapter sAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_subscribelist);
		
		byId();
		setAdapter();
	}
	private void byId() {
		lv_address_list=(ListView) findViewById(R.id.lv_address_list);
		im_return=(ImageView) findViewById(R.id.im_return);
		
		im_return.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}
	public void setAdapter(){
		sAdapter=new SubscribeListAdapter(this);
		lv_address_list.setAdapter(sAdapter);
	}
}
