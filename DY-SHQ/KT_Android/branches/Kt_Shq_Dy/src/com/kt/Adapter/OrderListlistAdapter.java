package com.kt.Adapter;

import java.text.NumberFormat;
import java.util.List;

import com.kt.Bean.OrderDetailBusinessDomain;
import com.kt.Bean.OrderListBean;
import com.kt.kt_shq_dy.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

//===========================================================
//     订单详细中二级列表Adapter
//==========================================================

public class OrderListlistAdapter extends BaseAdapter{
	private Context context;
	private LayoutInflater mLayoutInflater;
	private List<OrderDetailBusinessDomain> domain;
	
	public OrderListlistAdapter(Context context, List<OrderDetailBusinessDomain> domain){
		this.context=context;
		this.domain=domain;
		mLayoutInflater = LayoutInflater.from(context);
	}
	
	@Override
	public int getCount() {
		return domain.size();
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
			convertView = mLayoutInflater.inflate(R.layout.order_list_list_item, null);

			viewHolder = new ViewHolder();
			viewHolder.tv_present=(TextView) convertView.findViewById(R.id.tv_present);
			viewHolder.tv_unit_price=(TextView) convertView.findViewById(R.id.tv_unit_price);
			viewHolder.tv_number=(TextView) convertView.findViewById(R.id.tv_number);
			viewHolder.tv_total=(TextView) convertView.findViewById(R.id.tv_total);
			
			
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		OrderDetailBusinessDomain orderDomain=domain.get(position);
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		
		if(viewHolder.tv_present.getLineCount()>2){
			int lineEndIndex = viewHolder.tv_present.getLayout().getLineEnd(1);
			String text = viewHolder.tv_present.getText().subSequence(0, lineEndIndex-3) +"...";
			viewHolder.tv_present.setText(text);
		}
		
		viewHolder.tv_present.setText("商品简介："+orderDomain.getBusinessProduct().getIntroduce());
		viewHolder.tv_unit_price.setText("单价："+orderDomain.getCustomerOrderDetailed().getSalePrice());
		viewHolder.tv_number.setText("数量："+orderDomain.getCustomerOrderDetailed().getNumbers());
		viewHolder.tv_total.setText("总价："+formatter.format(orderDomain.getCustomerOrderDetailed().getTotal()));
		
		return convertView;
	}
	private class ViewHolder {
		private TextView tv_present;		//简介
		private TextView tv_unit_price;		//单价
		private TextView tv_number;			//数量
		private TextView tv_total;			//总价
		
	}
}
