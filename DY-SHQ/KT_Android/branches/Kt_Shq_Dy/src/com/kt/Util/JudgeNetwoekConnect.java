package com.kt.Util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo.State;

public class JudgeNetwoekConnect {
	//判断网络是否连接
		public static boolean isConnect(Context context)
		{
			ConnectivityManager conMan = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
			State mobile = conMan.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState();
			State wifi = conMan.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState();

			if (mobile == State.CONNECTED || mobile == State.CONNECTING)
			{
				return true;
			} else if (wifi == State.CONNECTED || wifi == State.CONNECTING)
			{
				return true;
			} else
			{
				return false;
			}
		}
}
