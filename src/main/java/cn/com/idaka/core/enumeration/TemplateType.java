package cn.com.idaka.core.enumeration;

public enum TemplateType {
	INDEX("index"),
	LIST("list"),
	NEWS("news");
	TemplateType(String text){
		this.id = text;
	}
	private final String id;
	public String getId(){
		return this.id;
	}
}
