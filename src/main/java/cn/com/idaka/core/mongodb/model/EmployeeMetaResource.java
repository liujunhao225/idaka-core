package cn.com.idaka.core.mongodb.model;

import org.springframework.security.access.ConfigAttribute;

public class EmployeeMetaResource implements ConfigAttribute{
	
	private static final long serialVersionUID = 2595412823567910373L;
	private String id;
	/**
	 * 功能地址
	 */
	private String attribute;
	/**
	 * 菜单名称
	 */
	private String group;
	/**
	 * 功能名称
	 */
	private String name;
	
	/** 顺序号 */
	private int sort;
	
	/** sid */
	private String sid;
	
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String getAttribute() {
		return this.attribute;
	}
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}

}
