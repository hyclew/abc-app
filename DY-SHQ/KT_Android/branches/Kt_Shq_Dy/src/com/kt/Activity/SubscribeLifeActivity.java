package com.kt.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kt.kt_shq_dy.R;

//===========================================================
//   预约服务activity
//==========================================================

public class SubscribeLifeActivity extends Activity implements OnClickListener{
	private ImageView im_return,im_subscribelife_submit,im_subscribelife_xuan,iv_subscribelife_add,im_subscribelife_personal,im_subscribelife_firm;
	private TextView tv_subscribelife_Address,tv_subscribelife_name,tv_subscribelife_phone,tv_new_address,et_subscribelife_time;
	private EditText et_subscribelife_new_name,et_subscribelife_new_addrress,
						et_subscribelife_new_phone;
	private LinearLayout ll_subscribelife_new_address,ll_subscribelife_you,ll_subscribelife_time;
	private boolean c=true ,d=true;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_subscribelife);
		
		byId();
		listener();
		checkBox();
	}
	
	public void byId(){
		im_return=(ImageView) findViewById(R.id.im_return);
		im_subscribelife_submit=(ImageView) findViewById(R.id.im_subscribelife_submit);
		tv_subscribelife_Address=(TextView) findViewById(R.id.tv_subscribelife_Address);
		tv_subscribelife_name=(TextView) findViewById(R.id.tv_subscribelife_name);
		tv_subscribelife_phone=(TextView) findViewById(R.id.tv_subscribelife_phone);
		
		tv_new_address=(TextView) findViewById(R.id.tv_new_address);
		et_subscribelife_new_name=(EditText) findViewById(R.id.et_subscribelife_new_name);
		et_subscribelife_new_addrress=(EditText) findViewById(R.id.et_subscribelife_new_addrress);
		et_subscribelife_new_phone=(EditText) findViewById(R.id.et_subscribelife_new_phone);
		
		im_subscribelife_xuan=(ImageView) findViewById(R.id.im_subscribelife_xuan);
		iv_subscribelife_add=(ImageView) findViewById(R.id.iv_subscribelife_add);
		ll_subscribelife_new_address=(LinearLayout) findViewById(R.id.ll_subscribelife_new_address);
		ll_subscribelife_you=(LinearLayout) findViewById(R.id.ll_subscribelife_you);
		ll_subscribelife_time=(LinearLayout) findViewById(R.id.ll_subscribelife_time);
		et_subscribelife_time=(TextView) findViewById(R.id.et_subscribelife_time);
	}
	//判断输入框能不能输入
	public void checkBox(){
		if(c==true){
				et_subscribelife_new_name.setEnabled(false);
				et_subscribelife_new_addrress.setEnabled(false);
				et_subscribelife_new_phone.setEnabled(false);
		}else{
				et_subscribelife_new_name.setEnabled(true);
				et_subscribelife_new_addrress.setEnabled(true);
				et_subscribelife_new_phone.setEnabled(true);
		}
	}
	private void listener() {
		im_return.setOnClickListener(this);
		im_subscribelife_submit.setOnClickListener(this);
		tv_new_address.setOnClickListener(this);
		im_subscribelife_xuan.setOnClickListener(this);
		iv_subscribelife_add.setOnClickListener(this);
		ll_subscribelife_you.setOnClickListener(this);
		ll_subscribelife_time.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		//返回按钮
		case R.id.im_return:
			finish();
			break;
			//默认按钮
		case R.id.im_subscribelife_xuan:
			if(c==true){
				im_subscribelife_xuan.setImageResource(R.drawable.im_shopping_no);
				et_subscribelife_new_name.setEnabled(true);
				et_subscribelife_new_addrress.setEnabled(true);
				et_subscribelife_new_phone.setEnabled(true);
				c=false;
			}else{
				im_subscribelife_xuan.setImageResource(R.drawable.im_shopping_yes);
				et_subscribelife_new_name.setEnabled(false);
				et_subscribelife_new_addrress.setEnabled(false);
				et_subscribelife_new_phone.setEnabled(false);
				c=true;
			}
			break;
			//提交按钮
		case R.id.im_subscribelife_submit:
		
			break;
			//添加新地址按钮
		case R.id.tv_new_address:
			if(d==true){
				ll_subscribelife_new_address.setVisibility(View.VISIBLE);
				d=false;
			}else{
				ll_subscribelife_new_address.setVisibility(View.GONE);
				d=true;
			}
			break;
			//确认添加
		case R.id.iv_subscribelife_add:
			
			break;
			//跳转地址列表
		case R.id.ll_subscribelife_you:
			Intent intent=new Intent();
			intent.setClass(SubscribeLifeActivity.this, SubscribeListActivity.class);
			startActivity(intent);
			break;
		//选择时间
		case R.id.ll_subscribelife_time:
			
			break;
		}
	}
}
