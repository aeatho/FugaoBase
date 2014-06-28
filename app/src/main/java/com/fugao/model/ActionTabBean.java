package com.fugao.model;

import java.util.ArrayList;

public class ActionTabBean {
	private ArrayList<MenuBean> Menus;
	private String Id;
	private String Name;
	private String Actived;
	private String SortId;

	public ArrayList<MenuBean> getMenus() {
		return Menus;
	}

	public void setMenus(ArrayList<MenuBean> menus) {
		Menus = menus;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getActived() {
		return Actived;
	}

	public void setActived(String actived) {
		Actived = actived;
	}

	public String getSortId() {
		return SortId;
	}

	public void setSortId(String sortId) {
		SortId = sortId;
	}

}
