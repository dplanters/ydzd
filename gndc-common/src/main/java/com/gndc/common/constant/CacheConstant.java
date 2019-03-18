package com.gndc.common.constant;

public class CacheConstant {

    /**
     * redis永不失效
     */
    public static final Long NO_EXPIRE = -1L;

    /**
     * 运营管理员登录前缀
     */
    public static final String KEY_ADMIN_LOGIN_PREFIX = "admin_";

    /**
     * 运营管理员登录过期时间
     */
    public static final Long EXPIRE_ADMIN_LOGIN = 30 * 60L;

    /**
     * 商户管理员登录前缀
     */
    public static final String KEY_PARTNER_LOGIN_PREFIX = "partner_";

    /**
     * 商户管理员登录过期时间
     */
    public static final Long EXPIRE_PARTNER_LOGIN = 30 * 60L;

    /**
     * APP用户登录前缀
     */
    public static final String KEY_USER_LOGIN_PREFIX = "user_";

    /**
     * APP用户登录过期时间-90天
     */
    public static final Long EXPIRE_USER_LOGIN = 90 * 24 * 60 * 60L;

    /**
     * redis中存所有角色的key
     */
    public static final String KEY_ALL_ROLE = "all_role";

    /**
     * redis中存所有权限的key
     */
    public static final String KEY_ALL_RIGHT = "all_right";

    /**
     * redis中存所有角色权限的key
     */
    public static final String KEY_ALL_ROLE_RIGHT = "all_role_right";

    /**
     * APP用户10分钟短信验证前缀
     */
    public static final String KEY_USER_SMS_10_PREFIX = "10m_";

    /**
     * APP用户10分钟短信验证过期时间-10分钟
     */
    public static final Long EXPIRE_USER_SMS_10 = 10 * 60L;

    /**
     * APP用户1小时短信验证前缀
     */
    public static final String KEY_USER_SMS_24H_PREFIX = "24h_";

    /**
     * APP用户1小时短信验证过期时间-1小时
     */
    public static final Long EXPIRE_USER_SMS_24H = 24 * 60 * 60L;

    /**
     * APP用户短信内容前缀
     */
    public static final String KEY_USER_SMS_15M_PREFIX = "15m_";

    /**
     * APP用户短信内容前缀过期时间15分钟
     */
    public static final Long EXPIRE_USER_SMS_15M = 15 * 60L;
}
