package com.fugao.model;

import org.codehaus.jackson.annotate.JsonProperty;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 
 * @author gelp 2013-09-24
 * 
 * 病人类型分类 
 * 增加高危分类
 * @author findchen_2013 2013-12-4
 * 
 */
public class PatientCategoryBean implements Parcelable {
	/**
	 * 住院号
	 */
	@JsonProperty
	private String PatId;
	/**
	 * 是否有手术
	 */
	@JsonProperty
	private String IsOperation;
	/**
	 * 是否药物过敏
	 */
	@JsonProperty
	private String IsAllergy;
	/**
	 * 是否病危
	 */
	@JsonProperty
	private String IsCritical;
	/**
	 * 是否高危
	 */
	@JsonProperty
	private String IsHightCritical;
	

	public String getPatId() {
		return PatId;
	}

	public void setPatId(String patId) {
		PatId = patId;
	}

	public String getIsOperation() {
		return IsOperation;
	}

	public void setIsOperation(String isOperation) {
		IsOperation = isOperation;
	}

	public String getIsAllergy() {
		return IsAllergy;
	}

	public void setIsAllergy(String isAllergy) {
		IsAllergy = isAllergy;
	}

	public String getIsCritical() {
		return IsCritical;
	}

	public void setIsCritical(String isCritical) {
		IsCritical = isCritical;
	}

	
	
	public String getIsHightCritical() {
		return IsHightCritical;
	}

	public void setIsHightCritical(String isHightCritical) {
		IsHightCritical = isHightCritical;
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int arg1) {
		dest.writeString("PatId");
		dest.writeString("IsOperation");
		dest.writeString("IsAllergy");
		dest.writeString("IsCritical");
		dest.writeString("IsHightCritical");
		

	}

	public static final Creator<PatientCategoryBean> CREATOR = new Creator<PatientCategoryBean>() {

		@Override
		public PatientCategoryBean[] newArray(int arg0) {

			return new PatientCategoryBean[arg0];
		}

		@Override
		public PatientCategoryBean createFromParcel(Parcel arg0) {
			PatientCategoryBean patientsRelatedBean = new PatientCategoryBean();
			patientsRelatedBean.PatId = arg0.readString();
			patientsRelatedBean.IsOperation = arg0.readString();
			patientsRelatedBean.IsAllergy = arg0.readString();
			patientsRelatedBean.IsCritical = arg0.readString();
			patientsRelatedBean.IsHightCritical= arg0.readString();
			
			return patientsRelatedBean;
		}
	};
}
