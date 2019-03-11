package com.gndc.core.service.simple.impl;

import com.gndc.common.service.impl.BaseServiceImpl;
import com.gndc.core.service.simple.DemoService;
import com.gndc.core.mapper.simple.DemoModelMapper;
import com.gndc.core.model.DemoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author 景凯辉
 * @date 2018/11/9
 * @mail kaihuijing@gmail.com
 */
@Component
@Transactional(rollbackFor = Exception.class)
public class DemoServiceImpl extends BaseServiceImpl<DemoModel, Integer> implements DemoService {

    @Autowired
    private DemoModelMapper demoModelMapper;

}
