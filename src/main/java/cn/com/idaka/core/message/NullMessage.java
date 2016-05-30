package cn.com.idaka.core.message;

import cn.com.idaka.core.enumeration.MessageType;
import cn.com.idaka.core.message.Message;;
/**
 * 空消息体，返回空字符串,用于不向用户做任何反馈。
 * @author liangping
 */
public class NullMessage implements Message {

	@Override
	public String getToUserName() {
		return null;
	}

	@Override
	public void setToUserName(String tousername) {

	}

	@Override
	public String getFromUserName() {
		return null;
	}

	@Override
	public void setFromUserName(String fromUserName) {

	}

	@Override
	public Integer getCreateTime() {
		return null;
	}

	@Override
	public void setCreateTime(Integer createtime) {

	}

	@Override
	public MessageType getMsgType() {
		return null;
	}

	@Override
	public void setMsgType(MessageType msgType) {

	}

	@Override
	public String toString() {
		return "";
	}

	@Override
	public String toEncryptString() {
		return "";
	}
	
}
