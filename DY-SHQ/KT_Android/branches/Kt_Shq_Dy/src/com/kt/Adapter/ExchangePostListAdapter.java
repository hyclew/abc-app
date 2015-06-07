package com.kt.Adapter;

import com.kt.kt_shq_dy.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ExchangePostListAdapter extends BaseAdapter{
	private Context context;
	
	public ExchangePostListAdapter(Context context){
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
		return null;
	}


	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		ViewHolder holder=null;
		if(convertView==null){
			convertView=LayoutInflater.from(context).inflate(R.layout.exchangepost_list_item, null);
			holder = new ViewHolder();
			
			
			convertView.setTag(holder);
		}else {
			holder = (ViewHolder) convertView.getTag();
		}
			
		
		return convertView;
	}
	public class ViewHolder{
		
		private TextView textView1;
	}

	
}
