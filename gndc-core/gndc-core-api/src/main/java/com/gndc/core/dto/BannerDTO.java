package com.gndc.core.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author <a href="jingkaihui@adpanshi.com">jingkaihui</a>
 * @Description
 * @date 2019/4/23
 */
@Getter
@Setter
public class BannerDTO implements Serializable {

    @NotNull
    private Integer id;

    @NotNull
    private Integer position;
}
