package cn.com.idaka.core.message.helper;

import cn.com.idaka.core.enumeration.MessageType;
import cn.com.idaka.core.message.DefaultMessage;
import cn.com.idaka.core.message.ImageMessage;
import cn.com.idaka.core.message.LinkMessage;
import cn.com.idaka.core.message.Message;
import cn.com.idaka.core.message.MusicMessage;
import cn.com.idaka.core.message.NewsMessage;
import cn.com.idaka.core.message.TextMessage;


public class MessageFactory {
	private static void init(Message send,Message receive){
		send.setFromUserName(receive.getToUserName());
		send.setToUserName( receive.getFromUserName());
		send.setCreateTime((int) (System.currentTimeMillis() / 1000));
	}
	
	public static TextMessage createTextMessage(Message receive){
		TextMessage send = new DefaultMessage();
		send.setMsgType(MessageType.text);
		init(send, receive);
		return send;
	}
	public static NewsMessage createNewsMessage(Message receive){
		NewsMessage send = new DefaultMessage();
		send.setMsgType(MessageType.news);
		init(send, receive);
		return send;
	}
	public static MusicMessage createMusicMessage(Message receive){
		MusicMessage send = new DefaultMessage();
		send.setMsgType(MessageType.music);
		init(send, receive);
		return send;
	}
	public static LinkMessage createLinkMessage(Message receive){
		LinkMessage send = new DefaultMessage();
		send.setMsgType(MessageType.link);
		init(send, receive);
		return send;
	}
	public static ImageMessage createImageMessage(Message receive){
		ImageMessage send = new DefaultMessage();
		send.setMsgType(MessageType.image );
		init(send, receive);
		return send;
	}
}
