/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.admin.service.settlement.impl;

import com.gndc.admin.service.settlement.SettlementService;
import com.gndc.common.api.admin.settlement.SettlementRecordInfoRequest;
import com.gndc.common.dto.SettlementRecordInfoDTO;
import com.gndc.common.mapper.SettlementMapper;
import com.gndc.common.model.Settlement;
import com.gndc.common.service.impl.BaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author <a href="liujun8852@adpanshi.com">liujun</a>
 * @version V1.0.1
 * @Description
 * @date 2019/5/5  11:26
 */
@Slf4j
@Service
public class SettlementServiceImpl extends BaseServiceImpl<Settlement,Integer> implements SettlementService {

    @Autowired
    private SettlementMapper settlementMapper;

    @Override
    public List<Settlement> sumFeeByCreateTimeGroupSettlementMode(String time) {
        return settlementMapper.sumFeeByCreateTimeGroupSettlementMode(time);
    }

    @Override
    public Integer countByCreateTime(String time) {
        return settlementMapper.countByCreateTime(time);
    }

    @Override
    public List<SettlementRecordInfoDTO> selectRecordInfoPage(SettlementRecordInfoRequest param) {
        return settlementMapper.selectRecordInfoPage(param);
    }
}
