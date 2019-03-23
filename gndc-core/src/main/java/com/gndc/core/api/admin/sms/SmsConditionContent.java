package com.gndc.core.api.admin.sms;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class SmsConditionContent implements Serializable {

    private static final long serialVersionUID = 6274410745423655224L;

    /**
     * 营销条件0-未定义 1-营销类 2-催收类 3-提醒类 4-通知类
     */
    private Byte conditionType;
    /*******************营销类****************/
    /**
     * 营销事件1登录 2注册
     */
    private Byte marketingType;
    /**
     * 营销时间
     */
    private Integer marketingTime;
    /**
     * 营销时间单位1日2月
     */
    private Byte marketingUnit;
    /*******************营销类****************/
    /*******************催收类****************/
    /**
     * 催收时间
     */
    private Integer collectionTime[];
    /**
     * 催收时间单位1日2月
     */
    private Byte collectionUnit;
    /*******************催收类****************/
    /*******************提醒类****************/
    /**
     * 提醒时间
     */
    private Integer remindTime[];
    /**
     * 提醒时间单位1日2月
     */
    private Byte remindUnit;
    /*******************提醒类****************/
    /*******************通知类****************/
    /**
     * 通知事件1当日放款成功 2当日申请成功
     */
    private Byte noticeType;
    /*******************通知类****************/
}
