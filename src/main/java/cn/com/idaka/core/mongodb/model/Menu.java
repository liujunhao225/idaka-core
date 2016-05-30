package cn.com.idaka.core.mongodb.model;

import java.io.Serializable;

public class Menu implements Serializable, Comparable<Menu>{
	
	public static final byte TEXT 	= 1;
	public static final byte VOICE 	= 2;
	public static final byte IMAGE 	= 3;
	public static final byte NEWS 	= 4;
	public static final byte LINK 	= 5;
	public static final byte FUNCTION 	= 6;
	public static final byte SYSTEM 	= 7;

	private static final long serialVersionUID = -8355596125275490406L;
	
	private String id;
	
	private String sid;

	private byte type=1;
	
	private String title;
	
	private String content;
	
	private String parent;
	
	private int sort=99;

	public byte getType() {
		return type;
	}

	public void setType(byte type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public String getParent() {
		return parent;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	@Override
	public int compareTo(Menu o) {
		return this.sort-o.sort;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getSid() {
		return sid;
	}
	
}
