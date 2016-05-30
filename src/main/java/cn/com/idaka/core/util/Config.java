package cn.com.idaka.core.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.idaka.core.message.parts.News;
import cn.com.idaka.core.mongodb.model.Brand;
import cn.com.idaka.core.mongodb.model.User;

public final class Config {
	
	private static Logger logger = LoggerFactory.getLogger(Config.class);
	
	private static Properties cachedProps = new Properties();
	
	public static int TOTAL_ACCOUNTS = 50;
	public static final int PAGESIZE= 20;
	public static final int PAGESIZE50=50;
	
	/**
	 * 微信分页大小
	 */
	public static final int WEIXIN_PAGESIZE= 10;

	public static final String PASSWORD_SALT_VALUE = "liangping";
	
	/** 微信平台登陆用户 */
	public static final String ACCESS_WEIXIN_USER = "ACCESS_WEIXIN_USER";
	/** 当前微信账号 */
	public static final String ACCESS_CURRENT_ACCOUNT = "ACCESS_CURRENT_ACCOUNT";
	/** 商户平台登陆用户 */
	public static final String ACCESS_CUSTOM_ID = "ACCESS_CUSTOM_ID";
	public static final String ACCESS_CUSTOM_OBJECT = "ACCESS_CUSTOM_OBJECT";
	
	
	public static final String WEIXIN_USER_FROM = "WEIXIN_USER_FROM";
	
	
	public static final int SHOW_MAX_LOAD_SIZE_= 200;
	public static String uploadDir = "F:\\projects\\guangbo\\WebContent\\uploadfile";
	public static String HOSTNAME = "";
	public static String HOSTIMAGE = "";
	public static String HOSTWEIXIN = "";
	public static String WEIXIN_NOTIFY_URL = "http://www.idaka.com.cn/weixin/pay/notify/api";
	public static String PAGEDIR = "";
	/**静态文件目录**/
	public static String STATIC_DIR = "";
	/**模板目录**/
	public static String TEMPLATE_DIR = "";

	public static Map<Integer,String> PAGE_DATATYPE = new HashMap<Integer, String>();
	public static Map<Integer,Object> PAGE_DATACLASS = new HashMap<Integer, Object>();
	
	public static String IMAGE_PREFIX = "/guangbo/uploadfile/";
	
	public static Map<Integer,String> WEEKS = null;
	
	public static String[] COLORNAME = {"teal", "green",  "bricky", "purple", "white"};
	
	public static Map<Integer,String> MODEL_STATUS = new HashMap<Integer, String>();
	public static Map<Integer,String> BOOLEAN_STATUS = new HashMap<Integer, String>();
	
	public static Map<String,String> MENU_FUNCTION = new HashMap<String, String>();
	public static Map<String,String> MENU_SYSTEM = new HashMap<String, String>();
	
	public static Map<Integer,String> ORDER_TYPE = new HashMap<Integer, String>();
	public static Map<Integer,String> ORDER_STATUS = new HashMap<Integer, String>();
	public static Map<Integer,String> ORDER_OPTERATION=new HashMap<Integer,String>();
	public static Map<String,String> ORDER_RECEIVING_TYPE = new HashMap<String, String>(); 
	public static Map<Integer,String> ORDER_DELIVER_STATUS = new HashMap<Integer, String>(); 
	
	public static Map<String,String> GIFT_STATUS = new HashMap<String, String>();
	public static Map<Integer,String> GIFT_DELIVER_STATUS = new HashMap<Integer, String>();
	
	public static Map<Integer,String> PROMOTION_TYPE = new HashMap<Integer, String>();
	public static Map<Integer,String> PROMOTION_MODE = new HashMap<Integer, String>();
	
	public static Map<Integer,String> FREEBUY_RETURN_TYPE = new HashMap<Integer, String>();
	
	public static Map<Integer,String> COUPON_TYPE = new HashMap<Integer, String>();
	public static Map<Integer,String> COUPON_CATELOG = new HashMap<Integer, String>();
	public static Map<Integer,String> COUPON_DELIVERY = new HashMap<Integer, String>();
	public static Map<Integer,String> COUPON_TICKET_STATUS = new HashMap<Integer, String>();
	public static Map<Integer,String> COUPON_CARD_STATUS = new HashMap<Integer, String>();
	public static Map<Integer,String> IAPRIZE_TYPE = new HashMap<Integer, String>();
	
	public static Map<Integer,String> LUCKY_ROUND_TYPE = new HashMap<Integer, String>();
	
	public static Map<Integer,String> STORE_TYPE = new HashMap<Integer, String>();
	public static Map<Integer,String> STORE_INOUT_TYPE = new HashMap<Integer, String>();
	
	public static Map<Integer,String> PARTNER_TYPE = new HashMap<Integer, String>();
	public static Map<Integer,String> PARTNER_STAGE = new HashMap<Integer, String>();
	
	public static Map<Integer,String> COMMISSION_TYPE = new HashMap<Integer, String>();
	public static Map<Integer,String> COMMISSTION_STATUS = new HashMap<Integer, String>();
	
	public static Map<Integer,String> WITHDRAW_APPLY_STATUS = new HashMap<Integer, String>();
	
	public static Map<Integer,String> MERCHANT_TYPE = new HashMap<Integer, String>();
	
	public static Map<String,String> ISTORE_TEMPLATE_TYPE = new HashMap<String, String>();
	
	public static Map<Integer,String> YAO_DEVICE_STATUS = new HashMap<Integer, String>();
	public static Map<Integer,String> YAO_ACTIVITY_TYPE = new LinkedHashMap<Integer, String>();
	
	
	public static Map<Integer,String> YYYGIFT_TYPE = new HashMap<Integer, String>();
	public static Map<Integer,String> YYYREDPACK_TYPE = new HashMap<Integer, String>();
	public static Map<Integer,String> YYYVOTE_METHOD = new HashMap<Integer, String>();
	
	public static Map<Integer,String> CATELOG_TYPE = new HashMap<Integer, String>();
	
	public static Map<String,String> SHEQU_ITEM_TAGS = new HashMap<String, String>();
	
	/**新闻标签*/
	public static Map<String,String> NEWS_TYPE = new HashMap<String, String>();
	/**调库状态*/
	public static Map<Integer,String> STORAGE_TRANSFER_STATUS=new HashMap<Integer,String>();
	
	
	/**任务状态*/
	public static Map<Integer,String> TASK_STATUS = new HashMap<Integer,String>();
	
	/**邀请新用户注册成功通知*/
	public static String TEMPLATE_ID_USER_REGISTER_NOTICE = "";
	/**领取红包通知*/
	public static String TEMPLATE_ID_COMMISSION_MSG_NOTICE = "";
	/**订单支付成功通知*/
	public static String TEMPLATE_ID_PAY_SUCCESS_NOTICE = "";
	/**新订单通知*/
	public static String TEMPLATE_ID_ORDER_NEW_NOTICE_TO_MANAGER = "";
	/**订单提交成功通知，发送给购买的顾客*/
	public static String TEMPLATE_ID_ORDER_NEW_NOTICE_TO_BUYER = "";
	/**向用户发放优惠券时，发送消息提醒*/
	public static String TEMPLATE_ID_COUPON_NOTICE_TO_BUYER = "";
	/**订单发货时，向用户发送消息提醒*/
	public static String TEMPLATE_ID_ORDER_DELIVER_NOTICE_TO_BUYER = "";
	
	/** 商户号支付相关参数 */
	public static String TENPAY_PARTNER_CERT_PATH = "";
	public static String TENPAY_PARTNER_CERT_KEY = "";
	
	static {
		WEEKS = new HashMap<Integer, String>(7);
		WEEKS.put(0, "周日");
		WEEKS.put(1, "周一");
		WEEKS.put(2, "周二");
		WEEKS.put(3, "周三");
		WEEKS.put(4, "周四");
		WEEKS.put(5, "周五");
		WEEKS.put(6, "周六");
		
		MODEL_STATUS.put(Constant.ACTIVE, "启用");
		MODEL_STATUS.put(Constant.INACTIVE, "禁用");
		
		BOOLEAN_STATUS.put(Constant.TRUE, "是");
		BOOLEAN_STATUS.put(Constant.FALSE, "否");
		
		ORDER_TYPE.put(Constant.Order.TYPE_NORMAL, "普通订单");
		ORDER_TYPE.put(Constant.Order.TYPE_GIFT, "送礼订单");
		
		ORDER_STATUS.put(Constant.Order.STATUS_TO_PAY, "待付款");
		ORDER_STATUS.put(Constant.Order.STATUS_TO_DELIVER, "待发货");
		ORDER_STATUS.put(Constant.Order.STATUS_TO_RECEIVE, "待收货");
		ORDER_STATUS.put(Constant.Order.STATUS_FINISHED, "已完成");
		ORDER_STATUS.put(Constant.Order.STATUS_CANCELED, "已取消");
		ORDER_STATUS.put(Constant.Order.STATUS_WITHDRAW, "已撤销");
		ORDER_STATUS.put(Constant.Order.STATUS_DELETE, "已删除");
		
		ORDER_OPTERATION.put(Constant.Order.STATUS_TO_PAY, "支付");//100
		ORDER_OPTERATION.put(Constant.Order.STATUS_TO_DELIVER, "提醒发货");//200
		ORDER_OPTERATION.put(Constant.Order.STATUS_TO_RECEIVE, "确认收货");//300
		ORDER_OPTERATION.put(Constant.Order.STATUS_FINISHED, "删除");//400
		ORDER_OPTERATION.put(Constant.Order.STATUS_CANCELED, "删除");//1000
		
		GIFT_STATUS.put(Constant.Gift.NEW, "待支付");
		GIFT_STATUS.put(Constant.Gift.PAYED, "待赠出");
		GIFT_STATUS.put(Constant.Gift.SENDED, "待接收");
		GIFT_STATUS.put(Constant.Gift.ACCEPTED, "已接收");
		GIFT_STATUS.put(Constant.Gift.FORWARD, "已转赠");
		GIFT_STATUS.put(Constant.Gift.RENEW, "待转赠");
		
		GIFT_DELIVER_STATUS.put(Constant.Gift.GIFT_EXPRESS_TO_DELIVER, "待发货");
		GIFT_DELIVER_STATUS.put(Constant.Gift.GIFT_EXPRESS_TO_RECEIVE, "待收货");
		GIFT_DELIVER_STATUS.put(Constant.Gift.GIFT_EXPRESS_RECEIVED, "已收货");
		GIFT_DELIVER_STATUS.put(Constant.Gift.GIFT_EXPRESS_FINISHED, "已完成");
		
		ORDER_RECEIVING_TYPE.put(Constant.Order.RECEIVING_TYPE_STORE, "门店提货");
		ORDER_RECEIVING_TYPE.put(Constant.Order.RECEIVING_TYPE_EXPRESS, "邮寄上门");
		ORDER_RECEIVING_TYPE.put(Constant.Order.RECEIVING_TYPE_SENDHOME, "送货上门");
		
		ORDER_DELIVER_STATUS.put(Constant.Order.DELIVER_STATUS_UNSEND, "未发货");
		ORDER_DELIVER_STATUS.put(Constant.Order.DELIVER_STATUS_SENDED, "已发货");
		
		PAGE_DATATYPE.put(Constant.Page.NEWS, 				"文章资讯");
		PAGE_DATATYPE.put(Constant.Page.PARTNER, 		"分销商");
		PAGE_DATATYPE.put(Constant.Page.PRODUCT, 		"商品");
		PAGE_DATATYPE.put(Constant.Page.PROMOTION, 	"促销");
		PAGE_DATATYPE.put(Constant.Page.USER, 				"客户");
		PAGE_DATATYPE.put(Constant.Page.CATALOG, 		"分类");
		PAGE_DATATYPE.put(Constant.Page.BRAND, 		"品牌");
		PAGE_DATATYPE.put(Constant.Page.SUM_USER, 		"注册总用户数");

		PAGE_DATACLASS.put(Constant.Page.NEWS, 				new News() );
		PAGE_DATACLASS.put(Constant.Page.USER, 				new User() );
		PAGE_DATACLASS.put(Constant.Page.BRAND, 			new Brand() );
		
		MENU_FUNCTION.put("1", "微首页");
		MENU_FUNCTION.put("3", "幸运大转盘");
		MENU_FUNCTION.put("4", "微相册");
		MENU_FUNCTION.put("5", "会员首页");
		MENU_FUNCTION.put("6", "投票列表");
		MENU_FUNCTION.put("7", "竞猜游戏");
		MENU_FUNCTION.put("8", "签到");
		MENU_FUNCTION.put("9", "刮刮乐");
		
		MENU_SYSTEM.put("scancode_push", "扫码推事件");
		MENU_SYSTEM.put("scancode_waitmsg", "扫码推事件且弹出“消息接收中”提示框");
		MENU_SYSTEM.put("pic_sysphoto", "弹出系统拍照发图");
		MENU_SYSTEM.put("pic_photo_or_album", "弹出拍照或者相册发图");
		MENU_SYSTEM.put("pic_weixin", "弹出微信相册发图器");
		MENU_SYSTEM.put("location_select", "弹出地理位置选择器");
		
		PROMOTION_TYPE.put(Constant.Promotion.PRO_TYPE_USING_CREDIT, "积分抵现金");
		PROMOTION_TYPE.put(Constant.Promotion.PRO_TYPE_COUPON, "送优惠券");
		PROMOTION_TYPE.put(Constant.Promotion.PRO_TYPE_DISCOUNT, "折扣");
		PROMOTION_TYPE.put(Constant.Promotion.PRO_TYPE_FREE_SHIP, "减免运费");
		PROMOTION_TYPE.put(Constant.Promotion.PRO_TYPE_LESSCASH, "减现金");
		PROMOTION_TYPE.put(Constant.Promotion.PRO_TYPE_LIMIT, "限时特价");
		PROMOTION_TYPE.put(Constant.Promotion.PRO_TYPE_SEND_CREDIT, "购物送积分");
		PROMOTION_TYPE.put(Constant.Promotion.PRO_TYPE_FRIENDS_BARGAIN, "邀请好友砍价");
		PROMOTION_TYPE.put(Constant.Promotion.PRO_TYPE_YAOYYAO, "摇一摇促销");
		PROMOTION_TYPE.put(Constant.Promotion.PRO_TYPE_MANYPEOPLEGROUP, "三人成团");
		PROMOTION_TYPE.put(Constant.Promotion.PRO_TYPE_FREEBUY, "0元购返现");
		
		PROMOTION_MODE.put(Constant.Promotion.CACULATED_BY_ORDER_AMOUNT, "按订单金额促销");
		PROMOTION_MODE.put(Constant.Promotion.CACULATED_BY_ORDER_QUANTITY, "按订单商品数量促销");
		
		FREEBUY_RETURN_TYPE.put(Constant.Promotion.FREEBUY_RETURN_TYPE_BY_WEEK, "按周返还");
		FREEBUY_RETURN_TYPE.put(Constant.Promotion.FREEBUY_RETURN_TYPE_BY_MONTH, "按月返还");
		
		COUPON_TYPE.put(Constant.Coupon.COUPON_TYPE_LESSCASH, "现金券");
		COUPON_TYPE.put(Constant.Coupon.COUPON_TYPE_DISCOUNT, "折扣券");
		
		COUPON_CATELOG.put(Constant.Coupon.COUPON_CATELOG_PLATFORM, "平台优惠券");
		COUPON_CATELOG.put(Constant.Coupon.COUPON_CATELOG_SUPPLIER, "供应商优惠券");
		COUPON_CATELOG.put(Constant.Coupon.COUPON_CATELOG_MERCHANT, "商户优惠券");
		
		COUPON_DELIVERY.put(Constant.Coupon.DELIVERY_TYPE_MANUAL, "手工派发");
		COUPON_DELIVERY.put(Constant.Coupon.DELIVERY_TYPE_PROMOTION, "促销派发");
		COUPON_DELIVERY.put(Constant.Coupon.DELIVERY_TYPE_REGISTER, "新用户注册");
		COUPON_DELIVERY.put(Constant.Coupon.DELIVERY_TYPE_INTERACTIVE, "互动活动");
		COUPON_DELIVERY.put(Constant.Coupon.DELIVERY_TYPE_PARTNER, "分销商派发");
		COUPON_DELIVERY.put(Constant.Coupon.DELIVERY_TYPE_SCAN, "扫码关注");
		COUPON_DELIVERY.put(Constant.Coupon.DELIVERY_TYPE_REDEXCHANGE, "红包兑换");
		COUPON_DELIVERY.put(Constant.Coupon.DELIVERY_TYPE_PRINT, "纸质印刷");
		
		COUPON_TICKET_STATUS.put(Constant.Coupon.TICKET_STATUS_NEW, "新生成");
		COUPON_TICKET_STATUS.put(Constant.Coupon.TICKET_STATUS_ACTIVE, "已激活");
		COUPON_TICKET_STATUS.put(Constant.Coupon.TICKET_STATUS_SEND, "待激活");
		COUPON_TICKET_STATUS.put(Constant.Coupon.TICKET_STATUS_USED, "已使用");
		
		COUPON_CARD_STATUS.put(Constant.Coupon.COUPON_CARD_STATUS_UNCREATED, "未生成");
		COUPON_CARD_STATUS.put(Constant.Coupon.COUPON_CARD_STATUS_CHECKING, "审核中");
		COUPON_CARD_STATUS.put(Constant.Coupon.COUPON_CARD_STATUS_FAILED, "审核失败");
		COUPON_CARD_STATUS.put(Constant.Coupon.COUPON_CARD_STATUS_NORMAL, "使用中");
		COUPON_CARD_STATUS.put(Constant.Coupon.COUPON_CARD_STATUS_OVERDUE, "已停用");
		
		
		IAPRIZE_TYPE.put(Constant.LuckyRound.PRIZE_TYPE_TEXT, "文本描述");
		IAPRIZE_TYPE.put(Constant.LuckyRound.PRIZE_TYPE_COUPON, "系统优惠券");
		
		LUCKY_ROUND_TYPE.put(Constant.LuckyRound.TYPE_GGL, "刮刮乐");
		LUCKY_ROUND_TYPE.put(Constant.LuckyRound.TYPE_DZP, "大转盘");
		
		STORE_TYPE.put(Constant.Store.STORE_TYPE_REPOSITORY, "仓库");
		STORE_TYPE.put(Constant.Store.STORE_TYPE_STORE, "门店");
		STORE_TYPE.put(Constant.Store.STORE_TYPE_SALEPOINT, "销售点 ");
		
		STORE_INOUT_TYPE.put(Constant.Store.STORAGE_ORDER_TYPE_IN, "入库");
		STORE_INOUT_TYPE.put(Constant.Store.STORAGE_ORDER_TYPE_OUT, "出库");
		
		PARTNER_TYPE.put(Constant.Partner.TYPE_PERSON, "个人分销商");
		PARTNER_STAGE.put(Constant.Partner.STAGE_ONE, "一级");
		PARTNER_STAGE.put(Constant.Partner.STAGE_TWO, "二级");
		
		COMMISSION_TYPE.put(Constant.Cash.COMMISSION_TYPE_REGISTER, "新用户关注");
		COMMISSION_TYPE.put(Constant.Cash.COMMISSION_TYPE_UNREGISTER, "取消关注");
		COMMISSION_TYPE.put(Constant.Cash.COMMISSION_TYPE_ORDER_COMMISSION, "订单提成");
		COMMISSION_TYPE.put(Constant.Cash.COMMISSION_TYPE_REDBUYCOUPON, "红包兑换优惠券");
		
		COMMISSTION_STATUS.put(Constant.Cash.COMMISSTION_STATUS_UNCASHOUT, "未提现");
		COMMISSTION_STATUS.put(Constant.Cash.COMMISSTION_STATUS_APPLYING, "申请提现中");
		COMMISSTION_STATUS.put(Constant.Cash.COMMISSTION_STATUS_CASHOUT, "已提现");
		
		WITHDRAW_APPLY_STATUS.put(Constant.Cash.WITHDRAW_APPLY_STATUS_AUDIT, "审核中");
		WITHDRAW_APPLY_STATUS.put(Constant.Cash.WITHDRAW_APPLY_STATUS_SENDED, "已发放");
		WITHDRAW_APPLY_STATUS.put(Constant.Cash.WITHDRAW_APPLY_STATUS_RECEIVED, "已领取");
		WITHDRAW_APPLY_STATUS.put(Constant.Cash.WITHDRAW_APPLY_STATUS_AUDIT_UNPASS, "审核不通过");
		
		MERCHANT_TYPE.put(Constant.Comm.MERCHANT_TYPE_RESTAURANT, "饭店");
		MERCHANT_TYPE.put(Constant.Comm.MERCHANT_TYPE_HOTEL, "酒店");
		MERCHANT_TYPE.put(Constant.Comm.MERCHANT_TYPE_STORE, "商店");
		MERCHANT_TYPE.put(Constant.Comm.MERCHANT_TYPE_ENTERPRISE, "企业");
		MERCHANT_TYPE.put(Constant.Comm.MERCHANT_TYPE_OTHER, "其它");
		
		ISTORE_TEMPLATE_TYPE.put("default", "默认样式");
		
		YAO_DEVICE_STATUS.put(Constant.YAOZB.DEVICE_STATUS_STOPPED, "禁用");
		YAO_DEVICE_STATUS.put(Constant.YAOZB.DEVICE_STATUS_INACTIVE, "未激活");
		YAO_DEVICE_STATUS.put(Constant.YAOZB.DEVICE_STATUS_ACTIVE, "已激活");
		
		STORAGE_TRANSFER_STATUS.put(Constant.Store.STORAGE_TRANSFER_DURATION,"调库中");
		STORAGE_TRANSFER_STATUS.put(Constant.Store.STORAGE_TRANSFER_DONE, "已完成");
		STORAGE_TRANSFER_STATUS.put(Constant.Store.STORAGE_TRANSFER_CANCELED, "已取消");
		
		YAO_ACTIVITY_TYPE.put(Constant.YAOZB.ACTIVITY_TYPE_HONGBAO, "摇一摇红包");
		YAO_ACTIVITY_TYPE.put(Constant.YAOZB.ACTIVITY_TYPE_LIPIN, "摇一摇礼品");
		YAO_ACTIVITY_TYPE.put(Constant.YAOZB.ACTIVITY_TYPE_YOUHUIQUAN, "摇一摇优惠券");
		YAO_ACTIVITY_TYPE.put(Constant.YAOZB.ACTIVITY_TYPE_XIANJINQUAN, "摇一摇现金券");
		YAO_ACTIVITY_TYPE.put(Constant.YAOZB.ACTIVITY_TYPE_HAIBAO, "摇一摇海报");
		YAO_ACTIVITY_TYPE.put(Constant.YAOZB.ACTIVITY_TYPE_GUANZHU, "摇一摇关注");
		
		YYYGIFT_TYPE.put(Constant.YyyGift.YYYGIFT_TYPE_COMMON, "普通礼品");
		YYYGIFT_TYPE.put(Constant.YyyGift.YYYGIFT_TYPE_REDPACK, "红包礼品");
		YYYGIFT_TYPE.put(Constant.YyyGift.YYYGIFT_TYPE_COUPON, "优惠券");
		YYYGIFT_TYPE.put(Constant.YyyGift.YYYGIFT_TYPE_LINKURL, "特殊链接");
		
		YYYREDPACK_TYPE.put(Constant.YyyRedPack.YYYREDPACK_TYPE_FIX, "定额红包");
		YYYREDPACK_TYPE.put(Constant.YyyRedPack.YYYREDPACK_TYPE_RANGE, "范围红包");
		
		YYYVOTE_METHOD.put(Constant.YyyVote.VOTEMETHOD_ONCE, "一次");
		YYYVOTE_METHOD.put(Constant.YyyVote.VOTEMETHOD_DAY, "每天");
		
		CATELOG_TYPE.put(Constant.SHOPPING.CATELOG_TYPE_PRODUCT, "商品");
		CATELOG_TYPE.put(Constant.SHOPPING.CATELOG_TYPE_SERVICE, "服务");
		CATELOG_TYPE.put(Constant.SHOPPING.CATELOG_TYPE_MESSAGE, "图文");
		CATELOG_TYPE.put(Constant.SHOPPING.CATELOG_TYPE_OTHER, "其它");
		
		SHEQU_ITEM_TAGS.put(Constant.SheQu.ITEM_TAGS_SR,"松茸");
		SHEQU_ITEM_TAGS.put(Constant.SheQu.ITEM_TAGS_MK,"玛咖");
		SHEQU_ITEM_TAGS.put(Constant.SheQu.ITEM_TAGS_HLW,"互联网+");
		SHEQU_ITEM_TAGS.put(Constant.SheQu.ITEM_TAGS_QT,"其他热点");
		
		NEWS_TYPE.put(Constant.NewsType.NEWS_TYPE_GSDT,"公司动态");
		NEWS_TYPE.put(Constant.NewsType.NEWS_TYPE_HYRD,"行业热点");
		NEWS_TYPE.put(Constant.NewsType.NEWS_TYPE_JKZX,"健康资讯");
		NEWS_TYPE.put(Constant.NewsType.NEWS_TYPE_OTHER,"其他");
		
		TASK_STATUS.put(Constant.Task.TASK_STATUS_DRAFT, "草稿");
		TASK_STATUS.put(Constant.Task.TASK_STATUS_WORKING, "进行中");
		TASK_STATUS.put(Constant.Task.TASK_STATUS_FINISH, "已结束");
		
		Properties props = new Properties();
		try {
			props.load(Config.class.getResourceAsStream("/config.properties")); 
			uploadDir = props.getProperty("upload.dir");
			HOSTNAME = props.getProperty("host.name");
			HOSTIMAGE = props.getProperty("host.image");
			HOSTWEIXIN = props.getProperty("host.weixin");
			PAGEDIR = props.getProperty("pagedir","");
			 if(props.getProperty("weixin.notify.url")!=null) WEIXIN_NOTIFY_URL = props.getProperty("weixin.notify.url");
			
			logger.info( uploadDir );
			
			STATIC_DIR = props.getProperty("static.dir");
			logger.info("staticDir:"+ STATIC_DIR );
			
			TEMPLATE_DIR = props.getProperty("template.dir");
			logger.info("templateDir:"+ TEMPLATE_DIR );
			
			TEMPLATE_ID_USER_REGISTER_NOTICE = props.getProperty("template.user_register_notice");
			TEMPLATE_ID_COMMISSION_MSG_NOTICE = props.getProperty("template.commission_msg_notice");
			TEMPLATE_ID_PAY_SUCCESS_NOTICE = props.getProperty("template.pay_success_notice");
			TEMPLATE_ID_ORDER_NEW_NOTICE_TO_MANAGER = props.getProperty("template.order_new_notice_to_manager");
			TEMPLATE_ID_ORDER_NEW_NOTICE_TO_BUYER = props.getProperty("template.order_new_notice_to_buyer");
			TEMPLATE_ID_COUPON_NOTICE_TO_BUYER = props.getProperty("template.coupon_notice_to_buyer");
			TEMPLATE_ID_ORDER_DELIVER_NOTICE_TO_BUYER = props.getProperty("template.order_deliver_notice_to_buyer");
			
			TENPAY_PARTNER_CERT_PATH = props.getProperty("weixin.tenpay_partner_cert_path");
			TENPAY_PARTNER_CERT_KEY = props.getProperty("weixin.tenpay_partner_cert_key"); 
				
		} catch (IOException e) {
			logger.error(e.getMessage());
		}		
		
		cachedProps = props;
	}
	
	public static String getVar(String name){
		return (String)cachedProps.get(name);
	}
	
	static public String[][] init(){
		String[][] resources = {
				{"分销商","材料上传","/partner/{account}/upload.htm"},
				{"分销商","查看推荐用户","/partner/{account}/listUser.htm"},
				{"分销商","成交记录","/partner/{account}/listTrade.htm"},
				{"分销商","Settle","/partner/{account}/listSettle.htm"},
				{"分销商","更新","/partner/{account}/update1.htm"},
				{"分销商","推送消息","/partner/{account}/push.htm"},
				{"分销商","结算","/partner/{account}/clearing.htm"},
				{"分销商","列表","/partner/{account}/list.htm"},
				{"分销商","修改","/partner/{account}/form.htm"},
				{"分销商","更新","/partner/{account}/update.htm"},
				{"分销商","查看","/partner/{account}/view.htm"},
				{"微信设置","微信互动墙","/setting/{account}/jumbotron.htm"},
				{"分类管理","删除","/catelog/{account}/remove.htm"},
				{"分类管理","列表","/catelog/{account}/list.htm"},
				{"分类管理","修改","/catelog/{account}/save.htm"},
				{"分类管理","排序","/catelog/{account}/sort.htm"},
				{"系统管理员","微信帐号","/admin/employee/{account}/weixin.htm"},
				{"系统管理员","列表","/admin/employee/{account}/list.htm"},
				{"系统管理员","修改","/admin/employee/{account}/form.htm"},
				{"问题系统","列表","/faq/{account}/list.htm"},
				{"问题系统","修改","/faq/{account}/form.htm"},
				{"图文编辑","上传图片","/upload/{account}/upload.htm"},
				{"图文编辑","删除图片","/upload/{account}/remove.htm"},
				{"图文编辑","图片列表","/upload/{account}/attachments.htm"},
				{"用户主页","性别报表","/home/{account}/sex.htm"},
				{"用户主页","用户/消息报表","/home/{account}/plot.htm"},
				{"用户主页","首页","/"},
				{"用户主页","控制台","/home.htm"},
				{"用户主页","消息互动墙","/home/{account}/slidee.htm"},
				{"用户主页","获奖名单","/home/{account}/winners.htm"},
				{"用户主页","微信互动墙","/home/{account}/jumbotron.htm"},
				{"回复消息","位置列表","/feedback/{account}/location/list.htm"},
				{"回复消息","位置修改","/feedback/{account}/location/form.htm"},
				{"互动日志","列表","/interactivelogs/{account}/list.htm"},
				{"游戏活动","获奖者列表","/ia/{account}/round/winners.htm"},
				{"游戏活动","领奖","/ia/{account}/round/issued.htm"},
				{"游戏活动","列表","/ia/{account}/round/list.htm"},
				{"活戏活动","修改","/ia/{account}/round/form.htm"},
				{"游戏活动","保存","/ia/{account}/save.htm"},
				{"游戏活动","会员卡","/ia/{account}/membercard.htm"},
				{"微信菜单","图文查询","/menu/{account}/news.json.htm"},
				{"微信菜单","图文菜单","/menu/{account}/news.htm"},
				{"微信菜单","删除","/menu/{account}/remove.htm"},
				{"微信菜单","列表","/menu/{account}/list.htm"},
				{"微信菜单","修改","/menu/{account}/form.htm"},
				{"微信菜单","排序","/menu/{account}/sort.htm"},
				{"微信菜单","微信同步","/menu/{account}/publish.htm"},
				{"回复消息","音乐列表","/feedback/{account}/music/list.htm"},
				{"回复消息","音乐修改","/feedback/{account}/music/form.htm"},
				{"用户主页","消息提示","/home/my/badge.htm"},
				{"用户主页","修改密码","/home/my/password.htm"},
				{"用户主页","站内消息","/home/my/messages.htm"},
				{"回复消息","图文消息列表","/feedback/{account}/news/list.htm"},
				{"回复消息","图文消息修改","/feedback/{account}/news/form.htm"},
				{"订单管理","订单","/order/{account}/bill.htm"},
				{"订单管理","冻结资金","/order/{account}/freezeCash.htm"},
				{"订单管理","列表","/order/{account}/list.htm"},
				{"订单管理","修改","/order/{account}/form.htm"},
				{"订单管理","查询","/order/search.htm"},
				{"订单管理","状态","/order/{account}/status.htm"},
				{"订单管理","更新","/order/{account}/update.htm"},
				{"订单管理","查看","/order/{account}/view.htm"},
				{"订单统计","订单统计","/orderstat/{account}/order_list.htm"},
				{"订单统计","支付订单统计","/orderstat/{account}/bill_list.htm"},
				{"订单统计","分销商统计","/orderstat/{account}/partner_list.htm"},
				{"游戏互动","价格竞猜列表","/ia/{account}/price/list.htm"},
				{"游戏互动","价格竞猜修改","/ia/{account}/price/form.htm"},
				{"电子商务","修改状态","/product/{account}/modifyStatus.htm"},
				{"电子商务","产品列表","/product/{account}/list.htm"},
				{"电子商务","产品修改","/product/{account}/form.htm"},
				{"游戏互动","迷语竞猜列表","/ia/{account}/puzzle/list.htm"},
				{"游戏互动","迷语竞猜修改","/ia/{account}/puzzle/form.htm"},
				{"二维码管理","生成","/qr/{account}/generator.htm"},
				{"二维码管理","列表","/qr/{account}/list.htm"},
				{"二维码管理","修改","/qr/{account}/form.htm"},
				{"二维码管理","查询","/qr/search.htm"},
				{"意见反馈","列表","/questionrecords/{account}/list.htm"},
				{"意见反馈","修改","/questionrecords/{account}/form.htm"},
				{"游戏活动","签到用户","/ia/{account}/register/users.htm"},
				{"游戏活动","签到列表","/ia/{account}/register/list.htm"},
				{"游戏活动","签到修改","/ia/{account}/register/form.htm"},
				{"系统管理","模板设置","/admin/{account}/template.htm"},
				{"系统管理","微信帐号","/admin/weixin/{account}/list.htm"},
				{"系统管理","微信平台","/admin/weixin/{account}/platform.htm"},
				{"系统管理","系统设置","/admin/{account}/config.htm"},
				{"短信管理","短信列表","/smstemplate/{account}/list.htm"},
				{"短信管理","短信修改","/smstemplate/{account}/form.htm"},
				{"系统统计","用户统计","/statistics/{account}/stat_user.htm"},
				{"门店管理","上传","/store/{account}/upload.htm"},
				{"门店管理","列表","/store/{account}/list.htm"},
				{"门店管理","修改","/store/{account}/form.htm"},
				{"供应商","结算","/supplier/{account}/clearing.htm"},
				{"供应商","支付订单","/supplier/{account}/listBill.htm"},
				{"供应商","订单列表","/supplier/{account}/listTrade.htm"},
				{"供应商","绑定用户","/supplier/{account}/listSettle.htm"},
				{"供应商","列表","/supplier/{account}/list.htm"},
				{"供应商","修改","/supplier/{account}/form.htm"},
				{"消息回复","文本列表","/feedback/{account}/list.htm"},
				{"消息回复","文本修改","/feedback/{account}/form.htm"},
				{"用户管理","消息列表","/user/{account}/messages.htm"},
				{"用户管理","回复","/user/{account}/reply.htm"},
				{"用户管理","列表","/user/{account}/list.htm"},
				{"用户管理","修改","/user/{account}/form.htm"},
				{"游戏互动","微信投票列表","/ia/{account}/vote/list.htm"},
				{"游戏互动","微信投票修改","/ia/{account}/vote/form.htm"}
		};
		return resources;
	}
}
