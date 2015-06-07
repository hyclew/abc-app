package com.kingteller.bs.mvc.velocity;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.kingteller.bs.framework.check.StringUtils;

/**
 * Velocity工具类
 * 
 * @author yangfan
 */
//@DefaultKey("util")
//@ValidScope(Scope.APPLICATION)
public class VelocityUtil {

	/**
	 * float类型转换为int
	 * 
	 * @param f
	 * @return
	 */
	public int parseInt(float f) {
		return (int) f;
	}
	/**
	 * string类型转换为int
	 * @param f
	 * @return
	 */
	public int parseInt(String f) {
		if(f == null || "".equals(f)){
			return 0;
		}
		return Integer.valueOf(f);
	}

	/**
	 * 四舍五入保留n位小数
	 * 
	 * @param money
	 * @param n
	 * @return
	 */
	public String roundTo(BigDecimal money, int n) {
		if (money == null) {
			return "";
		}

		double d = money.doubleValue();
		return this.roundTo(d, n);
	}

	/**
	 * 四舍五入保留n位小数
	 * 
	 * @param money
	 * @param n
	 * @return
	 */
	public String roundTo(String money, int n) {
		if (money == null || "".equals(money)) {
			return "";
		}

		double d = Double.valueOf(money);
		return this.roundTo(d, n);
	}

	/**
	 * 四舍五入保留n位小数
	 * 
	 * @param money
	 * @param n
	 * @return
	 */
	public String roundTo(double money, int n) {
		double d = money;
		long power = (long) Math.pow(10, n);
		d = Math.round(d * power) / (power * 1.00);
		String s = String.valueOf(d);
		if (s.indexOf(".") == -1) {
			s = s + ".00";
		} else {
			String[] arr = s.split("\\.");
			if (arr[1].length() == 1) {
				s = s + "0";
			}
		}
		return s;
	}
	
	/**
	 * 金额格式化
	 * @param money
	 * @return
	 */
	public String formatMoney(String money){
		return this.formatMoney(Double.parseDouble(money));
	}
	
	/**
	 * 金额格式化
	 * @param money
	 * @return
	 */
	public String formatMoney(double money){
//		NumberFormat nf = NumberFormat.getNumberInstance();
		DecimalFormat df = new DecimalFormat("##,###,###,###,##0.00");
		return df.format(money);
	}
	
	/**
	 * 金额格式化
	 * @param money
	 * @return
	 */
	public String formatMoney(BigDecimal money){
		return this.formatMoney(money.doubleValue());
	}
	
	/**
	 * 日期转化  
	 * $util.formatDate("20131223 10:32:49", "yyyyMMdd HH:mm:ss", "yyyy-MM-dd HH:mm:ss")
	 * @param sdate 日期字符串
	 * @param oformater 原始格式化
	 * @param nformater 新格式化
	 * @return
	 */
	public String formatDate(String sdate, String oformater, String nformater){
		if(sdate == null || "".equals(sdate)){
			return "";
		}
		
		try {
			SimpleDateFormat osdf = new SimpleDateFormat(oformater);
			SimpleDateFormat nsdf = new SimpleDateFormat(nformater);
			Date odate = osdf.parse(sdate);
			return nsdf.format(odate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "格式化错误";
	}
	
	/**
	 * 
	 * @param userName
	 * @return
	 */
	public String hideUserName(String userName){
		if(userName != null && !"".equals(userName)){
			if(userName.length() > 3){
				return "***" + userName.substring(3, userName.length());
			} else {
				return "***";
			}
		} else {
			return "用户名为空";
		}
	}
	/**
	 * 特殊字符转html
	 * @param userName
	 * @return
	 */
	public String textToHtml(String s){
		if(StringUtils.isEmpty(s)){
			return " ";
		}else{
			return s.replaceAll("&","&amp;")
					.replaceAll(" ","&nbsp;")
					.replaceAll("<", "&lt;")
					.replaceAll(">", "&gt;")
					.replaceAll("\"", "&quot;")
					.replaceAll("\n", "<BR>");
		}
	}
}
