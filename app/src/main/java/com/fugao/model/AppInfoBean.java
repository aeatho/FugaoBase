package com.fugao.model;

import org.codehaus.jackson.annotate.JsonProperty;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 应用程序信息
 * 
 * @author findchen TODO 2013-9-16下午3:06:50
 */
public class AppInfoBean implements Parcelable {
	@JsonProperty
	public String Id;
	/**
	 * 名称
	 */
	@JsonProperty
	public String Name;
	/**
	 * 代码
	 */
	@JsonProperty
	public String ByName;
	/**
	 * 版本号
	 */
	@JsonProperty
	public String Version;
	/**
	 * 服务器端地址
	 */
	@JsonProperty
	public String Path;
	/**
	 * 操作系统
	 */
	@JsonProperty
	public String OperateSystem;
	/**
	 * 启用科室
	 */
	@JsonProperty
	public String EnableDept;
	/**
	 * 状态
	 */
	@JsonProperty
	public String Status;
	/**
	 * 更新日志
	 */
	@JsonProperty
	public String Note;
	/**
	 * 更新时间
	 */
	@JsonProperty
	public String UpdateDate;
	/**
	 * 程序包名
	 */
	@JsonProperty
	public String packageName;

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(Id);
		dest.writeString(Name);
		dest.writeString(ByName);
		dest.writeString(Version);
		dest.writeString(Path);
		dest.writeString(OperateSystem);
		dest.writeString(EnableDept);
		dest.writeString(Status);
		dest.writeString(Note);
		dest.writeString(UpdateDate);
	}

	public static final Creator<AppInfoBean> CREATOR = new Creator<AppInfoBean>() {

		@Override
		public AppInfoBean[] newArray(int size) {
			// TODO Auto-generated method stub
			return new AppInfoBean[size];
		}

		@Override
		public AppInfoBean createFromParcel(Parcel source) {
			AppInfoBean bean = new AppInfoBean();
			bean.Id = source.readString();
			bean.Name = source.readString();
			bean.ByName = source.readString();
			bean.Version = source.readString();
			bean.Path = source.readString();
			bean.OperateSystem = source.readString();
			bean.EnableDept = source.readString();
			bean.Status = source.readString();
			bean.Note = source.readString();
			bean.UpdateDate = source.readString();
			return bean;
		}
	};
}
