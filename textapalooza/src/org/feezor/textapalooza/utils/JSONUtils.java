package org.feezor.textapalooza.utils;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;


public class JSONUtils {
	
	private static ObjectMapper mapper;

	static {
		mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.setSerializationInclusion(Include.NON_NULL);
	}



	public static String objectToJson(Object obj) {
		// Java object to JSON string, default compact-print
		try {
			return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static <T> T jsonToObject(String jsonString, Class<T> clazz) {
		   T obj = null;
		   try {
		     obj = mapper.readValue(jsonString, clazz);
		   } catch (Exception e) {
		     e.printStackTrace();
		   }
		 
		   return obj;
		 }

}
