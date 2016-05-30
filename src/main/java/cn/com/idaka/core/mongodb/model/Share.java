package cn.com.idaka.core.mongodb.model;

import java.util.Date;

/**
 * 用户分享记录类
 * mayibo
 */
public class Share {
	
	private String id;
	
	private String sid;
	
	//分享者的openid
	private String openid;
	
	//分享名称，如homepage、luckround等
	private String shareName;
	
	//分享类型，分享到朋友圈，或发送给朋友
	private String shareType;
	
	//分享时间
	private Date shareTime;

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

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getShareName() {
		return shareName;
	}

	public void setShareName(String shareName) {
		this.shareName = shareName;
	}

	public String getShareType() {
		return shareType;
	}

	public void setShareType(String shareType) {
		this.shareType = shareType;
	}

	public Date getShareTime() {
		return shareTime;
	}

	public void setShareTime(Date shareTime) {
		this.shareTime = shareTime;
	}
	
}
