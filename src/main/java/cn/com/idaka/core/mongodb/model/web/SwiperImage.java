package cn.com.idaka.core.mongodb.model.web;

import cn.com.idaka.core.util.Config;


public class SwiperImage {

	private String id;
	/** 图片路径 */
	private String image;
	/** 链接 */
	private String link;
	/** 排序 */
	private int sort;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
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
	public String getImageUrl(){
		return Config.HOSTIMAGE+this.image;
	}
}
