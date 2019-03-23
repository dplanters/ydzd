package com.gndc.core.api.admin.operation;

import com.gndc.core.api.common.RequestMessage;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
public class AOBannerModifyRequest extends RequestMessage {

    @NotNull
    @Min(1)
    private Integer id;

    /**
     * 链接地址
     */
    @NotNull
    @NotBlank
    private String link;

    /**
     * 图片地址
     */
    @NotNull
    @NotBlank
    private String imgUrl;

    /**
     * 开始时间
     */
    @NotNull
    private Date beginTime;

    /**
     * 结束时间
     */
    @NotNull
    private Date endTime;

}
