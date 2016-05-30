package cn.com.idaka.core.mongodb.model.web;

public class WebUser {

	private String id;
	
	/** 昵称 */
	private String nickname;
	/** 密码 */
	private String password;
	/** 性别 */
	private String sex;
	/** 真实姓名 */
	private String realName;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
}
