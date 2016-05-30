package cn.com.idaka.core.mongodb.model.web;

public class TopMenu {

	private String id;
	/**菜单名称*/
	private String name;
	/**菜单链接*/
	private String link;
	/**菜单排序号*/
	private int sort;
	
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
	
}
