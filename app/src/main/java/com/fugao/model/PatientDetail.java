/**   
 * Copyright © 2014 上海复高计算机科技有限公司. All rights reserved.
 * 
 * @Title: PatientDetail.java 
 * @Prject: FugaoNurse
 * @Package: com.fugao.nurse.model 
 * @Description: TODO
 * @author: 葛立平  geliping@fugao.com
 * @date: 2014年3月1日 下午2:48:51 
 * @version: V1.0   
 */
package com.fugao.model;

import org.codehaus.jackson.annotate.JsonProperty;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 病人详请
 * 
 * @ClassName: PatientDetail
 * @Description: TODO
 * @author: 葛立平 geliping@fugao.com
 * @date: 2014年3月1日 下午2:48:51
 */
public class PatientDetail implements Parcelable {
	/**
	 * 病人ID
	 */
	@JsonProperty
	public String PatId;
	/**
	 * 过敏
	 */
	@JsonProperty
	public String AllergyValue;
	/**
	 * 诊断
	 */
	@JsonProperty
	public String Diagnosis;
	/**
	 * 责任医生
	 */
	@JsonProperty
	public String Doctors;
	/**
	 * 联系电话
	 */
	@JsonProperty
	public String Phone;
	/**
	 * 联系地址
	 */
	@JsonProperty
	public String Address;
	/**
	 * 总金额
	 */
	@JsonProperty
	public String TotalAmount;
	/**
	 * 预付款
	 */
	@JsonProperty
	public String Advance;
	/**
	 * 可用金额
	 */
	@JsonProperty
	public String AmountAvailable;
	/**
	 * 责任护士
	 */
	@JsonProperty
	public String Nurse;

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(PatId);
		dest.writeString(AllergyValue);
		dest.writeString(Diagnosis);
		dest.writeString(Doctors);
		dest.writeString(Phone);
		dest.writeString(Address);
		dest.writeString(TotalAmount);
		dest.writeString(Advance);
		dest.writeString(AmountAvailable);
		dest.writeString(Nurse);
	}

	public static final Creator<PatientDetail> CREATOR = new Creator<PatientDetail>() {

		@Override
		public PatientDetail[] newArray(int size) {
			return new PatientDetail[size];
		}

		@Override
		public PatientDetail createFromParcel(Parcel source) {
			PatientDetail patientDetail = new PatientDetail();
			patientDetail.PatId = source.readString();
			patientDetail.AllergyValue = source.readString();
			patientDetail.Diagnosis = source.readString();
			patientDetail.Doctors = source.readString();
			patientDetail.Phone = source.readString();
			patientDetail.Address = source.readString();
			patientDetail.TotalAmount = source.readString();
			patientDetail.Advance = source.readString();
			patientDetail.AmountAvailable = source.readString();
			patientDetail.Nurse = source.readString();
			return patientDetail;
		}
	};

}
