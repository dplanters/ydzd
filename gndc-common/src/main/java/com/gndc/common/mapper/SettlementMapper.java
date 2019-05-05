package com.gndc.common.mapper;

import com.gndc.common.api.admin.settlement.SettlementRecordInfoRequest;
import com.gndc.common.dto.SettlementRecordInfoDTO;
import com.gndc.common.model.Settlement;
import com.gndc.common.mybatis.MyMapper;

import java.util.List;

public interface SettlementMapper extends MyMapper<Settlement,Integer> {


    /**
     * @Description
     * @param time yyyy-MM 格式
     * @author <a href="liujun8852@adpanshi.com">liujun</a>
     */
    List<Settlement> sumFeeByCreateTimeGroupSettlementMode(String time);

    /**
     * @Description
     * @param time yyyy-MM 格式
     * @author <a href="liujun8852@adpanshi.com">liujun</a>
     */
    Integer countByCreateTime(String time);

    /**
     * @Description
     * @param param
     * @author <a href="liujun8852@adpanshi.com">liujun</a>
     */
    List<SettlementRecordInfoDTO> selectRecordInfoPage(SettlementRecordInfoRequest param);

}