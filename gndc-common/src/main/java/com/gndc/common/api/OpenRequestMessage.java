package com.gndc.common.api;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author <a href="jingkaihui@adpanshi.com">jingkaihui</a>
 * @Description
 * @date 2019/4/13
 */
@Getter
@Setter
public class OpenRequestMessage extends RequestMessage {

    /**
     * 机构应用id
     */
    @NotNull
    @Min(1)
    private Integer appId;

    /**
     * 10位长度随机字符串
     */
    @NotBlank
    @Size(min = 10, max = 10)
    private String randomStr;
}
