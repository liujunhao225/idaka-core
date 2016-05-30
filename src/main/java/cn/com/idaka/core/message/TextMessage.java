package cn.com.idaka.core.message;

import cn.com.idaka.core.message.Message;

public interface TextMessage extends Message {

	public String getContent();

	public void setContent(String content);

	public String getMsgId();

	public void setMsgId(String msgId);
	
}
