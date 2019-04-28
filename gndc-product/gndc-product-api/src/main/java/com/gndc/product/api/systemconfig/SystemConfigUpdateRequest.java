package com.gndc.product.api.systemconfig;

import com.gndc.common.api.RequestMessage;
import lombok.Data;

@Data
public class SystemConfigUpdateRequest extends RequestMessage {


    private Integer id;
    /**
     * 分组
     */
    private String group;

    /**
     * 配置项key
     */
    private String key;

    /**
     * 配置项value
     */
    private String value;

    /**
     * 备注，描述
     */
    private String remark;

}