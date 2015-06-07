package com.kt.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;

import com.kt.kt_shq_dy.R;

//===========================================================
//    推荐开卡activity
//==========================================================

public class RecommendedCardActivity extends Activity{
	private  ImageView im_return,imageView1;
	private Spinner spinner1;
	private ArrayAdapter<String> adapter;
	private static final String[] m = {"身份证", "社保证" };
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recommendedcard);
		
		byId();
		spinner();
	}

	private void byId() {
		im_return=(ImageView) findViewById(R.id.im_return);
		spinner1=(Spinner) findViewById(R.id.spinner1);
		imageView1=(ImageView) findViewById(R.id.imageView1);
		
		im_return.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		
		spinner1.setOnItemSelectedListener(new OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> arg0, View view,
					int arg2, long arg3) {
				
				TextView tv = (TextView)view;
				tv.setTextColor(getResources().getColor(R.color.typeface_color));    //设置颜色  
			}
			
			public void onNothingSelected(AdapterView<?> arg0) {

			}
		});
		
	}
	public void spinner() {
		// 将可选内容与ArrayAdapter连接起来
				adapter = new ArrayAdapter<String>(this,
						android.R.layout.simple_spinner_item, m);
				// 设置下拉列表的风格
				adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				// 将adapter 添加到spinner中
				spinner1.setAdapter(adapter);
				// 设置默认值
				spinner1.setVisibility(View.VISIBLE);
	}
}
