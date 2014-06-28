package com.fugao.utils;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
/**
 * 解析基本模型
 * @author findchen_2013
 * 2013年11月18日上午10:38:17
 */
public class BaseString2Model {
	public static String ITEMS = "Items";
	public static String COUNTS = "Count";
	public static ObjectMapper objectMapper = new ObjectMapper();
	static {
		objectMapper
				.configure(
						DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES,
						false);
		objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
	}
}
