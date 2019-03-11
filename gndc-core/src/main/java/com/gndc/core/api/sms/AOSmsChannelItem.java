package com.gndc.core.api.sms;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class AOSmsChannelItem implements Serializable {

    /**
     * 通道id
     */
    private Integer id;

    /**
     * 短信通道名称
     */
    private String name;

}
