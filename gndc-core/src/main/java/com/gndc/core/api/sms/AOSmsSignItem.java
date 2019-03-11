package com.gndc.core.api.sms;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class AOSmsSignItem implements Serializable {

    /**
     * 签名id
     */
    private Integer id;

    /**
     * 签名名称
     */
    private String name;

}
