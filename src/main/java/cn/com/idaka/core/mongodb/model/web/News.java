package cn.com.idaka.core.mongodb.model.web;

import java.util.Date;

import cn.com.idaka.core.util.Config;

public class News {//动态新闻

	private String id;
	
	/** 新闻标题 */
	private String name;
	/** 新闻图片 */
	private String logo;
	/** 新闻链接 */
	private String link;
	/**发布新闻时间*/
	private Date  date;
	/** 文章提要**/
	private String summary;
	/** 文章正文**/
	private String text;
	/** 新闻标签（分类）**/
	private String type;
	/** 阅读量**/
	private int readNO;
	
	
	public String getDisplayType(){
		if(this.type==null)
			return null;
		
		return Config.NEWS_TYPE.get(this.type).toString();
	}
	
	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public int getReadNO() {
		return readNO;
	}



	public void setReadNO(int readNO) {
		this.readNO = readNO;
	}



	public String getSummary() {
		return summary;
	}



	public void setSummary(String summary) {
		this.summary = summary;
	}



	public String getText() {
		return text;
	}



	public void setText(String text) {
		this.text = text;
	}



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



	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getLogoUrl(){
		return Config.HOSTIMAGE+this.logo;
	}
	
}
