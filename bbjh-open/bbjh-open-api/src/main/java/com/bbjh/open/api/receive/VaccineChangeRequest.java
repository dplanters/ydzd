package com.bbjh.open.api.receive;

import com.bbjh.open.api.common.CommonRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author <a href="jingkaihui@adpanshi.com">jingkaihui</a>
 * @Description 审批确认请求
 * @date 2019/5/7
 */
@Getter
@Setter
@Accessors(chain = true)
@ApiModel(description = "用于贷超请求机构的审批确认接口", parent = CommonRequest.class)
public class VaccineChangeRequest extends CommonRequest {
    /**
     * 用户id
     */
    @NotNull
    @ApiModelProperty(value = "用户id", required = true, example = "1321354631465")
    private String uid;

}
