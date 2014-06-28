package com.fugao.model;

import java.util.ArrayList;

import org.codehaus.jackson.annotate.JsonProperty;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 部门/病区 模型
 * 
 * @author chenliang
 * @date 2012-12-19
 */
public class DepartmentBean implements Parcelable {
	// 父类的ID
	@JsonProperty
	public String Parent;
	// 部门的序号
	@JsonProperty
	public String Id;
	// 名称
	@JsonProperty
	public String Name;
	// 子部门
	@JsonProperty
	public ArrayList<DepartmentBean> ChildDepts;




	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(Parent);
		dest.writeString(Id);
		dest.writeString(Name);
		dest.writeList(ChildDepts);
	}

	public static final Creator<DepartmentBean> CREATOR = new Creator<DepartmentBean>() {

		@Override
		public DepartmentBean createFromParcel(Parcel source) {
			DepartmentBean departmentBean = new DepartmentBean();
			departmentBean.Parent = source.readString();
			departmentBean.Id = source.readString();
			departmentBean.Name = source.readString();
			departmentBean.ChildDepts=source.readArrayList(this.getClass().getClassLoader());
			return departmentBean;
		}

		@Override
		public DepartmentBean[] newArray(int size) {
			// TODO Auto-generated method stub
			return new DepartmentBean[size];
		}

	};
}
