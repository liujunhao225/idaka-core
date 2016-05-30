package cn.com.idaka.core.mongodb.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.com.idaka.core.message.parts.Room;
import cn.com.idaka.core.util.Config;

public class Feedback implements Serializable{

	private static final long serialVersionUID = -4525805764820374826L;
	
	public static final int TEXT 	= 1;
	public static final int MUSIC 	= 2;
	public static final int NEWS 	= 3;
	public static final int LOCATION= 4;
	
	private String id;
	private String title;
	private Integer sort;
	private String sid;
	private String keyword1;
	private String keyword2;
	private String content;	
	private byte status = 1;
	private int type = 1;
	private String op;
	private Date lastUpdate;
	
	private String summary;
	private String catelog;
	private String catelogName;

	/**
	 * 经纬度, 索引0经度，索引1纬度.
	 */
	private Double[] loc = new Double[2];

	private String musicUrl;
	private String hQMusicUrl;
	
	private String pic;
	
	private int viewed = 0;
	
	private String supplierid;
	private Integer advance;
	private List<Room> rooms;
	private String address;
	private String contact;
	private String phone;
	/**
	 * 外部对接系统的ID
	 */
	private String fid;
	/**
	 * 返现
	 */
	private int cash;
	private Integer payment;
	
	private String linkUrl;
	
	/** 标签 */
	private List<String> tags = new ArrayList<String>();
	
	
	public Integer getPayment() {
		return payment;
	}

	public void setPayment(Integer payment) {
		this.payment = payment;
	}

	public int getCash() {
		return cash;
	}

	public void setCash(int cash) {
		this.cash = cash;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}
	
	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public byte getStatus() {
		return status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getKeyword1() {
		return keyword1;
	}

	public void setKeyword1(String keyword1) {
		this.keyword1 = keyword1;
	}

	public String getKeyword2() {
		return keyword2;
	}

	public void setKeyword2(String keyword2) {
		this.keyword2 = keyword2;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getPic() {
		return pic;
	}
	
	public String getLogoUrl() {
		return new StringBuffer(Config.HOSTIMAGE ).append(this.pic).toString();
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getMusicUrl() {
		return musicUrl;
	}

	public void setMusicUrl(String musicUrl) {
		this.musicUrl = musicUrl;
	}

	public String gethQMusicUrl() {
		return hQMusicUrl;
	}

	public void sethQMusicUrl(String hQMusicUrl) {
		this.hQMusicUrl = hQMusicUrl;
	}

	public void setLoc(Double[] loc) {
		this.loc = loc;
	}

	public Double[] getLoc() {
		return loc;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getCatelog() {
		return catelog;
	}

	public void setCatelog(String catelog) {
		this.catelog = catelog;
	}

	public String getCatelogName() {
		return catelogName;
	}

	public void setCatelogName(String catelogName) {
		this.catelogName = catelogName;
	}
	
	public void setViewed(int viewed) {
		this.viewed = viewed;
	}

	public int getViewed() {
		return viewed;
	}

	public Integer getAdvance() {
		return advance;
	}

	public void setAdvance(Integer advance) {
		this.advance = advance;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSupplierid() {
		return supplierid;
	}



	public void setSupplierid(String supplierid) {
		this.supplierid = supplierid;
	}

	public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

	public String getLinkUrl() {
		return linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	
	

}
