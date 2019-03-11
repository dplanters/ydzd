package com.gndc.core.api.sms;

import com.gndc.common.api.HjAction;
import com.gndc.common.api.RequestMessage;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AOSmsTemplateAddRequest extends RequestMessage {

    /**
     * 签名ID
     */
    @NotNull
    private Integer signId;

    /**
     * 类型 0-未定义 1-验证码 2-营销类 3-提醒类
     */
    @NotNull
    private Byte type;

    /**
     * 短信模板内容
     */
    @NotBlank
    private String content;

    @Override
    public void createHeader() {
        super.createHeader();
        header.setAction(HjAction.AO_SMS_TEMPLATE_TEMPLATE_MANAGER_TEMPLATE_ADD);
    }
}
