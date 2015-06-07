package com.kt.Bean;

import java.util.ArrayList;
import java.util.List;

//购物车结算保存的选中数据
public class ListBusinessCart {
	public static List<BusinessCartDomain> blist=new ArrayList<BusinessCartDomain>();

	public static List<BusinessCartDomain> getBlist() {
		return blist;
	}

	public static void setBlist(List<BusinessCartDomain> blist) {
		ListBusinessCart.blist = blist;
	}

	@Override
	public String toString() {
		return "ListBusinessCart [getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}
