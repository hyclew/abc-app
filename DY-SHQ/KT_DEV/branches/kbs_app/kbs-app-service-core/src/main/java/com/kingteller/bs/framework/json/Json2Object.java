package com.kingteller.bs.framework.json;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.SerializationFeature;

public class Json2Object {
	private static final Logger logger = Logger.getLogger(
			Json2Object.class.getName());
	private static  ThreadLocal localMapper = new ThreadLocal();
	
	private static ObjectMapper getMapper() {
		ObjectMapper mapper = (ObjectMapper) localMapper.get();
		if(mapper == null) {
			mapper = new ObjectMapper();
			localMapper.set(mapper);
		}
//		mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//		mapper.configure(SerializationConfig.Feature.WRITE_NULL_PROPERTIES, false);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);
		return mapper;
	}
	public static Object deserializeObject(String string, JavaType type) {
		Object userData;
		try {
			userData = getMapper().readValue(string, type);
			return userData;
		} catch (JsonParseException e) {
			if(logger.isErrorEnabled()) {
				logger.error("DeserializeObject:"+string+", type:"+type+" error.", e);
			}
		} catch (JsonMappingException e) {
			if(logger.isErrorEnabled()) {
				logger.error("DeserializeObject:"+string+", type:"+type+" error.", e);
			}
		} catch (IOException e) {
			if(logger.isErrorEnabled()) {
				logger.error("DeserializeObject:"+string+", type:"+type+" error.", e);
			}
		}
		return null;
	}
	
	public static Object convertObject(Object orig, JavaType type) 
	{
		Object userData;
		userData = getMapper().convertValue(orig, type);
		return userData;

	}
	
	public static Object convertObject(Object orig, Class<?> type) 
	{
		Object userData;
		userData = getMapper().convertValue(orig, type);
		return userData;

	}
	public static Object deserializeObject(String string, Class<?> type) throws JsonParseException, JsonMappingException{
		Object userData;
		try {
			userData = getMapper().readValue(string, type);
			return userData;
		} catch (JsonParseException e) {
			if(logger.isErrorEnabled()) {
				logger.error("DeserializeObject:"+string+", type:"+type+" error.", e);
			}
			throw new JsonParseException("传入Json转换为对象异常", JsonLocation.NA);
		} catch (JsonMappingException e) {
			if(logger.isErrorEnabled()) {
				logger.error("DeserializeObject:"+string+", type:"+type+" error.", e);
			}
			throw new JsonMappingException("传入Json转换为对象异常", JsonLocation.NA);
		} catch (IOException e) {
			if(logger.isErrorEnabled()) {
				logger.error("DeserializeObject:"+string+", type:"+type+" error.", e);
			}
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public static Map<String, Map<String, Map<String, Map<String, Map<String, Object>>>>> deserializeGdpObject(String jsonString) {
		Map<String, Map<String, Map<String, Map<String, Map<String, Object>>>>> userData;
		try {
			userData = getMapper().readValue(jsonString, Map.class);
			return userData;
		} catch (JsonParseException e) {
			if(logger.isErrorEnabled()) {
				logger.error("DeserializeObject:"+jsonString+" error.", e);
			}
		} catch (JsonMappingException e) {
			if(logger.isErrorEnabled()) {
				logger.error("DeserializeObject:"+jsonString+" error.", e);
			}
		} catch (IOException e) {
			if(logger.isErrorEnabled()) {
				logger.error("DeserializeObject:"+jsonString+" error.", e);
			}
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public static Map<?, ?> deserializeObject(String jsonString) {
		Map<String, Object> userData;
		try {
			userData = getMapper().readValue(jsonString, Map.class);
			return userData;
		} catch (JsonParseException e) {
			if(logger.isErrorEnabled()) {
				logger.error("DeserializeObject:"+jsonString+" error.", e);
			}
		} catch (JsonMappingException e) {
			if(logger.isErrorEnabled()) {
				logger.error("DeserializeObject:"+jsonString+" error.", e);
			}
		} catch (IOException e) {
			if(logger.isErrorEnabled()) {
				logger.error("DeserializeObject:"+jsonString+" error.", e);
			}
		}
		return null;
	}

	public static String serializeObject(Object _systemList) {
		try {
			return getMapper().writeValueAsString(_systemList);
		} catch (JsonGenerationException e) {
			if(logger.isErrorEnabled()) {
				logger.error("SerializeObject:"+_systemList+" error.", e);
			}
		} catch (JsonMappingException e) {
			if(logger.isErrorEnabled()) {
				logger.error("SerializeObject:"+_systemList+" error.", e);
			}
		} catch (IOException e) {
			if(logger.isErrorEnabled()) {
				logger.error("SerializeObject:"+_systemList+" error.", e);
			}
		}
		return null;
	}

	public static Date getStandardTime(long lastSynchTime) {
		return new Date(lastSynchTime);
	}
}
