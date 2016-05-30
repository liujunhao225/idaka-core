package cn.com.idaka.core.mongodb.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class District {
	
	private String id;
	private int oldId;
	private String name;
	private String pid;
	private int sort;
	private int level;
	private boolean cityFlag;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getOldId() {
		return oldId;
	}
	public void setOldId(int oldId) {
		this.oldId = oldId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public boolean isCityFlag() {
		return cityFlag;
	}
	public void setCityFlag(boolean cityFlag) {
		this.cityFlag = cityFlag;
	}
	
}
