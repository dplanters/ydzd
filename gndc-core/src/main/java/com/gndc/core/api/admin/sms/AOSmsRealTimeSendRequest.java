package com.gndc.core.api.admin.sms;

import com.gndc.core.api.common.RequestMessage;
import com.gndc.core.model.SmsSign;
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
    private Byte channelId;

    /**
     * 条件id
     */
    private Integer conditionId;

    /**
     * 签名id
     */
    @NonNull
    private Integer smsSignIds[];

    /**
     * 模板id
     */
    @NonNull
    private Integer templateId;

    /**
     * 运营商id
     */
    @NonNull
    private Integer operatorId[];

    /**
     * 电话，",隔开（15800000000,15300000000）
     */
    private String phones;

}
