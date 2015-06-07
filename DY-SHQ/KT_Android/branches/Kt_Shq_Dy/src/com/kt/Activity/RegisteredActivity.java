package com.kt.Activity;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.Request.Method;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.kt.Bean.UserInfoDomain;
import com.kt.KtApi.KtInterface;
import com.kt.kt_shq_dy.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;

//===========================================================
//   注册activity
//==========================================================

public class RegisteredActivity extends Activity implements OnClickListener {
	private ImageView im_return;
	private EditText et_register_username;
	private ImageView bt_register_yes;
	private EditText et_register_name,et_register_phone,et_register_password,et_register_address,et_register_password_yes;
	private RadioGroup sex = null;
	private RadioButton male = null,female = null;
	private int sex1=0;
	private UserInfoDomain user;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registered);

		byId();
		listener();
	}
	//属性初始化
	private void byId() {
		im_return = (ImageView) findViewById(R.id.im_return);
		bt_register_yes = (ImageView) findViewById(R.id.bt_register_yes);
		et_register_username = (EditText) findViewById(R.id.et_register_username);
		et_register_name = (EditText) findViewById(R.id.et_register_name);
		et_register_phone = (EditText) findViewById(R.id.et_register_phone);
		et_register_password = (EditText) findViewById(R.id.et_register_password);
		et_register_address = (EditText) findViewById(R.id.et_register_address);
		et_register_password_yes=(EditText) findViewById(R.id.et_register_password_yes);
		sex=(RadioGroup) findViewById(R.id.sex);
		male=(RadioButton) findViewById(R.id.male);
		female=(RadioButton) findViewById(R.id.female);
		
	}
	
	//监听方法
	public void listener() {
		im_return.setOnClickListener(this);
		bt_register_yes.setOnClickListener(this);
		sex.setOnCheckedChangeListener(new OnCheckedChangeListenerImp());
	}
	//单选按钮
	private class OnCheckedChangeListenerImp implements OnCheckedChangeListener {

		public void onCheckedChanged(RadioGroup group, int checkedId) {
			String temp = null;
			if (RegisteredActivity.this.male.getId() == checkedId) {
				temp = "男";
				sex1=0;
			} else if (RegisteredActivity.this.female.getId() == checkedId) {
				temp = "女";
				sex1=1;
			}
		}
	}
	//监听事件
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.im_return:
			finish();
			break;
		case R.id.bt_register_yes:
			user = new UserInfoDomain();
			user.loginUser.username = et_register_username.getText().toString().trim();
			user.loginUser.password = et_register_password.getText().toString().trim();
			user.userBase.name = et_register_name.getText().toString().trim();
			user.userDetailed.sex=sex1+"";
			user.userBase.phone = et_register_phone.getText().toString().trim();
			user.userBase.address = et_register_address.getText().toString().trim();
			user.loginUser.confirmPassword=et_register_password_yes.getText().toString().trim();
			
			if(user.loginUser.username.equals("")||user.loginUser.username==null){
					Dialog("用户名不能为空", et_register_username);
					return;
			}else if(null == user.userBase.name || "".equals(user.userBase.name)){
					Dialog("真实姓名不能为空",et_register_name);
					return;
			}else if(null == user.loginUser.password || "".equals(user.loginUser.password) || 
					!user.loginUser.password.matches("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,12}$")){
					Dialog("密码必须是数字和字母的组合,且长度为6到12位",et_register_password);
					return;
			}else if(!user.loginUser.password.equals(user.loginUser.confirmPassword)){
					Dialog("两次密码输入必须一致",et_register_password_yes);
					return;
			}else if(null == user.userBase.address || "".equals(user.userBase.address)){
					Dialog("地址不能为空",et_register_address);
					return;
			}else if(null == user.userBase.phone || "".equals(user.userBase.phone) || 
					!user.userBase.phone.matches("[0-9]{11}")){
					Dialog("请输入正确手机号",et_register_phone);
					return;
			}

			try {
				volley();
			} catch (JSONException e) {
				e.printStackTrace();
			}
			break;
		}
	}
	
	//网络请求
	public void volley() throws JSONException {
		RequestQueue requestQueue = Volley
				.newRequestQueue(getApplicationContext());
		
		Gson gson2 = new Gson();
		String str = gson2.toJson(user);

		org.json.JSONObject jsonObject = new org.json.JSONObject(str);
		Log.e("------------------", jsonObject.toString());
		JsonRequest<JSONObject> jsonRequest = new JsonObjectRequest(
				Method.POST, KtInterface.REGISTER, jsonObject,
				new Response.Listener<JSONObject>() {
					@Override
					public void onResponse(JSONObject response) {
						Log.e("TAG", response.toString());
						try {
							org.json.JSONObject ojb = new JSONObject(response.toString());
							org.json.JSONObject header = ojb.getJSONObject("responseHeader");
							String error = header.getString("errorCode");
							String message = header.getString("message");
							if (error.equals("0000")) {
								Toast.makeText(RegisteredActivity.this,
										message, Toast.LENGTH_LONG).show();
							} else {
								Toast.makeText(RegisteredActivity.this,message,
										Toast.LENGTH_LONG).show();
							}
							finish();
						} catch (JSONException e) {
							e.printStackTrace();
						}
					}
				}, new Response.ErrorListener() {
					@Override
					public void onErrorResponse(VolleyError error) {
						Log.e("TAG", error.getMessage(), error);
						Toast.makeText(RegisteredActivity.this,"网络连接错误！", Toast.LENGTH_LONG).show();
					}
				}) {

			@Override
			public Map<String, String> getHeaders() {
				HashMap<String, String> headers = new HashMap<String, String>();
				headers.put("Accept", "application/json");
				headers.put("Content-Type", "application/json; charset=UTF-8");

				return headers;
			}
		};
		requestQueue.add(jsonRequest);
	}
	//提示框
	public AlertDialog Dialog(String text, final EditText tditText) {
		return new AlertDialog.Builder(RegisteredActivity.this).setTitle("提示")
				.setMessage(text)
				.setPositiveButton("确定", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						tditText.setFocusable(true);
						tditText.setFocusableInTouchMode(true);
						tditText.requestFocus();
					}
				}).show();
	}
}
