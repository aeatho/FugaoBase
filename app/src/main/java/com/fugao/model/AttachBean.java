package com.fugao.model;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * 文件管理
 * 
 * @author chenliang
 * @date 2012-12-13
 */
public class AttachBean {
	/**
	 * 序号
	 */
	@JsonProperty
	public String Id;
	/**
	 * 文件名称
	 */
	@JsonProperty
	public String OriginalName;
	/**
	 * 文件路径
	 */
	@JsonProperty
	public String PathName;
	/**
	 * 标题
	 */
	@JsonProperty
	public String Title;
	/**
	 * 扩展名
	 */
	@JsonProperty
	public String Extension;
	/**
	 * 文件大小
	 */
	@JsonProperty
	public String Size;
	/**
	 * 对象名称
	 */
	@JsonProperty
	public String ObjectType;
	/**
	 * 对象代码,0录音,1照相,2视频
	 */
	@JsonProperty
	public String ObjectId;
	/**
	 * 创建者
	 */
	@JsonProperty
	public String CreatorId;
	/**
	 * 创建者姓名
	 */
	@JsonProperty
	public String CreatorName;
	/**
	 * 创建时间
	 */
	@JsonProperty
	public String CreatedAt;
	/**
	 * 下载次数
	 */
	@JsonProperty
	public String Downloads;
	/**
	 * 备注
	 */
	@JsonProperty
	public String Extra;
	/**
	 * 删除标记
	 */
	@JsonProperty
	public String Deleted;
	/**
	 * 便签ID
	 */
	@JsonProperty
	public String TodoId;
	/**
	 * 是否被选中
	 */
	public boolean ischecked;

	@Override
	public String toString() {
		return "AttachBean [Id=" + Id + ", OriginalName=" + OriginalName
				+ ", PathName=" + PathName + ", Title=" + Title
				+ ", Extension=" + Extension + ", Size=" + Size
				+ ", ObjectType=" + ObjectType + ", ObjectId=" + ObjectId
				+ ", CreatorId=" + CreatorId + ", CreatorName=" + CreatorName
				+ ", CreatedAt=" + CreatedAt + ", Downloads=" + Downloads
				+ ", Extra=" + Extra + ", Deleted=" + Deleted + ", TodoId="
				+ TodoId + ", ischecked=" + ischecked + "]";
	}

}
