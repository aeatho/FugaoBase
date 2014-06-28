package com.fugao.model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;
/**
 * 检验申请
 * @author gelp
 *
 */
public class InspectApplyBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6768112019615044954L;
	/**
	 * 申请编号
	 */
	@JsonProperty
	private String Id;
	/**
	 * 检验类型
	 */
	@JsonProperty
	private String Type;
	/**
	 * 申请时间
	 */
	@JsonProperty
	private String RequestDate;
	/**
	 * 病区编号
	 */
	@JsonProperty
	private String DivisionCode;
	/**
	 * 病区名称
	 */
	@JsonProperty
	private String DivisionName;
	/**
	 * 住院号
	 */
	@JsonProperty
	private String PatId;
	/**
	 * 病人姓名
	 */
	@JsonProperty
	private String Name;
	/**
	 * 床号
	 */
	@JsonProperty
	private String BedNo;
	/**
	 * 性别
	 */
	@JsonProperty
	private String Sex;
	/**
	 * 年龄
	 */
	@JsonProperty
	private String Age;
	/**
	 * 诊断
	 */
	@JsonProperty
	private String Diagnosis;
	/**
	 * 报告时间
	 */
	@JsonProperty
	private String ReportDate;

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getRequestDate() {
		return RequestDate;
	}

	public void setRequestDate(String requestDate) {
		RequestDate = requestDate;
	}

	public String getDivisionCode() {
		return DivisionCode;
	}

	public void setDivisionCode(String divisionCode) {
		DivisionCode = divisionCode;
	}

	public String getDivisionName() {
		return DivisionName;
	}

	public void setDivisionName(String divisionName) {
		DivisionName = divisionName;
	}

	public String getPatId() {
		return PatId;
	}

	public void setPatId(String patId) {
		PatId = patId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getBedNo() {
		return BedNo;
	}

	public void setBedNo(String bedNo) {
		BedNo = bedNo;
	}

	public String getSex() {
		return Sex;
	}

	public void setSex(String sex) {
		Sex = sex;
	}

	public String getAge() {
		return Age;
	}

	public void setAge(String age) {
		Age = age;
	}

	public String getDiagnosis() {
		return Diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		Diagnosis = diagnosis;
	}

	public String getReportDate() {
		return ReportDate;
	}

	public void setReportDate(String reportDate) {
		ReportDate = reportDate;
	}
}
