package com.gndc.common.utils;

/**
 * Redis key
 *
 * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
 * @version V1.0.1
 * @Description
 * @date 2017年10月13日 下午2:39:38
 */
public final class RedisKey {

    /**
     * 地区Map Key
     */
    public static final String AREA_MAP_KEY = "AREA_MAP_KEY";

    /**
     * 所有包含首字母的城市列表 格<Map<String, List<AREA>>
     */
    public static final String AREA_KEY_ALLCITY_WITHCHAR = "AREA_KEY_ALLCITY_WITHCHAR";

    /**
     * 所有父级城市下级城市列表 格式 Map<Integer, List<AREA>
     */
    public static final String AREA_KEY_CITYLIST_BY_PCODE = "AREA_KEY_CITYLIST_BY_PCODE";

    /**
     * 角色键对象
     */
    public static final String roleKey = "Role_";

    /**
     * 所有权限map <Map<Integer, Right>
     **/
    public static final String RIGHT_KEY_ALL_MAP = "RIGHT_KEY_ALL_MAP";

    /**
     * 所有父级权限下级权限列表 格式 Map<Integer, List<Right>
     */
    public static final String RIGHT_KEY_RIGHTLIST_BY_PID = "RIGHT_KEY_RIGHTLIST_BY_PID";

    /**
     * 所有系统配置项
     **/
    public static final String SYSOPTIN_KEY_ALL = "SYSOPTIN_KEY_ALL";

    /**
     * 所有数据字典map Map<String, Dictionary>
     */
    public static final String DICT_KEY_ALL_MAP = "DICT_KEY_ALL_MAP";

    public static final String DICT_KEY_ALL_MAP_ALLSTATUS = "DICT_KEY_ALL_MAP_ALLSTATUS";

    /**
     * 所有父级权限下级配置表列表 格式 Map<String, List<Dictionary>
     */
    public static final String DICT_KEY_DICTLIST_BY_PID = "DICT_KEY_DICTLIST_BY_PID";
}
