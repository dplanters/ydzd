package com.gndc.admin.api.admin.sms;

import com.gndc.common.api.RequestMessage;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AOSmsRealTimeSendRequest extends RequestMessage {

    /**
     * 用户来源1条件筛选 2导入
     */
    @NotNull
    private Byte sourceType;

    /**
     * 渠道id 1创蓝2大汉三通
     */
    @NotNull
    private Integer channelId;

    /**
     * 条件id
     */
    private Integer conditionId;

    /**
     * 签名id
     */
    @NonNull
    private Integer[] smsSignIds;

    /**
     * 模板id
     */
    @NonNull
    private Integer templateId;

    /**
     * 运营商id
     */
    @NonNull
    private Integer[] operatorIds;

    /**
     * 电话
     */
    private String[] phones;

}
