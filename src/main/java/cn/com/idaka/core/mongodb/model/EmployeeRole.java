package cn.com.idaka.core.mongodb.model;

import java.util.List;

public class EmployeeRole {
	
	public static final int ROLE_SYSTEM = 1;
	public static final int ROLE_CUSTOM = 0;
	private String id;
	private String roleName;
	/**
	 * 0.后台添加的
	 * 1.系统初始化的默认角色，不能修改。
	 */
	private int roleType = ROLE_CUSTOM;
	private List<String> attributes;
	
	private boolean needFilterByCity; //是否需要根据城市对数据进行过滤
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public List<String> getAttributes() {
		return attributes;
	}
	public void setAttributes(List<String> attributes) {
		this.attributes = attributes;
	}
	public int getRoleType() {
		return roleType;
	}
	public void setRoleType(int roleType) {
		this.roleType = roleType;
	}
	public boolean isNeedFilterByCity() {
		return needFilterByCity;
	}
	public void setNeedFilterByCity(boolean needFilterByCity) {
		this.needFilterByCity = needFilterByCity;
	} 

}
