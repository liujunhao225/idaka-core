package cn.com.idaka.core.mongodb.model;

import java.util.Date;

public class Picture {

	private String id;
	private String sid;
	private String url;
	private String userid;
	private String username;
	private Date date;
	private int like = 0;
	private int status =1 ;
	/**
	 * 打印串码.
	 */
	private String printcode;
	/**
	 * 是否已打印（0否，1是）.
	 */
	private int printed = 0;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getLike() {
		return like;
	}
	public void setLike(int like) {
		this.like = like;
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
	public String getPrintcode() {
		return printcode;
	}
	public void setPrintcode(String printcode) {
		this.printcode = printcode;
	}
	public int getPrinted() {
		return printed;
	}
	public void setPrinted(int printed) {
		this.printed = printed;
	}
}
