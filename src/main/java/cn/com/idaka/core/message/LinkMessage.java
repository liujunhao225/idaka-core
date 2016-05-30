package cn.com.idaka.core.message;

import cn.com.idaka.core.message.Message;


public interface LinkMessage extends Message{
	
	public String getUrl();
	public void setUrl(String url);
	public String getTitle() ;
	public void setTitle(String title);
	public String getDescription() ;
	public void setDescription(String description) ;
	public String getMsgId();
	public void setMsgId(String msgId);
}
