package com.fugao.model;

import java.io.Serializable;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * 检查申请
 * @author gelp
 *
 */
public class CheckApplyBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5570311682194684340L;
	/**
	 * 申请ID
	 */
	@JsonProperty
	private String Id;
	/**
	 * 申请时间
	 */
	@JsonProperty
	private String RequestDate;
	@JsonProperty
	private String Flag;
	/**
	 * 住院号
	 */
	@JsonProperty
	private String PatId;
	/**
	 * 检查类型
	 */
	@JsonProperty
	private String ItemCode;
	/**
	 * 患者姓名
	 */
	@JsonProperty
	private String PatName;
	/**
	 * 性别
	 */
	@JsonProperty
	private String PatSex;
	/**
	 * 医技号
	 */
	@JsonProperty
	private String ApplyId;
	/**
	 * 申请科室
	 */
	@JsonProperty
	private String ReqDeptName;
	
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getRequestDate() {
		return RequestDate;
	}
	public void setRequestDate(String requestDate) {
		RequestDate = requestDate;
	}
	public String getFlag() {
		return Flag;
	}
	public void setFlag(String flag) {
		Flag = flag;
	}
	public String getPatId() {
		return PatId;
	}
	public void setPatId(String patId) {
		PatId = patId;
	}
	public String getItemCode() {
		return ItemCode;
	}
	public void setItemCode(String itemCode) {
		ItemCode = itemCode;
	}
	public String getPatName() {
		return PatName;
	}
	public void setPatName(String patName) {
		PatName = patName;
	}
	public String getPatSex() {
		return PatSex;
	}
	public void setPatSex(String patSex) {
		PatSex = patSex;
	}
	public String getApplyId() {
		return ApplyId;
	}
	public void setApplyId(String applyId) {
		ApplyId = applyId;
	}
	public String getReqDeptName() {
		return ReqDeptName;
	}
	public void setReqDeptName(String reqDeptName) {
		ReqDeptName = reqDeptName;
	}
	
}
