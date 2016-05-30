package cn.com.idaka.core.message;

import cn.com.idaka.core.message.Message;

public interface LocationMessage extends Message {

	public Float getLocation_X();

	public void setLocation_X(Float locationX);

	public Float getLocation_Y();

	public void setLocation_Y(Float LocationY);
	
	public String getLabel();

	public void setLabel(String label);

	public String getMsgId();

	public void setMsgId(String msgId);
	
	public Integer getScale();
	
	public void setScale(Integer scale);
}
