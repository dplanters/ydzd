package com.bbjh.open.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author fwb
 * @Description 疫苗库存变化DTO
 * @date 2019/5/27
 */
@Getter
@Setter
@Accessors(chain = true)
public class VaccineChangeDTO implements Serializable {

    /**
     * 用户Id
     */
    private String uid;

    /**
     * redis中存储的key
     */
    private String redisKey;
}
