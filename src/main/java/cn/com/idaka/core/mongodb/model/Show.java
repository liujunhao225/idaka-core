package cn.com.idaka.core.mongodb.model;

import java.io.Serializable;
import java.util.Date;

public class Show implements Serializable{

	private static final long serialVersionUID = -5812135343586554127L;
	private String id;
	private String sid;
	private String name;
	private Date begin;
	private Date end;
	private int status;
	/**
	 * 周日~周六（0-6）
	 */
	private int[] repeat;
	private String hostId;
	private String host;
	private String logo;
	private String description;
	
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBegin() {
		return begin;
	}
	public void setBegin(Date begin) {
		this.begin = begin;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public int[] getRepeat() {
		return repeat;
	}
	public void setRepeat(int[] repeat) {
		this.repeat = repeat;
	}
	public String getHostId() {
		return hostId;
	}
	public void setHostId(String hostId) {
		this.hostId = hostId;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getStatus() {
		return status;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
