package com.gndc.common.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Getter
@Setter
@Accessors(chain = true)
public class PUserLoginInfoDTO implements Serializable {

    /**
     * 用户id
     */
    private Integer id;

}
