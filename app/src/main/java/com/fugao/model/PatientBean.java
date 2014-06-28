package com.fugao.model;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 病人模型, 实现了Parcelable 接口
 * 
 * @author chenliang
 * @date 2012-12-11
 */
public class PatientBean implements Parcelable {
	/**
	 * 序号
	 */
	@JsonProperty
	private String Id;
	/**
	 * 病人的姓名
	 */
	@JsonProperty
	private String Name;
	/**
	 * 病人的性别
	 */
	@JsonProperty
	private String Sex;
	/**
	 * 病人的年龄
	 */
	@JsonProperty
	private String Age;
	/**
	 * 出生日期
	 */
	@JsonProperty
	private String Birthday;
	/**
	 * 病人住院号
	 */
	@JsonProperty
	private String PatId;
	/**
	 * 门诊号
	 */
	@JsonProperty
	private String ClinicNo;
	/**
	 * 入院日期
	 */
	@JsonProperty
	private String InHosDate;
	/**
	 * 出院日期
	 */
	@JsonProperty
	private String OutHosDate;
	/**
	 * 所属病区
	 */
	@JsonProperty
	private String DivisionCode;
	/**
	 * 病区的名称
	 */
	@JsonProperty
	private String DivisionName;

	/**
	 * 科室代码 所属科室
	 */
	@JsonProperty
	private String DeptCode;
	/**
	 * 科室的名称
	 */
	@JsonProperty
	private String DeptName;
	/**
	 * 病人的床位号
	 */
	@JsonProperty
	private String BedNo;
	/**
	 * 主治医师的工号
	 */
	@JsonProperty
	private String DoctorId;
	/**
	 * 主治医生的姓名
	 */
	@JsonProperty
	private String DoctorName;
	/**
	 * 护理等级
	 */
	@JsonProperty
	private String CareLevel;
	/**
	 * 主病案号
	 */
	@JsonProperty
	private String MedicalId;
	/**
	 * 护理名称
	 */
	@JsonProperty
	private String CareName;
	/**
	 * 治疗状态
	 */
	@JsonProperty
	private String CureStatus;
	/**
	 * 饮食名称
	 */
	@JsonProperty
	private String DietName;
	/**
	 * 饮食类型
	 */
	@JsonProperty
	private String DietType;
	/**
	 * 记帐名称
	 */
	@JsonProperty
	private String PatientType;
	/**
	 * 诊断
	 */
	@JsonProperty
	private String Diagnosis;
	/**
	 * 余额
	 */
	@JsonProperty
	private String Balance;
	/**
	 * 药物反应的代码 值
	 */
	@JsonProperty
	private String DrugAllergy;
	/**
	 * 是否选中
	 */
	@JsonIgnore
	public boolean ischecked;
	/**
	 * 入院天数
	 */
	@JsonProperty
	private String DaysInHos;
	/**
	 * 出院天数
	 * 
	 */
	@JsonProperty
	private String DaysOutHos;
	/**
	 * 护理级别
	 */
	@JsonProperty
	private String CstCareLevel;
	/**
	 * 住院状态
	 */
	@JsonProperty
	private String PatStatus;

	/**
	 * 病人头像
	 */
	@JsonProperty
	private PatAffixBean PatAffix;

	/**
	 * 过敏药物的项目名称
	 */
	@JsonProperty
	private String DrugAllergyValues;

	private PatientDetail patientDetail;
	/**
	 * 健康卡号
	 */
	@JsonProperty
	private String HealthyCardID;

	public String getPatStatus() {
		return PatStatus;
	}

	public void setPatStatus(String patStatus) {
		PatStatus = patStatus;
	}
	

	public String getHealthyCardID() {
		return HealthyCardID;
	}

	public void setHealthyCardID(String healthyCardID) {
		HealthyCardID = healthyCardID;
	}

	public String getDrugAllergyValues() {
		return DrugAllergyValues;
	}

	public void setDrugAllergyValues(String drugAllergyValues) {
		DrugAllergyValues = drugAllergyValues;
	}

	public PatAffixBean getPatAffix() {
		return PatAffix;
	}

	public void setPatAffix(PatAffixBean patAffix) {
		PatAffix = patAffix;
	}

	public String getCareLevel() {
		return CareLevel;
	}

	public void setCareLevel(String careLevel) {
		CareLevel = careLevel;
	}

	public boolean isIschecked() {
		return ischecked;
	}

	public void setIschecked(boolean ischecked) {
		this.ischecked = ischecked;
	}

	public String getDaysInHos() {
		return DaysInHos;
	}

	public void setDaysInHos(String daysInHos) {
		DaysInHos = daysInHos;
	}

	public String getDaysOutHos() {
		return DaysOutHos;
	}

	public void setDaysOutHos(String daysOutHos) {
		DaysOutHos = daysOutHos;
	}

	public String getCstCareLevel() {
		return CstCareLevel;
	}

	public void setCstCareLevel(String cstCareLevel) {
		CstCareLevel = cstCareLevel;
	}

	public static Creator<PatientBean> getCreator() {
		return CREATOR;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getDoctorName() {
		return DoctorName;
	}

	public void setDoctorName(String doctorName) {
		DoctorName = doctorName;
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

	public String getBirthday() {
		return Birthday;
	}

	public void setBirthday(String birthday) {
		Birthday = birthday;
	}

	public String getPatId() {
		return PatId;
	}

	public void setPatId(String patId) {
		PatId = patId;
	}

	public String getClinicNo() {
		return ClinicNo;
	}

	public void setClinicNo(String clinicNo) {
		ClinicNo = clinicNo;
	}

	public String getDeptCode() {
		return DeptCode;
	}

	public void setDeptCode(String deptCode) {
		DeptCode = deptCode;
	}

	public String getBedNo() {
		return BedNo;
	}

	public void setBedNo(String bedNo) {
		BedNo = bedNo;
	}

	public String getDoctorId() {
		return DoctorId;
	}

	public void setDoctorId(String doctorId) {
		DoctorId = doctorId;
	}

	public PatientDetail getPatientDetail() {
		return patientDetail;
	}

	public void setPatientDetail(PatientDetail patientDetail) {
		this.patientDetail = patientDetail;
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {

		dest.writeString(Id);
		dest.writeString(Name);
		dest.writeString(Sex);
		dest.writeString(Age);
		dest.writeString(Birthday);
		dest.writeString(PatId);
		dest.writeString(ClinicNo);
		dest.writeString(InHosDate);
		dest.writeString(OutHosDate);
		dest.writeString(DivisionCode);
		dest.writeString(DivisionName);
		dest.writeString(DeptCode);
		dest.writeString(DeptName);
		dest.writeString(BedNo);
		dest.writeString(DoctorId);
		dest.writeString(DoctorName);
		dest.writeString(CareLevel);

		dest.writeString(MedicalId);
		dest.writeString(CareName);
		dest.writeString(CureStatus);
		dest.writeString(DietName);
		dest.writeString(DietType);
		dest.writeString(PatientType);
		dest.writeString(Diagnosis);
		dest.writeString(Balance);
		dest.writeString(DrugAllergy);
		dest.writeString(CstCareLevel);
		dest.writeString(HealthyCardID);
		dest.writeValue(patientDetail);
	}

	public String getInHosDate() {
		return InHosDate;
	}

	public void setInHosDate(String inHosDate) {
		InHosDate = inHosDate;
	}

	public String getOutHosDate() {
		return OutHosDate;
	}

	public void setOutHosDate(String outHosDate) {
		OutHosDate = outHosDate;
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

	public String getMedicalId() {
		return MedicalId;
	}

	public void setMedicalId(String medicalId) {
		MedicalId = medicalId;
	}

	public String getCareName() {
		return CareName;
	}

	public void setCareName(String careName) {
		CareName = careName;
	}

	public String getCureStatus() {
		return CureStatus;
	}

	public void setCureStatus(String cureStatus) {
		CureStatus = cureStatus;
	}

	public String getDietName() {
		return DietName;
	}

	public void setDietName(String dietName) {
		DietName = dietName;
	}

	public String getDietType() {
		return DietType;
	}

	public void setDietType(String dietType) {
		DietType = dietType;
	}

	public String getPatientType() {
		return PatientType;
	}

	public void setPatientType(String patientType) {
		PatientType = patientType;
	}

	public String getDiagnosis() {
		return Diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		Diagnosis = diagnosis;
	}

	public String getBalance() {
		return Balance;
	}

	public void setBalance(String balance) {
		Balance = balance;
	}

	public String getDrugAllergy() {
		return DrugAllergy;
	}

	public void setDrugAllergy(String drugAllergy) {
		DrugAllergy = drugAllergy;
	}

	public String getDeptName() {
		return DeptName;
	}

	public void setDeptName(String deptName) {
		DeptName = deptName;
	}

	public String getHospitalStatus() {
		return PatStatus;
	}

	public void setHospitalStatus(String hospitalStatus) {
		PatStatus = hospitalStatus;
	}

	@Override
	public String toString() {
		return "PatientBean [Id=" + Id + ", Name=" + Name + ", Sex=" + Sex
				+ ", Age=" + Age + ", Birthday=" + Birthday + ", PatId="
				+ PatId + ", ClinicNo=" + ClinicNo + ", InHosDate=" + InHosDate
				+ ", OutHosDate=" + OutHosDate + ", DivisionCode="
				+ DivisionCode + ", DivisionName=" + DivisionName
				+ ", HealthyCardID=" + HealthyCardID
				+ ", DeptCode=" + DeptCode + ", DeptName=" + DeptName
				+ ", BedNo=" + BedNo + ", DoctorId=" + DoctorId
				+ ", DoctorName=" + DoctorName + ", CareLevel=" + CareLevel
				+ "]";
	}

	public static final Creator<PatientBean> CREATOR = new Creator<PatientBean>() {
		@Override
		public PatientBean[] newArray(int size) {
			return new PatientBean[size];
		}

		@Override
		public PatientBean createFromParcel(Parcel source) {
			PatientBean patientBean = new PatientBean();
			patientBean.Id = source.readString();
			patientBean.Name = source.readString();
			patientBean.Sex = source.readString();
			patientBean.Age = source.readString();
			patientBean.Birthday = source.readString();
			patientBean.PatId = source.readString();
			patientBean.ClinicNo = source.readString();
			patientBean.InHosDate = source.readString();
			patientBean.OutHosDate = source.readString();
			patientBean.DivisionCode = source.readString();
			patientBean.DivisionName = source.readString();
			patientBean.DeptName = source.readString();
			patientBean.DeptCode = source.readString();
			patientBean.BedNo = source.readString();
			patientBean.DoctorId = source.readString();
			patientBean.DoctorName = source.readString();
			patientBean.CareLevel = source.readString();

			patientBean.MedicalId = source.readString();
			patientBean.CareName = source.readString();
			patientBean.CureStatus = source.readString();
			patientBean.DietName = source.readString();
			patientBean.DietType = source.readString();
			patientBean.PatientType = source.readString();
			patientBean.Diagnosis = source.readString();
			patientBean.Balance = source.readString();
			patientBean.DrugAllergy = source.readString();
			patientBean.CstCareLevel = source.readString();
			patientBean.HealthyCardID=source.readString();
			patientBean.patientDetail = (PatientDetail) source.readValue(this
					.getClass().getClassLoader());
			return patientBean;
		}
	};

}
