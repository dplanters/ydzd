package com.gndc.open.api;

import com.gndc.common.api.OpenRequest;
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
public class OpenDemoRequest extends OpenRequest {

    @NotBlank
    private String name;

}