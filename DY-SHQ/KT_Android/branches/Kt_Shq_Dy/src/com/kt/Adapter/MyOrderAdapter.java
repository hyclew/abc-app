package com.kt.Adapter;

import java.util.List;

import com.kt.Bean.MyOrderBean;
import com.kt.kt_shq_dy.R;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

//===========================================================
//		我的订单Adapter
//==========================================================

public class MyOrderAdapter extends BaseAdapter{
	private Context context;
	private List<MyOrderBean> orderList;
	
	
	public MyOrderAdapter(Context context,List<MyOrderBean> orderList){
		this.context=context;
		this.orderList=orderList;
		
	}
	@Override
	public int getCount() {
		return orderList.size();
		
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
			convertView=LayoutInflater.from(context).inflate(R.layout.my_order_item, null);
			holder = new ViewHolder();
			holder.tv_order_number=(TextView) convertView.findViewById(R.id.tv_order_number);
			holder.tv_order_date=(TextView) convertView.findViewById(R.id.tv_order_date);
			holder.tv_order_shuliang=(TextView) convertView.findViewById(R.id.tv_order_shuliang);
			holder.tv_order_total=(TextView) convertView.findViewById(R.id.tv_order_total);
			
			
			convertView.setTag(holder);
		}else {
			holder = (ViewHolder) convertView.getTag();
		}	
		
		MyOrderBean order=orderList.get(position);
		
		holder.tv_order_number.setText("订单号:"+order.getOrderNumber());
		holder.tv_order_date.setText(order.getUpdateTime());
		holder.tv_order_shuliang.setText("数量："+order.getTotalNumbers());
		holder.tv_order_total.setText("总价："+order.getTotalCash());
		
		return convertView;
	}
	
	public class ViewHolder{
		private TextView tv_order_number;       //订单号
		private TextView tv_order_date;			//日期
		private TextView tv_order_shuliang;   //数量
		private TextView tv_order_total;	  //总价
		private ImageView im_order_checket;   //查看详情
	}

}
