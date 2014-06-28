package com.fugao.model;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * 医嘱的模型
 * 
 * @author chenliang
 * @date 2012-12-22
 */
public class AdviceBean {
	public boolean isChecked;
	/**
	 * 医嘱编号
	 */
	@JsonProperty
	public String Id;
	/**
	 * 相关医嘱
	 */
	@JsonProperty
	public String GroupId;
	/**
	 * 所属病区
	 */
	@JsonProperty
	public String DivisionCode;
	/**
	 * 所属科室
	 */
	@JsonProperty
	public String DeptCode;
	/**
	 * 住院号
	 */
	@JsonProperty
	public String PatId;

	/**
	 * 医嘱属性
	 */
	@JsonProperty
	public String CategoryCode;

	/**
	 * 录入工号
	 */
	@JsonProperty
	public String CreatorId;
	@JsonProperty
	public String Creator;

	/**
	 * 开方医生
	 */
	@JsonProperty
	public String DoctorId;
	/**
	 * 开方医生
	 */
	@JsonProperty
	public String DoctorName;
	/**
	 * 开始日期
	 */
	@JsonProperty
	public String BeginDate;
	/**
	 * 开始时间
	 */
	@JsonProperty
	public String BeginTime;

	/**
	 * 类别
	 */
	@JsonProperty
	public String ItemCode;
	/**
	 * 医嘱种类
	 */
	@JsonProperty
	public String ItemName;
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

	public String HisCode;
	public String HisName;
	/**
	 * 规格
	 */
	@JsonProperty
	public String Spec;
	/**
	 * 剂量
	 */
	@JsonProperty
	public String OneDosage;
	/**
	 * 单位
	 */
	@JsonProperty
	public String OneDosageUnit;
	/**
	 * 频次
	 */
	@JsonProperty
	public String Frequency;
	/**
	 * 途径
	 */
	@JsonProperty
	public String Usage;
	/**
	 * 说明
	 */
	@JsonProperty
	public String Desc;
	/**
	 * 备注
	 */
	@JsonProperty
	public String Remark;

	/**
	 * 录入日期
	 */
	@JsonProperty
	public String CreatedDate;
	/**
	 * 录入时间
	 */
	@JsonProperty
	public String CreatedTime;
	/**
	 * 确认日期
	 */
	@JsonProperty
	public String ExecuteDate;
	/**
	 * 确认时间
	 */
	@JsonProperty
	public String ExecuteTime;
	/**
	 * 确认者(执行护士)
	 */
	@JsonProperty
	public String ExecutorId;
	@JsonProperty
	public String Executor;

	/**
	 * 确认标记
	 */
	@JsonProperty
	public String ExeFlag;
	/**
	 * 停止标志
	 */
	@JsonProperty
	public String StopFlag;
	/**
	 * 停止日期
	 */
	@JsonProperty
	public String StopDate;
	/**
	 * 停止时间
	 */
	@JsonProperty
	public String StopTime;
	/**
	 * 停止工号
	 */
	@JsonProperty
	public String StopDoctorId;
	/**
	 * 停止工号(name)// 停止医生
	 */
	@JsonProperty
	public String StopDoctor;

	/**
	 * 自理标志
	 */
	@JsonProperty
	public String SelfProvide;
	/**
	 * 数量
	 */
	@JsonProperty
	public String Quantity;
	/**
	 * 执行次数
	 */
	@JsonProperty
	public String ExeCount;
	/**
	 * 报告标志
	 */
	@JsonProperty
	public String RptFlag;
	@JsonProperty
	public String AdContent;
	@JsonProperty
	public String AdStatus;
	@JsonProperty
	public String AdBeginTime;
	@JsonProperty
	public String InSystem;
	/**
	 * 特殊剂量
	 */
	@JsonProperty
	public String SpDose;

}
