/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 * 
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.common.api;

/**
 * @Description 功能号定义 P_:app用功能号 AO_:后台运营用功能号 AP_:后台商户用功能号 AC_:后台通用功能号 C_:全局通用功能号
 * @date 2018年1月25日 上午9:47:05
 * @version V1.0.1
 */
public class HjAction {
	// =========================图片存放列表====================
	/**
	 * 图片存放URL
	 */
	public final static String IMG_URL = "IMGURL0001";

	// =========================BANNER接口列表====================
	/**
	 * BANNER广告页列表
	 */
	// public final static String A_BANNER = "BANNER0001";
	public final static String P_BANNER_LIST = "BANNER0001";

	/**
	 * BANNER广告页 列表
	 */
	public final static String A_BANNER_LIST = "BANNER0002";

	/**
	 * BANNER广告页 状态更新 上架 下架 删除
	 */
	public final static String A_BANNER_STATE_EDIT = "BANNER0003";

	/**
	 * BANNER广告页 详情
	 */
	public final static String A_BANNER_DETAIL = "BANNER0004";

	/**
	 * BANNER广告页 修改/增加
	 */
	public final static String A_BANNER_SAVE = "BANNER0005";

	/**
	 * BANNER广告页 调序
	 */
	public final static String A_BANNER_SORT = "BANNER0006";

	// =========================意见类接口列表====================
	/**
	 * 问题及意见反馈列表
	 */
	public final static String A_FEEDBACK_LIST = "FEEDBACK0001";

	/**
	 * 问题及意见反馈列表导出
	 */
	public final static String A_FEEDBACK_EXP = "FEEDBACK0006";
	/**
	 * 问题及意见反馈详情
	 */
	public final static String A_FEEDBACK_DETAIL = "FEEDBACK0003";

	/**
	 * 问题及意见反馈详情列表
	 */
	public final static String A_FEEDBACK_DETAIL_LIST = "FEEDBACK0005";

	/**
	 * 意见反馈 回复
	 */
	public final static String A_FEEDBACK_RE = "FEEDBACK0002";

	/**
	 * 意见反馈 回复
	 */
	public final static String A_FEEDBACK_LIST_RE = "FEEDBACK0004";

	/**
	 * 客服管理-客服客户通话记录列表
	 */
	public final static String A_MY_CUSTOMER_USER_CALL_RECORD = "PHONEVISIT0001";

	/**
	 * 客服管理-客服客户通话记录保存
	 */
	public final static String A_MY_CUSTOMER_USER_CALL_SAVE = "PHONEVISIT0002";

	/**
	 * 统计UV
	 */
	public final static String P_STATIC_UV = "P_STATIC_UV";

	// =========================产品接口列表====================

	public final static String A_PRODUCT_ADD_MODIFY = "PROD0005";

	public final static String A_PRODUCT_VIEW = "PROD0006";

	public final static String A_ALL_PRODUCT_LIST = "PROD0007";

	public final static String A_PRODUCT_LIST = "PROD0008";

	public final static String A_PRODUCT_LIST_EXP = "EXPPROD0008";

	public final static String A_PRODUCT_OPER = "PROD0009";

	public final static String A_PRODUCT_DEL = "PROD0010";

	public final static String A_PRODUCT_EXPORT = "PROD0013";

	public final static String A_PRODUCT_DATA_LIST = "PROD0011";

	public final static String A_PRODUCT_DATA_LIST_EXP = "EXPPROD0011";

	public final static String A_ALL_PRODUCT_INTERFACE = "PROD0012";

	// =========================APP端接口列表=========================

	/**
	 * 获取请求接口地址
	 */
	public final static String U_ACHIEVE_URL = "APPSYS0001";
	/**
	 * 开屏弹窗广告接口
	 */
	public final static String U_OPENING_POPUP = "APPU0007";
	/**
	 * 用户消息 查询消息
	 */
	public final static String U_MESSAGE = "MSG0001";

	/**
	 * 用户消息 阅读消息
	 */
	public final static String U_MESSAGE_CNT = "MSG0002";

	/**
	 * 查询轮播消息
	 */
	public final static String U_MESSAGE_BROADCAST = "MSG0003";

	/**
	 * 用户点击日志记录
	 */
	public final static String U_CLICK_LOG = "LOG0001";

	/**
	 * 用户注册
	 */
	public final static String U_REGISTER = "U0001";

	/**
	 * 用户设置新密码
	 */
	public final static String P_LOGIN_PASSWORDEDIT = "P_LOGIN_PASSWORDEDIT";

	/**
	 * 微信公众号、客服电话、微信客服
	 */
	public final static String P_PUBLIC = "P_PUBLIC";

	/**
	 * 用户密码登录
	 */
	public final static String P_LOGIN_PWD = "P_LOGIN_PWD";

	/**
	 * 用户三方登录
	 */
	public final static String P_OAUTH_LOGIN = "APPU0001";

	/**
	 * 第三方登录后绑定手机号
	 */
	public final static String P_MODILE_BIND = "APPU0002";

	/**
	 * 用户登录短信验证码
	 */
	public final static String P_SMS_USER_LOGIN = "APPM0001";

	/**
	 * 验证码登录
	 */
	public final static String P_SMS_LOGIN = "APPU0003";

	/**
	 * facebook短信登录
	 */
	public final static String P_FACEBOOK_SMS_LOGIN = "APPU0004";

	/**
	 * facebook绑定电话号码
	 */
	public final static String P_FACEBOOK_PHONE_BIND = "APPU0008";

	/**
	 * 获取找贷款搜索配置项
	 */
	public final static String P_SEARCH_CRITERIA_FIND = "PRODS0001";

	/**
	 * 获取产品推荐列表
	 */
	public final static String P_PRODUCT_RECOMMEND_LIST = "PROD0001";

	/**
	 * 贷款超市页面
	 */
	public final static String P_PRODUCT_LIST = "PROD0002";

	/**
	 * 贷款产品详情
	 */
	public final static String C_PRODUCT_DETAIL = "PROD0003";

	/**
	 * 产品收藏/取消收藏
	 */
	public final static String P_PRODUCT_COLLECT = "PROD0004";

	/**
	 * 判断产品有没有收藏
	 */
	public final static String P_USER_PRODUCT_COLLECT = "PROD0014";

	/**
	 * 产品常见问题列表
	 */
	public final static String P_PRODUCT_QUESTION_LIST = "PROD0015";

	/**
	 * 用户登出
	 */
	public final static String U_LOGOUT = "U0003";

	/**
	 * app上传异常信息
	 */
	public final static String APPEXCEPTION_UPLOAD = "APP0002";
	/**
	 * 用户登出
	 */
	public final static String U_LOGOUT_OUT = "U00015";

	/**
	 * 设置密码
	 */
	public final static String U_MODIFY_PWD = "U0004";
	/**
	 * 验证找回密码验证码
	 */
	public final static String U_VERIFY_SMS_RESET_PWD = "U0005";
	/**
	 * 忘记密码-重置密码
	 */
	public final static String U_RESET_PWD = "U0006";
	/**
	 * 更换绑定手机
	 */
	public final static String U_MODIFY_PHONE = "U0007";
	/**
	 * 查看用户信息
	 */
	public final static String U_INFO_GET = "U0008";
	/**
	 * 用户信息修改
	 */
	public final static String U_INFO_EDIT = "U0009";
	/**
	 * 设置支付密码
	 */
	public final static String U_PAY_PWD_SET = "U0010";
	/**
	 * 修改支付密码
	 */
	public final static String U_PAY_PWD_EDIT = "U0011";
	/**
	 * 更换绑定手机前验证当前密码
	 */
	public final static String U_MODIFY_PHONE_CONFORM_PWD = "U0012";

	/**
	 * 根据openid获取用户信息并自动登录
	 */
	public final static String U_INFO_BY_OPENID = "U0013";

	/**
	 * 用户个人资料填写
	 */
	public final static String U_INFO_ADD = "U0014";

	/**
	 * 他人根据用户的id查看用户信息
	 */
	public final static String U_GETINFO_BY_ID = "U0060";

	/**
	 * 意见反馈
	 */
	public final static String U_FEEDBACK = "U0070";
	/**
	 * 添加分享记录
	 */
	public final static String U_WX_SHARE_ADD = "U0071";
	/**
	 * 用户打开app统计
	 */
	public final static String U_OPEN_APP = "U0072";

	/**
	 * 我的收藏
	 */
	public final static String U_USER_COLLECTIONS = "APPU0005";

	/** --------------------------通用功能定义------------------------------ */
	/**
	 * 上传头像
	 */
	public final static String C_HEAD_UPLOAD = "F0001";
	/**
	 * 上传图片
	 */
	public final static String C_IMAGE_UPLOAD = "F0002";

	/**
	 * 上传图片
	 */
	public final static String A_IMAGE_UPLOAD = "F0005";
	/**
	 * 图片查看
	 */
	public final static String C_IMAGE_VIEW = "F0003";
	/**
	 * 获取融云token
	 */
	public final static String C_RONG_TOKEN_GET = "C0001";

	/**
	 * 获取banner图列表
	 */
	public final static String C_BANNER_LIST = "C0002";

	/**
	 * 根据id查询城市信息
	 */
	public final static String C_AREA_SELECT_BY_ID = "C0010";
	/**
	 * 查询包含首字母的城市列表
	 */
	public final static String C_AREA_CITY_BY_CHAR = "C0011";
	/**
	 * 查询所有城市列表
	 */
	public final static String C_AREA_SELECT_ALL = "C0012";

	/**
	 * 根据pid查询下属城市列表
	 */
	public final static String C_AREA_LIST_BY_PID = "C0013";

	/**
	 * 查询所有数据字典map
	 */
	public final static String DICT_ALL_INMAP = "DICT0001";

	/** --------------------------短信功能定义------------------------------ */
	/**
	 * 用户注册短信验证码
	 */
	public final static String SMS_USER_REGISTER = "M0001";

	/**
	 * 忘记密码-发送验证码
	 */
	public final static String SMS_USER_FORGET_PWD = "M0003";
	/**
	 * 更换绑定手机-验证验证码
	 */
	public final static String SMS_USER_MODIFY_PHONE = "M0004";

	/**
	 * 代付款未支付订单提醒
	 */
	public final static String SMS_USER_ORDER_NEEDPAY = "M0005";

	/**
	 * 退款申请已受理
	 */
	public final static String SMS_USER_ORDER_FEFUND_ACCEPT = "M0006";

	/**
	 * 退款到账通知
	 */
	public final static String SMS_USER_ORDER_FEFUNDED = "M0007";

	// =================后台管理=====================
	/**
	 * 后台登录
	 */
	public final static String A_LOGIN = "A0001";

    /**
     * 后台登录获取手机验证码
     */

    public static final String A_LOGIN_SMS = "A00002";

	/**
	 * 工作台
	 */
	public final static String A_WORKST = "WORKST0001";
	/**
	 * 修改登录密码
	 */
	public final static String A_EDIT_PWD = "A0002";

	/**
	 * 后台用户列表
	 */
	public final static String A_SEARCH_USER = "A0003";

	/**
	 * 后台用户个人信息
	 */
	public final static String A_SEARCH_USER_INFO = "A0004";

	/**
	 * 修改后台用户个人信息
	 */
	public final static String A_EDIT_USER_INFO = "A0005";

	/**
	 * 移入移出黑名单
	 */
	public final static String A_ADD_BLACK = "A0006";

	/**
	 * 黑名单列表
	 */
	public final static String A_SEARCH_BlACK_USER = "A0007";
	/**
	 * 所有权限树状图
	 */
	public final static String A_RIGHT_TREE = "A0010";

	/**
	 * 添加角色
	 */
	public final static String A_ROLE_ADD = "A0011";
	/**
	 * 编辑角色
	 */
	public final static String A_ROLE_EDIT = "A0012";
	/**
	 * 删除角色
	 */
	public final static String A_ROLE_DEL = "A0013";
	/**
	 * 角色详情
	 */
	public final static String A_ROLE_DETAIL = "A0014";

	/**
	 * 角色分页查询
	 */
	public final static String A_ROLE_PAGE_LIST = "A0015";

	/**
	 * 添加管理员
	 */
	public final static String A_ADMIN_ADD = "A0016";
	/**
	 * 编辑管理员
	 */
	public final static String A_ADMIN_EDIT = "A0022";
	/**
	 * 删除管理员
	 */
	public final static String A_ADMIN_DEL = "A0018";
	/**
	 * 管理员详情
	 */
	public final static String A_ADMIN_DETAIL = "A0019";
	/**
	 * 管理员分页显示
	 */
	public final static String A_ADMIN_PAGE_LIST = "A0020";

	/**
	 * 管理员重置密码
	 */
	public final static String A_ADMIN_RESET_PWD = "A0017";

	/**
	 * 添加推荐
	 */
	public final static String A_ADD_RECOMMEND = "A0033";
	/**
	 * 取消推荐
	 */
	public final static String A_CANCEL_RECOMMEND = "A0037";

	/**
	 * 订单列表
	 */
	public final static String A_SEARCH_ORDER = "A0060";
	/**
	 * 用户反馈
	 */
	public final static String A_SEARCH_USER_FEEDBACK = "A0070";

	/**
	 * 后台-用户管理--用户列表
	 */
	public final static String A_USER_MANAGER_LIST = "ADMINUSER0001";

	/**
	 * 后台-用户管理--用户列表导出
	 */
	public final static String A_USER_LIST_EXP = "ADMINUSER0005";

	/**
	 * 后台-用户管理--用户详细信息
	 */
	public final static String A_USER_MANAGER_DETAIL = "ADMINUSER0002";

	/**
	 * 后台-用户管理--用户信息-我的收藏纪录
	 */
	public final static String A_USER_COLLECTIONS = "ADMINUSER0003";

	/**
	 * 后台-用户管理--用户信息-点击下载
	 */
	public final static String A_USER_DOWNLOAD = "ADMINUSER0004";

	/**
	 * 后台-用户管理--用户行为（改版后用户详情）
	 */
	public final static String AO_USER_EVENT_DETAIL = "AO_USER_EVENT_DETAIL";

	/**
	 * 查询app上架状态
	 */
	public final static String APPUPLOAD_STATUS = "APP0001";

	/**
	 * 查询所有系统配置项
	 */
	public final static String SYSOPTION_ALL_INMAP = "SYS0001";

	// =================平台管理=====================
	/**
	 * 常见问题添加
	 */
	public final static String QUESTION_ADD = "QUESTION0001";

	/**
	 * 常见问题删除
	 */
	public final static String QUESTION_DELETE = "QUESTION0002";

	/**
	 * 常见问题修改
	 */
	public final static String QUESTION_EDIT = "QUESTION0003";

	/**
	 * 常见问题列表
	 */
	public final static String QUESTION_LIST = "QUESTION0004";

	/**
	 * 首页热推列表
	 */
	public final static String PRODHOT_LIST = "PRODHOT0001";
	/**
	 * 首页热推调整
	 */
	public final static String PRODHOT_SORT = "PRODHOT0002";
	/**
	 * 首页热推上线/下线
	 */
	public final static String PRODHOT_EDIT = "PRODHOT0003";
	/**
	 * 首页热推删除
	 */
	public final static String PRODHOT_DELETE = "PRODHOT0004";
	/**
	 * 首页热推添加
	 */
	public final static String PRODHOT_ADD = "PRODHOT0005";

	// =================运营管理=====================

	/**
	 * 渠道数据列表
	 */
	public final static String CHANNEL_LIST = "CHANNEL0001";
	/**
	 * 渠道数据列表导出
	 */
	public final static String CHANNEL_LIST_EXP = "CHANNEL0002";
	/**
	 * 广告设置列表
	 */
	public final static String ADVERTIS_LIST = "ADVERTIS0001";
	/**
	 * 广告添加/修改
	 */
	public final static String ADVERTIS_ADD_EDIT = "ADVERTIS0002";
	/**
	 * 广告上线/下线/删除
	 */
	public final static String ADVERTIS_STATUS_EDIT = "ADVERTIS0003";

	// =================APP我的=====================
	/**
	 * 添加意见反馈
	 */
	public final static String U_FEEDBACK_ADD = "APPU0006";

	/**
	 * 帮助中心列表
	 */
	public final static String U_QUESTION_HELP = "HELPCENTER0001";

	/**
	 * 站内消息列表
	 */
	public final static String U_MESSAGE_LIST = "MESSAGE0015";

	/**
	 * 阅读用户消息
	 */
	public final static String U_READ_MESSAGE = "MESSAGE0016";
	// =================appsflyer click事件=====================
	/**
	 * 获取appsflyer clickid
	 */
	public final static String APPSFLYER_CLICK = "APPSCLICK0001";

    /**
     * 商户后台-账户管理-获取商户信息
     */
    public static final String A_PARTNER_INFO = "PARTNER0001";

    /**
     * 商户后台-账户管理-充值(生成记录)
     */
    public static final String A_PARTNER_RECHARGE_RECORD = "PARTNER0002";

    /**
     * 商户后台-账户管理-提现(生成记录)
     */
    public static final String A_PARTNER_WITHDRAW_RECORD = "PARTNER0003";

    /**
     * 商户后台-账户管理-充值(记录分页查询)
     */
    public static final String A_PARTNER_RECHARGE_LIST = "PARTNER0004";

    /**
     * 商户后台-账户管理-提现(记录分页查询)
     */
    public static final String A_PARTNER_WITHDRAW_LIST = "PARTNER0005";

    /**
     * 获取所有商户信息
     */
    public static final String A_PARTNER_ALL = "PARTNER0006";

    /**
     * 商户后台-报警设置-添加通知人
     */
    public static final String A_PARTNER_CONTACT_ADD = "PARTNER0007";

    /**
     * 商户后台-账单管理-费用统计(表格)
     */
    public static final String A_EVENT_FEE_STATISTIC_TABLE = "EVENT0001";

    /**
     * 商户后台-管理首页-UV统计
     */
    public static final String A_MANAGER_HOME_STATISTIC_UV = "MANAGER0001";

    /**
     * 商户后台-产品设置-获取产品列表
     */
    public static final String AP_PRODUCT_SETTING_LIST = "AP_PRODUCT_SETTING_LIST";

    /**
     * 商户后台-获取收款人列表
     */
    public static final String AP_PAYEE_LIST = "AP_PAYEE_LIST";

    /**
     * 商户后台-数据分析
     */
    public static final String AP_DATA_ANALYSIS = "AP_DATA_ANALYSIS";

    /**
     * 商户后台-财务结算-费用结算列表
     */
    public static final String AP_FINANCE_EXPENSE_TABLE = "AP_FINANCE_EXPENSE_TABLE";

    /**
     * 运营后台-短信管理-签名管理-新增签名
     */
    public static final String AO_SMS_MANAGER_SIGN_MANAGER_SIGN_ADD = "AO_SMS_MANAGER_SIGN_MANAGER_SIGN_ADD";

    /**
     * 运营后台-短信管理-模板管理-模板添加
     */
    public static final String AO_SMS_TEMPLATE_TEMPLATE_MANAGER_TEMPLATE_ADD = "AO_SMS_TEMPLATE_TEMPLATE_MANAGER_TEMPLATE_ADD";

    /**
     * 运营后台-短信管理-通道管理-通道添加
     */
    public static final String AO_SMS_CHANNEL_CHANNEL_MANAGER_CHANNEL_ADD =
            "AO_SMS_CHANNEL_CHANNEL_MANAGER_CHANNEL_ADD";

    /**
     * 运营后台-获取所有短信通道
     */
    public static final String AO_SMS_CHANNEL_ALL = "AO_SMS_CHANNEL_ALL";

    /**
     * 运营后台-获取所有短信通道
     */
    public static final String AO_SMS_SIGN_ALL = "AO_SMS_SIGN_ALL";

    /**
     * 运营后台-产品管理-产品添加/修改
     */
    public static final String AO_PRODUCT_MANAGER_PRODUCT_ADD_MODIFY = "AO_PRODUCT_MANAGER_PRODUCT_ADD_MODIFY";

    /**
     * 运营后台-产品管理-获取产品列表
     */
    public static final String AO_PRODUCT_MANAGER_PRODUCT_LIST = "AO_PRODUCT_MANAGER_PRODUCT_LIST";

    /**
     * 运营后台-产品管理-获取产品详情
     */
    public static final String AO_PRODUCT_MANAGER_PRODUCT_DETAIL = "AO_PRODUCT_MANAGER_PRODUCT_DETAIL";

    /**
     * 运营后台-产品管理-产品上下线
     */
    public static final String AO_PRODUCT_MANAGER_PRODUCT_UPPER_AND_LOWER_LINE = "AO_PRODUCT_MANAGER_PRODUCT_UPPER_AND_LOWER_LINE";

    /**
     * 运营后台-产品管理-产品删除
     */
    public static final String AO_PRODUCT_MANAGER_PRODUCT_DELETE = "AO_PRODUCT_MANAGER_PRODUCT_DELETE";

    /**
     * 运营后台-费用管理-机构费用列表
     */
    public static final String AO_COST_MANAGER_PARTNER_COST_LIST = "AO_COST_MANAGER_PARTNER_COST_LIST";

	/**
	 * 运营后台-产品管理-精选爆款列表
	 */
	public static final String AO_PRODUCT_MANAGER_PRODUCT_HOT_LIST = "AO_PRODUCT_MANAGER_PRODUCT_HOT_LIST";

	/**
	 * 运营后台-产品管理-精选爆款编辑
	 */
	public static final String AO_PRODUCT_MANAGER_PRODUCT_HOT_EDIT = "AO_PRODUCT_MANAGER_PRODUCT_HOT_EDIT";

    /**
     * 运营后台-获取所有产品名
     */
    public static final String AO_PRODUCT_NAME_ALL = "AO_PRODUCT_NAME_ALL";
}
