package com.kt.Adapter;

import java.text.NumberFormat;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.kt.Activity.BottledWaterActivity;
import com.kt.Bean.LifeBean;
import com.kt.KtApi.KtInterface;
import com.kt.kt_shq_dy.R;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Toast;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

//===========================================================
//   送水列表Adapter
//==========================================================

public class WaterListAdapter extends BaseAdapter{
	private Context context;
	private List<LifeBean> list;
	private RequestQueue mQueue;
	private String url;
	private String headurl;
	private Bitmap bitmap;
	
	public WaterListAdapter(Context context,List<LifeBean> list){
		this.context=context;
		this.list=list;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}
	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder=null;
		if(convertView==null){
			convertView=LayoutInflater.from(context).inflate(R.layout.water_list_item, null);
			holder = new ViewHolder();
			
			holder.tv_waterlist_introduction=(TextView) convertView.findViewById(R.id.tv_waterlist_introduction);
			holder.tv_waterlist_level=(TextView) convertView.findViewById(R.id.tv_waterlist_level);
			holder.tv_waterlist_ample=(TextView) convertView.findViewById(R.id.tv_waterlist_ample);
			holder.tv_waterlist_card=(TextView) convertView.findViewById(R.id.tv_waterlist_card);
			holder.iv_waterlist_head= (ImageView) convertView.findViewById(R.id.iv_waterlist_head);
			
			convertView.setTag(holder);
		}else {
			holder = (ViewHolder) convertView.getTag();
		}
		LifeBean water=list.get(position);
		
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		
		if(holder.tv_waterlist_introduction.getLineCount()>1){
			int lineEndIndex = holder.tv_waterlist_introduction.getLayout().getLineEnd(1);
			String text = holder.tv_waterlist_introduction.getText().subSequence(0, lineEndIndex-3) +"...";
			holder.tv_waterlist_introduction.setText(text);
		}
		
		holder.tv_waterlist_introduction.setText("简介："+water.getIntroduce());
		holder.tv_waterlist_level.setText(formatter.format(water.getUnitPrice()));
		holder.tv_waterlist_level.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG );
		holder.tv_waterlist_ample.setText(formatter.format(water.getSalePrice()));
		holder.tv_waterlist_card.setText(formatter.format(water.getPreferPrice()));
		
		url = KtInterface.WATERHEAD+water.getResourceId();
//		mQueue = Volley .newRequestQueue(context);
//		StringRequest myRequest=new StringRequest(Request.Method.GET,url, 
//				new Response.Listener<String>() {
//			
//					@Override
//					public void onResponse(String response) {
//						try {
//							org.json.JSONObject json = new org.json.JSONObject(response);
//							org.json.JSONObject urljson=json.getJSONObject("responseBody");
//							headurl=urljson.getString("resourceURL");
//							//base64解码
//							byte[] byteIcon = Base64.decode(headurl,Base64.DEFAULT);
//						    bitmap = BitmapFactory.decodeByteArray(byteIcon,0,byteIcon.length);
//							
//						} catch (Exception e) {
//							e.printStackTrace();
//						}
//					}
//		},new Response.ErrorListener() {
//			@Override
//			public void onErrorResponse(VolleyError error) {
//				Log.e("TAG", error.getMessage(), error);
//				Toast.makeText(context,"网络连接错误！", Toast.LENGTH_LONG).show();
//			}
//		});
//		mQueue.add(myRequest);
//		holder.iv_waterlist_head.setImageBitmap(bitmap);
		
		return convertView;
	}
	public class ViewHolder{
		private TextView tv_waterlist_introduction;//简介
		private TextView tv_waterlist_level; //原价
		private TextView tv_waterlist_ample; //优惠
		private TextView tv_waterlist_card;  //银行促销
		private ImageView iv_waterlist_head; //图片
}
}
