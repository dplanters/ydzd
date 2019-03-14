package com.gndc.core.service.sys;

import com.gndc.common.service.BaseService;
import com.gndc.core.model.Right;

import java.util.List;

public interface RightService extends BaseService<Right, Integer> {

    /**
     * 获取权限树
     * @return
     */
    List<Right> rightsTree(Byte rightLevel, Byte platform, Integer superId, List<Integer> rightIds);
}
