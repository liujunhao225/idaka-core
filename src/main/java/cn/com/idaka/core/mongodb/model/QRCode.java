package cn.com.idaka.core.mongodb.model;

import java.util.Date;

public class QRCode {
	
	public static final int QR_SCENE = 1;
	public static final int QR_LIMIT_SCENE = 2;
	
	public static final int ROLE_CAB 	= 1;
	public static final int ROLE_STORE	= 2;
	
	private String id;
	private String sid;
	private int sceneid;
	private String ticket;
	private int type = QR_LIMIT_SCENE;
	private int expire_seconds;
	
	/**
	 * 使用者
	 */
	private String user;
	private Date date;
	/**
	 * 绑定时间
	 */
	private Date useDate;
	private String creator;
	private int role = ROLE_CAB;
	
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
	public int getSceneid() {
		return sceneid;
	}
	public void setSceneid(int sceneid) {
		this.sceneid = sceneid;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getExpire_seconds() {
		return expire_seconds;
	}
	public void setExpire_seconds(int expire_seconds) {
		this.expire_seconds = expire_seconds;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getUseDate() {
		return useDate;
	}
	public void setUseDate(Date useDate) {
		this.useDate = useDate;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}

}
