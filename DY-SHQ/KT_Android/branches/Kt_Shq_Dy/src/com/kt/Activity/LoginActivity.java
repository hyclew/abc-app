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
import com.kt.Bean.LoginBean;
import com.kt.Bean.UserInfoDomain;
import com.kt.Fragment.Fragment_MyCircle;
import com.kt.KtApi.KtInterface;
import com.kt.kt_shq_dy.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.style.ReplacementSpan;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

//===========================================================
//   登录activity
//==========================================================

public class LoginActivity extends Activity implements OnClickListener{
	private ImageView im_return,im_login_register,im_login_wangji,im_login_go;
	private EditText et_login_username,et_login_password;
	private Intent intent;
	public SharedPreferences mySharedPreferences;
	public SharedPreferences.Editor editor;
	private LoginBean user;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		byId();
		listener();
	}
	//属性初始化
	public void byId(){
		intent=new Intent();
		im_return=(ImageView) findViewById(R.id.im_return);
		im_login_register=(ImageView) findViewById(R.id.im_login_register);
		im_login_wangji=(ImageView) findViewById(R.id.im_login_wangji);
		im_login_go=(ImageView) findViewById(R.id.im_login_go);
		et_login_username=(EditText) findViewById(R.id.et_login_username);
		et_login_password=(EditText) findViewById(R.id.et_login_password);
	}
	//监听方法
	public void listener(){
		im_return.setOnClickListener(this);
		im_login_register.setOnClickListener(this);
		im_login_wangji.setOnClickListener(this);
		im_login_go.setOnClickListener(this);
	}
	//监听事件
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.im_return:
			finish();
			break;

		case R.id.im_login_register:
			intent.setClass(LoginActivity.this, RegisteredActivity.class);
			startActivity(intent);
			break;
			
		case R.id.im_login_wangji:
			intent.setClass(LoginActivity.this, ForgetPasswordActivity.class);
			startActivity(intent);
			break;
			
		case R.id.im_login_go:
			user=new LoginBean();
			user.username= et_login_username.getText().toString().trim();
			user.password=et_login_password.getText().toString().trim();
			if(user.username==null||"".equals(user.username)){
				Dialog("用户名/手机号不能为空",et_login_username);
				return;
			}else if(user.password==null||"".equals(user.password)||
					!user.password.matches("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,12}$")){
				Dialog("密码必须是数字和字母的组合,且长度为6到12位",et_login_password);
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
		String str =gson2.toJson(user);

        org.json.JSONObject jsonObject =new org.json.JSONObject(str);
             
        JsonRequest<JSONObject> jsonRequest = new JsonObjectRequest(Method.POST,KtInterface.LOGIN, jsonObject,
        	    new Response.Listener<JSONObject>() {
        	        @Override
        	        public void onResponse(JSONObject response) {
        	        	Log.e("TAG", response.toString());
        	        	try {
							org.json.JSONObject ojb=new JSONObject(response.toString());
							org.json.JSONObject header=ojb.getJSONObject("responseHeader");
							String error= header.getString("errorCode");
							String message=header.getString("message");
							
							if(error.equals("0000")){
								org.json.JSONObject body=ojb.getJSONObject("responseBody");
								String sessionId=body.getString("sessionId");
								Toast.makeText(LoginActivity.this, message, Toast.LENGTH_LONG).show();
								
								mySharedPreferences = getSharedPreferences("test",Activity.MODE_PRIVATE); 
								editor = mySharedPreferences.edit(); 
								editor.putString("sessionId",sessionId); 
								editor.commit(); 
								
								Intent intent=new Intent();
								intent.setClass(LoginActivity.this,Fragment_MyCircle.class);
								startActivity(intent);
							}else{
								Toast.makeText(LoginActivity.this, message, Toast.LENGTH_LONG).show();
							}
							
						} catch (JSONException e) {
							e.printStackTrace();
						}
        	        }
        	    }, new Response.ErrorListener() {
        	        @Override
        	        public void onErrorResponse(VolleyError error) {
        	            Log.e("TAG", error.getMessage(), error);
        	            Toast.makeText(LoginActivity.this,"请检查网络后重试！", Toast.LENGTH_LONG).show();
        	    }
        	    })
        	    {
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
			return new AlertDialog.Builder(LoginActivity.this).setTitle("提示")
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
