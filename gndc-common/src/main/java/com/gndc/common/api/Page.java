package com.gndc.common.api;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author <a href="jingkaihui@adpanshi.com">jingkaihui</a>
 * @Description
 * @date 2019/4/11
 */
@Getter
@Setter
public class Page implements Serializable {

    private Integer pageNum;

    private Integer pageSize;
}
