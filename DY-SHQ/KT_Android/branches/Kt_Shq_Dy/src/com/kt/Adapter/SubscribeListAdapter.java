package com.kt.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

import com.kt.Activity.SubscribeLifeActivity;
import com.kt.Activity.SubscribeListActivity;
import com.kt.kt_shq_dy.R;

//===========================================================
//    预约服务地址Adapter
//==========================================================

public class SubscribeListAdapter extends BaseAdapter{
	private Context context;
	
	public SubscribeListAdapter(Context context){
		this.context=context;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 3;
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
			convertView=LayoutInflater.from(context).inflate(R.layout.subscribe_list_item, null);
			holder = new ViewHolder();
			holder.cb_list_xuan=(CheckBox) convertView.findViewById(R.id.cb_list_xuan);
			
			
			convertView.setTag(holder);
		}else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.cb_list_xuan.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				Intent intent=new Intent();
				intent.setClass(context, SubscribeLifeActivity.class);
				context.startActivity(intent);
				
			}
		});
		
		return convertView;
	}
	public class ViewHolder{
		private CheckBox cb_list_xuan;
	}
}
