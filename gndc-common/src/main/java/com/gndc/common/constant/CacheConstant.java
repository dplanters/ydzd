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
     * APP用户登录过期时间
     */
    public static final Long EXPIRE_USER_LOGIN = 30 * 60L;

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
}
