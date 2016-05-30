package cn.com.idaka.core.mongodb.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;

import org.springframework.beans.BeanUtils;
import org.springframework.data.mongodb.core.mapping.Document;

import cn.com.idaka.core.message.DefaultMessage;


/**
 * The persistent class for the weixin_raw_post database table.
 * 
 */
@Document
public class MessageLogs extends DefaultMessage implements Serializable {

	private static final long serialVersionUID = 9202245791674722967L;
	
	public MessageLogs() {
		super();
	}	
	public MessageLogs(DefaultMessage message) {
		BeanUtils.copyProperties(message, this);
	}

	@Id
	private String id;
	
	private String sid;
	
	private Date date;

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

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDate() {
		return date;
	}


}