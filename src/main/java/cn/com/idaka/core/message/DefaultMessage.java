package cn.com.idaka.core.message;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.idaka.core.enumeration.MessageType;
import cn.com.idaka.core.message.parts.Music;
import cn.com.idaka.core.message.parts.News;

@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class DefaultMessage implements TextMessage, ImageMessage,LinkMessage,
		LocationMessage, EventMessage, VoiceMessage, MusicMessage, NewsMessage, VideoMessage {
	
	private static Logger logger = LoggerFactory.getLogger( DefaultMessage.class );

	/**
	 * 消息密文体
	 */
	@XmlElement 
	private String Encrypt;
	
	// text message
	@XmlElement
	private String Content;
	@XmlElement
	private Integer CreateTime;
	@XmlElement
	private String Description;
	// event message
	@XmlElement
	private String Event;
	@XmlElement
	private String EventKey;
	@XmlElement
	private String FromUserName;
	@XmlElement
	private String Label;
	// location message
	@XmlElement
	private Float Location_X;
	@XmlElement
	private Float Location_Y;
	@XmlElement
	private String MsgId;
	@XmlElement
	private MessageType MsgType = MessageType.text ;
	@XmlElement
	private String PicUrl;
	@XmlElement
	private Integer Scale ;
	// link message
	@XmlElement
	private String Title;
	// common
	@XmlElement
	private String ToUserName;
	@XmlElement
	private String Url;
	@XmlElement
	private String MediaId;
	@XmlElement
	private String format;
	@XmlElement
	private String Recognition;
	//card message
	@XmlElement
	private String CardId;
	@XmlElement
	private String FriendUserName;
	@XmlElement
	private Integer IsGiveByFriend;
	@XmlElement
	private String UserCardCode;

	@XmlElement 
	private String Ticket;
	
	@XmlElement 
	private String ThumbMediaId;
	
	private Integer articleCount;
	private List<News> articles;
	private Music music;
	
	@Override
	public String getToUserName() {
		return this.ToUserName;
	}

	@Override
	public void setToUserName(String tousername) {
		this.ToUserName = tousername;
	}

	@Override
	public String getFromUserName() {
		return this.FromUserName;
	}

	@Override
	public void setFromUserName(String fromUserName) {
		this.FromUserName = fromUserName;
	}

	@Override
	public Integer getCreateTime() {
		return this.CreateTime;
	}

	@Override
	public void setCreateTime(Integer createtime) {
		this.CreateTime = createtime;
	}

	@Override
	public MessageType getMsgType() {
		return this.MsgType;
	}

	@Override
	public void setMsgType(MessageType msgType) {
		this.MsgType = msgType;
	}

	@Override
	public String getEvent() {
		return this.Event;
	}

	@Override
	public void setEvent(String event) {
		this.Event = event;
	}

	@Override
	public String getEventKey() {
		return this.EventKey;
	}

	@Override
	public void setEventKey(String eventKey) {
		this.EventKey = eventKey;
	}

	@Override
	public Float getLocation_X() {
		return this.Location_X;
	}

	@Override
	public void setLocation_X(Float locationX) {
		this.Location_X = locationX;
	}

	@Override
	public Float getLocation_Y() {
		return this.Location_Y;
	}

	@Override
	public void setLocation_Y(Float locationY) {
		this.Location_Y = locationY;
	}

	@Override
	public String getLabel() {
		return this.Label;
	}

	@Override
	public void setLabel(String label) {
		this.Label = label;
	}

	@Override
	public Integer getScale() {
		return this.Scale;
	}

	@Override
	public void setScale(Integer scale) {
		this.Scale = scale;
	}

	@Override
	public String getPicUrl() {
		return this.PicUrl;
	}

	@Override
	public void setPicUrl(String picUrl) {
		this.PicUrl = picUrl;
	}

	@Override
	public String getContent() {
		return this.Content;
	}

	@Override
	public void setContent(String content) {
		this.Content = content;
	}

	@Override
	public String getMsgId() {
		return this.MsgId;
	}

	@Override
	public void setMsgId(String msgId) {
		this.MsgId = msgId;
	}


	@Override
	public String getMediaId() {
		return this.MediaId;
	}

	@Override
	public void setMediaId(String MediaId) {
		this.MediaId = MediaId;
	}

	@Override
	public String getFormat() {
		return this.format;
	}

	@Override
	public void setFormat(String format) {
		this.format = format;		
	}

	@Override
	public String getRecognition() {
		return this.Recognition;
	}

	@Override
	public void setRecognition(String Recognition) {
		this.Recognition = Recognition;
	}

	@Override
	public Integer getArticleCount() {
		return this.articleCount;
	}

	@Override
	public void setArticleCount(Integer articleCount) {
		this.articleCount	 = articleCount;	
	}

	@Override
	public List<News> getArticles() {
		return this.articles;
	}

	@Override
	public void setArticles(List<News> articles) {
		this.articles = articles; 
	}

	@Override
	public Music getMusic() {
		return this.music;
	}

	@Override
	public void setMusic(Music music) {
		this.music = music;
	}
	
	
	@Override
	public String toEncryptString() {
		return null;
		/*try {
			WXBizMsgCrypt crypt = new WXBizMsgCrypt( Config.component_token , Config.component_aeskey, Config.component_appid );
			String miwen = crypt.encryptMsg( this.toString(), "", String.valueOf(new Random().nextInt(10000)));
			return miwen;
		}catch(AesException e) {
			logger.error( "加密错误：".concat(e.getMessage() ) );
			return "";
		}*/
	}
	
	@Override
	public String toString() {
		StringBuffer xml = new StringBuffer();
		xml.append("<xml>");
		xml.append("<FromUserName>").append(this.FromUserName)
				.append("</FromUserName>");
		xml.append("<ToUserName>").append(this.ToUserName)
				.append("</ToUserName>");
		xml.append("<MsgType>").append(this.MsgType).append("</MsgType>");
		xml.append("<CreateTime>").append(this.CreateTime)
				.append("</CreateTime>");

		if (this.Encrypt != null)
			xml.append("<Encrypt>").append(this.Encrypt)	.append("</Encrypt>");
		if (this.MsgId != null)
			xml.append("<MsgId>").append(this.MsgId).append("</MsgId>");

		switch (this.MsgType) {		
		case text:// text
				xml.append("<Content><![CDATA[").append(this.Content).append("]]></Content>");
			break;
		case image: // image
				xml.append("<PicUrl>").append(this.PicUrl).append("</PicUrl>");
			break;
		case location:
			// location
				xml.append("<Location_X>").append(this.Location_X)	.append("</Location_X>");
				xml.append("<Location_Y>").append(this.Location_Y)	.append("</Location_Y>");
				xml.append("<Scale>").append(this.Scale).append("</Scale>");
				xml.append("<Label>").append(this.Label).append("</Label>");
			break;
		case link:// link
				xml.append("<Title>").append(this.Title).append("</Title>");
				xml.append("<Url>").append(this.Url).append("</Url>");
				xml.append("<Description>").append(this.Description).append("</Description>");
			break;
		case event:// event
				xml.append("<Event>").append(this.Event).append("</Event>");
				xml.append("<EventKey>").append(this.EventKey).append("</EventKey>");
				if(this.Ticket!=null ) xml.append("<Ticket>").append(this.Ticket).append("</Ticket>");
				xml.append("<FuncFlag>0</FuncFlag>");
				if(CardId != null)
					xml.append("<CardId>").append(CardId).append("</CardId>");
				if(UserCardCode != null)
					xml.append("<UserCardCode>").append(UserCardCode).append("</UserCardCode>");
			break;
		case voice:
			xml.append("<MediaId>").append(this.MediaId).append("</MediaId>");
			xml.append("<Format>").append(this.format).append("</Format>");
			xml.append("<Recognition>").append(this.Recognition).append("</Recognition>");
			if (this.MsgId != null)
				xml.append("<MsgId>").append(this.MsgId).append("</MsgId>");
			break;
		case video:
			xml.append("<MediaId>").append(this.MediaId).append("</MediaId>");
			xml.append("<ThumbMediaId>").append(this.ThumbMediaId).append("</ThumbMediaId>");
			if (this.MsgId != null)
				xml.append("<MsgId>").append(this.MsgId).append("</MsgId>");
			break;
		case music:
			xml.append("<Music>");
			if(this.music!=null){
				xml.append("<Title><![CDATA[").append(this.music.getTitle()).append("]]></Title>");
				xml.append("<MusicUrl><![CDATA[").append(this.music.getMusicUrl()).append("]]></MusicUrl>");
				xml.append("<HQMusicUrl><![CDATA[").append(this.music.gethQMusicUrl()).append("]]></HQMusicUrl>");
				xml.append("<Description><![CDATA[").append(this.music.getDescription()).append("]]></Description>");
			}
			xml.append("</Music>");
			break;
		case news:		
			xml.append("<ArticleCount>").append(this.articles.size()).append("</ArticleCount>");
			xml.append("<Articles>");
			for (News news : this.articles) {
				xml.append("<item>");
				xml.append("<Title>").append(news.getTitle()).append("</Title>");
				if(news.getPicUrl()!=null) xml.append("<PicUrl><![CDATA[").append(news.getPicUrl()).append("]]></PicUrl>");
				xml.append("<Url><![CDATA[").append( news.getUrl()==null?"":news.getUrl() ).append("]]></Url>");
				xml.append("<Description>").append(news.getDescription()).append("</Description>");
				xml.append("</item>");
			}
			xml.append("</Articles>");
			xml.append("<FuncFlag>1</FuncFlag>");
			}
			return xml.append("</xml>").toString();
	}

	@Override
	public String getTicket() {
		return this.Ticket;
	}

	@Override
	public void setTicket(String ticket) {
		this.Ticket = ticket;
	}

	@Override
	public String getUrl() {
		return this.Url;
	}

	@Override
	public void setUrl(String url) {
		this.Url = url;
	}

	@Override
	public String getTitle() {
		return this.Title;
	}

	@Override
	public void setTitle(String title) {
		this.Title = title;
	}

	@Override
	public String getDescription() {
		return this.Description;
	}

	@Override
	public void setDescription(String description) {
		this.Description = description;
	}

	@Override
	public String getThumbMediaId() {
		return this.ThumbMediaId;
	}

	@Override
	public void setThumbMediaId(String mediaId) {
		this.ThumbMediaId = mediaId;		
	}

	@Override
	public String getCardId() {
		return this.CardId;
	}

	@Override
	public void setCardId(String cardid) {
		this.CardId = cardid;
	}

	@Override
	public String getFriendUserName() {
		return this.FriendUserName;
	}

	@Override
	public void setFriendUserName(String friendusername) {
		this.FriendUserName = friendusername;
	}

	@Override
	public Integer getIsGiveByFriend() {
		return this.IsGiveByFriend;
	}

	@Override
	public void setIsGiveByFriend(Integer isgivebyfriend) {
		this.IsGiveByFriend = isgivebyfriend;
	}

	@Override
	public String getUserCardCode() {
		return this.UserCardCode;
	}

	@Override
	public void setUserCardCode(String usercardcode) {
		this.UserCardCode = usercardcode;
	}

	public String getEncrypt() {
		return Encrypt;
	}

	public void setEncrypt(String encrypt) {
		Encrypt = encrypt;
	}


}
