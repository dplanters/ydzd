package com.gndc.core.api.open;

import com.gndc.common.api.OpenRequestMessage;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * @author <a href="jingkaihui@adpanshi.com">jingkaihui</a>
 * @Description
 * @date 2019/4/11
 */
@Getter
@Setter
public class OpenDemoRequestMessage extends OpenRequestMessage {

    @NotBlank
    private String name;

}