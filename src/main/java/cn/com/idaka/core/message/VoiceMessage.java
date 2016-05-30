package cn.com.idaka.core.message;

import cn.com.idaka.core.message.Message;

public interface VoiceMessage extends Message {

	public String getMediaId();

	public void setMediaId(String mediaId);

	public String getMsgId();

	public void setMsgId(String msgId);
	
	public String getFormat();

	public void setFormat(String format);	
	
	public String getRecognition();

	public void setRecognition(String recognition);
}
