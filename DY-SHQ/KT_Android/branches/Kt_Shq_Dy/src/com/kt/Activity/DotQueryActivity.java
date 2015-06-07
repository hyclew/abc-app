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

import com.kt.Adapter.DotQueryAdapter;
import com.kt.kt_shq_dy.R;

//===========================================================
//   网点预约排号activity
//==========================================================

public class DotQueryActivity extends Activity{
	private ListView lv_dotquery_list;
	private ImageView im_return;
	private DotQueryAdapter dAdapter;
	private Intent intent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dotquery);
		
		byId();
		setAdapter();
	}

	private void byId() {
		intent=new Intent();
		im_return=(ImageView) findViewById(R.id.im_return);
		im_return.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		
		lv_dotquery_list=(ListView) findViewById(R.id.lv_dotquery_list);
		
		lv_dotquery_list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				intent.setClass(DotQueryActivity.this, NetworkQueryActivity.class);
				startActivity(intent);
				
			}
		});
	}
	public void setAdapter(){
		dAdapter=new DotQueryAdapter(this);
		lv_dotquery_list.setAdapter(dAdapter);
	}
}
