/**   
 * Copyright © 2013 上海复高计算机科技有限公司. All rights reserved.
 * 
 * @Title: UnDrugBean.java 
 * @Prject: FugaoBase
 * @Package: com.fugao.model.advice 
 * @Description: TODO
 * @author: 饶涛  raotao@fugao.com
 * @date: 2013年12月25日 下午2:25:58 
 * @version: V1.0   
 */
package com.fugao.model.advice;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * 非药品字典表
 * 
 * @ClassName: UnDrugBean
 * @Description: TODO
 * @author: 饶涛 raotao@fugao.com
 * @date: 2013年12月25日 下午2:25:58
 */
public class UnDrugBean extends DrugBaseBean {
	public boolean isChecked = false;
	/**
	 * 序号
	 */
	@JsonProperty
	public String Id;
	/**
	 * 组代码,对应分组
	 */
	@JsonProperty
	public String GroupCode;
	/**
	 * 组名称, 对应分组名称
	 */
	@JsonProperty
	public String GroupName;
	/**
	 * 分类代码
	 */
	@JsonProperty
	public String ItemCode;
	/**
	 * 分类名称
	 */
	@JsonProperty
	public String ItemName;
	@JsonProperty
	public String Var1;
	@JsonProperty
	public String Var2;
	/**
	 * 单价
	 */
	@JsonProperty
	public String Price;
	/**
	 * 基本剂量
	 */
	@JsonProperty
	public String BasicDosag;
}
