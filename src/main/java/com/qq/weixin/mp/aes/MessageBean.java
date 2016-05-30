package com.qq.weixin.mp.aes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class MessageBean {
	private String Appid	;			//第三方平台appid
	private String CreateTime; 	//	时间戳
	private String InfoType;		//	component_verify_ticket , unauthorized
	private String ComponentVerifyTicket;//
	private String AuthorizerAppid;
	private String Encrypt;
	
	public String getAppid() {
		return Appid;
	}
	public void setAppid(String appid) {
		Appid = appid;
	}
	public String getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(String createTime) {
		CreateTime = createTime;
	}
	public String getInfoType() {
		return InfoType;
	}
	public void setInfoType(String infoType) {
		InfoType = infoType;
	}
	public String getComponentVerifyTicket() {
		return ComponentVerifyTicket;
	}
	public void setComponentVerifyTicket(String componentVerifyTicket) {
		ComponentVerifyTicket = componentVerifyTicket;
	}
	public String getAuthorizerAppid() {
		return AuthorizerAppid;
	}
	public void setAuthorizerAppid(String authorizerAppid) {
		AuthorizerAppid = authorizerAppid;
	}
	public String getEncrypt() {
		return Encrypt;
	}
	public void setEncrypt(String encrypt) {
		Encrypt = encrypt;
	}
	@Override
	public String toString() {
		return "MessageBean [Appid=" + Appid + ", CreateTime=" + CreateTime
				+ ", InfoType=" + InfoType + ", ComponentVerifyTicket="
				+ ComponentVerifyTicket + ", AuthorizerAppid="
				+ AuthorizerAppid + ", Encrypt=" + Encrypt + "]";
	}
}
