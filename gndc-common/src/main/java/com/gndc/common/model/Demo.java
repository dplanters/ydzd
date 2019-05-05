package com.gndc.common.model;

import com.alibaba.fastjson.JSONObject;
import com.gndc.common.mybatis.SnowflakeIdGenId;
import com.gndc.common.mybatis.type.JsonTypeHandler;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import tk.mybatis.mapper.annotation.ColumnType;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Accessors(chain = true)
@Table(name = "dc_demo")
public class Demo implements Serializable {
    @Id
    @KeySql(genId = SnowflakeIdGenId.class)
    private Long id;

    @ColumnType(typeHandler = JsonTypeHandler.class)
    private JSONObject extra;

    /**
     * 状态  1：正常；0：删除
     */
    private Byte status;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

}