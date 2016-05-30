package cn.com.idaka.core.util;

public interface Constant {
	
	public final static int TRUE = 1;
	public final static int FALSE = 0;
	
	public final static int ACTIVE = 1;
	public final static int INACTIVE = 0;
	
	/** 可用 */
	public final static int ENABLE = 1;
	/** 不可用 */
	public final static int DISABLE = 0;
	
	
	/** 产品类型 */
	public interface Product{
		public final static int PRODUCT_TYPE_ITEM = 1;	//商品
		public final static int PRODUCT_TYPE_SERVICE = 2;	//服务
	}
	
	
	/** 订单相关 */
	public interface Order{
		
		/** 订单类型 */
		/** 普通订单 */
		public final static int TYPE_NORMAL = 100;
		/** 送礼订单 */
		public final static int TYPE_GIFT = 200;
		/** 测试订单*/
		public final static int TYPE_TEST = 300;
		
		
		/** 订单状态 */
		/** 待付款 */
		public final static int STATUS_TO_PAY = 100;
		/** 已付款，待发货 */
		public final static int STATUS_TO_DELIVER = 200;
		/** 已发货，待收货 */
		public final static int STATUS_TO_RECEIVE = 300;
		/** 已完成 */
		public final static int STATUS_FINISHED = 400;
		/** 申请退款 */
		public final static int STATUS_APPLY_REFUND = 500;
		/** 申请退货退款 */
		public final static int STATUS_APPLY_GOOD_REFUND = 600;
		/** 已退款 */
		public final static int STATUS_REFUNDED = 700;
		/** 已取消 */
		public final static int STATUS_CANCELED = 1000;
		/** 已撤销 */
		public final static int STATUS_WITHDRAW = 1200;
		/** 已删除 */
		public final static int STATUS_DELETE = 1300;
		
		
		/** 收货方式 */
		/** 门店提货 */
		public final static String RECEIVING_TYPE_STORE = "store";
		/** 邮寄上门 */
		public final static String RECEIVING_TYPE_EXPRESS = "express";
		/** 送货上门 */
		public final static String RECEIVING_TYPE_SENDHOME = "sendhome";
		
		
		/** 分销商提成方式 */
		/** 按百分比 */
		public final static int PARTNER_COMM_TYPE_PERCENT = 0;
		/** 按固定数额 */
		public final static int PARTNER_COMM_TYPE_AMOUNT = 1;
		
		/** 以下供单品配置使用 */
		/** 默认配置 */
		public final static int PARTNER_COMM_TYPE_DEFAULT = 2;
		/** 不提成 */
		public final static int PARTNER_COMM_TYPE_NO_COMM = 3;
		
		
		/** 首单提成计算方式 */
		/** 只发首单提成 */
		public final static int COMM_FIRST_CALC_TYPE_SINGLE = 100;
		/** 与一级分销提成叠加 */
		public final static int COMM_FIRST_CALC_TYPE_SUM = 200;
		/** 取最大值 */
		public final static int COMM_FIRST_CALC_TYPE_MAX = 300;
		/** 取最小值 */
		public final static int COMM_FIRST_CALC_TYPE_MIN = 400;
		
		/** 发货状态 */
		/** 未发货 */
		public final static int DELIVER_STATUS_UNSEND = 100;
		/** 已发货 */
		public final static int DELIVER_STATUS_SENDED = 200;
		
		
		/** 0元购状态 */
		public final static int FREEBUY_ORDER_STATUS_UNPAY = 100;
		public final static int FREEBUY_ORDER_STATUS_PAYED = 200;
		public final static int FREEBUY_ORDER_STATUS_FINISH = 300;
		public final static int FREEBUY_ORDER_STATUS_DELETE = 400;
	}
	
	/** 礼包状态 */
	public interface Gift{
		public final static String NEW = "new";
		public final static String PAYED = "payed";
		//public final static String SENDING = "sending";
		public final static String SENDED = "sended";
		public final static String ACCEPTED = "accepted";
		public final static String FORWARD = "forward";
		public final static String RENEW = "renew";//重新生成 , 待转赠
		
		/** 待发货 */
		public final static int GIFT_EXPRESS_TO_DELIVER = 100;
		/** 待收货 */
		public final static int GIFT_EXPRESS_TO_RECEIVE = 200;
		/** 已收货 */
		public final static int GIFT_EXPRESS_RECEIVED = 300;
		/** 已完成*/
		public final static int GIFT_EXPRESS_FINISHED = 1000;
	}
	
	/** 微信用户角色 */
	public interface Role{
		public final static int ROLE_ID_OPERATION_NORMAL = 1;//普通人员
		public final static int ROLE_ID_OPERATION_ADMIN = 2;//管理员
		public final static int ROLE_ID_OPERATION_MANAGER = 3;  //运营人员
		public final static int ROLE_ID_OPERATION_TEST = 4;  //流程测试人员
		public final static int ROLE_ID_STORE_WAITER = 10;  //门店服务员
	}
	
	/** 促销活动 */
	public interface Promotion{
		/** 促销活动计算方式 */
		/** 按订单金额计算 */
		public static final int CACULATED_BY_ORDER_AMOUNT = 1;		
		/** 按订单商品数量计算 */
		public static final int CACULATED_BY_ORDER_QUANTITY = 2;	
		
		
		/** 促销方式 */
		/** 折扣 */
		public static final int PRO_TYPE_DISCOUNT = 1;
		/** 减免现金 */
		public static final int PRO_TYPE_LESSCASH = 2;
		/** 赠送优惠券 */
		public static final int PRO_TYPE_COUPON = 3;
		/** 减免邮费，如果减免的数量为负数，表示运费全面，即包邮。 */
		public static final int PRO_TYPE_FREE_SHIP = 4;
		/** 限时特价 */
		public static final int PRO_TYPE_LIMIT = 5;
		/** 积分抵现金 */
		public static final int PRO_TYPE_USING_CREDIT = 6;
		/** 购物送积分 */
		public static final int PRO_TYPE_SEND_CREDIT = 7;
		/** 邀请好友砍价 */
		public static final int PRO_TYPE_FRIENDS_BARGAIN = 8;
		/** 摇一摇促销 */
		public static final int PRO_TYPE_YAOYYAO = 9;
		/** 三人成团 */
		public static final int PRO_TYPE_MANYPEOPLEGROUP = 10;
		/** 0元购 */
		public static final int PRO_TYPE_FREEBUY = 11;
		
		
		/** 促销活动范围 */
		/** 全部商品 */
		public static final int RANG_ALL = 0;
		public static final int RANG_IN_BRANDS = 1;
		public static final int RANG_IN_CATEGORIES = 2;
		public static final int RANG_IN_PRODUCTS = 3;
		public static final int RANG_UNLIMITED = 0;
		
		/** 限购类型 */
		public static final int LIMIT_TYPE_BY_PROMOTION = 100;
		public static final int LIMIT_TYPE_BY_PRODUCT = 200;
		
		/** 返现周期 */
		/** 按周返现 */
		public static final int FREEBUY_RETURN_TYPE_BY_WEEK = 100;
		/** 按月返现 */
		public static final int FREEBUY_RETURN_TYPE_BY_MONTH = 200;
	}
	
	/** 优惠券 */
	public interface Coupon{
		/** 优惠券类型 */
		/** 现金券 */
		public static final int COUPON_TYPE_LESSCASH = 1;	
		/** 折扣券 */
		public static final int COUPON_TYPE_DISCOUNT = 2;	
		
		/** 优惠券发放方式 */
		/** 手工派发 */
		public static final int DELIVERY_TYPE_MANUAL = 1;
		/** 促销活动 */
		public static final int DELIVERY_TYPE_PROMOTION = 2;
		/** 新用户注册 */
		public static final int DELIVERY_TYPE_REGISTER = 3;
		/** 互动活动 */
		public static final int DELIVERY_TYPE_INTERACTIVE = 4;
		/** 分销商派发 */
		public static final int DELIVERY_TYPE_PARTNER = 5;
		/** 扫码关注 */
		public static final int DELIVERY_TYPE_SCAN = 6;
		/** 红包兑换 */
		public static final int DELIVERY_TYPE_REDEXCHANGE = 7;
		/** 纸质印刷 */
		public static final int DELIVERY_TYPE_PRINT = 8;
		
		
		
		/** 优惠券凭证状态 */
		/** 新生成 */
		public static final int TICKET_STATUS_NEW = 1; 		
		/** 已派发 */
		public static final int TICKET_STATUS_SEND = 2;		
		/** 已激活 */
		public static final int TICKET_STATUS_ACTIVE = 3;	
		/** 已使用 */
		public static final int TICKET_STATUS_USED = 4;		
		/** 已过期 */
		public static final int TICKET_STATUS_EXPIRED = 5;	
		
		/**关联的卡券状态*/
		/** 未生成*/
		public static final int COUPON_CARD_STATUS_UNCREATED = 100;
		/** 审核中*/
		public static final int COUPON_CARD_STATUS_CHECKING = 200;
		/** 审核失败*/
		public static final int COUPON_CARD_STATUS_FAILED = 300;
		/** 使用中*/
		public static final int COUPON_CARD_STATUS_NORMAL = 400;
		/** 已停用*/
		public static final int COUPON_CARD_STATUS_OVERDUE = 1000;
		
		/** 优惠券类别，根据优惠券的发放机构区分 */
		
		/** 平台派发 */
		public static final int COUPON_CATELOG_PLATFORM = 1;
		/** 分销商派发 */
		public static final int COUPON_CATELOG_SUPPLIER = 2;
		/** 商户派发 */
		public static final int COUPON_CATELOG_MERCHANT = 3;
		
	}
	
	/** 分销商 */
	public interface Partner{
		/** 分销商类型 */
		/** 个人 */
		public static final int TYPE_PERSON = 100;
		
		/** 分销级数 */
		/** 一级 */
		public static final int STAGE_ONE = 100;
		/** 二级 */
		public static final int STAGE_TWO = 200;
	}
	
	/** 抽奖活动 */
	public interface LuckyRound{
		/** 活动类型 */
		public static final int TYPE_GGL = 100;		/** 刮刮乐 */
		public static final int TYPE_DZP = 200;		/** 大转盘 */
		
		/** 奖品类型 */
		public static final int PRIZE_TYPE_TEXT = 100;		/** 文本描述 */
		public static final int PRIZE_TYPE_COUPON = 200;	/** 优惠券 */
		
		/** 活动状态 */
		public final static int STATUS_STOP = 0;	/**停用*/
		public final static int STATUS_NORMAL = 1;	/**使用中*/
	}
	
	/** 产品评论类型 */
	public interface ProductComment{
		public static final int PRIZED = 1;		/**	点赞	*/
		public static final int COMMENT = 2;	/**	评论	*/
		public static final int SHARED = 3;		/**	分享	*/
	}
	
	/** 购物车 */
	public interface ShoppingItem{
		/**	有效	*/
		public static final int STATUS_ENABLE = 100;	
		/**	无效	*/
		public static final int STATUS_DISABLE = 200;	
	}
	
	/** 仓库相关 */
	public interface Store{
		/** 仓库类型 */
		/** 仓库 */
		public static final int STORE_TYPE_REPOSITORY = 100;
		/** 门店 */
		public static final int STORE_TYPE_STORE = 200;
		/** 销售点 */
		public static final int STORE_TYPE_SALEPOINT = 300;
		
		/** 发货单状态 */
		/** 待发货 */
		public static final int DELIVERY_ORDER_STATUS_TO_DELIVER = 100;
		/** 已发货 */
		public static final int DELIVERY_ORDER_STATUS_DELIVERED = 200;
		/** 已取消 */
		public static final int DELIVERY_ORDER_STATUS_CANCELED = 300;
		
		/** 出入库类型 */
		/** 入库 */
		public static final int STORAGE_ORDER_TYPE_IN = 100;
		/** 出库 */
		public static final int STORAGE_ORDER_TYPE_OUT = 200;
		
		/**调库状态*/
		public static final int STORAGE_TRANSFER_DURATION = 0;
		public static final int STORAGE_TRANSFER_DONE = 1;
		public static final int STORAGE_TRANSFER_CANCELED = 2;
	}
	
	/** 现金相关 */
	public interface Cash{
		/** 红包类型 */
		/** 推荐新用户关注 */
		public static final int COMMISSION_TYPE_REGISTER = 100;
		/** 取消关注 */
		public static final int COMMISSION_TYPE_UNREGISTER = 150;
		/** 推荐用户下单提成 */
		public static final int COMMISSION_TYPE_ORDER_COMMISSION = 200;
		/** 购买优惠券 */
		public static final int COMMISSION_TYPE_REDBUYCOUPON = 300;
		
		/** 红包状态 */
		/** 未提现 */
		public static final int COMMISSTION_STATUS_UNCASHOUT = 100;
		/** 申请提现中 */
		public static final int COMMISSTION_STATUS_APPLYING = 200;
		/** 已提现 */
		public static final int COMMISSTION_STATUS_CASHOUT = 300;
		
		/** 提现申请状态 */
		/** 审核中 */
		public static final int WITHDRAW_APPLY_STATUS_AUDIT = 100;
		/** 已发放 */
		public static final int WITHDRAW_APPLY_STATUS_SENDED = 200;
		/** 已领取 */
		public static final int WITHDRAW_APPLY_STATUS_RECEIVED = 300;
		/** 审核不通过 */
		public static final int WITHDRAW_APPLY_STATUS_AUDIT_UNPASS = 1000;
		
	}
	
	/** 商户相关 */
	public interface Comm{
		/** 商户类型 */
		/** 饭店 */
		public static final int MERCHANT_TYPE_RESTAURANT = 100;
		/** 酒店 */
		public static final int MERCHANT_TYPE_HOTEL = 200;
		/** 商店 */
		public static final int MERCHANT_TYPE_STORE = 300;
		/** 企业 */
		public static final int MERCHANT_TYPE_ENTERPRISE = 400;
		/** 其它 */
		public static final int MERCHANT_TYPE_OTHER = 10000;
	}
	
	/** 电子商务 */
	public interface SHOPPING{
		/** 分类类型 */
		/** 商品 */
		public static final int CATELOG_TYPE_PRODUCT = 100;
		/** 服务 */
		public static final int CATELOG_TYPE_SERVICE = 150;
		/** 图文 */
		public static final int CATELOG_TYPE_MESSAGE = 200;
		/** 其它 */
		public static final int CATELOG_TYPE_OTHER = 900;
	}
	
	/** 摇周边设备、活动管理相关常量 */
	public interface YAOZB{
		/** 设备状态 */
		/** 禁用 */
		public static final int DEVICE_STATUS_STOPPED = 100;
		/** 未激活 */
		public static final int DEVICE_STATUS_INACTIVE = 200;
		/** 已激活 */
		public static final int DEVICE_STATUS_ACTIVE = 300;
		
		/** 活动类型 */
		/** 摇一摇红包 */
		public static final int ACTIVITY_TYPE_HONGBAO = 10;
		/** 摇一摇礼品 */
		public static final int ACTIVITY_TYPE_LIPIN = 20;
		/** 摇一摇优惠券 */
		public static final int ACTIVITY_TYPE_YOUHUIQUAN = 30;
		/** 摇一摇现金券 */
		public static final int ACTIVITY_TYPE_XIANJINQUAN = 40;
		/** 摇一摇海报 */
		public static final int ACTIVITY_TYPE_HAIBAO = 50;
		/** 摇一摇关注 */
		public static final int ACTIVITY_TYPE_GUANZHU = 60;
	}
	
	
	/** 摇一摇礼品*/
	public interface YyyGift{
		int YYYGIFT_TYPE_COMMON = 1;//普通礼品
		
		int YYYGIFT_TYPE_REDPACK = 2;//红包礼品
		
		int YYYGIFT_TYPE_COUPON = 3;//优惠券
		
		int YYYGIFT_TYPE_LINKURL = 4;//特殊链接
	}
	
	/** 摇一摇红包*/
	public interface YyyRedPack{
		int YYYREDPACK_TYPE_FIX = 1;//定额红包
		
		int YYYREDPACK_TYPE_RANGE = 2;//范围红包
	}
	
	/** 摇一摇红包*/
	public interface YyyVote{
		int VOTEMETHOD_ONCE = 1;//只能投票一会
		
		int VOTEMETHOD_DAY = 2;//每天均可投票
	}
	
	
	public interface SheQu{
		
		public static final String ITEM_TAGS_SR="ys4.0";
		public static final String ITEM_TAGS_MK="mk";
		public static final String ITEM_TAGS_HLW="hlw";
		public static final String ITEM_TAGS_QT="qt";
		
	}
	
	public interface NewsType{
		public static final String NEWS_TYPE_GSDT="gsdt";//公司动态
		public static final String NEWS_TYPE_HYRD="hyrd";//行业热点
		public static final String NEWS_TYPE_JKZX="jkz";//健康资讯
		public static final String NEWS_TYPE_OTHER="other";//健康资讯
	}

	public interface Day{
		public static final int LAW_DAY_TYPE_WORKDAY = 100;//法定工作日
		public static final int LAW_DAY_TYPE_FESTIVAL = 200;//法定节假日
	}
	
	
	public interface Kaoqin {
		public static final String DEFAULT_STRATEGY_TYPE = "DefaultKaoqinStrategy";//考勤默认执行策略
		public static final String STORE_STRATEGY_TYPE = "StoreKaoqinStrategy";//门店考勤执行策略
	}
	
	public interface Business{
		public static final int ALL_BUSINESS_TYPE = 0;		//大班
		public static final int DEFAULT_BUSINESS_TYPE = 1; //默认(行政班)
		public static final int AM_BUSINESS_TYPE = 2;		//早班
		public static final int PM_BUSINESS_TYPE = 3;		//中班
		
	}
	
	
	public interface Sort{
		public static final String ASC = "ASC";  // 顺序
		public static final String DESC = "DESC";//逆序
	}
	
	
	/** 任务状态 */
	public interface Task{
		public static final int TASK_STATUS_DRAFT = 100;	// 草稿
		public static final int TASK_STATUS_WORKING = 200;	// 进行中
		public static final int TASK_STATUS_FINISH = 300;	// 已结束		
	}
	
	/** 上传文件  */
	public interface UploadFile{
		public static final int FILE_ORIGIN_NAME = 100;	    //原始名称
		public static final int FILE_SAVE_NAME = 200;		//上传保存后文件名称，包括具体路径
		public static final int FILE_THUMB_NAME = 300;		//缩略图
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/** 支付状态 */
	public interface PayStatus{}
	
	
	/** 提现申请的状态 */
	public interface CashoutStatus{
		/** 已提交 */
		int COMMIT = 0;
		/** 已完成 */
		int FINISHED = 1;
	}
	
	/** 结算状态 */
	public interface ClearStatus{
		/** 未结算 */
		int NO_CLEAR = 0;
		/** 已结算 */
		int CLEARED = 1;
		/** 结算中 */
		int CLEARING = 2;
	}
	
	/** request 请求判断 */
	public interface Method{
		String METHOD_TO_QUERY = "toQuery";
	}


	public interface Page {
		public static final int NEWS = 1;
		public static final int PRODUCT = 2;
		public static final int USER = 3;
		public static final int PROMOTION = 4;
		public static final int PARTNER = 5;
		public static final int CATALOG = 6;
		public static final int BRAND = 7;
		public static final int SUM_USER = 102;
	}
	
	/** 判断是点赞还是 */
	public interface Praise{
		/** 点赞 */
		public static final int PRAISE = 1;
		/** 拍砖 */
		public static final int DESPISE = 2;
	}
}
