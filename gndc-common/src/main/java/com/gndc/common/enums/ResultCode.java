/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.common.enums;

import com.gndc.common.constant.Constant;
import com.gndc.common.enums.common.CountryTypeEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回码枚举类
 * 说明
 * 0为成功
 * 响应码为1+5+2
 * 第一位为异常级别：1：系统级别；2：业务级别
 * 中间五位为业务编号如：00002为登录相关业务
 * 最后2两位为具体业务下具体的异常码
 * 组合起来如10000102位session过期异常
 */
public enum ResultCode {
    
    // 成功
    OK(0, "成功", "Berhasil", "Thành công", "Success"),
    // 1 系统返回码部分
    /**
     * 0001为通用业务
     * 用来表示未知错误
     */
    SYSTEM_BUSY(1000101, "系统繁忙", "系统繁忙", "系统繁忙", "系统繁忙"),

    PARAMETER_CHECK_FAIL(1000102, "参数校验失败", "参数校验失败", "参数校验失败", "参数校验失败"),

    /**
     * 用来表示 404
     */
    NOT_FOUND(1000103, "资源不存在", "资源不存在", "资源不存在", "资源不存在"),

    /**
     * 用来表示权限没有在系统当中配置
     */
    RIGHT_NOT_INITIALISE(1000104, "权限没有配置", "权限没有配置", "权限没有配置", "权限没有配置"),

    /**
     * 表示解密失败
     */
    DECRYPT_ERROR(1000105, "解密失败", "解密失败", "解密失败", "解密失败"),

    /**
     * 发送http请求发生异常
     */
    HTTP_EXCEPTION(1000106, "请求错误", "请求错误", "请求错误", "请求错误"),

    /**
     * 0002为登录相关业务
     */
    NO_SESSION(1000201, "缺少sessionId", "缺少sessionId", "缺少sessionId", "缺少sessionId"),

    SESSION_EXPIRED(1000202, "SessionId已过期", "SessionId已过期", "SessionId已过期", "SessionId已过期"),

    INVALID_SESSION(1000203, "无效的sessionId", "无效的sessionId", "无效的sessionId", "无效的sessionId"),

    NOT_ALLOW_LOGIN(1000204, "不允许登录", "不允许登录", "不允许登录", "不允许登录"),

    ADMIN_NOT_EXIST(1000205, "账号不存在", "账号不存在", "账号不存在", "账号不存在"),

    PASSWORD_ERROR(1000206, "密码错误", "密码错误", "密码错误", "密码错误"),
    /**
     * 设备类型为空
     */
    DEVICE_TYPE_ISNULL(1000207, "设备类型为空", "Jenis peralatan kosong", "Loại thiết bị trống", "Blank device type"),
    /**
     * 手机终端类型为空
     */
    TERM_TYPE_ISNULL(1000208, "手机终端类型为空", "Jenis akhir ponsel kosong", "Loại thiết bị đầu cuối điện thoại trống",
            "Blank phone terminal type"),
    /**
     * 设备IMEI不能为空
     */
    IMEI_TOKEN_ISNULL(1000209, "设备IMEI不能为空", "IMEI peralatan tidak boleh kosong", "thiết bị IMEI  không được rỗng",
            "Device IMEI can not be blank"),
    /**
     * 用户已锁定
     */
    USER_DISABLED(1000210, "用户已锁定", "用户已锁定", "用户已锁定", "用户已锁定"),
    /**
     * 用户名或密码错误
     */
    USER_NAME_PASSWORD_ERROR(1000211, "用户名或密码错误", "Nama pelanggan atau kata sandi salah",
            "Tên người dùng hoặc mật khẩu không chính xác", "Wrong user's name or password"),

    /**
     * 0003
     */
    NO_PERMISSION(1000301, "没有权限", "没有权限", "没有权限", "没有权限"),

     // 2 业务返回码部分
    /**
     * 0001为通用业务
     */
    RECORD_NOT_EXIST(2000101, "记录不存在", "记录不存在", "记录不存在", "记录不存在"),

    RECORD_SAVE_FAIL(2000102, "记录保存失败", "记录保存失败", "记录保存失败", "记录保存失败"),

    RECORD_MODIFY_FAIL(2000103, "记录修改失败", "记录修改失败", "记录修改失败", "记录修改失败"),

    RECORD_DELETE_FAIL(2000104, "记录删除失败", "记录删除失败", "记录删除失败", "记录删除失败"),

    RECORD_EXIST(2000105, "记录已经存在", "记录已经存在", "记录已经存在", "记录已经存在"),

    /**
     * 0002为账号相关
     */
    ADMIN_EXIST(2000201, "账号已存在", "账号已存在", "账号已存在", "账号已存在"),
    /**
     * 用户不存在
     */
    USER_NOT_EXISTS(2000202, "用户不存在", "用户不存在", "用户不存在", "用户不存在"),
    /**
     * 用户已存在
     */
    USER_EXISTS(2000203, "用户已存在", "Pengguna telah ada", "Người dùng đã tồn tại", "The user existed already "),
    /**
     * 密码不一致
     */
    CONFIRM_PASSWORD_ERROR(2000204, "密码不一致", "Kata sandi tidak sesuai", "Mật khẩu không nhất quán",
            "Inconsistant password"),
    /**
     * 原密码错误
     */
    OLD_PASSWORD_ERROR(2000205, "原密码错误", "Kata sandi sebelumnya salah", "Lỗi mật khẩu ban đầu", "Wrong old password"),

    /**
     * 00003为角色相关业务
     */
    ROLE_NOT_EXIST(2000301, "角色不存在", "Peran tidak ada", "Vai trò không tồn tại", "This role does not exist"),

    ROLE_HAS_NORMAL_ADMIN(2000302, "角色下存在正常用户,请先删除相关用户", "角色下存在正常用户,请先删除相关用户", "角色下存在正常用户,请先删除相关用户", "角色下存在正常用户," +
            "请先删除相关用户"),
    ROLENAME_EXISTS(2000303, "角色名已经存在", "Nama peran telah ada", "Tên vai trò đã tồn tại", "The role name existed already"),
    /**
     * 0004为权限管理相关
     */
    RIGHT_IS_USING(2000401, "权限在使用，请先取消相关角色授权后再进行删除", "权限在使用，请先取消相关角色授权后再进行删除", "权限在使用，请先取消相关角色授权后再进行删除", "权限在使用，请先取消相关角色授权后再进行删除"),

    RIGHT_HAS_CHILDREN(2000402, "权限存在子权限，请先删除子权限后后再进行删除", "权限存在子权限，请先删除子权限后后再进行删除", "权限存在子权限，请先删除子权限后后再进行删除", "权限存在子权限，请先删除子权限后后再进行删除"),

    /**
     * 0005为产品相关
     */
    PRODUCT_ONLINE(2000501, "产品在线，请下线产品后再删除", "", "", ""),

    PRODUCTS_NOT_ONLINE(2000502, "未上线的产品", "未上线的产品", "", ""),

    /**
     * 0006为短信相关
     */
    SIGN_NOT_EXIST(2000601, "签名不存在", "", "", ""),
    TEMPLATE_NOT_EXIST(2000602, "模板不存在", "", "", ""),
    CONDITION_NOT_EXIST(2000603, "条件不存在", "", "", ""),
    SMS_ILLEGAL_DATE(2000604, "配置不合法", "", "", ""),
    SMS_ILLEGAL_CRON(2000605, "cron表达式不正确", "", "", ""),
    /**
     * 10分钟内只能发送3条短信
     */
    AUTH_COUNT_TEN_LIMIT(2000606, "10分钟内只能发送3条短信", "Hanya dapat kirim 3 pesan dalam waktu 10 menit",
            "Chỉ có thể gửi 3 tin nhắn  trong vòng 5 phút", "You can have only 3 SMS in 5 minutes"),
    /**
     * 验证码失效，请重新获取
     */
    AUTH_INVALID(2000607, "验证码失效，请重新获取", "Kode verifikasi tidak valid, silahkan ambil kembali",
            "Mã xác minh không hợp lệ, vui lòng lấy lại", "Unvalid verification code, please request again"),
    /**
     * 验证码错误
     */
    AUTH_ERROR(2000608, "验证码错误", "Kode verifikasi salah", "Lỗi mã xác minh", "Wrong verification code"),
    /**
     * 验证码输错次数过多
     */
    AUTH_FAIL_COUNT(2000609, "验证码输错次数过多", "Input kode verifikasi salah banyak kali", "xác minh quá nhiều lần lỗi",
            "  Too many errors"),
    /**
     * 24小时内只能发送10条同类短信
     */
    AUTH_COUNT_24_HOUR(2000610, "24小时内只能发送10条同类短信", "24小时内只能发送10条同类短信", "24小时内只能发送10条同类短信", "24小时内只能发送10条同类短信"),
    ;

    /**
     * 返回码MAP
     */
    private static final Map<Integer, ResultCode> map;

    static {
        map = new HashMap<>();
        for (ResultCode as : values()) {
            map.put(as.code, as);
        }
    }

    // 成员变量
    private Integer code; // 编码
    private String CNContent;// 中文版本
    private String IDContent;// 印尼内容
    private String VNContent;// 越南内容
    private String PHContent;// 菲率宾内容

    private ResultCode(Integer code, String CNContent, String IDContent, String VNContent, String PHContent) {
        this.code = code;
        this.CNContent = CNContent;
        this.IDContent = IDContent;
        this.VNContent = VNContent;
        this.PHContent = PHContent;
    }

    public static ResultCode getType(int code) {
        if (code <= 0) {
            return null;
        }
        for (ResultCode resultCode : ResultCode.values()) {
            if (resultCode.code == code) {
                return resultCode;
            }
        }
        return null;
    }

    /**
     * 根据编码获取状态
     *
     * @param code
     * @return
     */
    public static ResultCode fetch(int code) {
        return map.get(code);
    }

    /**
     * 根据编码获取名称
     *
     * @param code
     * @return
     */
    public static String fetchCNContent(int code) {
        ResultCode as = map.get(code);
        return as != null ? as.CNContent : null;
    }

    /**
     * 根据编码获取显示名
     *
     * @param code
     * @return
     */
    public static String fetchIDContent(int code) {
        ResultCode as = map.get(code);
        return as != null ? as.IDContent : null;
    }

    public static String fetchVNContent(int code) {
        ResultCode as = map.get(code);
        return as != null ? as.VNContent : null;
    }

    public static String fetchPHContent(int code) {
        ResultCode as = map.get(code);
        return as != null ? as.PHContent : null;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getCNContent() {
        return CNContent;
    }

    public void setCNContent(String CNContent) {
        this.CNContent = CNContent;
    }

    public String getIDContent() {
        return IDContent;
    }

    public void setIDContent(String IDContent) {
        this.IDContent = IDContent;
    }

    public String getVNContent() {
        return VNContent;
    }

    public void setVNContent(String VNContent) {
        this.VNContent = VNContent;
    }

    public String getPHContent() {
        return PHContent;
    }

    public void setPHContent(String PHContent) {
        this.PHContent = PHContent;
    }

    /**
     * 国际语言返回
     *
     * @return
     * @Description
     * @author <a href="jiangxin8116@adpanshi.com">jiangxin</a>
     */
    public String getI18NContent() {

        if (Constant.COUNTRY.equals(CountryTypeEnum.INDONESIA.getCode())) {
            return IDContent;
        } else if (Constant.COUNTRY.equals(CountryTypeEnum.VIETNAM.getCode())) {
            return VNContent;
        } else if (Constant.COUNTRY.equals(CountryTypeEnum.PHILIPPINES.getCode())) {
            return PHContent;
        }
        return CNContent;
    }

}
