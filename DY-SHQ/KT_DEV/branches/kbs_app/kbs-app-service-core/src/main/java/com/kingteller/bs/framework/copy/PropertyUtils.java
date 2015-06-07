package com.kingteller.bs.framework.copy;

import com.kingteller.bs.framework.exception.AppException;

public abstract class PropertyUtils {
	 public static void copyProperties(Object dest, Object orig){
		 try{
		org.apache.commons.beanutils.PropertyUtils.copyProperties(dest, orig);
		 }catch(Exception e){
			 throw new AppException(e.getMessage());
		 }
	}
}
