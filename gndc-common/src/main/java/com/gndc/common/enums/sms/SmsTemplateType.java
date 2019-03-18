/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.common.enums.sms;

import com.gndc.common.constant.Constant;
import com.gndc.common.enums.common.CountryTypeEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * 短信模版
 *
 * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
 * @version V1.0.1
 * @Description
 * @date 2018年3月24日 下午8:45:57
 */
public enum SmsTemplateType {

    USER_LOGIN((byte) 1, "【77鱼塘】您好,您的验证码是{0}", "kode verifikasi: {0}, 5 menit berlaku, mohon verifikasi segera",
            "Mã xác minh:{0},Hết hạn sau 5 phút, không tiết lộ", "Verification code：{0}, valid for 5 minutes"),

    USER_FORGET_PWD((byte) 3, "【77鱼塘】您好,您的验证码是{0},您正在找回密码嘘~千万别告诉别人。",
            "kode verifikasi: {0}, 5 menit berlaku, mohon verifikasi segera",
            "Mã xác minh:{0},Hết hạn sau 5 phút, không tiết lộ", "Verification code：{0}, valid for 5 minutes"),

    // 修改手机验证码，目前和注册模板相同
    USER_MODIFY_PHONE((byte) 4, "您的验证码为{0}，5分钟内有效。", "kode verifikasi: {0}, 5 menit berlaku, mohon verifikasi segera",
            "Mã xác minh của bạn là {0}, hợp lệ trong 5 phút.", "Verification code：{0}, valid for 5 minutes"),

    // 银行卡绑定验证码
    BANK_BIND((byte) 5, "您的验证码为{0}，您的银行卡正在互金网络平台开通绑定，请勿泄露。",
            "kode verifikasi: {0}, 5 menit berlaku, mohon verifikasi segera",
            "Mã xác minh của bạn là {0}, hợp lệ trong 5 phút.", "Verification code：{0}, valid for 5 minutes"),

    NOTIFY((byte) 6,
            "Pinjaman Anda kadaluarsa hari ini, tolong bayar tepat waktu! Pelunasan silahkan masuk ke APP - klik <My - My Order - Immediate Repayment>",
            "Pinjaman Anda kadaluarsa hari ini, tolong bayar tepat waktu! Pelunasan silahkan masuk ke APP - klik <My - My Order - Immediate Repayment>",
            "Đơn đặt hàng của bạn đã hết hạn. Vui lòng xử lý đơn hàng ngay !",
            "You loan will be overdue today, please repay in time. You can repay under \"my order\" ."),

    // 还款失败
    REFUND_FAIL((byte) 7,
            "Perhatian, pembayaran pesanan anda gagal, silahkan kembali melakukan pengembalian dana! Dapat menghubungi layanan pelanggan{0}",
            "peringatan ,pembayaran pinjaman anda gagal ,silahkan ulang kembali melakukan pengembalian dana! Dapat menghubungi customer services kami di {0}",
            "Xin lưu ý ,đơn đặt hàng của bạn hoàn trả không thành công. Vui lòng trả lại! Có thể liên hệ với dịch vụ khách hàng {0}",
            "Attention! Your loan repayment failed. Please repay again! For details, please contact our customer serivce {0}."),

    // 还款提醒 1天
    REFUND_AMOUNT_WARN_ONE((byte) 8,
            "Pinjaman anda akan jatuh tempo besok, mohon dapat mengembalikan dana tepat waktu! Pembayaran dapat dilakukan dalam \"Pesananku\"",
            "Pinjaman anda akan jatuh tempo besok, mohon untuk pengembalian dana pada tepat waktu! Pembayaran dapat dilakukan dalam \"Pinjaman\"",
            "Khoản vay của bạn sẽ hết hạn vào ngày mai. Vui lòng hoàn trả khoản vay đúng hạn! Trả nợ có thể được thực hiện trong ' Đơn đặt hàng của tôi'",
            "You loan will be overdue by romorrow, please repay in time. You can repay under \"my order\" ."),

    // 还款提醒 当天
    REFUND_AMOUNT_WARN_TODAY((byte) 9,
            "Pinjaman anda akan jatuh tempo hari ini, mohon dapat mengembalikan dana tepat waktu! Pembayaran dapat dilakukan dalam \"Pesananku\"",
            "Pinjaman anda akan jatuh tempo hari ini, mohon untuk pengembalian dana pada tepat waktu! Pembayaran dapat dilakukan dalam \"Pinjaman\"",
            "Khoản vay của bạn sẽ hết hạn vào hôm nay. Vui lòng hoàn trả khoản vay của bạn! Trả nợ có thể được thực hiện trong Đơn đặt hàng của tôi",
            "You loan will be overdue today, please repay in time. You can repay under \"my order\" ."),

    // 逾期短信 1天
    OVERDUVE_WARN_ONE((byte) 10,
            "Pinjaman anda sudah lewat tempo, mohon segera melakukan pengembalian dana! Jika ada masalah segera hubungi layanan pelanggan {0}",
            "Pinjaman anda sudah lewat tempo, mohon segera melakukan pengembalian dana! Jika ada masalah segera hubungi customer service kami di {0}",
            "Khoản vay của bạn đã hết hạn. Vui lòng hoàn trả ngay ! Nếu bạn có  câu hỏi gì, xin vui lòng liên hệ với dịch vụ khách hàng kịp thời{0}.",
            "Your loan is overdue, please repay immediately. Any questions, please contact our contomer service {0}."),

    // 逾期短信2天
    OVERDUVE_WARN_TWO((byte) 11,
            "Pinjaman anda sudah lewat tempo 2 hari, mohon segera melakukan pengembalian dana! Jika ada masalah segera hubungi layanan pelanggan {0}",
            "Pinjaman anda sudah lewat tempo 2 hari, mohon segera melakukan pengembalian dana! Jika ada masalah segera hubungi customer service {0}",
            "Khoản vay của bạn đã hết hạn 2 ngày. Vui lòng hoàn trả lại ngay ! Nếu bạn có  câu hỏi gì, xin vui lòng liên hệ với dịch vụ khách hàng kịp thời{0}.",
            "Your loan has been overdue for 2 day, please repay immediately. Any questions, please contact our contomer service {0}."),

    // 逾期短信3天
    OVERDUVE_WARN_THREE((byte) 12,
            "Pinjaman anda sudah lewat tempo 3 hari, mohon segera melakukan pengembalian dana! Jika ada masalah segera hubungi layanan pelanggan {0}",
            "Pinjaman anda sudah lewat tempo 3 hari, mohon segera melakukan pengembalian dana! Jika ada masalah segera hubungi layanan pelanggan {0}",
            "Khoản vay của bạn đã hết hạn 3 ngày. Vui lòng hoàn trả lại ngay ! Không ảnh hưởng đến tín dụng, nếu bạn có câu hỏi gì, xin vui lòng liên hệ với dịch vụ khách hàng kịp thời{0}.",
            "Your loan has been overdue for 3 day, please repay immediately to protect your credit. Any questions, please contact our contomer service {0}."),

    COLLECTION((byte) 13, "催收模版短信", "催收模版短信", "催收模版短信", ""),

    MARKET((byte) 14, "营销类短信", "营销类短信", "营销类短信", ""),
    ;

    private static final Map<Byte, SmsTemplateType> map;

    static {
        map = new HashMap<>();
        for (SmsTemplateType as : values()) {
            map.put(as.code, as);
        }
    }

    // 短信类型
    private byte code;
    // 短信模板
    private String CNContent;// 中文版本
    private String IDContent;// 印尼内容
    private String VNContent;// 印尼内容
    private String PHContent;// 印尼内容

    private SmsTemplateType(byte code, String CNContent, String IDContent, String VNContent, String PHContent) {
        this.code = code;
        this.CNContent = CNContent;
        this.IDContent = IDContent;
        this.VNContent = VNContent;
        this.PHContent = PHContent;
    }

    /**
     * 根据编码获取状态
     *
     * @param code
     * @return
     */
    public static SmsTemplateType fetch(byte code) {
        return map.get(code);
    }

    /**
     * 根据编码获取名称
     *
     * @param code
     * @return
     */
    public static String fetchCNContent(byte code) {
        SmsTemplateType as = map.get(code);
        return as != null ? as.CNContent : null;
    }

    /**
     * 根据编码获取显示名
     *
     * @param code
     * @return
     */
    public static String fetchIDContent(byte code) {
        SmsTemplateType as = map.get(code);
        return as != null ? as.IDContent : null;
    }

    public static String fetchVNContent(byte code) {
        SmsTemplateType as = map.get(code);
        return as != null ? as.VNContent : null;
    }

    public static String fetchPHContent(byte code) {
        SmsTemplateType as = map.get(code);
        return as != null ? as.PHContent : null;
    }

    public byte getCode() {
        return code;
    }

    public void setCode(byte code) {
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
