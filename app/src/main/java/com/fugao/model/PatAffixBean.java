package com.fugao.model;

import org.codehaus.jackson.annotate.JsonProperty;

public class PatAffixBean {
	@JsonProperty
	private String Id;
	@JsonProperty
	private String PatId;
	/**
	 * 图片
	 */
	@JsonProperty
	private String Avatar;
	/**
	 * 时间
	 */
	@JsonProperty
	private String CreateAt;
	/**
	 * 描述
	 */
	@JsonProperty
	private String Desc;

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getPatId() {
		return PatId;
	}

	public void setPatId(String patId) {
		PatId = patId;
	}

	public String getAvatar() {
		return Avatar;
	}

	public void setAvatar(String avatar) {
		Avatar = avatar;
	}

	public String getCreateAt() {
		return CreateAt;
	}

	public void setCreateAt(String createAt) {
		CreateAt = createAt;
	}

	public String getDesc() {
		return Desc;
	}

	public void setDesc(String desc) {
		Desc = desc;
	}
}
