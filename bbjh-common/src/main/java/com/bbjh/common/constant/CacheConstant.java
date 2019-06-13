package com.bbjh.common.constant;

public class CacheConstant {

    /**
     * redis永不失效
     */
    public static final Long NO_EXPIRE = -1L;

    /**
     * 运营管理员登录命名空间
     */
    public static final String NAMESPACE_ADMIN_LOGIN = "admin:";

    /**
     * 运营管理员登录过期时间
     */
    public static final Long EXPIRE_ADMIN_LOGIN = 30 * 60L;


    /**
     * APP用户登录命名空间
     */
    public static final String NAMESPACE_USER_LOGIN = "user:";

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
     * 疫苗库存变化锁
     * key:vaccine_change_lock:{uid}
     */
    public static final String KEY_VACCINE_CHANGE_LOCK = "vaccine_change_lock:{}";
}
