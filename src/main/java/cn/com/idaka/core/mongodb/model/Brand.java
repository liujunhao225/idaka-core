package cn.com.idaka.core.mongodb.model;

import cn.com.idaka.core.util.Config;

public class Brand {
	
	private String id;
	private String sid;
	private String name;
	private String nameEn;
	private int status;
	
	// 描述
	private String description;
	
	// 明细
	private String detail;
	
	/** 品牌图片 */
	private String logo;
	
	/** 外系统ID */
	private String extId;
	
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
	public String getNameEn() {
		return nameEn;
	}
	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getExtId() {
		return extId;
	}
	public void setExtId(String extId) {
		this.extId = extId;
	}
	public String getLogoUrl(){
		if(logo == null)
			return null;
		return Config.HOSTIMAGE.concat(logo);
	}
}
