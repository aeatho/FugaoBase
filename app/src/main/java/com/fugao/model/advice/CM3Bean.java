/**   
 * Copyright © 2013 上海复高计算机科技有限公司. All rights reserved.
 * 
 * @Title: CM3.java 
 * @Prject: FugaoBase
 * @Package: com.fugao.model.advice 
 * @Description: TODO
 * @author: 饶涛  raotao@fugao.com
 * @date: 2013年12月25日 下午2:31:30 
 * @version: V1.0   
 */
package com.fugao.model.advice;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * 手术字典表
 * 
 * @ClassName: CM3
 * @Description: TODO
 * @author: 饶涛 raotao@fugao.com
 * @date: 2013年12月25日 下午2:31:30
 */
public class CM3Bean {
	/**
	 * 代码
	 */
	@JsonProperty
	public String Code;
	/**
	 * 名称
	 */
	@JsonProperty
	public String Name;
	/**
	 * 输入码,对应拼音码
	 */
	@JsonProperty
	public String Input;
	/**
	 * 标志
	 */
	@JsonProperty
	public String Flag;
}
