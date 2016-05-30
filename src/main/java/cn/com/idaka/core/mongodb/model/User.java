package cn.com.idaka.core.mongodb.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import cn.com.idaka.core.util.Config;
import cn.com.idaka.core.util.StringUtil;

/**
 * The persistent class for the weixin_users database table. *
 */
@Document
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private String country;
	private String province;//省份
	private String city;//城市
	private String area;//地区
	private String custom;//收件人
	private String realname;//真实姓名
	private String certid;//身份证号
	private String certimgxddress;//身份证正面图片地址
	private String certimgyddress;//身份证反面图片地址

	private int sex = 0;
	private String language;
	private Date createtime;
	private int credits;//当前积分，可用消费，扣减
	private String manager;
	private String managerName;

	/**
	 * 如果是微信认证用户，此ID为OpenID, 其它情况这里是fakeID;
	 */
	private String fakeid;
	private int group;
	private String ip;
	private String logo;
	private int msgs;
	private String phone;
	private String address;

	private String nickname;
	private String password;
	private int role;
	private String sid;
	private byte status;
	private int totalcredits;//累计积分，只会增加，不会减少
	private int visits;
	private int fromscene;
	private String fromstore;
	private String fromuser;
	private Date signindate;
	
	/** 自身购买量统计,以支付成功为核计标准 */
	private int selfOrders = 0;			//自身订单数量
	private Float selfAmount = 0.0f;	//自身订单总金额
	
	/** 提成统计，下线成交数据 */
	private int orders = 0;//订单量
	private Float revenue = 0.0f;//销售总额
	private Float commission = 0.0f;//可提成余额
	private Float withdraw = 0.0f;//累计提成
	
	// 是否曾经关注，用于区分当前用户是否是第一次关注
	private boolean isOnceSubscribe = false;
	
	// 是否曾经取消关注，用于区分当前用户是否是第一次取消关注
	private boolean onceUnSubscribe = false;
	
	// 用户二维码scene和ticket 
	private String qrScene;
	private String qrTicket;
	
	// 转发统计
	private int totalShareTimeline = 0;	//转发朋友圈合计
	private int currShareTimeline = 0;	//当前转发朋友圈次数
	private Date lastShareTime = null;	//最近转发朋友圈时间
	
	// 下线用户数量
	private int subUserCount = 0; //下线用户数量
	
	//社区论坛昵称
	private String sqname;
	private String sqlogo;

	public User() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public int getCredits() {
		return this.credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public String getFakeid() {
		return this.fakeid;
	}

	public void setFakeid(String fakeid) {
		this.fakeid = fakeid;
	}

	public int getGroup() {
		return this.group;
	}

	public void setGroup(int group) {
		this.group = group;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public int getMsgs() {
		return this.msgs;
	}

	public void setMsgs(int msgs) {
		this.msgs = msgs;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getRole() {
		return this.role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getSid() {
		return this.sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public byte getStatus() {
		return this.status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public int getTotalcredits() {
		return this.totalcredits;
	}

	public void setTotalcredits(int totalcredits) {
		this.totalcredits = totalcredits;
	}

	public int getVisits() {
		return this.visits;
	}

	public void setVisits(int visits) {
		this.visits = visits;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getFromscene() {
		return fromscene;
	}

	public void setFromscene(int fromscene) {
		this.fromscene = fromscene;
	}

	public Date getSignindate() {
		return signindate;
	}

	public void setSignindate(Date signindate) {
		this.signindate = signindate;
	}

	public int getOrders() {
		return orders;
	}

	public void setOrders(int orders) {
		this.orders = orders;
	}

	public Float getRevenue() {
		return revenue;
	}

	public void setRevenue(Float revenue) {
		this.revenue = revenue;
	}

	public Float getCommission() {
		return commission;
	}

	public void setCommission(Float commission) {
		this.commission = commission;
	}

	public Float getWithdraw() {
		return withdraw;
	}

	public void setWithdraw(Float withdraw) {
		this.withdraw = withdraw;
	}

	public String getFromstore() {
		return fromstore;
	}

	public void setFromstore(String fromstore) {
		this.fromstore = fromstore;
	}

	public String getFromuser() {
		return fromuser;
	}

	public void setFromuser(String fromuser) {
		this.fromuser = fromuser;
	}


	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isOnceSubscribe() {
		return isOnceSubscribe;
	}

	public void setOnceSubscribe(boolean isOnceSubscribe) {
		this.isOnceSubscribe = isOnceSubscribe;
	}
	
	public int getSelfOrders() {
		return selfOrders;
	}

	public void setSelfOrders(int selfOrders) {
		this.selfOrders = selfOrders;
	}

	public Float getSelfAmount() {
		return selfAmount;
	}

	public void setSelfAmount(Float selfAmount) {
		this.selfAmount = selfAmount;
	}
	
	public boolean isOnceUnSubscribe() {
		return onceUnSubscribe;
	}

	public void setOnceUnSubscribe(boolean onceUnSubscribe) {
		this.onceUnSubscribe = onceUnSubscribe;
	}


	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCustom() {
		return custom;
	}

	public void setCustom(String custom) {
		this.custom = custom;
	}

	public String getCertid() {
		return certid;
	}

	public void setCertid(String certid) {
		this.certid = certid;
	}

	public String getCertimgxddress() {
		return certimgxddress;
	}

	public void setCertimgxddress(String certimgxddress) {
		this.certimgxddress = certimgxddress;
	}

	public String getCertimgyddress() {
		return certimgyddress;
	}

	public void setCertimgyddress(String certimgyddress) {
		this.certimgyddress = certimgyddress;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getQrScene() {
		return qrScene;
	}

	public void setQrScene(String qrScene) {
		this.qrScene = qrScene;
	}

	public int getTotalShareTimeline() {
		return totalShareTimeline;
	}

	public void setTotalShareTimeline(int totalShareTimeline) {
		this.totalShareTimeline = totalShareTimeline;
	}

	public int getCurrShareTimeline() {
		return currShareTimeline;
	}

	public void setCurrShareTimeline(int currShareTimeline) {
		this.currShareTimeline = currShareTimeline;
	}

	public Date getLastShareTime() {
		return lastShareTime;
	}

	public void setLastShareTime(Date lastShareTime) {
		this.lastShareTime = lastShareTime;
	}

	public int getSubUserCount() {
		return subUserCount;
	}

	public void setSubUserCount(int subUserCount) {
		this.subUserCount = subUserCount;
	}

	public String getQrTicket() {
		return qrTicket;
	}

	public void setQrTicket(String qrTicket) {
		this.qrTicket = qrTicket;
	}
	
	public String getSqname() {
		if(sqname==null)
			return this.nickname;
		return sqname;
	}

	public void setSqname(String sqname) {
		this.sqname = sqname;
	}

	public String getSqlogo() {
		if(this.sqlogo==null)
			return this.logo;
		return Config.HOSTIMAGE.concat(this.sqlogo);
	}

	public void setSqlogo(String sqlogo) {
		this.sqlogo = sqlogo;
	}

	public String getFixedLengthName(){
		return StringUtil.fixLength(this.nickname,6);
	}
	
	
}