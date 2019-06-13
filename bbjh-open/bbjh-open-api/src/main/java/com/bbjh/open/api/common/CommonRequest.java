package com.bbjh.open.api.common;


import com.bbjh.common.api.RequestMessage;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

/**
 * 通用请求
 */
@Getter
@Setter
@Accessors(chain = true)
@ApiModel(description = "用于开放接口的通用请求", parent = CommonRequest.class)
public class CommonRequest extends RequestMessage {


}
