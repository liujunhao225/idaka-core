package cn.com.idaka.core.message;

import cn.com.idaka.core.message.Message;
import cn.com.idaka.core.message.parts.Music;

public interface MusicMessage extends Message {

	public Music getMusic();

	public void setMusic(Music music);
}
