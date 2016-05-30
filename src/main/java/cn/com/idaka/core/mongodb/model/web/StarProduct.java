package cn.com.idaka.core.mongodb.model.web;

import cn.com.idaka.core.util.Config;

public class StarProduct {

	private String id;
	
	/** 产品名称*/
	private String name;
	/** 产品简介*/
	private String introduce;
	/** 产品图片 */
	private String logo;
	/** 产品链接*/
	private String link;
	/** 产品排序*/
	private int sort;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public String getLogoUrl(){
		return Config.HOSTIMAGE+this.logo;
	}
}
