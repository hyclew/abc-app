package com.kt.Adapter;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.Request.Method;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.kt.Bean.BusinessCartDomain;
import com.kt.Bean.ListBusinessCart;
import com.kt.Bean.ShoppingCartBean;
import com.kt.Bean.ShoppingCartId;
import com.kt.Bean.ShoppingCartUpdate;
import com.kt.KtApi.KtInterface;
import com.kt.kt_shq_dy.R;

//===========================================================
//		购物车Adapter
//==========================================================

public class ShoppingListAdapter extends BaseAdapter {
	// 用来控制CheckBox的选中状况  
	private static HashMap<Integer, Boolean> isSelected;  
	
	private Context context;
	private List<ShoppingCartBean> shoppingList;
	private List<ShoppingCartId> idList;
	private List<BusinessCartDomain> blist;
	private String rid;
	private ShoppingCartUpdate update;
	private TextView tv_shopping_total_deyang,tv_shopping_total;
	private Double s,p;
	
	public ShoppingListAdapter(Context context,List<ShoppingCartBean> shoppingList,List<ShoppingCartId> idList,List<BusinessCartDomain> blist,
					String rid,Double s,Double p,TextView tv_shopping_total_deyang,TextView tv_shopping_total){
		this.context=context;
		this.shoppingList=shoppingList;
		this.idList=idList;
		this.blist=blist;
		this.rid=rid;
		this.tv_shopping_total_deyang=tv_shopping_total_deyang;
		this.tv_shopping_total=tv_shopping_total;
		this.s=s;
		this.p=p;
		initDate();
	}

	
	private void initDate() {
		update=new ShoppingCartUpdate();
		isSelected= new HashMap<Integer, Boolean>();
		for (int i = 0; i < shoppingList.size(); i++) { 
			isSelected.put(i, false);  
        } 
	}


	@Override
	public int getCount() {
		return shoppingList.size();
	}

	@Override
	public Object getItem(int position) {
		return shoppingList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {

		 final ViewHolder holder;
		 final ShoppingCartBean car=shoppingList.get(position);
		if(convertView==null){
			
			convertView=LayoutInflater.from(context).inflate(R.layout.shopping_list_item, null);
			holder = new ViewHolder();
			
			holder.iv_shopping_cb=(CheckBox) convertView.findViewById(R.id.iv_shopping_cb);
			holder.tv_shopping_number=(TextView) convertView.findViewById(R.id.tv_shopping_number);
			holder.im_shopping_add=(ImageView) convertView.findViewById(R.id.im_shopping_add);
			holder.im_shopping_minus=(ImageView) convertView.findViewById(R.id.im_shopping_minus);
			holder.tv_shopping_introduction=(TextView) convertView.findViewById(R.id.tv_shopping_introduction);
			holder.tv_shopping_name=(TextView) convertView.findViewById(R.id.tv_shopping_name);
			holder.tv_shopping_money=(TextView) convertView.findViewById(R.id.tv_shopping_money);
			holder.tv_shopping_deyang=(TextView) convertView.findViewById(R.id.tv_shopping_deyang);
			
			convertView.setTag(holder);
		}else {
			holder = (ViewHolder) convertView.getTag();
		}	
	
		//购物车基本详情数据显示
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		holder.tv_shopping_name.setText(car.getProductName());
		holder.tv_shopping_introduction.setText(car.getProductIntroduce());
		holder.tv_shopping_deyang.setText(formatter.format(Double.parseDouble(car.getProductPreferPrice())));
		holder.tv_shopping_money.setText("价格："+formatter.format(Double.parseDouble(car.getProductSalePrice())));
		holder.tv_shopping_number.setText(car.getCount());
		//单选按钮事件
		holder.iv_shopping_cb.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // 将CheckBox的选中状况记录下来  .
                getIsSelected().put(position, holder.iv_shopping_cb.isChecked()); 
                //选中时候的id
                ShoppingCartId sid=new ShoppingCartId();
				sid.id=car.getCartId();
				//结算时选中数据
				BusinessCartDomain bc=new BusinessCartDomain();
				bc.cartId=car.getCartId();
				bc.businessProductId=car.getBusinessProductId();
				bc.businessProductCatalogId=car.getBusinessProductCatalogId();
				bc.count=car.getCount();
				bc.productSalePrice=car.getProductSalePrice();
				bc.productPreferPrice=car.getProductPreferPrice();
				//两个变量控制两个价格
				Double sale=Double.parseDouble(car.getProductSalePrice())*Double.parseDouble( holder.tv_shopping_number.getText().toString());
				Double prefer=Double.parseDouble(car.getProductPreferPrice())*Double.parseDouble( holder.tv_shopping_number.getText().toString());
                // 调整选定条目  
                if (holder.iv_shopping_cb.isChecked() == true) { 
                	idList.add(sid);
                	blist.add(bc);
    				ListBusinessCart.blist=blist;
                	
                	s+=sale;
                	p+=prefer;
                	tv_shopping_total.setText("合计"+String.valueOf(p)+"元");
                	tv_shopping_total_deyang.setText("合计"+String.valueOf(s)+"元");
                	ShoppingListAdapter.this.notifyDataSetChanged();
                	
                } else if(holder.iv_shopping_cb.isChecked() == false){
                	//遍历选中id集合
                	for(int i=0;i<idList.size();i++){
        				if(idList.get(i).getId()==car.getCartId()){
        					idList.remove(i);
                        	s-=sale;
                        	p-=prefer;
                        	tv_shopping_total.setText("合计"+String.valueOf(p)+"元");
                        	tv_shopping_total_deyang.setText("合计"+String.valueOf(s)+"元");
        				}
        			}
                	//遍历结算时候选中的集合
                	for(int i=0;i<blist.size();i++){
                		if(blist.get(i).getCartId()==car.getCartId()){
                			blist.remove(i);
                			ListBusinessCart.blist=blist;
                		}
                	}
                    ShoppingListAdapter.this.notifyDataSetChanged();
                }  
                
			}
		});
		//数量加按钮点击事件
		holder.im_shopping_add.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				int num=Integer.parseInt( holder.tv_shopping_number.getText().toString());
				 if(num<80&&num>1||num==1){
				   num++;
				 holder.tv_shopping_number.setText(Integer.toString(num)); 
				
				 update.sessionId=rid;
				 update.shoppingCart.id=car.getCartId();
				 update.shoppingCart.count=holder.tv_shopping_number.getText().toString();
				 try {
					updateHttp();
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
			}
		});
		//数量减按钮点击事件
		holder.im_shopping_minus.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				int num=Integer.parseInt( holder.tv_shopping_number.getText().toString());
				if(num<80&&num>1){
				num--;
				holder.tv_shopping_number.setText(Integer.toString(num)); 
				
				update.sessionId=rid;
				update.shoppingCart.id=car.getCartId();
				update.shoppingCart.count=holder.tv_shopping_number.getText().toString();
				try {
					updateHttp();
				} catch (JSONException e) {
					e.printStackTrace();
				}
				}
			}
		});
		
		// 根据isSelected来设置checkbox的选中状况  
        holder.iv_shopping_cb.setChecked(getIsSelected().get(position)); 
        
        
		return convertView;
	}
	public static HashMap<Integer, Boolean> getIsSelected() {  
        return isSelected;  
    }  

    public static void setIsSelected(HashMap<Integer, Boolean> isSelected) {  
    	ShoppingListAdapter.isSelected = isSelected;  
    } 
	//holder方法 属性初始化
	public class ViewHolder{
		public CheckBox iv_shopping_cb;
		private TextView tv_shopping_number;
		private ImageView im_shopping_minus;
		private ImageView im_shopping_add;
		private TextView tv_shopping_name;
		private TextView tv_shopping_introduction;
		private TextView tv_shopping_money;
		private TextView tv_shopping_deyang;
		
	}
	//更新网络请求
	public void updateHttp()throws JSONException{
		RequestQueue requestQueue = Volley.newRequestQueue(context);
		
		Gson gson2 = new Gson();
		String str = gson2.toJson(update);
		org.json.JSONObject jsonObject = new org.json.JSONObject(str);
		Log.e("------------------", jsonObject.toString());
		
		JsonRequest<JSONObject> jsonRequest = new JsonObjectRequest(
				Method.POST, KtInterface.UPDATECART, jsonObject,
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
								
								Toast.makeText(context,message, Toast.LENGTH_LONG).show();
							} else {
								
								Toast.makeText(context,message,Toast.LENGTH_LONG).show();
							}
							
						} catch (JSONException e) {
							e.printStackTrace();
						}
					}
				}, new Response.ErrorListener() {
					@Override
					public void onErrorResponse(VolleyError error) {
						Log.e("TAG", error.getMessage(), error);
						Toast.makeText(context,"网络连接错误！", Toast.LENGTH_LONG).show();
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
}
