package com.kt.Adapter;

import com.kt.kt_shq_dy.R;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
//===========================================================
//    网点预约排号Adapter
//==========================================================

public class DotQueryAdapter extends BaseAdapter{
	private Context context;
	
	
	public DotQueryAdapter(Context context){
		this.context=context;
		
	}
	@Override
	public int getCount() {
		return 3;
	}

	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder=null;
		if(convertView==null){
			convertView=LayoutInflater.from(context).inflate(R.layout.dotquery_list_item, null);
			holder = new ViewHolder();
			
			
			
		}else{
			holder=(ViewHolder) convertView.getTag();
		}
		
		
		return convertView;
	}
	public class ViewHolder{
		
	}
	
}
