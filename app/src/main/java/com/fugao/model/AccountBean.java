package com.fugao.model;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * 账户基类
 * 
 * @author findchen TODO 2013-8-7下午4:53:37
 */
// TODO 部分字段未对应
public class AccountBean {
	/**
	 * 类型
	 */
	public String RoleIds;
	/**
	 * 序号
	 */
	@JsonProperty
	public String Id;
	/**
	 * 科室代码
	 */
	@JsonProperty
	public String DeptCode;
	// 性别
	@JsonProperty
	private String Gender;
	// 出生日期
	@JsonProperty
	private String Birthday;
	/**
	 * 姓名
	 */
	@JsonProperty
	public String FullName;
	/**
	 * 工号
	 */
	@JsonProperty
	public String UserName;


	// 手机号码
	private String PhoneNumber;
	// 创建日期
	private String CreatedAt;
	/**
	 * 当前服务器的时间，用来判断本地时间和服务器端时间的差异性
	 */
	@JsonProperty
	public String NowDateTime;
	/**
	 * 最新系统的信息
	 */
	@JsonProperty
	public AppInfoBean AppInfo;

}
