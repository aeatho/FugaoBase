/**   
 * Copyright © 2013 上海复高计算机科技有限公司. All rights reserved.
 * 
 * @Title: DrugBaseBean.java 
 * @Prject: FugaoBase
 * @Package: com.fugao.model.advice 
 * @Description: TODO
 * @author: 饶涛  raotao@fugao.com
 * @date: 2013年12月25日 下午2:26:28 
 * @version: V1.0   
 */
package com.fugao.model.advice;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * 药品和非药品公共部分
 * 
 * @ClassName: DrugBaseBean
 * @Description: TODO
 * @author: 饶涛 raotao@fugao.com
 * @date: 2013年12月25日 下午2:26:28
 */
public class DrugBaseBean {
	/**
	 * 基本单位
	 */
	@JsonProperty
	public String BasicUnit;
	/**
	 * 类别代码
	 */
	@JsonProperty
	public String CategoryCode;
	/**
	 * 类别名称
	 */
	@JsonProperty
	public String CategoryName;
	/**
	 * 代码
	 */
	@JsonProperty
	public String Code;
	/**
	 * 所属科室
	 */
	@JsonProperty
	public String DeptCode;
	/**
	 * 名称
	 */
	@JsonProperty
	public String Name;
	/**
	 * 输入码
	 */
	@JsonProperty
	public String Pinyin;
	/**
	 * 数量
	 */
	@JsonProperty
	public String Quntity;
	/**
	 * 备注
	 */
	@JsonProperty
	public String Remark;
	/**
	 * 排序
	 */
	@JsonProperty
	public String SortId;
	/**
	 * 规格
	 */
	@JsonProperty
	public String Spec;
	/**
	 * 状态
	 */
	@JsonProperty
	public String Status;
}
