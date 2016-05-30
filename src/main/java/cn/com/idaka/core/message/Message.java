package cn.com.idaka.core.message;

import cn.com.idaka.core.enumeration.MessageType;

/**
 * 微信消息格式<br>
 * &lt;ToUserName>&lt;![CDATA[toUser]]>&lt;/ToUserName><br>
 * &lt;FromUserName>&lt;![CDATA[fromUser]]>&lt;/FromUserName><br>
 * &lt;CreateTime>12345678&lt;/CreateTime> <br>
 * &lt;MsgType>&lt;![CDATA[news]]>&lt;/MsgType><br>
 * 
 * @author liangping
 * 
 */
public interface Message {
	
	public String getToUserName();

	public void setToUserName(String tousername);

	public String getFromUserName();

	public void setFromUserName(String fromUserName);

	public Integer getCreateTime();

	public void setCreateTime(Integer createtime);

	public MessageType getMsgType();

	public void setMsgType(MessageType msgType);

	public String toEncryptString();

}
