package cn.com.idaka.core.mongodb.model.store;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.com.idaka.core.util.Config;
import cn.com.idaka.core.util.Constant;

public class Storage {
	
	private String id;
	private String sid;
	private Date createtime;
	private boolean majorStorage;

	/** 供应商ID */
	private String supplierId;
	
	/** 仓库类型 */
	private int type = Constant.Store.STORE_TYPE_REPOSITORY;
	/** 仓库编号 */
	private String no;
	/** 仓库名称 */
	private String name;
	/** 仓库地址 */
	private String address;
	/** 经度*/
	private String longitude;
	/** 纬度*/
	private String latitude;
	/** 门店电话*/
	private String telephone;
	/** 排序*/
	private int sort = 1;
	
	
	/** 企业号部门ID */
	private String deptId;
	
	private int status = Constant.ACTIVE;
	
	/** 企业Enterprise id name */
	private String enterpriseId;
	private String enterpriseName;
	
	/** 提成信息 */
	/** 提成方式 */
	private int commType;
	/** 提成额度，实际数额或者百分比，如：5表示5% */
	private int commValue;
	/** 交易额 */
	private Float revenue = 0.0f;
	/** 总提成 */
	private Float commission = 0.0f;
	/** 可提现 */
	private Float withdraw = 0.0f;
	
	
	/** 是否需要身份认证信息 */
	private boolean needCertInfo = false;
	
	/** 订单限额,0表示没有限额 */
	private float orderAmountLimit = 0.0f;
	
	
	/** 原系统ID */
	private String extId;
	/** 发货信息描述 */
	private String desc;
	
	/** 是否在订单页面显示仓库发货信息 */
	private boolean showDescOnPage = false;
	
	/** 所在省份*/
	private String region;
	/** 所在城市*/
	private String city;
	
	/** 是否关联订单库存扣减*/
	private boolean orderLink = false;
	
	/** 所关联的pos机*/
	private List<String> pos = new ArrayList<String>();
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public int getCommType() {
		return commType;
	}
	public void setCommType(int commType) {
		this.commType = commType;
	}
	public int getCommValue() {
		return commValue;
	}
	public void setCommValue(int commValue) {
		this.commValue = commValue;
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
	public boolean isMajorStorage() {
		return majorStorage;
	}
	public void setMajorStorage(boolean majorStorage) {
		this.majorStorage = majorStorage;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public boolean isNeedCertInfo() {
		return needCertInfo;
	}
	public void setNeedCertInfo(boolean needCertInfo) {
		this.needCertInfo = needCertInfo;
	}
	public float getOrderAmountLimit() {
		return orderAmountLimit;
	}
	public void setOrderAmountLimit(float orderAmountLimit) {
		this.orderAmountLimit = orderAmountLimit;
	}
	public String getExtId() {
		return extId;
	}
	public void setExtId(String extId) {
		this.extId = extId;
	}
	public boolean isShowDescOnPage() {
		return showDescOnPage;
	}
	public void setShowDescOnPage(boolean showDescOnPage) {
		this.showDescOnPage = showDescOnPage;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getTypeName(){
		return Config.STORE_TYPE.get(type);
	}
	
	public boolean isOrderLink() {
		return orderLink;
	}
	public void setOrderLink(boolean orderLink) {
		this.orderLink = orderLink;
	}
	public String getEnterpriseId() {
		return enterpriseId;
	}
	public void setEnterpriseId(String enterpriseId) {
		this.enterpriseId = enterpriseId;
	}
	public String getEnterpriseName() {
		return enterpriseName;
	}
	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}
	public List<String> getPos() {
		return pos;
	}
	public void setPos(List<String> pos) {
		this.pos = pos;
	}
}
