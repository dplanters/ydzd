package com.gndc.core.api.admin.sms;

import com.gndc.core.api.common.RequestMessage;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

@Getter
@Setter
public class AOSmsSignEditRequest extends RequestMessage {

    /**
     * 签名id
     */
    private Integer signId;
    /**
     * 签名名称
     */
    private String name;

    /**
     * 通道id
     */
    private String channelId;

    /**
     * 通道name
     */
    private String channelName;

    /**
     * 状态id状态 1正常 -1删除
     */
    private Byte status;
}
