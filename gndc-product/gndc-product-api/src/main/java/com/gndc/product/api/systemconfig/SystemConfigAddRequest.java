package com.gndc.product.api.systemconfig;

import com.gndc.common.api.RequestMessage;
import lombok.Data;

@Data
public class SystemConfigAddRequest extends RequestMessage {

    /**
     * 配置项key
     */
    private String key;
    /**
     * 配置项value
     */
    private String value;

    private Integer productId;

}