package cn.com.idaka.core.mongodb.model;

import cn.com.idaka.core.helper.MongoHelper;
import cn.com.idaka.core.util.Constant;

public class Department {

	private String id;//部门id
	private String sid;
	private String name;//部门名称
	private int sort;//部门排序编号
	private String pid;//上级部门id
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String apartName) {
		this.name = apartName;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	
	public String getParentName(){
		Department parent = MongoHelper.findById(pid, Department.class);
		if(parent!=null){
			return parent.getName();
		}
		
		return "";
	}
	
}
