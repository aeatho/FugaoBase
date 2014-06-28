/**   
 * Copyright © 2013 上海复高计算机科技有限公司. All rights reserved.
 * 
 * @Title: CM3Operation.java 
 * @Prject: FugaoBase
 * @Package: com.fugao.model.advice 
 * @Description: TODO
 * @author: 饶涛  raotao@fugao.com
 * @date: 2013年12月25日 下午2:31:42 
 * @version: V1.0   
 */
package com.fugao.model.advice;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * 手术字典表
 * 
 * @ClassName: CM3Operation
 * @Description: TODO
 * @author: 饶涛 raotao@fugao.com
 * @date: 2013年12月25日 下午2:31:42
 */
public class CM3OperationBean {
	/**
	 * 代码, 对应收费代码
	 */
	@JsonProperty
	public String Code;
	/**
	 * CM3编码",对应手术代码
	 */
	@JsonProperty
	public String Cm3Code;
	/**
	 * 手术级别,对应级别
	 */
	@JsonProperty
	public String Cm3Level;
}
