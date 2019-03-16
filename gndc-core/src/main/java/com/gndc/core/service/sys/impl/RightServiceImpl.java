package com.gndc.core.service.sys.impl;

import com.alibaba.druid.sql.visitor.functions.If;
import com.gndc.common.service.impl.BaseServiceImpl;
import com.gndc.core.mapper.simple.RightMapper;
import com.gndc.core.mapper.simple.RoleMapper;
import com.gndc.core.model.Right;
import com.gndc.core.service.sys.RightService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.weekend.Weekend;

import java.util.List;

@Service
public class RightServiceImpl extends BaseServiceImpl<Right, Integer> implements RightService {

    private static final Logger logger = LoggerFactory.getLogger(RightServiceImpl.class);

    @Autowired
    private RightMapper rightMapper;

    @Override
    public List<Right> rightsTree(Byte rightLevel, Byte platform, Integer superId, List<Integer> rightIds) {
        Weekend<Right> weekend = Weekend.of(Right.class);
        weekend.orderBy("rightOrder");
        rightIds.add(0);
        weekend.weekendCriteria()
                .andEqualTo(Right::getPlatform, platform)
                .andEqualTo(Right::getSupperId, superId)
                .andIn(Right::getId, rightIds);
        List<Right> rights = rightMapper.selectByExample(weekend);
        if (rights != null && rights.size() > 0) {
            rightLevel++;
            for (Right right : rights) {
                List<Right> rightList = rightsTree(rightLevel, platform, right.getId(), rightIds);
                right.setRights(rightList);
            }
            return rights;
        } else {
            return null;
        }
    }
}
