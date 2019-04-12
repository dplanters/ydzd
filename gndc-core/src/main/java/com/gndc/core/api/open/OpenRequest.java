package com.gndc.core.api.open;

import com.gndc.common.api.RequestMessage;
import lombok.Getter;
import lombok.Setter;

/**
 * @author <a href="jingkaihui@adpanshi.com">jingkaihui</a>
 * @Description
 * @date 2019/4/11
 */
@Getter
@Setter
public class OpenRequest extends RequestMessage {

    private Integer appId;

    private Integer partnerId;

    private String name;

    private String randomStr;
}
