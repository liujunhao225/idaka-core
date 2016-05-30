package cn.com.idaka.core.enumeration;

public enum SharedType {
	
	DEFAULT(0),
	USER(1),
	user(1),
	STORE(2),
	store(2);
	
	SharedType(Integer id){
		this.id = id;
	}
	
	private final Integer id;
	
	public Integer getId(){
		return this.id;
	}
}
