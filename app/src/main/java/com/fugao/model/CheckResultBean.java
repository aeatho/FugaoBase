package com.fugao.model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;
/**
 * 检查结果
 * @author gelp
 *
 */
public class CheckResultBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 808719205258988896L;
	/**
	 * 检查类型
	 */
	@JsonProperty
	private String ItemCode;
	/**
	 * 检查部位和名称
	 */
	@JsonProperty
	private String ItemName;
	/**
	 * 放射学诊断
	 */
	@JsonProperty
	private String DiagResult;
	/**
	 * 放射学表现
	 */
	@JsonProperty
	private String Content;
	/**
	 * 报告时间
	 */
	@JsonProperty
	private String ReportDate;
	/**
	 * 审核医生
	 */
	@JsonProperty
	private String VerifyDoctor;
	/**
	 * 审核时间
	 */
	@JsonProperty
	private String VerifyDate;
	/**
	 * 申请时间
	 */
	@JsonProperty
	private String RequestDate;
	/**
	 * 申请编号
	 */
	@JsonProperty
	private String Id;
	/**
	 * 门诊号
	 */
	@JsonProperty
	private String ClinicNo;
	/**
	 * 是否处在图像
	 */
	@JsonProperty
	private boolean HasDicom;
	/**
	 * 临床诊断
	 */
	@JsonProperty
	private String ClinicDiag;
	/**
	 * 检查方法
	 */
	@JsonProperty
	private String ExamTech;
	/**
	 * 患者姓名
	 */
	@JsonProperty
	private String Name;
	/**
	 * 患者性别
	 */
	@JsonProperty
	private String Sex;
	/**
	 * 年龄
	 */
	@JsonProperty
	private String Age;
	/**
	 * 科室名称
	 */
	@JsonProperty
	private String DeptName;
	/**
	 * 病人住院号
	 */
	@JsonProperty
	private String PatId;
	/**
	 * 病区名称
	 */
	@JsonProperty
	private String DivisionName;
	/**
	 * 床位号
	 */
	@JsonProperty
	private String BedNo;
	/**
	 * 报告医生
	 */
	@JsonProperty
	private String Reportor;
	
	public String getItemName() {
		return ItemName;
	}
	public void setItemName(String itemName) {
		ItemName = itemName;
	}
	public String getDiagResult() {
		return DiagResult;
	}
	public void setDiagResult(String diagResult) {
		DiagResult = diagResult;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public String getReportDate() {
		return ReportDate;
	}
	public void setReportDate(String reportDate) {
		ReportDate = reportDate;
	}
	public String getVerifyDoctor() {
		return VerifyDoctor;
	}
	public void setVerifyDoctor(String verifyDoctor) {
		VerifyDoctor = verifyDoctor;
	}
	public String getVerifyDate() {
		return VerifyDate;
	}
	public void setVerifyDate(String verifyDate) {
		VerifyDate = verifyDate;
	}
	public String getRequestDate() {
		return RequestDate;
	}
	public void setRequestDate(String requestDate) {
		RequestDate = requestDate;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getClinicNo() {
		return ClinicNo;
	}
	public void setClinicNo(String clinicNo) {
		ClinicNo = clinicNo;
	}
	public boolean isHasDicom() {
		return HasDicom;
	}
	public void setHasDicom(boolean hasDicom) {
		HasDicom = hasDicom;
	}
	public String getClinicDiag() {
		return ClinicDiag;
	}
	public void setClinicDiag(String clinicDiag) {
		ClinicDiag = clinicDiag;
	}
	public String getExamTech() {
		return ExamTech;
	}
	public void setExamTech(String examTech) {
		ExamTech = examTech;
	}
	public String getItemCode() {
		return ItemCode;
	}
	public void setItemCode(String itemCode) {
		ItemCode = itemCode;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
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
	public String getDeptName() {
		return DeptName;
	}
	public void setDeptName(String deptName) {
		DeptName = deptName;
	}
	public String getPatId() {
		return PatId;
	}
	public void setPatId(String patId) {
		PatId = patId;
	}
	public String getDivisionName() {
		return DivisionName;
	}
	public void setDivisionName(String divisionName) {
		DivisionName = divisionName;
	}
	public String getBedNo() {
		return BedNo;
	}
	public void setBedNo(String bedNo) {
		BedNo = bedNo;
	}
	public String getReportor() {
		return Reportor;
	}
	public void setReportor(String reportor) {
		Reportor = reportor;
	}
	
}
