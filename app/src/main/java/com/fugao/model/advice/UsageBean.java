/**   
 * Copyright © 2013 上海复高计算机科技有限公司. All rights reserved.
 * 
 * @Title: UsageBean.java 
 * @Prject: FugaoBase
 * @Package: com.fugao.model.advice 
 * @Description: TODO
 * @author: 饶涛  raotao@fugao.com
 * @date: 2013年12月25日 下午2:43:25 
 * @version: V1.0   
 */
package com.fugao.model.advice;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * 用法字典表
 * 
 * @ClassName: UsageBean
 * @Description: TODO
 * @author: 饶涛 raotao@fugao.com
 * @date: 2013年12月25日 下午2:43:25
 */
public class UsageBean {
	/**
	 * 代码
	 */
	@JsonProperty
	public String Code;
	/**
	 * HIS代码
	 */
	@JsonProperty
	public String HisCode;
	/**
	 * HIS名称
	 */
	@JsonProperty
	public String HisName;
	/**
	 * 名称
	 */
	@JsonProperty
	public String Name;
	/**
	 * 唯一号
	 */
	@JsonProperty
	public String Id;
	@JsonProperty
	public String SortId;
}
