package com.gndc.core.service.sys.impl;

import cn.hutool.core.collection.CollUtil;
import com.gndc.common.service.impl.BaseServiceImpl;
import com.gndc.core.mapper.simple.RightMapper;
import com.gndc.core.model.Right;
import com.gndc.core.service.sys.RightService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.weekend.Weekend;

import java.util.ArrayList;
import java.util.List;

@Service
public class RightServiceImpl extends BaseServiceImpl<Right, Integer> implements RightService {

    private static final Logger logger = LoggerFactory.getLogger(RightServiceImpl.class);

    @Autowired
    private RightMapper rightMapper;

    @Override
    public List<Right> rightsTree(Byte rightLevel, Byte platform, Integer superId, List<Integer> rightIds) {
        if (CollUtil.isEmpty(rightIds)) {
            rightIds = new ArrayList<>();
        }
        Weekend<Right> weekend1 = Weekend.of(Right.class);
        weekend1.weekendCriteria()
                .andEqualTo(Right::getPlatform, platform)
                .andEqualTo(Right::getSuperId, 0);
        Right rootRight = rightMapper.selectOneByExample(weekend1);
        //添加对应机构的根权限
        rightIds.add(rootRight.getId());

        Weekend<Right> weekend = Weekend.of(Right.class);
        weekend.orderBy("rightOrder");
        weekend.weekendCriteria()
                .andEqualTo(Right::getPlatform, platform)
                .andEqualTo(Right::getSuperId, superId)
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

    @Override
    public List<Integer> rightIds() {
        List<Right> rights = rightMapper.selectAll();
        List<Integer> rightIds = new ArrayList<>(rights.size());
        rights.forEach(r -> {
            rightIds.add(r.getId());
        });
        return rightIds;
    }
}
