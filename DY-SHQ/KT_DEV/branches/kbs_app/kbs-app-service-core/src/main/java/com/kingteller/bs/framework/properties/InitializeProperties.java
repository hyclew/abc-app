package com.kingteller.bs.framework.properties;

import java.util.HashMap;
import java.util.Map;

/**
 * REST系统启动时将属性文件中的内容加载到内存中
 * @author wangyafei
 *
 */
public class InitializeProperties {

	private static Map<String, String> properties = new HashMap<String, String>();

	public static Map<String, String> getProperties() {
		return properties;
	}

	public static void setProperties(Map<String, String> properties) {
		InitializeProperties.properties = properties;
	}
	
	public static void putProperty(String key, String value){
		getProperties().put(key, value);
	}
	
	public static String getProperty(String key){
		return getProperties().get(key);
	}
	
}
