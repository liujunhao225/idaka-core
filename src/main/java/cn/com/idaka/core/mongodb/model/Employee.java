package cn.com.idaka.core.mongodb.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import cn.com.idaka.core.helper.MongoHelper;
import cn.com.idaka.core.mongodb.model.store.Storage;


/**
 * The persistent class for the weixin_employee database table.
 * 
 */
@Document
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private Date createtime;

	private int fans;

	private int group;

	private String introduction;

	private String ip;

	private String lifestyle;

	private String logo;

	private int msgs;

	private String name;

	@Indexed
	private String nickname;

	private String password;

	private String role;
	
	private List<String> roleIds = new ArrayList<String>();
	private List<String> roleNames = new ArrayList<String>();

	private byte sex;

	private String showname;

	private String showtime;

	private byte status=1;

	private int visits;
	
	private List<User> users;
	
	private List<String> settings;
	
	
	private String cityId;
	private String cityName;
	
	/**所属门店(部门)*/
	private String storageId;
	
	/** 部门（新）*/
	private String departId;
	/** 部门（新）名称*/
	private String deptname;
	
	/** 钉钉工号 */
	private String jobNumber;
	/** 企业钉钉账户 DingSetting ID*/
	private String dingId;
	
	/** 员工所得票数(年会临时使用) */
	private int tempVoteNum = 0;
	private int bossVoteNum = 0;
	private boolean votedFlag;
	private int msgNum = 0;
	private int bossMsgNum = 0;
	
	
    public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public String getJobNumber() {
		return jobNumber;
	}

	public void setJobNumber(String jobNumber) {
		this.jobNumber = jobNumber;
	}

	public String getDepartId() {
		return departId;
	}

	public void setDepartId(String departId) {
		this.departId = departId;
	}

	public Employee() {
    }

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public int getFans() {
		return this.fans;
	}

	public void setFans(int fans) {
		this.fans = fans;
	}

	public int getGroup() {
		return this.group;
	}

	public void setGroup(int group) {
		this.group = group;
	}

	public String getIntroduction() {
		return this.introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getLifestyle() {
		return this.lifestyle;
	}

	public void setLifestyle(String lifestyle) {
		this.lifestyle = lifestyle;
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<String> getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(List<String> roleIds) {
		this.roleIds = roleIds;
	}

	public List<String> getRoleNames() {
		return roleNames;
	}

	public void setRoleNames(List<String> roleNames) {
		this.roleNames = roleNames;
	}

	public byte getSex() {
		return this.sex;
	}

	public void setSex(byte sex) {
		this.sex = sex;
	}

	public String getShowname() {
		return this.showname;
	}

	public void setShowname(String showname) {
		this.showname = showname;
	}

	public String getShowtime() {
		return this.showtime;
	}

	public void setShowtime(String showtime) {
		this.showtime = showtime;
	}

	public byte getStatus() {
		return this.status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public int getVisits() {
		return this.visits;
	}

	public void setVisits(int visits) {
		this.visits = visits;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
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

	public void setSettings(List<String> settings) {
		this.settings = settings;
	}

	public List<String> getSettings() {
		return settings;
	}
	
	public String getStorageId() {
		return storageId;
	}

	public void setStorageId(String storageId) {
		this.storageId = storageId;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String getDingId() {
		return dingId;
	}

	public void setDingId(String dingId) {
		this.dingId = dingId;
	}

	public int getTempVoteNum() {
		return tempVoteNum;
	}

	public void setTempVoteNum(int tempVoteNum) {
		this.tempVoteNum = tempVoteNum;
	}

	public int getBossVoteNum() {
		return bossVoteNum;
	}

	public void setBossVoteNum(int bossVoteNum) {
		this.bossVoteNum = bossVoteNum;
	}

	public boolean isVotedFlag() {
		return votedFlag;
	}

	public void setVotedFlag(boolean votedFlag) {
		this.votedFlag = votedFlag;
	}

	public int getMsgNum() {
		return msgNum;
	}

	public void setMsgNum(int msgNum) {
		this.msgNum = msgNum;
	}

	public int getBossMsgNum() {
		return bossMsgNum;
	}

	public void setBossMsgNum(int bossMsgNum) {
		this.bossMsgNum = bossMsgNum;
	}

	public Storage getStorage(){
		return MongoHelper.findById(this.storageId, Storage.class);
	}
	
	
	public String getRoleName(){
		if(role == null)
			return null;
		EmployeeRole er = MongoHelper.findById(role, EmployeeRole.class);
		if(er == null)
			return null;
		
		return er.getRoleName();
	}
	
	public boolean isSystemAdmin(){
		if(role == null)
			return false;
		EmployeeRole er = MongoHelper.findById(role, EmployeeRole.class);
		if(er == null)
			return false;
		
		return er.getRoleType() == EmployeeRole.ROLE_SYSTEM && "超级管理员".equals(er.getRoleName());
	}
	
	public String getShowName(){
		if(name.length()>2){
			return name.substring(1,3);
		}else{
			return name;
		}
	}
	
}