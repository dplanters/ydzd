/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.common.enums.admin;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
 * @version V1.0.1
 * @Description 权限列表
 * @date 2018年1月24日 下午4:46:30
 */
public enum RightType {

    MENU_WORKS(10, "MENU_WORKS", "工作台"),

    RIGHT_WORKS_DAY(1001, "RIGHT_WORKS_DAY", "今日数据"),

    RIGHT_WORKS_ALL(1002, "RIGHT_WORKS_ALL", "累计数据"),

    MENU_USER(11, "MENU_USER", "用户管理"),

    MENU_USER_LIST(1101, "MENU_USER_LIST", "用户列表"),

    RIGHT_USER_LIST_QUERY(110101, "RIGHT_USER_LIST_QUERY", "查询"),

    RIGHT_USER_LIST_EXP(110102, "RIGHT_USER_LIST_EXP", "导出"),

    RIGHT_USER_LIST_LIST(110103, "RIGHT_USER_LIST_LIST", "列表"),

    RIGHT_USER_LIST_DETAIL(110104, "RIGHT_USER_LIST_DETAIL", "详细"),

    MENU_CUSTOMER_SERVICE(12, "MENU_CUSTOMER_SERVICE", "客服管理"),

    MENU_USER_FEEDBACK(1201, "MENU_USER_FEEDBACK", "用户反馈列表"),

    RIGHT_USER_FEEDBACK_QUERY(120101, "RIGHT_USER_FEEDBACK_QUERY", "查询"),

    RIGHT_USER_FEEDBACK_EXP(120102, "RIGHT_USER_FEEDBACK_EXP", "导出"),

    RIGHT_USER_FEEDBACK_LIST(120103, "RIGHT_USER_FEEDBACK_LIST", "列表"),

    RIGHT_USER_FEEDBACK_SHOW(120104, "RIGHT_USER_FEEDBACK_SHOW", "查看"),

    RIGHT_USER_FEEDBACK_REPLY(120105, "RIGHT_USER_FEEDBACK_REPLY", "反馈"),

    MENU_CUSTOMER_SERVICE_VISIT(1202, "MENU_CUSTOMER_SERVICE_VISIT", "电话来访记录"),

    RIGHT_CUSTOMER_SERVICE_VISIT_QUERY(120201, "RIGHT_CUSTOMER_SERVICE_VISIT_QUERY", "查询"),

    RIGHT_CUSTOMER_SERVICE_VISIT_LIST(120202, "RIGHT_CUSTOMER_SERVICE_VISIT_LIST", "列表"),

    RIGHT_CUSTOMER_SERVICE_VISIT_ADD(120203, "RIGHT_CUSTOMER_SERVICE_VISIT_ADD", "添加"),

    RIGHT_CUSTOMER_SERVICE_VISIT_ADD_SUBMIT(120204, "RIGHT_CUSTOMER_SERVICE_VISIT_ADD_SUBMIT", "添加提交"),

    RIGHT_CUSTOMER_SERVICE_VISIT_SHOW(120205, "RIGHT_CUSTOMER_SERVICE_VISIT_SHOW", "查看"),

    MENU_SYSTEM(13, "MENU_SYSTEM", "系统管理"),

    MENU_SYSTEIM_USER(1301, "MENU_SYSTEIM_USER", "账号管理"),

    RIGHT_SYSTEIM_USER_QUERY(130101, "RIGHT_SYSTEIM_USER_QUERY", "查询"),

    RIGHT_SYSTEIM_USER_LIST(130102, "RIGHT_SYSTEIM_USER_LIST", "列表"),

    RIGHT_SYSTEIM_USER_REST(130103, "RIGHT_SYSTEIM_USER_REST", "密码重置"),

    RIGHT_SYSTEIM_USER_DEL(130104, "RIGHT_SYSTEIM_USER_DEL", "注销"),

    RIGHT_SYSTEIM_USER_ADD(130105, "RIGHT_SYSTEIM_USER_ADD", "添加账号"),

    RIGHT_SYSTEIM_USER_EDIT(130106, "RIGHT_SYSTEIM_USER_EDIT", "修改账号"),

    MENU_SYSTEM_RIGHT(1302, "MENU_SYSTEM_RIGHT", "权限分配"),

    RIGHT_SYSTEM_RIGHT_ADD(130201, "RIGHT_SYSTEM_RIGHT_ADD", "添加角色"),

    RIGHT_SYSTEM_RIGHT_QUERY(130202, "RIGHT_SYSTEM_RIGHT_QUERY", "查询"),

    RIGHT_SYSTEM_RIGHT_LIST(130203, "RIGHT_SYSTEM_RIGHT_LIST", "列表"),

    RIGHT_SYSTEM_RIGHT_EDIT(130204, "RIGHT_SYSTEM_RIGHT_EDIT", "修改"),

    RIGHT_SYSTEM_RIGHT_DEL(130205, "RIGHT_SYSTEM_RIGHT_DEL", "删除"),

    MENU_PLATFORM(14, "MENU_PLATFORM", "平台管理"),

    MENU_PLATFORM_PROBLEM(1401, "MENU_PLATFORM_PROBLEM", "常见问题"),

    RIGHT_PLATFORM_PROBLEM_QUERY(140101, "RIGHT_PLATFORM_PROBLEM_QUERY", "查询"),

    RIGHT_PLATFORM_PROBLEM_ADD(140102, "RIGHT_PLATFORM_PROBLEM_ADD", "添加"),

    RIGHT_PLATFORM_PROBLEM_LIST(140103, "RIGHT_PLATFORM_PROBLEM_LIST", "列表"),

    RIGHT_PLATFORM_PROBLEM_EDIT(140104, "RIGHT_PLATFORM_PROBLEM_EDIT", "修改"),

    RIGHT_PLATFORM_PROBLEM_DEL(140105, "RIGHT_PLATFORM_PROBLEM_DEL", "删除"),

    MENU_PLATFORM_PRODUCTHOT(1402, "MENU_PLATFORM_PRODUCTHOT", "首页热推"),

    RIGHT_PLATFORM_PRODUCTHOT_QUERY(140201, "RIGHT_PLATFORM_PRODUCTHOT_QUERY", "查询"),

    RIGHT_PLATFORM_PRODUCTHOT_ADD(140202, "RIGHT_PLATFORM_PRODUCTHOT_ADD", "添加"),

    RIGHT_PLATFORM_PRODUCTHOT_LIST(140203, "RIGHT_PLATFORM_PRODUCTHOT_LIST", "列表"),

    RIGHT_PLATFORM_PRODUCTHOT_EDIT(140204, "RIGHT_PLATFORM_PRODUCTHOT_EDIT", "上下线"),

    RIGHT_PLATFORM_PRODUCTHOT_DEL(140205, "RIGHT_PLATFORM_PRODUCTHOT_DEL", "删除"),

    RIGHT_PLATFORM_PRODUCTHOT_SORT(140206, "RIGHT_PLATFORM_PRODUCTHOT_SORT", "调序"),

    MENU_OPERATE(15, "MENU_OPERATE", "运营管理"),

    MENU_OPERATE_CHANNEL(1501, "MENU_OPERATE_CHANNEL", "渠道数据"),

    RIGHT_OPERATE_CHANNEL_LIST(150101, "RIGHT_OPERATE_CHANNEL_LIST", "列表"),

    RIGHT_OPERATE_CHANNEL_QUERY(150102, "RIGHT_OPERATE_CHANNEL_QUERY", "查询"),

    RIGHT_OPERATE_CHANNEL_EXP(150103, "RIGHT_OPERATE_CHANNEL_EXP", "导出"),

    MENU_OPERATE_ADVERTIS(1502, "MENU_OPERATE_ADVERTIS", "广告设置"),

    RIGHT_OPERATE_ADVERTIS_QUERY(150201, "RIGHT_OPERATE_ADVERTIS_QUERY", "查询"),

    RIGHT_OPERATE_ADVERTIS_ADD(150202, "RIGHT_OPERATE_ADVERTIS_ADD", "添加"),

    RIGHT_OPERATE_ADVERTIS_LIST(150203, "RIGHT_OPERATE_ADVERTIS_LIST", "列表"),

    RIGHT_OPERATE_ADVERTIS_EDIT(150204, "RIGHT_OPERATE_ADVERTIS_EDIT", "修改"),

    RIGHT_OPERATE_ADVERTIS_UPDATE(150205, "RIGHT_OPERATE_ADVERTIS_UPDATE", "上下线"),

    RIGHT_OPERATE_ADVERTIS_DEL(150206, "RIGHT_OPERATE_ADVERTIS_DEL", "删除"),

    MENU_OPERATE_BANNER(1503, "MENU_OPERATE_BANNER", "banner设置"),

    RIGHT_OPERATE_BANNER_QUERY(150301, "RIGHT_OPERATE_BANNER_QUERY", "查询"),

    RIGHT_OPERATE_BANNER_ADD(150302, "RIGHT_OPERATE_BANNER_ADD", "添加"),

    RIGHT_OPERATE_BANNER_LIST(150303, "RIGHT_OPERATE_BANNER_LIST", "列表"),

    RIGHT_OPERATE_BANNER_EDIT(150304, "RIGHT_OPERATE_BANNER_EDIT", "修改"),

    RIGHT_OPERATE_BANNER_UPDATE(150305, "RIGHT_OPERATE_BANNER_UPDATE", "上下线"),

    RIGHT_OPERATE_BANNER_DEL(150306, "RIGHT_OPERATE_BANNER_DEL", "删除"),

    RIGHT_PLATFORM_BANNER_SORT(150307, "RIGHT_PLATFORM_BANNER_SORT", "调序"),

    MENU_PRODUCT(16, "MENU_PRODUCT", "产品"),

    PRODUCT_LIST(1601, "PRODUCT_LIST", "产品列表"),

    PRODUCT_DATA(1602, "PRODUCT_LIST", "产品数据"),

    PRODUCT_LIST_QUERY(160101, "PRODUCT_LIST_QUERY", "查询"),

    PRODUCT_LIST_ADD(160102, "PRODUCT_LIST_ADD", "添加产品"),

    PRODUCT_LIST_VIEW(160103, "PRODUCT_LIST_VIEW", "查看"),

    PRODUCT_LIST_OFFLINE(160104, "PRODUCT_LIST_OFFLINE", "下线"),

    PRODUCT_LIST_DELETE(160105, "PRODUCT_LIST_DELETE", "删除"),

    PRODUCT_LIST_EXPORT(160106, "PRODUCT_LIST_EXPORT", "导出"),

    PRODUCT_LIST_EDIT(160107, "PRODUCT_LIST_EDIT", "修改"),

    PRODUCT_LIST_ONLINE(160108, "PRODUCT_LIST_ONLINE", "上线"),

    PRODUCT_DATA_QUERY(160201, "PRODUCT_DATA_QUERY", "查询"),

    PRODUCT_DATA_EXPORT(160202, "PRODUCT_DATA_EXPORT", "导出"),

    MENU_FINANCE(17, "MENU_FINANCE", "财务结算"),

    BILL_MANAGER(1701, "BILL_MANAGER", "账单管理"),

    BILL_STATISTIC_TABLE(170101, "BILL_STATISTIC_TABLE", "账单统计表格"),
    ;

    private static final Map<String, RightType> map;

    static {
        map = new HashMap<>();
        for (RightType as : values()) {
            map.put(as.code, as);
        }
    }

    private int id;
    private String code;
    private String name;

    RightType(int id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    /**
     * 根据编码获取状态
     *
     * @param code
     * @return
     */
    public static RightType fetch(String code) {
        return map.get(code);
    }

    /**
     * 根据编码获取名称
     *
     * @param code
     * @return
     */
    public static String fetchName(String code) {
        RightType as = map.get(code);
        return as != null ? as.name : null;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
