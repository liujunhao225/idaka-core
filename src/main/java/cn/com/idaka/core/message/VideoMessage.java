package cn.com.idaka.core.message;

import cn.com.idaka.core.message.Message;

public interface VideoMessage extends Message {
	
	public String getMediaId();

	public void setMediaId(String mediaId);

	public String getMsgId();

	public void setMsgId(String msgId);
	
	public String getThumbMediaId();

	public void setThumbMediaId(String mediaId);
}
