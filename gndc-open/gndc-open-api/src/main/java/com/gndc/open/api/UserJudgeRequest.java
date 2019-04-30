package com.gndc.open.api;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author <a href="jingkaihui@adpanshi.com">jingkaihui</a>
 * @Description
 * @date 2019/4/29
 */
@Getter
@Setter
public class UserJudgeRequest implements Serializable {

    @NotNull
    @Min(1)
    private Integer partnerId;

    @NotBlank
    private String idCard;

    @NotBlank
    private String phone;

    @NotNull
    private Integer productNo;
}
