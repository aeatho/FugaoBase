/**   
 * Copyright © 2013 上海复高计算机科技有限公司. All rights reserved.
 * 
 * @Title: DrugBean.java 
 * @Prject: FugaoBase
 * @Package: com.fugao.model.advice 
 * @Description: TODO
 * @author: 饶涛  raotao@fugao.com
 * @date: 2013年12月25日 下午2:15:13 
 * @version: V1.0   
 */
package com.fugao.model.advice;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * 药品字典表
 * 
 * @ClassName: DrugBean
 * @Description: TODO
 * @author: 饶涛 raotao@fugao.com
 * @date: 2013年12月25日 下午2:15:13
 */
public class DrugBean extends DrugBaseBean {

	public boolean isChecked = false;
	/**
	 * 唯一号
	 */
	@JsonProperty
	public String Id;
	/**
	 * 通用名称
	 */
	@JsonProperty
	public String GeneralName;
	/**
	 * 包装量
	 */
	@JsonProperty
	public String Package;
	/**
	 * 包装单位
	 */
	@JsonProperty
	public String PackageUnit;
	/**
	 * 价格
	 */
	@JsonProperty
	public String Price;
	/**
	 * 单位
	 */
	@JsonProperty
	public String Unit;
	/**
	 * 推荐用法
	 */
	@JsonProperty
	public String GeneralUsage;
	/**
	 * 厂商
	 */
	@JsonProperty
	public String Company;
	/**
	 * 基本剂量
	 */
	@JsonProperty
	public String BasicDosage;
	/**
	 * 抗菌药物
	 */
	@JsonProperty
	public String IsAntibiotic;
}
