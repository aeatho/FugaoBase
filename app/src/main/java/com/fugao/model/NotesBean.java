package com.fugao.model;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * 任务模型
 * 
 * @author chenliang
 * @date 2012-12-10
 */
public class NotesBean {
	/**
	 * 序号
	 */
	@JsonProperty
	public String Id;
	/**
	 * 对象类型
	 */
	@JsonProperty
	public String ObjectType;
	/**
	 * 对象代码
	 */
	@JsonProperty
	public String ObjectId;
	/**
	 * 对象名称
	 */
	@JsonProperty
	public String ObjectName;
	/**
	 * 创建日期
	 */
	@JsonProperty
	public String CreatedAt;
	/**
	 * 创建者
	 */
	@JsonProperty
	public String CreatorId;
	/**
	 * 开始日期
	 */
	@JsonProperty
	public String BeginDate;
	/**
	 * 开始时间
	 */
	@JsonProperty
	public String Begin;
	/**
	 * 结束时间
	 */
	@JsonProperty
	public String End;
	/**
	 * 类型
	 */
	@JsonProperty
	public String Type;
	/**
	 * 标题
	 */
	@JsonProperty
	public String Title;
	/**
	 * 描述
	 */
	@JsonProperty
	public String Desc;
	/**
	 * 状态
	 */
	@JsonProperty
	public String Status;
	/**
	 * 私有
	 */
	@JsonProperty
	public String Private;
	/**
	 * 文件集合
	 */
	public List<AttachBean> Attachs;
	/**
	 * 解决 checkbox 和lisview 的冲突
	 */
	public boolean isChecked = false;

	@Override
	public String toString() {
		return "NotesBean [Id=" + Id + ", ObjectType=" + ObjectType
				+ ", ObjectId=" + ObjectId + ", CreatedAt=" + CreatedAt
				+ ", CreatorId=" + CreatorId + ", BeginDate=" + BeginDate
				+ ", Begin=" + Begin + ", End=" + End + ", Type=" + Type
				+ ", Title=" + Title + ", Desc=" + Desc + ", Status=" + Status
				+ ", Private=" + Private + ", Attachs=" + Attachs
				+ ", isChecked=" + isChecked + "]";
	}

}
