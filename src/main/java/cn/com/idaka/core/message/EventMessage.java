package cn.com.idaka.core.message;

import cn.com.idaka.core.message.Message;

public interface EventMessage extends Message {
//	<Event><![CDATA[EVENT]]></Event>
//	<EventKey><![CDATA[EVENTKEY]]></EventKey>
	public String getEvent();

	public void setEvent(String event);

	public String getEventKey();

	public void setEventKey(String eventKey);
	
	public String getTicket();
	
	public void setTicket(String ticket);
	

	public String getCardId();
	
	public void setCardId(String cardid);
	
	public String getFriendUserName();
	
	public void setFriendUserName(String friendusername);
	
	public Integer getIsGiveByFriend();
	
	public void setIsGiveByFriend(Integer isgivebyfriend);
	
	public String getUserCardCode();
	
	public void setUserCardCode(String usercardcode);


	
}
