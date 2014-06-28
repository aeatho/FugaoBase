package com.fugao.model;
/**
 * 菜单模型
 * 
 * @author chenliang
 * @date 2012-12-10
 */
public class MenuBean {
	// 角色代码
	private String RoleId;
	// 模块
	private String App;
	// 方法
	private String Method;
	// 启用
	private String Actived;
	// ICON
	private String Icon;
	// 排序
	private String SortId;
	
	public String getRoleId() {
		return RoleId;
	}
	public void setRoleId(String roleId) {
		RoleId = roleId;
	}
	public String getApp() {
		return App;
	}
	public void setApp(String app) {
		App = app;
	}
	public String getMethod() {
		return Method;
	}
	public void setMethod(String method) {
		Method = method;
	}
	public String getActived() {
		return Actived;
	}
	public void setActived(String actived) {
		Actived = actived;
	}
	public String getIcon() {
		return Icon;
	}
	public void setIcon(String icon) {
		Icon = icon;
	}
	public String getSortId() {
		return SortId;
	}
	public void setSortId(String sortId) {
		SortId = sortId;
	}
	
	
}
