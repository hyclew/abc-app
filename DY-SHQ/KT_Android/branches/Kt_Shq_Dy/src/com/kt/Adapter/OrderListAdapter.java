package com.kt.Adapter;

import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.kt.Bean.OrderDetailBusinessDomain;
import com.kt.Bean.OrderListBean;
import com.kt.Util.ChildLiistView;
import com.kt.kt_shq_dy.R;

//===========================================================
//    订单详细一级列表Adapter
//==========================================================

public class OrderListAdapter extends BaseAdapter{
	private Context context;
	private List<OrderListBean> oList;
	private LayoutInflater mLayoutInflater;

	public OrderListAdapter(Context context, List<OrderListBean> oList) {
		this.context = context;
		this.oList = oList;

		mLayoutInflater = LayoutInflater.from(context);
	}
	@Override
	public int getCount() {
		return oList.size();
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
		ViewHolder viewHolder = null;
		if (null == convertView) {
			convertView = mLayoutInflater.inflate(R.layout.order_list_item, null);

			viewHolder = new ViewHolder();
			viewHolder.tv_merchant_name=(TextView) convertView.findViewById(R.id.tv_merchant_name);
			viewHolder.lv_list=(ChildLiistView) convertView.findViewById(R.id.lv_list);
			
			
			
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		OrderListBean order=oList.get(position);
		List<OrderDetailBusinessDomain> domain=order.getOrderDetailBusinessDomain();
		Log.e("domain------------------------", domain.toString());
		viewHolder.tv_merchant_name.setText(order.getBusinessBase().getName());
		
		OrderListlistAdapter olAdapter=new OrderListlistAdapter(context, domain);
		viewHolder.lv_list.setAdapter(olAdapter);
		
		return convertView;
	}
	private class ViewHolder {
		private TextView tv_merchant_name; //商品名称
		private ChildLiistView lv_list;
		
	}
	
}
