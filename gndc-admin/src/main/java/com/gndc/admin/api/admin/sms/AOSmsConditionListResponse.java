package com.gndc.admin.api.admin.sms;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class AOSmsConditionListResponse implements Serializable {

    /**
     * id
     */
    private Integer id;

    /**
     * 类型 0-未定义 1-营销类 2-催收类 3-提醒类 4-通知类
     */
    private Byte type;

    /**
     * 创建时间开始
     */
    private String createTime;

    /**
     * 创建人
     */
    private String name;
    /**
     * 条件(json)
     */
    private String condition;
    /**
     * 条件(内容)
     */
    private String conditionText;
}
