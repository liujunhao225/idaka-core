package cn.com.idaka.core.mongodb.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import cn.com.idaka.core.enumeration.TemplateType;
import cn.com.idaka.core.util.Config;
import cn.com.idaka.core.util.Constant;


/**
 * The persistent class for the setting database table.
 * 
 */
@Document
public class Setting implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String name;  // 名称
	private String fullname; // 全名
	
	// 关注回复类型
	private byte msgtype = 1;
	// 关注回复语
	private String welcome;
	// 关注回复图文图片
	private String logo;
	
	//转发相关配置，用于商城转发时显示
	private String shareLogo; // 转发LOGO
	private String shareTitle; // 转发标题
	private String shareDesc; // 转发描述
	
	//邀请关注配置，用于邀请好友关注时显示
	private String inviteTitle;
	private String inviteDesc;
	
	
	private Date bindingtime;
	
	private int color;

	private int statsFans;

	private int statsMsg;

	private int statsWeb;

	private byte status = 1;

	private String token;

	
	private String appid;
	
	private String appsecurite;
	
	
	private Map<String,Integer> config;
	
	private List<String> jumbotrons;
	
	private Map<String,String> template;
	
	private int apiLevel = 0;
	
	private String paySignKey;
	private String tenpayPartner;
	private String tenpayPartnerKey;
	
	private String corpId;
	private String corpSecret;
	private String encodingAESKey;
	
	private String alipayEmail;
	private String alipayPartner;
	private String alipayPartnerKey;
	
	/**
	 * 推送信息
	 */
	private String pushMsg;
	
	/**
	 * 出租车推荐新增一个用户，奖励金额
	 */
	private Float reward;
	
	/**
	 * 供应商推荐新增一个用户，奖励金额
	 */
	private Float rewardSupplier;

	/**
	 * 是否开启微信打印(1开启，其他否).
	 */
	private Integer printFlag = 0;
	/**
	 * 微信打印的提示语.
	 */
	private String printMsg;
	/**
	 * 微信打印，工作人员通过密钥方式获取串码的密钥.
	 */
	private String printKey;
	/**
	 * 微信打印串码有效时间，单位秒.
	 */
	private Integer printCodeSeconds = 0;
	
	/**
	 * 微信打印远程服务器URL.
	 */
	private String printServerUrl;
	
	/**
	 * 微信打印设备编号前缀.
	 */
	private String printServerNo;

	/**
	 * 微信平台拼音首字母.
	 */
	private String simpleAreaName;
	
	/**
	 * 发送短信服务URL.
	 */
	private String sendPhoneMessageServerUrl;
	
	/** 卡券用户白名单 */
	private String cardWhiteOpenid;
	
	/** 商城模板 */
	private String pageTemplate;
	/** 商城图片素材 */
	private String img1;
	private String img2;
	private String img3;
	private String img4;
	private String img5;
	/** 图片链接地址 */
	private String link1;
	private String link2;
	private String link3;
	private String link4;
	private String link5;
	
	/** 分类导航图片 */
	private String navImg;
	
	/** 模板消息ID */
	/**邀请新用户注册成功通知*/
	private String TEMPLATE_ID_USER_REGISTER_NOTICE;
	/**领取红包通知*/
	private String TEMPLATE_ID_COMMISSION_MSG_NOTICE;
	/**订单支付成功通知*/
	private String TEMPLATE_ID_PAY_SUCCESS_NOTICE;
	/**订单支付成功给运营人员发送提醒*/
	private String TEMPLATE_ID_PAY_SUCCESS_TO_MANAGER;
	/**订单提交成功通知，发送给购买的顾客*/
	private String TEMPLATE_ID_ORDER_NEW_NOTICE_TO_BUYER;
	/**订单提交成功通知，发送给运营人员*/
	private String TEMPLATE_ID_ORDER_NEW_NOTICE_TO_MANAGER;
	/**向用户发放优惠券时，发送消息提醒*/
	private String TEMPLATE_ID_COUPON_NOTICE_TO_BUYER;
	/**订单发货时，向用户发送消息提醒*/
	private String TEMPLATE_ID_ORDER_DELIVER_NOTICE_TO_BUYER;
	/**组团成功时，向参加组团的用户发送消息提醒*/
	private String TEMPLATE_ID_GROUP_SUCC_NOTICE_TO_BUYER;
	/**礼包接收时，给礼品的赠送者发送消息提醒*/
	private String TEMPLATE_ID_GIFT_RECEIVED_NOTICE_TO_SENDER;
	/**礼包接收时，给管理员发送发货提醒*/
	private String TEMPLATE_ID_ORDER_SEND_NOTICE_TO_ADMIN;
	/**返现到帐通知*/
	private String TEMPLATE_ID_RETURN_CASH_NOTICE;
	
	
	/** 首单提成配置 */
	private int commTypeFirst;		//首单提成方式
	private int commValueFirst;		//首单提成数额或百分比
	private Float commFirstUseCond = 0.0f; //首单提成起用金额
	private int commFirstCalcType = Constant.Order.COMM_FIRST_CALC_TYPE_SINGLE; //首单提成计算方式 

	/** 默认提成方式 */
	private int commType = Constant.Order.PARTNER_COMM_TYPE_PERCENT;
	/** 默认提成金额，普通用户推销提成百分比 */
	private int ticheng = 0;
	
	/** 邀请关注提成日限额 */
	private float regCommLimit = 0.0f;
	/** 限额例外二维码清单 */
	private String excludeQrCodes;
	
	/** 是否启用多客服系统 */
	private boolean useCustomService = false;
	
	/** 城市 */
	private String cityId;
	private String cityName;

	public String getSimpleAreaName() {
		return simpleAreaName;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getAppsecurite() {
		return appsecurite;
	}

	public void setAppsecurite(String appsecurite) {
		this.appsecurite = appsecurite;
	}

	public Setting() {
		template = new HashMap<String, String>();
		template.put(TemplateType.INDEX.getId(), "1");
		template.put(TemplateType.LIST.getId(), "1");
		template.put(TemplateType.NEWS.getId(), "1");
    }

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getBindingtime() {
		return this.bindingtime;
	}

	public void setBindingtime(Date bindingtime) {
		this.bindingtime = bindingtime;
	}

	public int getColor() {
		return this.color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public String getFullname() {
		return this.fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getLogo() {
		return this.logo;
	}
	public String getLogoUrl() {
		if(this.logo!=null) {
			return Config.HOSTIMAGE.concat(this.logo);
		}else {
			return "";
		}
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public byte getMsgtype() {
		return this.msgtype;
	}

	public void setMsgtype(byte msgtype) {
		this.msgtype = msgtype;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStatsFans() {
		return this.statsFans;
	}

	public void setStatsFans(int statsFans) {
		this.statsFans = statsFans;
	}

	public int getStatsMsg() {
		return this.statsMsg;
	}

	public void setStatsMsg(int statsMsg) {
		this.statsMsg = statsMsg;
	}

	public int getStatsWeb() {
		return this.statsWeb;
	}

	public void setStatsWeb(int statsWeb) {
		this.statsWeb = statsWeb;
	}

	public byte getStatus() {
		return this.status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getWelcome() {
		return this.welcome;
	}

	public void setWelcome(String welcome) {
		this.welcome = welcome;
	}

	public void setConfig(Map<String,Integer> config) {
		this.config = config;
	}

	public Map<String,Integer> getConfig() {
		return config;
	}

	public void setJumbotrons(List<String> jumbotrons) {
		this.jumbotrons = jumbotrons;
	}

	public List<String> getJumbotrons() {
		return jumbotrons;
	}

	public void setTemplate(Map<String,String> template) {
		this.template = template;
	}

	public Map<String,String> getTemplate() {
		return template;
	}

	public int getApiLevel() {
		return apiLevel;
	}

	public void setApiLevel(int apiLevel) {
		this.apiLevel = apiLevel;
	}

	public String getPaySignKey() {
		return paySignKey;
	}

	public void setPaySignKey(String paySignKey) {
		this.paySignKey = paySignKey;
	}

	public String getTenpayPartner() {
		return tenpayPartner;
	}

	public void setTenpayPartner(String tenpayPartner) {
		this.tenpayPartner = tenpayPartner;
	}

	public String getTenpayPartnerKey() {
		return tenpayPartnerKey;
	}

	public void setTenpayPartnerKey(String tenpayPartnerKey) {
		this.tenpayPartnerKey = tenpayPartnerKey;
	}

	public String getAlipayPartner() {
		return alipayPartner;
	}

	public void setAlipayPartner(String alipayPartner) {
		this.alipayPartner = alipayPartner;
	}

	public String getAlipayPartnerKey() {
		return alipayPartnerKey;
	}

	public void setAlipayPartnerKey(String alipayPartnerKey) {
		this.alipayPartnerKey = alipayPartnerKey;
	}

	public String getAlipayEmail() {
		return alipayEmail;
	}

	public void setAlipayEmail(String alipayEmail) {
		this.alipayEmail = alipayEmail;
	}

	public String getPushMsg() {
		return pushMsg;
	}

	public void setPushMsg(String pushMsg) {
		this.pushMsg = pushMsg;
	}

    public Integer getPrintFlag() {
		return printFlag;
	}

	public void setPrintFlag(Integer printFlag) {
		this.printFlag = printFlag;
	}

	public String getPrintMsg() {
		return printMsg;
	}

	public void setPrintMsg(String printMsg) {
		this.printMsg = printMsg;
	}
	
	public String getPrintKey() {
		return printKey;
	}

	public void setPrintKey(String printKey) {
		this.printKey = printKey;
	}

	public Integer getPrintCodeSeconds() {
		return printCodeSeconds;
	}

	public void setPrintCodeSeconds(Integer printCodeSeconds) {
		this.printCodeSeconds = printCodeSeconds;
	}
	
	public String getPrintServerUrl() {
		return printServerUrl;
	}

	public void setPrintServerUrl(String printServerUrl) {
		this.printServerUrl = printServerUrl;
	}

	public String getPrintServerNo() {
		return printServerNo;
	}

	public void setPrintServerNo(String printServerNo) {
		this.printServerNo = printServerNo;
	}

	public Float getReward() {
		return reward;
	}

	public void setReward(Float reward) {
		this.reward = reward;
	}
	
	public Float getRewardSupplier() {
		return rewardSupplier;
	}

	public void setRewardSupplier(Float rewardSupplier) {
		this.rewardSupplier = rewardSupplier;
	}
	
	public void setSimpleAreaName(String simpleAreaName) {
		this.simpleAreaName = simpleAreaName;
	}
	
	public String getSendPhoneMessageServerUrl() {
		return sendPhoneMessageServerUrl;
	}

	public void setSendPhoneMessageServerUrl(String sendPhoneMessageServerUrl) {
		this.sendPhoneMessageServerUrl = sendPhoneMessageServerUrl;
	}
	public List<Level> getMemberLevels() {
		return memberLevels;
	}

	public void setMemberLevels(List<Level> memberLevels) {
		this.memberLevels = memberLevels;
	}
	private List<Level> memberLevels = new ArrayList<Setting.Level>();
	
	public class Level{
		private int value;
		private String title;
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
	}

	public int getTicheng() {
		return ticheng;
	}

	public void setTicheng(int ticheng) {
		this.ticheng = ticheng;
	}

	public int getCommType() {
		return commType;
	}

	public void setCommType(int commType) {
		this.commType = commType;
	}

	public String getCorpId() {
		return corpId;
	}

	public void setCorpId(String corpId) {
		this.corpId = corpId;
	}

	public String getCorpSecret() {
		return corpSecret;
	}

	public void setCorpSecret(String corpSecret) {
		this.corpSecret = corpSecret;
	}

	public String getEncodingAESKey() {
		return encodingAESKey;
	}

	public void setEncodingAESKey(String encodingAESKey) {
		this.encodingAESKey = encodingAESKey;
	}

	public String getCardWhiteOpenid() {
		return cardWhiteOpenid;
	}

	public void setCardWhiteOpenid(String cardWhiteOpenid) {
		this.cardWhiteOpenid = cardWhiteOpenid;
	}

	public String getPageTemplate() {
		return pageTemplate;
	}

	public void setPageTemplate(String pageTemplate) {
		this.pageTemplate = pageTemplate;
	}

	public String getShareLogo() {
		return shareLogo;
	}

	public void setShareLogo(String shareLogo) {
		this.shareLogo = shareLogo;
	}
	
	public String getShareLogoUrl(){
		if(shareLogo == null)
			return null;
		return Config.HOSTIMAGE.concat(shareLogo);
	}

	public String getShareTitle() {
		return shareTitle;
	}

	public void setShareTitle(String shareTitle) {
		this.shareTitle = shareTitle;
	}

	public String getShareDesc() {
		return shareDesc;
	}

	public void setShareDesc(String shareDesc) {
		this.shareDesc = shareDesc;
	}

	public String getTEMPLATE_ID_USER_REGISTER_NOTICE() {
		return TEMPLATE_ID_USER_REGISTER_NOTICE;
	}

	public void setTEMPLATE_ID_USER_REGISTER_NOTICE(
			String tEMPLATE_ID_USER_REGISTER_NOTICE) {
		TEMPLATE_ID_USER_REGISTER_NOTICE = tEMPLATE_ID_USER_REGISTER_NOTICE;
	}

	public String getTEMPLATE_ID_COMMISSION_MSG_NOTICE() {
		return TEMPLATE_ID_COMMISSION_MSG_NOTICE;
	}

	public void setTEMPLATE_ID_COMMISSION_MSG_NOTICE(
			String tEMPLATE_ID_COMMISSION_MSG_NOTICE) {
		TEMPLATE_ID_COMMISSION_MSG_NOTICE = tEMPLATE_ID_COMMISSION_MSG_NOTICE;
	}

	public String getTEMPLATE_ID_PAY_SUCCESS_NOTICE() {
		return TEMPLATE_ID_PAY_SUCCESS_NOTICE;
	}

	public void setTEMPLATE_ID_PAY_SUCCESS_NOTICE(
			String tEMPLATE_ID_PAY_SUCCESS_NOTICE) {
		TEMPLATE_ID_PAY_SUCCESS_NOTICE = tEMPLATE_ID_PAY_SUCCESS_NOTICE;
	}

	public String getTEMPLATE_ID_PAY_SUCCESS_TO_MANAGER() {
		return TEMPLATE_ID_PAY_SUCCESS_TO_MANAGER;
	}

	public void setTEMPLATE_ID_PAY_SUCCESS_TO_MANAGER(
			String tEMPLATE_ID_PAY_SUCCESS_TO_MANAGER) {
		TEMPLATE_ID_PAY_SUCCESS_TO_MANAGER = tEMPLATE_ID_PAY_SUCCESS_TO_MANAGER;
	}

	public String getTEMPLATE_ID_ORDER_NEW_NOTICE_TO_BUYER() {
		return TEMPLATE_ID_ORDER_NEW_NOTICE_TO_BUYER;
	}

	public void setTEMPLATE_ID_ORDER_NEW_NOTICE_TO_BUYER(
			String tEMPLATE_ID_ORDER_NEW_NOTICE_TO_BUYER) {
		TEMPLATE_ID_ORDER_NEW_NOTICE_TO_BUYER = tEMPLATE_ID_ORDER_NEW_NOTICE_TO_BUYER;
	}

	public String getTEMPLATE_ID_ORDER_NEW_NOTICE_TO_MANAGER() {
		return TEMPLATE_ID_ORDER_NEW_NOTICE_TO_MANAGER;
	}

	public void setTEMPLATE_ID_ORDER_NEW_NOTICE_TO_MANAGER(
			String tEMPLATE_ID_ORDER_NEW_NOTICE_TO_MANAGER) {
		TEMPLATE_ID_ORDER_NEW_NOTICE_TO_MANAGER = tEMPLATE_ID_ORDER_NEW_NOTICE_TO_MANAGER;
	}

	public String getTEMPLATE_ID_COUPON_NOTICE_TO_BUYER() {
		return TEMPLATE_ID_COUPON_NOTICE_TO_BUYER;
	}

	public void setTEMPLATE_ID_COUPON_NOTICE_TO_BUYER(
			String tEMPLATE_ID_COUPON_NOTICE_TO_BUYER) {
		TEMPLATE_ID_COUPON_NOTICE_TO_BUYER = tEMPLATE_ID_COUPON_NOTICE_TO_BUYER;
	}

	public String getTEMPLATE_ID_ORDER_DELIVER_NOTICE_TO_BUYER() {
		return TEMPLATE_ID_ORDER_DELIVER_NOTICE_TO_BUYER;
	}

	public void setTEMPLATE_ID_ORDER_DELIVER_NOTICE_TO_BUYER(
			String tEMPLATE_ID_ORDER_DELIVER_NOTICE_TO_BUYER) {
		TEMPLATE_ID_ORDER_DELIVER_NOTICE_TO_BUYER = tEMPLATE_ID_ORDER_DELIVER_NOTICE_TO_BUYER;
	}

	
	public String getTEMPLATE_ID_GROUP_SUCC_NOTICE_TO_BUYER() {
		return TEMPLATE_ID_GROUP_SUCC_NOTICE_TO_BUYER;
	}

	public void setTEMPLATE_ID_GROUP_SUCC_NOTICE_TO_BUYER(
			String tEMPLATE_ID_GROUP_SUCC_NOTICE_TO_BUYER) {
		TEMPLATE_ID_GROUP_SUCC_NOTICE_TO_BUYER = tEMPLATE_ID_GROUP_SUCC_NOTICE_TO_BUYER;
	}

	public String getTEMPLATE_ID_GIFT_RECEIVED_NOTICE_TO_SENDER() {
		return TEMPLATE_ID_GIFT_RECEIVED_NOTICE_TO_SENDER;
	}

	public void setTEMPLATE_ID_GIFT_RECEIVED_NOTICE_TO_SENDER(
			String tEMPLATE_ID_GIFT_RECEIVED_NOTICE_TO_SENDER) {
		TEMPLATE_ID_GIFT_RECEIVED_NOTICE_TO_SENDER = tEMPLATE_ID_GIFT_RECEIVED_NOTICE_TO_SENDER;
	}

	public String getTEMPLATE_ID_ORDER_SEND_NOTICE_TO_ADMIN() {
		return TEMPLATE_ID_ORDER_SEND_NOTICE_TO_ADMIN;
	}

	public void setTEMPLATE_ID_ORDER_SEND_NOTICE_TO_ADMIN(
			String tEMPLATE_ID_ORDER_SEND_NOTICE_TO_ADMIN) {
		TEMPLATE_ID_ORDER_SEND_NOTICE_TO_ADMIN = tEMPLATE_ID_ORDER_SEND_NOTICE_TO_ADMIN;
	}

	public String getTEMPLATE_ID_RETURN_CASH_NOTICE() {
		return TEMPLATE_ID_RETURN_CASH_NOTICE;
	}

	public void setTEMPLATE_ID_RETURN_CASH_NOTICE(
			String tEMPLATE_ID_RETURN_CASH_NOTICE) {
		TEMPLATE_ID_RETURN_CASH_NOTICE = tEMPLATE_ID_RETURN_CASH_NOTICE;
	}

	public String getInviteTitle() {
		return inviteTitle;
	}

	public void setInviteTitle(String inviteTitle) {
		this.inviteTitle = inviteTitle;
	}

	public String getInviteDesc() {
		return inviteDesc;
	}

	public void setInviteDesc(String inviteDesc) {
		this.inviteDesc = inviteDesc;
	}

	public String getNavImg() {
		return navImg;
	}

	public void setNavImg(String navImg) {
		this.navImg = navImg;
	}

	public int getCommTypeFirst() {
		return commTypeFirst;
	}

	public void setCommTypeFirst(int commTypeFirst) {
		this.commTypeFirst = commTypeFirst;
	}

	public int getCommValueFirst() {
		return commValueFirst;
	}

	public void setCommValueFirst(int commValueFirst) {
		this.commValueFirst = commValueFirst;
	}

	public int getCommFirstCalcType() {
		return commFirstCalcType;
	}

	public void setCommFirstCalcType(int commFirstCalcType) {
		this.commFirstCalcType = commFirstCalcType;
	}

	public Float getCommFirstUseCond() {
		return commFirstUseCond;
	}

	public void setCommFirstUseCond(Float commFirstUseCond) {
		this.commFirstUseCond = commFirstUseCond;
	}

	public float getRegCommLimit() {
		return regCommLimit;
	}

	public void setRegCommLimit(float regCommLimit) {
		this.regCommLimit = regCommLimit;
	}

	public boolean isUseCustomService() {
		return useCustomService;
	}

	public void setUseCustomService(boolean useCustomService) {
		this.useCustomService = useCustomService;
	}

	public String getExcludeQrCodes() {
		return excludeQrCodes;
	}

	public void setExcludeQrCodes(String excludeQrCodes) {
		this.excludeQrCodes = excludeQrCodes;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getLink1() {
		return link1;
	}

	public void setLink1(String link1) {
		this.link1 = link1;
	}

	public String getLink2() {
		return link2;
	}

	public void setLink2(String link2) {
		this.link2 = link2;
	}

	public String getLink3() {
		return link3;
	}

	public void setLink3(String link3) {
		this.link3 = link3;
	}

	public String getLink4() {
		return link4;
	}

	public void setLink4(String link4) {
		this.link4 = link4;
	}

	public String getLink5() {
		return link5;
	}

	public void setLink5(String link5) {
		this.link5 = link5;
	}

	public String getImg1() {
		return img1;
	}

	public void setImg1(String img1) {
		this.img1 = img1;
	}

	public String getImg2() {
		return img2;
	}

	public void setImg2(String img2) {
		this.img2 = img2;
	}

	public String getImg3() {
		return img3;
	}

	public void setImg3(String img3) {
		this.img3 = img3;
	}

	public String getImg4() {
		return img4;
	}

	public void setImg4(String img4) {
		this.img4 = img4;
	}

	public String getImg5() {
		return img5;
	}

	public void setImg5(String img5) {
		this.img5 = img5;
	}
	
	public String getNavImgUrl(){
		if(navImg == null)
			return null;
		return Config.HOSTIMAGE.concat(navImg);
	}
	
	public String getImg1Url(){
		if(img1 == null)
			return null;
		return Config.HOSTIMAGE.concat(img1);
	}
	public String getImg2Url(){
		if(img2 == null)
			return null;
		return Config.HOSTIMAGE.concat(img2);
	}
	public String getImg3Url(){
		if(img3 == null)
			return null;
		return Config.HOSTIMAGE.concat(img3);
	}
	public String getImg4Url(){
		if(img4 == null)
			return null;
		return Config.HOSTIMAGE.concat(img4);
	}
	public String getImg5Url(){
		if(img5 == null)
			return null;
		return Config.HOSTIMAGE.concat(img5);
	}
	
	public List<String> getImgUrlList(){
		List<String> ret = new ArrayList<String>();
		
		if(img1 != null)
			ret.add(Config.HOSTIMAGE.concat(img1));
		if(img2 != null)
			ret.add(Config.HOSTIMAGE.concat(img2));
		if(img3 != null)
			ret.add(Config.HOSTIMAGE.concat(img3));
		if(img4 != null)
			ret.add(Config.HOSTIMAGE.concat(img4));
		if(img5 != null)
			ret.add(Config.HOSTIMAGE.concat(img5));
		
		return ret;
	}
	public List<String> getImgLinkList(){
		List<String> ret = new ArrayList<String>();
		if(link1!=null)
			ret.add(link1);
		if(link2!=null)
			ret.add(link2);
		if(link3!=null)
			ret.add(link3);
		if(link4!=null)
			ret.add(link4);
		if(link5!=null)
			ret.add(link5);
		
		return ret;
	}
	
}