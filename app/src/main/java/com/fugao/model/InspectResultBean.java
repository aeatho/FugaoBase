package com.fugao.model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;
/**
 * 检验结果
 * @author gelp
 *
 */
public class InspectResultBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -138991865768083627L;
	/**
	 * 用作类型排序
	 */
	@JsonProperty
	private String Type;
	/**
	 * 申请时间
	 */
	@JsonProperty
	private String RequestDate;
	/**
	 * 检验号
	 */
	@JsonProperty
	private String SampleNo;
	/**
	 * 结果描述
	 */
	@JsonProperty
	private String Value;
	/**
	 * 临界值
	 */
	@JsonProperty
	private String RefRange;
	/**
	 * 检验代码
	 */
	@JsonProperty
	private String ItemCode;
	/**
	 * 检验名称
	 */
	@JsonProperty
	private String ItemName;
	/**
	 * 结果
	 */
	@JsonProperty
	private String Conclusion;

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

	public String getSampleNo() {
		return SampleNo;
	}

	public void setSampleNo(String sampleNo) {
		SampleNo = sampleNo;
	}

	public String getValue() {
		return Value;
	}

	public void setValue(String value) {
		Value = value;
	}

	public String getRefRange() {
		return RefRange;
	}

	public void setRefRange(String refRange) {
		RefRange = refRange;
	}

	public String getItemCode() {
		return ItemCode;
	}

	public void setItemCode(String itemCode) {
		ItemCode = itemCode;
	}

	public String getItemName() {
		return ItemName;
	}

	public void setItemName(String itemName) {
		ItemName = itemName;
	}

	public String getConclusion() {
		return Conclusion;
	}

	public void setConclusion(String conclusion) {
		Conclusion = conclusion;
	}
}
