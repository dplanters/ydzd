package com.gndc.core.mapper.simple;

import com.gndc.common.mybatis.MyMapper;
import com.gndc.core.model.Dictionary;
import com.gndc.core.etc.dictionary.DictionaryExt;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DictionaryMapper extends MyMapper<Dictionary, Integer> {
    /**
     * @mbggenerated 2018-03-20
     */
    List<DictionaryExt> selectByDict(DictionaryExt record);
}